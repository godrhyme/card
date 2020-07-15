package com.example.card.Vo;

import lombok.Data;
import lombok.NonNull;

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
}
