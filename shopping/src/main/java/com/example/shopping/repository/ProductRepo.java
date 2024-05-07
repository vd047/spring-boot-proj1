package com.example.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.shopping.model.Product;

public interface ProductRepo extends JpaRepository<Product,String>
{
    @Query("SELECT s FROM Product s WHERE s.productName = :productName")
    Product findByproductName(@RequestParam("productName") String productName);
}
