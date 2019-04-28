package com.bootdo.system.dao;

import com.bootdo.system.domain.LogisticsDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author dc
 */
@Mapper
public interface LogisticsDao {

    LogisticsDO get(Long id);

    List<LogisticsDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(LogisticsDO logistics);

    int update(LogisticsDO logistics);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
