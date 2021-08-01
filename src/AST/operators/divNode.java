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
        INumber valIzq = (INumber) getIzq().eval();
        INumber valDer = (INumber) getDer().eval();
        if (valIzq != null && valDer != null) {
            return valIzq.nDivide(valDer);
        }
        return null;
    }
}
