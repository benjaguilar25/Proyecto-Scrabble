package test;
import AST.INode;
import AST.operators.*;
import AST.transformers.*;
import flowControl.ifNode;
import flowControl.operators.CompareTo;
import flowControl.whileNode;
import fw.FlyClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import types.IType;
import types.Numbers.IBinOperand;
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

    private FlyClient client;

    private CompareTo sCompare;
    private CompareTo sCompare2;
    private CompareTo sCompare3;

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

        client = new FlyClient();

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

    // section - NODE

    @Test
    void stringNodeTrans() {
        var expectedToString = new ScrabbleString(strVal);

        INode transStringNull = new to_nString();
        INode transString = new to_nString(new ScrabbleString(strVal));

        assertEquals(transStringNull.eval(), null);
        assertEquals(transString.eval(), expectedToString);
    }

    @Test
    void boolNodeTrans() {
        var expectedSBool = new ScrabbleBool(boolVal);
        var expectedSString = new ScrabbleString(String.valueOf(boolVal));

        INode transBoolNull = new to_nBool();
        INode transBool = new to_nBool(new ScrabbleBool(boolVal));
        INode transStringNull = new to_nString();
        INode transString = new to_nString(new ScrabbleBool(boolVal));

        assertEquals(transBoolNull.eval(), null);
        assertEquals(transBool.eval(), expectedSBool);
        assertEquals(transStringNull.eval(), null);
        assertEquals(transString.eval(), expectedSString);
    }

    @Test
    void floatNodeTrans() {
        var expectedSFloat = new ScrabbleFloat(floatVal);
        var expectedSString = new ScrabbleString(String.valueOf(floatVal));

        INode transFloatNull = new to_nFloat();
        INode transFloat = new to_nFloat(new ScrabbleFloat(floatVal));
        INode transStringNull = new to_nString();
        INode transString = new to_nString(new ScrabbleFloat(floatVal));

        assertEquals(transFloatNull.eval(), null);
        assertEquals(transFloat.eval(), expectedSFloat);
        assertEquals(transStringNull.eval(), null);
        assertEquals(transString.eval(), expectedSString);
    }

    @Test
    void intNodeTrans() {
        var expectedSInt = new ScrabbleInt(intVal);
        var expectedSString = new ScrabbleString(String.valueOf(intVal));
        var expectedSFloat = new ScrabbleFloat(Double.valueOf(intVal));
        var expectedSBinary = new ScrabbleBinary(sInt.intToBinary(intVal));
        var expectedNegSBinary = new ScrabbleBinary(sInt.intToBinary(intVal2));

        INode transIntNull = new to_nInt();
        INode transInt = new to_nInt(new ScrabbleInt(intVal));
        INode transStringNull = new to_nString();
        INode transString = new to_nString(new ScrabbleInt(intVal));
        INode transFloatNull = new to_nFloat();
        INode transFloat = new to_nFloat(new ScrabbleInt(intVal));
        INode transBinaryNull = new to_nBinary();
        INode transBinary = new to_nBinary(new ScrabbleInt(intVal));
        INode transNegBinary = new to_nBinary(new ScrabbleInt(intVal2));

        assertEquals(transIntNull.eval(), null);
        assertEquals(transInt.eval(), expectedSInt);
        assertEquals(transStringNull.eval(), null);
        assertEquals(transString.eval(), expectedSString);
        assertEquals(transFloatNull.eval(), null);
        assertEquals(transFloat.eval(), expectedSFloat);
        assertEquals(transBinaryNull.eval(), null);
        assertEquals(transBinary.eval(), expectedSBinary);
        assertEquals(transNegBinary.eval(), expectedNegSBinary);
    }

    @Test
    void binNodeTrans() {
        var expectedSBin = new ScrabbleBinary(binVal);
        var expectedSString = new ScrabbleString(binVal);
        var expectedSFloat = new ScrabbleFloat(Double.parseDouble(String.valueOf(sBin.binToInt(binVal))));
        var expectedSInt = new ScrabbleInt(sBin.binToInt(binVal));
        var expectedNegSInt = new ScrabbleInt(sBin.binToInt(negBinVal));

        INode transBinNull = new to_nBinary();
        INode transBin = new to_nBinary(new ScrabbleBinary(binVal));
        INode transStringNull = new to_nString();
        INode transString = new to_nString(new ScrabbleBinary(binVal));
        INode transFloatNull = new to_nFloat();
        INode transFloat = new to_nFloat(new ScrabbleBinary(binVal));
        INode transIntNull = new to_nInt();
        INode transInt = new to_nInt(new ScrabbleBinary(binVal));
        INode transNegInt = new to_nInt(new ScrabbleBinary(negBinVal));

        assertEquals(transBinNull.eval(), null);
        assertEquals(transBin.eval(), expectedSBin);
        assertEquals(transStringNull.eval(), null);
        assertEquals(transString.eval(), expectedSString);
        assertEquals(transFloatNull.eval(), null);
        assertEquals(transFloat.eval(), expectedSFloat);
        assertEquals(transIntNull.eval(), null);
        assertEquals(transInt.eval(), expectedSInt);
        assertEquals(transNegInt.eval(), expectedNegSInt);
    }

    @Test
    void strNodeOp() {
        // add
        var expectedSString = new ScrabbleString(strVal + strVal);
        var expectedSBool = new ScrabbleString(strVal + String.valueOf(boolVal));
        var expectedSFloat = new ScrabbleString(strVal + String.valueOf(floatVal));
        var expectedSInt = new ScrabbleString(strVal + String.valueOf(intVal));
        var expectedSBin = new ScrabbleString(strVal + binVal);

        // add
        INode addNull = new addNode(
                sString,
                new addNode()
        );
        INode addString = new addNode(
                sString,
                sString
        );
        INode addBool = new addNode(
                sString,
                sBoolT
        );
        INode addBinary = new addNode(
                sString,
                sBin
        );
        INode addFloat = new addNode(
                sString,
                sFloat
        );
        INode addInt = new addNode(
                sString,
                sInt
        );

        IType addStringVal = addString.eval();
        IType addBoolVal = addBool.eval();
        IType addBinaryVal = addBinary.eval();
        IType addFloatVal = addFloat.eval();
        IType addIntVal = addInt.eval();

        assertEquals(addNull.eval(), null);
        assertEquals(addStringVal, expectedSString);
        assertEquals(addBoolVal, expectedSBool);
        assertEquals(addBinaryVal, expectedSBin);
        assertEquals(addFloatVal, expectedSFloat);
        assertEquals(addIntVal, expectedSInt);
    }

    @Test
    void boolNodeOp() {
        // binExample = "01010";
        String binAndF = "00000";
        String binOrT = "11111";

        // and
        var expectedBinAndTrue = new ScrabbleBinary(binVal);
        var expectedBoolTrueAndTrue = new ScrabbleBool(boolVal && boolVal);
        var expectedBoolFalseAndTrue = new ScrabbleBool(!boolVal && boolVal);
        var expectedBinAndFalse = new ScrabbleBinary(binAndF);

        // or
        var expectedBinOrTrue = new ScrabbleBinary(binOrT);
        var expectedBoolTrueOrTrue = new ScrabbleBool(boolVal || boolVal);
        var expectedBoolFalseOrTrue = new ScrabbleBool(!boolVal || boolVal);
        var expectedBinOrFalse = new ScrabbleBinary(binVal);

        // neg
        var expectedSNeg = new ScrabbleBool(!boolVal);

        // and
        INode andNull = new andNode(
                sBoolT,
                new andNode()
        );
        INode andTBin = new andNode(
                sBoolT,
                sBin
        );
        INode andTTrue = new andNode(
                sBoolT,
                sBoolT
        );
        INode andTFalse = new andNode(
                sBoolT,
                sBoolF
        );
        INode andFBin = new andNode(
                sBoolF,
                sBin
        );

        // or
        INode orNull = new orNode(
                sBoolT,
                new orNode()
        );
        INode orTBin = new orNode(
                sBoolT,
                sBin
        );
        INode orTTrue = new orNode(
                sBoolT,
                sBoolT
        );
        INode orTFalse = new orNode(
                sBoolT,
                sBoolF
        );
        INode orFBin = new orNode(
                sBoolF,
                sBin
        );

        // neg

        INode negBool = new negNode(new ScrabbleBool(boolVal));

        // and
        assertEquals(andNull.eval(), null);
        assertEquals(andTBin.eval(), expectedBinAndTrue);
        assertEquals(andTTrue.eval(), expectedBoolTrueAndTrue);
        assertEquals(andTFalse.eval(), expectedBoolFalseAndTrue);
        assertEquals(andFBin.eval(), expectedBinAndFalse);

        // or
        assertEquals(orNull.eval(), null);
        assertEquals(orTBin.eval(), expectedBinOrTrue);
        assertEquals(orTTrue.eval(), expectedBoolTrueOrTrue);
        assertEquals(orTFalse.eval(), expectedBoolFalseOrTrue);
        assertEquals(orFBin.eval(), expectedBinOrFalse);

        // neg
        assertEquals(negBool.eval(), expectedSNeg);
    }

    @Test
    void floatNodeOp() {
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
        INode addNull = new addNode(
                sFloat,
                new addNode()
        );
        INode addFloat = new addNode(
                sFloat,
                sFloat
        );
        INode addInt = new addNode(
                sFloat,
                sInt
        );
        INode addBinary = new addNode(
                sFloat,
                sBin
        );

        // subtract
        INode subNull = new subNode(
                sFloat,
                new subNode()
        );
        INode subFloat = new subNode(
                sFloat,
                sFloat
        );
        INode subInt = new subNode(
                sFloat,
                sInt
        );
        INode subBinary = new subNode(
                sFloat,
                sBin
        );

        // multiply
        INode mulNull = new mulNode(
                sFloat,
                new mulNode()
        );
        INode mulFloat = new mulNode(
                sFloat,
                sFloat
        );
        INode mulInt = new mulNode(
                sFloat,
                sInt
        );
        INode mulBinary = new mulNode(
                sFloat,
                sBin
        );

        // divide
        INode divNull = new divNode(
                sFloat,
                new divNode()
        );
        INode divFloat = new divNode(
                sFloat,
                sFloat
        );
        INode divInt = new divNode(
                sFloat,
                sInt
        );
        INode divBinary = new divNode(
                sFloat,
                sBin
        );

        // add
        assertEquals(addNull.eval(), null);
        assertEquals(addFloat.eval(), expectedAddFloat);
        assertEquals(addInt.eval(), expectedAddInt);
        assertEquals(addBinary.eval(), expectedAddBinary);

        // subtract
        assertEquals(subNull.eval(), null);
        assertEquals(subFloat.eval(), expectedSubFloat);
        assertEquals(subInt.eval(), expectedSubInt);
        assertEquals(subBinary.eval(), expectedSubBinary);

        // multiply
        assertEquals(mulNull.eval(), null);
        assertEquals(mulFloat.eval(), expectedMulFloat);
        assertEquals(mulInt.eval(), expectedMulInt);
        assertEquals(mulBinary.eval(), expectedMulBinary);

        // divide
        assertEquals(divNull.eval(), null);
        assertEquals(divFloat.eval(), expectedDivFloat);
        assertEquals(divInt.eval(), expectedDivInt);
        assertEquals(divBinary.eval(), expectedDivBinary);
    }

    @Test
    void intNodeOp() {
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
        INode addNull = new addNode(
                sInt,
                new addNode()
        );
        INode addFloat = new addNode(
                sInt,
                sFloat
        );
        INode addInt = new addNode(
                sInt,
                sInt
        );
        INode addBinary = new addNode(
                sInt,
                sBin
        );

        // subtract
        INode subNull = new subNode(
                sInt,
                new subNode()
        );
        INode subFloat = new subNode(
                sInt,
                sFloat
        );
        INode subInt = new subNode(
                sInt,
                sInt
        );
        INode subBinary = new subNode(
                sInt,
                sBin
        );

        // multiply
        INode mulNull = new mulNode(
                sInt,
                new mulNode()
        );
        INode mulFloat = new mulNode(
                sInt,
                sFloat
        );
        INode mulInt = new mulNode(
                sInt,
                sInt
        );
        INode mulBinary = new mulNode(
                sInt,
                sBin
        );

        // divide
        INode divNull = new divNode(
                sInt,
                new divNode()
        );
        INode divFloat = new divNode(
                sInt,
                sFloat
        );
        INode divInt = new divNode(
                sInt,
                sInt
        );
        INode divBinary = new divNode(
                sInt,
                sBin
        );

        // add
        assertEquals(addNull.eval(), null);
        assertEquals(addFloat.eval(), expectedAddFloat);
        assertEquals(addInt.eval(), expectedAddInt);
        assertEquals(addBinary.eval(), expectedAddBinary);

        // subtract
        assertEquals(subNull.eval(), null);
        assertEquals(subFloat.eval(), expectedSubFloat);
        assertEquals(subInt.eval(), expectedSubInt);
        assertEquals(subBinary.eval(), expectedSubBinary);

        // multiply
        assertEquals(mulNull.eval(), null);
        assertEquals(mulFloat.eval(), expectedMulFloat);
        assertEquals(mulInt.eval(), expectedMulInt);
        assertEquals(mulBinary.eval(), expectedMulBinary);

        // divide
        assertEquals(subNull.eval(), null);
        assertEquals(divFloat.eval(), expectedDivFloat);
        assertEquals(divInt.eval(), expectedDivInt);
        assertEquals(divBinary.eval(), expectedDivBinary);
    }

    @Test
    void binNodeOp() {
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
        INode addNull = new addNode(
                sBin,
                new addNode()
        );
        INode addInt = new addNode(
                sBin,
                sInt
        );
        INode addBinary = new addNode(
                sBin,
                sBin2
        );

        // subtract
        INode subNull = new subNode(
                sBin,
                new subNode()
        );
        INode subInt = new subNode(
                sBin,
                sInt
        );
        INode subBinary = new subNode(
                sBin,
                sBin2
        );

        // multiply
        INode mulNull = new mulNode(
                sBin,
                new mulNode()
        );
        INode mulInt = new mulNode(
                sBin,
                sInt
        );
        INode mulBinary = new mulNode(
                sBin,
                sBin2
        );

        // divide
        INode divNull = new divNode(
                sBin,
                new divNode()
        );
        INode divInt = new divNode(
                sBin,
                sInt
        );
        INode divBinary = new divNode(
                sBin,
                sBin2
        );

        // and
        INode andNull = new andNode(
                sBin,
                new andNode()
        );
        INode andBoolT = new andNode(
                sBin,
                sBoolT
        );
        INode andBoolF = new andNode(
                sBin,
                sBoolF
        );
        INode andBinary = new andNode(
                sBin,
                sBin2
        );

        // or
        INode orNull = new orNode(
                sBin,
                new orNode()
        );
        INode orBoolT = new orNode(
                sBin,
                sBoolT
        );
        INode orBoolF = new orNode(
                sBin,
                sBoolF
        );
        INode orBinary = new orNode(
                sBin,
                sBin2
        );

        // neg
        INode negNull = new negNode();
        INode negBinary = new negNode(
                sBin
        );

        // add
        assertEquals(addNull.eval(), null);
        assertEquals(addInt.eval(), expectedAddInt);
        assertEquals(addBinary.eval(), expectedAddBinary);

        // subtract
        assertEquals(subNull.eval(), null);
        assertEquals(subInt.eval(), expectedSubInt);
        assertEquals(subBinary.eval(), expectedSubBinary);

        // multiply
        assertEquals(mulNull.eval(), null);
        assertEquals(mulInt.eval(), expectedMulInt);
        assertEquals(mulBinary.eval(), expectedMulBinary);

        // divide
        assertEquals(divNull.eval(), null);
        assertEquals(divInt.eval(), expectedDivInt);
        assertEquals(divBinary.eval(), expectedDivBinary);

        // and
        assertEquals(andNull.eval(), null);
        assertEquals(andBoolT.eval(), expectedBinAndTrue);
        assertEquals(andBoolF.eval(), expectedBinAndFalse);
        assertEquals(andBinary.eval(), expectedBinAndBin);

        // or
        assertEquals(orNull.eval(), null);
        assertEquals(orBoolT.eval(), expectedBinOrTrue);
        assertEquals(orBoolF.eval(), expectedBinOrFalse);
        assertEquals(orBinary.eval(), expectedBinOrBin);

        // neg
        assertEquals(negNull.eval(), null);
        assertEquals(negBinary.eval(), expectedSNeg);
    }

    @Test
    void wrongOpTest() {
        // if we try to operate in a different way our construction
        // of scrabble was made, the result for this
        // and all cases will be null


        // float wrong op example
        INode floatBoolAdd = new addNode(
                sFloat,
                sBoolT
        );
        INode floatBoolSubtract = new subNode(
                sFloat,
                sBoolT
        );
        INode floatBoolMultiply = new mulNode(
                sFloat,
                sBoolT
        );
        INode floatBoolDivide = new divNode(
                sFloat,
                sBoolT
        );

        // int wrong op example
        INode intStringAdd = new addNode(
                sInt,
                sString
        );
        INode intStringSubtract = new subNode(
                sInt,
                sString
        );
        INode intStringMultiply = new mulNode(
                sInt,
                sString
        );
        INode intStringDivide = new divNode(
                sInt,
                sString
        );

        // bin wrong op example
        INode binFloatAdd = new addNode(
                sBin,
                sFloat
        );
        INode binFloatSubtract = new subNode(
                sBin,
                sFloat
        );
        INode binFloatMultiply = new mulNode(
                sBin,
                sFloat
        );
        INode binFloatDivide = new divNode(
                sBin,
                sFloat
        );

        // asserts
        assertEquals(floatBoolAdd.eval(), null);
        assertEquals(floatBoolSubtract.eval(), null);
        assertEquals(floatBoolMultiply.eval(), null);
        assertEquals(floatBoolDivide.eval(), null);

        assertEquals(intStringAdd.eval(), null);
        assertEquals(intStringSubtract.eval(), null);
        assertEquals(intStringMultiply.eval(), null);
        assertEquals(intStringDivide.eval(), null);

        assertEquals(binFloatAdd.eval(), null);
        assertEquals(binFloatSubtract.eval(), null);
        assertEquals(binFloatMultiply.eval(), null);
        assertEquals(binFloatDivide.eval(), null);

    }

    @Test
    void pdfProblemTest() {
        var expectedResult = new ScrabbleFloat(34.9);

        // In this case, as operations in the form of 'Binary + Float'
        // are not allowed, we return null for the whole operation
        INode problemNull = new addNode(
                new orNode(
                        new ScrabbleBinary("1000"),
                        new to_nBinary((IBinOperand) new subNode(
                                new ScrabbleInt(25),
                                new ScrabbleBinary("0101")
                        ).eval())
                ),
                new ScrabbleFloat(6.9)
        );

        // but if we make a slight change in the way the operation is written
        // as 'Float + Binary', it will return the value we were expecting
        // just as the PDF result : 34.9
        INode problem = new addNode(
                new ScrabbleFloat(6.9),
                new orNode(
                        new ScrabbleBinary("1000"),
                        new to_nBinary((IBinOperand) new subNode(
                                new ScrabbleInt(25),
                                new ScrabbleBinary("0101")
                        ).eval())
                )
        );

        assertEquals(problemNull.eval(), null);
        assertEquals(problem.eval(), expectedResult);
    }

    // flyweight factory test
    // we check that types can store and iterate instead of
    // creating a new one every time we need a new ScrabbleType
    @Test
    void flyweightTest() {
        var sStr_1 = client.sStringFactory(strVal);
        var sStr_2 = client.sStringFactory(strVal);

        var sBool_1 = client.sBoolFactory(boolVal);
        var sBool_2 = client.sBoolFactory(boolVal);

        var sFloat_1 = client.sFloatFactory(floatVal);
        var sFloat_2 = client.sFloatFactory(floatVal);

        var sInt_1 = client.sIntFactory(intVal);
        var sInt_2 = client.sIntFactory(intVal);

        var sBin_1 = client.sBinaryFactory(binVal);
        var sBin_2 = client.sBinaryFactory(binVal);

        assertEquals(sStr_1, sStr_2);
        assertEquals(sStr_1.getValue(), sStr_2.getValue());

        assertEquals(sBool_1, sBool_2);
        assertEquals(sBool_1.getValue(), sBool_2.getValue());

        assertEquals(sFloat_1, sFloat_2);
        assertEquals(sFloat_1.getValue(), sFloat_2.getValue());

        assertEquals(sInt_1, sInt_2);
        assertEquals(sInt_1.getValue(), sInt_2.getValue());

        assertEquals(sBin_1, sBin_2);
        assertEquals(sBin_1.getValue(), sBin_2.getValue());
    }

    @Test
    void compareToOp() {
        var expectedCompare_1 = new ScrabbleInt(1);
        var expectedCompare_2 = new ScrabbleInt(0);
        var expectedCompare_3 = new ScrabbleInt(-1);

        sCompare = new CompareTo(sBin, sInt2);
        sCompare2 = new CompareTo(sFloat, sFloat);
        sCompare3 = new CompareTo(sBin2, sFloat);

        assertEquals(sCompare.eval(), expectedCompare_1);
        assertEquals(sCompare2.eval(), expectedCompare_2);
        assertEquals(sCompare3.eval(), expectedCompare_3);
    }

    @Test
    void ifNodeTest() {
        var expectedResult1 = new ScrabbleInt(intVal - 1);
        var expectedResult2 = new ScrabbleInt(intVal2 + 1);
        var correctIf = new ScrabbleInt(1);
        ScrabbleInt comparison1 = (ScrabbleInt) new CompareTo(sInt, sInt2).eval();
        ScrabbleInt comparison2 = (ScrabbleInt) new CompareTo(sInt2, sInt).eval();

        INode ifTrueAST = new ifNode(
                new ScrabbleBool(comparison1.getValue() == correctIf.getValue()),
                new subNode(
                        sInt,
                        correctIf
                ),
                new addNode(
                        sInt2,
                        correctIf
                )
        );

        INode ifFalseAST = new ifNode(
                new ScrabbleBool(comparison2.getValue() == correctIf.getValue()),
                new subNode(
                        sInt,
                        correctIf
                ),
                new addNode(
                        sInt2,
                        correctIf
                )
        );

        assertEquals(ifTrueAST.eval(), expectedResult1);
        assertEquals(ifFalseAST.eval(), expectedResult2);
    }


    /**
     * se quiso testear pero dentro de la clase whileNode
     * no se pudo descubrir como actualizar la condición
     * ya que esta se almacena en ScrabbleBool y no se
     * puede acceder a los parámetros de forma independiente
     *
     * si se hubiese podido, lo ideal hubiera sido
     * actualizar una de las variables hasta que la cond
     * no se cumpla y terminar el ciclo
    @Test
    void whileNodeTest() {
        var expectedResult1 = new ScrabbleInt(intVal2);
        var expectedResult2 = new ScrabbleInt(intVal2 + 1);
        var correctIf = new ScrabbleInt(1);
        ScrabbleInt comparison1 = (ScrabbleInt) new CompareTo(sInt, sInt2).eval();
        ScrabbleInt comparison2 = (ScrabbleInt) new CompareTo(sInt2, sInt).eval();

        INode whileAST = new whileNode(
                new ScrabbleBool(comparison1.getValue() == correctIf.getValue()),
                new subNode(
                        sInt,
                        correctIf
                )
        );

        assertEquals(whileAST.eval(), expectedResult1);
    }
    */
}
