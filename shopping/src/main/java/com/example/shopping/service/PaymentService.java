
package com.example.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Service;

import com.example.shopping.model.Payment;

import com.example.shopping.repository.PaymentRepo;



@Service
public class PaymentService {
    @Autowired
    PaymentRepo mr;
    public Payment create (Payment mm)
    {
        return mr.save(mm);
    }
    public List<Payment> getAll()
    {
        return mr.findAll();
    }
    public Payment getMe(int id)
    {
        return mr.findById(id).orElse(null);
    }
    public boolean updateDetails(int id,Payment mm)
        {
            if(this.getMe(id)==null)
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
public boolean deleteProduct(int id)
        {
            if(this.getMe(id) == null)
            {
                return false;
            }
            mr.deleteById(id);
            return true;
        }
        
        
        
    
}
