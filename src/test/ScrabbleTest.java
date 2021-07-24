package test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import types.Numbers.ScrabbleBinary;
import types.Numbers.ScrabbleFloat;
import types.Numbers.ScrabbleInt;
import types.ScrabbleBool;
import types.ScrabbleString;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Random;


public class ScrabbleTest {
    private ScrabbleString sString;
    private ScrabbleBool sBool;
    private ScrabbleFloat sFloat;
    private ScrabbleInt sInt;
    private ScrabbleBinary sBin;

    private int seed;
    private Random rng;

    private String strVal = "Text";
    private boolean boolVal = true;
    private double floatVal = 2.5;
    private int intVal = 2;
    private String binVal = "01010";

    @BeforeEach
    void setUp() {
        seed = new Random().nextInt();
        rng = new Random(seed);
        sString = new ScrabbleString(strVal);
        sBool = new ScrabbleBool(boolVal);
        sFloat = new ScrabbleFloat(floatVal);
        sInt = new ScrabbleInt(intVal);
        sBin = new ScrabbleBinary(binVal);
    }

    @Test
    void constructorTest() {
        var expectedSString = new ScrabbleString(strVal);
        var expectedSBool = new ScrabbleBool(boolVal);
        var expectedSFloat = new ScrabbleFloat(floatVal);
        var expectedSInt = new ScrabbleInt(intVal);
        var expectedSBin = new ScrabbleBinary(binVal);

        assertEquals(expectedSString, sString);
        assertEquals(expectedSBool, sBool);
        assertEquals(expectedSFloat, sFloat);
        assertEquals(expectedSInt, sInt);
        assertEquals(expectedSBin, sBin);
    }
}
