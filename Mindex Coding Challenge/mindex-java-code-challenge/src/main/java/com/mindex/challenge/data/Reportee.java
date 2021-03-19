package com.mindex.challenge.data;

import java.util.List;
import java.util.Map;
/* Author: Shaivya Chandra
 *  Purpose: Reportee Model for structure
 * @params: employeeId,reportee and numberofreportee
 * */
public class Reportee {
    private String employeeId;
    private String reportee;
    private Integer numberofreportee;

    public Reportee(String employeeId, String reportee, Integer numberofreportee) {
        this.employeeId = employeeId;
        this.reportee = reportee;
        this.numberofreportee = numberofreportee;
    }
    //toString for print structure
    @Override
    public String toString() {
        return "Reportee{" +
                "employeeId='" + employeeId + '\'' +
                ", reportee=" + reportee +
                ", numberofreportee=" + numberofreportee +
                '}';
    }


    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getReportee() {
        return reportee;
    }

    public void setReportee(String reportee) {
        this.reportee = reportee;
    }

    public Integer getNumberofreportee() {
        return numberofreportee;
    }

    public void setNumberofreportee(Integer numberofreportee) {
        this.numberofreportee = numberofreportee;
    }
}
