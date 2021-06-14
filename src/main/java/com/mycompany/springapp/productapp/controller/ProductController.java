package com.mycompany.springapp.productapp.controller;

import com.mycompany.springapp.productapp.model.ProductModel;
import com.mycompany.springapp.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Value("${myproperty}")
    String dummyField;

    @Value("${spring.datasource.username}")
    String dbUser;


    @Autowired
    private ProductService ps;
    @GetMapping(value ="/products")
    //public ResponseEntity<List<ProductModel>> getAllProducts() {
    public  ResponseEntity<Iterable<ProductModel>> getAllProducts() {
        System.out.println(dummyField);
        System.out.println(dbUser);

       //List<ProductModel> list =ps.getAllProducts();
        Iterable<ProductModel> list =ps.getAllProducts();
        return (new ResponseEntity<Iterable<ProductModel>>(list, HttpStatus.OK));
    }

    @PostMapping(value = "/products", consumes = {"application/json"}, produces = {"application/json"})
    public  ResponseEntity<ProductModel> createProduct(@RequestBody ProductModel productModel){
        System.out.println("Create Product");
        productModel =ps.createProduct(productModel);
        ResponseEntity<ProductModel> res = new ResponseEntity<ProductModel>(productModel,HttpStatus.CREATED);
        return res;
    }
    @DeleteMapping(value ="/products/{id}")
    public ResponseEntity<ProductModel>  deleteProduct(@PathVariable("id") long id) {
        ProductModel productModel=ps.deleteProduct(id);
        ResponseEntity<ProductModel> res = new ResponseEntity<ProductModel>(productModel,HttpStatus.NO_CONTENT);
        return  res;
    }
    @GetMapping(value ="/products/search")
    public ResponseEntity<List<ProductModel>> searchProductByDescription(@RequestParam("description")
                                                                                     String description){
        List<ProductModel> productList = ps.searchProductByDescription(description);
        ResponseEntity<List<ProductModel>> res = new ResponseEntity<List<ProductModel>>(productList,HttpStatus.OK);
        return res;
    }
    @PutMapping(value ="/products/{id}")
    public ResponseEntity<ProductModel> updateProduct(@PathVariable("id") long id,@RequestBody ProductModel productModel){
        productModel = ps.updateProduct(id,productModel);
        ResponseEntity<ProductModel> res = new ResponseEntity<ProductModel>(productModel,HttpStatus.OK);
        return res;

    }
}
