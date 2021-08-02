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
            return valIzq.nAdd(valDer);
        }
        else {
            return null;
        }
    }
}
