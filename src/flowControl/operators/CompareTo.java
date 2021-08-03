package flowControl.operators;

import AST.INode;
import types.IType;
import types.Numbers.INumber;
import types.Numbers.ScrabbleInt;

public class CompareTo implements INode {

    private INumber type1;
    private INumber type2;

    public CompareTo(INumber type1, INumber type2) {
        this.type1 = type1;
        this.type2 = type2;
    }

    @Override
    public IType eval() {
        int compare = this.type1.compareTo(this.type2);
        return new ScrabbleInt(compare);
    }

}
