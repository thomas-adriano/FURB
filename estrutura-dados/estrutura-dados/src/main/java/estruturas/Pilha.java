package estruturas;

/**
 * Created by thomasadriano on 16/03/15.
 */
public class Pilha<T extends Comparable> {

    private Node<T> topo;
    private int size;

    public void push(Node<T> no) {
        size++;
        if (this.topo == null) {
            this.topo = no;
            return;
        }

        Node<T> anterior = topo;
        topo = no;
        topo.setProximo(anterior);
    }

    public Node<T> pop() {
        size--;
        Node<T> novoTopo = topo.getProximo();
        Node<T> result = topo;
        topo.setProximo(null);
        topo = novoTopo;
        return result;
    }

}
