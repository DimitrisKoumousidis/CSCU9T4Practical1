// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;




import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
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

   
   // look up the entry of a given day and month
   public String lookupEntry (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No entries found";
       String matches = ""; //TASK 2 : Declare an empty string for any potential matches
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y)
             matches = matches.concat(current.getEntry() + "\n");  // TASK 2: Append using the concat method
             result = matches;  //TASK 2: Assign the result to the matches string
            }
       return result;
   } // lookupEntry


    public String FindByName(String name) { //TASK 9 : Look for the entries that match the name
        ListIterator<Entry> iter = tr.listIterator();
        String result = "No matches found";
        String matches = "";
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getName().toLowerCase().equals(name))
                matches = matches.concat(current.getEntry() + "\n");  // TASK 9: Append using the concat method
                result = matches;  //TASK 9: Assign the result to the matches string
            }
            return result;
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