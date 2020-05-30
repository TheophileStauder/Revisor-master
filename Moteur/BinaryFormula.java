package Moteur;

import java.util.Objects;

public abstract class BinaryFormula extends Formula {
    protected Formula leftChild;
    protected Formula rightChild;

    public BinaryFormula(Formula leftChild, Formula rightChild) {
        super(leftChild, rightChild);
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public Formula getLeftChild() {
        return leftChild;
    }

    @Override
    public Formula getRightChild() {
        return rightChild;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryFormula that = (BinaryFormula) o;
        return Objects.equals(leftChild, that.leftChild) &&
                Objects.equals(rightChild, that.rightChild);
    }
}
