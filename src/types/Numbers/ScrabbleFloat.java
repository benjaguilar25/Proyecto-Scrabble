package types.Numbers;

import types.AbstractType;
import types.IType;
import types.ScrabbleString;

import java.util.Objects;

// CLASS
// ScrabbleFloat type extends the AbstractType abstract class, which means
// this type can be transformed and added the same way as any IType (every type)
// Implements INumber interface, which means this type transform, operates, and
// can be operated as every other INumber types (ScrabbleFloat, ScrabbleInt, ScrabbleBinary)

// stores : double d
public class ScrabbleFloat extends AbstractType implements INumber {

    // section - INIT

    // ScrabbleFloat type stores double java primitive
    private double d;
    public ScrabbleFloat(double d) {
        this.d = d;
    }

    // section



    // section - GETTERS

    // In order to use the Type stored value, a getter will be created
    // returns stored value => double d
    public double getValue() {
        return d;
    }

    // section



    // section - TRANSFORMATIONS

    @Override
    // ScrabbleFloat type can be transformed into a ScrabbleString type
    // returns a new ScrabbleString => ScrabbleString(toStr d)
    public ScrabbleString to_String() {
        return new ScrabbleString(this.toString());
    }

    @Override
    // ScrabbleFloat type can be transformed into itself, if you want of course
    // returns a new ScrabbleFloat => ScrabbleBool(double d)
    public ScrabbleFloat to_Float() {
        return new ScrabbleFloat(d);
    }

    // section



    // section OPERATE

    // ScrabbleFloat type can add/subtract/multiply/divide with any other INumber inherit type
    // returns and calls another method floatAdd implying a Type is being added to this ScrabbleFloat

    // Operating with ScrabbleFloat types leads to ScrabbleFloat types only as double java
    // primitive operated with other numbers can't be expressed as another primitive

    // floatOp methods are called returning a new ScrabbleFloat
    public ScrabbleFloat add(INumber adds) {
        return adds.floatAdd(this);
    }

    public ScrabbleFloat subtract(INumber subtracts) {
        return subtracts.floatSubtract(this);
    }

    public ScrabbleFloat multiply(INumber multiplier) {
        return multiplier.floatMultiply(this);
    }

    public ScrabbleFloat divide(INumber divider) {
        return divider.floatDivide(this);
    }

    // section



    // section - OPERATIONS DD (DOUBLE DISPATCH)

    // ScrabbleFloat type can be added with a ScrabbleString type
    // this will lead to a new ScrabbleString type with both values concatenated as a String primitive
    @Override
    public ScrabbleString stringAdd(ScrabbleString add) {
        return new ScrabbleString(add.getValue() + this.toString());
    }

    // ScrabbleFloat type can be added/subtracted/multiplied/divided with a ScrabbleFloat type
    // this will lead to a new ScrabbleFloat type with the operation interpreted as a double value
    @Override
    public ScrabbleFloat floatAdd(ScrabbleFloat added) {
        return new ScrabbleFloat(added.getValue() + this.getValue());
    }

    @Override
    public ScrabbleFloat floatSubtract(ScrabbleFloat subtracted) {
        return new ScrabbleFloat(subtracted.getValue() - this.getValue());
    }

    @Override
    public ScrabbleFloat floatMultiply(ScrabbleFloat multiplied) {
        return new ScrabbleFloat(multiplied.getValue() * this.getValue());
    }

    @Override
    public ScrabbleFloat floatDivide(ScrabbleFloat divided) {
        return new ScrabbleFloat(divided.getValue() / this.getValue());
    }

    // ScrabbleFloat type can be added/subtracted/multiplied/divided with a ScrabbleInt type
    // this will lead to a new ScrabbleFloat type with the operation interpreted as a double value
    @Override
    public INumber intAdd(ScrabbleInt added) {
        return new ScrabbleFloat(added.to_Float().getValue() + this.getValue());
    }

    @Override
    public INumber intSubtract(ScrabbleInt subtracted) {
        return new ScrabbleFloat(subtracted.to_Float().getValue() - this.getValue());
    }

    @Override
    public INumber intMultiply(ScrabbleInt multiplied) {
        return new ScrabbleFloat(multiplied.to_Float().getValue() * this.getValue());
    }

    @Override
    public INumber intDivide(ScrabbleInt divided) {
        return new ScrabbleFloat(divided.to_Float().getValue() / this.getValue());
    }

    // section



    // section - DD NODE OPERATIONS

    @Override
    public IType nAdd(IType adds) {
        if (!(adds instanceof INumber)) {
            return null;
        }
        return this.add((INumber) adds);
    }

    @Override
    public IType nSubtract(IType subtracts) {
        if (!(subtracts instanceof INumber)) {
            return null;
        }
        return this.subtract((INumber) subtracts);
    }

    @Override
    public IType nMultiply(IType multiplies) {
        if (!(multiplies instanceof INumber)) {
            return null;
        }
        return this.multiply((INumber) multiplies);
    }

    @Override
    public IType nDivide(IType divides) {
        if (!(divides instanceof INumber)) {
            return null;
        }
        return this.divide((INumber) divides);
    }

    @Override
    public ScrabbleFloat eval() {
        return this;
    }

    // section



    // section - COMPARETO

    @Override
    public int compareTo(INumber o) {
        ScrabbleFloat type1 = this;
        ScrabbleFloat type2 = o.to_Float();

        if (type1.getValue() > type2.getValue()) {
            return 1;
        }
        else if (type1.getValue() < type2.getValue()) {
            return -1;
        }

        return 0;
    }

    // section



    // section - TOSTR DD

    // ToString method is overridden by one that returns a String value of the type
    // returns the stored value as a String => toStr d
    @Override
    public String toString() {
        return String.valueOf(d);
    }

    // section



    // section - TESTING

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AbstractType) {
            var o = (ScrabbleFloat) obj;
            return o.d == this.d;
        }
        return obj instanceof AbstractType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ScrabbleFloat.class);
    }

    // section
}
