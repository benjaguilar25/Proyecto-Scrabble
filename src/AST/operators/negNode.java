package AST.operators;

import AST.AbstractTrans;
import AST.INode;
import operators.ILogic;
import types.IType;
import types.Numbers.IBinOperand;

// CLASS
// negNode extends AbstractTrans abstract class, which means
// this operation can be evaluated the same way any INode does

// stores : INode node
public class negNode extends AbstractTrans implements INode {

    // section - INIT

    // negNode type stores ILogic class
    // since neg op only works with inherited classes
    private ILogic node;

    public negNode(ILogic node) {
        this.node = node;
    }

    public negNode() {
        this.node = null;
    }

    // section



    // section - GETTERS

    @Override
    public IType getNode() {
        return (IType) this.node;
    }

    // section



    // section - EVAL as ITYPE

    @Override
    public IType eval() {
        if (getNode() == null) {
            return null;
        }

        return (IType) ((ILogic) getNode().eval()).neg();
    }

    // section
}
