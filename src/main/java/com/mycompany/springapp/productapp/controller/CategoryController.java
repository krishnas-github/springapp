package com.mycompany.springapp.productapp.controller;

import com.mycompany.springapp.productapp.model.CategoryModel;
import com.mycompany.springapp.productapp.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService cs;
    @GetMapping(value = "/categoryList")
    public ResponseEntity<Iterable<CategoryModel>> getAllCategory(){
        Iterable<CategoryModel> list = cs.getAllCategory();
        return (new ResponseEntity<Iterable<CategoryModel>>(list, HttpStatus.OK));
    }

    @ApiOperation(value = "createCategory",
                    notes = "This method create a new category")
    @PostMapping(value = "/category")
    public ResponseEntity<CategoryModel> createCategory(@ApiParam(name ="category",
                                                type = "categoryModel",
                                                value = "category data",
                                                example = "categoryId,categoryName",
                                                required = true) @RequestBody CategoryModel categoryModel){
        categoryModel = cs.createCategory(categoryModel);
        ResponseEntity<CategoryModel> res = new ResponseEntity<CategoryModel>(categoryModel,HttpStatus.CREATED);
        return res;
    }
    @DeleteMapping(value = "/category/{id}")
    public ResponseEntity<CategoryModel> deleteCategory(@PathVariable("id") long id){
        CategoryModel categoryModel = cs.deleteCategory(id);
        ResponseEntity<CategoryModel> res = new ResponseEntity<CategoryModel>(categoryModel,HttpStatus.OK);
        return res;
    }
    @GetMapping (value = "/category/search")
    public ResponseEntity<List<CategoryModel>> searchCategory(@RequestParam("categoryName") String categoryName){
        List<CategoryModel> categoryModel = cs.searchCategory(categoryName);
        ResponseEntity<List<CategoryModel>> res = new ResponseEntity<List<CategoryModel>>(categoryModel,HttpStatus.OK);
        return res;
    }
    @PutMapping(value = "/category/{id}")
    public ResponseEntity<CategoryModel> updateCategory(@PathVariable("id") long id,@RequestBody CategoryModel categoryModel){
        categoryModel = cs.updateCategory(id,categoryModel);
        ResponseEntity<CategoryModel> res = new ResponseEntity<CategoryModel>(categoryModel,HttpStatus.OK);
        return res;
    }



}
