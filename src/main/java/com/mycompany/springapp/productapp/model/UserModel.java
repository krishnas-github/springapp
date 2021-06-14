package com.mycompany.springapp.productapp.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name ="USER_TABLE")
public class UserModel  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="USER_ID")
    private Long id;
    @Column(name ="USER_NAME")
    private String name;
    @Column(name ="USER_EMAIL")
    private String email;
    @Column(name ="USER_PASSWORD")
    private String password;
    @Column(name="USER_PHONE_NUMBER")
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.ALL)//Any operation that happens to user will automatically reflect to the corresponding rows to the address table.
    // For Example if we delete a user, its corresponding address will also be deleted
    @JoinColumn(name ="ADDRESS_ID")
    private AddressModel address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }
}


