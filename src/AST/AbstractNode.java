package AST;

import types.IType;

public class AbstractNode implements INode {
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

    @Override
    public IType eval() {
        return null;
    }

    public INode getIzq() {
        return this.izq;
    }

    public INode getDer() {
        return this.der;
    }
}
