package com.example.shopping.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Product {
    @Id
    private String productName;
    private int productId;
    private String productCount;
    private String productBrand;
    private String manufactureId;
    private double productPrice;
    private String productRating;
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public String getProductCount() {
        return productCount;
    }
    public void setProductCount(String productCount) {
        this.productCount = productCount;
    }
    public String getProductBrand() {
        return productBrand;
    }
    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }
    public String getManufactureId() {
        return manufactureId;
    }
    public void setManufactureId(String manufactureId) {
        this.manufactureId = manufactureId;
    }
    public double getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    public String getProductRating() {
        return productRating;
    }
    public void setProductRating(String productRating) {
        this.productRating = productRating;
    }
    public Product(String productName,int productId, String productCount, String productBrand, String manufactureId,
            double productPrice, String productRating) {
        
        this.productName = productName;
        this.productId = productId;
        this.productCount = productCount;
        this.productBrand = productBrand;
        this.manufactureId = manufactureId;
        this.productPrice = productPrice;
        this.productRating = productRating;
    }
    public Product() {
    }
    @OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Payment payment;
    public Payment getPayment() {
        return payment;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
