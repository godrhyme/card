package com.example.card.Service;

import com.example.card.Enity.CardtableEntity;
import com.example.card.Enity.UserEntity;
import com.example.card.Repository.CardtableDao;
import com.example.card.Repository.UserDao;
import com.example.card.Service.IService.CardtableIService;
import com.example.card.Vo.CardtavleVo;
import com.example.card.status.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardtableService implements CardtableIService {

    @Autowired
    private CardtableDao cardtableDao;

    @Autowired
    private UserDao userDao;

    @Override
    public Object card_submit(CardtavleVo cardtavleVo) {
        CardtableEntity cardtableEntity = new CardtableEntity();
        UserEntity userEntity =userDao.findUserEnityByUid(cardtavleVo.getUid());
        userEntity.getCardtableEntities().add(cardtableEntity);
        cardtableEntity.setAdress(cardtavleVo.getAdress());
        cardtableEntity.setTemperature(cardtavleVo.getTemperature());
        cardtableEntity.setDescription(cardtavleVo.getDescription());
        cardtableEntity.setIfgoout(cardtableEntity.getIfgoout());
        cardtableDao.save(cardtableEntity);
        return ResponseBody.Success();
    }

    @Override
    public Object card_search(Long id) {
        CardtableEntity cardtableEntity = cardtableDao.findCardtableEntityById(id);
        return ResponseBody.Success(cardtableEntity);
    }

    @Override
    public Object getMyCard(Long uid) {
        UserEntity userEntity = userDao.findUserEnityByUid(uid);
        List<CardtableEntity> list = new ArrayList<>();
        userEntity.getCardtableEntities().forEach(item->{{list.add(new CardtableEntity());}});
        return ResponseBody.Success(list);
    }
}
