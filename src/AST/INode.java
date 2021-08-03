package AST;

// INTERFACE

import types.IType;
import types.Numbers.INumber;
import types.Numbers.ScrabbleInt;

// This interface alludes to Nodes in ABS
// every node has two values attached to it as (INode left, INode right)
// and can be evaluated in a IType from Scrabble
// inherited (not implemented explicitly) to
// AbstractNode, AbstractTrans, to_nType methods, and opNode methods
public interface INode {

    // section - EVAL

    // Any INode can transform to a ScrabbleType
    // INode -> eval() -> ScrabbleType("value")
    IType eval();

    // section

}
