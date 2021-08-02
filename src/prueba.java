import AST.INode;
import AST.operators.addNode;
import types.Numbers.ScrabbleBinary;
import types.Numbers.ScrabbleFloat;

public class prueba {
    public static void main(String[] args) {
        INode peo = new addNode(new ScrabbleFloat(2.5), new ScrabbleBinary("01010"));
        System.out.println(peo.eval());
    }
}
