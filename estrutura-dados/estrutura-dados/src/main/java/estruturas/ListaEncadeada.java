package estruturas;

/**
 * Created by thomasadriano on 02/03/15.
 */
public class ListaEncadeada<T extends Comparable> {
    private Node<T> inicio;
    private int size;

    ListaEncadeada<T> merge(ListaEncadeada<T> toMerge) {
        ListaEncadeada<T> result = new ListaEncadeada<>();

        Node<T> esta = inicio;

        Node<T> outra = toMerge.inicio;

        while (esta != null && outra != null) {

            if (esta.getValue().compareTo(outra.getValue()) < 0) {
                result.insere(outra.getValue());
                outra = outra.getProximo();
            } else {
                result.insere(esta.getValue());
                esta = esta.getProximo();
            }

        }

        while (esta != null) {
            result.insere(esta.getValue());
            esta = esta.getProximo();
        }

        while (outra != null) {
            result.insere(outra.getValue());
            outra = outra.getProximo();
        }

        return result;
    }

    public ListaEncadeada<T> concatenaListas(ListaEncadeada<T> l2) {
        ListaEncadeada<T> lN = new ListaEncadeada<T>();
        Node<T> p1 = this.inicio;
        Node<T> p2 = l2.inicio;
        Node<T> pN = null; // variavel para ligar os objetos
        Node<T> aux;
        while ((p1 != null) && (p2 != null)) {
            if (p1.getValue().compareTo(p2.getValue()) < 0) // compara
            { // as informacoes de p1 e p2 para ver qual È maior;
                aux = new Node<T>(p1.getValue()); // se
                p1 = p1.getProximo(); // ja
            } else {
                aux = new Node<T>(p2.getValue()); // se
                p2 = p2.getProximo(); // ja peguei, vou para o proximo.
            }
            if (pN == null) { // para ligar os
                pN = aux;
                lN.inicio = aux;
            } else {
                pN.setProximo(aux); // pN recebe o aux
                pN = aux;
            }
        }
        if (p1 == null) {
            while (p2 != null) {
                aux = new Node<T>(p2.getValue());
                p2 = p2.getProximo();
                if (pN != null) {
                    pN.setProximo(aux); // pN recebe o aux (proximo objeto)
                    pN = aux;
                } else {
                    lN.inicio = aux;
                    pN = aux;
                }
            }
        } else {
            while (p1 != null) {
                aux = new Node<T>(p1.getValue());
                p1 = p1.getProximo();
                if (pN != null) {
                    pN.setProximo(aux); // pN recebe o aux (proximo objeto)
                    pN = aux;
                } else {
                    lN.inicio = aux;
                    pN = aux;
                }
            }
        }
        return lN;
    }


    void insereOrdem(T info) {
        if (inicio == null) {
            inicio = new Node<T>(info);
            return;
        } else {
            Node<T> p, p_ant;
            p = inicio;
            p_ant = inicio;
            while (p.getValue().compareTo(info) < 0) {
                if (p.getProximo() != null) {
                    p_ant = p;
                    p = p.getProximo();
                } else {
                    Node<T> nodo = new Node<T>(info);
                    p.setProximo(nodo);
                    return;
                }
            }
            Node<T> nodo = new Node<T>(info);
            nodo.setProximo(p);
            if (inicio == p) {
                inicio = nodo;
            } else
                p_ant.setProximo(nodo);
            return;
        }
    }


    boolean insere(T info) {

        Node<T> no = new Node<>(info);
        no.setProximo(inicio);
        inicio = no;
        size++;
        return true;
    }

    Node<T> consulta(Node<T> no) {
        if (inicio == null) {
            return null;
        } else {
            Node<T> atual = inicio;
            while (atual != null) {
                if (atual.getValue().equals(no.getValue())) {
                    return atual;
                }
                atual = atual.getProximo();
            }
        }
        return null;
    }

    Node<T> consulta(int posicao) {
        if (inicio == null) {
            return null;
        } else {
            int counter = 0;
            Node<T> atual = inicio;
            while (atual != null) {
                if (counter == posicao) {
                    return atual;
                }
                atual = atual.getProximo();
                counter++;

            }
        }

        return null;
    }

    boolean excluiElemento(Node<T> no) {
        if (inicio == null) {
            return false;
        } else {
            Node<T> atual = inicio;
            Node<T> anterior = null;
            while (atual != null) {
                if (atual.getValue().equals(no.getValue())) {
                    if (atual.getValue().equals(inicio.getValue())) {
                        inicio = inicio.getProximo();
                        size--;
                        atual.setProximo(null);
                        return true;
                    }

                    anterior.setProximo(atual.getProximo());
                    size--;
                    atual.setProximo(null);
                    return true;
                }
                anterior = atual;
                atual = atual.getProximo();
            }
        }
        return false;
    }

    ListaEncadeada<T> copiaLista() {
        ListaEncadeada<T> result = new ListaEncadeada<>();
        Node<T> no = this.inicio;
        Node<T> no2 = no;

        result.inicio = no2;

        while (no != null) {
            no2.setProximo(no.getProximo());
            no = no.getProximo();
        }

        return result;

    }

    boolean comparaListaInterativo(ListaEncadeada<T> lista) {
        Node<T> raiz = this.inicio;
        Node<T> outraRaiz = lista.inicio;

        if (raiz.getValue().compareTo(outraRaiz.getValue()) != 0) {
            return false;
        }

        while ((raiz = raiz.getProximo()) != null && (outraRaiz = outraRaiz.getProximo()) != null) {
            if (raiz.getValue().compareTo(outraRaiz.getValue()) != 0) {
                return false;
            }
        }

        return true;
    }

    boolean comparaListaRecursiva(ListaEncadeada<T> lz) {
        Node<T> raiz = this.inicio;
        Node<T> outraRaiz = lz.inicio;

        return comparaListaAux(raiz, outraRaiz);
    }

    private boolean comparaListaAux(Node<T> no, Node<T> outroNo) {
        if (no == null && outroNo == null) {
            return true;
        } else if (no == null || outroNo == null) {
            return false;
        }

        if (no.getValue().compareTo(outroNo.getValue()) == 0) {
            return comparaListaAux(no.getProximo(), outroNo.getProximo());
        } else {
            return false;
        }

    }

    boolean excluiElemento(int posicao) {
        return false;
    }

    int size() {
        return size;
    }

    void imprime() {
        imprimeAux(inicio);
    }

    private void imprimeAux(Node<T> no) {
        if (no != null) {
            System.out.println(no.getValue());
            if (no.getProximo() != null) {
                imprimeAux(no.getProximo());
            }
        }
    }

    @Override
    public String toString() {
        Node<T> no = inicio;
        StringBuilder sb = new StringBuilder();
        while (no != null) {
            sb.append(no.getValue()).append(", ");
            no = no.getProximo();
        }
        return sb.toString();
    }


}
