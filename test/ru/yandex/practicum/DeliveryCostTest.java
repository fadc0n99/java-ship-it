package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.*;

class DeliveryCostTest {

    @Test
    void shouldReturn6ForStandardParcelAndWeight3() {
        StandardParcel parcel = new StandardParcel(
                "123", 3, "Ларек за гаражами", 10);
        double expectedCost = 6;

        Assertions.assertEquals(expectedCost, parcel.calculateDeliveryCost());
    }

    @Test
    void shouldReturn30ForFragileParcelAndWeight10() {
        FragileParcel parcel = new FragileParcel(
                "123", 10, "Ларек за гаражами", 10);
        double expectedCost = 30;

        Assertions.assertEquals(expectedCost, parcel.calculateDeliveryCost());
    }

    @Test
    void shouldReturn4ForPerishableParcelAndWeight1() {
        PerishableParcel parcel = new PerishableParcel(
                "123", 1, "Ларек за гаражами", 10, 3);
        double expectedCost = 4;

        Assertions.assertEquals(expectedCost, parcel.calculateDeliveryCost());
    }

}
