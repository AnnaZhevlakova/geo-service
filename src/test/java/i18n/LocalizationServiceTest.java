package i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceTest {
    @Test
    public void test_locale_1() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        String result = localizationService.locale(Country.BRAZIL);
        String expected = "Welcome";
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_locale_2() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        String result = localizationService.locale(Country.RUSSIA);
        String expected = "Добро пожаловать";
        Assertions.assertEquals(expected, result);
    }
}
