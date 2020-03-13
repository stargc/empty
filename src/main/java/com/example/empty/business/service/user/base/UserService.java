package com.example.empty.business.service.user.base;

import com.example.empty.infrastructure.persistence.mapper.UserMapper;
import com.example.empty.infrastructure.persistence.po.User;
import com.example.empty.infrastructure.persistence.po.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author created by guanchen on 2019/9/23 11:27
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User selectUserInfoByUserIdAndPassword(String userId,String password){
        UserExample searchExample = new UserExample();
        searchExample.createCriteria().andUserIdEqualTo(userId);
        List<User> userList = userMapper.selectByExample(searchExample);
        if (userList.isEmpty()){
            return null;
        }
        return userList.get(0);
    }
}
