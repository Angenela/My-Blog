package com.angenela.service.user;

import com.angenela.dao.User;
import com.angenela.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(User user) {

        User userByName = userMapper.getUserByName(user.getName());

        if(userByName == null){
            return false;
        }else if(userByName.getPassword().equals(user.getPassword())){
            return true;
        }else{
            return false;
        }

    }
}
