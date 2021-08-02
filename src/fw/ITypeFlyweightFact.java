package fw;

import types.Numbers.ScrabbleBinary;
import types.Numbers.ScrabbleFloat;
import types.Numbers.ScrabbleInt;
import types.ScrabbleBool;
import types.ScrabbleString;

import java.util.HashMap;

public class ITypeFlyweightFact {
    private static final HashMap<String, ScrabbleString> sString = new HashMap<>();
    private static final HashMap<Boolean, ScrabbleBool> sBool = new HashMap<>();
    private static final HashMap<Double, ScrabbleFloat> sFloat = new HashMap<>();
    private static final HashMap<Integer, ScrabbleInt> sInt = new HashMap<>();
    private static final HashMap<String, ScrabbleBinary> sBin = new HashMap<>();

    public static ScrabbleString getSString(String s) {
        if (sString.containsKey(s)) {
            return sString.get(s);
        }
        else {
            ScrabbleString SStr = new ScrabbleString(s);
            sString.put(s, SStr);
            return SStr;
        }
    }

    public static ScrabbleBool getSBool(boolean b) {
        if (sBool.containsKey(b)) {
            return sBool.get(b);
        }
        else {
            ScrabbleBool SBool = new ScrabbleBool(b);
            sBool.put(b, SBool);
            return SBool;
        }
    }

    public static ScrabbleFloat getSFloat(double d) {
        if (sFloat.containsKey(d)) {
            return sFloat.get(d);
        }
        else {
            ScrabbleFloat SFloat = new ScrabbleFloat(d);
            sFloat.put(d, SFloat);
            return SFloat;
        }
    }

    public static ScrabbleInt getSInt(int i) {
        if (sInt.containsKey(i)) {
            return sInt.get(i);
        }
        else {
            ScrabbleInt SInt = new ScrabbleInt(i);
            sInt.put(i, SInt);
            return SInt;
        }
    }

    public static ScrabbleBinary getSBin(String b) {
        if (sBin.containsKey(b)) {
            return sBin.get(b);
        }
        else {
            ScrabbleBinary SBin = new ScrabbleBinary(b);
            sBin.put(b, SBin);
            return SBin;
        }
    }
}
