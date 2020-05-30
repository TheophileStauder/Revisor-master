package Moteur;

import java.util.Objects;

public abstract class NullArityFormula extends Formula {
    protected Coefficients coefficients ;
    protected RationalNumber rightMember;


    public NullArityFormula(Coefficients coefficients, RationalNumber rightMember) {
        super(coefficients, rightMember);
        this.coefficients = coefficients ;
        this.rightMember = rightMember;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NullArityFormula that = (NullArityFormula) o;
        return Objects.equals(coefficients, that.coefficients) &&
                Objects.equals(rightMember, that.rightMember);
    }

}
