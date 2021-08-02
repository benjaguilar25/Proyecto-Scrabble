package AST.operators;

import AST.AbstractNode;
import AST.INode;
import types.IType;
import types.Numbers.INumber;

public class mulNode extends AbstractNode {

    public mulNode(INode izq, INode der) {
        super(izq, der);
    }

    public mulNode() {
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
            return valIzq.nMultiply(valDer);
        }
        return null;
    }
}
