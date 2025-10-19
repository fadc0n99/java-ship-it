package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable {
    private static final int BASE_COST = 3;

    public FragileParcel(String description, double weight,
                         String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка <" + getDescription() + "> обёрнута в защитную плёнку");
        super.packageItem();
    }

    @Override
    int getBaseCost() {
        return BASE_COST;
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка <" + getDescription() + "> изменила местоположение на " + newLocation);
    }
}
