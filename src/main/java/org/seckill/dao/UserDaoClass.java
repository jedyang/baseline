package org.seckill.dao;

import org.springframework.stereotype.Repository;

//import javax.persistence.criteria.From;

/**
 * TODO
 * 改为使用mybatis
 */
@Repository
public class UserDaoClass {
//	@Autowired
//	JdbcDao jdbcDao;
	
//	//注册用户
//	public boolean reg(String name, String password, String defaultAddress, String defaultPhone, String mail) {
//
//		//java时间转化为sql的时间戳;
//		Timestamp time  = new Timestamp(System.currentTimeMillis());
//		return 0!=jdbcDao.jdbcTemplate.update("insert into user value(null,?,?,?,?,?,?)", new Object[] {name, password, defaultAddress, defaultPhone, mail, time});
//
//	}
//
//	//登录验证
//	public boolean login(String name, String password){
//		List<Map<String,Object>> list = jdbcDao.jdbcTemplate.queryForList("select * from user where name=?", new Object[] {name});
//		Iterator iterator = list.iterator();
//		while( iterator.hasNext() ) {
//			Map<String, Object> map = (Map<String, Object>) iterator.next();
//			if( name.equals( map.get("name") ) ) {
//				return password.equals( (String)map.get("password") );
//			};
//		};
//		return false;
//	}
//
//	//添加订单
//	public boolean addOrder(int userId, int commodityId, int commodityCount) {
//		List<Map<String,Object>> list = jdbcDao.jdbcTemplate.queryForList("select * from orderlist where userId=? and commodityId=?", new Object[] {userId, commodityId});
//		//如果list不存在那就使用insert, 添加一条记录;
//		if(list.size() == 0) {
//			return 0!=jdbcDao.jdbcTemplate.update("insert into orderlist values(null,?,?,?)", new Object[] {userId, commodityId, commodityCount});
//		}else{
//			int count = jdbcDao.jdbcTemplate.queryForInt("select commodityCount from orderlist where userId="+userId+" and commodityId="+commodityId);
//			if( count != 0 ) {
//				commodityCount += count;
//			};
//			return 0!=jdbcDao.jdbcTemplate.update("update orderlist set userId=?,commodityId=?,commodityCount=? where userId=? and commodityId=?", new Object[] {userId, commodityId, commodityCount, userId, commodityId});
//		}
//	}
//
//	//获取购物车
//	public String getOrderList(int userId) {
//		List<Map<String,Object>> list = jdbcDao.jdbcTemplate.queryForList("select * from orderlist where userId=?", new Object[] {userId});
//		return JSONArray.fromObject( list ).toString();
//	}
//
//	//删除购物车
//	public boolean delOrder(int userId) {
//		return 0!=jdbcDao.jdbcTemplate.update("delete  from orderlist where userId=?", new Object[] {userId});
//	}
//
//	//添加订单
//	public boolean addForm(int userId,String address,String phone,String totalPrice,String pay, String orderlist) {
//		return 0!=jdbcDao.jdbcTemplate.update("insert into OrderInfo values(null,?,?,?,?,?,?)", new Object[] {userId, address, phone, totalPrice, pay, orderlist});
//	}
//
//	//获取指定用户所有订单;
//	public List<OrderInfo> getFormList(int userId) {
//		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcDao.jdbcTemplate);
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//		paramMap.put("userId", userId);
//		RowMapper< OrderInfo > rm = new BeanPropertyRowMapper<OrderInfo>( OrderInfo.class );
//		List<OrderInfo> list = namedParameterJdbcTemplate.query("select * from OrderInfo where userId=(:userId)",paramMap,rm);
//		return list;
//	}
//
//	//获取所有
//	public List<OrderInfo> getFormAllList() {
//		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcDao.jdbcTemplate);
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//		RowMapper< OrderInfo > rm = new BeanPropertyRowMapper<OrderInfo>( OrderInfo.class );
//		List<OrderInfo> list = namedParameterJdbcTemplate.query("select * from OrderInfo",paramMap,rm);
//		return list;
//	}
//
//	/**
//	 * @param userId 获取指定状态的订单;
//	 * @param flag
//	 * true 获取指定用户已经支付的订单;
//	 * false 获取指定用户未支付的订单;
//	 */
//	public List<OrderInfo> getFormList(int userId, boolean flag) {
//		int payType = 0;
//		if( flag ) {
//			payType = 1;
//		}else{
//			payType = 0;
//		};
//		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcDao.jdbcTemplate);
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//		paramMap.put("userId", userId);
//		paramMap.put("payType", payType);
//		RowMapper< OrderInfo > rm = new BeanPropertyRowMapper<OrderInfo>( OrderInfo.class );
//		List<OrderInfo> list = namedParameterJdbcTemplate.query("select * from OrderInfo where userId=(:userId) and pay=(:payType)",paramMap,rm);
//		return list;
//	}
//
//	public boolean setPaying(int userId, int orderformId) {
//		//获取用户金额， 获取订单的金额
//		//如果相减为正值， 那么就把设置订单的状态为已经支付， 然后用户的金额减少， 并返回true;
//		int userMoney = jdbcDao.jdbcTemplate.queryForInt("select money from user where id="+userId);
//		int orderMoney = jdbcDao.jdbcTemplate.queryForInt("select totalPrice from OrderInfo where id="+orderformId);
//		if( userMoney - orderMoney >=0 ) {
//			userMoney -= orderMoney;
//			jdbcDao.jdbcTemplate.update("update user set money="+userMoney);
//			jdbcDao.jdbcTemplate.update("update OrderInfo set pay=1 where id="+orderformId);
//			return true;
//		}else{
//			//否者返回false;
//			return false;
//		}
//	}
//
//	public User getInfo( int userId ) {
//		Map<String, Object> map = jdbcDao.jdbcTemplate.queryForMap( "select * from user where id="+userId );
//		User user = new User();
//		user.setId( (Integer)map.get("id") );
//		user.setDefaultAddress((String) map.get("defaultAddress") );
//		user.setDefaultPhone( (String)map.get("defaultPhone") );
//		user.setMail( (String)map.get("mail") );
//		user.setName( (String)map.get("name") );
//		user.setPassword( (String)map.get("password") );
//		user.setMoney( map.get("money").toString() );
//		return user;
//	}
//
//	public boolean updateInfo(String userId, String name,String  password, String defaultAddress, String defaultPhone, String mail) {
//		return 0!=jdbcDao.jdbcTemplate.update("update user set name='"+name+"', password='"+password+"', defaultAddress='"+defaultAddress+"', defaultPhone='"+defaultPhone+"', mail='"+mail+"'  where id="+userId);
//	}
//
//	public String getPassword(String username) {
//
//		String str = "";
//
//		StringBuilder sqlString = new StringBuilder( "select * from user where name='"+username+"'");
//
//		List<Map<String,Object>> list = jdbcDao.jdbcTemplate.queryForList( sqlString.toString() );
//
//		Iterator iterator = list.iterator();
//
//		while(iterator.hasNext()) {
//
//			str = (String)((Map)iterator.next()).get("password");
//
//		};
//
//		return str;
//	}
//	public String getId(String username) {
//
//		String str = "";
//
//		StringBuilder sqlString = new StringBuilder( "select * from user where name='"+username+"'");
//
//		List<Map<String,Object>> list = jdbcDao.jdbcTemplate.queryForList( sqlString.toString() );
//
//		Iterator iterator = list.iterator();
//
//		while(iterator.hasNext()) {
//			Map<String, Object> map = (Map<String, Object>) iterator.next();
//			str = map.get("id").toString();
//
//		};
//
//		return str;
//	}
//
//	public int getRole(String username) {
//
//		StringBuilder sqlString = new StringBuilder( "select role from user where name='"+username+"'");
//		return jdbcDao.jdbcTemplate.queryForInt( sqlString.toString() );
//
//	}
}
