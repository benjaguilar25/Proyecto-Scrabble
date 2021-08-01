package AST.operators;

import AST.AbstractNode;
import AST.INode;
import operators.ILogic;
import types.IType;

public class andNode extends AbstractNode {

    public andNode(INode izq, INode der) {
        super(izq, der);
    }

    public andNode() {
        super();
    }

    @Override
    public IType eval() {
        ILogic valIzq = (ILogic) getIzq().eval();
        ILogic valDer = (ILogic) getDer().eval();
        if (valIzq != null && valDer != null) {
            return (IType) valIzq.and(valDer);
        }
        return null;
    }
}