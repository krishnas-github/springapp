package com.mycompany.springapp.productapp.service;

import com.mycompany.springapp.productapp.exception.BusinessException;
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
    public Iterable<ProductModel> getAllProducts() throws BusinessException {
        //List<ProductModel> productModelList =pr.getAllProducts();
        Iterable<ProductModel> productModelList = pcr.findAll();
        if(null!=productModelList){
            return productModelList;
        }
        else{
            BusinessException pce = new BusinessException("The product list is empty","Nothing to display");
            throw pce;
        }
    }
    public ProductModel createProduct(ProductModel productModel) throws BusinessException {
        //productModel = pr.createProduct(productModel);
        Optional<List<ProductModel>> product = pcr.findByDescription(productModel.getDescription());
        if(product.isPresent()){
            BusinessException pce = new BusinessException("This product already exist","Cannot create this product");
            throw pce;
        }
        Optional<CategoryModel> optCategory = cr.findById(productModel.getCategoryModel().getCategory_Id());
        productModel.setCategoryModel(optCategory.get());
        productModel = pcr.save(productModel);
        return productModel;
    }
    public ProductModel deleteProduct(long id) throws BusinessException{
        ProductModel productModel =null;
        //ProductModel productModel = pr.deleteProduct(id);
        Optional<ProductModel> optProduct = pcr.findById(id);
        if(optProduct.isPresent()){
            ProductModel product = optProduct.get();
            productModel = product;
            pcr.delete(product);
        }
        else{
            BusinessException pce = new BusinessException("This product is not present","Cannot delete");
            throw pce;
        }
        /*else{
            System.out.println("No Matching Product found");
        }*/

        return productModel;
    }
    public List<ProductModel> searchProductByDescription(String description) throws BusinessException{
        List<ProductModel> productModel2 = null;
        Optional<List<ProductModel>> searchProduct = pcr.findByDescription(description);
        if(searchProduct.isPresent()){
            productModel2 = searchProduct.get();
            //ProductModel product1 = searchProduct.get();
            //productModel2 = (List<ProductModel>) product1;
            return productModel2;
        }
        else{
            BusinessException pce = new BusinessException("No such product is present","Please check the spelling");
            throw pce;
        }

        //List<ProductModel> productList = pr.searchProductByDescription(description);
        //return productList;
    }
    public ProductModel updateProduct(long id, ProductModel productModel) throws BusinessException {
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
            BusinessException pce = new BusinessException("No Matching Product found","Please check the spelling");
            throw pce;
        }
        return productModel1;
    }
}
