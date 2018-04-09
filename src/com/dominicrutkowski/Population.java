package com.dominicrutkowski;

import java.util.ArrayList;

public class Population {

    private ArrayList<Generation> generations = new ArrayList<>();
    private long size;

    public Population(long size) {
        this.size = size;
    }

    public void simulateGeneration() {
        if (generations.isEmpty()) {
            double greenChanceAfterGreen = (double) (size - 1) / (2 * size - 1);
            double greenChanceAfterYellow = (double) size / (2 * size - 1);
            generations.add(new Generation(size, 0.5, greenChanceAfterGreen, greenChanceAfterYellow));
        } else {
            GenePool genePool = generations.get(generations.size() - 1).getGenePool();
            generations.add(new Generation(size, genePool.chanceOfGreen(), genePool.chanceOfGreenAfterGreen(), genePool.chanceOfGreenAfterYellow()));
        }
        generations.get(generations.size() - 1).simulateGeneration();
    }

    public long simulatePopulation() {
        do {
            simulateGeneration();
        } while (generations.get(generations.size() - 1).getGenePool().chanceOfGreen() > 0 &&
                generations.get(generations.size() - 1).getGenePool().chanceOfGreen() < 1);
        return generations.size();
    }

    public GenePool getLastGenePool() {
        return generations.get(generations.size() - 1).getGenePool();
    }

}
