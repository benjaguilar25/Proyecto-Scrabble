package types.Numbers;

import operators.ILogic;
import types.AbstractType;
import types.ScrabbleBool;
import types.ScrabbleString;

// CLASS
// ScrabbleBinary type extends the AbstractType abstract class, which means
// this type can be transformed and added the same way any IType does (every type)
// Implements INumber interface, which means this type transform, operates, and
// can be operated as any other INumber types (ScrabbleFloat, ScrabbleInt, ScrabbleBinary)
// Implements IBinOperand interface, which means ScrabbleBinary type transform and operates
// with ScrabbleInt types and self one exclusively (ScrabbleInt, ScrabbleBinary)
// Implements ILogic interface, which means this type operates
// logically with any other ILogic types (ScrabbleBool, ScrabbleBinary)

// stores : String b
public class ScrabbleBinary extends AbstractType implements INumber, IBinOperand, ILogic {

    // section - INIT

    // ScrabbleBinary type stores String java primitive
    private String b;
    public ScrabbleBinary(String b) {
        this.b = b;
    }

    // section



    // section - GETTERS

    // In order to use the Type stored value, a getter will be created
    // returns stored value => String b
    public String getValue() {
        return b;
    }

    // section



    // section - TRANSFORMATIONS

    @Override
    // ScrabbleBinary type can be transformed into a ScrabbleString type
    // returns a new ScrabbleString => ScrabbleString(toStr b)
    public ScrabbleString to_String() {
        return new ScrabbleString(this.toString());
    }

    @Override
    // ScrabbleBinary type can be transformed into a ScrabbleFloat type
    // returns a new ScrabbleFloat => ScrabbleString(toDouble b)
    public ScrabbleFloat to_Float() {
        return this.to_Int().to_Float();
    }

    @Override
    // ScrabbleBinary type can be transformed into a ScrabbleInt type
    // returns a new ScrabbleInt => ScrabbleInt(toInt b)
    public ScrabbleInt to_Int() {
        return new ScrabbleInt(binToInt(b));
    }

    @Override
    // ScrabbleBinary type can be transformed into itself, if you want of course
    // returns a new ScrabbleBinary => ScrabbleBinary(String b)
    public ScrabbleBinary to_Binary() {
        return new ScrabbleBinary(b);
    }

    // section



    // section - AUX INT TRANSFORMATIONS

    // This methods were delivered by the assignment's PDF
    // returns any String bin to int

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

    // ScrabbleBinary type can add/subtract/multiply/divide with any other IBinOperand inherit type
    // returns and calls another method binAdd implying a Type is being added to this ScrabbleBinary

    // Operating with ScrabbleBinary types leads to different types since int
    // primitive is malleable to other INumber primitives results
    // binOp methods are called returning a new ScrabbleBinary
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

    // ScrabbleBinary type can operate with every ILogic inherit type
    // this operations specifically are Logic ones
    // including and, or & neg
    @Override
    public ILogic and(ILogic operand) {
        return operand.andBinary(this);
    }

    @Override
    public ILogic or(ILogic operand) {
        return operand.orBinary(this);
    }

    public ScrabbleBinary neg() {
        return new ScrabbleBinary(this.neg_binary());
    }

    // section



    // section - AUX NEG OPERATION

    public String neg_binary() {
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

    // ScrabbleBinary type can be operated with a ScrabbleString type
    // this will lead to a new ScrabbleString type with both values concatenated as a String primitive
    @Override
    public ScrabbleString stringAdd(ScrabbleString add) {
        return new ScrabbleString(add.getValue() + this.toString());
    }

    // ScrabbleBinary type can be added/subtracted/multiplied/divided with a ScrabbleFloat type
    // this will lead to a new ScrabbleFloat type with the operation made as a double value
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

    // ScrabbleBinary type can be added/subtracted/multiplied/divided with a ScrabbleInt type
    // this will lead to a new ScrabbleInt type with the operation interpreted as an int value
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

    // ScrabbleBinary type can be added/subtracted/multiplied/divided with a ScrabbleBinary type
    // this will lead to a new ScrabbleBinary type with the operation interpreted as a String value
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

    // ScrabbleBinary type can be operated with every ILogic inherit type
    // this operations specifically are Logic ones
    // including and, or & neg
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

    // Method created to simplify and avoid mistakes when operating String binaries
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

    // ToString method is overridden by one that returns a String value of the type
    // returns the stored value as a String => String b
    @Override
    public String toString() {
        return b;
    }

    // section



    // section - TESTING

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AbstractType) {
            var o = (ScrabbleBinary) obj;
            return o.b.equals(this.b);
        }
        return obj instanceof AbstractType;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    // section

}
