package estruturas;

public class Node<T extends Comparable> {
        private T value;
        private Node<T> proximo;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getProximo() {
            return proximo;
        }

        public void setProximo(Node<T> proximo) {
            this.proximo = proximo;
        }
    }