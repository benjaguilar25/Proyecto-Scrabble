package types;

import operators.ILogic;
import types.Numbers.ScrabbleBinary;

public class ScrabbleBool extends AbstractType implements ILogic {

    // section - INIT

    private boolean b;
    public ScrabbleBool(boolean b) {
        this.b = b;
    }

    // section



    // section - GETTERS

    public boolean getValue() {
        return b;
    }

    // section



    // section - TRANSFORMATIONS

    @Override
    public ScrabbleString to_String() {
        return new ScrabbleString(this.toString());
    }

    public ScrabbleBool to_Bool() {
        return new ScrabbleBool(b);
    }

    // section



    // section - OPERATE

    @Override
    public ILogic and(ILogic operand) {
        return andBool(this);
    }

    @Override
    public ILogic or(ILogic operand) {
        return orBool(this);
    }

    public ScrabbleBool neg() {
        if (this.getValue()) {
            return new ScrabbleBool(false);
        }
        else {
            return new ScrabbleBool(true);
        }
    }

    // section



    // section - OPERATIONS DD (DOUBLE DISPATCH)

    @Override
    public ScrabbleString stringAdd(ScrabbleString add) {
        return new ScrabbleString(add.getValue() + this.toString());
    }

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



    // section - TOSTR DD

    @Override
    public String toString() {
        return String.valueOf(b);
    }

    // section
}
