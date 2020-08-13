package com.example.card.Repository;

import com.example.card.Enity.CardtableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface CardtableDao extends JpaRepository<CardtableEntity,Long> {

    @Query(value = "select c from CardtableEntity c where c.id=?1")
    CardtableEntity findCardtableEntityById(Long id);

    @Query(value = "select c from CardtableEntity c where c.creator.uid=?1")
    List<CardtableEntity> findCardtableEntityByCreator(Long uid);

    @Query(value = "select c from CardtableEntity c where c.creator.uid=?1 and c.date >= ?2 and c.date<=?3")
    List<CardtableEntity> findCardtableEntityByIdAndDate(Long uid, Date date,Date now);
}
