package AST.transformers;

import AST.AbstractTrans;
import AST.INode;
import operators.ILogic;
import types.IType;
import types.Numbers.IBinOperand;
import types.Numbers.ScrabbleBinary;
import types.ScrabbleBool;
import types.ScrabbleString;

public class to_nBinary extends AbstractTrans implements INode {

    private IBinOperand node;

    public to_nBinary(IBinOperand node) {
        this.node = node;
    }

    public to_nBinary() {
        this.node = null;
    }

    @Override
    public IType getNode() {
        return (IType) this.node;
    }

    @Override
    public ScrabbleBinary eval() {
        if (getNode() == null) {
            return null;
        }

        return ((IBinOperand)getNode().eval()).to_Binary();
    }
}