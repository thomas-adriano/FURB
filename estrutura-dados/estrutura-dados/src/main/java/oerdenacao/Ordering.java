package oerdenacao;

import java.util.Collections;
import java.util.List;

/**
 * Created by thomasadriano on 25/02/15.
 */
public class Ordering {

    public static void selection(List<Integer> toOrder) {
        for (int i = 0; i < toOrder.size(); i++) {
            int minor = i;

            for (int j = i + 1; j < toOrder.size(); j++) {
                if (toOrder.get(minor) > toOrder.get(j)) {
                    minor = j;
                }
            }

            if (toOrder.get(minor) != toOrder.get(i)) {
                Collections.swap(toOrder, i, minor);
            }

        }
    }

    public static void bubble(List<Integer> toOrder) {
        boolean unordered = true;
        while (unordered) {
            unordered = false;
            for (int i = 1; i < toOrder.size(); i++) {
                if (toOrder.get(i - 1) > toOrder.get(i)) {
                    Collections.swap(toOrder, i - 1, i);
                    unordered = true;
                }
            }
        }
    }

}
