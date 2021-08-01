package AST.transformers;

import AST.AbstractTrans;
import AST.INode;
import operators.ILogic;
import types.Numbers.IBinOperand;
import types.Numbers.ScrabbleBinary;
import types.ScrabbleBool;

public class to_nBinary extends AbstractTrans implements INode {

    private IBinOperand node;

    public to_nBinary(IBinOperand node) {
        this.node = node;
    }

    public to_nBinary() {
        this.node = null;
    }

    @Override
    public ScrabbleBinary eval() {
        if (getNode() == null) {
            return null;
        }

        return ((IBinOperand)getNode().eval()).to_Binary();
    }
}