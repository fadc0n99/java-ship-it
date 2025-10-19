package ru.yandex.practicum.delivery;

public abstract class Parcel {
    private final String description;
    private final double weight;
    private final String deliveryAddress;
    private final int sendDay;

    protected Parcel(String description, double weight,
                     String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public String getDescription() {
        return description;
    }

    public double getWeight() {
        return weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public int getSendDay() {
        return sendDay;
    }

    public void packageItem() {
        System.out.println("Посылка <" + description + "> упакована");
    }

    public void deliver() {
        System.out.println("Посылка <" + description +
                "> доставлена по адресу " + deliveryAddress);
    }

    public double calculateDeliveryCost() {
        return weight * getBaseCost();
    }

    abstract int getBaseCost();
}
