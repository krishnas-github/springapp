package com.mycompany.springapp.jsonoperation;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonToJavaToJasonMain {
    public static void main(String[] args){
        ObjectMapper mapper = new ObjectMapper();
        try{
            EmployeeModel employeeModel = new EmployeeModel();
            employeeModel.setEmpId1(111);
            employeeModel.setName("John Doe");
            employeeModel.setPhone(998899L);
            employeeModel.setPassword("mysecret");
            //Converted java object to Json object/Serialization
            //String jsonString = mapper.writeValueAsString(employeeModel);
            String jsonString = "{\"deptId\":333,\"empId\":111,\"name\":\"John Doe\",\"phone\":null,\"password\":\"mysecret\"}";
            System.out.println("Json version of object is");
            System.out.println(jsonString);

            //Converted json object to java object;//Deserialization
            EmployeeModel emp = mapper.readValue(jsonString,EmployeeModel.class);
            System.out.println("Employee version of object is");
            System.out.println(emp.getName());

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
