package estruturas;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by thomasadriano on 02/03/15.
 */
public class ListaContiguaTest {


    @Test
    public void insereTest() {
        ListaContigua<Integer> lc = new ListaContigua<>(5);
        lc.insere(10);
        lc.insere(10);
        lc.insere(10);

        assertThat(lc.size(), is(3));

        lc.insere(10);
        lc.insere(10);
        assertThat(lc.size(), is(5));

        assertThat(lc.insere(10), is(false));
    }

    @Test
    public void consultaPorTipoTest() {
        Integer dez = 10;

        ListaContigua<Integer> lc = new ListaContigua<>(5);
        lc.insere(13);
        lc.insere(4);
        lc.insere(6);
        lc.insere(dez);

        assertThat(lc.size(), is(4));

        Integer result = lc.consulta(dez);

        assertThat(result, is(3));
    }

    @Test
    public void consultaPorIndiceTest() {
        Integer dez = 10;

        ListaContigua<Integer> lc = new ListaContigua<>(5);
        lc.insere(13);
        lc.insere(4);
        lc.insere(dez);
        lc.insere(6);


        assertThat(lc.size(), is(4));

        Integer result = lc.consulta(2);

        assertThat(result, is(dez));

    }

    @Test
    public void insereOrdemTest() {

        ListaContigua<Integer> lc = new ListaContigua<>(5);
        lc.insereOrdem(13);
        lc.insereOrdem(4);
        lc.insereOrdem(8);
        lc.insereOrdem(6);
        lc.insereOrdem(1);


        assertThat(lc.size(), is(5));

        assertThat(lc.consulta(0), is(1));
        assertThat(lc.consulta(1), is(4));
        assertThat(lc.consulta(2), is(6));
        assertThat(lc.consulta(3), is(8));
        assertThat(lc.consulta(4), is(13));
    }

}