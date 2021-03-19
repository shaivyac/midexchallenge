package com.mindex.challenge;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

@Component
public class DataBootstrap {
    private static final String DATASTORE_LOCATION = "/static/employee_database.json";
    private static final String Compensation_DATASTORE_LOCATION = "/static/compensation_database.json";


    @Autowired
    private EmployeeRepository employeeRepository;
    //Adding the autowired CompensationRepository
    @Autowired
    private CompensationRepository compensationRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public DataBootstrap() {
    }

    @PostConstruct
    public void init() {
        InputStream inputStream = this.getClass().getResourceAsStream(DATASTORE_LOCATION);
        //adding inputstream for Compensation Datastorage
        InputStream compinputStream = this.getClass().getResourceAsStream(Compensation_DATASTORE_LOCATION);


        Employee[] employees = null;
        //Getting the list of compensation
        Compensation[] compensations = null;

        try {
            employees = objectMapper.readValue(inputStream, Employee[].class);
            //read a compensation
            compensations = objectMapper.readValue(compinputStream, Compensation[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Employee employee : employees) {
            employeeRepository.insert(employee);
        }
        //Insert a compensation
        for (Compensation compensation : compensations) {
             compensationRepository.insert(compensation);
        }
    }
}
