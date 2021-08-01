package AST.transformers;

import AST.AbstractTrans;
import AST.INode;
import operators.ILogic;
import types.Numbers.IBinOperand;
import types.Numbers.INumber;
import types.Numbers.ScrabbleInt;
import types.ScrabbleBool;

public class to_nInt extends AbstractTrans implements INode {

    private INumber node;

    public to_nInt(INumber node) {
        this.node = node;
    }

    public to_nInt() {
        this.node = null;
    }

    @Override
    public INumber getNode() {
        return this.node;
    }

    @Override
    public ScrabbleInt eval() {
        if (getNode() == null) {
            return null;
        }

        return ((IBinOperand)getNode().eval()).to_Int();
    }
}