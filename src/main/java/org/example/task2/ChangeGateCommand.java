package org.example.task2;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ChangeGateCommand implements ScheduleCommand {
    private final AirportSchedule schedule;
    private final String flightId;
    private final String oldGate;
    private final String newGate;

    public ChangeGateCommand(AirportSchedule schedule, String flightId, String oldGate, String newGate) {
        this.schedule = schedule;
        this.flightId = flightId;
        this.oldGate = oldGate;
        this.newGate = newGate;
    }

    @Override
    public void execute() {
        logRequest("Запит на зміну виходу рейсу " + flightId + " на " + newGate);
        schedule.changeGate(flightId, newGate);
    }

    @Override
    public void undo() {
        logRequest("Запит на відміну зміни виходу рейсу " + flightId);
        schedule.changeGate(flightId, oldGate);
    }

    private void logRequest(String event) {
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.printf("[%s] [ChangeGateCommand] %s%n", time, event);
    }
}
