package com.bootdo.system.service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.domain.LogisticsDO;


public interface LogisticsService {

    LogisticsDO get(Long id);

    List<LogisticsDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(LogisticsDO logistics);

    int update(LogisticsDO logistics);

    int remove(Long id);

    int batchRemove(Long[] ids);

}
