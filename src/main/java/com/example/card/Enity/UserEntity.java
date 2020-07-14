package com.example.card.Enity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long uid;

    String account;

    String password;

    String name;

    String phone;

    String favicon;

    @ManyToMany
    Set<CompanyEntity> company_join=new HashSet<>();

    @JoinColumn(name = "user_id")
    @OneToMany(cascade = CascadeType.ALL)
    List<CompanyEntity> company_creat = new ArrayList<>();

    @JoinColumn(name = "user_id")
    @OneToMany(cascade = CascadeType.ALL)
    List<CardtableEntity> cardtableEntities = new ArrayList<>();

}
