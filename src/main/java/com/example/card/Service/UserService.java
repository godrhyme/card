package com.example.card.Service;

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
        if(null==userDao.findUserEntityByAccount(account)){
            return ResponseBody.UserNotExist();
        }
        else {
            if (!userDao.findUserEntityByAccount(account).getPassword().equals(password))
                return ResponseBody.PasswordError();
            else
                return ResponseBody.Success(userDao.findUserEntityByAccount(account).getUid());
        }
    }

    @Override
    public Object register(UserVo userVo) {
        UserEntity userEntity =new UserEntity();
        userEntity.setAccount(userVo.getAccount());
        userEntity.setPassword(userVo.getPassword());
        userEntity.setName(userVo.getName());
        userEntity.setPhone(userVo.getPhone());
        userDao.save(userEntity);
        return ResponseBody.Success(userEntity.getUid());
    }

    @Override
    public Object user_info() {
        return null;
    }

    @Override
    public Object user_change() {
        return null;
    }
}
