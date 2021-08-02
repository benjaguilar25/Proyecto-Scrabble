package AST.transformers;

import AST.AbstractTrans;
import AST.INode;
import operators.ILogic;
import types.Numbers.INumber;
import types.Numbers.ScrabbleFloat;
import types.ScrabbleBool;

// CLASS
// to_nFloat extends AbstractTrans abstract class, which means
// this operation can be evaluated the same way any INode does

// stores : INumber node / null
public class to_nFloat extends AbstractTrans implements INode {

    // section - INIT

    // to_nFloat operation stores INumber classes or nothing
    private INumber node;

    public to_nFloat(INumber node) {
        this.node = node;
    }

    public to_nFloat() {
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
    public ScrabbleFloat eval() {
        if (getNode() == null) {
            return null;
        }

        return ((INumber)getNode().eval()).to_Float();
    }

    // section
}