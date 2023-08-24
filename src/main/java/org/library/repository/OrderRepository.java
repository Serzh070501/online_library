package org.library.repository;

import org.library.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

//    List<Order> findByUserId(UUID id);
//
//    List<Order> findByBookIdAuthor(String author);
//
//    List<Order> findByBookIdTitle(String title);

}
