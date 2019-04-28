package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.LogisticsManageDao;
import com.bootdo.system.domain.LogisticsManageDO;
import com.bootdo.system.service.LogisticsManageService;


@Service
public class LogisticsManageServiceImpl implements LogisticsManageService {
    @Autowired
    private LogisticsManageDao logisticsManageDao;

    @Override
    public LogisticsManageDO get(Long id) {
        return logisticsManageDao.get(id);
    }

    @Override
    public List<LogisticsManageDO> list(Map<String, Object> map) {
        return logisticsManageDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return logisticsManageDao.count(map);
    }

    @Override
    public int save(LogisticsManageDO logisticsManage) {
        logisticsManage.setCreateDate(new Date());
        return logisticsManageDao.save(logisticsManage);
    }

    @Override
    public int update(LogisticsManageDO logisticsManage) {
        return logisticsManageDao.update(logisticsManage);
    }

    @Override
    public int remove(Long id) {
        return logisticsManageDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return logisticsManageDao.batchRemove(ids);
    }

}
