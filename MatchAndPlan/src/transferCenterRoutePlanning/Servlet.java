package transferCenterRoutePlanning;

import com.google.gson.Gson;
import org.junit.Test;
import transferCenterRoutePlanning.Util.LatLng;
import transferCenterRoutePlanning.Util.RoutePlanByGreey;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.ResponseCache;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Servlet extends BaseServlet {
    public TransportService transportService = new TransportCenterServiceImpl();
    public RoutePlanByGreey rtp = new RoutePlanByGreey();
    public Gson gson = new Gson();


    protected void routePlanToMap(HttpServletRequest request, HttpServletResponse response) throws IOException {
       //获取排序之前点集list
        List<LatLng> preList = transportService.getLatLngList();
        String preListString = gson.toJson(preList);
        //根据点集计算任意两点间距离
        rtp.getEachDistance(preList);
        //发起贪心算法得到排序后的点集
        List<LatLng> posList = rtp.PathPlan(preList,10);
        String posListString = gson.toJson(posList);
        //从数据库中获取未排序的带有名字的点集的Map
        Map<String,LatLng> preMap = transportService.getLatLngMap();
        String preMapString = gson.toJson(preMap);
        //定义排序后的Map
        Map<String,LatLng> posMap = new LinkedHashMap<>();
        //根据排序后的点集形成排序后的Map
        for (LatLng latLng : posList) {
            for(Map.Entry<String,LatLng> entry :preMap.entrySet()){
                if ((latLng.latitude == entry.getValue().latitude)&&(latLng.longitude==entry.getValue().longitude))
                {
                    posMap.put(entry.getKey(),latLng);
                    preMap.remove(entry);
                }

            }
        }

        String posMapString = gson.toJson(posMap);
        System.out.println(preMapString);
        System.out.println(posMapString);
        response.getWriter().write(posMapString);

    }

    protected void routePlanToList(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //获取排序之前点集list
        List<LatLng> preList = transportService.getLatLngList();
        String preListString = gson.toJson(preList);
        //根据点集计算任意两点间距离
        rtp.getEachDistance(preList);
        //发起贪心算法得到排序后的点集
        List<LatLng> posList = rtp.PathPlan(preList,10);
        String posListString = gson.toJson(posList);
        response.getWriter().write(posListString);
    }
}
