package AST.transformers;

import AST.AbstractTrans;
import AST.INode;
import types.IType;
import types.ScrabbleString;

public class to_nString extends AbstractTrans implements INode {

    private IType node;

    public to_nString(IType node) {
        this.node = node;
    }

    public to_nString() {
        this.node = null;
    }

    @Override
    public INode getNode() {
        return this.node;
    }

    @Override
    public ScrabbleString eval() {
        if (getNode() == null) {
            return null;
        }

        return getNode().eval().to_String();
    }
}
