package com.mycompany.springapp.productapp.service;

import com.mycompany.springapp.productapp.model.CategoryModel;
import com.mycompany.springapp.productapp.repository.CategoryRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository cr;
    public Iterable<CategoryModel> getAllCategory(){
        Iterable<CategoryModel> categoryModelList = cr.findAll();
        return categoryModelList;
    }

    public CategoryModel createCategory(CategoryModel categoryModel){
        categoryModel = cr.save(categoryModel);
        return categoryModel;
    }

    public CategoryModel deleteCategory(long id){
        CategoryModel categoryModel = null;
        Optional<CategoryModel> optCategory = cr.findById(id);
        if(optCategory.isPresent()){
            CategoryModel category = optCategory.get();
            categoryModel =category;
            cr.delete(category);
        }
        else{
            System.out.println("Category id not found");
        }
        return categoryModel;
    }

    public List<CategoryModel> searchCategory(String categoryName) {
        List<CategoryModel> categoryList = null;
        Optional<List<CategoryModel>> optCategoryModelList = cr.findByCategoryName(categoryName);
        if(optCategoryModelList.isPresent()){
            categoryList = optCategoryModelList.get();
        }
        return categoryList;
    }

    public CategoryModel updateCategory(long id, CategoryModel categoryModel){
        CategoryModel categoryModel1 = null;
        Optional<CategoryModel> optCategory = cr.findById(id);
        if(optCategory.isPresent()){
            CategoryModel categoryModel2 = optCategory.get();
            if(null!=categoryModel.getCategoryName()){
                categoryModel2.setCategoryName(categoryModel.getCategoryName());
            }
            categoryModel1 = categoryModel2;
            cr.save(categoryModel2);
        }
        else{
            System.out.println("No Matching category found");
        }
        return categoryModel1;
    }
}
