package com.example.card.Enity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class UserEnity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long uid;

    String account;

    String password;

    String name;

    String phone;

    String favicon;

}
