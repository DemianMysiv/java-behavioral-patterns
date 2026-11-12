package org.example.task2;

public class Task2Demo {
    public static void run() {
        AirportSchedule schedule = new AirportSchedule();
        Dispatcher dispatcher = new Dispatcher();

        schedule.addFlight("PS-101", "14:00", "A1");
        schedule.addFlight("PS-202", "16:45", "B2");
        schedule.addFlight("PS-303", "18:20", "C3");

        System.out.println("=== СЦЕНАРІЙ 1: Миттєві дії ===");
        dispatcher.executeAction(new RescheduleCommand(schedule, "PS-101", "14:00", "15:30"));
        dispatcher.executeAction(new ChangeGateCommand(schedule, "PS-202", "B2", "C1"));
        schedule.printSchedule();

        System.out.println("=== СЦЕНАРІЙ 2: Скасування дій ===");
        dispatcher.undoLastAction();
        dispatcher.undoLastAction();
        schedule.printSchedule();

        System.out.println("=== СЦЕНАРІЙ 3: Пакетне виконання ===");
        dispatcher.queueAction(new RescheduleCommand(schedule, "PS-303", "18:20", "19:00"));
        dispatcher.queueAction(new ChangeGateCommand(schedule, "PS-101", "A1", "A5"));
        dispatcher.queueAction(new CancelFlightCommand(schedule, "PS-202"));
        
        dispatcher.executeBatch();
        schedule.printSchedule();
        
        dispatcher.printJournal();
    }
}
