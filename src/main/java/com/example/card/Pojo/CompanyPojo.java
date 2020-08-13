package com.example.card.Pojo;

import com.example.card.Enity.CompanyEntity;
import lombok.Data;

import java.util.Date;

@Data
public class CompanyPojo {
    Long cid;

    String name;

    Date creat_time;

    String location;

    String creator;

    String description;

    public CompanyPojo(CompanyEntity companyEntity){
        this.cid=companyEntity.getCid();
        this.setName(companyEntity.getName());
        this.setCreat_time(companyEntity.getCreat_time());
        this.setLocation(companyEntity.getLocation());
        this.setDescription(companyEntity.getDescription());
        this.setCreator(companyEntity.getCreator().getName());
    }
}
