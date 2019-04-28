package com.bootdo.system.service;

import com.bootdo.system.domain.LogisticsManageDO;

import java.util.List;
import java.util.Map;

public interface LogisticsManageService {

    LogisticsManageDO get(Long id);

    List<LogisticsManageDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(LogisticsManageDO logisticsManage);

    int update(LogisticsManageDO logisticsManage);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
