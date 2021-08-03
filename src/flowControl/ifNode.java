package flowControl;

import AST.INode;
import flowControl.operators.CompareTo;
import types.IType;
import types.ScrabbleBool;

// CLASS
// ifNode implements INode interface, which means
// this operation can be evaluated the same way any INode does

// stores : (ScrabbleBool cond, INode ifTrue, INode ifFalse)
public class ifNode implements INode {

    // section - INIT

    // ifNode type stores INode classes
    private ScrabbleBool cond;
    private INode ifTrue;
    private INode ifFalse;

    public ifNode(ScrabbleBool cond, INode ifTrue, INode ifFalse) {
        this.cond = cond;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }

    // section



    // section - EVAL as ITYPE

    @Override
    public IType eval() {
        if (cond.getValue() == true) {
            return ifTrue.eval();
        }

        else {
            return ifFalse.eval();
        }
    }

    // section
}
