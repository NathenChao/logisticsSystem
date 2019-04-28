package com.bootdo.system.dao;

import com.bootdo.system.domain.OrderDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author dc
 */
@Mapper
public interface OrderDao {

    OrderDO get(Long id);

    List<OrderDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(OrderDO order);

    int update(OrderDO order);

    int remove(Long id);

    int batchRemove(Long[] ids);

    List<OrderDO> statistics(Map<String, Object> map);

    int statisticsCount(Map<String, Object> map);
}
