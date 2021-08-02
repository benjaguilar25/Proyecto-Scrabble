package AST.operators;

import AST.AbstractNode;
import AST.INode;
import types.IType;
import types.Numbers.INumber;

public class divNode extends AbstractNode {

    public divNode(INode izq, INode der) {
        super(izq, der);
    }

    public divNode() {
        super();
    }

    @Override
    public IType eval() {
        IType valIzq;
        IType valDer;
        if (getIzq() == null) {
            valIzq = null;
        }
        else {
            valIzq = getIzq().eval();
        }
        if (getDer() == null) {
            valDer = null;
        }
        else {
            valDer = getDer().eval();
        }
        if (valIzq != null && valDer != null) {
            return valIzq.nDivide(valDer);
        }
        return null;
    }
}
