package com.furb.teoriagrafos;

import org.junit.Test;

/**
 * Created by thomasadriano on 07/11/15.
 */
public class AlgoritmoRobertEFloresTest {

    @Test
    public void test() {
        MatrizAdjacencia<Integer> adj = new MatrizAdjacencia<>();
        adj.addRota(1, 2).addRota(2, 3, 5).addRota(3, 1, 4).addRota(4, 3, 6).addRota(5, 3, 4).addRota(6, 1, 2, 3);

        AlgoritmoRobertEFlores alg = new AlgoritmoRobertEFlores(adj);

        Resultado res = alg.executar();

        System.out.println(res);
    }
}
