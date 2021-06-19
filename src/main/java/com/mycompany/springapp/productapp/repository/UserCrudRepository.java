package com.mycompany.springapp.productapp.repository;

import com.mycompany.springapp.productapp.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCrudRepository extends CrudRepository<UserModel, Long> {

    //@Override
    Optional<UserModel> findByEmailAndPassword(String e, String p);
    //List<UserModel> findBy Email And Address Id In(List<String> emailList);
    Optional<UserModel> findByPhoneNumber(String p);
}
