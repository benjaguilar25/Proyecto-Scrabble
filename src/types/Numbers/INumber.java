package types.Numbers;

import types.IType;

// INTERFACE
// This interface allude to Number types, which extends IType
// implemented to (ScrabbleInt, ScrabbleFloat, ScrabbleInt, ScrabbleBinary)
public interface INumber extends IType {

    // section - TRANSFORMATIONS

    // Any INumber can be transformed into a ScrabbleFloat type
    ScrabbleFloat to_Float();

    // section



    // section - OPERATIONS

    // Any INumber can operate entirely with ScrabbleFloat and ScrabbleInt types

    // Operating with ScrabbleFloat types leads to ScrabbleFloat types only as double java
    // primitive operated with other numbers can't be expressed as another primitive
    ScrabbleFloat floatAdd(ScrabbleFloat added);
    ScrabbleFloat floatSubtract(ScrabbleFloat subtracted);
    ScrabbleFloat floatMultiply(ScrabbleFloat multiplied);
    ScrabbleFloat floatDivide(ScrabbleFloat divided);

    // Operating with ScrabbleInt types leads to any INumber as int java
    // primitive is pretty malleable to acquire types as Float or Binary
    INumber intAdd(ScrabbleInt added);
    INumber intSubtract(ScrabbleInt subtracted);
    INumber intMultiply(ScrabbleInt multiplied);
    INumber intDivide(ScrabbleInt divided);

    // section
}
