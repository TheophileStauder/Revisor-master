package Moteur;

//real variable
public class RealVariable extends Variable {

    public RealVariable(String name) {
        super(name);
        isReal = true ;
    }


    @Override
    public boolean equals(Object o) {
        Variable variable = (Variable)o ;
        return isReal == variable.isReal() && super.equals(o);
    }

}
