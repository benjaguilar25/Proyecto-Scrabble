package types.Numbers;

import types.AbstractType;
import types.ScrabbleString;

// CLASS
// ScrabbleInt type extends the AbstractType abstract class, which means
// this type can be transformed and added the same way as any IType (every type)
// Implements INumber interface, which means this type transform, operates, and
// can be operated as other INumber types (ScrabbleFloat, ScrabbleInt, ScrabbleBinary)
// Implements IBinOperand interface, which means ScrabbleBinary type transform and operates
// with ScrabbleBinary types and this one exclusively (ScrabbleBinary, ScrabbleInt)

// stores : int i
public class ScrabbleInt extends AbstractType implements INumber, IBinOperand {

    // section - INIT

    // ScrabbleInt type stores int java primitive
    private int i;
    public ScrabbleInt (int i) {
        this.i = i;
    }

    // section



    // section - GETTER

    // In order to use the Type stored value, a getter will be created
    // returns stored value => int i
    public int getValue() {
        return i;
    }

    // section



    // section - TRANSFORMATIONS

    @Override
    // ScrabbleInt type can be transformed into a ScrabbleString type
    // returns a new ScrabbleString => ScrabbleString(toStr i)
    public ScrabbleString to_String() {
        return new ScrabbleString(this.toString());
    }

    @Override
    // ScrabbleInt type can be transformed into a ScrabbleFloat type
    // returns a new ScrabbleFloat => ScrabbleFloat(toDouble i)
    public ScrabbleFloat to_Float() {
        return new ScrabbleFloat(Double.parseDouble(this.toString()));
    }

    // ScrabbleInt type can be transformed into itself, if you want of course
    // returns a new ScrabbleInt => ScrabbleInt(int i)
    public ScrabbleInt to_Int() {
        return new ScrabbleInt(i);
    }

    // ScrabbleInt type can be transformed into a ScrabbleBinary type
    // returns a new ScrabbleBinary => ScrabbleBinary(toBinStr i)
    public ScrabbleBinary to_Binary() {
        return new ScrabbleBinary(intToBinary(this.getValue()));
    }

    // section




    // section - AUX BINARY TRANSFORMATIONS

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
        return neg_s;
    }

    // section



    // section - OPERATE

    // ScrabbleInt type can add/subtract/multiply/divide with any other INumber inherit type
    // returns and calls another method floatAdd implying a Type is being added to this ScrabbleFloat

    // Operating with ScrabbleInt types leads to different types since int
    // primitive is malleable to other INumber primitives results
    // intOp methods are called returning a new ScrabbleInt
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

    // section



    // section - OPERATIONS DD (DOUBLE DISPATCH)

    // ScrabbleInt type can be added with a ScrabbleString type
    // this will lead to a new ScrabbleString type with both values concatenated as a String primitive
    @Override
    public ScrabbleString stringAdd(ScrabbleString added) {
        return new ScrabbleString(added.getValue() + this.toString());
    }

    // ScrabbleInt type can be added/subtracted/multiplied/divided with a ScrabbleFloat type
    // this will lead to a new ScrabbleFloat type with the operation interpreted as a double value
    @Override
    public ScrabbleFloat floatAdd(ScrabbleFloat added) {
        return new ScrabbleFloat( added.getValue() + this.getValue());
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
        return new ScrabbleFloat(divided.getValue() / this.getValue() );
    }

    // ScrabbleInt type can be added/subtracted/multiplied/divided with a ScrabbleInt type
    // this will lead to a new ScrabbleInt type with the operation interpreted as an int value
    @Override
    public INumber intAdd(ScrabbleInt added) {
        return new ScrabbleInt(added.getValue() + this.getValue());
    }

    @Override
    public INumber intSubtract(ScrabbleInt subtracted) {
        return new ScrabbleInt(subtracted.getValue() - this.getValue());
    }

    @Override
    public INumber intMultiply(ScrabbleInt multiplied) {
        return new ScrabbleInt(multiplied.getValue() * this.getValue());
    }

    @Override
    public INumber intDivide(ScrabbleInt divided) {
        return new ScrabbleInt(divided.getValue() / this.getValue());
    }

    // ScrabbleInt type can be added/subtracted/multiplied/divided with a ScrabbleBinary type
    // this will lead to a new ScrabbleBinary type with the operation interpreted as a String value
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

    // section



    // section - TOSTR DD

    // ToString method is overridden by one that returns a String value of the type
    // returns the stored value as a String => toStr i
    @Override
    public String toString() {
        return String.valueOf(i);
    }

    // section
}


