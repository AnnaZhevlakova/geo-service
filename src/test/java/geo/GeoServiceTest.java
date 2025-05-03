package geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;


public class GeoServiceTest {
    @Test
    public void test_byIp_1() {
        GeoService geoService = new GeoServiceImpl();
        Location result = geoService.byIp("172.0.32.11");
        Assertions.assertEquals(Country.RUSSIA, result.getCountry());
        Assertions.assertEquals("Moscow", result.getCity());
        Assertions.assertEquals("Lenina", result.getStreet());
        Assertions.assertEquals(15, result.getBuiling());
    }

    @Test
    public void test_byIp_2() {
        GeoService geoService = new GeoServiceImpl();
        Location result = geoService.byIp("96.44.183.149");
        Assertions.assertEquals(Country.USA, result.getCountry());
        Assertions.assertEquals("New York", result.getCity());
        Assertions.assertEquals(" 10th Avenue", result.getStreet());
        Assertions.assertEquals(32, result.getBuiling());
    }
}
