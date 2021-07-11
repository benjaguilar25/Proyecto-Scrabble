package types.Numbers;

import types.AbstractType;
import types.ScrabbleBool;
import types.ScrabbleString;

public class ScrabbleInt extends AbstractType {

    private int i;
    public ScrabbleInt (int i) {
        this.i = i;
    }

    public int getValue() {
        return i;
    }

    public ScrabbleFloat to_Float() {
        return new ScrabbleFloat(Double.parseDouble(this.toString()));
    }

    public ScrabbleInt to_Int() {
        return new ScrabbleInt(i);
    }

    public ScrabbleBinary to_Binary() {
        return new ScrabbleBinary();
    }

    @Override
    public ScrabbleString to_String() {
        return new ScrabbleString(this.toString());
    }

    @Override
    public String toString() {
        return String.valueOf(i);
    }
}
