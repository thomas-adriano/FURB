package com.furb.teoriagrafos;


import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

/**
 * Created by thomasadriano on 07/11/15.
 */
public class MatrizAdjacenciaTest {

    private MatrizAdjacencia<Integer> mat;

    @Before
    public void setUpMethod() {
        mat = new MatrizAdjacencia<>();
    }

    @Test
    public void deveriaAdicionar_VerticeOrigem_QuePossue_UnicoVerticeDestino() {
        mat.addRota(1, 2);
        List<Vertice<Integer>> rota = mat.getRota(1);
        assertThat(rota, is(Arrays.asList(new Vertice<>(2))));
    }

    @Test
    public void deveriaAdicionar_VerticeOrigem_QuePossue_VariosVerticesDestino() {
        mat.addRota(1, 2, 3, 4);
        List<Vertice<Integer>> rota = mat.getRota(1);
        assertThat(rota, is(Arrays.asList(new Vertice<>(2), new Vertice<>(3), new Vertice<>(4))));
    }

    @Test
    public void deveriaAdicionar_VerticeOrigem_QuePossue_ZeroVerticesDestino() {
        mat.addRota(1);
        List<Vertice<Integer>> rota = mat.getRota(1);
        assertThat(rota, is(new ArrayList<>()));
    }

    @Test
    public void deveriaArmazenar_VerticesDestino_Ordenadamente() {
        mat.addRota(1, 9, 5, 7, 333, 8, 666);
        List<Vertice<Integer>> rota = mat.getRota(1);
        assertThat(rota, contains(new Vertice<>(5), new Vertice<>(7), new Vertice<>(8)
                , new Vertice<>(9), new Vertice<>(333), new Vertice<>(666)));
    }

    @Test
    public void deveriaRemover_VerticesDestino_DeTodasAsRotasExistentes() {
        mat.addRota(1, 3, 5, 7);
        mat.addRota(2, 4, 6, 8);
        mat.addRota(3, 3, 7);
        mat.addRota(4, 4, 6);

        mat.removerVerticeDestino(3);
        mat.removerVerticeDestino(6);

        List<Vertice<Integer>> rotaSemTres = mat.getRota(1);
        assertThat(rotaSemTres, is(Arrays.asList(new Vertice<>(5), new Vertice<>(7))));

        rotaSemTres = mat.getRota(3);
        assertThat(rotaSemTres, is(Arrays.asList(new Vertice<>(7))));

        List<Vertice<Integer>> rotaSemSeis = mat.getRota(2);
        assertThat(rotaSemSeis, is(Arrays.asList(new Vertice<>(4), new Vertice<>(8))));

        rotaSemSeis = mat.getRota(4);
        assertThat(rotaSemSeis, is(Arrays.asList(new Vertice<>(4))));
    }

    @Test
    public void copiaDaMatriz_deveriaSerProfunda() {
        mat.addRota(1, 3, 5, 7);
        MatrizAdjacencia<Integer> mat2 = new MatrizAdjacencia<>(mat);
        mat.removerVerticeDestino(5);

        assertThat(mat2.getRota(1), is(Arrays.asList(new Vertice<>(3), new Vertice<>(5), new Vertice<>(7))));
    }

    @Test
    public void proximoVerticeOrigemTest() {
        mat.addRota(2, 4, 6, 8);
        mat.addRota(10, 20, 50, 15);
        mat.addRota(1, 3, 7, 5);

        List<Vertice<Integer>> verticesOrigem = new ArrayList<>();

        Vertice<Integer> v = null;

        while ((v = mat.proximoVerticeOrigem()) != null) {
            verticesOrigem.add(v);
        }

        assertThat(verticesOrigem, is(new ArrayList<>(Arrays.asList(new Vertice<>(1), new Vertice<>(2), new Vertice<>(10)))));
    }

}
