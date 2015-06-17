package estruturas;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by thomasadriano on 02/03/15.
 */
public class ListaEncadeadaTest {


    @Test
    public void mergeTest() {
        ListaEncadeada<Integer> lc = new ListaEncadeada<>();
        lc.insereOrdem(10);
        lc.insereOrdem(20);
        lc.insereOrdem(30);

        ListaEncadeada<Integer> lc2 = new ListaEncadeada<>();
        lc2.insereOrdem(11);
        lc2.insereOrdem(21);
        lc2.insereOrdem(31);

        ListaEncadeada<Integer> expeced = new ListaEncadeada<>();
        expeced.insereOrdem(10);
        expeced.insereOrdem(11);
        expeced.insereOrdem(20);
        expeced.insereOrdem(21);
        expeced.insereOrdem(30);
        expeced.insereOrdem(31);

        ListaEncadeada<Integer> merged = lc.merge(lc2);
        System.out.println(merged);

        Assert.assertThat(expeced, is(merged));

        merged = lc.concatenaListas(lc2);
        System.out.println(merged);

        Assert.assertThat(expeced, is(merged));
    }

    @Test
    public void insereTest() {
        ListaEncadeada<Integer> lc = new ListaEncadeada<>();
        lc.insere(10);
        lc.insere(10);
        lc.insere(10);

        Assert.assertThat(lc.size(), is(3));
    }

    @Test
    public void imprimeTest() {
        ListaEncadeada<Integer> lc = new ListaEncadeada<>();
        lc.insere(10);
        lc.insere(15);
        lc.insere(16);
        lc.insere(55);
        lc.imprime();
    }

    @Test
    public void consultaIndiceTest() {
        ListaEncadeada<Integer> lc = new ListaEncadeada<>();
        lc.insere(10);
        lc.insere(15);
        lc.insere(16);
        lc.insere(55);

        assertThat(lc.consulta(2).getValue(), is(15));
    }

    @Test
    public void consultaNoTest() {
        ListaEncadeada<Integer> lc = new ListaEncadeada<>();
        lc.insere(10);
        lc.insere(15);
        lc.insere(16);
        lc.insere(55);
        Node<Integer> procura = new Node<>(15);

        assertThat(lc.consulta(procura).getValue(), is(15));
    }

    @Test
    public void comparaListaInterativoTest() {
        ListaEncadeada<Integer> lc = new ListaEncadeada<>();
        lc.insere(10);
        lc.insere(15);
        lc.insere(16);
        lc.insere(55);

        ListaEncadeada<Integer> lc2 = new ListaEncadeada<>();
        lc2.insere(33);
        lc2.insere(4);
        lc2.insere(45);
        lc2.insere(2);

        assertThat(lc.comparaListaInterativo(lc2), is(false));

        lc2 = new ListaEncadeada<>();
        lc2.insere(10);
        lc2.insere(15);
        lc2.insere(16);
        lc2.insere(55);

        assertThat(lc.comparaListaInterativo(lc2), is(true));
    }

    @Test
    public void comparaListaRecursivoTest() {
        ListaEncadeada<Integer> lc = new ListaEncadeada<>();
        lc.insere(10);
        lc.insere(15);
        lc.insere(16);
        lc.insere(55);

        ListaEncadeada<Integer> lc2 = new ListaEncadeada<>();
        lc2.insere(33);
        lc2.insere(4);
        lc2.insere(45);
        lc2.insere(2);

        assertThat(lc.comparaListaRecursiva(lc2), is(false));

        lc2 = new ListaEncadeada<>();
        lc2.insere(10);
        lc2.insere(15);
        lc2.insere(16);
        lc2.insere(55);

        assertThat(lc.comparaListaRecursiva(lc2), is(true));
    }

    @Test
    public void copiaListaTest() {
        ListaEncadeada<Integer> lc = new ListaEncadeada<>();
        lc.insere(10);
        lc.insere(15);
        lc.insere(16);
        lc.insere(55);

        ListaEncadeada<Integer> lc2 = lc.copiaLista();

        assertThat(lc, is(lc2));
    }

    @Test
    public void excluiNoTest() {
        //testa meio
        ListaEncadeada<Integer> lc = new ListaEncadeada<>();
        lc.insere(10);
        lc.insere(15);
        lc.insere(16);
        lc.insere(55);

        Node<Integer> exclui = new Node<>(15);

        lc.excluiElemento(exclui);

        assertThat(lc.size(), is(3));
        assertThat(lc.consulta(0).getValue(), is(55));
        assertThat(lc.consulta(1).getValue(), is(16));
        assertThat(lc.consulta(2).getValue(), is(10));
        assertThat(lc.consulta(3), is(IsEqual.equalTo(null)));

        //testa primeiro
        lc = new ListaEncadeada<>();
        lc.insere(10);
        lc.insere(15);
        lc.insere(16);
        lc.insere(55);

        exclui = new Node<>(55);

        lc.excluiElemento(exclui);

        assertThat(lc.size(), is(3));
        assertThat(lc.consulta(0).getValue(), is(16));
        assertThat(lc.consulta(1).getValue(), is(15));
        assertThat(lc.consulta(2).getValue(), is(10));
        assertThat(lc.consulta(3), is(IsEqual.equalTo(null)));


        //testa ultimo
        lc = new ListaEncadeada<>();
        lc.insere(10);
        lc.insere(15);
        lc.insere(16);
        lc.insere(55);

        exclui = new Node<>(10);

        lc.excluiElemento(exclui);

        assertThat(lc.size(), is(3));
        assertThat(lc.consulta(0).getValue(), is(55));
        assertThat(lc.consulta(1).getValue(), is(16));
        assertThat(lc.consulta(2).getValue(), is(15));
        assertThat(lc.consulta(3), is(IsEqual.equalTo(null)));
    }

}
