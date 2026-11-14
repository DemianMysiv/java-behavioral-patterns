package org.example.task2;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CancelFlightCommand implements ScheduleCommand {
    private final AirportSchedule schedule;
    private final String flightId;

    public CancelFlightCommand(AirportSchedule schedule, String flightId) {
        this.schedule = schedule;
        this.flightId = flightId;
    }

    @Override
    public void execute() {
        logRequest("Запит на скасування рейсу " + flightId);
        schedule.cancelFlight(flightId);
    }

    @Override
    public void undo() {
        logRequest("Запит на відновлення рейсу " + flightId);
        schedule.restoreFlight(flightId);
    }

    private void logRequest(String event) {
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.printf("[%s] [CancelFlightCommand] %s%n", time, event);
    }
}
