package fr.loria.k.revisor.engine.revisorPCSFC.pclc;

public class Interpretation extends VariableValueTable {
    public Interpretation() {
    }

    public boolean satisfies(Formula formula){
        return formula.isSatisfiedBy(this, formula.getVariables()) ;
    }
}
