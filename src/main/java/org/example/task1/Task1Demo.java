package org.example.task1;
public class Task1Demo {
    public static void run(){
        runScenario1();
        runScenario2();
        runScenario3();
    }

    private static void runScenario1() {
        System.out.println("=== Сценарій 1: Міжнародний рейс (успішне проходження) ===");
        CheckHandler chain = buildInternationalChain();
        Passenger passenger = new Passenger("Олександр", true, 8.5, true, true);

        boolean result = chain.check(passenger);
        if (result) {
            System.out.println("Результат: Пасажир допущений до посадки.\n");
        } else {
            System.out.println("Результат: Пасажир зупинений.\n");
        }
    }

    private static void runScenario2() {
        System.out.println("=== Сценарій 2: Пасажир з ручною поклажею 12 кг ===");
        CheckHandler chain = buildInternationalChain();
        Passenger passenger = new Passenger("Марія", true, 12.0, true, true);

        boolean result = chain.check(passenger);
        if (result) {
            System.out.println("Результат: Пасажир допущений до посадки.\n");
        } else {
            System.out.println("Результат: Пасажир зупинений.\n");
        }
    }

    private static void runScenario3() {
        System.out.println("=== Сценарій 3: Внутрішній рейс (без паспортного контролю) ===");
        CheckHandler chain = buildDomesticChain();
        Passenger passenger = new Passenger("Іван", false, 6.0, true, false);

        boolean result = chain.check(passenger);
        if (result) {
            System.out.println("Результат: Пасажир допущений до посадки.\n");
        } else {
            System.out.println("Результат: Пасажир зупинений.\n");
        }
    }


    private static CheckHandler buildInternationalChain() {
        CheckHandler head = new BoardingPassCheck();
        head.setNext(new PassportControlCheck())
                .setNext(new CustomsControlCheck())
                .setNext(new SecurityCheck())
                .setNext(new WeightCheck());
        return head;
    }


    private static CheckHandler buildDomesticChain() {
        CheckHandler head = new BoardingPassCheck();
        head.setNext(new SecurityCheck())
                .setNext(new WeightCheck());
        return head;
    }
}