package types.Numbers;

import types.IType;

public interface INumber extends IType {
    ScrabbleFloat to_Float();

    ScrabbleFloat floatAdd(ScrabbleFloat added);
    ScrabbleFloat floatSubtract(ScrabbleFloat subtracted);
    ScrabbleFloat floatMultiply(ScrabbleFloat multiplier);
    ScrabbleFloat floatDivide(ScrabbleFloat divider);

    INumber intAdd(ScrabbleInt added);
    INumber intSubtract(ScrabbleInt subtracted);
    INumber intMultiply(ScrabbleInt multiplier);
    INumber intDivide(ScrabbleInt divider);
}
