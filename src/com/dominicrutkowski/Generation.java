package com.dominicrutkowski;

public class Generation {

    private GenePool genePool = new GenePool();
    private long size;
    private double greenChance;
    private double greenChanceAfterGreen;
    private double greenChanceAfterYellow;

    public Generation(long size, double greenChance, double greenChanceAfterGreen, double greenChanceAfterYellow) {
        this.size = size;
        this.greenChance = greenChance;
        this.greenChanceAfterGreen = greenChanceAfterGreen;
        this.greenChanceAfterYellow = greenChanceAfterYellow;
    }

    public void addTrial() {
        Bead bead1 = Math.random() < greenChance ? Bead.GREEN : Bead.YELLOW;
        Bead bead2;
        if (bead1 == Bead.GREEN) {
            bead2 = Math.random() < greenChanceAfterGreen ? Bead.GREEN : Bead.YELLOW;
        } else {
            bead2 = Math.random() < greenChanceAfterYellow ? Bead.GREEN : Bead.YELLOW;
        }
        genePool.process(new Trial(bead1, bead2));
    }

    public void simulateGeneration() {
        for (long i = 0; i < size; i++) {
            addTrial();
        }
    }

    public GenePool getGenePool() {
        return genePool;
    }

}
