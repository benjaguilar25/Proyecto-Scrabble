package AST.operators;

import AST.AbstractNode;
import AST.INode;
import operators.ILogic;
import types.IType;

// CLASS
// orNode extends AbstractNode abstract class, which means
// this operation can be evaluated the same way any INode does

// stores : (INode left, INode right)
public class orNode extends AbstractNode {

    // section - INIT

    // orNode type stores INode classes
    public orNode(INode izq, INode der) {
        super(izq, der);
    }

    public orNode() {
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
            return (IType) valIzq.or(valDer);
        }
        return null;
    }

    // section
}
