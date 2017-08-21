package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.OrderInfo;
import org.seckill.entity.User;

import java.util.Date;
import java.util.List;

public interface UserDao {
    //注册用户
    int reg(@Param("name") String name, @Param("email") String email, @Param("password") String password, @Param("phone") String phone);


    User getRecord(@Param("param") String param, @Param("column") String column);
}
