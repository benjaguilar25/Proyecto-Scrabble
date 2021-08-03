import AST.INode;
import AST.operators.addNode;
import AST.operators.subNode;
import flowControl.ifNode;
import flowControl.operators.CompareTo;
import types.Numbers.ScrabbleBinary;
import types.Numbers.ScrabbleFloat;
import types.Numbers.ScrabbleInt;
import types.ScrabbleBool;

public class prueba {
    public static void main(String[] args) {
        var expectedResult1 = new ScrabbleInt(10 - 1);
        var expectedResult2 = new ScrabbleInt(-10 + 1);
        var correctIf = new ScrabbleInt(1);
        var sInt = new ScrabbleInt(10);
        var sInt2 = new ScrabbleInt(-10);
        ScrabbleInt comparison1 = (ScrabbleInt) new CompareTo(sInt, sInt2).eval();
        ScrabbleInt comparison2 = (ScrabbleInt) new CompareTo(sInt2, sInt).eval();
        ScrabbleBool cond = new ScrabbleBool(comparison1.getValue() == correctIf.getValue());

        INode ifTrueAST = new ifNode(
                cond,
                new subNode(
                        sInt,
                        correctIf
                ),
                new addNode(
                        sInt2,
                        correctIf
                )
        );

        int inicial = 10;
        int limite = -10;
        while (inicial > limite) {
            inicial--;
        }
        System.out.println(inicial);
    }
}
