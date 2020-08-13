package com.example.card.Enity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Getter
@Setter
@Table(name = "company")
@EntityListeners(AuditingEntityListener.class)
public class CompanyEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long cid;

    String name;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date creat_time;

    String location;

    String description;

    @ManyToMany
    Set<UserEntity> joiners=new HashSet<>();

    @ManyToMany
    Set<UserEntity> applicants=new HashSet<>();

    @JoinColumn(name = "user_id")
    @ManyToOne
    UserEntity creator;

}
