package Moteur;


public class And extends BinaryFormula {
    public And(Formula leftChild, Formula rightChild) {
        super(leftChild, rightChild);
    }

    @Override
    public Formula toNNF() {
        return new And(leftChild.toNNF(), rightChild.toNNF());
    }

    @Override
    public Formula toSubNNF() {
        return new Or(new Not(leftChild).toNNF(), new Not(rightChild).toNNF());
    }


    @Override
    public String toString() {
        return "(" + leftChild + " ∧ " + rightChild + ")";
    }

    @Override
    public boolean isEt() {
        return true;
    }

    @Override
    public Variables getVariables() {
        Variables variables1 = leftChild.getVariables() ;
        Variables variables2 = rightChild.getVariables() ;
        return variables1.union(variables2);
    }

    @Override
    public Formula toDNF() {
        //a, b, c, d : formula

        //type a and b
        if (leftChild.isConstraint() && rightChild.isConstraint()) {
            return this;
        }

        //type a and (b or c)
        if (leftChild.isConstraint() && rightChild.isOr()) {
            return new Or(new And(leftChild, rightChild.getLeftChild().toDNF()), new And(leftChild, rightChild.getRightChild().toDNF()));
        }

        //type (a or b) and c
        if (rightChild.isConstraint() && leftChild.isOr()) {
            return new Or(new And(leftChild.getLeftChild().toDNF(), rightChild), new And(leftChild.getRightChild().toDNF(), rightChild));
        }

        //type (a or b) and (c or d)
        if(leftChild.isOr() && rightChild.isOr()){
            And and1 = new And(leftChild.getLeftChild(), rightChild.getLeftChild()) ;
            And and2 = new And(leftChild.getLeftChild(), rightChild.getRightChild()) ;
            And and3 = new And(leftChild.getRightChild(), rightChild.getLeftChild()) ;
            And and4 = new And(leftChild.getRightChild(), rightChild.getRightChild()) ;
            return new Or(new Or(and1.toDNF(), and2.toDNF()), new Or(and3.toDNF(), and4.toDNF())) ;
        }

        return new And(leftChild.toDNF(), rightChild.toDNF()) ;
    }

    @Override
    public boolean isSatisfiedBy(Interpretation inter, Variables variables) {
        return (leftChild.isSatisfiedBy(inter, variables) && rightChild.isSatisfiedBy(inter, variables));
    }


}
