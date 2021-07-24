package types;

public interface IType {

    // section - TRANSFORMATIONS

    // Any IType can transform to ScrabbleString
    ScrabbleString to_String();

    // section



    // section - OPERATIONS

    // Any IType can be added to a ScrabbleString
    ScrabbleString stringAdd(ScrabbleString added);

    // section
}
