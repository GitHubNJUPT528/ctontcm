package com.cton.service.truck;

import com.cton.model.Truck;

import java.util.List;

public interface TruckService {
    List<Truck> listAllTrucks();

    int createTruck(Truck truck);

    int deleteTruckById(Integer id);

    int updateTruck(Truck truck);

    Truck selectTruckById(Integer id);

}
