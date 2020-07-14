package com.example.card.Enity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "company")
@EntityListeners(AuditingEntityListener.class)
public class CompanyEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long cid;

    String name;

    Date creat_time;

    String location;

    String description;

    @ManyToMany(cascade = CascadeType.MERGE,mappedBy = "company_join")
    List<UserEntity> joiners=new ArrayList<>();

    @JoinColumn(name = "user_id")
    @ManyToOne
    UserEntity userEntity;

    @JoinColumn(name = "company_id")
    @OneToMany(cascade = CascadeType.ALL)
    List<CardtableEntity> cardtableEntities = new ArrayList<>();



}
