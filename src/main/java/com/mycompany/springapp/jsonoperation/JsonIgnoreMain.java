package com.mycompany.springapp.jsonoperation;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonIgnoreMain {
    public static void main(String[] args){
        ObjectMapper mapper = new ObjectMapper();
        try{
            EmployeeModel employeeModel = new EmployeeModel();
            employeeModel.setEmpId1(111);
            employeeModel.setName("John Doe");
            //employeeModel.setPhone(998899L);
            //employeeModel.setPassword("mysecret");
            //Converted java object to Json object
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeeModel);
            System.out.println("Json version of object is");
            System.out.println(jsonString);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
