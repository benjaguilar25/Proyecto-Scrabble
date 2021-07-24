package types;

// ABSTRACT CLASS
// This abstract class allude -as the interface- to the Scrabble Types
// In this case, this will be inherited to the different types
public abstract class AbstractType implements IType {

    // section - ABSTRACT METHODS

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
