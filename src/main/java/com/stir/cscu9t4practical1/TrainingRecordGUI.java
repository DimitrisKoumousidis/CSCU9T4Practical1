// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {
    private String entryType = "null";
    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JTextField terrain = new JTextField(10);
    private JTextField tempo = new JTextField(10);
    private JTextField repetitions = new JTextField(2);
    private JTextField recovery = new JTextField(2);
    private JTextField where = new JTextField(10);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JLabel labterrain = new JLabel("Terrain type:");
    private JLabel labtempo = new JLabel("Tempo:");
    private JLabel labrep = new JLabel("Repetitions:");
    private JLabel labrec = new JLabel("Recovery(Mins):");
    private JLabel labwhere = new JLabel("Outdoors/Indoors:");// TASK 8 All necessary labels and buttons declared
    private JButton cycleEntry = new JButton("Enter a cycle entry"); //Task 8:GUI button for adding cycle entries
    private JButton swimEntry = new JButton("Enter a swim entry"); //Task 8:GUI button for adding swim entries
    private JButton sprintEntry = new JButton("Enter a sprint entry"); //Task 8:GUI button for adding cycle entries
    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton FindAllByDate = new JButton("Find all by date"); //TASK 1: Declare the FindAllByDate button
    private JButton FindByName = new JButton("Find by name"); //TASK 9 : Declare the FindByName button
    private JButton RemoveEntry = new JButton("Remove"); //TASK 11: Declare the remove button
    private JButton WeeklyDistance = new JButton("Weekly distance"); //TASK 14: Declare the weekly distance button
    private TrainingRecord myAthletes = new TrainingRecord();
    private JTextArea outputArea = new JTextArea(5, 50);
    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(false);
        add(labm);
        add(month);
        month.setEditable(false);
        add(laby);
        add(year);
        year.setEditable(false);
        add(labh);
        add(hours);
        hours.setEditable(false);
        add(labmm);
        add(mins);
        mins.setEditable(false);
        add(labs);
        add(secs);
        secs.setEditable(false);
        add(labdist);
        add(dist);
        dist.setEditable(false);
        add(labterrain);
        add(terrain);
        terrain.setEditable(false); //TASK 8: Add the terrain button to the GUI
        add(labtempo);
        add(tempo);
        tempo.setEditable(false); //TASK 8: Add the tempo button to the GUI
        add(labrep);
        add(repetitions);
        repetitions.setEditable(false); //TASK 8: Add the repetitions button to the GUI
        add(labrec);
        add(recovery);
        recovery.setEditable(false); //TASK 8: Add the recovery button to the GUI
        add(labwhere);
        add(where);
        where.setEditable(false); //TASK 8: Add the where button to the GUI
        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(outputArea);
        outputArea.setEditable(false);
        add(FindAllByDate); //TASK 1: Add the FindAllByDate button to the GUI
        FindAllByDate.addActionListener(this);
        add(cycleEntry);
        cycleEntry.addActionListener(this);
        add(swimEntry);
        swimEntry.addActionListener(this);
        add(sprintEntry);
        sprintEntry.addActionListener(this);
        add(FindByName);
        FindByName.addActionListener(this); //TASK 9 : Add the FindByName button to the GUI
        add(RemoveEntry);
        RemoveEntry.addActionListener(this); //TASK 11: Add the Remove button
        add(WeeklyDistance);
        WeeklyDistance.addActionListener(this); //TASK 14: Add the weekly distance button
        setSize(720, 500); //Set the GUI'S height to 500
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry("generic");
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if(event.getSource() == FindAllByDate) { //TASK 1: FindAllByDate Button action
            message = FindAllByDate();
        }
        if(event.getSource() == cycleEntry){ //TASK 8: If the Cycle entry button is pressed
            name.setEditable(true);//TASK 8: Reset the textfields and enable the appropriate input objects
            name.setText("");
            day.setEditable(true);
            day.setText("");
            month.setEditable(true);
            month.setText("");
            mins.setEditable(true);
            mins.setText("");
            hours.setEditable(true);
            hours.setText("");
            secs.setEditable(true);
            secs.setText("");
            year.setEditable(true);
            year.setText("");
            dist.setEditable(true);
            dist.setText("");
            terrain.setEditable(true);
            terrain.setText("");
            tempo.setEditable(true);
            tempo.setText("");
            repetitions.setEditable(false);
            repetitions.setText("");
            recovery.setEditable(false);
            recovery.setText("");
            where.setEditable(false);
            where.setText("");
            entryType = "cycle"; //Set the entryType string to cycle


        }
        if(event.getSource() == swimEntry){ //TASK 8: If the swim entry button is pressed
            name.setEditable(true);//TASK 8: Reset the textfields and enable the appropriate input objects
            name.setText("");
            day.setEditable(true);
            day.setText("");
            month.setEditable(true);
            month.setText("");
            mins.setEditable(true);
            mins.setText("");
            hours.setEditable(true);
            hours.setText("");
            secs.setEditable(true);
            secs.setText("");
            year.setEditable(true);
            year.setText("");
            dist.setEditable(true);
            dist.setText("");
            terrain.setEditable(false);
            terrain.setText("");
            tempo.setEditable(false);
            tempo.setText("");
            repetitions.setEditable(false);
            repetitions.setText("");
            recovery.setEditable(false);
            recovery.setText("");
            where.setEditable(true);
            where.setText("");
            entryType = "swim"; //Set the entryType string to swim
        }
        if(event.getSource() == sprintEntry){ //TASK 8: If the sprint entry button is pressed
            name.setEditable(true);//TASK 8: Reset the textfields and enable the appropriate input objects
            name.setText("");
            day.setEditable(true);
            day.setText("");
            month.setEditable(true);
            month.setText("");
            mins.setEditable(true);
            mins.setText("");
            hours.setEditable(true);
            hours.setText("");
            secs.setEditable(true);
            secs.setText("");
            year.setEditable(true);
            year.setText("");
            dist.setEditable(true);
            dist.setText("");
            terrain.setEditable(false);
            terrain.setText("");
            tempo.setEditable(false);
            tempo.setText("");
            repetitions.setEditable(true);
            repetitions.setText("");
            recovery.setEditable(true);
            recovery.setText("");
            where.setEditable(false);
            where.setText("");
            entryType = "sprint"; //Set the entryType string to sprint
        }
        if(event.getSource() == FindByName){ //TASK 9: If the "Find by name" button is pressed
            message = FindByName();
        }
        if(event.getSource() == RemoveEntry){ //TASK 11: If the "Remove" button is pressed
            message = Remove();
        }
        if(event.getSource() == WeeklyDistance){ //TASK 14: If the "Weekly Distance" button is pressed
            message = WeekDist();
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    /**
     * Adds an entry to the list once the "Look up" button is pressed
     * its able to addd all 3 types of entries depending on the entry selection
     * calls the addEntry() method from TrainingRecord.java
     * @return the output message for the outputArea textField
     */
    public String addEntry(String what) {
        String message = "Record added\n";

        try { //TASK 4: Check if the input is correct
            System.out.println("Adding " + what + " entry to the records");
            String n = name.getText();

            if(n.isEmpty()) {  //TASK 4: Return a message if the name string is empty
                System.out.println("Adding " + what + " entry to the records failed : Empty name string");
                return "Name is empty";
            }
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            float km = java.lang.Float.parseFloat(dist.getText());
            int h = Integer.parseInt(hours.getText());
            int mm = Integer.parseInt(mins.getText());
            int s = Integer.parseInt(secs.getText());
            if (entryType.equals("cycle")){ //TASK 8: If the entry is a cycle
                String ter = terrain.getText();
                String temp = tempo.getText();

                Entry e = new CycleEntry(n, d, m, y, h, mm, s, km,ter,temp); //TASK 8: Create and add a CycleEntry object
                myAthletes.addEntry(e);

            }
            if(entryType.equals("swim")){//TASK 8: If the entry is a swim

                String whe = where.getText();
//                if(!whe.toLowerCase().equals("outdoors") || !whe.toLowerCase().equals("pool") ){ //If the input is invalid
//                    return "Invalid input for \"where\"";
//                }
                Entry e = new SwimEntry(n, d, m, y, h, mm, s, km,whe); //TASK 8: Create and add a SwimEntry object
                myAthletes.addEntry(e);
            }
            if(entryType.equals("sprint")){ //TASK 8: If the entry is a sprint
                int rep = Integer.parseInt(repetitions.getText());
                int rec = Integer.parseInt(recovery.getText());
                Entry e = new SprintEntry(n, d, m, y, h, mm, s, km,rep,rec); //TASK 8: Create and add a SprintEntry object
                myAthletes.addEntry(e);


                }




            return message;
        } catch(NumberFormatException e) {  //TASK 4: Catch a number format exception

            message = "Invalid input";  //TASK 4: Return a message if the input is invalid
            System.out.println("Adding " + what + " entry to the records failed : Invalid input");
        }
        return message;
    }
    /**
     * TASK 4
     * Looks up for any entries that match the date parsed
     * from the day,month and year buttons
     * calls lookupEntry from TrainingRecord.java
     * @return the output message for the outputArea textField
     */
    public String lookupEntry() {
        String message;
        try { //TASK 4: Check if month,day,year are integers
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            outputArea.setText("looking up record ...");
            message = myAthletes.lookupEntry(d, m, y);
            return message;

        } catch (NumberFormatException e ){
            message = "Invalid date input"; //TASK 4: Display a message if the input is invalid
            System.out.println("lookupEntry failed : Invalid input");
        }
        return message;
    }
    /**
     * TASK 4
     * A duplicate of lookupEntry from TrainingRecordGUI.java
     * @return the output message for the outputArea textField
     */
    public String FindAllByDate(){  //TASK 1: FindAllByDate button method
        String message;
        try { //TASK 4: Check if month,day,year are integers
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            message = myAthletes.lookupEntry(d, m, y);
            return message;
        } catch (NumberFormatException e){
            message = "Invalid date input"; //TASK 4: Display a message if the input is invalid
            System.out.println("FindAllByDate failed : Invalid input");
        }
        return message;
    }
    /**
     * TASK 9
     * Finds all the record that match the name present in the name textfield
     * once the "Find by name" button is pressed
     * @return the output message for the outputArea textField
     */
    public String FindByName() {
        String message;
        String target = name.getText();
        message = myAthletes.FindByName(target);
        return message;
    }

    /**
     * TASK 11
     * Removes the entry specified by the name and date in the
     * name text field and day, month and year buttons
     * once the "Remove" button is pressed
     * @return the output message for the outputArea textField
     */
    public String Remove(){
        String message;
        try {
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            String n = name.getText();

            message = myAthletes.Remove(n,d,m,y);;

        } catch(NumberFormatException e){
            message = "Invalid date input"; //TASK 11: Display a message if the input is invalid
            System.out.println("Remove failed : Invalid input");

        }
        return message;
    }
    /**
     * TASK 14
     * Shows the total distance for all of the records in the past 7 days
     * for every entry type depending on the name text field and day, month and year buttons
     * once the "Weekly distance" button is pressed
     * @return the output message for the outputArea textField
     */
    public String WeekDist(){
         String message;
        try {
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            String n = name.getText();

            message = myAthletes.weeklyDistance(n,d,m,y);;

        } catch(NumberFormatException e){
            message = "Invalid date input"; //TASK 11: Display a message if the input is invalid
            System.out.println("Remove failed : Invalid input");

        }
        return message;


    }

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

} // TrainingRecordGUI

