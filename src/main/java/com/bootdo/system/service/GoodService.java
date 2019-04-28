package com.bootdo.system.service;

import com.bootdo.system.domain.GoodDO;

import java.util.List;
import java.util.Map;


public interface GoodService {

    GoodDO get(Long id);

    List<GoodDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(GoodDO good);

    int update(GoodDO good);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
