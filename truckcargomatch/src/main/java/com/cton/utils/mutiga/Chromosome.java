package com.cton.utils.mutiga;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Data
public class Chromosome {
    private boolean[] gene;
    private double score;
    private double cw[];
    private double w[];
    private double v[];

//    static double cw[]={20,10,35,9,30,8,38,30,35,40};
//    static double w[]={16,2,8,1,30, 5, 5, 3, 24, 5, 5, 2, 35, 3, 25, 4, 30, 3, 35, 5};
//    static double v[]={8320, 1040, 4160, 520, 15600, 2600, 2600, 1560, 12480, 2600, 2600, 1040, 18200, 1560, 13000, 2080, 15600, 1560, 18200, 2600};
//    static double h[]={0, 0, 10000, 10000, 0, 0, 0, 0, 0, 10000, 0, 0, 0, 0, 10000, 0, 0, 0, 0, 0};

    public Chromosome() {
    }

    public Chromosome(double cw[], double w[], double v[]) {
        this.cw = cw;
        this.w = w;
        this.v = v;
    }

//    public Chromosome(int cwSize, int wSize) {
//        cw = new double[cwSize];
//        w = new double[wSize];
//        v = new double[wSize];
//    }


    public Chromosome(int size,double cw[], double w[]) {
        double beifencw[] = new double[cw.length];
        if (size <= 0)
            return;
        gene = new boolean[size];
        int n[] = new int[w.length];
        for(int a=0;a<cw.length;a++){
            beifencw[a]=cw[a];
        }

        for(int j=0;j<w.length;j++){

            while(true){
                Random random= new Random();
                int a =random.nextInt(w.length);
                if(n[a]==1){
                    continue;
                }
                for(int b=0;b<cw.length;b++){
                    if(w[a]<=beifencw[b]){
                        n[a]=1;
                        beifencw[b]=beifencw[b]-w[a];
                        gene[cw.length*a+b]=true;
                        break;
                    }
                }
                n[a]=1;
                break;
            }
        }
    }

    public static Chromosome clone(Chromosome chromosome) {
        if (chromosome == null || chromosome.gene == null)
            return null;
        Chromosome copy = new Chromosome();
        copy.gene = new boolean[chromosome.gene.length];
        copy.score = chromosome.score;
        System.arraycopy(chromosome.gene, 0, copy.gene, 0, chromosome.gene.length);

        copy.setCw(chromosome.getCw());
        copy.setW(chromosome.getW());
        copy.setV(chromosome.getV());
        return copy;
    }

    /**
     * 交叉操作
     * @param p1:交叉对象1
     * @param p2:交叉对象2
     * @return 交叉后的对象
     */
    public List<Chromosome> genetic(Chromosome p1, Chromosome p2, double crossRate) {
        if (p1 == null ||p2 == null)
            return null;
        if (p1.gene == null || p2.gene == null) {
            return null;
        }
        if (p1.gene.length != p2.gene.length) {
            return null;
        }
        double[] cw = p1.getCw();
        double[] w = p1.getW();
        double[] v = p1.getV();


        Chromosome c1 = clone(p1);
        Chromosome c2 = clone(p2);
        if (Math.random() < crossRate) {
            int size = c1.gene.length;
            int roundA = (int)(Math.random() * size);
//            int roundB = (int)(Math.random() * size);
//
//            int max = Math.max(roundA, roundB);
//            int min = Math.min(roundA, roundB);

//            for (int i = min/cw.length*cw.length; i < max/cw.length+cw.length; i++) {
            for (int i = (roundA/cw.length)*cw.length; i < (roundA/cw.length)+cw.length; i++) {
                boolean temp = c1.gene[i];
                c1.gene[i] = c2.gene[i];
                c2.gene[i] = temp;
            }
        }

        //约束
        double ccw[][]=new double[2][cw.length];
        boolean x1=true;
        boolean x2=true;
        boolean gene1[] = c1.getGene();
        boolean gene2[] = c2.getGene();
        for(int i=0;i<c1.gene.length;i++){
            if(gene1[i]==true){
                ccw[0][i%cw.length] += w[i/cw.length];
            }
            if(gene2[i]==true){
                ccw[1][i%cw.length] += w[i/cw.length];
            }

        }
        for(int i=0;i<cw.length;i++){
            if(ccw[0][i]>cw[i]){x1=false;break;}
            if(ccw[1][i]>cw[i]){x2=false;break;}
        }

        List<Chromosome> chromosomes = new ArrayList<>();
        if(x1){
            chromosomes.add(c1);
        }
        else{
            chromosomes.add(p1);
        }
        if(x2){
            chromosomes.add(c2);
        }
        else {
            chromosomes.add(p2);
        }
//        System.out.println("交叉"+chromosomes);
//        System.out.println("交叉完了");
        return chromosomes;
    }

    public void mutation(int num) {
        Chromosome c1 = clone(this);
        if (num == 0)
            return;
        int size = c1.gene.length;
        double[] cw = c1.getCw();
        double[] w = c1.getW();
        double[] v = c1.getV();


        for (int i = 0; i < num; i++) {
            int at = (int)(Math.random() * size) % size;
            for(int b =(at/cw.length)*cw.length;b<at/cw.length+cw.length;b++){
                c1.gene[b]=false;
            }
            c1.gene[at] = !c1.gene[at];
        }

        //约束
        double ccw[]=new double[cw.length];
        boolean x1=true;
        boolean gene1[] = c1.getGene();
        for(int i=0;i<c1.gene.length;i++){
            if(gene1[i]==true){
                ccw[i%cw.length] += w[i/cw.length];
            }

        }
        for(int i=0;i<cw.length;i++){
            if(ccw[i]>cw[i]){x1=false;break;}
        }
        System.out.println(x1);
        if(false){

            if (num == 0)
                return;
            for (int i = 0; i < num; i++) {
                int at = (int)(Math.random() * size) % size;
                for(int b =(at/cw.length*cw.length);b<at/cw.length+cw.length;b++){
                    gene[b]=false;
                }
                gene[at] = !gene[at];
            }
        }
    }

    public int binary2dec() {
        if (gene == null)
            return 0;
        int num = 0;
        for (boolean b : gene) {
            num <<= 1;
            if (b)
                num++;
        }
        return num;
    }

    public boolean[] getGene() {
        return gene;
    }

    public void setGene(boolean[] gene) {
        this.gene = gene;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Chromosome{" +
                "gene=" + Arrays.toString(gene) +
                ", score=" + score +
                '}';
    }

//    public static void main(String[] args) {
//        Chromosome chromosome = new Chromosome();
//        chromosome.gene = new boolean[]{false, true, false, false};
//        System.out.println(chromosome.binary2dec());
//    }
}
