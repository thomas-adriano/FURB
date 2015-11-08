package com.furb.teoriagrafos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by thomasadriano on 08/11/15.
 */
public class Resultado<T extends Comparable<T>> implements Iterable<List<Vertice<T>>> {

    private final List<List<Vertice<T>>> resultado = new ArrayList<>();

    public Resultado addCicloHamiltoniano(List<Vertice<T>> ciclo) {
        this.resultado.add(ciclo);
        return this;
    }

    @Override
    public Iterator<List<Vertice<T>>> iterator() {
        return resultado.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < resultado.size(); i++) {
            sb.append("Ciclo hamiltoniano ").append(i + 1).append(": ").append(resultado.get(i)).append("\n");
        }

        return sb.toString();
    }
}
