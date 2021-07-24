package types.Numbers;

// INTERFACE
// This interface allude to Binary operating types
// used to filter the operating Number types
// implemented to (ScrabbleInt, ScrabbleBinary)
public interface IBinOperand {

    // section - OPERATIONS

    // Any IBinOperand can be operated with ScrabbleBinary types
    // this leads to ScrabbleBinary types only, since Int and Binary operations
    // needs to be expressed as such (ScrabbleBinary)
    ScrabbleBinary binAdd(ScrabbleBinary added);
    ScrabbleBinary binSubtract(ScrabbleBinary subtracted);
    ScrabbleBinary binMultiply(ScrabbleBinary multiplier);
    ScrabbleBinary binDivide(ScrabbleBinary divider);

    // section



    // section - TRANSFORMATIONS

    // Any IBinOperand can be transformed into ScrabbleBinary and ScrabbleInt types
    ScrabbleBinary to_Binary();
    ScrabbleInt to_Int();

    // section
}
