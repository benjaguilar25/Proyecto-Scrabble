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
        INumber valIzq = (INumber) getIzq().eval();
        INumber valDer = (INumber) getDer().eval();
        if (valIzq != null && valDer != null) {
            return valIzq.nMultiply(valDer);
        }
        return null;
    }
}
