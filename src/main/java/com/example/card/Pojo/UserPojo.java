package com.example.card.Pojo;

import com.example.card.Enity.UserEntity;
import lombok.Data;

import java.util.List;

@Data
public class UserPojo {
    Long uid;

    String name;

    String phone;

    Boolean card_today;

    String favicon;

    public UserPojo(UserEntity userEntity){
        this.uid=userEntity.getUid();
        this.setName(userEntity.getName());
        this.setPhone(userEntity.getPhone());
        this.setCard_today(userEntity.getCard_today());
        this.favicon=userEntity.getFavicon().getImage_url();
    }

}
