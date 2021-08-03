package fw;

import types.Numbers.ScrabbleBinary;
import types.Numbers.ScrabbleFloat;
import types.Numbers.ScrabbleInt;
import types.ScrabbleBool;
import types.ScrabbleString;

// CLASS
// FlyClient define the methods in charge of create and
// store the different values methods
// this will optimize the creation of ITypes since
// only one attribute differ type will be created then called
public class FlyClient {

    // section - FACTORY
    // will check if type already stored and call it
    // other way, create it

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

    // section
}
