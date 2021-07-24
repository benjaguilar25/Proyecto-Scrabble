package types.Numbers;

import operators.ILogic;
import types.AbstractType;
import types.ScrabbleBool;
import types.ScrabbleString;

public class ScrabbleBinary extends AbstractType implements INumber, IBinOperand, ILogic {

    // section - INIT

    private String b;
    public ScrabbleBinary(String b) {
        this.b = b;
    }

    // section



    // section - GETTERS

    public String getValue() {
        return b;
    }

    // section



    // section - TRANSFORMATIONS

    @Override
    public ScrabbleString to_String() {
        return new ScrabbleString(this.toString());
    }

    @Override
    public ScrabbleFloat to_Float() {
        return this.to_Int().to_Float();
    }

    @Override
    public ScrabbleInt to_Int() {
        return new ScrabbleInt(binToInt(b));
    }

    @Override
    public ScrabbleBinary to_Binary() {
        return new ScrabbleBinary(b);
    }

    // section



    // section - AUX INT TRANSFORMATIONS

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

    // section



    // section - OPERATE

    public IBinOperand add(IBinOperand adds) {
        return adds.binAdd(this);
    }

    public IBinOperand subtract(IBinOperand subtracts) {
        return subtracts.binSubtract(this);
    }

    public IBinOperand multiply(IBinOperand multiplier) {
        return multiplier.binMultiply(this);
    }

    public IBinOperand divide(IBinOperand divider) {
        return divider.binDivide(this);
    }

    @Override
    public ILogic and(ILogic operand) {
        return operand.andBinary(this);
    }

    @Override
    public ILogic or(ILogic operand) {
        return operand.orBinary(this);
    }

    public ScrabbleBinary neg() {
        String neg_value = neg_string(this.getValue());
        return new ScrabbleBinary(neg_value);
    }

    // section



    // section - AUX NEG OPERATION

    public String neg_string(String s) {
        String neg_value = "";
        for (int i = 0; i < this.getValue().length(); i++) {
            if (this.getValue().charAt(i) == '0') {
                neg_value += "1";
            }
            else {
                neg_value += "0";
            }
        }
        return neg_value;
    }

    // section



    // section - OPERATIONS DD (DOUBLE DISPATCH)

    @Override
    public ScrabbleString stringAdd(ScrabbleString add) {
        return new ScrabbleString(add.getValue() + this.toString());
    }

    @Override
    public ScrabbleFloat floatAdd(ScrabbleFloat added) {
        return new ScrabbleFloat(added.getValue() + this.to_Float().getValue());
    }

    @Override
    public ScrabbleFloat floatSubtract(ScrabbleFloat subtracted) {
        return new ScrabbleFloat(subtracted.getValue() - this.to_Float().getValue());
    }

    @Override
    public ScrabbleFloat floatMultiply(ScrabbleFloat multiplied) {
        return new ScrabbleFloat(multiplied.getValue() * this.to_Float().getValue());
    }

    @Override
    public ScrabbleFloat floatDivide(ScrabbleFloat divided) {
        return new ScrabbleFloat(divided.getValue() / this.to_Float().getValue());
    }

    @Override
    public INumber intAdd(ScrabbleInt added) {
        return new ScrabbleInt(added.getValue() + this.to_Int().getValue());
    }

    @Override
    public INumber intSubtract(ScrabbleInt subtracted) {
        return new ScrabbleInt(subtracted.getValue() - this.to_Int().getValue());
    }

    @Override
    public INumber intMultiply(ScrabbleInt multiplied) {
        return new ScrabbleInt(multiplied.getValue() * this.to_Int().getValue());
    }

    @Override
    public INumber intDivide(ScrabbleInt divided) {
        return new ScrabbleInt(divided.getValue() / this.to_Int().getValue());
    }

    @Override
    public ScrabbleBinary binAdd(ScrabbleBinary added) {
        int add = added.to_Int().getValue() + this.to_Int().getValue();
        ScrabbleInt sAdd_int = new ScrabbleInt(add);
        return sAdd_int.to_Binary();
    }

    @Override
    public ScrabbleBinary binSubtract(ScrabbleBinary subtracted) {
        int subtract = subtracted.to_Int().getValue() - this.to_Int().getValue();
        ScrabbleInt sSubtract_int = new ScrabbleInt(subtract);
        return sSubtract_int.to_Binary();
    }

    @Override
    public ScrabbleBinary binMultiply(ScrabbleBinary multiplier) {
        int multiply = multiplier.to_Int().getValue() * this.to_Int().getValue();
        ScrabbleInt sMultiply_int = new ScrabbleInt(multiply);
        return sMultiply_int.to_Binary();
    }

    @Override
    public ScrabbleBinary binDivide(ScrabbleBinary divider) {
        int divide = divider.to_Int().getValue() / this.to_Int().getValue();
        ScrabbleInt sDivide_int = new ScrabbleInt(divide);
        return sDivide_int.to_Binary();
    }

    @Override
    public ILogic andBool(ScrabbleBool b) {
        String bin = this.getValue();
        String new_bin = "";
        int l = bin.length();
        for (int i = 0; i < l; i++) {
            if (bin.charAt(i) == '1' && b.getValue()) {
                new_bin += "1";
            }
            else {
                new_bin += "0";
            }
        }
        return new ScrabbleBinary(new_bin);
    }

    @Override
    public ILogic andBinary(ScrabbleBinary b) {
        String bin1 = b.getValue();
        String bin2 = this.getValue();
        int l = Math.max(bin1.length(), bin2.length());
        String new_bin = normalizeBin(bin1, bin2);

        for (int i = 0; i < l; i++) {
            if (bin1.charAt(i) == '1' && bin2.charAt(i) == '1') {
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
            if (bin.charAt(i) == '0' && !b.getValue()) {
                new_bin += "0";
            }
            else {
                new_bin += "1";
            }
        }
        return new ScrabbleBinary(new_bin);
    }

    @Override
    public ILogic orBinary(ScrabbleBinary b) {
        String bin1 = b.getValue();
        String bin2 = this.getValue();
        int l = Math.max(bin1.length(), bin2.length());
        String new_bin = normalizeBin(bin1, bin2);

        for (int i = 0; i < l; i++) {
            if (bin1.charAt(i) == '0' && bin2.charAt(i) == '0') {
                new_bin += "0";
            }
            else {
                new_bin += "1";
            }
        }
        return new ScrabbleBinary(new_bin);
    }

    // section



    // section - AUX BINARY OPERATION

    public String normalizeBin(String bin1, String bin2) {
        String new_bin = "";
        int l = Math.max(bin1.length(), bin2.length());
        if (bin1.length() == l) {
            while (bin2.length() != l) {
                bin2 = "0" + bin2;
            }
        }
        else {
            while (bin1.length() != l) {
                bin1 = "0" + bin1;
            }
        }
        return new_bin;
    }

    // section



    // section - TOSTR DD

    @Override
    public String toString() {
        return b;
    }

    //

}
