package Moteur;

public class Constraint extends NullArityFormula {
    public Constraint(Coefficients coefficients, RationalNumber rightMember) {
        super(coefficients, rightMember);
    }

    @Override
    public Formula toNNF() {
        return this;
    }

    @Override
    public boolean isSatisfiedBy(Interpretation inter, Variables variables) {
        RationalNumber rationalNumber = new RationalNumber(0.);
        for(Object v : variables){
            Variable var = (Variable)v ;
            rationalNumber = rationalNumber.plus(inter.get(var).mult(coefficients.get(var))) ;

        }
        return (rationalNumber.leq(rightMember)) ;
    }

    @Override
    public boolean isConstraint() {
        return true;
    }

    @Override
    public Variables getVariables() {
        return coefficients.getVariables();
    }

    @Override
    public Formula toDNF() {
        return this ;
    }

    @Override
    public String toString() {
        return  "("+coefficients + " ≤ "+ rightMember +")" ;
    }
}
