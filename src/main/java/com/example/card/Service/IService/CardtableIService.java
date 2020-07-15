package com.example.card.Service.IService;

import com.example.card.Vo.CardtableVo;

public interface CardtableIService {

    //打卡
    Object card_submit(CardtableVo cardtavleVo);

    //查询表单
    Object card_search(Long id);

    //我的表单
    Object getMyCard(Long uid);

}
