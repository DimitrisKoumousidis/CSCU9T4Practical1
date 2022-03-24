package com.stir.cscu9t4practical1;

public class SwimEntry extends Entry{
    private String where;
    /**
     * Class constructor
     * Inherits the variables from the Entry class
     * initializes the where string
     */
    public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String where) {
        super(n, d, m, y, h, min, s, dist);
        this.where = where;
    }
    /**
     * Returns a string depending on the "where" string
     */
    public String getWhere(){
        String output ="Null";
        if (this.where.toLowerCase().equals("pool")){
            output = "in a pool";
        }
        if (this.where.toLowerCase().equals("outdoors")){
            output = "outdoors";
        }
        return output;
    }
    /**
     * Overridden method from the Entry class
     * returns a string with the required information from the SwimEntry class
     */
    public String getEntry(){
        String result = getName()+" swam " + getDistance() + " " + "km"+ " " + getWhere() + " " + "in" + " " +
                +getHour()+":"+getMin()+":"+ getSec() + " on "
                +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
        return result;

    }
}
