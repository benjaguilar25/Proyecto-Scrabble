package AST.transformers;

import AST.AbstractTrans;
import AST.INode;
import operators.ILogic;
import types.IType;
import types.ScrabbleBool;
import types.ScrabbleString;

// CLASS
// to_nBool extends AbstractTrans abstract class, which means
// this operation can be evaluated the same way any INode does

// stores : ScrabbleBool node / null
public class to_nBool extends AbstractTrans implements INode {

    // section - INIT

    // to_nBool operation stores ScrabbleBool classes or nothing
    private ScrabbleBool node;

    public to_nBool(ScrabbleBool node) {
        this.node = node;
    }

    public to_nBool() {
        this.node = null;
    }

    // section



    // section - GETTERS

    @Override
    public ScrabbleBool getNode() {
        return this.node;
    }

    // section



    // section - EVAL as ITYPE

    @Override
    public ScrabbleBool eval() {
        if (getNode() == null) {
            return null;
        }

        return ((ScrabbleBool)getNode().eval()).to_Bool();
    }

    // section
}
