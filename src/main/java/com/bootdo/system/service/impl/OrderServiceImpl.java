package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.OrderDao;
import com.bootdo.system.domain.OrderDO;
import com.bootdo.system.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public OrderDO get(Long id) {
        return orderDao.get(id);
    }

    @Override
    public List<OrderDO> list(Map<String, Object> map) {
        return orderDao.list(map);
    }


    @Override
    public List<OrderDO> statistics(Map<String, Object> map) {
        return orderDao.statistics(map);
    }

    @Override
    public int statisticsCount(Map<String, Object> map) {
        return orderDao.statisticsCount(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return orderDao.count(map);
    }

    @Override
    public int save(OrderDO order) {
        order.setOrderSn(String.valueOf(new Date().getTime()));
        order.setCreateDate(new Date());
        order.setStatus(0);
        return orderDao.save(order);
    }

    @Override
    public int update(OrderDO order) {
        return orderDao.update(order);
    }

    @Override
    public int remove(Long id) {
        return orderDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return orderDao.batchRemove(ids);
    }

}
