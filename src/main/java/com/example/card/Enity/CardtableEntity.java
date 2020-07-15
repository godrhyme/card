package com.example.card.Enity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "cardtable")
@EntityListeners(AuditingEntityListener.class)
public class CardtableEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date date;

    String adress;

    String temperature;

    String description;

    Boolean ifcontinue;

    Boolean ifgoout;

    @JoinColumn(name = "user_id")
    @ManyToOne
    UserEntity creator;


}
