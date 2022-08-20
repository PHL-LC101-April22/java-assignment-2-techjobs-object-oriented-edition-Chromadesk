package org.launchcode.techjobs.oo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;


// TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String aname, Employer aemployer, Location alocation, PositionType apositionType, CoreCompetency acoreCompetency) {
        this();
        this.name = aname;
        this.employer = aemployer;
        this.location = alocation;
        this.positionType = apositionType;
        this.coreCompetency = acoreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object a) {
        if (a instanceof  Job) {
            return ((Job) a).id == this.id;
        }
        return false;
    }
    @Override
    public String toString() {
        //There HAS to be a better way to do this.
        String aname = null;
        String aemployer = null;
        String alocation = null;
        String apositionType = null;
        String acoreCompetency = null;
        if (name == null) {
            aname = "Data not found.";
        } else {
            aname = name;
        }
        if (employer == null) {
            aemployer = "Data not found.";
        } else {
            aemployer = employer.getValue();
        }
        if (location == null) {
            alocation = "Data not found.";
        } else {
            alocation = location.getValue();
        }
        if (positionType == null) {
            apositionType = "Data not found.";
        } else {
            apositionType = positionType.getValue();
        }
        if (coreCompetency == null) {
            acoreCompetency = "Data not found.";
        } else {
            acoreCompetency = coreCompetency.getValue();
        }
        String finalPrintout = "";
        ArrayList<String> printValues = new ArrayList<>();
        printValues.add("ID: " + id);
        printValues.add("Name: " + aname);
        printValues.add("Employer: " + aemployer);
        printValues.add("Location: " + alocation);
        printValues.add("Position Type: " + apositionType);
        printValues.add("Core Competency: " + acoreCompetency);

        for (String line : printValues) {
            finalPrintout += "/n" + line + "/n";
        }
        return finalPrintout;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
