package Moteur;

import java.util.Objects;

public abstract class UnaryFormula extends Formula {
    protected Formula child ;

    public UnaryFormula(Formula child) {
        super(child);
        this.child = child;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnaryFormula that = (UnaryFormula) o;
        return Objects.equals(child, that.child);
    }
}
