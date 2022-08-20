package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

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
        marketer = new Job();
    }
    @Test
    public void testSettingJobId() {
        assertNotEquals(soundEngineer, marketer);
    }
    @Test
    public void testConstructorSetsAllFields() {
        assertTrue(soundEngineer.getEmployer() instanceof Employer);
        assertTrue(soundEngineer.getLocation() instanceof Location);
        assertTrue(soundEngineer.getPositionType() instanceof PositionType);
        assertTrue(soundEngineer.getCoreCompetency() instanceof CoreCompetency);
        assertSame("Sound Engineer", soundEngineer.getName());
        assertSame("Audio Lion", soundEngineer.getEmployer().getValue());
        assertSame("California", soundEngineer.getLocation().getValue());
        assertSame("Senior", soundEngineer.getPositionType().getValue());
        assertSame("Experience", soundEngineer.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality() {
        Job cloneEngineer = new Job("Sound Engineer", new Employer("Audio Lion"), new Location("California"), new PositionType("Senior"), new CoreCompetency("Experience"));
        assertFalse(soundEngineer.equals(cloneEngineer));
    }
}
