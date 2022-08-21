package org.launchcode.techjobs.oo;

public class Location extends JobField {
    @Override
    public boolean equals(Object a) {
        if (a instanceof Location) {
            return ((Location) a).getId() == this.getId();
        }
        return false;
    }
    public Location(String value) {
        super(value);
    }
}
