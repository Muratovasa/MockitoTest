import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;

import static ru.netology.sender.MessageSenderImpl.IP_ADDRESS_HEADER;

public class MessageSenderImplTest {
    @Test
    void sendRus() {
        String expected = "Добро пожаловать";
        HashMap<String, String> map = new HashMap<String, String>();
        map.put(IP_ADDRESS_HEADER, "172.0.32.11");

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("172.0.32.11"))
                .thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String rzult = messageSender.send(map);
        assert expected.equals(rzult);
    }
    @Test
    void sendEn() {
        String expected = "Welcome";
        HashMap<String, String> map = new HashMap<String, String>();
        map.put(IP_ADDRESS_HEADER, "96.44.183.149");

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("96.44.183.149"))
                .thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String rzult = messageSender.send(map);
        assert expected.equals(rzult);
    }
}
