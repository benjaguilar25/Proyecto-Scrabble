package types.Numbers;

import operators.ILogic;
import types.AbstractType;
import types.IType;
import types.ScrabbleBool;
import types.ScrabbleString;

public class ScrabbleBinary extends AbstractType implements INumber, IBinary, ILogic {

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

    @Override
    public ScrabbleFloat to_Float() {
        return this.to_Int().to_Float();
    }

    @Override
    public ScrabbleBinary to_Binary() {
        return new ScrabbleBinary(b);
    }

    @Override
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

    @Override
    public ILogic and(ILogic operand) {
        return operand.andBinary(this);
    }

    @Override
    public ILogic or(ILogic operand) {
        return operand.orBinary(this);
    }

    @Override
    public ILogic andBool(ScrabbleBool b) {
        String bin = this.getValue();
        String new_bin = "";
        int l = bin.length();
        for (int i = 0; i < l; i++) {
            if (bin.charAt(i) == '1' && b.getValue() == true) {
                new_bin += "1";
            }
            else {
                new_bin += "0";
            }
        }
        return new ScrabbleBinary(new_bin);
    }

    @Override
    public ILogic orBool(ScrabbleBool b) {
        String bin = this.getValue();
        String new_bin = "";
        int l = bin.length();
        for (int i = 0; i < l; i++) {
            if (bin.charAt(i) == '0' && b.getValue() == false) {
                new_bin += "0";
            }
            else {
                new_bin += "1";
            }
        }
        return new ScrabbleBinary(new_bin);
    }

    public IType add()

    @Override
    public ScrabbleBinary binAdd(ScrabbleBinary added) {
        return null;
    }

    @Override
    public ScrabbleBinary binSubtract(ScrabbleBinary subtracted) {
        return null;
    }

    @Override
    public ScrabbleBinary binMultiply(ScrabbleBinary multiplier) {
        return null;
    }

    @Override
    public ScrabbleBinary binDivide(ScrabbleBinary divider) {
        return null;
    }

    @Override
    public ScrabbleFloat floatAdd(ScrabbleFloat added) {
        return null;
    }

    @Override
    public ScrabbleFloat floatSubtract(ScrabbleFloat subtracted) {
        return null;
    }

    @Override
    public ScrabbleFloat floatMultiply(ScrabbleFloat multiplied) {
        return null;
    }

    @Override
    public ScrabbleFloat floatDivide(ScrabbleFloat divided) {
        return null;
    }

    @Override
    public INumber intAdd(ScrabbleInt added) {
        return null;
    }

    @Override
    public INumber intSubtract(ScrabbleInt subtracted) {
        return null;
    }

    @Override
    public INumber intMultiply(ScrabbleInt multiplied) {
        return null;
    }

    @Override
    public INumber intDivide(ScrabbleInt divided) {
        return null;
    }
}
