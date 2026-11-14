package org.example.task1;

public class BoardingPassCheck extends CheckHandler {
    @Override
    protected boolean doCheck(Passenger passenger) {
        if (!passenger.hasBoardingPass()) {
            log("Відмовлено: відсутній дійсний посадковий талон.");
            return false;
        }
        log("Перевірку посадкового талона успішно пройдено.");
        return true;
    }
}