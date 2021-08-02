package AST;

import types.IType;

// ABSTRACT CLASS
// This abstract class allude -as the interface- to ABS Nodes
// In this case, this will be inherited to all different node transformations
public abstract class AbstractTrans implements INode {

    // section - CONSTRUCTOR

    private INode node;

    protected AbstractTrans(INode node) {
        this.node = node;
    }

    protected AbstractTrans() {
        this.node = null;
    }

    // section



    // section - GETTERS

    // you can access the node through getters

    public INode getNode() {
        return this.node;
    }

    // section

}
