package com.mycompany.springapp.productapp.service;

import com.mycompany.springapp.productapp.exception.BusinessException;
import com.mycompany.springapp.productapp.model.CategoryModel;
import com.mycompany.springapp.productapp.model.ProductModel;
import com.mycompany.springapp.productapp.repository.CategoryRepository;
import com.mycompany.springapp.productapp.repository.ProductCrudRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductCrudRepository productCrudRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Test
    public void test_createProduct_exception(){
        ProductModel productModel = new ProductModel();
        productModel.setId(1);
        productModel.setPrice(450);
        productModel.setDescription("phone");
        List<ProductModel> pm = new ArrayList<>();
        pm.add(productModel);

        Mockito.when(productCrudRepository.findByDescription(productModel.getDescription())).thenReturn(Optional.of(pm));
        Assertions.assertThrows(BusinessException.class,()->{
            productService.createProduct(productModel);
        });
    }

    @Test
    public void test_createProduct() throws BusinessException {
        ProductModel productModel = new ProductModel();
        CategoryModel cm = new CategoryModel();
        cm.setCategory_Id(1L);
        productModel.setCategoryModel(cm);
        productModel.setId(1);
        productModel.setPrice(450);
        productModel.setDescription("phone");
        List<ProductModel> pm = new ArrayList<>();
        pm.add(productModel);

        Mockito.when(productCrudRepository.findByDescription(productModel.getDescription())).thenReturn(Optional.empty());
        Mockito.when(categoryRepository.findById(pm.get(0).getCategoryModel().getCategory_Id())).thenReturn(Optional.of(cm));
        Mockito.when(productCrudRepository.save(productModel)).thenReturn(productModel);
        ProductModel product = productService.createProduct(productModel);
        Assertions.assertEquals(productModel.getId(),product.getId());

    }

}
