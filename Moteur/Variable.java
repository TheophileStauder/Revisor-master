package Moteur;

public abstract class Variable{
    protected String name ;
    protected boolean isReal ;

    public Variable(String name) {
        this.name = name;
        this.isReal = false ;
    }



    public String getName() {
        return name;
    }



    /**
     *
     * @return true if type RealVariable, false if type IntegerVariable
     */
    public boolean isReal() {
        return isReal;
    }

    /**
     *
     * @param o Variable
     * @return true if both names are equals
     */
    @Override
    public boolean equals(Object o) {

        Variable variable = (Variable) o;
        return name.equals(variable.getName()) ;
    }

    @Override
    public String toString() {
        return name;
    }
}
