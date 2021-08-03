package AST.transformers;

import AST.AbstractTrans;
import AST.INode;
import operators.ILogic;
import types.Numbers.IBinOperand;
import types.Numbers.INumber;
import types.Numbers.ScrabbleInt;
import types.ScrabbleBool;

// CLASS
// to_nInt extends AbstractTrans abstract class, which means
// this operation can be evaluated the same way any INode does

// stores : INumber node / null
public class to_nInt extends AbstractTrans implements INode {

    // section - INIT

    // to_nInt operation stores INumber classes or nothing
    private INumber node;

    public to_nInt(INumber node) {
        this.node = node;
    }

    public to_nInt() {
        this.node = null;
    }

    // section



    // section - GETTERS

    @Override
    public INumber getNode() {
        return this.node;
    }

    // section



    // section - EVAL as ITYPE

    @Override
    public ScrabbleInt eval() {
        if (getNode() == null) {
            return null;
        }

        return ((IBinOperand)getNode().eval()).to_Int();
    }

    // section
}