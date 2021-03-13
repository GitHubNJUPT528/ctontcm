package com.cton.mapper;

import com.cton.model.Truck;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TruckMapper {
    List<Truck> listAllTrucks();

    int insertSelective(Truck truck);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Truck truck);

    Truck selectByPrimaryKey(Integer id);

}
