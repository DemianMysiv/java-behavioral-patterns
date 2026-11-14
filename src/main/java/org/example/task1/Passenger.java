package org.example.task1;
public class Passenger {
    private String name;
    private boolean isInternational;
    private double baggageWeight;
    private boolean hasBoardingPass;
    private boolean hasValidPassport;

    public Passenger(String name, boolean isInternational, double baggageWeight, boolean hasBoardingPass, boolean hasValidPassport) {
        this.name = name;
        this.isInternational = isInternational;
        this.baggageWeight = baggageWeight;
        this.hasBoardingPass = hasBoardingPass;
        this.hasValidPassport = hasValidPassport;
    }

    public String getName() { return name; }
    public boolean isInternational() { return isInternational; }
    public double getBaggageWeight() { return baggageWeight; }
    public boolean hasBoardingPass() { return hasBoardingPass; }
    public boolean hasValidPassport() { return hasValidPassport; }
}