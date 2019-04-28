package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.OrderSettlementDao;
import com.bootdo.system.domain.OrderSettlementDO;
import com.bootdo.system.service.OrderSettlementService;


@Service
public class OrderSettlementServiceImpl implements OrderSettlementService {
    @Autowired
    private OrderSettlementDao orderSettlementDao;

    @Override
    public OrderSettlementDO get(Long id) {
        return orderSettlementDao.get(id);
    }

    @Override
    public List<OrderSettlementDO> list(Map<String, Object> map) {
        return orderSettlementDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return orderSettlementDao.count(map);
    }

    @Override
    public int save(OrderSettlementDO orderSettlement) {
        orderSettlement.setCreateDate(new Date());
        return orderSettlementDao.save(orderSettlement);
    }

    @Override
    public int update(OrderSettlementDO orderSettlement) {
        return orderSettlementDao.update(orderSettlement);
    }

    @Override
    public int remove(Long id) {
        return orderSettlementDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return orderSettlementDao.batchRemove(ids);
    }

}
