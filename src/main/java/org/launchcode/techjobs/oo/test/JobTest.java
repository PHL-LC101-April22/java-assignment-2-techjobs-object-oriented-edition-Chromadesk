package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.util.ArrayList;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    Job soundEngineer;
    Job marketer;
    @Before
    public void createJobObject() {
        soundEngineer = new Job("Sound Engineer", new Employer("Audio Lion"), new Location("California"), new PositionType("Senior"), new CoreCompetency("Experience"));
        marketer = new Job("",new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
    }
    @Test
    public void testSettingJobId() {
        assertNotEquals(soundEngineer, marketer);
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(soundEngineer.getName() instanceof String);
        assertTrue(soundEngineer.getEmployer() instanceof Employer);
        assertTrue(soundEngineer.getLocation() instanceof Location);
        assertTrue(soundEngineer.getPositionType() instanceof PositionType);
        assertTrue(soundEngineer.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Sound Engineer", soundEngineer.getName());
        assertEquals("Audio Lion", soundEngineer.getEmployer().getValue());
        assertEquals("California", soundEngineer.getLocation().getValue());
        assertEquals("Senior", soundEngineer.getPositionType().getValue());
        assertEquals("Experience", soundEngineer.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality() {
        Job cloneEngineer = new Job("Sound Engineer", new Employer("Audio Lion"), new Location("California"), new PositionType("Senior"), new CoreCompetency("Experience"));
        assertFalse(soundEngineer.equals(cloneEngineer));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        char[] jobPrintout = soundEngineer.toString().toCharArray();
        assertEquals("/n", jobPrintout[0] + "" + jobPrintout[1]);
        assertEquals("/n", jobPrintout[jobPrintout.length - 2] + "" + jobPrintout[jobPrintout.length - 1]);
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        String[] jobPrintout = soundEngineer.toString().split("/n");
        ArrayList<String> printArray = new ArrayList<>();
        for (String word : jobPrintout) {
            if (word.length() > 0) {
                printArray.add(word);
            }
        }
        assertTrue(printArray.get(0).contains("ID:"));
        assertTrue(printArray.get(1).contains("Name:"));
        assertTrue(printArray.get(2).contains("Employer:"));
        assertTrue(printArray.get(3).contains("Location:"));
        assertTrue(printArray.get(4).contains("Position Type:"));
        assertTrue(printArray.get(5).contains("Core Competency:"));
    }
    @Test
    public void testToStringHandlesEmptyField() {
        marketer.setName("Marketer");
        String[] jobPrintout = marketer.toString().split("/n");
        ArrayList<String> printArray = new ArrayList<>();
        for (String word : jobPrintout) {
            if (word.length() > 0) {
                printArray.add(word);
            }
        }
        for (int i = 2; i < printArray.size(); i++) {
            assertTrue(printArray.get(i).contains("Data not available"));
        }
    }
    @Test
    public void testToStringPrintsMockErrorForEmptyData() {
        assertEquals("/nOOPS! This job does not seem to exist./n",marketer.toString());
        assertNotEquals("/nOOPS! This job does not seem to exist./n",soundEngineer.toString());
    }
}
