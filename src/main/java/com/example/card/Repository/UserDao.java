package com.example.card.Repository;
import com.example.card.Enity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<UserEntity,Long> {

    @Query(value = "select u from UserEntity u where u.uid=?1")
    UserEntity findUserEnityByUid(Long uid);

    @Query(value = "select u from UserEntity u where u.account=?1")
    UserEntity findUserEntityByAccount(String account);
}
