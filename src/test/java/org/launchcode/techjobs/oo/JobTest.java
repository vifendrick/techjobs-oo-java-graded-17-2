package org.launchcode.techjobs.oo;

import org.junit.Test;

import javax.naming.Name;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;
import static org.testng.Assert.assertNotEquals;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId () {
        Job jobTestOne = new Job();
        Job jobTestTwo = new Job();
        assertNotEquals(jobTestOne.getId(), jobTestTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job jobTest = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(jobTest.getName() instanceof String);
        assertTrue(jobTest.getEmployer() instanceof Employer);
        assertTrue(jobTest.getLocation() instanceof Location);
        assertTrue(jobTest.getPositionType() instanceof PositionType);
        assertTrue(jobTest.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(jobTest.getName(), "Product tester");
        assertEquals(jobTest.getEmployer().getValue(), "ACME");
        assertEquals(jobTest.getLocation().getValue(), "Desert");
        assertEquals(jobTest.getPositionType().getValue(), "Quality control");
        assertEquals(jobTest.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job jobTestOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobTestTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(jobTestOne.equals(jobTestTwo));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job jobTest = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(jobTest.toString().startsWith(lineSeparator()));
        assertTrue(jobTest.toString().endsWith(lineSeparator()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job jobTest = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(lineSeparator() + "ID: " + jobTest.getId() + "\n" + "Name: " + jobTest.getName() + "\n" + "Employer: " + jobTest.getEmployer() +  "\n" + "Location: " + jobTest.getLocation() + "\n" + "Position Type: " + jobTest.getPositionType() + "\n" + "Core Competency: " + jobTest.getCoreCompetency() + lineSeparator(), jobTest.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job jobTest = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals(lineSeparator() + "ID: " + jobTest.getId() + "\n" + "Name: Data Not Available\n" + "Employer: Data Not Available\n" + "Location: Data Not Available\n" + "Position Type: Data Not Available\n" + "Core Competency: Data Not Available\n" + lineSeparator(), jobTest.toString());
    }

}
