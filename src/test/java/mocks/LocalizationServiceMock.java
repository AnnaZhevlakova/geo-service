package mocks;

import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;

public class LocalizationServiceMock implements LocalizationService {

    public String locale(Country country) {

        return "Добро пожаловать";

    }
}
