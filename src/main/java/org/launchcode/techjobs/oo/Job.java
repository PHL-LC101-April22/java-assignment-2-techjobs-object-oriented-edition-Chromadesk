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
        this.employer = new Employer("");
        this.location = new Location("");
        this.positionType = new PositionType("");
        this.coreCompetency = new CoreCompetency("");
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
    private String findData(String data) {
        if (data.length() <= 0) return "Data not available.";
        return data;
    }
    @Override
    public String toString() {
        if ((name + employer.getValue() + location.getValue() + positionType.getValue() + coreCompetency.getValue()).length() <= 0) return "/nOOPS! This job does not seem to exist./n";
        String finalPrintout = "";
        ArrayList<String> printValues = new ArrayList<>();
        printValues.add("ID: " + id);
        printValues.add("Name: " + findData(name));
        printValues.add("Employer: " + findData(employer.getValue()));
        printValues.add("Location: " + findData(location.getValue()));
        printValues.add("Position Type: " + findData(positionType.getValue()));
        printValues.add("Core Competency: " + findData(coreCompetency.getValue()));

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
