import JohnTest.JohnTestsJR;

import java.util.function.Function;

public class Example {


    public static void main(String[] args) {

        JohnTestsJR jr = new JohnTestsJR();

        Integer[] a = new Integer[]{1, 2};
        Function<Integer[], Integer> f = ExampleFunctions::add;
        Function<Integer[], Integer> g = ExampleFunctions::subtract; //there's probably a better way to do this too bad i dont know what it is lol
        jr.queue(f, a, "3");
        jr.queue(g, a, "-612412");
        jr.fire();
        jr.displayDebug();
    }
}