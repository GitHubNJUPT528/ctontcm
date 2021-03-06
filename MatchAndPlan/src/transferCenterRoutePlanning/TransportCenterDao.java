package transferCenterRoutePlanning;

import transferCenterRoutePlanning.Util.TransportCenter;

import java.util.List;

public interface TransportCenterDao {
    public List<TransportCenter> queryTransportCenter();
    public int queryMaxCargoByName(String name);
}
