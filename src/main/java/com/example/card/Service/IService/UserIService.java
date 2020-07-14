package com.example.card.Service.IService;

import com.example.card.Vo.UserVo;

public interface UserIService {

    //登陆
    Object login(String account,String password);

    //注册
    Object register(UserVo userVo);

    //获取用户信息
    Object user_info();

    //修改用户信息
    Object user_change();

}
