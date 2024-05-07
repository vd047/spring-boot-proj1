package com.example.shopping.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.example.shopping.model.Payment;

public interface PaymentRepo extends JpaRepository<Payment,Integer>{
    /*@Query("SELECT e FROM Payment where e.accountName='SBI'")
    List<Payment> findByname();*/
}

