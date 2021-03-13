package com.cton;


import com.cton.model.Cargo;
import com.cton.service.bussiness.TruckCargoMatchingService;
import com.cton.service.cargo.CargoService;
import com.github.skjolber.packing.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = TruckcargomatchApplication.class)
public class CargoTest {

    @Autowired
    private TruckCargoMatchingService truckCargoMatchingService;

    @Autowired
    private CargoService cargoService;

//    @Test
//    public void test3DTCM(){
//
//        List<Cargo> cargos = cargoService.listCargo();
//        for (Cargo cargo:cargos
//             ) {
//            double newMass = cargo.getMass() * 2;
//            cargo.setMass(newMass);
//            cargoService.updateByPrimaryKeySelective(cargo);
//        }
//
//    }
}
