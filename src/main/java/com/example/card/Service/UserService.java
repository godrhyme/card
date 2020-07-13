package com.example.card.Service;

import com.example.card.Dao.UserDao;
import com.example.card.Enity.UserEnity;
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
        if(null==userDao.findUserEnityByAccount(account)){
            return ResponseBody.UserNotExist();
        }
        else {
            if (!userDao.findUserEnityByAccount(account).getPassword().equals(password))
                return ResponseBody.PasswordError();
            else
                return ResponseBody.Success(userDao.findUserEnityByAccount(account).getUid());
        }
    }

    @Override
    public Object register(UserVo userVo) {
        UserEnity userEnity =new UserEnity();
        userEnity.setAccount(userVo.getAccount());
        userEnity.setPassword(userVo.getPassword());
        userEnity.setName(userVo.getName());
        userEnity.setPhone(userVo.getPhone());
        userDao.save(userEnity);
        return ResponseBody.Success(userEnity.getUid());
    }

    @Override
    public Object user_info() {
        return null;
    }
}
