package types.Numbers;

import types.AbstractType;
import types.ScrabbleString;

public class ScrabbleFloat extends AbstractType implements INumber {

    private double d;
    public ScrabbleFloat(double d) {
        this.d = d;
    }

    public double getValue() {
        return d;
    }

    @Override
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

    @Override
    public ScrabbleString stringAdd(ScrabbleString add) {
        return new ScrabbleString(add.getValue() + this.toString());
    }

    public ScrabbleFloat add(INumber adds) {
        return floatAdd(this);
    }

    public ScrabbleFloat subtract(INumber subtracts) {
        return floatSubtract(this);
    }

    public ScrabbleFloat multiply(INumber multiplier) {
        return floatMultiply(this);
    }

    public ScrabbleFloat divide(INumber divider) {
        return floatDivide(this);
    }

    @Override
    public ScrabbleFloat floatAdd(ScrabbleFloat added) {
        return new ScrabbleFloat(this.getValue() + added.getValue());
    }

    @Override
    public ScrabbleFloat floatSubtract(ScrabbleFloat subtracted) {
        return new ScrabbleFloat(this.getValue() - subtracted.getValue());
    }

    @Override
    public ScrabbleFloat floatMultiply(ScrabbleFloat multiplied) {
        return new ScrabbleFloat(this.getValue() * multiplied.getValue());
    }

    @Override
    public ScrabbleFloat floatDivide(ScrabbleFloat divided) {
        return new ScrabbleFloat(this.getValue() / divided.getValue());
    }

    @Override
    public INumber intAdd(ScrabbleInt added) {
        return new ScrabbleFloat(this.getValue() + added.to_Float().getValue());
    }

    @Override
    public INumber intSubtract(ScrabbleInt subtracted) {
        return new ScrabbleFloat(this.getValue() - subtracted.to_Float().getValue());
    }

    @Override
    public INumber intMultiply(ScrabbleInt multiplied) {
        return new ScrabbleFloat(this.getValue() * multiplied.to_Float().getValue());
    }

    @Override
    public INumber intDivide(ScrabbleInt divided) {
        return new ScrabbleFloat(this.getValue() / divided.to_Float().getValue());
    }
}
