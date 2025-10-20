package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.StandardParcel;

class ParcelBoxTest {

    @Test
    void shouldAddParcelWhenParcelWeightDoesNotExceedsLimit() {
        ParcelBox<StandardParcel> parcelBox = new ParcelBox<>(10);

        StandardParcel parcel = new StandardParcel(
                "123", 3, "Ларек за гаражами", 10);

        parcelBox.addParcel(parcel);
        parcelBox.addParcel(parcel);

        Assertions.assertEquals(2, parcelBox.getAllParcels().size());
    }

    @Test
    void shouldNotAddParcelWhenParcelWeightDoesExceedsLimit() {
        ParcelBox<StandardParcel> parcelBox = new ParcelBox<>(4);

        StandardParcel parcel = new StandardParcel(
                "123", 3, "Ларек за гаражами", 10);

        parcelBox.addParcel(parcel);
        parcelBox.addParcel(parcel);

        Assertions.assertEquals(1, parcelBox.getAllParcels().size());
    }

    @Test
    void shouldAddParcelWhenAddingParcelMakesMaxWeightBox() {
        ParcelBox<StandardParcel> parcelBox = new ParcelBox<>(6);

        StandardParcel parcel = new StandardParcel(
                "123", 3, "Ларек за гаражами", 10);

        parcelBox.addParcel(parcel);
        parcelBox.addParcel(parcel);

        Assertions.assertEquals(2, parcelBox.getAllParcels().size());
    }

}
