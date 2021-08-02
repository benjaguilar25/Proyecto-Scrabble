package AST.transformers;

import AST.AbstractTrans;
import AST.INode;
import types.IType;
import types.ScrabbleString;

// CLASS
// to_nString extends AbstractTrans abstract class, which means
// this operation can be evaluated the same way any INode does

// stores : IType node / null
public class to_nString extends AbstractTrans implements INode {

    // section - INIT

    // to_nString operation stores IType classes or nothing
    private IType node;

    public to_nString(IType node) {
        this.node = node;
    }

    public to_nString() {
        this.node = null;
    }

    // section



    // section - GETTERS

    @Override
    public INode getNode() {
        return this.node;
    }

    // section



    // section - EVAL as ITYPE

    @Override
    public ScrabbleString eval() {
        if (getNode() == null) {
            return null;
        }

        return getNode().eval().to_String();
    }

    // section
}
