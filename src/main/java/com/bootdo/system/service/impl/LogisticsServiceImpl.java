package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.LogisticsDao;
import com.bootdo.system.domain.LogisticsDO;
import com.bootdo.system.service.LogisticsService;


@Service
public class LogisticsServiceImpl implements LogisticsService {
    @Autowired
    private LogisticsDao logisticsDao;

    @Override
    public LogisticsDO get(Long id) {
        return logisticsDao.get(id);
    }

    @Override
    public List<LogisticsDO> list(Map<String, Object> map) {
        return logisticsDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return logisticsDao.count(map);
    }

    @Override
    public int save(LogisticsDO logistics) {
        return logisticsDao.save(logistics);
    }

    @Override
    public int update(LogisticsDO logistics) {
        return logisticsDao.update(logistics);
    }

    @Override
    public int remove(Long id) {
        return logisticsDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return logisticsDao.batchRemove(ids);
    }

}
