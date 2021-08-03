package AST.operators;

import AST.AbstractNode;
import AST.INode;
import types.IType;

// CLASS
// addNode extends AbstractNode abstract class, which means
// this operation can be evaluated the same way any INode does

// stores : (INode left, INode right)
public class addNode extends AbstractNode {

    // section - INIT

    // addNode type stores INode classes
    public addNode(INode izq, INode der) {
        super(izq, der);
    }

    public addNode() {
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
            return valIzq.nAdd(valDer);
        }
        else {
            return null;
        }
    }

    // section
}
