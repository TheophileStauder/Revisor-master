package fr.loria.k.revisor.engine.revisorPCSFC.pclc;

import java.util.ArrayList;

public class Et extends FormuleBinaire {
    public Et(Formule oper1, Formule oper2) {
        super(oper1, oper2);
    }

    @Override
    public Formule toNNF() {
        return new Et(leftChild.toNNF(), rightChild.toNNF());
    }

    @Override
    public Formule toSousNNF() {
        return new Ou(new Non(leftChild).toNNF(), new Non(rightChild).toNNF());
    }

   /* @Override
    public Formule toDNF() {
        return ;
    }*/

    @Override
    public String toString() {
        return "(" + leftChild + " ∧ " + rightChild + ")";
    }



    public boolean satisfait(ArrayList<Variable> listX) {
        //return (oper1.satisfait(listX) && oper2.satisfait(listX));r
        return false;
    }

    @Override
    public boolean isEt() {
        return true;
    }

    @Override
    public Variables getVariables() {
        return null;
    }

    public Formule toDNF() {
        if (leftChild.isContrainte() && rightChild.isContrainte()) {
            return this;
        }

       /* if (oper1.isEt() && oper2.isEt()){
            return new Et(oper1.toDNF(), oper2.toDNF()).toDNF() ;
        }
        if (oper1.isContrainte() && oper2.isEt()) {
            return new Et(oper1, oper2.toDNF()).toDNF();
        }
        if (oper2.isContrainte() && oper1.isEt()) {
            return new Et(oper1.toDNF(), oper2).toDNF();
        }*/
        if (leftChild.isContrainte() && rightChild.isOu()) {
            return new Ou(new Et(leftChild, rightChild.getLeftChild()), new Et(leftChild, rightChild.getRightChild()));
        }

        if (rightChild.isContrainte() && leftChild.isOu()) {
            return new Ou(new Et(leftChild.getLeftChild(), rightChild), new Et(leftChild.getRightChild(), rightChild));
        }

        if(leftChild.isOu() && rightChild.isOu()){
            Et et1 = new Et(leftChild.getLeftChild(), rightChild.getLeftChild()) ;
            Et et2 = new Et(leftChild.getLeftChild(), rightChild.getRightChild()) ;
            Et et3 = new Et(leftChild.getRightChild(), rightChild.getLeftChild()) ;
            Et et4 = new Et(leftChild.getRightChild(), rightChild.getRightChild()) ;
            return new Ou(new Ou(et1, et2), new Ou(et3, et4)) ;
        }


        return new Et(leftChild.toDNF(), rightChild.toDNF()) ;

    }

    @Override
    public boolean estSatisfaitePar(Interpretation inter, Variables variables) {
        return false;
    }


}
