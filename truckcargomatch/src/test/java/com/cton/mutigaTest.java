package com.cton;


import com.cton.model.Cargo;
import com.cton.model.Truck;
import com.cton.service.bussiness.TruckCargoMatchingService;
import com.cton.service.cargo.CargoService;
import com.cton.service.truck.TruckService;
import com.cton.utils.mutiga.Chromosome;
import com.cton.utils.mutiga.GeneticAlgorithm;
import com.cton.utils.mutiga.GeneticAlgorithmTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = TruckcargomatchApplication.class)
public class mutigaTest {

    @Autowired
    private TruckCargoMatchingService truckCargoMatchingService;

    @Autowired
    private TruckService truckService;

    @Autowired
    private CargoService cargoService;

    @Test
    public void test3DTCM(){

        int cwCount=0;
        int wCount=0;
        int vCount=0;
        List<Cargo> Cargoes = cargoService.listCargoNoTaking();
        Double temp_volume = 0.0;
        Double temp_mass = 0.0;
        List<Cargo> readyCargoes = new ArrayList<>();
        for (Cargo cargo: Cargoes
        ) {
            temp_volume += cargo.getVolume();
            temp_mass += cargo.getMass();
            if (temp_volume<=60000000 && temp_mass <=30000){
                readyCargoes.add(cargo);
            }else {
                break;
            }
        }
        List<Truck> truckList = truckService.listAllTrucks();
        for (Truck truck:truckList) {
            if(truck.getCount()>0){
                cwCount += truck.getCount();
            }
        }

        double cw1[] = new double[cwCount];
        double w1[] = new double[readyCargoes.size()];
        double v1[] = new double[readyCargoes.size()];
        int i =0,j=0;
        for (Truck truck:truckList) {
            int count = truck.getCount();
            while(count-- >0){
                cw1[i] = truck.getTruckLoad();
                i++;
            }
        }
        for (Cargo cargo:readyCargoes) {
            w1[j]= cargo.getMass();
            v1[j]=cargo.getPrice();
            j++;
        }

        GeneticAlgorithmTest geneticAlgorithmTest= new GeneticAlgorithmTest(cw1.length* w1.length);
        geneticAlgorithmTest.calculate(cw1,w1,v1);

//        GeneticAlgorithmTest test = new GeneticAlgorithmTest();
//        test.calculate();
    }
}
