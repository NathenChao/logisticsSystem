package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.StorageOutputDao;
import com.bootdo.system.domain.StorageOutputDO;
import com.bootdo.system.service.StorageOutputService;


@Service
public class StorageOutputServiceImpl implements StorageOutputService {
    @Autowired
    private StorageOutputDao storageOutputDao;

    @Override
    public StorageOutputDO get(Long id) {
        return storageOutputDao.get(id);
    }

    @Override
    public List<StorageOutputDO> list(Map<String, Object> map) {
        return storageOutputDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return storageOutputDao.count(map);
    }

    @Override
    public int save(StorageOutputDO storageOutput) {
        storageOutput.setCreateDate(new Date());
        return storageOutputDao.save(storageOutput);
    }

    @Override
    public int update(StorageOutputDO storageOutput) {
        return storageOutputDao.update(storageOutput);
    }

    @Override
    public int remove(Long id) {
        return storageOutputDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return storageOutputDao.batchRemove(ids);
    }

}
