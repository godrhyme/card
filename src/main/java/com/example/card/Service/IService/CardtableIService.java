package com.example.card.Service.IService;

import com.example.card.Vo.CardtableVo;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.util.Date;

public interface CardtableIService {

    //打卡
    Object card_submit(CardtableVo cardtavleVo);

    //查询表单
    Object card_search(Long uid, Date date) throws ParseException;

    //我的表单
    Object getMyCard(Long uid);

}
