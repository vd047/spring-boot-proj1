
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

import com.example.shopping.model.Payment;

import com.example.shopping.service.PaymentService;

@RestController
public class PaymentController {
    @Autowired
    PaymentService ms;
    @PostMapping("api/payment")
    public ResponseEntity<Payment>addelements(@RequestBody Payment m)
    {
        Payment mm=ms.create(m);
        return new ResponseEntity<>(mm,HttpStatus.CREATED);
    }
    @GetMapping("/api/payments")
    public ResponseEntity<List<Payment>> showinfo()
    {
        return new ResponseEntity<>(ms.getAll(),HttpStatus.OK);
    }
    @GetMapping("/api/payment/{productId}")
    public ResponseEntity<Payment> getById(@PathVariable Integer productId)
    {
        Payment obj=ms.getMe(productId);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    @PutMapping("/api/payment/{productId}")
    public ResponseEntity<Payment> putMethodName(@PathVariable("productId") int id, @RequestBody Payment m) {
        if(ms.updateDetails(id,m) == true)
        {
            return new ResponseEntity<>(m,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
@DeleteMapping("/api/payment/{productId}")
    public ResponseEntity<Boolean> delete(@PathVariable("productId") int id)
    {
        if(ms.deleteProduct(id) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
    

}