package fr.loria.k.revisor.engine.revisorPCSFC.pclc;

import java.util.ArrayList;

public class Entier extends Variable {

    public Entier(String nom) {
        super(nom);
    }


    public Formule toNNF() {
        //return this;
        return null;
    }


    public boolean satisfait(ArrayList<Variable> listX) {
        return true;
    }


    public int toInt(){
        return Integer.valueOf(name) ;
    }
}
