package AST.operators;

import AST.AbstractNode;
import AST.INode;
import types.IType;
import types.Numbers.INumber;

// CLASS
// mulNode extends AbstractNode abstract class, which means
// this operation can be evaluated the same way any INode does

// stores : (INode left, INode right)
public class mulNode extends AbstractNode {

    // section - INIT

    // mulNode type stores INode classes
    public mulNode(INode izq, INode der) {
        super(izq, der);
    }

    public mulNode() {
        super();
    }

    // section



    // section - EVAL as ITYPE

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
            return valIzq.nMultiply(valDer);
        }
        return null;
    }

    // section
}
