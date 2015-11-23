package com.furb.teoriagrafos;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by thomasadriano on 07/11/15.
 */
public class MatrizAdjacencia<T extends Comparable<T>> {

    private final Map<Vertice<T>, List<Vertice<T>>> rotas;
    private Vertice<T> ultimoVerticeOrigem;

    public MatrizAdjacencia() {
        rotas = new HashMap<>();
    }

    public MatrizAdjacencia(MatrizAdjacencia<T> adj) {
        Map<Vertice<T>, List<Vertice<T>>> result = new HashMap<>();
        for (Map.Entry<Vertice<T>, List<Vertice<T>>> entry : adj.rotas.entrySet()) {
            result.put(new Vertice<T>(entry.getKey().getLabel()), deepCopyList(entry.getValue()));
        }
        rotas = result;
    }

    private List<Vertice<T>> deepCopyList(List<Vertice<T>> toCopy) {
        Set<Vertice<T>> result = new TreeSet<>();

        for (Vertice<T> each : toCopy) {
            result.add(new Vertice<>(each.getLabel()));
        }

        return new ArrayList<>(result);
    }

    Set<Vertice<T>> getVertices() {
        return rotas.keySet();
    }

    /**
     * Adiciona uma rota à matriz de adjacencia. Uma rota se define em um vertice origem e
     * um set de vertices imediatamente atingiveis a partir deste vertice origem.
     *
     * @param origem   vertice origem
     * @param destinos vertices imediatamente atingiveis a partir do vertice origem
     * @return instancia desta classe, para uso fluente
     */
    public MatrizAdjacencia addRota(T origem, T... destinos) {
        List<Vertice<T>> rota = null;

        Vertice<T> vOrig = new Vertice<>(origem);
        TreeSet<Vertice<T>> vDest = new TreeSet<>(Arrays.asList(destinos).stream().map((t) -> new Vertice<>(t)).collect(Collectors.toSet()));

        //se nao informou destino para vertice origem, adiciona rota com destino vazio
        if (destinos == null || destinos.length == 0) {
            rotas.put(vOrig, new ArrayList<>());
        } else if ((rota = rotas.get(origem)) == null) {
            rotas.put(vOrig, new ArrayList<>(vDest));
        } else {
            rota.addAll(vDest);
        }
        return this;
    }

    /**
     * Retorna os vertices atingiveis a partir do vertice origem informado.
     *
     * @param origem vertice origem
     * @return set imutavel de vertices atingiveis a partir do vertice origem
     * ou set vazio e imutavel se nao possuir nenhum vertice atingivel
     */
    public List<Vertice<T>> getRota(T origem) {
        List<Vertice<T>> rota = rotas.get(new Vertice<>(origem));
        if (rota == null) {
            rota = Collections.emptyList();
        }
        return Collections.unmodifiableList(rota);
    }

    /**
     * Remove o vertice informado de todas as rotas existentes na matriz de adjacencia.
     *
     * @param vertice label do vertice a ser removido de todas as rotas existentes
     * @return esta instancia, para uso fluente
     */
    public MatrizAdjacencia removerVerticeDestino(T vertice) {

        for (Vertice<T> origem : rotas.keySet()) {
            List<Vertice<T>> destinos = rotas.get(origem);
            destinos.remove(new Vertice<>(vertice));
        }

        return this;
    }

    public Vertice<T> proximoVerticeOrigem() {
        TreeSet<Vertice<T>> verticesOrigem = new TreeSet<>(rotas.keySet());
        Iterator<Vertice<T>> origIterator = verticesOrigem.iterator();
        Vertice<T> verticeAtual = null;

        if (ultimoVerticeOrigem == null) {
            ultimoVerticeOrigem = origIterator.next();
            return ultimoVerticeOrigem;
        }

        if (verticesOrigem.higher(ultimoVerticeOrigem) == null) {
            return null;
        }

        while ((verticeAtual = origIterator.next()) != null && verticeAtual.compareTo(ultimoVerticeOrigem) <= 0) {
        }

        ultimoVerticeOrigem = verticeAtual;

        return ultimoVerticeOrigem;
    }

}
