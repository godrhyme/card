package com.example.card.Vo;

import lombok.Data;
import lombok.NonNull;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.Serializable;

@Data
public class UserVo implements Serializable {

    Long uid;

    String account;

    String password;

    String name;

    String phone;

    MultipartFile[] files;

    public UserVo(){};

}
