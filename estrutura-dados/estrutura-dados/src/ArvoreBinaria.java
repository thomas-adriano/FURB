public class ArvoreBinaria {
    private NodoArvore raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    public void insereElemento(int info) {
        NodoArvore n = new NodoArvore(info);
        if (raiz == null)
            raiz = n;
        else {
            NodoArvore p = raiz;
            boolean inseriu = false;
            do {
                if (info < p.getInfo()) {
                    if (p.getEsquerda() == null) {
                        p.setEsquerda(n);
                        inseriu = true;
                    } else
                        p = p.getEsquerda();

                } else {
                    if (p.getDireita() == null) {
                        p.setDireita(n);
                        inseriu = true;
                    } else
                        p = p.getDireita();
                }
            } while (!inseriu);
        }

    }

    public boolean pesquisa(int info) {
        NodoArvore r = raiz;
        while (r != null) {
            if (r.getInfo() == info)
                return true;
            else if (info < r.getInfo())
                r = r.getEsquerda();
            else
                r = r.getDireita();
        }
        return false;
    }

    public void resetaMarca() {
        resetaMarcaR(raiz);
    }

    private void resetaMarcaR(NodoArvore r) {
        if (r != null) {
            r.setMarca(false);
            resetaMarcaR(r.getEsquerda());
            resetaMarcaR(r.getDireita());
        }
    }

    public ArvoreBinaria constroiArvore(String s) {
        ArvoreBinaria a = new ArvoreBinaria();
        CadeiaChar cc = new CadeiaChar(s);
        a.raiz = constroiArvoreR(s, cc);
        return a;
    }

    private NodoArvore constroiArvoreR(String s, CadeiaChar cc) {
        char c = cc.getProximoChar();
        if (c == '*')
            return null;
        else {
            NodoArvore n = new NodoArvore(c);
            n.setEsquerda(constroiArvoreR(s, cc));
            n.setDireita(constroiArvoreR(s, cc));
            return n;
        }
    }


    public boolean comparaArvores(ArvoreBinaria a) /* compara a arvore this com a arvore "a" */ {
        return comparaArvores(this.raiz, a.raiz);

    }

    private boolean comparaArvores(NodoArvore a, NodoArvore b) {
        PilhaEncadeada<NodoArvore> p = new PilhaEncadeada<NodoArvore>();
        p.empilha(a);
        p.empilha(b);

        while (!p.vazia()) {
            NodoArvore a1 = p.desempilha();
            NodoArvore a2 = p.desempilha();
            if (a1 != null && a2 != null)
                if (a1.getInfo() == a2.getInfo()) {
                    p.empilha(a2.getDireita());
                    p.empilha(a1.getDireita());
                    p.empilha(a2.getEsquerda());
                    p.empilha(a1.getEsquerda());
                } else
                    return false;
            else if (a1 != null || a2 != null)
                return false;
        }
        return true;
    }

    public void preFixado() {
        preFixadoR(raiz);
    }

    private void preFixadoR(NodoArvore r) {
        if (r != null) {
            System.out.println(r.getInfo());
            preFixadoR(r.getEsquerda());
            preFixadoR(r.getDireita());
        } else
            System.out.println("*");
        return;
    }

    public void central() {
        centralR(raiz);
    }

    private void centralR(NodoArvore r) {
        if (r != null) {
            centralR(r.getEsquerda());
            System.out.println(r.getInfo());
            centralR(r.getDireita());
        }
        return;
    }

    public void posFixado() {
        posFixadoR(raiz);
    }

    private void posFixadoR(NodoArvore r) {
        if (r != null) {
            posFixadoR(r.getEsquerda());
            posFixadoR(r.getDireita());
            System.out.println(r.getInfo());
        }
        return;
    }

    public void preFixadoI() {
        PilhaEncadeada<NodoArvore> p = new PilhaEncadeada<NodoArvore>();
        p.empilha(raiz);
        NodoArvore n = null;
        while (!p.vazia()) {
            n = p.desempilha();
            if (n != null) {
                System.out.println(n.getInfo());
                p.empilha(n.getDireita());
                p.empilha(n.getEsquerda());

            }

        }

    }

    public void centralI() {
        PilhaEncadeada<NodoArvore> p = new PilhaEncadeada<NodoArvore>();
        resetaMarca();
        p.empilha(raiz);
        NodoArvore n = null;
        while (!p.vazia()) {
            n = p.desempilha();
            if (n != null) {
                if (n.getMarca() == false) {
                    p.empilha(n.getDireita());
                    n.setMarca(true);
                    p.empilha(n);
                    p.empilha(n.getEsquerda());
                } else
                    System.out.println(n.getInfo());

            }

        }

    }

    public void posFixadoI() {
        PilhaEncadeada<NodoArvore> p = new PilhaEncadeada<NodoArvore>();
        resetaMarca();
        p.empilha(raiz);
        NodoArvore n = null;
        while (!p.vazia()) {
            n = p.desempilha();
            if (n != null) {
                if (n.getMarca() == false) {
                    n.setMarca(true);
                    p.empilha(n);
                    p.empilha(n.getDireita());
                    p.empilha(n.getEsquerda());
                } else
                    System.out.println(n.getInfo());

            }

        }

    }

    public int tamanho() { // retorna o numero de nodos da �rvore.
        return tamanhoR(raiz);
    }

    private int tamanhoR(NodoArvore r) {
        if (r != null) {
            return 1 + tamanhoR(r.getEsquerda()) + tamanhoR(r.getDireita());
        } else
            return 0;
    }

    public int contaFolhas() { // retorna o numero de folhas da �rvore
        return contaFolhasR(raiz);
    }

    private int contaFolhasR(NodoArvore r) {
        if (r != null) {
            if (r.getEsquerda() == null && r.getDireita() == null)
                return 1;
            else
                return contaFolhasR(r.getEsquerda())
                        + contaFolhasR(r.getDireita());
        } else
            return 0;
    }

    public int maxNivel() {
        // retorna o maior nivel encontrado na �rvore, considerando que a raiz
        // est� no n�vel 1.
        return maxNivelR(raiz);
    }

    private int maxNivelR(NodoArvore r) {
        if (r != null) {
            int e = maxNivelR(r.getEsquerda());
            int d = maxNivelR(r.getDireita());
            if (e > d)
                return e + 1;
            else
                return d + 1;
        } else
            return 0;
    }

    public int nivel(int info) {
        // retorna o nivel que info se encontra na �rvore, considerando que a
        // raiz est� no n�vel 1.
        // Retorna 0 se info n�o existe na �rvore.
        int nivel = 0;
        NodoArvore r = raiz;
        while (r != null) {
            nivel++;
            if (r.getInfo() == info)
                return nivel;
            else if (info >= r.getInfo())
                r = r.getDireita();
            else
                r = r.getEsquerda();
        }
        return 0;
    }

//	public boolean comparaArvores(ArvoreBinaria a2) {
//		// retorna verdadeiro se as duas arvores tiverem a mesma estrutura e o
//		// mesmo conte�do
//		return comparaArvoresR(this.raiz, a2.raiz);
//	}

    private boolean comparaArvoresR(NodoArvore a1, NodoArvore a2) {
        if (a1 != null && a2 != null) {
            if (a1.getInfo() == a2.getInfo()) {
                return comparaArvoresR(a1.getEsquerda(), a2.getEsquerda())
                        && comparaArvoresR(a1.getDireita(), a2.getDireita());
            } else
                return false;
        } else {
            if (a1 == null && a2 == null)
                return true;
            else
                return false;
        }
    }

    public ArvoreBinaria copia() { // retorna um clone da this.
        ArvoreBinaria nova = new ArvoreBinaria();
        nova.raiz = copiaR(this.raiz);
        return nova;
    }

    private NodoArvore copiaR(NodoArvore r) {
        if (r != null) {
            NodoArvore n = new NodoArvore(r.getInfo());
            n.setEsquerda(copiaR(r.getEsquerda()));
            n.setDireita(copiaR(r.getDireita()));
            return n;
        } else
            return null;
    }

    public boolean remove(int info) {
        // remove info da �rvore

        return false;
    }

    public void amplitude() { // percorrer a �rvore em largura (ou amplitude
        FilaEncadeada<NodoArvore> f = new FilaEncadeada<NodoArvore>();
        f.insereElemento(raiz);
        NodoArvore n = null;
        while (!f.vazia()) {
            n = f.retiraElemento();
            if (n != null) {
                System.out.println(n.getInfo());
                f.insereElemento(n.getEsquerda());
                f.insereElemento(n.getDireita());

            }

        }
        return;
    }



    public NodoArvore pai(NodoArvore p)  //localiza o pai do novo P, retorna a referencia para o pai de P, se o P for a raiz retorna nulo
    {
        NodoArvore q = null;
        NodoArvore nodo;
        if (raiz.getInfo() == p.getInfo()) {
            return null;
        } else {
            boolean achei = false;
            nodo = raiz;
            while ((nodo != null) && (!achei)) {
                q = nodo;
                if (nodo.getInfo() > p.getInfo()) {
                    nodo = nodo.getEsquerda();
                    if (nodo.getInfo() == p.getInfo()) {
                        achei = true;
                    } else {
                        q = nodo;
                        nodo = nodo.getEsquerda();
                    }
                } else {
                    nodo = nodo.getDireita();
                    if (nodo.getInfo() == p.getInfo()) {
                        achei = true;
                    } else {
                        q = nodo;
                        nodo = nodo.getDireita();
                    }
                }
            }
            return nodo;
        }


    }

    public NodoArvore sucessorCentral(NodoArvore p) //quando um nó tem duas sabuarvores
    {
        NodoArvore n = p.getDireita();
        boolean achei = false;
        while ((n != null) && (!achei)) {
            if (n.getEsquerda() != null)
                n = n.getEsquerda();
            else
                achei = true;
        }
        return n;
    }

    public void removeArvore(NodoArvore p) {
        removeArvoreR(raiz, p);
    }

    private void removeArvoreR(NodoArvore r, NodoArvore p) {
        NodoArvore q = pai(p);
        if (p.getEsquerda() == null) {
            if (q == null)  // se pai == null -> È a raiz
                raiz = p.getDireita();
            else {
                if (q.getEsquerda() == p)
                    q.setEsquerda(p.getDireita());
                else
                    q.setDireita(p.getDireita());
            }
        } else {
            if (p.getDireita() == null) {
                if (q == null)
                    raiz = p.getDireita();
                else {
                    if (q.getDireita() == p)
                        q.setDireita(p.getEsquerda());
                    else
                        q.setEsquerda(p.getEsquerda());
                }
            } else {
                NodoArvore t = sucessorCentral(p);
                p.setInfo(t.getInfo());
                removeArvoreR(r, t);
                return;

            }
        }

    }

}


}
