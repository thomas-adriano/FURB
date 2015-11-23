public class NodoArvoreB {
    private int capacidade;
    private int[] filho;  //armazena os dados das chaves do nó filho
    private int[] chave;  //armazena os dados das chaves deste nó
    private int nChaves;  //controla o numero de posiçoes já utilizadas
    private int nSubArvores; //controla o numero de subarvores já utilizadas

    public NodoArvoreB(int capacidade) {
        this.capacidade = capacidade;
        filho = new int[capacidade + 1];  // conter� as refer�ncias para os filhos, que ser�o nodos
        // armazenados no arquivo
        this.chave = new int[capacidade];    // conter� as chaves existente no nodo
        nChaves = 0;
        nSubArvores = 0;
    }

    public boolean insereChave(int chave) {
        if (nChaves < capacidade)   // ainda tem lugar no nodo
        {
            for (int i = nChaves - 1; i >= 0; i--) {
                if (chave > this.chave[i]) {
                    this.chave[i + 1] = chave;
                    nChaves++;
                    return true;
                } else {
                    this.chave[i + 1] = this.chave[i];  // eh folha, n�o tem filhos !!!
                }
            }
            this.chave[0] = chave;
            nChaves++;
            return true;
        } else
            return false;
    }


    public int getnSubArvores() {

        return nSubArvores;
    }

    public boolean setFilhoI(int i, int filho) {
        if (i < 0 || i > capacidade + 1) {
            return false;
        } else {
            this.filho[i] = filho;
            return true;
        }
    }

    public int getnChaves() {
        return nChaves;
    }

    public int getFilhoI(int i) {
        if (i < 0 || i > capacidade)
            return -1;
        else
            return filho[i];
    }

    public int getChaveI(int i) {
        if (i < 0 || i > capacidade - 1)
            return -1;
        else
            return chave[i];
    }


    public boolean setChaveI(int i, int chave) {
        if (i < 0 || i >= capacidade)
            return false;
        else {
            this.chave[i] = chave;
            return true;
        }
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setNChaves(int chaves) {
        nChaves = chaves;
    }

    public void setNSubArvores(int subArvores) {
        nSubArvores = subArvores;
    }
}
