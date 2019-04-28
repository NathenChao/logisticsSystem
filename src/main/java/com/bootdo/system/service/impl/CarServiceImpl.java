package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.CarDao;
import com.bootdo.system.domain.CarDO;
import com.bootdo.system.service.CarService;


@Service
public class CarServiceImpl implements CarService {
    //自动装配
    @Autowired
    private CarDao carDao;

    @Override
    public CarDO get(Long id) {
        return carDao.get(id);
    }

    @Override
    public List<CarDO> list(Map<String, Object> map) {
        return carDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return carDao.count(map);
    }

    @Override
    public int save(CarDO car) {
        return carDao.save(car);
    }

    @Override
    public int update(CarDO car) {
        return carDao.update(car);
    }

    @Override
    public int remove(Long id) {
        return carDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return carDao.batchRemove(ids);
    }

}
