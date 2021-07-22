package types.Numbers;

import types.AbstractType;
import types.ScrabbleString;

public class ScrabbleInt extends AbstractType implements INumber {

    private int i;
    public ScrabbleInt (int i) {
        this.i = i;
    }

    public int getValue() {
        return i;
    }

    @Override
    public ScrabbleFloat to_Float() {
        return new ScrabbleFloat(Double.parseDouble(this.toString()));
    }

    public ScrabbleInt to_Int() {
        return new ScrabbleInt(i);
    }

    public ScrabbleBinary to_Binary() {
        return new ScrabbleBinary(intToBinary(this.i));
    }

    public String intToBinary(int n) {
        int abs_n = Math.abs(n);
        String bin_n = positiveIntToBinary(abs_n);

        if (n < 0) {
            bin_n = twosComplement(bin_n);
        }

        return bin_n;
    }

    public String positiveIntToBinary(int n) {
        String s = "";
        while (n > 0) {
            s = ((n % 2 ) == 0 ? "0":"1") + s;
            n = n/2;
        }
        return "0" + s;
    }

    public String twosComplement(String s) {
        String neg_s = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                neg_s += "1";
            }
            else {
                neg_s += "0";
            }
        }
        return neg_s;
    }

    @Override
    public ScrabbleString to_String() {
        return new ScrabbleString(this.toString());
    }

    @Override
    public String toString() {
        return String.valueOf(i);
    }

    @Override
    public ScrabbleString stringAdd(ScrabbleString add) {
        return new ScrabbleString(add.getValue() + this.toString());
    }

    public INumber add(INumber added) {
        return intAdd(this);
    }

    public INumber subtract(INumber subtracts) {
        return intSubtract(this);
    }

    public INumber multiply(INumber multiplier) {
        return intMultiply(this);
    }

    public INumber divide(INumber divider) {
        return intDivide(this);
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
        return new ScrabbleInt(this.getValue() + added.getValue());
    }

    @Override
    public INumber intSubtract(ScrabbleInt subtracted) {
        return new ScrabbleInt(this.getValue() - subtracted.getValue());
    }

    @Override
    public INumber intMultiply(ScrabbleInt multiplied) {
        return new ScrabbleInt(this.getValue() * multiplied.getValue());
    }

    @Override
    public INumber intDivide(ScrabbleInt divided) {
        return new ScrabbleInt(this.getValue() / divided.getValue());
    }
}
