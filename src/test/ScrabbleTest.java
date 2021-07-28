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
    private ScrabbleBool sBoolT;
    private ScrabbleBool sBoolF;
    private ScrabbleFloat sFloat;
    private ScrabbleInt sInt;
    private ScrabbleInt sInt2;
    private ScrabbleBinary sBin;
    private ScrabbleBinary sBin2;
    private ScrabbleBinary sBinNeg;

    private String strVal = "Text";
    private boolean boolVal = true;
    private double floatVal = 10.0;
    private int intVal = 10;
    private int intVal2 = -10;
    private String binVal = "01010";
    private String binVal2 = "0101";
    private String negBinVal = "1010";

    @BeforeEach
    void setUp() {
        sString = new ScrabbleString(strVal);
        sBoolT = new ScrabbleBool(boolVal);
        sBoolF = new ScrabbleBool(!boolVal);
        sFloat = new ScrabbleFloat(floatVal);
        sInt = new ScrabbleInt(intVal);
        sInt2 = new ScrabbleInt(intVal2);
        sBin = new ScrabbleBinary(binVal);
        sBin2 = new ScrabbleBinary(binVal2);
        sBinNeg = new ScrabbleBinary(negBinVal);
    }

    @Test
    void constructorTest() {
        var expectedSString = new ScrabbleString(strVal);
        var expectedSBool = new ScrabbleBool(boolVal);
        var expectedSFloat = new ScrabbleFloat(floatVal);
        var expectedSInt = new ScrabbleInt(intVal);
        var expectedSBin = new ScrabbleBinary(binVal);

        assertEquals(expectedSString, sString);
        assertEquals(expectedSBool, sBoolT);
        assertEquals(expectedSFloat, sFloat);
        assertEquals(expectedSInt, sInt);
        assertEquals(expectedSBin, sBin);

        assertEquals(expectedSString.hashCode(), sString.hashCode());
        assertEquals(expectedSBool.hashCode(), sBoolT.hashCode());
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
        var expectedSBoolT = new ScrabbleBool(boolVal);
        var expectedSBoolF = new ScrabbleBool(!boolVal);
        var expectedSString = new ScrabbleString(String.valueOf(boolVal));

        assertEquals(sBoolT.to_Bool(), expectedSBoolT);
        assertEquals(sBoolF.to_Bool(), expectedSBoolF);
        assertEquals(sBoolT.to_String(), expectedSString);
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
        var expectedNegSBinary = new ScrabbleBinary(sInt.intToBinary(intVal2));

        assertEquals(sInt.to_Int(), expectedSInt);
        assertEquals(sInt.to_String(), expectedSString);
        assertEquals(sInt.to_Float(), expectedSFloat);
        assertEquals(sInt.to_Binary(), expectedSBinary);
        assertEquals(sInt2.to_Binary(), expectedNegSBinary);
    }

    @Test
    void binTrans() {
        var expectedSBin = new ScrabbleBinary(binVal);
        var expectedSString = new ScrabbleString(binVal);
        var expectedSFloat = new ScrabbleFloat(Double.parseDouble(String.valueOf(sBin.binToInt(binVal))));
        var expectedSInt = new ScrabbleInt(sBin.binToInt(binVal));
        var expectedNegSInt = new ScrabbleInt(sBin.binToInt(negBinVal));

        assertEquals(sBin.to_Binary(), expectedSBin);
        assertEquals(sBin.to_String(), expectedSString);
        assertEquals(sBin.to_Float(), expectedSFloat);
        assertEquals(sBin.to_Int(), expectedSInt);
        assertEquals(sBinNeg.to_Int(), expectedNegSInt);
    }

    @Test
    void stringOp() {
        // add only
        var expectedSString = new ScrabbleString(strVal + strVal);
        var expectedSBoolT = new ScrabbleString(strVal + String.valueOf(boolVal));
        var expectedSBoolF = new ScrabbleString(strVal + String.valueOf(!boolVal));
        var expectedSFloat = new ScrabbleString(strVal + String.valueOf(floatVal));
        var expectedSInt = new ScrabbleString(strVal + String.valueOf(intVal));
        var expectedSBin = new ScrabbleString(strVal + binVal);

        // add only
        assertEquals(sString.add(sString), expectedSString);
        assertEquals(sString.add(sBoolT), expectedSBoolT);
        assertEquals(sString.add(sBoolF), expectedSBoolF);
        assertEquals(sString.add(sFloat), expectedSFloat);
        assertEquals(sString.add(sInt), expectedSInt);
        assertEquals(sString.add(sBin), expectedSBin);
    }

    @Test
    void boolOp() {
        // binExample = "01010";
        String binAndF = "00000";
        String binOrT = "11111";

        // and
        var expectedBinAndTrue = new ScrabbleBinary(binVal);
        var expectedBoolTrueAndTrue = new ScrabbleBool(boolVal && boolVal);
        var expectedBoolFalseAndTrue = new ScrabbleBool(!boolVal && boolVal);
        var expectedBinAndFalse = new ScrabbleBinary(binAndF);
        var expectedBoolTrueAndFalse = new ScrabbleBool(boolVal && !boolVal);

        // or
        var expectedBinOrTrue = new ScrabbleBinary(binOrT);
        var expectedBoolTrueOrTrue = new ScrabbleBool(boolVal || boolVal);
        var expectedBoolFalseOrTrue = new ScrabbleBool(!boolVal || boolVal);
        var expectedBinOrFalse = new ScrabbleBinary(binVal);
        var expectedBoolOrFalse = new ScrabbleBool(boolVal || !boolVal);

        // neg
        var expectedSNeg = new ScrabbleBool(!boolVal);

        // and
        assertEquals(sBoolT.and(sBin), expectedBinAndTrue);
        assertEquals(sBoolT.and(sBoolT), expectedBoolTrueAndTrue);
        assertEquals(sBoolF.and(sBoolT), expectedBoolFalseAndTrue);
        assertEquals(sBoolF.and(sBin), expectedBinAndFalse);
        assertEquals(sBoolT.and(sBoolF), expectedBoolTrueAndFalse);

        // or
        assertEquals(sBoolT.or(sBoolT), expectedBoolTrueAndTrue);
        assertEquals(sBoolT.or(sBin), expectedBinOrTrue);
        assertEquals(sBoolT.or(sBoolT), expectedBoolTrueOrTrue);
        assertEquals(sBoolF.or(sBoolT), expectedBoolFalseOrTrue);
        assertEquals(sBoolF.or(sBin), expectedBinOrFalse);
        assertEquals(sBoolT.or(sBoolF), expectedBoolOrFalse);

        // neg
        assertEquals(sBoolT.neg(), expectedSNeg);
    }

    @Test
    void binAux() {
        // neg_bin
        String expectedString = "10101";

        // normalizeBin
        String toNormalize = "010";
        String expectedNormalized = "00010";

        // neg_bin
        assertEquals(sBin.neg_binary(), expectedString);

        // normalizeBin
        assertEquals(sBin.normalizeBin(binVal, toNormalize), expectedNormalized);
    }

    @Test
    void floatOp() {
        // add
        var expectedAddFloat = new ScrabbleFloat(floatVal + floatVal);
        var expectedAddInt = new ScrabbleFloat(floatVal + Double.parseDouble(String.valueOf(intVal)));
        var expectedAddBinary = new ScrabbleFloat(floatVal + Double.parseDouble(String.valueOf(sBin.binToInt(binVal))));

        // subtract
        var expectedSubFloat = new ScrabbleFloat(floatVal - floatVal);
        var expectedSubInt = new ScrabbleFloat(floatVal - Double.parseDouble(String.valueOf(intVal)));
        var expectedSubBinary = new ScrabbleFloat(floatVal - Double.parseDouble(String.valueOf(sBin.binToInt(binVal))));

        // multiply
        var expectedMulFloat = new ScrabbleFloat(floatVal * floatVal);
        var expectedMulInt = new ScrabbleFloat(floatVal * Double.parseDouble(String.valueOf(intVal)));
        var expectedMulBinary = new ScrabbleFloat(floatVal * Double.parseDouble(String.valueOf(sBin.binToInt(binVal))));

        // divide
        var expectedDivFloat = new ScrabbleFloat(floatVal / floatVal);
        var expectedDivInt = new ScrabbleFloat(floatVal / Double.parseDouble(String.valueOf(intVal)));
        var expectedDivBinary = new ScrabbleFloat(floatVal / Double.parseDouble(String.valueOf(sBin.binToInt(binVal))));

        // add
        assertEquals(sFloat.add(sFloat), expectedAddFloat);
        assertEquals(sFloat.add(sInt), expectedAddInt);
        assertEquals(sFloat.add(sBin), expectedAddBinary);

        // subtract
        assertEquals(sFloat.subtract(sFloat), expectedSubFloat);
        assertEquals(sFloat.subtract(sInt), expectedSubInt);
        assertEquals(sFloat.subtract(sBin), expectedSubBinary);

        // multiply
        assertEquals(sFloat.multiply(sFloat), expectedMulFloat);
        assertEquals(sFloat.multiply(sInt), expectedMulInt);
        assertEquals(sFloat.multiply(sBin), expectedMulBinary);

        // divide
        assertEquals(sFloat.divide(sFloat), expectedDivFloat);
        assertEquals(sFloat.divide(sInt), expectedDivInt);
        assertEquals(sFloat.divide(sBin), expectedDivBinary);
    }

    @Test
    void intOp() {
        // add
        var expectedAddFloat = new ScrabbleFloat(Double.parseDouble(String.valueOf(intVal)) + floatVal);
        var expectedAddInt = new ScrabbleInt(intVal + intVal);
        var expectedAddBinary = new ScrabbleInt(intVal + sBin.binToInt(binVal));

        // subtract
        var expectedSubFloat = new ScrabbleFloat(Double.parseDouble(String.valueOf(intVal)) - floatVal);
        var expectedSubInt = new ScrabbleInt(intVal - intVal);
        var expectedSubBinary = new ScrabbleInt(intVal - sBin.binToInt(binVal));

        // multiply
        var expectedMulFloat = new ScrabbleFloat(Double.parseDouble(String.valueOf(intVal)) * floatVal);
        var expectedMulInt = new ScrabbleInt(intVal * intVal);
        var expectedMulBinary = new ScrabbleInt(intVal * sBin.binToInt(binVal));

        // divide
        var expectedDivFloat = new ScrabbleFloat(Double.parseDouble(String.valueOf(intVal)) / floatVal);
        var expectedDivInt = new ScrabbleInt(intVal / intVal);
        var expectedDivBinary = new ScrabbleInt(intVal / sBin.binToInt(binVal));

        // add
        assertEquals(sInt.add(sFloat), expectedAddFloat);
        assertEquals(sInt.add(sInt), expectedAddInt);
        assertEquals(sInt.add(sBin), expectedAddBinary);

        // subtract
        assertEquals(sInt.subtract(sFloat), expectedSubFloat);
        assertEquals(sInt.subtract(sInt), expectedSubInt);
        assertEquals(sInt.subtract(sBin), expectedSubBinary);

        // multiply
        assertEquals(sInt.multiply(sFloat), expectedMulFloat);
        assertEquals(sInt.multiply(sInt), expectedMulInt);
        assertEquals(sInt.multiply(sBin), expectedMulBinary);

        // divide
        assertEquals(sInt.divide(sFloat), expectedDivFloat);
        assertEquals(sInt.divide(sInt), expectedDivInt);
        assertEquals(sInt.divide(sBin), expectedDivBinary);
    }

    @Test
    void binOp() {
        // binExample = "01010" = int 10
        // binExample =  "0101" = int 5
        // intExample = 10
        String binAdd = "010100"; // int 20
        String binSub = "0"; // int 0
        String binMul = "01100100"; // int 100
        String binDiv = "01"; // int 1
        String binAddBin = "01111"; // int 15
        String binSubBin = "0101"; // int 5
        String binMulBin = "0110010"; // int 50
        String binDivBin = "010"; // int 2
        String binNeg = "10101";
        String binAndF = "00000";
        String binOrT = "11111";
        String binAndBin = "00000";
        String binOrBin = "01111";

        // add
        var expectedAddInt = new ScrabbleBinary(binAdd);
        var expectedAddBinary = new ScrabbleBinary(binAddBin);

        // subtract
        var expectedSubInt = new ScrabbleBinary(binSub);
        var expectedSubBinary = new ScrabbleBinary(binSubBin);

        // multiply
        var expectedMulInt = new ScrabbleBinary(binMul);
        var expectedMulBinary = new ScrabbleBinary(binMulBin);

        // divide
        var expectedDivInt = new ScrabbleBinary(binDiv);
        var expectedDivBinary = new ScrabbleBinary(binDivBin);

        // and
        var expectedBinAndTrue = new ScrabbleBinary(binVal);
        var expectedBinAndFalse = new ScrabbleBinary(binAndF);
        var expectedBinAndBin = new ScrabbleBinary(binAndBin);

        // or
        var expectedBinOrTrue = new ScrabbleBinary(binOrT);
        var expectedBinOrFalse = new ScrabbleBinary(binVal);
        var expectedBinOrBin = new ScrabbleBinary(binOrBin);

        // neg
        var expectedSNeg = new ScrabbleBinary(binNeg);

        // add
        assertEquals(sBin.add(sInt), expectedAddInt);
        assertEquals(sBin.add(sBin2), expectedAddBinary);

        // subtract
        assertEquals(sBin.subtract(sInt), expectedSubInt);
        assertEquals(sBin.subtract(sBin2), expectedSubBinary);

        // multiply
        assertEquals(sBin.multiply(sInt), expectedMulInt);
        assertEquals(sBin.multiply(sBin2), expectedMulBinary);

        // divide
        assertEquals(sBin.divide(sInt), expectedDivInt);
        assertEquals(sBin.divide(sBin2), expectedDivBinary);

        // and
        assertEquals(sBoolT.and(sBin), expectedBinAndTrue);
        assertEquals(sBin.and(sBoolT), expectedBinAndTrue);
        assertEquals(sBoolF.and(sBin), expectedBinAndFalse);
        assertEquals(sBin.and(sBoolF), expectedBinAndFalse);
        assertEquals(sBin.and(sBin2), expectedBinAndBin);

        // or
        assertEquals(sBoolT.or(sBin), expectedBinOrTrue);
        assertEquals(sBin.or(sBoolT), expectedBinOrTrue);
        assertEquals(sBoolF.or(sBin), expectedBinOrFalse);
        assertEquals(sBin.or(sBoolF), expectedBinOrFalse);
        assertEquals(sBin.or(sBin2), expectedBinOrBin);

        // neg
        assertEquals(sBin.neg(), expectedSNeg);
    }

    @Test
    void toStringTest() {
        String expectedStrStr = strVal;
        String expectedBoolStr = String.valueOf(boolVal);
        String expectedFloatStr = String.valueOf(floatVal);
        String expectedIntStr = String.valueOf(intVal);
        String expectedBinStr = binVal;

        assertEquals(sString.toString(), expectedStrStr);
        assertEquals(sBoolT.toString(), expectedBoolStr);
        assertEquals(sFloat.toString(), expectedFloatStr);
        assertEquals(sInt.toString(), expectedIntStr);
        assertEquals(sBin.toString(), expectedBinStr);
    }
}
