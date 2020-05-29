package fr.loria.k.revisor.engine.revisorPCSFC.pclc;

import java.util.ArrayList;

public class Reel extends Variable {

    public Reel(String nom) {
        super(nom);
    }


    public Formule toNNF() {
        //return this;
        return null;
    }


    public boolean satisfait(ArrayList<Variable> listX) {
        return true ;
    }


    public double toDouble(){
        return Double.valueOf(name) ;
    }
}
