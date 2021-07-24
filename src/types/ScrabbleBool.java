package types;

import operators.ILogic;
import types.Numbers.ScrabbleBinary;

public class ScrabbleBool extends AbstractType implements ILogic {

    private boolean b;
    public ScrabbleBool(boolean b) {
        this.b = b;
    }

    public boolean getValue() {
        return b;
    }

    public ScrabbleBool to_Bool() {
        return new ScrabbleBool(b);
    }

    @Override
    public ScrabbleString to_String() {
        return new ScrabbleString(this.toString());
    }

    @Override
    public String toString() {
        return String.valueOf(b);
    }

    @Override
    public ScrabbleString stringAdd(ScrabbleString add) {
        return new ScrabbleString(add.getValue() + this.toString());
    }

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
}
