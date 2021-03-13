package transferCenterRoutePlanning.test;

import org.junit.Test;
import transferCenterRoutePlanning.service.Impl.TransportCenterServiceImpl;
import transferCenterRoutePlanning.service.TransportService;
import transferCenterRoutePlanning.Util.LatLng;

import java.util.Map;

public class TransportServiceTest {
    private TransportService transportService = new TransportCenterServiceImpl();

    @Test
    public void getLatLngMap() {
        Map<String,LatLng> latLngMap = transportService.getLatLngMap();


    }
}