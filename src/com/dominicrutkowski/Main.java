package com.dominicrutkowski;

public class Main {

    private Main() {
        for (int exp = 2; exp <= 6; exp++) {
            long sum = 0;
            int fixed = 0;
            int fixedGreen = 0;
            int count;
            int noOfTrials = exp <= 4 ? 50000 : 10000;
            for (count = 1; count <= noOfTrials; count++) {
                Population population = new Population((long) Math.pow(2, exp));
                int trials = (int) population.simulatePopulation();
                sum += trials;
                if (trials <= 10) {
                    fixed++;
                    if (population.getLastGenePool().chanceOfGreen() >= 1) {
                        fixedGreen++;
                    }
                }
            }
            System.out.println("Results for " + (short) Math.pow(2, exp) + "-individual population:");
            System.out.println("Sample Size: " + noOfTrials);
            System.out.printf("Average Trials: %.2f%n", (double) sum / count);
            System.out.printf("Percentage Fixed: %.2f%%%n", (double) fixed * 100 / count);
            System.out.printf("Percentage not Fixed: %.2f%%%n", (double) (count - fixed) * 100 / count);
            System.out.printf("Percentage Fixed Green: %.2f%%%n", (double) fixedGreen * 100 / fixed);
            System.out.printf("Percentage Fixed Yellow: %.2f%%%n%n", (double) (fixed - fixedGreen) * 100 / fixed);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
    }

}
