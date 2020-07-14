package com.example.card.Vo;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

@Data
public class CompanyVo implements Serializable {

    @NonNull
    String name;

    String location;

    String description;

    Long uid;
}
