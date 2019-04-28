package com.bootdo.system.service;

import com.bootdo.system.domain.StorageInputDO;

import java.util.List;
import java.util.Map;


public interface StorageInputService {

    StorageInputDO get(Long id);

    List<StorageInputDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(StorageInputDO storageInput);

    int update(StorageInputDO storageInput);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
