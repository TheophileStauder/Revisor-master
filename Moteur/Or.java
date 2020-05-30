package Moteur;

public class Or extends BinaryFormula {
    public Or(Formula oper1, Formula oper2) {
        super(oper1, oper2);
    }

    @Override
    public Formula toNNF() {
        return new Or(leftChild.toNNF(), rightChild.toNNF());
    }

    @Override
    public Formula toSubNNF() {
        return new And(new Not(leftChild).toNNF(), new Not(rightChild).toNNF());
    }

    @Override
    public boolean isOr(){
        return true ;
    }

    @Override
    public String toString() {
        return "("+ leftChild +" ∨ "+ rightChild +")";
    }

    public Formula toDNF() {
        return new Or(leftChild.toDNF(), rightChild.toDNF()) ;
    }

    @Override
    public boolean isSatisfiedBy(Interpretation inter, Variables variables) {
        return (leftChild.isSatisfiedBy(inter, variables) || rightChild.isSatisfiedBy(inter, variables)) ;
    }

    @Override
    public Variables getVariables() {
        Variables variables1 = leftChild.getVariables() ;
        Variables variables2 = rightChild.getVariables() ;
        return variables1.union(variables2);
    }

}
