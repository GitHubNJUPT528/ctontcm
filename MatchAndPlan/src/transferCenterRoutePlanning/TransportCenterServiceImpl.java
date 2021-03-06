package transferCenterRoutePlanning;

import com.google.gson.Gson;
import transferCenterRoutePlanning.Util.LatLng;
import transferCenterRoutePlanning.Util.TransportCenter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TransportCenterServiceImpl implements TransportService {
    private TransportCenterDao transportCenterDao = new TransportCenterImpl();

    @Override
    public List<LatLng> getLatLngList() {
        List<TransportCenter> centerInfoList = transportCenterDao.queryTransportCenter();
        List<LatLng> list = new ArrayList<>();
        for (TransportCenter transportCenter : centerInfoList) {
            list.add(new LatLng(transportCenter.getLatitude(),transportCenter.getLongitude()));
        }
        return list;
    }

    @Override
    public Map<String,LatLng> getLatLngMap() {
        List<TransportCenter> centerInfoList = transportCenterDao.queryTransportCenter();
        Map<String,LatLng> map = new LinkedHashMap<>();
        for (TransportCenter transportCenter : centerInfoList) {
            LatLng latLng = new LatLng(transportCenter.getLatitude(),transportCenter.getLongitude());
            map.put(transportCenter.getName(),latLng);

        }
        return map;
    }

    @Override
    public int getMaxCargoByName(String name) {
        return transportCenterDao.queryMaxCargoByName(name);

    }


}
