package com.furb.teoriagrafos;

/**
 * Created by thomasadriano on 07/11/15.
 */
public class Vertice<T extends Comparable<T>> implements Comparable<Vertice<T>> {

    private final T label;

    public Vertice(T label) {
        this.label = label;
    }

    public T getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertice<?> vertice = (Vertice<?>) o;

        return label.equals(vertice.label);

    }

    @Override
    public int hashCode() {
        return label.hashCode();
    }

    @Override
    public int compareTo(Vertice<T> o) {
        return label.compareTo(o.label);
    }

    @Override
    public String toString() {
        return "Vertice{" +
                "label=" + label +
                '}';
    }
}
