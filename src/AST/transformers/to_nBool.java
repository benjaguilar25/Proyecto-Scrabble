package AST.transformers;

import AST.AbstractTrans;
import AST.INode;
import operators.ILogic;
import types.IType;
import types.ScrabbleBool;
import types.ScrabbleString;

public class to_nBool extends AbstractTrans implements INode {

    private ScrabbleBool node;

    public to_nBool(ScrabbleBool node) {
        this.node = node;
    }

    public to_nBool() {
        this.node = null;
    }

    @Override
    public ScrabbleBool getNode() {
        return this.node;
    }

    @Override
    public ScrabbleBool eval() {
        if (getNode() == null) {
            return null;
        }

        return ((ScrabbleBool)getNode().eval()).to_Bool();
    }
}
