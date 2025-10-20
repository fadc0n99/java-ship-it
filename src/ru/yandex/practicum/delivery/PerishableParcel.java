package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    private final int timeToLive;
    private static final int BASE_COST = 4;

    public PerishableParcel(String description, double weight,
                            String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay) {
        int maxDaysDeliveryTime = getSendDay() + timeToLive;

        return maxDaysDeliveryTime < currentDay;
    }

    @Override
    protected int getBaseCost() {
        return BASE_COST;
    }
}
