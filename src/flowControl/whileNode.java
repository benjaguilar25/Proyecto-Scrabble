package flowControl;

import AST.INode;
import types.IType;
import types.ScrabbleBool;

// CLASS
// whileNode implements INode interface, which means
// this operation can be evaluated the same way any INode does

// stores : (ScrabbleBool cond, INode whileTrue)
public class whileNode implements INode {

    // section - INIT

    // whileNode type stores INode classes
    private ScrabbleBool cond;
    private INode whileTrue;

    public whileNode(ScrabbleBool cond, INode whileTrue) {
        this.cond = cond;
        this.whileTrue = whileTrue;
    }

    // section



    // section - EVAL as ITYPE

    @Override
    public IType eval() {
        while (cond.getValue() == true) {
            whileTrue.eval();
        }
        return null;
    }

    // section
}
