package com.wangsong.springboot.chapter04.Controller;

import com.wangsong.springboot.chapter04.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: chenghao
 * @date: 2019/8/20
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getUser")
    public String getUserById(Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("/deleteUser")
    public void deleteUserById(Integer id) {
        userService.deleteUserById(id);
    }


}
