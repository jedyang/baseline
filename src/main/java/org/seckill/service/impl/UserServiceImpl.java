package org.seckill.service.impl;

import org.seckill.entity.OrderInfo;
import org.seckill.entity.User;
import org.seckill.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public boolean reg(String name, String password, String defaultAddress, String defaultPhone, String mail) {
        return false;
    }

    @Override
    public boolean login(String name, String password) {
        return false;
    }

    @Override
    public boolean addOrder(int userId, int commodityId, int commodityCount) {
        return false;
    }

    @Override
    public String getOrderList(int userId) {
        return null;
    }

    @Override
    public boolean delOrder(int userId) {
        return false;
    }

    @Override
    public boolean addForm(int userId, String address, String phone, String totalPrice, String pay, String orderlist) {
        return false;
    }

    @Override
    public List<OrderInfo> getFormList(int userId) {
        return null;
    }

    @Override
    public List<OrderInfo> getFormAllList() {
        return null;
    }

    @Override
    public List<OrderInfo> getFormList(int userId, boolean flag) {
        return null;
    }

    @Override
    public boolean setPaying(int userId, int orderformId) {
        return false;
    }

    @Override
    public User getInfo(int userId) {
        return null;
    }

    @Override
    public boolean updateInfo(String userId, String name, String password, String defaultAddress, String defaultPhone, String mail) {
        return false;
    }

    @Override
    public String getPassword(String username) {
        // TODO
        return "123456";
    }

    @Override
    public String getId(String username) {
        return null;
    }

    @Override
    public int getRole(String username) {
        return 0;
    }
}
