package com.dominicrutkowski;

public class GenePool {

    private long green = 0;
    private long yellow = 0;

    public GenePool() {}

    public void process(Trial trial) {
        green += trial.noOfGreen();
        yellow += trial.noOfYellow();
    }

    public double chanceOfGreen() {
        return (double) green / (green + yellow);
    }

    public double chanceOfGreenAfterGreen() {
        return (double) (green - 1) / (green + yellow - 1);
    }

    public double chanceOfGreenAfterYellow() {
        return (double) green / (green + yellow - 1);
    }

}
