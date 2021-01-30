package com.cton.service.truck;

import com.cton.mapper.TruckMapper;
import com.cton.model.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TruckServiceImpl implements TruckService {

    @Autowired
    private TruckMapper truckMapper;

    @Override
    public List<Truck> listAllTrucks() {
        return truckMapper.listAllTrucks();
    }

    @Override
    public int createTruck(Truck truck) {
        return truckMapper.insertSelective(truck);
    }

    @Override
    public int deleteTruckById(Integer id) {
        return truckMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateTruck(Truck truck) {
        return truckMapper.updateByPrimaryKeySelective(truck);
    }

    @Override
    public Truck selectTruckById(Integer id) {
        return truckMapper.selectByPrimaryKey(id);
    }
}
