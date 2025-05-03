package sender;

import mocks.GeoServiceMock;
import mocks.LocalizationServiceMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderTest {
    @Test
    public void test_send_1() {
        LocalizationService localizationServiceMock = new LocalizationServiceMock();
        GeoService geoServiceMock = new GeoServiceMock();
        MessageSenderImpl messageSender = new MessageSenderImpl(geoServiceMock, localizationServiceMock);
        Map<String, String> states = new HashMap<String, String>();
        states.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");
        String result = messageSender.send(states);
        String expected = "Добро пожаловать";
        Assertions.assertEquals(expected, result);
    }
    

}
