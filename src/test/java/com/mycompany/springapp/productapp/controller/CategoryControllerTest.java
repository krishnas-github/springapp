package com.mycompany.springapp.productapp.controller;

import com.mycompany.springapp.productapp.model.CategoryModel;
import com.mycompany.springapp.productapp.service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class CategoryControllerTest {

    @InjectMocks
    private CategoryController categoryController;

    @Mock
    private CategoryService categoryService;

    @Test
    public void test_createCategory_success(){
        CategoryModel cm = new CategoryModel();
        cm.setCategoryName("Food");

        CategoryModel cm1 = new CategoryModel();
        cm1 = new CategoryModel();
        cm1.setCategory_Id(1L);
        cm1.setCategoryName("Food");

        Mockito.when(categoryService.createCategory(cm)).thenReturn(cm1);
        ResponseEntity<CategoryModel> responseEntity = categoryController.createCategory(cm);
        Assertions.assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
        Assertions.assertNotNull(responseEntity.getBody().getCategory_Id());

    }

}
