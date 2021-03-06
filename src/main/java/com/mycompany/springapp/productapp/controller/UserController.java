package com.mycompany.springapp.productapp.controller;

import com.mycompany.springapp.productapp.exception.BusinessException;
import com.mycompany.springapp.productapp.model.UserModel;
import com.mycompany.springapp.productapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.objenesis.SpringObjenesis;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService us;

    @PostMapping(path ="/users")
    public ResponseEntity<String> login(@RequestBody UserModel userModel){
        Long response = us.login(userModel);
        ResponseEntity<String> res;
        if (response==0L){
             res = new ResponseEntity<String>("Incorrect email/password", HttpStatus.UNAUTHORIZED);
        }
        else{
            res = new ResponseEntity<String>("OK",HttpStatus.OK);
        }
        return res;
    }
    @PostMapping(path ="/users/register")
    public ResponseEntity<?> register(@RequestBody UserModel userModel) throws BusinessException {
        ResponseEntity<?> res = null;
        userModel = us.register(userModel);
        /*try {
            userModel = us.register(userModel);
        }
        catch (BusinessException be){
            res = new ResponseEntity<>(be.getErrorCode()+"-"+be.getErrorMessage(),HttpStatus.CONFLICT);
            return res;
        }*/
        res = new ResponseEntity<>(userModel, HttpStatus.CREATED);
        System.out.println("User created");
        return res;
    }


}
