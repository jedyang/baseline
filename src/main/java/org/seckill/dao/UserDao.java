package org.seckill.dao;

import org.seckill.entity.OrderInfo;
import org.seckill.entity.User;

import java.util.List;

public interface UserDao {
    //注册用户
    public boolean reg(String name, String password, String defaultAddress, String defaultPhone, String mail);

//        //java时间转化为sql的时间戳;
//        Timestamp time  = new Timestamp(System.currentTimeMillis());
//        return 0!=jdbcDao.jdbcTemplate.update("insert into user value(null,?,?,?,?,?,?)", new Object[] {name, password, defaultAddress, defaultPhone, mail, time});


    //登录验证
    public boolean login(String name, String password);
//        List<Map<String,Object>> list = jdbcDao.jdbcTemplate.queryForList("select * from user where name=?", new Object[] {name});
//        Iterator iterator = list.iterator();
//        while( iterator.hasNext() ) {
//            Map<String, Object> map = (Map<String, Object>) iterator.next();
//            if( name.equals( map.get("name") ) ) {
//                return password.equals( (String)map.get("password") );
//            };
//        };
//        return false;


    //添加订单
    public boolean addOrder(int userId, int commodityId, int commodityCount);


    //获取购物车
    public String getOrderList(int userId);

    //删除购物车
    public boolean delOrder(int userId);

    //添加订单
    public boolean addForm(int userId, String address, String phone, String totalPrice, String pay, String orderlist);

    //获取指定用户所有订单;
    public List<OrderInfo> getFormList(int userId);

    //获取所有
    public List<OrderInfo> getFormAllList();

    /**
     * @param userId 获取指定状态的订单;
     * @param flag   true 获取指定用户已经支付的订单;
     *               false 获取指定用户未支付的订单;
     */
    public List<OrderInfo> getFormList(int userId, boolean flag);

    public boolean setPaying(int userId, int orderformId);

    public User getInfo(int userId);

    public boolean updateInfo(String userId, String name, String password, String defaultAddress, String defaultPhone, String mail);

    public String getPassword(String username);

    public String getId(String username);

    public int getRole(String username);
}
