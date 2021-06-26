package com.mycompany.springapp.productapp.service;

import com.mycompany.springapp.productapp.model.CategoryModel;
import com.mycompany.springapp.productapp.repository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest  {
    
    @InjectMocks//Create a singleton dummy object for category service. With the help og injectmocks
    // we can use the junit testing for the function/method which are dependent to other layer
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @Test
    public void test_CreateCategory(){
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setCategoryName("Food");
        CategoryModel categoryModel2 = new CategoryModel();
        categoryModel2.setCategory_Id(1L);
        categoryModel2.setCategoryName("Food");

        Mockito.when(categoryRepository.save(categoryModel)).thenReturn(categoryModel2);
        CategoryModel categoryModel1 = categoryService.createCategory(categoryModel);
        Assertions.assertNotNull(categoryModel1.getCategory_Id(),"Test failed because category should have an id");

    }

    @Test
    public void test_getAllCategory_With_0_Size(){
        List<CategoryModel> categories =(List<CategoryModel>) categoryService.getAllCategory();
        Assertions.assertEquals(categories.size(),0);

    }

    @Test
    public void test_getAllCategory_With_non_zero_size(){
        CategoryModel cm = new CategoryModel();
        cm.setCategory_Id(1L);
        cm.setCategoryName("Food");

        List<CategoryModel> listOfCategory = new ArrayList<>();
        listOfCategory.add(cm);

        Mockito.when(categoryRepository.findAll()).thenReturn(listOfCategory);

        List<CategoryModel> categories =(List<CategoryModel>) categoryService.getAllCategory();
        Assertions.assertEquals(categories.size(),1);

    }
}
