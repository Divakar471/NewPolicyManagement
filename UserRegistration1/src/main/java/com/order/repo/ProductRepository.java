package com.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.model.AddPolicy;


public interface ProductRepository extends JpaRepository<AddPolicy,Integer>{

}
