package org.launchcode.techjobs.oo;

public class Employer extends JobField {
    @Override
    public boolean equals(Object a) {
        if (a instanceof Employer) {
            return ((Employer) a).getId() == this.getId();
        }
        return false;
    }
    public Employer (String value) {
        super(value);
    }
}
