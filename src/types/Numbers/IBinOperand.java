package types.Numbers;

public interface IBinOperand {

    // section - OPERATIONS

    ScrabbleBinary binAdd(ScrabbleBinary added);
    ScrabbleBinary binSubtract(ScrabbleBinary subtracted);
    ScrabbleBinary binMultiply(ScrabbleBinary multiplier);
    ScrabbleBinary binDivide(ScrabbleBinary divider);

    // section



    // section - TRANSFORMATIONS

    ScrabbleBinary to_Binary();
    ScrabbleInt to_Int();

    // section
}
