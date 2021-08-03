package operators;

import types.Numbers.ScrabbleBinary;
import types.ScrabbleBool;

// INTERFACE
// This interface allude to Logic operations accepted types
// used to filter the operating Number types
// implemented to (ScrabbleBool, ScrabbleBinary)
public interface ILogic {

    // section - OPERATE

    // ILogic can operate with ILogic types only
    ILogic and(ILogic operand);
    ILogic or(ILogic operand);
    ILogic neg();

    // section



    // section - OPERATIONS

    // ILogic can be operated with ILogic types only
    ILogic andBool(ScrabbleBool b);
    ILogic andBinary(ScrabbleBinary b);

    ILogic orBool(ScrabbleBool b);
    ILogic orBinary(ScrabbleBinary b);

    // section
}
