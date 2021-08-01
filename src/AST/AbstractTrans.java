package AST;

import types.IType;

public abstract class AbstractTrans implements INode {

    private INode node;

    protected AbstractTrans(INode node) {
        this.node = node;
    }

    protected AbstractTrans() {
        this.node = null;
    }

    public INode getNode() {
        return this.node;
    }

}
