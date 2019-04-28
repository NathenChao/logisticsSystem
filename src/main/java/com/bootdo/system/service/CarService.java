package com.bootdo.system.service;

import com.bootdo.system.domain.CarDO;

import java.util.List;
import java.util.Map;


public interface CarService {

    CarDO get(Long id);

    List<CarDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(CarDO car);

    int update(CarDO car);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
