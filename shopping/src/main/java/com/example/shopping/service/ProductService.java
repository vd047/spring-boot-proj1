package com.example.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.shopping.model.Product;
import com.example.shopping.repository.ProductRepo;


@Service
public class ProductService {
    @Autowired
    ProductRepo mr;
    public Product create (Product mm)
    {
        return mr.save(mm);
    }
    public List<Product> getAll()
    {
        return mr.findAll();
    }
    public Product getMe(String productName)
    {
        return mr.findById(productName).orElse(null);
    }
    public boolean updateDetails(String productName,Product mm)
        {
            if(this.getMe(productName)==null)
            {
                return false;
            }
            try{
                mr.save(mm);
            }
            catch(Exception e)
            {
                return false;
            }
            return true;
        }
public boolean deleteProduct(String productName)
        {
            if(this.getMe(productName) == null)
            {
                return false;
            }
            mr.deleteById(productName);
            return true;
        }
        public List<Product> sort(String productName) {
            Sort sort = Sort.by(Sort.Direction.ASC, productName);
            return mr.findAll(sort);
        }
        
        //pagination
        public List<Product> page(int pageSize, int pageNumber) {
            Pageable page = PageRequest.of(pageNumber, pageSize);
            return mr.findAll(page).getContent();
        }
        
        //sorting and pagination
        public List<Product> getsort(int pageNumber, int pageSize, String productName) {
            return mr.findAll(PageRequest.of(pageNumber, pageSize)
                    .withSort(Sort.by(Sort.Direction.ASC, productName))).getContent();
        }
        public Product findByproductName(String productName) {
            return mr.findByproductName(productName);
}
}