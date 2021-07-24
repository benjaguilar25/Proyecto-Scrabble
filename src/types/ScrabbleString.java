package types;

//
public class ScrabbleString extends AbstractType {

    // section - INIT

    private String s;
    public ScrabbleString(String s) {
        this.s = s;
    }

    // section



    // section - GETTERS

    public String getValue() {
        return s;
    }

    // section



    // section - TRANSFORMATIONS

    @Override
    public ScrabbleString to_String() {
        return new ScrabbleString(s);
    }

    // section



    // section - OPERATE

    public ScrabbleString add(IType added) {
        return added.stringAdd(this);
    }

    // section



    // section - OPERATIONS DD (DOUBLE DISPATCH)

    @Override
    public ScrabbleString stringAdd(ScrabbleString add) {
        return new ScrabbleString(add.getValue() + this.getValue());
    }

    // section



    // section - TOSTR DD

    @Override
    public String toString() {
        return s;
    }

    // section
}
