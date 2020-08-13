package com.example.card.Pojo;

import com.example.card.Enity.CardtableEntity;
import lombok.Data;

import java.util.Date;

@Data
public class CardtablePojo {

    Long id;

    Date date;

    String adress;

    String temperature;

    String description;

    Boolean ifcontinue;

    Boolean ifgoout;

    public CardtablePojo(CardtableEntity cardtableEntity){
        this.id=cardtableEntity.getId();
        this.setAdress(cardtableEntity.getAdress());
        this.setTemperature(cardtableEntity.getTemperature());
        this.setDescription(cardtableEntity.getDescription());
        this.setIfcontinue(cardtableEntity.getIfcontinue());
        this.setIfgoout(cardtableEntity.getIfgoout());
        this.setDate(cardtableEntity.getDate());
    }
}
