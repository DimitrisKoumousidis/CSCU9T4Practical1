// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;




import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor


    /**
     * TASK 4
     * Adds an entry to the list
     * doesn't add the entry if a duplicate is found in the same day
     * @param e The object to be added
     */
   public void addEntry(Entry e){
       ListIterator<Entry> iter = tr.listIterator();  //TASK 4: Declare an iterator
       int m = e.getMonth();
       int d = e.getDay();
       int y = e.getYear();
       String name = e.getName();
       boolean matchFound = false;   //TASK 4: Declare a boolean as false

       while(iter.hasNext()){
            Entry current = iter.next();
           //TASK 4: If a match is found in the current records
           if(current.getName().equals(name) && current.getDay() == d && current.getMonth() == m && current.getYear()==y){
              matchFound = true; //TASK 4: Set matchfound to true
           }
       }

       System.out.println(matchFound); //TASK 4: Print a message
       if(matchFound == true){ //TASK 4: If matchFound = true
           System.out.println("addEntry failed : Entry match in the records"); //TASK 4: Print a message
       }else{
           tr.add(e); //TASK 4: Else add the entry
       }
   } // addClass


    /**
     * TASK 2
     * Searches for an entry from the list
     * that matches the date given
     * @param d the day of the entry's date
     * @param m the month of the entry's date
     * @param y the year in the entry's date
     * @return a string with all matching results
     */
   public String lookupEntry (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "";
       String matches = ""; //TASK 2 : Declare an empty string for any potential matches
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y)
             matches = matches.concat(current.getEntry() + "\n");  // TASK 2: Append using the concat method
             result = matches;  //TASK 2: Assign the result to the matches string
            }
       if(result.isEmpty()){ //TASK 2: If no results are found
           result = "No entries found";//TASK 2: Print a message
       }
       return result;
   } // lookupEntry

    /**
     * TASK 9
     * Searches for an entry from the list
     * that matches the name provided regardless of the date
     * @param name the string of the name of the entry
     * @return a string with all matching results
     */
    public String FindByName(String name) { //TASK 9
        ListIterator<Entry> iter = tr.listIterator();
        String result = "";
        String matches = "";
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getName().toLowerCase().equals(name.toLowerCase()))
                matches = matches.concat(current.getEntry() + "\n");  // TASK 9: Append using the concat method
                result = matches;  //TASK 9: Assign the result to the matches string
            }
        if(result.isEmpty()){ //TASK 9: If no results are found
            result = "No name matches found";//TASK 9: Print a message
        }
        return result;
        }

    /**
     * TASK 11
     * Searches for an entry from the list
     * that matches the name and date provided and removes it from the list
     * @param name the string of the name of the entry
     * @param d the day of the entry's date
     * @param m the month of the entry's date
     * @param y the year in the entry's date
     *
     */
     public String Remove(String name, int d ,int m, int y) throws ConcurrentModificationException{
        ListIterator<Entry> iter = tr.listIterator();
        String message = "No matching entries to remove";

            while(iter.hasNext()){
                Entry current = iter.next();
                //TASK 11: If a match is found in the current records
                if(current.getName().equals(name) && current.getDay() == d && current.getMonth() == m && current.getYear()==y){
                   tr.remove(current); //Remove the current entry
                    message="Entry removed successfully";
                    return message;
                }
            }
        return message;
       }

       public String weeklyDistance(String name, int d ,int m, int y){
           ListIterator<Entry> iter = tr.listIterator();
           String message = "";
           float swi =0;
           float snt = 0;
           float cyc= 0;

           Calendar calendar = Calendar.getInstance(); // Create a calendar
           calendar.set(y,m-1,d);  //Set the calendar to the date provided



               while(iter.hasNext() == true) {
                   Entry current = iter.next();

                   for(int i = 0; i <= 6 ;i++) {


                       //If the name and the date is equal
                       if (current.getName().toLowerCase().equals(name.toLowerCase()) && calendar.get(Calendar.DAY_OF_MONTH) == current.getDay()
                               && (calendar.get(Calendar.MONTH) + 1) == current.getMonth() && calendar.get(Calendar.YEAR) == current.getYear()) {
                           System.out.println("FOUND AN ENTRY"+ "\n");
                           if (current.entryType.equals("swim")) { //If the entry is a sprint
                               swi += current.getDistance(); //Add the distance to the swim distance summary
                           }
                           if (current.entryType.equals("cycle")) { //If the entry is a cycle
                               cyc += current.getDistance(); //Add the distance to the cycle distance summary
                           }
                           if (current.entryType.equals("sprint")) { //If the entry is a sprint
                               snt += current.getDistance(); //Add the distance to the sprint distance summary
                           }
                       }
                       calendar.add(calendar.HOUR_OF_DAY, -24); // Go back 24 hours
                       System.out.println("Calendar time =" + calendar.getTime());
                   }
                   calendar.set(y,m-1,d);  //Reset the date
               }


           message="Date added :" + " " + d + "/" + m + "/" + y + " " + "\n"
                   +"Swimming distance last week =" + " " + swi +"kms"+ " " + "\n"
                   +"Sprinting distance last week =" + " " + snt +"kms"+ " " + "\n"
                   +"Cycling distance last week =" + " " + cyc +"kms"+ " " + "\n"
                   +"Searched until :" + " " + calendar.getTime();
           return message;
       }


   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   
} // TrainingRecord