package com.mindex.challenge.data;

import java.util.Date;
/* Author: Shaivya Chandra
 *  Purpose: Compensation Model for Compensation Structure
 * @params: employeeId,effectiveDtae and Salary
 *
 * */
public class Compensation {
    private String employeeId;
    private Date effectiveDate;
    private Long salary;
    //Adding a paramterized constructor
    public Compensation(String employeeId, Date effectiveDate, Long salary) {
        this.employeeId = employeeId;
        this.effectiveDate = effectiveDate;
        this.salary = salary;
    }
    //Adding constructor
    public Compensation() {
    }
    //Adding Getter and Setter
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
    //Adding toString for a structured print statement
    @Override
    public String toString() {
        return "Compensation{" +
                "employeeId='" + employeeId + '\'' +
                ", effictiveDate=" + effectiveDate +
                ", salary=" + salary +
                '}';
    }
}
