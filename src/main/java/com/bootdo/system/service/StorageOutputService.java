package com.bootdo.system.service;

import com.bootdo.system.domain.StorageOutputDO;

import java.util.List;
import java.util.Map;


public interface StorageOutputService {

    StorageOutputDO get(Long id);

    List<StorageOutputDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(StorageOutputDO storageOutput);

    int update(StorageOutputDO storageOutput);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
