package com.bootdo.system.dao;

import com.bootdo.system.domain.CustomerDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author dc
 */
@Mapper
public interface CustomerDao {

    CustomerDO get(Long id);

    List<CustomerDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(CustomerDO customer);

    int update(CustomerDO customer);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
