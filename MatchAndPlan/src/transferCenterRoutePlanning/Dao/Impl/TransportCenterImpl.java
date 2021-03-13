package transferCenterRoutePlanning.Dao.Impl;

import transferCenterRoutePlanning.Dao.BaseDao;
import transferCenterRoutePlanning.Dao.TransportCenterDao;
import transferCenterRoutePlanning.Util.TransportCenter;

import java.util.List;

public class TransportCenterImpl extends BaseDao implements TransportCenterDao {
    @Override
    public List<TransportCenter> queryTransportCenter() {
        String sql = "select  id  ,  name  ,  city  ,  max_cargo_count  ,  address  ,  latitude  ,  longitude   from transportation_center";
        return queryForList(TransportCenter.class, sql);
    }

    @Override
    public int queryMaxCargoByName(String name) {
        String sql = "select  max_cargo_count from transportation_center where name = ?";
        Number number = (Number) queryForSingleValue(sql,name);

        return number.intValue();
    }
}
