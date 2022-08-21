package org.launchcode.techjobs.oo;

public class PositionType extends JobField {
    @Override
    public boolean equals(Object a) {
        if (a instanceof PositionType) {
            return ((PositionType) a).getId() == this.getId();
        }
        return false;
    }
    public PositionType(String value) {
        super(value);
    }
}
