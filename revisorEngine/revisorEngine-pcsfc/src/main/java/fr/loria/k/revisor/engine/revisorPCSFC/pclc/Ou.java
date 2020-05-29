package fr.loria.k.revisor.engine.revisorPCSFC.pclc;

import java.util.ArrayList;

public class Ou extends FormuleBinaire {
    public Ou(Formule oper1, Formule oper2) {
        super(oper1, oper2);
    }

    @Override
    public Formule toNNF() {
        return new Ou(leftChild.toNNF(), rightChild.toNNF());
    }

    @Override
    public Formule toSousNNF() {
        return new Et(new Non(leftChild).toNNF(), new Non(rightChild).toNNF());
    }

    @Override
    public boolean isOu(){
        return true ;
    }

    @Override
    public Variables getVariables() {
        return null;
    }
    /*@Override
    public Formule toDNF() {
        return this ;
    }*/

    public boolean satisfait(ArrayList<Variable> listX) {
        //return (leftChild.satisfait(listX) || oper2.satisfait(listX)) ;
        return false;
    }

    @Override
    public String toString() {
        return "("+leftChild+" ∨ "+rightChild+")";
    }

    public Formule toDNF() {
        return new Ou(leftChild.toDNF(), rightChild.toDNF()) ;
    }

    @Override
    public boolean estSatisfaitePar(Interpretation inter, Variables variables) {
        return false;
    }


}
