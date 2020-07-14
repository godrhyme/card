package com.example.card.Enity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Data
@Table(name = "cardtable")
@EntityListeners(AuditingEntityListener.class)
public class CardtableEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Date date;

    String adress;

    String temperature;

    String description;

    Boolean ifcontinue;

    Boolean ifgoout;

    @JoinColumn(name = "user_id")
    @ManyToOne
    UserEntity userEntity;

    @JoinColumn(name = "company_id")
    @ManyToOne
    CompanyEntity companyEntity;



}
