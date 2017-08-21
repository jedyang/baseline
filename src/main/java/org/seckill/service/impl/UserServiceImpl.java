package org.seckill.service.impl;

import org.seckill.dao.UserDao;
import org.seckill.entity.OrderInfo;
import org.seckill.entity.Result;
import org.seckill.entity.User;
import org.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public Result reg(String name, String mail, String password, String phone) {
        Result r = new Result();
        int reg = userDao.reg(name, mail, password, phone);
        if (1 == reg) {
            r.setSuccess(true);
        } else {
            r.setSuccess(false);
        }
        return r;
    }

    @Override
    public int countRecord(String param, String column) {
        User user = userDao.getRecord("'" + param + "'", column);
        if (null == user){
            return 0;
        }
        return 1;
    }


    @Override
    public String getPassword(String username) {
        User user = userDao.getRecord("'" + username + "'", "name");
        if (null == user){
            return "";
        }
        return user.getPassword();
    }


    @Override
    public Result<User> getById(String userId) {
        User user = userDao.getRecord("'" + userId + "'", "user_id");
        Result r = new Result();

        if (null == user){
            r.setSuccess(false);
            r.setMsg("没有找到对应的信息");
        }else{
            r.setSuccess(true);
            r.setResultObj(user);
        }
        return r;
    }

    @Override
    public int getRole(String username) {
        return 0;
    }

    @Override
    public Result<User> getUser(String username) {
        User user = userDao.getRecord("'" + username + "'", "name");
        Result r = new Result();

        if (null == user){
            r.setSuccess(false);
            r.setMsg("没有找到对应的信息");
        }else{
            r.setSuccess(true);
            r.setResultObj(user);
        }
        return r;
    }


    @Override
    public int updateUser(User resultObj) {
        int result = userDao.updateUserPwd(resultObj);
        return result;
    }
}
