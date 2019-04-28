package com.bootdo.system.service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.domain.OrderDO;


public interface OrderService {

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
