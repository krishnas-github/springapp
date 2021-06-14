package com.mycompany.springapp.productapp.repository;

import com.mycompany.springapp.productapp.model.ProductModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    List<ProductModel> productList = new ArrayList<>();
    public ProductModel createProduct(ProductModel productModel){
        this.productList.add(productModel);
        return productModel;
    }
    public ProductModel deleteProduct(long id){
        ProductModel productModel = null;
        for(int i=0; i<productList.size();i++){
            productModel = productList.get(i);
            if(productList.get(i).getId() == id){
                productList.remove(i);
                break;
            }
        }
        return productModel;
    }
    public List<ProductModel> searchProductByDescription(String description){
        ProductModel pm = null;
        List<ProductModel> listOfProducts = new ArrayList<>();
        for(int i=0;i<this.productList.size();i++){
            pm = this.productList.get(i);
            if(pm.getDescription().contains(description)){
                listOfProducts.add(pm);
            }
        }
        return listOfProducts;
    }
    public ProductModel updateProduct(long id,ProductModel productModel){
        ProductModel pm = null;
        for(int i=0;i<productList.size();i++){
            pm = productList.get(i);
            if(pm.getId() ==id){
                pm.setDescription(productModel.getDescription());
                pm.setPrice(productModel.getPrice());
                this.productList.set(i,pm);
                break;
            }
        }
        return pm;
    }

    public List<ProductModel> getAllProducts(){
      /*  ProductModel pm = new ProductModel();
        pm.setId(1);
        pm.setDescription("Laptop");
        pm.setPrice(35000);
        productList.add(pm);

        pm =new ProductModel();
        pm.setId(2);
        pm.setDescription("Sampoo");
        pm.setPrice(35);
        productList.add(pm);

        pm =new ProductModel();
        pm.setId(3);
        pm.setDescription("Phone");
        pm.setPrice(25000);
        productList.add(pm);*/

        return productList;
    }
}
