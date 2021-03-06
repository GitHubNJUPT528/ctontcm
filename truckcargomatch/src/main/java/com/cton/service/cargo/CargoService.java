package com.cton.service.cargo;

import com.cton.model.Cargo;

import java.util.List;

public interface CargoService {
    List<Cargo> listCargoNoTaking();

    List<Cargo> listCargo();

    int deleteByPrimaryKey(Integer id);

    int insert(Cargo record);

    int insertSelective(Cargo record);

    Cargo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cargo record);

    int updateByPrimaryKey(Cargo record);
}
