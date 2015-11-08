package estruturas;

/**
 * Created by thomasadriano on 16/03/15.
 */
public class DoubleNode<T> {
    private DoubleNode<T> anterior;
    private DoubleNode<T> proximo;
    private T valor;

    public DoubleNode(T valor) {
        this.valor = valor;
    }

    /**
     * blablabla
     * @return
     */
    public DoubleNode<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(DoubleNode<T> anterior) {
        this.anterior = anterior;
    }

    public DoubleNode<T> getProximo() {
        return proximo;
    }

    public void setProximo(DoubleNode<T> proximo) {
        this.proximo = proximo;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }
}
