package com.example.websitebackend1.cart;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {



    @Query("SELECT c.id FROM Cart c WHERE c.productUuid = ?1")
    Long findIdByProductUuid(UUID productUuid);


    @Query("SELECT c FROM Cart c WHERE c.accountUuid = ?1 AND c.productUuid = ?2")
    Optional<Cart> findCartByProduct(UUID sessionUuid, UUID productUuid);

    @Query("SELECT c FROM Cart c WHERE c.accountUuid = ?1 AND c.productUuid = ?2")
    void updateCartAmount(long id, String amount);


    @Query("SELECT c FROM Cart c WHERE c.accountUuid = ?1")
    List<Cart> getAllCartItemsFromAccount(UUID accountUuid);
}
