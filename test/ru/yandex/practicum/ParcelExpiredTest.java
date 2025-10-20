package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.PerishableParcel;

class ParcelExpiredTest {

    @Test
    void shouldBeFalseWhenSendDayAndTimeToLiveEqualsCurrentDay() {
        PerishableParcel parcel = new PerishableParcel(
                "123", 1, "Ларек за гаражами", 10, 3);
        int currentDay = 13;
        Assertions.assertFalse(parcel.isExpired(currentDay));
    }

    @Test
    void shouldBeFalseWhenSendDayAndTimeToLiveMoreCurrentDay() {
        PerishableParcel parcel = new PerishableParcel(
                "123", 1, "Ларек за гаражами", 10, 3);
        int currentDay = 10;
        Assertions.assertFalse(parcel.isExpired(currentDay));
    }

    @Test
    void shouldBeTrueWhenSendDayAndTimeToLiveLessCurrentDay() {
        PerishableParcel parcel = new PerishableParcel(
                "123", 1, "Ларек за гаражами", 5, 3);
        int currentDay = 13;
        Assertions.assertTrue(parcel.isExpired(currentDay));
    }

}
