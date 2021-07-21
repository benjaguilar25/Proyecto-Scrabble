package types;

public class ScrabbleBool extends AbstractType {

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
        return new ScrabbleString(this.toString());
    }
}
