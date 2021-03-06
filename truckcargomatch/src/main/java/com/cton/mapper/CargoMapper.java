package com.cton.mapper;

import com.cton.model.Cargo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CargoMapper {

    List<Cargo> listCargoNoTaking();

    List<Cargo> listCargo();

    int deleteByPrimaryKey(Integer id);

    int insert(Cargo record);

    int insertSelective(Cargo record);

    Cargo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cargo record);

    int updateByPrimaryKey(Cargo record);
}
