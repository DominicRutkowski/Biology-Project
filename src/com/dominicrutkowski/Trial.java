package com.dominicrutkowski;

public class Trial {

    private Bead bead1;
    private Bead bead2;

    public Trial(Bead bead1, Bead bead2) {
        this.bead1 = bead1;
        this.bead2 = bead2;
    }

    public short noOfGreen()
    {
        short number = 0;
        if (bead1 == Bead.GREEN) {
            number++;
        }
        if (bead2 == Bead.GREEN) {
            number++;
        }
        return number;
    }

    public short noOfYellow()
    {
        short number = 0;
        if (bead1 == Bead.YELLOW) {
            number++;
        }
        if (bead2 == Bead.YELLOW) {
            number++;
        }
        return number;
    }

}
