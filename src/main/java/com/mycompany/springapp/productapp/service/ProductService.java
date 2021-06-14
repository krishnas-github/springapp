package com.mycompany.springapp.productapp.service;

import com.mycompany.springapp.productapp.model.CategoryModel;
import com.mycompany.springapp.productapp.model.ProductModel;
import com.mycompany.springapp.productapp.repository.CategoryRepository;
import com.mycompany.springapp.productapp.repository.ProductCrudRepository;
import com.mycompany.springapp.productapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository pr;
    @Autowired
    private ProductCrudRepository pcr;
    @Autowired
    private CategoryRepository cr;

    //public List<ProductModel> getAllProducts(){
    public Iterable<ProductModel> getAllProducts(){
        //List<ProductModel> productModelList =pr.getAllProducts();
        Iterable<ProductModel> productModelList = pcr.findAll();
        return productModelList;
    }
    public ProductModel createProduct(ProductModel productModel){
        //productModel = pr.createProduct(productModel);
        Optional<CategoryModel> optCategory = cr.findById(productModel.getCategoryModel().getCategory_Id());
        productModel.setCategoryModel(optCategory.get());
        productModel = pcr.save(productModel);
        return productModel;
    }
    public ProductModel deleteProduct(long id){
        ProductModel productModel =null;
        //ProductModel productModel = pr.deleteProduct(id);
        Optional<ProductModel> optProduct = pcr.findById(id);
        if(optProduct.isPresent()){
            ProductModel product = optProduct.get();
            productModel = product;
            pcr.delete(product);
        }
        else{
            System.out.println("No Matching Product found");
        }

        return productModel;
    }
    public List<ProductModel> searchProductByDescription(String description){
        List<ProductModel> productModel2 = null;
        Optional<ProductModel> searchproduct = pcr.findByDescription(description);
        if(searchproduct.isPresent()){
            ProductModel product1 = searchproduct.get();
            productModel2 = (List<ProductModel>) product1;
        }
        return productModel2;
        //List<ProductModel> productList = pr.searchProductByDescription(description);
        //return productList;
    }
    public ProductModel updateProduct(long id, ProductModel productModel) {
        //productModel = pr.updateProduct(id, productModel);
        //return productModel;
        ProductModel productModel1 =null;
        //ProductModel productModel = pr.deleteProduct(id);
        Optional<ProductModel> optProduct = pcr.findById(id);
        if(optProduct.isPresent()){
            ProductModel product = optProduct.get();
            if(null!=productModel.getDescription()){
                product.setDescription(productModel.getDescription());
            }
            if(productModel.getPrice()!=0){
                product.setPrice(productModel.getPrice());
            }
            //product.setDescription(productModel.getDescription());
            //product.setPrice(productModel.getPrice());
            productModel1 = product;
            pcr.save(product);
        }
        else{
            System.out.println("No Matching Product found");
        }
        return productModel1;
    }
}
