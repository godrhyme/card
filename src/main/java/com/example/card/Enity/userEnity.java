package com.example.card.Enity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class userEnity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String account;

    String password;

    String name;

    String phone;

    String favicon;


}
