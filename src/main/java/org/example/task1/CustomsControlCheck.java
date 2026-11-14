package org.example.task1;

public class CustomsControlCheck extends CheckHandler {
    @Override
    protected boolean doCheck(Passenger passenger) {
        log("Митний контроль успішно пройдено.");
        return true;
    }
}