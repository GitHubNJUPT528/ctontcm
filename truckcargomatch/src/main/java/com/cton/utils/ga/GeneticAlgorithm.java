package com.cton.utils.ga;

import java.util.ArrayList;
import java.util.List;
import com.cton.model.Cargo;
import com.github.skjolber.packing.*;

public class GeneticAlgorithm {
    private List<Cargo> cargo;
    private List<Chromosome> population = new ArrayList<Chromosome>();//种群
    private int popSize = 100;//种群数量

    private int geneSize;//基因最大长度
    private int maxIterNum = 500;//最大迭代次数

    private double mutationRate = 0.01;//基因变异的概率
    private int maxMutationNum = 3;//最大变异步长

    private int generation = 1;//当前遗传到第几代

    private double bestScore;//最好得分
    private double worstScore;//最坏得分
    private double totalScore;//总得分
    private double averageScore;//平均得分
    private List<Cargo> temp = new ArrayList<Cargo>();//暂存产生的货物集合，判断是否合理
    private List<Cargo> x = new ArrayList<Cargo>(); //记录历史种群中最好的X值
    private double y; //记录历史种群中最好的Y值
    private int geneI;//x y所在代数
    private double mass;
    private double volume;
    private double temp_mass = 0;
    private double temp_volume = 0;
    private double whole_mass = 0;
    private double whole_volume = 0;
    private double whole_price = 0;
    private boolean flag1 = false;
    private boolean flag2 = false;

    //遗传主函数
    public List<Cargo> caculte(double mass1, double volume1) {
        //初始化种群
        generation = 1;
        setMassVolume(mass1, volume1);
        init();
        while (generation < maxIterNum) {
            //种群遗传
            evolve();
            generation++;

        }
//        printcargo(x);
      return x;
    }

//    private void printcargo(List<Cargo> c) {
//        System.out.println();
//        System.out.println("车辆载重为：" + mass + "\t体积为" + volume);
//        System.out.println();
//        System.out.println("待匹配的货物有：");
//        for (int count = 0; count < getcargo().size(); count++) {
//
//            System.out.println("货物" + getcargo().get(count).getId() + "\t重量：" + getcargo().get(count).getMass() + "\t体积：" + getcargo().get(count).getVolume()+"\t价格："+getcargo().get(count).getPrice());
//        }
//        System.out.println();
//        System.out.println("车货匹配成功，装载的货物编号为：");
//        for (int u = 0; u < c.size(); u++) {
//            whole_price += c.get(u).getPrice();
//            whole_mass += c.get(u).getMass();
//            whole_volume += c.get(u).getVolume();
//            System.out.print(c.get(u).getId() + "  ");
//        }

//        System.out.println();
//        System.out.println("本次车货匹配的总运费为:" + whole_price + "\t重量满载率为" + whole_mass / mass + "\t体积满载率为" + whole_volume / volume);

//    }

    private void setMassVolume(double mass1, double volume1) {
        mass = mass1;
        volume = volume1;
    }


    //初始化种群
    private void init() {
        population = new ArrayList<Chromosome>();
        for (int i = 0; i < popSize; i++) {

            while(true) {
                temp_mass = 0;
                temp_volume = 0;
                Chromosome chro = new Chromosome(geneSize);
                temp = changeX(chro, getcargo());
                for (int j = 0; j < temp.size(); j++) {
                    temp_mass += temp.get(j).getMass();
                    temp_volume += temp.get(j).getVolume();
                }
                if (temp_volume <= volume && temp_mass <= mass) {
                    population.add(chro);
                    break;
                }
            }
        }
        caculteScore();
    }

    //计算当前种群的最好最坏适应度
    private void caculteScore() {
        setChromosomeScore(population.get(0));//计算种群第一个个体的适应度
        bestScore = 0;
        worstScore = 999999;
        totalScore = 0;

        for (Chromosome chro : population) {
//            temp=changeX(chro,getcargo());
//            for (int j = 0; j <temp.size() ; j++) {
//                    temp_mass+=temp.get(j).getMass();
//                    temp_volume+=temp.get(j).getVolume();
//                }
//            if(temp_volume<=volume&&temp_mass<=mass){
            setChromosomeScore(chro);
            if (chro.getScore() > bestScore) { //设置最好基因值
                bestScore = chro.getScore();
                if (y < bestScore) {
                    x = changeX(chro, getcargo());
                    y = bestScore;
                    geneI = generation;
                }
//                }
                if (chro.getScore() < worstScore) { //设置最坏基因值
                    worstScore = chro.getScore();
                }
                totalScore += chro.getScore();
            }
            averageScore = totalScore / popSize;
            //因为精度问题导致的平均值大于最好值，将平均值设置成最好值
            averageScore = averageScore > bestScore ? bestScore : averageScore;
        }

    }

    private List<Cargo> changeX(Chromosome chro, List<Cargo> cargos) {
        boolean temp[] = chro.getGene();
        ArrayList<Cargo> cargoResultlist = new ArrayList<>();
        for (int i = 0; i < chro.getGene().length; i++) {
            if (temp[i] == true) {
                cargoResultlist.add(cargos.get(i));
            }
        }
        return cargoResultlist;
    }

    ;

    //计算基因的适应度，并设置
    private void setChromosomeScore(Chromosome chro) {
        if (chro == null) {
            return;
        }
        List<Cargo> x = changeX(chro, getcargo());
        double y = caculateY(x);
        chro.setScore(y);

    }

    private double caculateY(List<Cargo> cargos) {
        float whole_price = 0;
        for (int u = cargos.size() - 1; u >= 0; u--) {
            whole_price += cargos.get(u).getPrice();
        }
        /**
         * 加上装箱约束
         */
        List<Container> containers = new ArrayList<Container>();
        containers.add(new Container("truck",960, 230, 270, 25000)); // x y z and weight

        Packager packager = LargestAreaFitFirstPackager.newBuilder().withContainers(containers).build();

        List<BoxItem> products = new ArrayList<BoxItem>();
        for (Cargo cargo:cargos
        ) {
            products.add(new BoxItem(new Box("分公司"+cargo.getNetworkId()+"货物"+cargo.getId(), (int)Math.ceil(cargo.getLength()), (int)Math.ceil(cargo.getWidth()), (int)Math.ceil(cargo.getLength()), (int)Math.ceil(cargo.getMass())), 1));
            volume += cargo.getVolume();
            mass += cargo.getMass();
        }
        Container match = packager.pack(products);
        if (match == null){
            return 0;
        }
        //约束代码结束
        return whole_price;
    }

    //选择能够产生下一代的个体
    private Chromosome getParentChromosome() {
        double slice = Math.random() * totalScore;
        double sum = 0;
        for (Chromosome chro : population) {
            sum += chro.getScore();
            //转到对应的位置并且适应度不小于平均适应度
            if (sum > slice && chro.getScore() >= averageScore) {
                return chro;
            }
        }
        return null;
    }

    //生成下一代种群
    private void evolve() {
        List<Chromosome> childPopulation = new ArrayList<Chromosome>();


        while (childPopulation.size() < popSize) {
            Chromosome p1 = getParentChromosome();
            Chromosome p2 = getParentChromosome();
            List<Chromosome> children = Chromosome.genetic(p1, p2);
            if (children != null) {
                for (int i = 0; i < children.size(); i++) {
                    temp_mass = 0;
                    temp_volume = 0;
                    temp = changeX(children.get(i), getcargo());
                    for (int j = 0; j < temp.size(); j++) {
                        temp_mass += temp.get(j).getMass();
                        temp_volume += temp.get(j).getVolume();
                    }
                    if (temp_volume <= volume && temp_mass <= mass) {
                        childPopulation.add(children.get(i));
                    }
                }

            }
        }
        //新种群替换旧种群
        List<Chromosome> t = population;
        population = childPopulation;
        t.clear();
        t = null;
        //基因突变
        mutation();
        //计算新种群的适应度
        caculteScore();
    }




    //    基因变异
    private void mutation() {
        for (Chromosome chro : population) {
            if (Math.random() < mutationRate) { //发生基因突变
                while(true) {
                    temp_mass = 0;
                    temp_volume = 0;
                    int mutationNum = (int) (Math.random() * maxMutationNum);
                    chro.mutation(mutationNum);
                    temp = changeX(chro, getcargo());
                    for (int j = 0; j < temp.size(); j++) {
                        temp_mass += temp.get(j).getMass();
                        temp_volume += temp.get(j).getVolume();
                    }
                    if (temp_volume <= volume && temp_mass <= mass) {
                        break;
                    }
                }
            }
        }
    }

    public List<Cargo> getcargo() {
        return cargo;
    }

    public void setCargo(List<Cargo> cList) {
        this.cargo = cList;
    }


    public void setGeneSize(int geneSize) {
        this.geneSize = geneSize;
    }
}
