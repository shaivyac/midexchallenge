package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.Reportee;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class EmployeeController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee create(@RequestBody Employee employee) {
        LOG.debug("Received employee create request for [{}]", employee);

        return employeeService.create(employee);
    }


    @GetMapping("/employee/{id}")
    public Employee read(@PathVariable String id) {
        LOG.debug("Received employee create request for id [{}]", id);
        System.out.println("Getting the employee");
        return employeeService.read(id);
    }
    @PutMapping("/employee/{id}")
    public Employee update(@PathVariable String id, @RequestBody Employee employee) {
        LOG.debug("Received employee create request for id [{}] and employee [{}]", id, employee);

        employee.setEmployeeId(id);
        return employeeService.update(employee);
    }


    /*
    Function to get the reportee structure and count the number of reportees
    Employee Id 16a596ae-edd3-4847-99fe-c4518e82c86f
    Reporting Structure:
    John Lennon
            Ringo Starr
                    George Harrison
                    Pete Best
            Paul McCartney

    No of Reportees: 4
    return: reportee model
*/
    @GetMapping("/employee/reportee/{id}")
    public Reportee reportee(@PathVariable String id) {

        LOG.debug("Received employee create request for id [{}]", id);

        Employee manager = employeeService.read(id);
        Stack<Employee> stack = new Stack<Employee>();
        //Map to save the reportees
        Map<String, List<String>> reportee = new LinkedHashMap<>();
        //stack for getting the level number and printing the structure
        Stack<Integer> levelstack = new Stack<Integer>();
        stack.push(manager);
        levelstack.push(0);
        int count = 0;
        String structure = "";
        int levels=0;
        while (stack.size() > 0) {
            Employee current = stack.pop();
            int level= levelstack.pop();
            String tabs = "";
            List<String> emplist = new LinkedList<>();
            reportee.put(current.getEmployeeId(), emplist);
            String name = current.getFirstName() + " " + current.getLastName();
            for(int tabcounter =0;tabcounter<level;tabcounter++)
                tabs=tabs+"\t";
            structure = structure+tabs+name+"\n";
            if (current.getDirectReports() != null) {
                levels++;

                for (Employee emp : current.getDirectReports()) {
                    Employee employees = employeeService.read(emp.getEmployeeId());
                    stack.push(employees);
                    levelstack.push(levels);
                    reportee.get(current.getEmployeeId()).add(emp.getEmployeeId());
                    count++;
                }
            }


        }

        System.out.println("Employee Id: "+manager.getEmployeeId());
        System.out.println("Reporting Structure: \n"+structure);
        System.out.println("No of Reportees: "+count);
        Reportee reportees = new Reportee(manager.getEmployeeId(), structure, count);
        return reportees;
    }
    /*
    * Function to save a compensation
    * return: compensation model*/

    @PostMapping("/compensation")
    public Compensation create(@RequestBody Compensation compensation) {
        LOG.debug("Received compensation create request for [{}]", compensation);

        return employeeService.createcompensation(compensation);


    }
    /*
     * Function to read a compensation
     * return: compenstion*/

    @GetMapping("/compensation/{id}")
    public Compensation readcompensation(@PathVariable String id) {
        LOG.debug("Received compensation read request for id [{}]", id);

        return employeeService.readcompensation(id);
    }



}
