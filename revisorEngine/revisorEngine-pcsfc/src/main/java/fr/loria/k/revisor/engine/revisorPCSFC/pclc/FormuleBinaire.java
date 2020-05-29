package fr.loria.k.revisor.engine.revisorPCSFC.pclc;

import java.util.Objects;

public abstract class FormuleBinaire extends Formule {
    protected Formule leftChild;
    protected Formule rightChild;

    public FormuleBinaire(Formule leftChild, Formule rightChild) {
        super(leftChild, rightChild);
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public Formule getLeftChild() {
        return leftChild;
    }

    @Override
    public Formule getRightChild() {
        return rightChild;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormuleBinaire that = (FormuleBinaire) o;
        return Objects.equals(leftChild, that.leftChild) &&
                Objects.equals(rightChild, that.rightChild);
    }
}
