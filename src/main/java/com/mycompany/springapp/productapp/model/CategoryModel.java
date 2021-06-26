package com.mycompany.springapp.productapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name= "CATEGORY")
public class CategoryModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="CATEGORY_ID")
    private Long category_Id;
    @ApiModelProperty(
            value = "category_name",
            name = "categoryName",
            dataType = "String",
            example ="electronics")
    @Column(name = "CATEGORY_NAME")
    private String categoryName;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoryModel", cascade = CascadeType.ALL)//One category will have many product(Reverse mapping)
    //mappedBy means the category should not create the foreign key of product rather than category table should
    //use the already created foreign key inside product table
    @JsonIgnore
    private List<ProductModel> productModelList;

    public Long getCategory_Id() {
        return category_Id;
    }

    public void setCategory_Id(Long category_Id) {
        this.category_Id = category_Id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<ProductModel> getProductModelList() {
        return productModelList;
    }

    public void setProductModelList(List<ProductModel> productModelList) {
        this.productModelList = productModelList;
    }
}
