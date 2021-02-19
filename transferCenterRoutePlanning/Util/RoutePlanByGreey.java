package Util;






import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoutePlanByGreey {

    private double[][] cityDistance;    //城市间距离
    private List<LatLng> newPointsArray = null;
    private List<LatLng> prePointsArray1;


    //计算点间距离,并设置最小距离
    public void getEachDistance(List<LatLng> allPoints) {
        cityDistance = new double[allPoints.size()][allPoints.size()];     //设置数组大小
        double min = 0;     //最短距离
        //点到自身距离设为0
        for(int k = 0;k < allPoints.size();k++) {
            cityDistance[k][k] = 0;
        }
        //根据公式计算上三角
        for (int i = 0;i < allPoints.size()-1;i++) {
            for (int j = i+1; j < allPoints.size(); j++) {
                double radLat1 = Rad(allPoints.get(i).latitude);
                double radLat2 = Rad(allPoints.get(j).latitude);
                double diffLat = Arith.sub(radLat1,radLat2);
                double diffLng = Arith.sub(Rad(allPoints.get(i).longitude) , Rad(allPoints.get(j).longitude));
                double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(Arith.div(diffLat,2)), 2)
                        + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(Arith.div(diffLng,2)), 2)));

                distance = Arith.mul(distance,6378.137);     //地球半径
                distance = Arith.div(Arith.round(Arith.mul(distance,10000),6),10000);
                distance = Arith.div(Arith.round(Arith.mul(distance,1000),2),1);     //单位修改为米,取整

                //计算最短距离
                if(min>distance) {
                    min = distance;
                }

                this.cityDistance[i][j] = Arith.round(distance,0);
                this.cityDistance[j][i] = Arith.round(distance,0);
            }

        }
    }

    //经纬度转换成三角函数中度分表形式
    private double Rad(double latOrLng) {
        return latOrLng * Math.PI / 180.0;
    }


    //传入起点进行路径规划并返回规划后点集
    public List<LatLng> PathPlan(List<LatLng> prePointsArray, int firstIndex) {
        newPointsArray = new ArrayList<>();
        //将更改点作为第一个点
        double shortestDis = Double.MAX_VALUE;		//初始设最短路径为最大值
        int[] index = new int[prePointsArray.size()];
        int count = 0;	//序列个数
        int startIndex = firstIndex;       //开始点的序号
        int nextIndex;       //下个点的序号
        boolean[] isSelectedArray = new boolean[prePointsArray.size()];

        LatLng startPoint = null;	//起始点


        //preData.data = reArrangeData;
        //起始都是未选择状态
        for(int i=0;i<prePointsArray.size();i++) {
            isSelectedArray[i] = false;
        }
        startPoint = prePointsArray.get(startIndex);
        newPointsArray.add(startPoint);	//加入初始起点
        isSelectedArray[startIndex] = true;

        index[count] = 0;

        count++;
        for(int i=1;i<prePointsArray.size();i++) {
            //寻找距离最短的点,除
            for(int j=0;j<prePointsArray.size() ;j++) {//已归入序列不需要再遍历
                if(isSelectedArray[j] == true)
                    continue;
                nextIndex = j;
                double dis = cityDistance[startIndex][nextIndex];
                if(dis < shortestDis){
                    shortestDis = dis;
                    index[count] = j;	//最短距离的起点加入序列
                }
            }
            newPointsArray.add(prePointsArray.get(index[count]));  //加入距离最近点

            isSelectedArray[index[count]] = true;
            startIndex = index[count++];		//终点成为新的起点
            shortestDis = Double.MAX_VALUE;
        }
        String str = "";
        for(int i = 0;i<index.length;i++) {
            str += index[i]+" ";
        }

        return newPointsArray;
    }


    //传入起点进行路径规划,返回序号
    public int[] PathPlanReturnIndex(int firstIndex) {
        newPointsArray = new ArrayList<>();
        //将更改点作为第一个点
        double shortestDis = Double.MAX_VALUE;		//初始设最短路径为最大值
        int[] index = new int[prePointsArray1.size()];
        int count = 0;	//序列个数
        int startIndex = firstIndex;       //开始点的序号
        int nextIndex;       //下个点的序号
        boolean[] isSelectedArray = new boolean[prePointsArray1.size()];

        LatLng startPoint = null;	//起始点


        //preData.data = reArrangeData;
        //起始都是未选择状态
        for(int i=0;i<prePointsArray1.size();i++) {
            isSelectedArray[i] = false;
        }
        startPoint = prePointsArray1.get(startIndex);
        newPointsArray.add(startPoint);	//加入初始起点
        isSelectedArray[startIndex] = true;

        index[count] = firstIndex;

        count++;
        for(int i=1;i<prePointsArray1.size();i++) {
            //寻找距离最短的点,除
            for(int j=0;j<prePointsArray1.size() ;j++) {//已归入序列不需要再遍历
                if(isSelectedArray[j] == true)
                    continue;
                nextIndex = j;
                double dis = cityDistance[startIndex][nextIndex];
                if(dis < shortestDis){
                    shortestDis = dis;
                    index[count] = j;	//最短距离的起点加入序列
                }
            }
            newPointsArray.add(prePointsArray1.get(index[count]));  //加入距离最近点

            isSelectedArray[index[count]] = true;
            startIndex = index[count++];		//终点成为新的起点
            shortestDis = Double.MAX_VALUE;
        }
        String str = "";
        for(int i = 0;i<index.length;i++) {
            str += index[i]+" ";
        }
        return index;
    }


    //传入起点进行路径规划,返回序号
    public int[] PathPlanReturnIndex(List<LatLng> prePointsArray, int firstIndex) {
        newPointsArray = new ArrayList<>();
        //将更改点作为第一个点
        double shortestDis = Double.MAX_VALUE;		//初始设最短路径为最大值
        int[] index = new int[prePointsArray.size()];
        int count = 0;	//序列个数
        int startIndex = firstIndex;       //开始点的序号
        int nextIndex;       //下个点的序号
        boolean[] isSelectedArray = new boolean[prePointsArray.size()];

        LatLng startPoint = null;	//起始点


        //preData.data = reArrangeData;
        //起始都是未选择状态
        for(int i=0;i<prePointsArray.size();i++) {
            isSelectedArray[i] = false;
        }
        startPoint = prePointsArray.get(startIndex);
        newPointsArray.add(startPoint);	//加入初始起点
        isSelectedArray[startIndex] = true;

        index[count] = startIndex;

        count++;
        for(int i=1;i<prePointsArray.size();i++) {
            //寻找距离最短的点,除
            for(int j=0;j<prePointsArray.size() ;j++) {//已归入序列不需要再遍历
                if(isSelectedArray[j] == true)
                    continue;
                nextIndex = j;
                double dis = cityDistance[startIndex][nextIndex];
                if(dis < shortestDis){
                    shortestDis = dis;
                    index[count] = j;	//最短距离的起点加入序列
                }
            }
            newPointsArray.add(prePointsArray.get(index[count]));  //加入距离最近点

            isSelectedArray[index[count]] = true;
            startIndex = index[count++];		//终点成为新的起点
            shortestDis = Double.MAX_VALUE;
        }
        String str = "***第二小区顺序***：";
        for(int i = 0;i<index.length;i++) {
            str += index[i]+" ";
        }
        return index;
    }

    //包含已签收和未签收，但不需要更改起始地点
    public int[] PathPlanReturnIndex(int firstUnSignedId,String[] lat, String[] lng) {
        this.prePointsArray1 = new ArrayList<>();  //点集

        //封装点集
        for(int i=firstUnSignedId;i < lat.length;i++)
            this.prePointsArray1.add(new LatLng(Double.parseDouble(lat[i]),Double.parseDouble(lng[i])));

        //计算点间距离数组
        getEachDistance(this.prePointsArray1);
        newPointsArray = new ArrayList<>();
        //将更改点作为第一个点
        double shortestDis = Double.MAX_VALUE;		//初始设最短路径为最大值
        int[] index = new int[this.prePointsArray1.size()];
        int count = 0;	//序列个数
        int startIndex = firstUnSignedId;       //开始点的序号
        int nextIndex;       //下个点的序号
        boolean[] isSelectedArray = new boolean[this.prePointsArray1.size()];

        LatLng startPoint;	//起始点

        //preData.data = reArrangeData;
        //起始都是未选择状态
        for(int i=0;i<this.prePointsArray1.size();i++) {
            isSelectedArray[i] = false;
        }
        startPoint = this.prePointsArray1.get(startIndex);
        newPointsArray.add(startPoint);	//加入初始起点
        isSelectedArray[startIndex] = true;
        index[count] = startIndex;

        count++;
        for(int i=1;i<this.prePointsArray1.size();i++) {
            //寻找距离最短的点,除
            for(int j=0;j<this.prePointsArray1.size() ;j++) {//已归入序列不需要再遍历
                if(isSelectedArray[j] == true)
                    continue;
                nextIndex = j;
                double dis = this.cityDistance[startIndex][nextIndex];
                if(dis < shortestDis){
                    shortestDis = dis;
                    index[count] = j;	//最短距离的起点加入序列
                }
            }
            newPointsArray.add(this.prePointsArray1.get(index[count]));  //加入距离最近点

            isSelectedArray[index[count]] = true;
            startIndex = index[count++];		//终点成为新的起点
            shortestDis = Double.MAX_VALUE;
        }
        String str = "";
        for(int i = 0;i<index.length;i++) {
            str += index[i]+" ";
        }


        int[] newIndexArray = new int[lat.length];
        //已签收序号
        int i;
        for(i=0;i<=firstUnSignedId;i++) {
            newIndexArray[i]=i;
        }
        //未签收已排序的序号
        int j = 0;
        for(i--;i<lat.length;i++) {
            newIndexArray[i] = index[j++]+firstUnSignedId;
        }

        str = "当不在同一个小区时,先排第一个小区（不需更改点）：";
        for(i = 0;i<newIndexArray.length;i++) {
            str += newIndexArray[i]+" ";
        }
        return newIndexArray;
    }

    //传入起点进行路径规划,返回序号（传入的点集在同一个小区）包含已签收和未签收，需要更改起始地点
    public int[] PathPlanReturnIndex(int changedId,int firstUnSignedId,String[] lat, String[] lng) {
        this.prePointsArray1 = new ArrayList<>();  //点集

        //封装点集
        for(int i=firstUnSignedId;i < lat.length;i++)
            this.prePointsArray1.add(new LatLng(Double.parseDouble(lat[i]),Double.parseDouble(lng[i])));

        //计算点间距离数组
        getEachDistance(this.prePointsArray1);
        newPointsArray = new ArrayList<>();
        //将更改点作为第一个点
        double shortestDis = Double.MAX_VALUE;		//初始设最短路径为最大值
        int[] index = new int[this.prePointsArray1.size()];
        int count = 0;	//序列个数
        int startIndex = changedId - firstUnSignedId;       //开始点的序号
        int nextIndex;       //下个点的序号
        boolean[] isSelectedArray = new boolean[this.prePointsArray1.size()];

        LatLng startPoint;	//起始点

        //preData.data = reArrangeData;
        //起始都是未选择状态
        for(int i=0;i<this.prePointsArray1.size();i++) {
            isSelectedArray[i] = false;
        }
        startPoint = this.prePointsArray1.get(startIndex);
        newPointsArray.add(startPoint);	//加入初始起点
        isSelectedArray[startIndex] = true;
        index[count] = startIndex;

        count++;
        for(int i=1;i<this.prePointsArray1.size();i++) {
            //寻找距离最短的点,除
            for(int j=0;j<this.prePointsArray1.size() ;j++) {//已归入序列不需要再遍历
                if(isSelectedArray[j] == true)
                    continue;
                nextIndex = j;
                double dis = this.cityDistance[startIndex][nextIndex];
                if(dis < shortestDis){
                    shortestDis = dis;
                    index[count] = j;	//最短距离的起点加入序列
                }
            }
            newPointsArray.add(this.prePointsArray1.get(index[count]));  //加入距离最近点

            isSelectedArray[index[count]] = true;
            startIndex = index[count++];		//终点成为新的起点
            shortestDis = Double.MAX_VALUE;
        }
        String str = "";
        for(int i = 0;i<index.length;i++) {
            str += index[i]+" ";
        }


        int[] newIndexArray = new int[lat.length];
        //已签收序号
        int i;
        for(i=0;i<=firstUnSignedId;i++) {
            newIndexArray[i]=i;
        }
        //未签收已排序的序号
        int j = 0;
        for(i--;i<lat.length;i++) {
            newIndexArray[i] = index[j++]+firstUnSignedId;
        }

        str = "";
        for(i = 0;i<newIndexArray.length;i++) {
            str += newIndexArray[i]+" ";
        }
        return newIndexArray;
    }

    /*
        （按小区分组），更改后的地点在同一个小区
     */
    public int[] PathPlanReturnIndexInSameCommunity(int changedId,int firstUnSignedId,
                                                    String[] lat, String[] lng,int cutNum) {

        int[] firstHalfIndexArray;
        //在同一个小区的条件下：1.在第一个小区，需要分开规划；2.在第二个小区，则直接规划
        if(firstUnSignedId < cutNum) {      //在第一个小区
            firstHalfIndexArray = new int[cutNum];    //将前一半封装排序
            String[] firstHalfLat = Arrays.copyOf(lat,cutNum);
            String[] firstHalfLng = Arrays.copyOf(lng,cutNum);

            System.arraycopy(PathPlanReturnIndex(changedId,firstUnSignedId,
                    firstHalfLat,firstHalfLng),0,firstHalfIndexArray,0,cutNum);     //获得前cutNum个地点的顺序

            //firstHalfIndexArray中暂时存放前一个小区排序后的顺序，再从其中最后一个以贪心法开始连接第二个小区
            int lastOfFirstCommunityIndex = firstHalfIndexArray[cutNum-1];  //第一个小区的最后一个位置

            this.prePointsArray1 = new ArrayList<>();  //点集
            this.prePointsArray1.add(new LatLng(Double.parseDouble(lat[lastOfFirstCommunityIndex]),
                    Double.parseDouble(lng[lastOfFirstCommunityIndex])));   //将最后一个点作为第二个小区开始的起点

            //封装第二个小区点集
            for(int i=cutNum;i < lat.length;i++)
                this.prePointsArray1.add(new LatLng(Double.parseDouble(lat[i]),Double.parseDouble(lng[i])));

            //获取第二个小区排序序号
            int[] secondHalfIndexArray = new int[lat.length-cutNum];

            getEachDistance(prePointsArray1);
            System.arraycopy(PathPlanReturnIndex(0),1,secondHalfIndexArray,
                    0,PathPlanReturnIndex(0).length-1);
            for(int i=0;i<secondHalfIndexArray.length;i++)
                secondHalfIndexArray[i] += cutNum-1;

            firstHalfIndexArray = Arrays.copyOf(firstHalfIndexArray, lat.length);//数组扩容
            System.arraycopy(secondHalfIndexArray, 0, firstHalfIndexArray,
                    cutNum, secondHalfIndexArray.length);

            String str = "都在第一个小区时：";
            for(int i = 0;i<firstHalfIndexArray.length;i++) {
                str += firstHalfIndexArray[i]+" ";
            }
            return firstHalfIndexArray;
        }

        else {
            return PathPlanReturnIndex(changedId,firstUnSignedId,lat,lng);
        }


    }



    /*
        （按小区分组），不在同一个小区，分开排序再合并
     */
    public int[] PathPlanReturnIndexInDifferentCommunity(int changedId,int firstUnSignedId,
                                                         String[] lat, String[] lng,int cutNum) {

        int[] firstHalfIndexArray;
        /*
            更换的地点在第二个小区：1.先规划第一个小区，再将更换点置于第二个小区的起始点
         */

        //在第一个小区
        firstHalfIndexArray = new int[cutNum];    //将前一半封装排序
        String[] firstHalfLat = Arrays.copyOf(lat,cutNum);
        String[] firstHalfLng = Arrays.copyOf(lng,cutNum);

        System.arraycopy(PathPlanReturnIndex(firstUnSignedId,
                firstHalfLat,firstHalfLng),0,firstHalfIndexArray,0,cutNum);     //获得前cutNum个地点的顺序

        /*
            firstHalfIndexArray中暂时存放前一个小区排序后的顺序，然后不根据当前点实行贪心，
            而是直接将第二个小区的更换点设为起点
         */

        this.prePointsArray1 = new ArrayList<>();  //点集
        /*this.prePointsArray1.add(new LatLng(Double.parseDouble(lat[changedId]),
                Double.parseDouble(lng[changedId])));   //将更改点作为第二个小区开始的起点*/

        //封装第二个小区点集
        for(int i=cutNum;i < lat.length;i++) {
            //if(i!=changedId)
            this.prePointsArray1.add(new LatLng(Double.parseDouble(lat[i]), Double.parseDouble(lng[i])));
        }

        getEachDistance(prePointsArray1);

        //获取第二个小区排序序号
        int[] secondHalfIndexArray = new int[lat.length-cutNum];
        /*System.arraycopy(PathPlanReturnIndex(0),0,secondHalfIndexArray,
                0,PathPlanReturnIndex(0).length);*/
        System.arraycopy(PathPlanReturnIndex(prePointsArray1,changedId-cutNum),0,secondHalfIndexArray,
                0,PathPlanReturnIndex(0).length);
        for(int i=0;i<secondHalfIndexArray.length;i++)
            secondHalfIndexArray[i] += cutNum;

        firstHalfIndexArray = Arrays.copyOf(firstHalfIndexArray, lat.length);//数组扩容
        System.arraycopy(secondHalfIndexArray, 0, firstHalfIndexArray,
                cutNum, secondHalfIndexArray.length);

        String str = "更换点和下个派件点分别在两个小区：";
        for(int i = 0;i<firstHalfIndexArray.length;i++) {
            str += firstHalfIndexArray[i]+" ";
        }
        return firstHalfIndexArray;

    }


    //传入起点进行路径规划,返回序号（传入的点集在同一个小区）包含已签收和未签收，需要更改起始地点
    public int[] PathPlanReturnIndex1(int changedId,int firstUnSignedId,String[] lat, String[] lng) {
        this.prePointsArray1 = new ArrayList<>();  //点集

        //封装点集
        for(int i=firstUnSignedId;i < lat.length;i++)
            this.prePointsArray1.add(new LatLng(Double.parseDouble(lat[i]),Double.parseDouble(lng[i])));

        //计算点间距离数组
        getEachDistance(this.prePointsArray1);
        newPointsArray = new ArrayList<>();
        //将更改点作为第一个点
        double shortestDis = Double.MAX_VALUE;		//初始设最短路径为最大值
        int[] index = new int[this.prePointsArray1.size()];
        int count = 0;	//序列个数
        int startIndex = changedId - firstUnSignedId;       //开始点的序号
        int nextIndex;       //下个点的序号
        boolean[] isSelectedArray = new boolean[this.prePointsArray1.size()];

        LatLng startPoint;	//起始点

        //preData.data = reArrangeData;
        //起始都是未选择状态
        for(int i=0;i<this.prePointsArray1.size();i++) {
            isSelectedArray[i] = false;
        }
        startPoint = this.prePointsArray1.get(startIndex);
        newPointsArray.add(startPoint);	//加入初始起点
        isSelectedArray[startIndex] = true;
        index[count] = startIndex;

        count++;
        for(int i=1;i<this.prePointsArray1.size();i++) {
            //寻找距离最短的点,除
            for(int j=0;j<this.prePointsArray1.size() ;j++) {//已归入序列不需要再遍历
                if(isSelectedArray[j] == true)
                    continue;
                nextIndex = j;
                double dis = this.cityDistance[startIndex][nextIndex];
                if(dis < shortestDis){
                    shortestDis = dis;
                    index[count] = j;	//最短距离的起点加入序列
                }
            }
            newPointsArray.add(this.prePointsArray1.get(index[count]));  //加入距离最近点

            isSelectedArray[index[count]] = true;
            startIndex = index[count++];		//终点成为新的起点
            shortestDis = Double.MAX_VALUE;
        }
        String str = "";
        for(int i = 0;i<index.length;i++) {
            str += index[i]+" ";
        }


        int[] newIndexArray = new int[lat.length];
        //已签收序号
        int i;
        for(i=0;i<=firstUnSignedId;i++) {
            newIndexArray[i]=i;
        }
        //未签收已排序的序号
        int j = 0;
        for(i--;i<lat.length;i++) {
            newIndexArray[i] = index[j++]+firstUnSignedId;
        }

        str = "";
        for(i = 0;i<newIndexArray.length;i++) {
            str += newIndexArray[i]+" ";
        }
        return newIndexArray;
    }



}
