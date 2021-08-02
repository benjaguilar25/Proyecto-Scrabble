package AST.operators;

import AST.AbstractTrans;
import AST.INode;
import operators.ILogic;
import types.IType;
import types.Numbers.IBinOperand;

public class negNode extends AbstractTrans implements INode {

    private ILogic node;

    public negNode(ILogic node) {
        this.node = node;
    }

    public negNode() {
        this.node = null;
    }

    @Override
    public IType getNode() {
        return (IType) this.node;
    }

    @Override
    public IType eval() {
        if (getNode() == null) {
            return null;
        }

        return (IType) ((ILogic) getNode().eval()).neg();
    }
}
