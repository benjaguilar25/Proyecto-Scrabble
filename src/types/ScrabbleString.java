package types;

// CLASS
// ScrabbleString type extends the AbstractType abstract class which means
// this type can be transformed and added the same way as any IType (every type)

import types.Numbers.ScrabbleFloat;

import java.util.Objects;

// stores : String s
public class ScrabbleString extends AbstractType {

    // section - INIT

    // ScrabbleString type stores String java primitive
    private String s;
    public ScrabbleString(String s) {
        this.s = s;
    }

    // section



    // section - GETTERS

    // In order to use the Type stored value, a getter will be created
    // returns stored value => String s
    public String getValue() {
        return s;
    }

    // section



    // section - TRANSFORMATIONS

    @Override
    // ScrabbleString type can be transformed into itself, if you want of course
    // returns a new ScrabbleString => ScrabbleString(String s)
    public ScrabbleString to_String() {
        return new ScrabbleString(s);
    }

    // section



    // section - OPERATE

    // ScrabbleString type can add to itself any other type
    // returns and calls another method stringAdd implying a Type is being added to this ScrabbleString
    // stringAdd method is called returning a new ScrabbleString
    public ScrabbleString add(IType added) {
        return added.stringAdd(this);
    }

    // section



    // section - OPERATIONS DD (DOUBLE DISPATCH)

    @Override
    // ScrabbleString type can be added to another ScrabbleString too
    // returns the same type => ScrabbleString(String concatenatedStrings)
    public ScrabbleString stringAdd(ScrabbleString add) {
        return new ScrabbleString(add.getValue() + this.getValue());
    }

    // section



    // section - TOSTR DD

    @Override
    // ToString method is overridden by one that returns a String value of the type
    // returns the stored value => String s
    public String toString() {
        return s;
    }

    // section



    // section - TESTING

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AbstractType) {
            var o = (ScrabbleString) obj;
            return o.s.equals(this.s);
        }
        return obj instanceof AbstractType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ScrabbleString.class);
    }

    // section
}
