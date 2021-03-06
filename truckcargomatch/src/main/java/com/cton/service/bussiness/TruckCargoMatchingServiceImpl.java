package com.cton.service.bussiness;


import com.cton.model.Cargo;
import com.cton.model.MatchDTO;
import com.cton.service.cargo.CargoService;
import com.cton.utils.ga.GeneticAlgorithm;
import com.cton.utils.ga.Chromosome;
import com.github.skjolber.packing.*;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.*;

@Service
public class TruckCargoMatchingServiceImpl implements TruckCargoMatchingService {

    @Autowired
    private TruckCargoMatchingService truckCargoMatchingService;

    @Autowired
    private CargoService cargoService;


    @Override
    public List<Cargo> dynamicAlgorithm(List<Cargo> cargos, double load, double volume) {   ////可以输出一个车接单价值最大得货物清单

        //6.8 修改匹配算法为动态规划求解
        ArrayList<Cargo> cargoResultlist = new ArrayList<>();
        int numOfCargo = cargos.size();
        int loadOfTruck = (int) Math.ceil(load);
        int volumeOfTruck = (int) Math.ceil(volume);
        //创建三维数组，
        //v[i][j][k] 表示在前i个货物中能够装入载重为j，容量为k的货车中的最大价值
        double[][][] v = new double[numOfCargo + 1][loadOfTruck + 1][volumeOfTruck + 1];
        //为了记录放入货物的情况，我们定一个三维数组
        double[][][] path = new double[numOfCargo + 1][loadOfTruck + 1][volumeOfTruck + 1];

        //根据动态规划思想处理
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[i].length; j++) {
                for (int k = 1; k < v[i][j].length; k++) {
                    if (cargos.get(i - 1).getMass() > j || cargos.get(i - 1).getVolume() > k) { ////找到货物的jk
                        v[i][j][k] = v[i - 1][j][k];
                    } else {

                        if (v[i - 1][j][k] < cargos.get(i - 1).getPrice() +
                                v[i - 1][j - (int) Math.ceil(cargos.get(i - 1).getMass())][k - (int) Math.ceil(cargos.get(i - 1).getVolume())]) {

                            v[i][j][k] = cargos.get(i - 1).getPrice() +
                                    v[i - 1][j - (int) Math.ceil(cargos.get(i - 1).getMass())][k - (int) Math.ceil(cargos.get(i - 1).getVolume())];
                            path[i][j][k] = 1;
                        } else {
                            v[i][j][k] = v[i - 1][j][k];
                        }
                    }
                }
            }

        }

        //输出一下动态规划表的目前情况
//        for (int i = 0; i < v.length; i++) {
//            for (int j = 0; j < v[i].length; j++) {
//                for (int k = 0; k < v[i][j].length; k++) {
//                    System.out.print(v[i][j][k] + " ");
//                }
//            }
//            System.out.println();
//        }

        //取出动态规划得到的结果
        int i = path.length - 1;
        int j = path[0].length - 1;
        int k = path[0][0].length - 1;
        while (i > 0 && j > 0 && k > 0) {
            if (path[i][j][k] == 1) {
                j -= cargos.get(i - 1).getMass();
                k -= cargos.get(i - 1).getVolume();
                cargoResultlist.add(cargos.get(i - 1));
            }
            i--;
        }

        return cargoResultlist;
    }


    //遗传算法
    @Override
    public List<Cargo> gaAlgorithm(List<Cargo> cargos, double load, double volume) {
        if(cargos.size()<1){return null;}
        ArrayList<Cargo> cargoResultlist = new ArrayList<>();
        List<Cargo> cargosResult = new ArrayList<>();
        GeneticAlgorithm test = new GeneticAlgorithm();
        test.setCargo(cargos);
        int i=test.getcargo().size();
        test.setGeneSize(i);
        cargosResult = test.caculte(load,volume);
        for(Cargo cargo : cargosResult){
            cargoResultlist.add(cargo);
        }
//        Collections.sort(cargoResultlist, new Comparator<Cargo>() {
//            @Override
//            public int compare(Cargo o1, Cargo o2) {
//                if(o1.getPrice()<o2.getPrice()){
//                    return 1;
//                }
//                return -1;
//            }
//        });
        return cargoResultlist;
    }

    @Override
    public List<Object> aaa(double length, double width, double hight, double tvolume,double tmass) {
        List<Cargo> readyCargoes = cargoService.listCargoNoTaking();
        List<Cargo> cargoes = new ArrayList<>();
        Double temp_volume = 0.0;
        Double temp_mass = 0.0;
        for (Cargo cargo: readyCargoes
        ) {
            temp_volume += cargo.getVolume();
            temp_mass += cargo.getMass();
            if (temp_volume<=tvolume*1.5 && temp_mass <=tmass *1.5){
                cargoes.add(cargo);
            }else {
                break;
            }
        }
        Boolean flag = false;
        while (flag==false){
            List<Cargo> matchResult = truckCargoMatchingService.gaAlgorithm(cargoes,tmass,tvolume);
            System.out.println("匹配结束");

            List<Container> containers = new ArrayList<Container>();
            containers.add(new Container("truck",(int)length, (int)width, (int)hight, (int)tmass)); // x y z and weight

            Packager packager = LargestAreaFitFirstPackager.newBuilder().withContainers(containers).build();

            List<BoxItem> products = new ArrayList<BoxItem>();
            Double volume = 0.0;
            Double mass = 0.0;
            for (Cargo cargo:matchResult
            ) {
                products.add(new BoxItem(new Box("分公司"+cargo.getNetworkId()+"货物"+cargo.getId(), (int)Math.ceil(cargo.getLength()), (int)Math.ceil(cargo.getWidth()), (int)Math.ceil(cargo.getLength()), (int)Math.ceil(cargo.getMass())), 1));
                volume += cargo.getVolume();
                mass += cargo.getMass();
            }
            Container match = packager.pack(products);
            if (match == null){
                continue;
            }


            System.out.println(match);
            System.out.println("匹配的货物数量："+matchResult.size());
            NumberFormat nt = NumberFormat.getPercentInstance();//获取格式化对象
            nt.setMinimumFractionDigits(2);//设置百分数精确度2即保留两位小数
//            System.out.println("百分数1：" + nt.format(percent));//最后格式化并输出
            System.out.println("空间满载率为:"+nt.format(volume/match.getVolume())+","+"重量满载率为:"+nt.format(mass/match.getWeight()));
            flag = true;
            List<MatchDTO> matchDTOList = new ArrayList<>();
            for (int i=0; i<match.getLevels().get(0).size();i++) {
                MatchDTO matchDTO = new MatchDTO();
                matchDTO.setBoxName(match.getLevels().get(0).get(i).getBox().getName());
                matchDTO.setSpace(new int[]{match.getLevels().get(0).get(i).getSpace().getX(),match.getLevels().get(0).get(i).getSpace().getY(),match.getLevels().get(0).get(i).getSpace().getZ()});
                matchDTO.setLength(match.getLevels().get(0).get(i).getBox().getWidth());
                matchDTO.setWidth(match.getLevels().get(0).get(i).getBox().getDepth());
                matchDTO.setHight(match.getLevels().get(0).get(i).getBox().getHeight());
                matchDTO.setVolume((int)match.getLevels().get(0).get(i).getBox().getVolume());
                matchDTO.setMass(match.getLevels().get(0).get(i).getBox().getWeight());

                matchDTOList.add(matchDTO);
            }
            Map<String,Integer> resultMap = new HashMap();
            resultMap.put("volume",(int)Math.floor(volume));
            resultMap.put("mass",(int)Math.floor(mass));

            List<Object> resultList = new ArrayList<>();
            resultList.add(resultMap);
            resultList.add(matchDTOList);
            return resultList;
        }
        return null;
    }


}
