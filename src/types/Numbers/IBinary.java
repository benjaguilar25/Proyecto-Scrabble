package types.Numbers;

public interface IBinary {

    ScrabbleBinary binAdd(ScrabbleBinary added);
    ScrabbleBinary binSubtract(ScrabbleBinary subtracted);
    ScrabbleBinary binMultiply(ScrabbleBinary multiplier);
    ScrabbleBinary binDivide(ScrabbleBinary divider);

    ScrabbleBinary to_Binary();
    ScrabbleInt to_Int();
}
