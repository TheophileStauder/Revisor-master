package Moteur;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class VariableValueTable {
    protected HashMap<Variable, RationalNumber> tab ;

    public VariableValueTable() {
        tab = new HashMap<>() ;
    }


    /**
     * add key and value to the hashmap
     * @param key Variable
     * @param value RationalNumber
     */
    public void put(Variable key, RationalNumber value) {
        tab.put(key, value) ;
    }

    public boolean satisfies(Formula formula){
        return false ;
    }

    public RationalNumber get(Variable var){
        return tab.get(var) ;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder() ;

        for (Map.Entry me : tab.entrySet()) {
            res.append(me.getValue()+"*"+me.getKey()+"+") ;
        }

        //remove the last +
        String str = res.toString();
        str = str.substring(0, str.length() - 1);
        return str ;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VariableValueTable that = (VariableValueTable) o;
        return Objects.equals(tab, that.tab);
    }

}
