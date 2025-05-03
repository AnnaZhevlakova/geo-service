package mocks;

import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;

public class GeoServiceMock implements GeoService {


    public Location byIp(String ip) {

        return new Location("Moscow", Country.RUSSIA, "Lenina", 15);

    }

    public Location byCoordinates(double latitude, double longitude) {
        throw new RuntimeException("Not implemented");
    }
}
