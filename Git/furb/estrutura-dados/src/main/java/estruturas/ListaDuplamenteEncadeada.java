package estruturas;

/**
 * Created by thomasadriano on 16/03/15.
 */
public class ListaDuplamenteEncadeada<T extends Comparable<T>> {

    private DoubleNode<T> inicio;

    public DoubleNode<T> insere(DoubleNode<T> node) {
        if (inicio == null) {
            inicio = node;
            return inicio;
        }

        node.setProximo(inicio);
        inicio.setAnterior(node);
        inicio = node;

        return inicio;
    }

    public void swap(DoubleNode<T> node1, DoubleNode<T> node2) {
        DoubleNode<T> node1Anterior = node1.getAnterior();
        DoubleNode<T> node1Proximo = node1.getProximo();

        DoubleNode<T> node2Anterior = node2.getAnterior();
        DoubleNode<T> node2Proximo = node2.getProximo();

        if (node1Anterior != null) {
            node1Anterior.setProximo(node2);
        }
        if (node1Proximo != null) {
            node1Proximo.setAnterior(node2);
        }
        node2.setProximo(node1Proximo);
        node2.setAnterior(node1Anterior);

        if(node2Anterior != null) {
            node2Anterior.setProximo(node1);
        }
        if(node2Proximo != null) {
            node2Proximo.setAnterior(node1);
        }
        node1.setProximo(node2Proximo);
        node1.setAnterior(node2Anterior);
    }

}
