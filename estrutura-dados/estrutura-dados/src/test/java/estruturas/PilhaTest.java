package estruturas;

import org.junit.Test;

/**
 * Created by thomasadriano on 16/03/15.
 */
public class PilhaTest {

    @Test
    public void testPush() {
        Pilha<Integer> p = new Pilha();
        p.push(new Node<Integer>(10));
        p.push(new Node<Integer>(20));
        p.push(new Node<Integer>(30));
        p.push(new Node<Integer>(40));
    }


    @Test
    public void testPop() {
        Pilha<Integer> p = new Pilha();
        p.push(new Node<Integer>(10));
        p.push(new Node<Integer>(20));
        p.push(new Node<Integer>(30));
        p.push(new Node<Integer>(40));

        Node<Integer> popped1 = p.pop();
        Node<Integer> popped2 = p.pop();
        Node<Integer> popped3 = p.pop();
        Node<Integer> popped4 = p.pop();
    }

}
