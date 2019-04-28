package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.CustomerDao;
import com.bootdo.system.domain.CustomerDO;
import com.bootdo.system.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public CustomerDO get(Long id) {
        return customerDao.get(id);
    }

    @Override
    public List<CustomerDO> list(Map<String, Object> map) {
        return customerDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return customerDao.count(map);
    }

    @Override
    public int save(CustomerDO customer) {
        return customerDao.save(customer);
    }

    @Override
    public int update(CustomerDO customer) {
        return customerDao.update(customer);
    }

    @Override
    public int remove(Long id) {
        return customerDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return customerDao.batchRemove(ids);
    }

}
