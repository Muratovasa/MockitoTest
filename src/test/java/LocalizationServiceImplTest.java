import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocalizationServiceImplTest {
    @ParameterizedTest
    @ValueSource(strings = {"Добро пожаловать","Welcome"})
    void locale(String country){
        LocalizationServiceImpl localizationService=new LocalizationServiceImpl();
        country= localizationService.locale(Country.RUSSIA);
        assertEquals(true, country.equals("Добро пожаловать"));
    }
}
