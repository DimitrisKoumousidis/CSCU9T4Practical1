package com.stir.cscu9t4practical1;

public class SprintEntry extends Entry{
    private int repetitions;
    private int recovery;
    /**
     * Class constructor
     * Inherits the variables from the Entry class
     * initializes the repetitions and recovery integers
     * divides the distance by 100
     */
    public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int rep , int rec) {
        super(n, d, m, y, h, min, s, dist);
        this.repetitions = rep;
        this.recovery = rec;
        this.distance = (this.distance / 100F);
        this.entryType = "sprint";
    }
    /**
     * Returns the repetitions from this object
     */
    public int getRepetitions() {
        return repetitions;
    }
    /**
     * Returns the recovery from this object
     */
    public int getRecovery() {
        return recovery;
    }
    /**
     * Returns the entry type
     */
    public String getType() {
        return entryType;
    }

    /**
     * Overridden method from the Entry class
     * returns a string with the required information from the SprintEntry class
     * sets the distance to itself multiplied by 100
     */
    public String getEntry(){
        String result = getName()+" sprinted " + getRepetitions() +"x"+ getDistance()*100 + "kms in "
                +getHour()+":"+getMin()+":"+ getSec() + " " + "with"+ " "
                +getRecovery()+ " " + "minutes recovery" +" on "
                +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
        return result;
    }
}
