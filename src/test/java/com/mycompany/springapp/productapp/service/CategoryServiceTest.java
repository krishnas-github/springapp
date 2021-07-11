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

    @Test
    public void test_deleteCategory(){
        CategoryModel cm = new CategoryModel();
        cm.setCategory_Id(1l);
        cm.setCategoryName("Food");

        Mockito.when(categoryRepository.findById(cm.getCategory_Id())).thenReturn(java.util.Optional.of(cm));
        Mockito.doNothing().when(categoryRepository).delete(cm);

        CategoryModel categories = (categoryService.deleteCategory(cm.getCategory_Id()));
        Assertions.assertEquals(cm.getCategory_Id(),categories.getCategory_Id(),"Test failed because category should have an id ");

    }
    @Test
    public void test_deleteCategory_categoryNotFound(){
        CategoryModel cm = new CategoryModel();
        cm.setCategory_Id(1l);
        cm.setCategoryName("Food");

        Mockito.when(categoryRepository.findById(cm.getCategory_Id())).thenReturn(java.util.Optional.empty());

        CategoryModel categories = (categoryService.deleteCategory(cm.getCategory_Id()));
        Assertions.assertNull(categories,"Test failed because category not found ");

    }

    @Test
    public void test_updateCategory(){
        CategoryModel cm = new CategoryModel();
        cm.setCategory_Id((1l));
        cm.setCategoryName("Cosmetics");

        CategoryModel cm1 = new CategoryModel();
        cm1.setCategory_Id((1l));
        cm1.setCategoryName("Food");

        Mockito.when(categoryRepository.findById(cm.getCategory_Id())).thenReturn(java.util.Optional.of(cm));
        Mockito.when(categoryRepository.save(cm)).thenReturn(cm1);
        //Mockito.doNothing().when(categoryRepository).save(cm);
        CategoryModel categories = categoryService.updateCategory(cm.getCategory_Id(),cm1);
        Assertions.assertEquals(cm1.getCategoryName(),categories.getCategoryName(),"Test failed because category should have an id ");
    }

    @Test
    public void test_updateCategory_categoryNotFound(){
        CategoryModel cm = new CategoryModel();
        cm.setCategory_Id((1l));
        cm.setCategoryName("Cosmetics");

        Mockito.when(categoryRepository.findById(cm.getCategory_Id())).thenReturn(java.util.Optional.empty());
        CategoryModel categories = categoryService.updateCategory(cm.getCategory_Id(),cm);
        Assertions.assertNull(categories,"Test failed because category not found ");
    }

    @Test
    public void test_searchCategory(){
        CategoryModel cm = new CategoryModel();
        cm.setCategory_Id(1l);
        cm.setCategoryName("Food");
        List<CategoryModel> listcm = new ArrayList<>();
        listcm.add(cm);
        Mockito.when(categoryRepository.findByCategoryName(cm.getCategoryName())).thenReturn(java.util.Optional.of(listcm));
        List<CategoryModel> categories = categoryService.searchCategory(cm.getCategoryName());
        Assertions.assertEquals(listcm.get(0).getCategoryName(),categories.get(0).getCategoryName(),"Test Failed because category does not match");
    }

}
