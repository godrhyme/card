package com.example.card.Vo;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

@Data
public class UserVo implements Serializable {

    String account;

    String password;

    String name;

    String phone;

    String user_favicon = "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1171074120,2891197699&fm=26&gp=0.jpg";

    public UserVo(){};

}
