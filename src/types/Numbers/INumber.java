package types.Numbers;

import types.IType;

public interface INumber extends IType {

    // section - TRANSFORMATIONS

    ScrabbleFloat to_Float();

    // section



    // section - OPERATIONS

    ScrabbleFloat floatAdd(ScrabbleFloat added);
    ScrabbleFloat floatSubtract(ScrabbleFloat subtracted);
    ScrabbleFloat floatMultiply(ScrabbleFloat multiplied);
    ScrabbleFloat floatDivide(ScrabbleFloat divided);

    INumber intAdd(ScrabbleInt added);
    INumber intSubtract(ScrabbleInt subtracted);
    INumber intMultiply(ScrabbleInt multiplied);
    INumber intDivide(ScrabbleInt divided);

    // section
}
