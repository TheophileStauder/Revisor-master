package fr.loria.k.revisor.engine.revisorPCSFC.pclc;

import java.util.Objects;

public abstract class FormuleArite0 extends Formula {
    protected Coefficients coefficients ;
    protected double rightMember;
    protected String name;


    public FormuleArite0(Coefficients coefficients, double rightMember) {
        super(coefficients, rightMember);
        this.coefficients = coefficients ;
        this.rightMember = rightMember;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormuleArite0 that = (FormuleArite0) o;
        return Double.compare(that.rightMember, rightMember) == 0 &&
                Objects.equals(coefficients, that.coefficients) &&
                Objects.equals(name, that.name);
    }
}
