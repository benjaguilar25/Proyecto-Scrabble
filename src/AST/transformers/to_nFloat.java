package AST.transformers;

import AST.AbstractTrans;
import AST.INode;
import operators.ILogic;
import types.Numbers.INumber;
import types.Numbers.ScrabbleFloat;
import types.ScrabbleBool;

public class to_nFloat extends AbstractTrans implements INode {

    private INumber node;

    public to_nFloat(INumber node) {
        this.node = node;
    }

    public to_nFloat() {
        this.node = null;
    }

    @Override
    public ScrabbleFloat eval() {
        if (getNode() == null) {
            return null;
        }

        return ((INumber)getNode().eval()).to_Float();
    }
}