package AST.operators;

import AST.AbstractNode;
import AST.INode;
import types.IType;
import types.Numbers.INumber;

public class subNode extends AbstractNode {

    public subNode(INode izq, INode der) {
        super(izq, der);
    }

    public subNode() {
        super();
    }

    @Override
    public IType eval() {
        INumber valIzq = (INumber) getIzq().eval();
        INumber valDer = (INumber) getDer().eval();
        if (valIzq != null && valDer != null) {
            return valIzq.nSubtract(valDer);
        }
        return null;
    }
}
