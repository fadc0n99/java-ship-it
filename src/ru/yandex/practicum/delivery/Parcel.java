package ru.yandex.practicum.delivery;

import java.util.Objects;

public abstract class Parcel {
    private final String description;
    private final double weight;
    private final String deliveryAddress;
    private final int sendDay;

    public Parcel(String description, double weight,
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parcel parcel = (Parcel) o;
        return Double.compare(weight, parcel.weight) == 0 && sendDay == parcel.sendDay && Objects.equals(description, parcel.description) && Objects.equals(deliveryAddress, parcel.deliveryAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "description='" + description + '\'' +
                ", weight=" + weight +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", sendDay=" + sendDay +
                '}';
    }
}
