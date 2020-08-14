package com.example.card.Service;

import com.example.card.Enity.CardtableEntity;
import com.example.card.Enity.UserEntity;
import com.example.card.Pojo.CardtablePojo;
import com.example.card.Repository.CardtableDao;
import com.example.card.Repository.UserDao;
import com.example.card.Service.IService.CardtableIService;
import com.example.card.Vo.CardtableVo;
import com.example.card.status.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
public class CardtableService implements CardtableIService {

    @Autowired
    private CardtableDao cardtableDao;

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public Object card_submit(CardtableVo cardtableVo) {

        CardtableEntity cardtableEntity = new CardtableEntity();
        UserEntity userEntity =userDao.findUserEnityByUid(cardtableVo.getUid());

        cardtableEntity.setAdress(cardtableVo.getAdress());
        cardtableEntity.setTemperature(cardtableVo.getTemperature());
        cardtableEntity.setDescription(cardtableVo.getDescription());
        cardtableEntity.setIfgoout(cardtableEntity.getIfgoout());
        cardtableEntity.setCreator(userEntity);

        userEntity.getMy_card().add(cardtableEntity);
        userEntity.setCard_today(true);

        cardtableDao.save(cardtableEntity);
        return ResponseBody.Success();
    }

    @Override
    public Object card_search(Long uid, Date date) {
        Date date2;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, 1);
        date2=c.getTime();
        List<CardtableEntity> list= cardtableDao.findCardtableEntityByIdAndDate(uid,date,date2);
        if (list==null){
            return ResponseBody.UserNotExist();
        }else {
            List<CardtablePojo> pojos= new ArrayList<>();
            list.forEach(item->{{ pojos.add(new CardtablePojo(item));};
            });
            return ResponseBody.Success(pojos);
        }
    }

    @Override
    public Object getMyCard(Long uid) {
        List<CardtableEntity> list = cardtableDao.findCardtableEntityByCreator(uid);
        List<CardtablePojo> pojo = new ArrayList<>();
        list.forEach(item->{{pojo.add(new CardtablePojo(item));}});
        return ResponseBody.Success(pojo);
    }
}
