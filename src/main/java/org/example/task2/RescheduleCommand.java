package org.example.task2;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RescheduleCommand implements ScheduleCommand {
    private final AirportSchedule schedule;
    private final String flightId;
    private final String oldTime;
    private final String newTime;

    public RescheduleCommand(AirportSchedule schedule, String flightId, String oldTime, String newTime) {
        this.schedule = schedule;
        this.flightId = flightId;
        this.oldTime = oldTime;
        this.newTime = newTime;
    }

    @Override
    public void execute() {
        logRequest("Запит на перенесення рейсу " + flightId + " на " + newTime);
        schedule.rescheduleFlight(flightId, newTime);
    }

    @Override
    public void undo() {
        logRequest("Запит на відміну перенесення рейсу " + flightId);
        schedule.rescheduleFlight(flightId, oldTime);
    }

    private void logRequest(String event) {
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.printf("[%s] [RescheduleCommand] %s%n", time, event);
    }
}
