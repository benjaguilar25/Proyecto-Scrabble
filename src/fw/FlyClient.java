package fw;

import types.Numbers.ScrabbleBinary;
import types.Numbers.ScrabbleFloat;
import types.Numbers.ScrabbleInt;
import types.ScrabbleBool;
import types.ScrabbleString;

public class FlyClient {

    public ScrabbleString sStringFactory(String s) {
        return ITypeFlyweightFact.getSString(s);
    }

    public ScrabbleBool sBoolFactory(boolean b) {
        return ITypeFlyweightFact.getSBool(b);
    }

    public ScrabbleFloat sFloatFactory(double d) {
        return ITypeFlyweightFact.getSFloat(d);
    }

    public ScrabbleInt sIntFactory(int i) {
        return ITypeFlyweightFact.getSInt(i);
    }

    public ScrabbleBinary sBinaryFactory(String b) {
        return ITypeFlyweightFact.getSBin(b);
    }
}
