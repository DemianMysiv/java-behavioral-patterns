package org.example.task1;

public class PassportControlCheck extends CheckHandler {
    @Override
    protected boolean doCheck(Passenger passenger) {
        if (!passenger.hasValidPassport()) {
            log("Відмовлено: проблеми з паспортним контролем.");
            return false;
        }
        log("Паспортний контроль успішно пройдено.");
        return true;
    }
}