/*
 * Test class for TrainingRecordGUI
 * It is not finished as we're not expecting you to implement GUI testing
 * However, you're welcome to use this starter template and extend it and add
 * test for public methods you implement in TrainingRecordGUI.java
 */
package com.stir.cscu9t4practical1;

import java.awt.event.ActionEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
// Only used if you want to use reflection to test private features
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.JButton;




/**
 *
 * @author saemundur
 */
public class TrainingRecordGUITest {

    public TrainingRecordGUITest() {
    }

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of main method, of class TrainingRecordGUI.
     * just tests if the class can be initialised without errors
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        TrainingRecordGUI.main(args);
    }

    /**
     * Test of actionPerformed method, of class TrainingRecordGUI.
     * This doesn't test anything but might be used in evaluations
     */
    @Test
    public void testActionPerformed() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        System.out.println("Action not performed");
    }

    /**
     * Test of blankDisplay method, of class TrainingRecordGUI.
     * It just executes the method to see if it doesn't throw an exception
     */
    @Test
    public void testBlankDisplay() {
        System.out.println("blankDisplay");
        TrainingRecordGUI instance = new TrainingRecordGUI();
        instance.blankDisplay();
    }
    
    /**
     * Test of addEntry method, of class TrainingRecordGUI
     * 
     */
    @Test
    public void testAddEntry(){
        System.out.println("addEntry");
        TrainingRecordGUI instance = new TrainingRecordGUI();
        //Test adding a cycle entry
        Entry cycle = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "asphalt", "moderate");
        instance.fillDisplayCycleEntry(cycle,"asphalt","moderate");
        String messageCycle = instance.addEntry("generic");
        System.out.println(messageCycle);
        assertEquals(messageCycle,"Record added\n");
        //Test adding a swim entry
        Entry swim = new SwimEntry("Alice", 2, 2, 2003, 0, 16, 7, 3,"outdoors");
        instance.fillDisplaySwimEntry(swim,"outdoors");
        String messageSwim = instance.addEntry("generic");
        System.out.println(messageSwim);
        assertEquals(messageSwim,"Record added\n");
        //Test adding a sprint entry
        Entry sprint = new SprintEntry("Alice", 3, 2, 2003, 0, 16, 7, 300, 4, 2);
        instance.fillDisplaySprintEntry(sprint,4,2);
        String messageSprint = instance.addEntry("generic");
        System.out.println(messageSprint);
        assertEquals(messageSprint,"Record added\n");
        //Test empty name
        Entry sprintError = new SprintEntry("", 4, 2, 2003, 0, 16, 7, 300, 4, 2);
        instance.fillDisplaySprintEntry(sprintError,4,2);
        String messageError = instance.addEntry("generic");//Should print an error message
        System.out.println(messageError);
        assertEquals(messageError,"Name is empty");

    }
    /**
     * Test of remove method, of class TrainingRecordGUI
     *
     */
    @Test
    public void testRemoveEntry(){
        System.out.println("removeEntry");
        TrainingRecordGUI instance = new TrainingRecordGUI();
        Entry entry = new SwimEntry("Alice", 1, 2, 2003, 0, 16, 7, 3,"outdoors");
        instance.fillDisplaySwimEntry(entry,"outdoors");
        instance.addEntry("Genetic");
        instance.fillDisplaySwimEntry(entry,"outdoors");
        String message = instance.RemoveEntry();
        System.out.println(message);
        assertEquals(message,"Entry removed successfully");
    }
    
    /**
     * Test to see if all display requirements have been met
     */
    @Test
    public void testButtonsPresentInGUI() throws IllegalAccessException, IllegalArgumentException{
        System.out.println("Check if you have added the buttons"); 
        TrainingRecordGUI instance = new TrainingRecordGUI();
        Class<?> instanceClass = instance.getClass();
        String[] expectedFields = {"findAllByDate","lookUpByDate","RemoveEntry"}; // add RemoveEntry when it is ready
        Field fields[] = instanceClass.getDeclaredFields();
        int found = 1;//All of the required buttons have in fact been implemented
        for (Field field : fields) {
            if (Arrays.asList(expectedFields).contains(field.getName())){
                found += 1;
                field.setAccessible(true);
                assertTrue(field.get(instance) instanceof JButton);
            }
        }
        assertEquals(found,expectedFields.length,"Have you added all required buttons?");
    }


}
