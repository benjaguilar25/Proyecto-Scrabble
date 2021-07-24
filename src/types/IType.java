package types;

// INTERFACE

// This interface allude to Types in Scrabble
// implemented to (AbstractType, ScrabbleString, ScrabbleBool, ScrabbleFloat, ScrabbleInt, ScrabbleBinary)
public interface IType {

    // section - TRANSFORMATIONS

    // Any IType can transform to a ScrabbleString type
    ScrabbleString to_String();

    // section



    // section - OPERATIONS

    // Any IType can be added to a ScrabbleString type
    ScrabbleString stringAdd(ScrabbleString added);

    // section
}
