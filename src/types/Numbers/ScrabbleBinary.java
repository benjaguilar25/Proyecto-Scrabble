package types.Numbers;

import types.AbstractType;
import types.ScrabbleString;

public class ScrabbleBinary extends AbstractType {

    private String b;
    public ScrabbleBinary(String b) {
        this.b = b;
    }

    public String getValue() {
        return b;
    }

    @Override
    public ScrabbleString to_String() {
        return new ScrabbleString(this.toString());
    }

    @Override
    public String toString() {
        return b;
    }

    public ScrabbleFloat to_Float() {
        return this.to_Int().to_Float();
    }

    public ScrabbleBinary to_Binary() {
        return new ScrabbleBinary(b);
    }

    public ScrabbleInt to_Int() {
        return new ScrabbleInt(binToInt(b));
    }

    public int binToInt(String binary) {
        if (bitToInt(binary.charAt(0)) == 0) {
            return positiveBinToInt(binary);
        } else {
            return negativeBinaryToInt(binary);
        }
    }
    private int negativeBinaryToInt(String binary) {
        int n = binary.length() - 1;
        int w = -bitToInt(binary.charAt(0)) * (int) Math.pow(2, n);
        for (int i = n, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * (binary.charAt(i) == '1' ? 1 : 0);
        }
        return w;
    }
    private int positiveBinToInt(String binary) {
        int w = 0;
        for (int i = binary.length() - 1, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * bitToInt(binary.charAt(i));
        }
        return w;
    }
    private int bitToInt(char bit) {
        return bit == '0' ? 0 : 1;
    }

    @Override
    public ScrabbleString stringAdd(ScrabbleString add) {
        return new ScrabbleString(add.getValue() + this.toString());
    }

}
