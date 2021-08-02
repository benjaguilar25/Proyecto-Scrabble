package AST.operators;

import AST.AbstractNode;
import AST.INode;
import types.IType;
import types.Numbers.INumber;

// CLASS
// subNode extends AbstractNode abstract class, which means
// this operation can be evaluated the same way any INode does

// stores : (INode left, INode right)
public class subNode extends AbstractNode {

    // section - INIT

    // subNode type stores INode classes
    public subNode(INode izq, INode der) {
        super(izq, der);
    }

    public subNode() {
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
            return valIzq.nSubtract(valDer);
        }
        return null;
    }

    // section
}
