package operators;

import types.Numbers.ScrabbleBinary;
import types.ScrabbleBool;

public interface ILogic {

    // section - OPERATE

    ILogic and(ILogic operand);

    // secion



    // section - OPERATIONS

    ILogic andBool(ScrabbleBool b);
    ILogic andBinary(ScrabbleBinary b);

    ILogic or(ILogic operand);
    ILogic orBool(ScrabbleBool b);
    ILogic orBinary(ScrabbleBinary b);

    // section
}
