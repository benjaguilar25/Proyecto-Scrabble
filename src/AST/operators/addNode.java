package AST.operators;

import AST.AbstractNode;
import AST.INode;
import types.IType;

public class addNode extends AbstractNode {

    public addNode(INode izq, INode der) {
        super(izq, der);
    }

    public addNode() {
        super();
    }

    @Override
    public IType eval() {
        IType valIzq = getIzq().eval();
        IType valDer = getDer().eval();
        if (valIzq != null && valDer != null) {
            return valIzq.nAdd(valDer);
        }
        return null;
    }
}
