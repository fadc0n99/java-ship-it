package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.println("Укажите тип посылки: 1 - Стандартная, 2 - Хрупкая, 3 - Скоропортящаяся");
        int type = Integer.parseInt(scanner.nextLine());

        if (type > 0 && type <= 3) {
            System.out.println("Укажите описание посылки");
            String description = scanner.nextLine();

            System.out.println("Укажите вес посылки");
            double weight = Double.parseDouble(scanner.nextLine());

            System.out.println("Укажите адрес посылки");
            String address = scanner.nextLine();

            System.out.println("Укажите день отправки посылки");
            int sendDay = Integer.parseInt(scanner.nextLine());

            switch (type) {
                case 1:
                    StandardParcel standardParcel = new StandardParcel(description, weight, address, sendDay);
                    allParcels.add(standardParcel);
                    break;
                case 2:
                    FragileParcel fragileParcel = new FragileParcel(description, weight, address, sendDay);
                    allParcels.add(fragileParcel);
                    break;
                case 3:
                    System.out.println("Укажите срок годности посылки в днях");
                    int timeToLive = Integer.parseInt(scanner.nextLine());

                    PerishableParcel perishableParcel = new PerishableParcel(
                            description, weight, address, sendDay, timeToLive);

                    allParcels.add(perishableParcel);
                    break;
            }
        } else {
            System.out.println("Такого типа посылки не существует!");
        }

    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        double totalCost = 0;
        for (Parcel parcel : allParcels) {
            totalCost += parcel.calculateDeliveryCost();
        }

        System.out.println("Общая стоимость посылок: " + totalCost);
    }

}

