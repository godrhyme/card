package com.example.card.Repository;

import com.example.card.Enity.CardtableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CardtableDao extends JpaRepository<CardtableEntity,Long> {

    @Query(value = "select c from CardtableEntity c where c.id=?1")
    CardtableEntity findCardtableEntityById(Long id);
}
