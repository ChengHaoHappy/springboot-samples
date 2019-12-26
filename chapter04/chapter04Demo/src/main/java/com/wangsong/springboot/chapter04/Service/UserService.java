package com.wangsong.springboot.chapter04.Service;

import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: chenghao
 * @date: 2019/8/19
 */
@Service
public class UserService {
    public String getUserById(Integer id) {
        System.out.println("UserService.getUserById");
        return "user";
    }

    public void deleteUserById(Integer id) {
        System.out.println("UserService.deleteUserById");
    }

}
