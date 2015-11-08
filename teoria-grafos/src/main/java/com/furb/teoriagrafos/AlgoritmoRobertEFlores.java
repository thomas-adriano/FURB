package com.furb.teoriagrafos;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Created by thomasadriano on 07/11/15.
 */
public class AlgoritmoRobertEFlores {


    private final MatrizAdjacencia matrizAdjacencia;
    private Vertice verticeInicial;
    private final Resultado resultado = new Resultado();
    private int quantidadeDeVertices = 0;
    private int quantidadeDeVerticesJaCaminhado = 0;

    public AlgoritmoRobertEFlores(MatrizAdjacencia matrizAdjacencia) {
        this.matrizAdjacencia = matrizAdjacencia;
        this.quantidadeDeVertices = matrizAdjacencia.getVertices().size();
    }

    public <T extends Comparable<T>> Resultado<T> executar() {
        Stack<Vertice<T>> stack = new Stack<>();

        while ((verticeInicial = matrizAdjacencia.proximoVerticeOrigem()) != null) {
            if (!matrizAdjacencia.getRota(verticeInicial.getLabel()).isEmpty()) {
                break;
            }
        }

        if (verticeInicial == null) {
            return resultado;
        }

        doExecute(matrizAdjacencia, stack, verticeInicial);

        return resultado;
    }


    private <T extends Comparable<T>> void doExecute(MatrizAdjacencia adj, Stack<Vertice<T>> stack, Vertice<T> verticeAtual) {
        stack.push(verticeAtual);
        quantidadeDeVerticesJaCaminhado++;

        MatrizAdjacencia m = new MatrizAdjacencia(adj);
        m.removerVerticeDestino(verticeAtual.getLabel());

        List<Vertice> rota = m.getRota(verticeAtual.getLabel());

        if (quantidadeDeVerticesJaCaminhado == quantidadeDeVertices && matrizAdjacencia.getRota(verticeAtual.getLabel()).contains(verticeInicial)) {
            stack.push(verticeInicial);
            resultado.addCicloHamiltoniano(stack.stream().collect(Collectors.toList()));
            stack.pop();
            return;
        }

        if (rota.isEmpty()) {
            quantidadeDeVerticesJaCaminhado--;
            stack.pop();
            return;
        }

        for (int i = 0; i < rota.size(); i++) {
            if (!rota.isEmpty()) {
                doExecute(m, stack, rota.get(i));
            }

            if (!stack.peek().equals(verticeAtual)) {
                quantidadeDeVerticesJaCaminhado--;
                stack.pop();
            }
        }
    }

}
