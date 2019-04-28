package com.bootdo.system.dao;

import com.bootdo.system.domain.StorageOutputDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author dc
 */
@Mapper
public interface StorageOutputDao {

    StorageOutputDO get(Long id);

    List<StorageOutputDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(StorageOutputDO storageOutput);

    int update(StorageOutputDO storageOutput);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
