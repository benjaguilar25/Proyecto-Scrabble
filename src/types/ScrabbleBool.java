package types;

import operators.ILogic;
import types.Numbers.ScrabbleBinary;
import types.Numbers.ScrabbleFloat;

import java.util.Objects;

// CLASS
// ScrabbleBool type extends the AbstractType abstract class, which means
// this type can be transformed and added the same way as any IType (every type)
// Implements ILogic interface, which means this type operates
// logically with other ILogic types (ScrabbleBool, ScrabbleBinary)

// stores : boolean b
public class ScrabbleBool extends AbstractType implements ILogic {

    // section - INIT

    // ScrabbleBool type stores boolean java primitive
    private boolean b;
    public ScrabbleBool(boolean b) {
        this.b = b;
    }

    // section


    // section - GETTERS

    // In order to use the Type stored value, a getter will be created
    // returns stored value => boolean b
    public boolean getValue() {
        return b;
    }

    // section


    // section - TRANSFORMATIONS

    @Override
    // ScrabbleBool type can be transformed into a ScrabbleString type
    // returns a new ScrabbleString => ScrabbleString(toStr b)
    public ScrabbleString to_String() {
        return new ScrabbleString(this.toString());
    }

    // ScrabbleBool type can be transformed into itself, if you want of course
    // returns a new ScrabbleBool => ScrabbleBool(boolean b)
    public ScrabbleBool to_Bool() {
        return new ScrabbleBool(b);
    }

    // section


    // section - OPERATE

    // ScrabbleBool type can operate with every ILogic inherit type
    // these operations specifically are Logic ones
    // including and, or & neg
    @Override
    public ILogic and(ILogic operand) {
        return operand.andBool(this);
    }

    @Override
    public ILogic or(ILogic operand) {
        return operand.orBool(this);
    }

    public ScrabbleBool neg() {
        if (this.getValue()) {
            return new ScrabbleBool(false);
        } else {
            return new ScrabbleBool(true);
        }
    }

    // section


    // section - OPERATIONS DD (DOUBLE DISPATCH)


    // ScrabbleBool type can be operated with a ScrabbleString type
    // this will lead to a new ScrabbleString type with both values concatenated as a String primitive
    @Override
    public ScrabbleString stringAdd(ScrabbleString add) {
        return new ScrabbleString(add.getValue() + this.toString());
    }

    // ScrabbleBool type can be operated with every ILogic inherit type
    // these operations specifically are Logic ones
    // including and, or & neg
    @Override
    public ILogic andBool(ScrabbleBool b) {
        return new ScrabbleBool(this.getValue() && b.getValue());
    }

    @Override
    public ILogic andBinary(ScrabbleBinary b) {
        String bin = b.getValue();
        String new_bin = "";
        int l = bin.length();
        for (int i = 0; i < l; i++) {
            if (bin.charAt(i) == '1' && this.getValue()) {
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
        return new ScrabbleBool(this.getValue() || b.getValue());
    }

    @Override
    public ILogic orBinary(ScrabbleBinary b) {
        String bin = b.getValue();
        String new_bin = "";
        int l = bin.length();
        for (int i = 0; i < l; i++) {
            if (bin.charAt(i) == '0' && !this.getValue()) {
                new_bin += "0";
            }
            else {
                new_bin += "1";
            }
        }
        return new ScrabbleBinary(new_bin);
    }

    // section



    // section - NODE

    @Override
    public ScrabbleBool eval() {
        return this;
    }

    // section



    // section - TOSTR DD

    // ToString method is overridden by one that returns a String value of the type
    // returns the stored value as a String => toStr b
    @Override
    public String toString() {
        return String.valueOf(b);
    }

    // section



    // section - TESTING

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AbstractType) {
            var o = (ScrabbleBool) obj;
            return o.getValue() == this.getValue();
        }
        return obj instanceof AbstractType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ScrabbleBool.class);
    }

    // section
}
