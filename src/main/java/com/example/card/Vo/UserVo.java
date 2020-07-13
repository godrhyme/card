package com.example.card.Vo;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

@Data
public class UserVo implements Serializable {

    @NonNull
    String account;

    @NonNull
    String password;

    @NonNull
    String name;

    @NonNull
    String phone;

}
