package fr.loria.k.revisor.engine.revisorPCSFC.pclc;

import java.util.ArrayList;

public class Non extends FormuleUnaire {
    public Non(Formule oper) {
        super(oper);
    }

    @Override
    public Formule toNNF() {
        if (child.isContrainte()) {
            return this;
        } else {
            return child.toSousNNF();
        }
    }

    @Override
    public boolean estContrainteNon() {
        return child.isContrainte();
    }

    @Override
    public Variables getVariables() {
        return null;
    }
  /*  @Override
    public Formule toDNF() {
        return oper.toDNF();
    }*/

    public boolean satisfait(ArrayList<Variable> listX) {
        //return !child.satisfait(listX);
        return false;
    }

    @Override
    public String toString() {
        return "¬" + child;
    }

    @Override
    public boolean isNon() {
        return true;
    }

    public Formule toDNF() {
        return this;
    }

    @Override
    public boolean estSatisfaitePar(Interpretation inter, Variables variables) {
        return false;
    }
}
