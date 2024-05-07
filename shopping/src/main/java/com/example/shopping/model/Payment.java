package com.example.shopping.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

//import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

//import jakarta.persistence.OneToOne;

@Entity
public class Payment {
    @Id
    private int productId;
    public Payment(int productId, String accountName, String accountNumber, String productPrice, String productCount,
            Payment payment) {
        this.productId = productId;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.productPrice = productPrice;
        this.productCount = productCount;

    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    
    private String accountName;
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    private String accountNumber;
    public String getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
    private String productPrice;
    public String getProductCount() {
        return productCount;
    }
    public void setProductCount(String productCount) {
        this.productCount = productCount;
    }
    private String productCount;
    public Payment()
    {

    }
    @OneToOne
    @JsonBackReference
    private Product product;
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
}