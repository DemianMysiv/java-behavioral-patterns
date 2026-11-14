package org.example;

public class Main {

    public static void main(String[] args) {
        System.out.println("--- Демонстрація Завдання 1 (Едік) ---");
        runSituation1();

        System.out.println("\n--- Демонстрація Завдання 2 (Дем'ян) ---");
        runSituation2();
    }

    public static void runSituation1() {
        org.example.task1.Task1Demo.run();
    }

    public static void runSituation2() {
        org.example.task2.Task2Demo.run();
    }
}