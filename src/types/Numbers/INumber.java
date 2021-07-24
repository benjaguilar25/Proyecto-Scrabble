package types.Numbers;

import types.IType;

public interface INumber extends IType {
    ScrabbleFloat to_Float();

    ScrabbleFloat floatAdd(ScrabbleFloat added);
    ScrabbleFloat floatSubtract(ScrabbleFloat subtracted);
    ScrabbleFloat floatMultiply(ScrabbleFloat multiplied);
    ScrabbleFloat floatDivide(ScrabbleFloat divided);

    INumber intAdd(ScrabbleInt added);
    INumber intSubtract(ScrabbleInt subtracted);
    INumber intMultiply(ScrabbleInt multiplied);
    INumber intDivide(ScrabbleInt divided);
}