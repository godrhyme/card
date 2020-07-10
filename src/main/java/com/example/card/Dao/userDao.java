package com.example.card.Dao;
import com.example.card.Enity.userEnity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface userDao extends JpaRepository<userEnity,Long> {

    @Query(value = "select l from userEnity l where l.id=?1")
    userEnity finduserEnitiesById(Long id);
}
