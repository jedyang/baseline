package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangyijun on 15/10/5.
 */
public interface SeckillDao {

    /**
     * 减库存,
     *
     * @param seckillId
     * @param killTime
     * @return 如果影响行数>1，表示更新的记录行数
     */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
     * 根据id查询秒杀对象
     *
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     *
     *
     * @param sort
     * @param limit
     * @param offset
     * @return
     */
    List<Seckill> queryAll( @Param("sort") String sort, @Param("order") String order, @Param("limit") int limit, @Param("offset") int offset);

    /**
     * 查询全部数量
     * @return
     */
    int countAll();

    /**
     * 使用存储过程执行秒杀
     *
     * @param paramMap
     */
    void killByProcedure(Map<String, Object> paramMap);

}
