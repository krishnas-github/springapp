package com.mycompany.springapp.productapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name ="PRODUCT_TABLE")
public class ProductModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="PRODUCT_ID")
    private long id;
    @Column(name ="PRODUCT_DESCRIPTION")
    private String description;
    @Column(name ="PRODUCT_PRICE")
    private double price;
    @ManyToOne(fetch = FetchType.EAGER)//FetchType.LAZY means don't fetch the child date while fetching the parent data.
    //In this case whenever product will be fetched from database, categoryModel variable will be null
    @JoinColumn(name = "CATEGORY_ID")
    private CategoryModel categoryModel;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CategoryModel getCategoryModel() {
        return categoryModel;
    }

    public void setCategoryModel(CategoryModel categoryModel) {
        this.categoryModel = categoryModel;
    }
}
