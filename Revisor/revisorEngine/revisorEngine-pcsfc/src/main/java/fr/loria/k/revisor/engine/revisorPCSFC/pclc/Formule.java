package fr.loria.k.revisor.engine.revisorPCSFC.pclc;

public abstract class Formule {
    protected Formule child;
    protected Coefficients coefficients ;
    protected double rightMember;
    protected Formule child2;
    protected String name;

    public Formule(Formule child) {
        this.child = child;
    }

    public Formule(Formule child, Formule child2) {
        this.child = child;
        this.child2 = child2;
    }

    public Formule(Coefficients coefficients, double rightMember) {
        this.coefficients = coefficients;
        this.rightMember = rightMember;
    }

    public Formule(String name) {
        this.name = name;
    }


    /**
     * NegativeNormalForm
     * @return
     */
    public abstract Formule toNNF() ;

    public  Formule toSousNNF(){
        return this ;
    }

    public abstract Formule toDNF() ;
    public abstract boolean estSatisfaitePar(Interpretation inter, Variables variables) ;
    public boolean isContrainte(){return false;}
    public boolean isOu(){return false;}
    public boolean isEt(){return false;}

    public boolean isNon(){return false;}
    public boolean estContrainteNon(){
        return false ;
    }

    public Formule getLeftChild() {
        return child;
    }
    public Formule getRightChild() {
        return child2;
    }


    public abstract Variables getVariables() ;
}
