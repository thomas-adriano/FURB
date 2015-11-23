import com.furb.teoriagrafos.AlgoritmoRobertEFlores;
import com.furb.teoriagrafos.MatrizAdjacencia;
import com.furb.teoriagrafos.Resultado;

/**
 * Created by thomasadriano on 08/11/15.
 */
public class Main {

    public static void main(String[] args) {
        //cria uma matriz de adjacencia conforme ilustracao abaixo
        //|1__|2|_|3|_|4|_|5|_|6|
        //|2| |3| |1| |3| |3| |1|
        //| | |5| |4| |6| |4| |2|
        //| | | | | | | | | | |3|
        MatrizAdjacencia<Integer> adj = new MatrizAdjacencia<>();
        adj.addRota(1/*V. orig*/, 2/*V. dest*/) //
                .addRota(2/*V. orig*/, 3, 5 /*V. dests*/) //
                .addRota(3/*V. orig*/, 1, 4 /*V. dests*/) //
                .addRota(4/*V. orig*/, 3, 6 /*V. dests*/) //
                .addRota(5/*V. orig*/, 3, 4 /*V. dests*/) //
                .addRota(6/*V. orig*/, 1, 2, 3 /*V. dests*/); //

        //instancia algoritmo de Robert e Flores passando a matriz de adjacencia criada acima
        AlgoritmoRobertEFlores alg = new AlgoritmoRobertEFlores(adj);

        //executa e obtem o resultado de execucao
        Resultado res = alg.executar();

        //imprime o resultado na console
        System.out.println(res);
    }
}
