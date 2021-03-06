package transferCenterRoutePlanning;

import org.junit.Test;
import transferCenterRoutePlanning.Util.LatLng;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class TransportServiceTest {
    private TransportService transportService = new TransportCenterServiceImpl();

    @Test
    public void getLatLngMap() {
        Map<String,LatLng> latLngMap = transportService.getLatLngMap();


    }
}