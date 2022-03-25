package com.stir.cscu9t4practical1;

public class CycleEntry extends Entry{
     private String terrain; // Terrain variable
     private String tempo;  // Tempo variable


    /**
     * Class constructor
     * Inherits the variables from the Entry class
     * initializes the terrain and tempo string
     */
    public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String terrain , String tempo) {
        super(n, d, m, y, h, min, s, dist);
        this.terrain = terrain;
        this.tempo = tempo;
        this.entryType = "cycle";
    }
    /**
     * Returns the terrain string of this object
     */
    public String getTerrain() {
        return terrain;
    }
    /**
     * Returns the tempo string of this object
     */
    public String getTempo() {
        return tempo;
    }
    /**
     * Returns the entry type
     */
    public String getType() {
        return entryType;
    }
    /**
     * Overridden method from the Entry class
     * returns a string with the required information from the Cycle entry class
     */
    public String getEntry(){
        String result = getName()+" cycled " + getDistance() + " km in "
                +getHour()+":"+getMin()+":"+ getSec() + " on "
                +getDay()+"/"+getMonth()+"/"+getYear()+ " "+ "on"+ " "
                +getTerrain()+" " +"at"+ " "+ getTempo()+" "+ "tempo" +"\n";
        return result;
    }
}
