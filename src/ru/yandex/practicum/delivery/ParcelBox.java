package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    private final List<T> parcels = new ArrayList<>();
    private final double maxBoxWeight;
    private double currentBoxWeight;

    public ParcelBox(double maxBoxWeight) {
        this.maxBoxWeight = maxBoxWeight;
    }

    public double getMaxBoxWeight() {
        return maxBoxWeight;
    }

    public List<T> getAllParcels() {
        return parcels;
    }

    public void addParcel(T newParcel) {
        if (currentBoxWeight + newParcel.getWeight() <= maxBoxWeight) {
            parcels.add(newParcel);
            currentBoxWeight += newParcel.getWeight();
        } else {
            System.out.println("Текущий вес коробки: " + currentBoxWeight +
                    ". Максимальный вес коробки: " + maxBoxWeight +
                    ". Посылка с весом " + newParcel.getWeight() + " не может быть добавлена!");
        }
    }
}
