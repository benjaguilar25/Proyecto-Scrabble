package AST.operators;

import AST.AbstractNode;
import AST.INode;
import operators.ILogic;
import types.IType;

// CLASS
// andNode extends AbstractNode abstract class, which means
// this operation can be evaluated the same way any INode does

// stores : (INode left, INode right)
public class andNode extends AbstractNode {

    // section - INIT

    // andNode type stores INode classes
    public andNode(INode izq, INode der) {
        super(izq, der);
    }

    public andNode() {
        super();
    }

    // section



    // section - EVAL as ITYPE

    @Override
    public IType eval() {
        ILogic valIzq;
        ILogic valDer;
        if (getIzq() == null) {
            valIzq = null;
        }
        else {
            valIzq = (ILogic) getIzq().eval();
        }
        if (getDer() == null) {
            valDer = null;
        }
        else {
            valDer = (ILogic) getDer().eval();
        }
        if (valIzq != null && valDer != null) {
            return (IType) valIzq.and(valDer);
        }
        return null;
    }

    // section
}
