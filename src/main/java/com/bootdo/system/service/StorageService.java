package com.bootdo.system.service;

import com.bootdo.system.domain.StorageDO;

import java.util.List;
import java.util.Map;


public interface StorageService {

    StorageDO get(Long id);

    List<StorageDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(StorageDO storage);

    int update(StorageDO storage);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
