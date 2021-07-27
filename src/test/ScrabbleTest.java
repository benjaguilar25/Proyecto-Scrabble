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
    private int intVal = -2;
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

        assertEquals(expectedSString.hashCode(), sString.hashCode());
        assertEquals(expectedSBool.hashCode(), sBool.hashCode());
        assertEquals(expectedSFloat.hashCode(), sFloat.hashCode());
        assertEquals(expectedSInt.hashCode(), sInt.hashCode());
        assertEquals(expectedSBin.hashCode(), sBin.hashCode());
    }



    @Test
    void stringTrans() {
        var expectedSString = new ScrabbleString(strVal);

        assertEquals(sString.to_String(), expectedSString);
    }

    @Test
    void boolTrans() {
        var expectedSBool = new ScrabbleBool(boolVal);
        var expectedSString = new ScrabbleString(String.valueOf(boolVal));

        assertEquals(sBool.to_Bool(), expectedSBool);
        assertEquals(sBool.to_String(), expectedSString);
    }

    @Test
    void floatTrans() {
        var expectedSFloat = new ScrabbleFloat(floatVal);
        var expectedSString = new ScrabbleString(String.valueOf(floatVal));

        assertEquals(sFloat.to_Float(), expectedSFloat);
        assertEquals(sFloat.to_String(), expectedSString);
    }

    @Test
    void intTrans() {
        var expectedSInt = new ScrabbleInt(intVal);
        var expectedSString = new ScrabbleString(String.valueOf(intVal));
        var expectedSFloat = new ScrabbleFloat(Double.valueOf(intVal));
        var expectedSBinary = new ScrabbleBinary(sInt.intToBinary(intVal));

        assertEquals(sInt.to_Int(), expectedSInt);
        assertEquals(sInt.to_String(), expectedSString);
        assertEquals(sInt.to_Float(), expectedSFloat);
        assertEquals(sInt.to_Binary(), expectedSBinary);
    }

    @Test
    void binTrans() {
        var expectedSBin = new ScrabbleBinary(binVal);
        var expectedSString = new ScrabbleString(binVal);
        var expectedSFloat = new ScrabbleFloat(Double.parseDouble(String.valueOf(sBin.binToInt(binVal))));
        var expectedSInt = new ScrabbleInt(sBin.binToInt(binVal));

        assertEquals(sBin, expectedSBin);
        assertEquals(sBin.to_String(), expectedSString);
        assertEquals(sBin.to_Float(), expectedSFloat);
        assertEquals(sBin.to_Int(), expectedSInt);
    }

    @Test
    void stringOp() {
        var expectedSString = new ScrabbleString(strVal + strVal);
        var expectedSBool = new ScrabbleString(strVal + String.valueOf(boolVal));
        var expectedSFloat = new ScrabbleString(strVal + String.valueOf(floatVal));
        var expectedSInt = new ScrabbleString(strVal + String.valueOf(intVal));
        var expectedSBin = new ScrabbleString(strVal + binVal);

        assertEquals(sString.add(sString), expectedSString);
        assertEquals(sString.add(sBool), expectedSBool);
        assertEquals(sString.add(sFloat), expectedSFloat);
        assertEquals(sString.add(sInt), expectedSInt);
        assertEquals(sString.add(sBin), expectedSBin);
    }

    @Test
    void boolOp() {

    }
}
