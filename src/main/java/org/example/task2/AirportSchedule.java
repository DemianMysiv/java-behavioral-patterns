package org.example.task2;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class AirportSchedule {
    private final Map<String, String> flightTimes = new HashMap<>();
    private final Map<String, String> flightGates = new HashMap<>();
    private final Map<String, Boolean> flightStatus = new HashMap<>();

    public void addFlight(String flightId, String time, String gate) {
        flightTimes.put(flightId, time);
        flightGates.put(flightId, gate);
        flightStatus.put(flightId, true);
    }

    public void rescheduleFlight(String flightId, String newTime) {
        flightTimes.put(flightId, newTime);
        log("Рейс " + flightId + " перенесено на " + newTime);
    }

    public void changeGate(String flightId, String newGate) {
        flightGates.put(flightId, newGate);
        log("Для рейсу " + flightId + " змінено вихід на " + newGate);
    }

    public void cancelFlight(String flightId) {
        flightStatus.put(flightId, false);
        log("Рейс " + flightId + " скасовано");
    }

    public void restoreFlight(String flightId) {
        flightStatus.put(flightId, true);
        log("Рейс " + flightId + " відновлено (скасування відмінено)");
    }

    public void printSchedule() {
        System.out.println("\n--- Поточний розклад ---");
        for (String flightId : flightTimes.keySet()) {
            String status = flightStatus.get(flightId) ? "Очікується" : "СКАСОВАНО";
            System.out.printf("Рейс: %s | Час: %s | Вихід: %s | Статус: %s%n", 
                    flightId, flightTimes.get(flightId), flightGates.get(flightId), status);
        }
        System.out.println("------------------------\n");
    }

    private void log(String event) {
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.printf("[%s] [AirportSchedule] Фактичне виконання: %s%n", time, event);
    }
}
