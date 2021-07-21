package types;

public class ScrabbleString extends AbstractType {

    private String s;
    public ScrabbleString(String s) {
        this.s = s;
    }

    public String getValue() {
        return s;
    }

    @Override
    public ScrabbleString to_String() {
        return new ScrabbleString(s);
    }

    @Override
    public String toString() {
        return s;
    }

    public ScrabbleString add(AbstractType t) {
        return t.stringAdd(this);
    }

    @Override
    public ScrabbleString stringAdd(ScrabbleString add) {
        return new ScrabbleString(add.s + this.s);
    }
}
