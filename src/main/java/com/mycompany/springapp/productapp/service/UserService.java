package com.mycompany.springapp.productapp.service;

import com.mycompany.springapp.productapp.exception.BusinessException;
import com.mycompany.springapp.productapp.model.UserModel;
import com.mycompany.springapp.productapp.repository.UserCrudRepository;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {

    @Autowired
    private UserCrudRepository ucr;
    public Long login(UserModel userModel){
        Optional<UserModel> optionalUserModel = ucr.findByEmailAndPassword(userModel.getEmail(), userModel.getPassword());
        if(optionalUserModel.isPresent()){
            return optionalUserModel.get().getId();
        }
        return 0L;
    }

    public UserModel register(UserModel userModel) throws BusinessException {
        Optional<UserModel> optionalPhoneNumber = ucr.findByPhoneNumber(userModel.getPhoneNumber());
        if(optionalPhoneNumber.isPresent()){
            BusinessException be = new BusinessException("Auth_001","User with this phoneNumber already exist, please try with another phoneNumber");
            throw be;
        }
        else{
            userModel = ucr.save(userModel);
        }
        return userModel;
    }
}
