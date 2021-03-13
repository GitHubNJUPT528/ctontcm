package com.cton.service.cargo;

import com.cton.mapper.CargoMapper;
import com.cton.model.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoMapper cargoMapper;

    @Override
    public List<Cargo> listCargoNoTaking() {
        return cargoMapper.listCargoNoTaking();
    }

    @Override
    public List<Cargo> listCargo() {
        return cargoMapper.listCargo();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return cargoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Cargo record) {
        return cargoMapper.insert(record);
    }

    @Override
    public int insertSelective(Cargo record) {
        return cargoMapper.insertSelective(record);
    }

    @Override
    public Cargo selectByPrimaryKey(Integer id) {
        return cargoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Cargo record) {
        return cargoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Cargo record) {
        return cargoMapper.updateByPrimaryKey(record);
    }
}
