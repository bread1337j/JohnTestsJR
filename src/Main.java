import jdk.dynalink.Operation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;

public class Main {


    public static void main(String[] args) {

        JohnTestsJR jr = new JohnTestsJR();

        Integer[] a = new Integer[]{1, 2};
        Function<Integer[], Integer> f = Test::add;
        Function<Integer[], Integer> g = Test::subtract; //there's probably a better way to do this too bad i dont know what it is lol
        jr.queue(f, a, "3");
        jr.queue(g, a, "-1");
        jr.fire();
        jr.display();
    }
}