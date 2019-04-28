package com.bootdo.system.service;

import com.bootdo.system.domain.OrderSettlementDO;

import java.util.List;
import java.util.Map;


public interface OrderSettlementService {

    OrderSettlementDO get(Long id);

    List<OrderSettlementDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(OrderSettlementDO orderSettlement);

    int update(OrderSettlementDO orderSettlement);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
