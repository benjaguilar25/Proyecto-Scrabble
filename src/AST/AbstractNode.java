package AST;

import types.IType;

// ABSTRACT CLASS
// This abstract class allude -as the interface- to ABS Nodes
// In this case, this will be inherited to all different node castings
public abstract class AbstractNode extends AbstractTrans implements INode {

    // section - CONSTRUCTOR

    private INode izq;
    private INode der;

    protected AbstractNode(INode izq, INode der) {
        this.izq = izq;
        this.der = der;
    }

    protected AbstractNode() {
        this.izq = null;
        this.der = null;
    }

    // section



    // section - eval() from INode

    @Override
    public IType eval() {
        return null;
    }

    // section



    // section - GETTERS

    // you can access left and right nodes through getters

    public INode getIzq() {
        return this.izq;
    }

    public INode getDer() {
        return this.der;
    }

    // section
}
