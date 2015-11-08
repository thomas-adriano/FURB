package estruturas;

import org.junit.Test;

/**
 * Created by thomasadriano on 16/03/15.
 */
public class ListaDuplamenteEncadeadaTest {

    @Test
    public void testInsere() {
        ListaDuplamenteEncadeada<Integer> lista = new ListaDuplamenteEncadeada<>();
        lista.insere(new DoubleNode<Integer>(10));
        lista.insere(new DoubleNode<Integer>(20));
        lista.insere(new DoubleNode<Integer>(30));
        lista.insere(new DoubleNode<Integer>(40));
        lista.insere(new DoubleNode<Integer>(50));
    }

    @Test
    public void swatTest() {
        ListaDuplamenteEncadeada<Integer> lista = new ListaDuplamenteEncadeada<>();
        DoubleNode<Integer> no1 = lista.insere(new DoubleNode<Integer>(10));
        DoubleNode<Integer> no2 = lista.insere(new DoubleNode<Integer>(20));
        DoubleNode<Integer> no3 = lista.insere(new DoubleNode<Integer>(30));
        DoubleNode<Integer> no4 = lista.insere(new DoubleNode<Integer>(40));
        DoubleNode<Integer> no5 = lista.insere(new DoubleNode<Integer>(50));

        lista.swap(no2, no4);
    }
}
