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

    String name = "未设置昵称";

    String phone;

    //用户头像
    private String user_favicon = "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1171074120,2891197699&fm=26&gp=0.jpg";

    @ManyToMany
    Set<CompanyEntity> my_join=new HashSet<>();

    @ManyToMany
    Set<CompanyEntity> my_apply=new HashSet<>();

    @JoinColumn(name = "create_by")
    @OneToMany(cascade = CascadeType.REMOVE)
    Set<CompanyEntity> my_company = new HashSet<>();

    @JoinColumn(name = "create_by")
    @OneToMany(cascade = CascadeType.REMOVE)
    Set<CardtableEntity> my_card = new HashSet<>();

    //ImageEntity imageEntity;

}
