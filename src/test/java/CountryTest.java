import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.netology.entity.Country;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CountryTest {

    @ParameterizedTest
    @EnumSource(Country.class)
    void values(Country country){
        assertEquals(true, EnumSet.allOf(Country.class).contains(country));}
}
