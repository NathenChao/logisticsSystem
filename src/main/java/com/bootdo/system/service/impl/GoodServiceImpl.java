package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.GoodDao;
import com.bootdo.system.domain.GoodDO;
import com.bootdo.system.service.GoodService;


@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodDao goodDao;

    @Override
    public GoodDO get(Long id) {
        return goodDao.get(id);
    }

    @Override
    public List<GoodDO> list(Map<String, Object> map) {
        return goodDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return goodDao.count(map);
    }

    @Override
    public int save(GoodDO good) {
        good.setCreateDate(new Date());
        good.setDelFlag(0);
        return goodDao.save(good);
    }

    @Override
    public int update(GoodDO good) {
        return goodDao.update(good);
    }

    @Override
    public int remove(Long id) {
        return goodDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return goodDao.batchRemove(ids);
    }

}
