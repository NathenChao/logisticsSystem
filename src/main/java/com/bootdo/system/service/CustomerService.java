package com.bootdo.system.service;

import com.bootdo.system.domain.CustomerDO;

import java.util.List;
import java.util.Map;


public interface CustomerService {

    CustomerDO get(Long id);

    List<CustomerDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(CustomerDO customer);

    int update(CustomerDO customer);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
