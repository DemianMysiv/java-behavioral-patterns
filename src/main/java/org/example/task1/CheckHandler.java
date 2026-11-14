package org.example.task1;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class CheckHandler {
    private CheckHandler next;

    public CheckHandler setNext(CheckHandler next) {
        this.next = next;
        return next;
    }

    public boolean check(Passenger passenger) {
        log("Отримав запит на перевірку пасажира: " + passenger.getName());

        if (!doCheck(passenger)) {
            return false;
        }

        if (next != null) {
            return next.check(passenger);
        }

        return true;
    }

    protected abstract boolean doCheck(Passenger passenger);

    protected void log(String event) {
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        String source = this.getClass().getSimpleName();
        System.out.println("[" + time + "] [" + source + "] " + event);
    }
}
