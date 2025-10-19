package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {
    private static final int BASE_COST = 2;

    public StandardParcel(String description, double weight,
                          String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    int getBaseCost() {
        return BASE_COST;
    }

}
