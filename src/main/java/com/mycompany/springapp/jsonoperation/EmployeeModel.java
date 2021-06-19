package com.mycompany.springapp.jsonoperation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeModel {
    @JsonProperty("empId")
    private Integer empId1;
    private String name;
    //@JsonIgnore
    private Long phone;
    //@JsonIgnore
    private String password;

    public Integer getEmpId1() {
        return empId1;
    }

    public void setEmpId1(Integer empId1) {
        this.empId1 = empId1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
