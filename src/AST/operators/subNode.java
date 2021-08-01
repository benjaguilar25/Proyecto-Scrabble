package AST.operators;

import AST.AbstractNode;
import AST.INode;
import types.IType;

public class subNode extends AbstractNode {

    public subNode(INode izq, INode der) {
        super(izq, der);
    }

    public subNode() {
        super();
    }

    @Override
    public IType eval() {
        IType valIzq = getIzq().eval();
        IType valDer = getDer().eval();
        if (valIzq != null && valDer != null) {
            return valIzq.nSubtract(valDer);
        }
        return null;
    }
}
