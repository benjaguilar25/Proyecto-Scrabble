package types.Numbers;

import types.AbstractType;
import types.ScrabbleString;

public class ScrabbleFloat extends AbstractType {

    private double d;
    public ScrabbleFloat(double d) {
        this.d = d;
    }

    public double getValue() {
        return d;
    }

    public ScrabbleFloat to_Float() {
        return new ScrabbleFloat(d);
    }

    @Override
    public ScrabbleString to_String() {
        return new ScrabbleString(this.toString());
    }

    @Override
    public String toString() {
        return String.valueOf(d);
    }
}