package types;

// INTERFACE

import AST.INode;

// This interface allude to Types in Scrabble
// every type has a value attached to it as a String, boolean, double, int
// inherited (not implemented explicitly) to
// AbstractType, ScrabbleString, ScrabbleBool, ScrabbleFloat, ScrabbleInt, ScrabbleBinary
public interface IType extends INode {

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



    // section - NODE

    IType nAdd(IType adds);
    IType nSubtract(IType subtracts);
    IType nMultiply(IType multiplies);
    IType nDivide(IType divides);

    // section
}
