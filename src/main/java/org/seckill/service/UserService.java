package org.seckill.service;

import org.seckill.entity.OrderInfo;
import org.seckill.entity.Result;
import org.seckill.entity.User;

import java.util.List;

public interface UserService {
    //注册用户
    Result reg(String name, String mail, String password, String phone);

    /**
     * 查询用户名或某个字段是否存在
     *
     * @return
     */
    int countRecord(String param, String column);

    String getPassword(String username);

    String getId(String username);

    int getRole(String username);

    Result<User> getUser(String userName);
}
