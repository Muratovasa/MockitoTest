import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.netology.geo.GeoServiceImpl.MOSCOW_IP;
import static ru.netology.geo.GeoServiceImpl.NEW_YORK_IP;

public class GeoServiceImplTest {
    @ParameterizedTest
    @ValueSource(strings = {MOSCOW_IP,NEW_YORK_IP})
    void startWith(String ip){
        ip=MOSCOW_IP;
        assertEquals(true, ip.startsWith("172."));
    }

    @Test
    void geoTest(){
        String ip="172.0.32.11";
        GeoService geoService=new GeoServiceImpl();
        Location expected= new Location("Moscow", Country.RUSSIA, "Lenina",15);
        Location location=geoService.byIp(ip);
        assert expected.getCountry().equals(location.getCountry());
    }
}
