package com.cton.service.bussiness;



import com.cton.model.Cargo;
import com.cton.model.MatchDTO;
import com.github.skjolber.packing.Container;

import java.util.List;

public interface TruckCargoMatchingService {



    //拼单分离出的动态规划算法
    List<Cargo> dynamicAlgorithm(List<Cargo> cargos, double load, double volume);

    //遗传算法
    List<Cargo> gaAlgorithm(List<Cargo> cargos, double load, double volume);

    //带装箱的匹配
    List<Object> aaa(double length, double width, double hight, double tvolume, double tmass);
}

