package transferCenterRoutePlanning;

import transferCenterRoutePlanning.Util.LatLng;
import transferCenterRoutePlanning.Util.TransportCenter;

import java.util.List;
import java.util.Map;

public interface TransportService {
    public Map<String,LatLng> getLatLngMap();
    public List<LatLng> getLatLngList();
    public int getMaxCargoByName(String name);
}
