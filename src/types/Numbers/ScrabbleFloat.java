package types.Numbers;

import types.AbstractType;
import types.ScrabbleString;

public class ScrabbleFloat extends AbstractType implements INumber {

    // section - INIT

    private double d;
    public ScrabbleFloat(double d) {
        this.d = d;
    }

    // section



    // section - GETTERS

    public double getValue() {
        return d;
    }

    // section



    // section - TRANSFORMATIONS

    @Override
    public ScrabbleString to_String() {
        return new ScrabbleString(this.toString());
    }

    @Override
    public ScrabbleFloat to_Float() {
        return new ScrabbleFloat(d);
    }

    // section



    // section OPERATE

    public ScrabbleFloat add(INumber adds) {
        return adds.floatAdd(this);
    }

    public ScrabbleFloat subtract(INumber subtracts) {
        return subtracts.floatSubtract(this);
    }

    public ScrabbleFloat multiply(INumber multiplier) {
        return multiplier.floatMultiply(this);
    }

    public ScrabbleFloat divide(INumber divider) {
        return divider.floatDivide(this);
    }

    // section



    // section - OPERATIONS DD (DOUBLE DISPATCH)

    @Override
    public ScrabbleString stringAdd(ScrabbleString add) {
        return new ScrabbleString(add.getValue() + this.toString());
    }


    @Override
    public ScrabbleFloat floatAdd(ScrabbleFloat added) {
        return new ScrabbleFloat(added.getValue() + this.getValue());
    }

    @Override
    public ScrabbleFloat floatSubtract(ScrabbleFloat subtracted) {
        return new ScrabbleFloat(subtracted.getValue() - this.getValue());
    }

    @Override
    public ScrabbleFloat floatMultiply(ScrabbleFloat multiplied) {
        return new ScrabbleFloat(multiplied.getValue() * this.getValue());
    }

    @Override
    public ScrabbleFloat floatDivide(ScrabbleFloat divided) {
        return new ScrabbleFloat(divided.getValue() / this.getValue());
    }

    @Override
    public INumber intAdd(ScrabbleInt added) {
        return new ScrabbleFloat(added.to_Float().getValue() + this.getValue());
    }

    @Override
    public INumber intSubtract(ScrabbleInt subtracted) {
        return new ScrabbleFloat(subtracted.to_Float().getValue() - this.getValue());
    }

    @Override
    public INumber intMultiply(ScrabbleInt multiplied) {
        return new ScrabbleFloat(multiplied.to_Float().getValue() * this.getValue());
    }

    @Override
    public INumber intDivide(ScrabbleInt divided) {
        return new ScrabbleFloat(divided.to_Float().getValue() / this.getValue());
    }

    // section



    // section - TOSTR DD

    @Override
    public String toString() {
        return String.valueOf(d);
    }

    // section
}
