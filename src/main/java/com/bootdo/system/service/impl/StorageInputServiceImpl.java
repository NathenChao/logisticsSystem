package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.StorageInputDao;
import com.bootdo.system.domain.StorageInputDO;
import com.bootdo.system.service.StorageInputService;


@Service
public class StorageInputServiceImpl implements StorageInputService {
    @Autowired
    private StorageInputDao storageInputDao;

    @Override
    public StorageInputDO get(Long id) {
        return storageInputDao.get(id);
    }

    @Override
    public List<StorageInputDO> list(Map<String, Object> map) {
        return storageInputDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return storageInputDao.count(map);
    }

    @Override
    public int save(StorageInputDO storageInput) {
        storageInput.setCreateDate(new Date());
        return storageInputDao.save(storageInput);
    }

    @Override
    public int update(StorageInputDO storageInput) {
        return storageInputDao.update(storageInput);
    }

    @Override
    public int remove(Long id) {
        return storageInputDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return storageInputDao.batchRemove(ids);
    }

}
