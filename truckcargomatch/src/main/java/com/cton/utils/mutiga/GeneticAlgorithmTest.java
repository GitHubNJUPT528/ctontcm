package com.cton.utils.mutiga;


public class GeneticAlgorithmTest extends GeneticAlgorithm {

    private static final int NUM = 1 << 200;
//    private double cw[];
//    private double w[];
//    private double v[];
//    private int cwSize;
//    private int wSize;


    public GeneticAlgorithmTest(int gene) {
        super(gene);
    }

    /**
     * 函数值
     * @param x
     * @return
     */
    @Override
    public double calculateY(double x) {  // "10*sin(5*x)+7*abs(x-5)+10"
        return x;
    }

    /**
     * 根据基因序列转换成x轴得值
     * @param chromosome 基因序列
     * @return x轴的值
     */

    @Override
    public double changeX(Chromosome chromosome) {
        double x=0;
        //原本是把个体转为十进制再求值
        //现在要遍历个体求值
        boolean gene[] = chromosome.getGene();
        double[] cw2 = chromosome.getCw();
        for(int i=0;i<getGeneSize();i++){
            if(gene[i]==true){
//                x += v[i/cw.length] + h[i/cw.length];
                x += cw2[i/cw2.length];
            }

        }
//        x -=hsum;
        return x;
    }

    public double getSum(double[] asum) {
        double sum=0;
        for(double number : asum){
            sum+=number;
        }

        return sum;
    }
//    double hsum = getSum(h);
//    public static void main(String[] args) {
//        GeneticAlgorithmTest test = new GeneticAlgorithmTest();
//
//
//        test.calculate();
//
//    }
}
