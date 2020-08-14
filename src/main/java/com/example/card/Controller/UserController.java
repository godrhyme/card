package com.example.card.Controller;

import com.example.card.Service.UserService;
import com.example.card.Vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/index")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public Object login(String account, String password) {
        return userService.login(account,password);
    }

    @PostMapping("/register")
    public Object register( @RequestBody UserVo userVo) {
        return userService.register(userVo);
    }

    @PostMapping("/user_info")
    public Object user_info(UserVo userVo) {
        return userService.user_change(userVo);
    }
}
