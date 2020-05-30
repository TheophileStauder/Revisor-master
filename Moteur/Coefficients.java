package Moteur;

import java.util.Map;

public class Coefficients extends VariableValueTable {

    /**
     *
     * @return Variables that contains all the variables in the hashmap
     */
    public Variables getVariables(){
        Variables variables = new Variables() ;
        for (Map.Entry me : tab.entrySet()) {
            variables.add((Variable)me.getKey());
        }
        return variables ;
    }
}
