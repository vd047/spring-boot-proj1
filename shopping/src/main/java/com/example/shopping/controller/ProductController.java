package com.example.shopping.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.shopping.model.Product;
import com.example.shopping.service.ProductService;
@RestController
public class ProductController {
    @Autowired
    ProductService ms;
    @PostMapping("api/product")
    public ResponseEntity<Product>addelements(@RequestBody Product m)
    {
        Product mm=ms.create(m);
        return new ResponseEntity<>(mm,HttpStatus.CREATED);
    }
    @GetMapping("/api/products")
    public ResponseEntity<List<Product>> showinfo()
    {
        return new ResponseEntity<>(ms.getAll(),HttpStatus.OK);
    }
    @GetMapping("/api/product/{productName}")
    public ResponseEntity<Product> getById(@PathVariable String productName)
    {
        Product obj=ms.getMe(productName);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    @PutMapping("/api/product/{productName}")
    public ResponseEntity<Product> putMethodName(@PathVariable("productName") String productName, @RequestBody Product m) {
        if(ms.updateDetails(productName,m) == true)
        {
            return new ResponseEntity<>(m,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
@DeleteMapping("/api/product/{productName}")
    public ResponseEntity<Boolean> delete(@PathVariable("productName") String productName)
    {
        if(ms.deleteProduct(productName) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
    @GetMapping("/api/product/sortBy/{productName}")
    public List<Product> g(@PathVariable String productName)
    {
        return ms.sort(productName);
    }

     //pagination
     @GetMapping("/api/page/{offset}/{pagesize}")
     public ResponseEntity <List<Product>> get(@PathVariable int offset,@PathVariable int pagesize)
     {
         try{
             return new ResponseEntity<>(ms.page(offset,pagesize),HttpStatus.OK);
          }
          catch(Exception e)
          {
              return new ResponseEntity<>(ms.page(offset,pagesize),HttpStatus.NOT_FOUND);
          }
     }

     
    //sorting and pagination
    @GetMapping("/api/{offset}/{pagesize}/{productName}")
    public ResponseEntity<List<Product>> getsorting(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String productName)
    {
        try{
            return new ResponseEntity<>(ms.getsort(offset,pagesize,productName),HttpStatus.OK);
         }
         catch(Exception e)
         {
             return new ResponseEntity<>(ms.getsort(offset,pagesize,productName),HttpStatus.NOT_FOUND);
         }
    }
    @GetMapping("/query/{productName}")
    public ResponseEntity<Product> findByproductName(@PathVariable String productName) 
    {
        Product sh = ms.findByproductName(productName);
        try{
            return new ResponseEntity<>(sh,HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(sh,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
