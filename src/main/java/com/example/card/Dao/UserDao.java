package com.example.card.Dao;
import com.example.card.Enity.UserEnity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<UserEnity,Long> {

    @Query(value = "select u from UserEnity u where u.uid=?1")
    UserEnity findUserEnityByUid(Long uid);

    @Query(value = "select u from UserEnity u where u.account=?1")
    UserEnity findUserEnityByAccount(String account);
}
