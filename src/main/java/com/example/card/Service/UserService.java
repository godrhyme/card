package com.example.card.Service;

import com.example.card.Pojo.UserPojo;
import com.example.card.Repository.UserDao;
import com.example.card.Enity.UserEntity;
import com.example.card.Service.IService.UserIService;
import com.example.card.Vo.UserVo;
import com.example.card.status.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserIService {

    @Autowired
    private UserDao userDao;

    @Override
    public Object login(String account, String password) {
        UserEntity userEntity=userDao.findUserEntityByAccount(account);
        if(null==userEntity){
            return ResponseBody.UserNotExist();
        }
        else {
            if (!userEntity.getPassword().equals(password))
                return ResponseBody.PasswordError();
            else
                return ResponseBody.Success(new UserPojo(userEntity));
        }
    }

    @Override
    public Object register(UserVo userVo) {
        if(userDao.findUserEntityByAccount(userVo.getAccount())!=null)
            return ResponseBody.UserHasBeenExist();
        else {
            UserEntity userEntity =new UserEntity();
            userEntity.setAccount(userVo.getAccount());
            userEntity.setPassword(userVo.getPassword());
            userEntity.setName(userVo.getName());
            userEntity.setPhone(userVo.getPhone());
            userDao.save(userEntity);
            return ResponseBody.Success(new UserPojo(userEntity));
        }
    }

    @Override
    public Object user_change(UserVo userVo,Long uid) {
        UserEntity userEntity =userDao.findUserEnityByUid(uid);
        userEntity.setName(userVo.getName());
        userEntity.setPhone(userVo.getPhone());
        userDao.save(userEntity);
        return ResponseBody.Success(new UserPojo(userEntity));
    }
}
