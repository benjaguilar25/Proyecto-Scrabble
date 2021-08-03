package AST.transformers;

import AST.AbstractTrans;
import AST.INode;
import operators.ILogic;
import types.IType;
import types.Numbers.IBinOperand;
import types.Numbers.ScrabbleBinary;
import types.ScrabbleBool;
import types.ScrabbleString;

// CLASS
// to_nBinary extends AbstractTrans abstract class, which means
// this operation can be evaluated the same way any INode does

// stores : IBinOperand node / null
public class to_nBinary extends AbstractTrans implements INode {

    // section - INIT

    // to_nBinary operation stores IBinOperand classes or nothing
    private IBinOperand node;

    public to_nBinary(IBinOperand node) {
        this.node = node;
    }

    public to_nBinary() {
        this.node = null;
    }

    // section



    // section - GETTERS

    @Override
    public IType getNode() {
        return (IType) this.node;
    }

    // section



    // section - EVAL as ITYPE

    @Override
    public ScrabbleBinary eval() {
        if (getNode() == null) {
            return null;
        }

        return ((IBinOperand)getNode().eval()).to_Binary();
    }

    // section
}