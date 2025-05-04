package sender;

import mocks.GeoServiceMock;
import mocks.LocalizationServiceMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderTest {
    @Test
    public void test_send_1() {

        LocalizationService localizationServiceMock  = Mockito.mock(LocalizationServiceImpl.class);
        GeoService geoServiceMock = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(localizationServiceMock.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");
        Mockito.when(localizationServiceMock.locale(Country.USA)).thenReturn("Welcome");
        Mockito.when(geoServiceMock.byIp("172.0.32.11")).thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        Mockito.when(geoServiceMock.byIp("96.44.183.149")).thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));
        MessageSenderImpl messageSender = new MessageSenderImpl(geoServiceMock, localizationServiceMock);
        Map<String, String> states = new HashMap<String, String>();
        states.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");
        String result = messageSender.send(states);
        String expected = "Добро пожаловать";
        Assertions.assertEquals(expected, result);
    }
    

}
