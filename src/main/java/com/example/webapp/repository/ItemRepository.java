package com.example.webapp.repository;

import com.example.webapp.domain.Items;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends PagingAndSortingRepository<Items, Long> {

    @Query("select p from Items p where p.user.id = ?1")
    List<Items> findByUser(Long userId);

//    @Query("select p from Product p where p.seller.firstName = :firstName and p.seller.lastName = :lastName")
//    List<Product> findBySellerName(@Param("firstName") String sellerFirstName, @Param("lastName") String sellerLastName);

}
