package com.example.card.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class CardtableVo {

    @NonNull
    String temperature;

    @NonNull
    String adress;

    @NonNull
    Boolean ifgoout;

    String description;

    Long uid;


    public CardtableVo(){}
}
