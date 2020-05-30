package Moteur;

public class IntegerVariable extends Variable {

    public IntegerVariable(String name) {
        super(name);
    }

    @Override
    public boolean equals(Object o) {
        Variable variable = (Variable)o ;

        return isReal == variable.isReal() && super.equals(o) ;
    }
}
