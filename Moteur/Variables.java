package Moteur;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Variables implements Iterable {
    protected ArrayList<Variable> variables ;
    public Variables() {
        this.variables = new ArrayList<Variable>() ;
    }
    @Override
    public Iterator iterator() {
        return variables.iterator();
    }

    public void add(Variable variable){
        variables.add(variable) ;
    }

    public Variables union(Variables variables){
        Variables var = this ;

        for(Object o : variables){
            if (!var.contains((Variable)o)) {
                var.add((Variable) o);
            }
        }
        return var ;
    }


    //utiliser equals ?
    public boolean contains(Variable var){
        boolean res = false ;
        for (Variable variable : this.variables){
            if (var.equals(variable)){
                res = true ;
            }
        }

        return res ;
    }

    @Override
    public String toString() {
        return "variables=" + variables ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Variables variables1 = (Variables) o;
        return Objects.equals(variables, variables1.variables);
    }

}
