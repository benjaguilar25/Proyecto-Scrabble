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
}
