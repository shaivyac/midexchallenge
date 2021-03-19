package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);


    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CompensationRepository compensationRepository;

    @Override
    public Employee create(Employee employee) {
        LOG.debug("Creating employee [{}]", employee);

        employee.setEmployeeId(UUID.randomUUID().toString());
        employeeRepository.insert(employee);

        return employee;
    }

    @Override
    public Employee read(String id) {
        LOG.debug("Creating employee with id [{}]", id);

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        LOG.debug("Updating employee [{}]", employee);

        return employeeRepository.save(employee);
    }

    /*
     * Function to create a compensation
     * throws exception:
     *   if Employee Id doesnot exists or null,
     *   if effective date and salary are null
     * returns compensation
     * */
    @Override
    public Compensation createcompensation(Compensation compensation) {
        LOG.debug("Creating employee [{}]", compensation);
        System.out.println("compe");
        if (compensation.getEmployeeId() == null) {
            throw new RuntimeException("Add the employeeId");
        }
        Employee employee = employeeRepository.findByEmployeeId(compensation.getEmployeeId());

        if (employee == null) {
            throw new RuntimeException("EmployeeId for compensation not found: " + compensation.getEmployeeId());
        }
        if (compensation.getEffectiveDate() == null || compensation.getSalary() == null) {
            throw new RuntimeException("Invalid values " + compensation.getEmployeeId());

        }


        compensationRepository.insert(compensation);

        return compensation;
    }

    /*
     * Function to read a compensation
     * throws exception:
     *   if compensation doesnot exists for employeeid,
     *
     * */
    @Override
    public Compensation readcompensation(String id) {
        Compensation compensation = compensationRepository.findByEmployeeId(id);

        if (compensation == null) {
            throw new RuntimeException("Compensation employeeId not found: " + id);
        }

        return compensation;
    }
}
