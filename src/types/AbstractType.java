package types;

// ABSTRACT CLASS
// This abstract class allude -as the interface- to Scrabble Types
// In this case, this will be inherited to all different types
public abstract class AbstractType implements IType {

    // section - ABSTRACT METHODS

    // Same methods included in IType interface

    @Override
    public ScrabbleString to_String() {
        return null;
    }

    @Override
    public ScrabbleString stringAdd(ScrabbleString add) {
        return null;
    }

    // section
}
