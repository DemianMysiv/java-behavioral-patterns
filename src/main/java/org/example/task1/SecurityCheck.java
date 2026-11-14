package org.example.task1;

public class SecurityCheck extends CheckHandler {
    @Override
    protected boolean doCheck(Passenger passenger) {
        log("Огляд безпеки успішно пройдено.");
        return true;
    }
}