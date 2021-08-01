package AST.operators;

import AST.AbstractNode;
import AST.INode;
import types.IType;

public class mulNode extends AbstractNode {

    public mulNode(INode izq, INode der) {
        super(izq, der);
    }

    public mulNode() {
        super();
    }

    @Override
    public IType eval() {
        IType valIzq = getIzq().eval();
        IType valDer = getDer().eval();
        if (valIzq != null && valDer != null) {
            return valIzq.nMultiply(valDer);
        }
        return null;
    }
}
