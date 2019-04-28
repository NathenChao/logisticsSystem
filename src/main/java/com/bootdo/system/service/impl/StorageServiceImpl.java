package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.StorageDao;
import com.bootdo.system.domain.StorageDO;
import com.bootdo.system.service.StorageService;


@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageDao storageDao;

    @Override
    public StorageDO get(Long id) {
        return storageDao.get(id);
    }

    @Override
    public List<StorageDO> list(Map<String, Object> map) {
        return storageDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return storageDao.count(map);
    }

    @Override
    public int save(StorageDO storage) {
        return storageDao.save(storage);
    }

    @Override
    public int update(StorageDO storage) {
        return storageDao.update(storage);
    }

    @Override
    public int remove(Long id) {
        return storageDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return storageDao.batchRemove(ids);
    }

}
