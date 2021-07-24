package types;

// INTERFACE

// This interface allude to Types in Scrabble
// every type has a value attached to it as a String, boolean, double, int
// inherited (not implemented explicitly) to
// AbstractType, ScrabbleString, ScrabbleBool, ScrabbleFloat, ScrabbleInt, ScrabbleBinary
public interface IType {

    // section - TRANSFORMATIONS

    // Any IType can transform to a ScrabbleString type
    // IType -> ScrabbleString("value")
    ScrabbleString to_String();

    // section



    // section - OPERATIONS

    // Any IType can be added (concatenated) to a ScrabbleString type
    // : ScrabbleString("val1val2")
    ScrabbleString stringAdd(ScrabbleString added);

    // section
}
