package fr.loria.k.revisor.engine.revisorPCSFC.pclc;

import java.util.Objects;

public abstract class FormuleUnaire extends Formule {
    protected Formule child ;

    public FormuleUnaire(Formule child) {
        super(child);
        this.child = child;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormuleUnaire that = (FormuleUnaire) o;
        return Objects.equals(child, that.child);
    }
}
