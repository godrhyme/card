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
public class CardtableEnity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Date date;

    String adress;

    String temperature;

    Boolean ifcontinue;

    Boolean ifgoout;
}
