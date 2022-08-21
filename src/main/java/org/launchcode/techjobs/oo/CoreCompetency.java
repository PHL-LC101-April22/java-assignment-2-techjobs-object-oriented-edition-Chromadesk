package org.launchcode.techjobs.oo;

public class CoreCompetency extends JobField {
    @Override
    public boolean equals(Object a) {
        if (a instanceof CoreCompetency) {
            return ((CoreCompetency) a).getId() == this.getId();
        }
        return false;
    }
    public CoreCompetency(String value) {
        super(value);
    }
}
