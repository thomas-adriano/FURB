package estruturas;

/**
 * Created by thomasadriano on 02/03/15.
 */
public class ListaContigua<T extends Comparable<T>> {

    private T[] elementos;
    private int tamanho;
    private int maxSize;

    public ListaContigua(int size) {
        this.elementos = (T[]) new Comparable[size];
        this.maxSize = size;
    }

    boolean insere(T info) {
        if (tamanho == elementos.length) {
            return false;
        }

        elementos[tamanho] = info;
        tamanho++;
        return true;
    }

    int consulta(T info) {
        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i].equals(info)) {
                return i;
            }
        }
        return 0;
    }

    T consulta(int posicao) {
        return elementos[posicao];
    }


    /*
    A dica do professor aqui foi inserir o elemento a partir do final da lista,
    facilitando a ordenacao. Pelo jeito não importa o fato de que uma vez o metodo insere()
    (nao ordenado) chamado iria ferrar com toda a ordenação..
     */
    boolean insereOrdem(T info) {
        if (tamanho == elementos.length) {
            return false;
        }

        if (elementos[0] == null) {
            elementos[0] = info;
            tamanho++;
            return true;
        }

        for (int i = elementos.length - 1; i >= 0; i--) {
            if (elementos[i] != null && elementos[i].compareTo(info) > 0) {
                elementos[i + 1] = elementos[i];
                if (i == 0) {
                    elementos[i] = info;
                    tamanho++;
                    break;
                } else {
                    continue;
                }

            }

            if (elementos[i] != null && elementos[i].compareTo(info) <= 0) {
                elementos[i + 1] = info;
                tamanho++;
                break;
            }
        }

        return true;

//        for (int i = 0; i < elementos.length; i++) {
//            T menor = elementos[i];
//            if (menor == null) {
//                return true;
//            }
//            for (int j = i + 1; j < elementos.length; j++) {
//                T aComparar = elementos[j];
//
//                if (aComparar == null) {
//                    break;
//                }
//
//                if (menor.compareTo(aComparar) > 0) {
//                    elementos[i] = aComparar;
//                    elementos[j] = menor;
//
//                }
//
//            }
//
//        }
    }

    boolean excluiElemento(T info) {
        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i].equals(info)) {
                elementos[i] = null;
                return true;
            }
        }
        return false;
    }

    boolean excluiElemento(int posicao) {
        if (posicao >= tamanho) {
            return false;
        }

        elementos[posicao] = null;
        return true;
    }

    int size() {
        return tamanho;
    }


}
