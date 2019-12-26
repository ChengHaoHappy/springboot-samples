package com.springboot.security02.mapper;

import com.springboot.security02.model.Role;
import com.springboot.security02.model.User;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface UserMapper {
    User loadUserByUsername(String username);

    List<Role> getUserRolesByUid(Integer id);
}
