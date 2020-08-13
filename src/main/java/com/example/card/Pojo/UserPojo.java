package com.example.card.Pojo;

import com.example.card.Enity.UserEntity;
import lombok.Data;

import java.util.List;

@Data
public class UserPojo {
    Long uid;

    String name;

    String phone;

    String user_favicon;

    public UserPojo(UserEntity userEntity){
        this.uid=userEntity.getUid();
        this.setName(userEntity.getName());
        this.setPhone(userEntity.getPhone());
        this.setUser_favicon(userEntity.getUser_favicon());
    }

}
