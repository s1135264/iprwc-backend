package com.example.websitebackend1.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //SELECT * FROM product WHERE ProductName = ?
//    @Query("SELECT p FROM Product p WHERE p.productName = ?1")
    Optional<Product> findProductByProductName(String name);


    //SELECT * FROM product WHERE ProductName ILIKE %?%
    @Query("SELECT p FROM Product p WHERE p.productName ILIKE %?1%")
    List<Product> findProductsByProductNameContaining(String filter);
}
