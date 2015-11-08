package oerdenacao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thomasadriano on 25/02/15.
 */
public class Main {

    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        data.add(5);
        data.add(3);
        data.add(56);
        data.add(11);
        data.add(1);
        data.add(0);

        Ordering.selection(data);

        System.out.println(data);

        data = new ArrayList<>();
        data.add(5);
        data.add(3);
        data.add(56);
        data.add(11);
        data.add(1);
        data.add(0);

        Ordering.bubble(data);

        System.out.println(data);
    }

}
