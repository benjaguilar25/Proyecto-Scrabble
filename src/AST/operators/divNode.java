package AST.operators;

import AST.AbstractNode;
import AST.INode;
import types.IType;

public class divNode extends AbstractNode {

    public divNode(INode izq, INode der) {
        super(izq, der);
    }

    public divNode() {
        super();
    }

    @Override
    public IType eval() {
        IType valIzq = getIzq().eval();
        IType valDer = getDer().eval();
        if (valIzq != null && valDer != null) {
            return valIzq.nDivide(valDer);
        }
        return null;
    }
}
