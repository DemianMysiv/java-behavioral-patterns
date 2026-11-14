package org.example.task1;

public class WeightCheck extends CheckHandler {
    private static final double MAX_WEIGHT = 10.0;

    @Override
    protected boolean doCheck(Passenger passenger) {
        if (passenger.getBaggageWeight() > MAX_WEIGHT) {
            log("Відмовлено: вага поклажі " + passenger.getBaggageWeight() + " кг перевищує ліміт " + MAX_WEIGHT + " кг.");
            return false;
        }
        log("Перевірку ваги ручної поклажі пройдено.");
        return true;
    }
}