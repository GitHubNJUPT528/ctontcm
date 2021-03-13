package com.cton;


import com.cton.model.Cargo;
import com.cton.model.OssEntity;
import com.cton.service.cargo.CargoService;
import com.cton.service.oss.AliOssService;
import com.github.skjolber.packing.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cton.service.bussiness.*;

import com.cton.utils.ga.Chromosome;
import com.cton.utils.ga.GeneticAlgorithm;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = TruckcargomatchApplication.class)
public class OssTest {

//    @Autowired
//    private OssEntity ossEntity;
//
    @Autowired
    private TruckCargoMatchingService truckCargoMatchingService;

    @Autowired
    private CargoService cargoService;

    @Test
    public void test3DTCM(){

        // initialization
//        List<Container> containers = new ArrayList<Container>();
//        containers.add(new Container("truck",10, 5, 6, 300)); // x y z and weight
//        Packager packager = LargestAreaFitFirstPackager.newBuilder().withContainers(containers).build();
//
//        List<BoxItem> products = new ArrayList<BoxItem>();
//        products.add(new BoxItem(new Box("cargo1", 6, 5, 5, 135), 1));
//        products.add(new BoxItem(new Box("cargo2", 10, 2, 1, 10), 1));
//        products.add(new BoxItem(new Box("cargo3", 4, 5, 4, 130), 1));
//        products.add(new BoxItem(new Box("cargo4", 10, 3, 1, 25), 1));

        List<Cargo> readyCargoes = cargoService.listCargoNoTaking();
        List<Cargo> cargoes = new ArrayList<>();
        Double temp_volume = 0.0;
        Double temp_mass = 0.0;
        for (Cargo cargo: readyCargoes
             ) {
            temp_volume += cargo.getVolume();
            temp_mass += cargo.getMass();
            if (temp_volume<=59616000*1.5 && temp_mass <=25000 *1.5){
                cargoes.add(cargo);
            }else {
                break;
            }
        }
        Boolean flag = false;
        while (flag==false){
            List<Cargo> matchResult = truckCargoMatchingService.gaAlgorithm(cargoes,25000,59616000);
            System.out.println("匹配结束");

            List<Container> containers = new ArrayList<Container>();
            containers.add(new Container("truck",960, 230, 270, 25000)); // x y z and weight

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
            NumberFormat nt = NumberFormat.getPercentInstance();//获取格式化对象
            nt.setMinimumFractionDigits(2);//设置百分数精确度2即保留两位小数
//            System.out.println("百分数1：" + nt.format(percent));//最后格式化并输出
            System.out.println("空间满载率为:"+nt.format(volume/match.getVolume())+","+"重量满载率为:"+nt.format(mass/match.getWeight()));
            flag = true;
        }


//        products.add(new BoxItem(new Box("cargo4", 1, 1, 1, 2), 1));
//        products.add(new BoxItem(new Box("cargo5", 2, 1, 1, 1), 1));
//        products.add(new BoxItem(new Box("cargo6", 1, 2, 1, 1), 1));
//        products.add(new BoxItem(new Box("cargo7", 1, 1, 2, 1), 1));
//        products.add(new BoxItem(new Box("cargo8", 3, 1, 1, 1), 1));
//        products.add(new BoxItem(new Box("cargo9", 1, 3, 1, 1), 1));
//        products.add(new BoxItem(new Box("cargo10", 1, 1, 3, 1), 1));
//        products.add(new BoxItem(new Box("cargo11", 4, 1, 1, 1), 1));
//        products.add(new BoxItem(new Box("cargo12", 1, 4, 1, 1), 1));
//        products.add(new BoxItem(new Box("cargo13", 1, 1, 4, 1), 1));
//        products.add(new BoxItem(new Box("cargo14", 2, 2, 1, 1), 1));
//        products.add(new BoxItem(new Box("cargo15", 1, 2, 2, 1), 1));
//        products.add(new BoxItem(new Box("cargo16", 2, 1, 2, 1), 1));
//        products.add(new BoxItem(new Box("cargo17", 2, 3, 1, 1), 1));
//        products.add(new BoxItem(new Box("cargo18", 1, 2, 3, 1), 1));
//        products.add(new BoxItem(new Box("cargo19", 2, 1, 3, 1), 1));
//        products.add(new BoxItem(new Box("cargo20", 3, 2, 1, 1), 1));
//        products.add(new BoxItem(new Box("cargo21", 1, 3, 2, 1), 1));
//        products.add(new BoxItem(new Box("cargo22", 3, 1, 2, 1), 1));
//        products.add(new BoxItem(new Box("cargo23", 3, 3, 1, 1), 1));
//        products.add(new BoxItem(new Box("cargo24", 1, 3, 3, 1), 1));
//        products.add(new BoxItem(new Box("cargo25", 3, 1, 3, 1), 1));
//        products.add(new BoxItem(new Box("cargo26", 2, 2, 2, 1), 1));

        // match a single container
//        Container match = packager.pack(products);
//        System.out.println(match);

    }
}
