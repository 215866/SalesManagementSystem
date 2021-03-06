package com.zpi.salesmanagementsystem.models;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double basePrice;

    private double preferredSalePrice;

    @ManyToOne
    @JoinColumn(name="CATEGORY_ID")
    private Category category;

    public Product(){}

    public Product(String name, double basePrice, Category category){
        this.name = name;
        this.basePrice = basePrice;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPreferredSalePrice() {
        return preferredSalePrice;
    }

    public void setPreferredSalePrice(double preferredSalePrice) {
        this.preferredSalePrice = preferredSalePrice;
    }
}
