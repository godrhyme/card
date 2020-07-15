package com.example.card.Enity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
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
    Set<CompanyEntity> my_join=new HashSet<>();

    @JoinColumn(name = "create_by")
    @OneToMany(cascade = CascadeType.REMOVE)
    Set<CompanyEntity> my_company = new HashSet<>();

    @JoinColumn(name = "create_by")
    @OneToMany(cascade = CascadeType.REMOVE)
    Set<CardtableEntity> my_card = new HashSet<>();

}
