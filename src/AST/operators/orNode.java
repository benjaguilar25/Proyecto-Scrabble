package AST.operators;

import AST.AbstractNode;
import AST.INode;
import operators.ILogic;
import types.IType;

public class orNode extends AbstractNode {

    public orNode(INode izq, INode der) {
        super(izq, der);
    }

    public orNode() {
        super();
    }

    @Override
    public IType eval() {
        ILogic valIzq;
        ILogic valDer;
        if (getIzq() == null) {
            valIzq = null;
        }
        else {
            valIzq = (ILogic) getIzq().eval();
        }
        if (getDer() == null) {
            valDer = null;
        }
        else {
            valDer = (ILogic) getDer().eval();
        }
        if (valIzq != null && valDer != null) {
            return (IType) valIzq.or(valDer);
        }
        return null;
    }
}
