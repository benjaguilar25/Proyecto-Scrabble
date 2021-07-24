package types.Numbers;

import types.AbstractType;
import types.ScrabbleString;

public class ScrabbleInt extends AbstractType implements INumber, IBinOperand {

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
        return new ScrabbleBinary(intToBinary(this.getValue()));
    }

    public String intToBinary(int n) {
        int abs_n = Math.abs(n);
        if (n < 0) {
            String bin_nFake = positiveIntToBinary(abs_n);
            String bin_n = positiveIntToBinary(abs_n - 1);
            String new_bin = "";
            int l = Math.max(bin_nFake.length(), bin_n.length());
            if (bin_nFake.length() == l) {
                while (bin_n.length() != l) {
                    bin_n = "0" + bin_n;
                }
            }
            else {
                while (bin_nFake.length() != l) {
                    bin_nFake = "0" + bin_nFake;
                }
            }
            bin_n = twosComplement(bin_n);
            return bin_n;
        }
        else {
            String bin_n = positiveIntToBinary(abs_n);
            return bin_n;
        }
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
        ScrabbleBinary neg = new ScrabbleBinary(neg_s);
        return neg.getValue();
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

    public INumber add(INumber adds) {
        return adds.intAdd(this);
    }

    public INumber subtract(INumber subtracts) {
        return subtracts.intSubtract(this);
    }

    public INumber multiply(INumber multiplier) {
        return multiplier.intMultiply(this);
    }

    public INumber divide(INumber divider) {
        return divider.intDivide(this);
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

    @Override
    public ScrabbleBinary binAdd(ScrabbleBinary added) {
        int add = added.to_Int().getValue() + this.getValue();
        ScrabbleInt sAdd_int = new ScrabbleInt(add);
        return sAdd_int.to_Binary();
    }

    @Override
    public ScrabbleBinary binSubtract(ScrabbleBinary subtracted) {
        int subtract = subtracted.to_Int().getValue() - this.getValue();
        ScrabbleInt sSubtract_int = new ScrabbleInt(subtract);
        return sSubtract_int.to_Binary();
    }

    @Override
    public ScrabbleBinary binMultiply(ScrabbleBinary multiplier) {
        int multiply = multiplier.to_Int().getValue() * this.getValue();
        ScrabbleInt sMultiply_int = new ScrabbleInt(multiply);
        return sMultiply_int.to_Binary();
    }

    @Override
    public ScrabbleBinary binDivide(ScrabbleBinary divider) {
        int divide = divider.to_Int().getValue() / this.getValue();
        ScrabbleInt sDivide_int = new ScrabbleInt(divide);
        return sDivide_int.to_Binary();
    }
}


