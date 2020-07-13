package com.example.card.Enity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "company")
@EntityListeners(AuditingEntityListener.class)
public class CompanyEnity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long cid;

    String name;

    Date creat_time;

    String location;

    String description;


    Long uid;

}
