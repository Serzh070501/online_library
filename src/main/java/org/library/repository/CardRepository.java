package org.library.repository;

import org.library.model.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface CardRepository extends JpaRepository<Card, Long> {


}


