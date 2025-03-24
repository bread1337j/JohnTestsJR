import JohnTest.JohnTestsJR;

import java.util.function.Function;

public class Example {


    public static void main(String[] args) {

        JohnTestsJR jr = new JohnTestsJR();

        Integer[] a = new Integer[]{1, 2};

        /*
        Important disclaimer:
        I have no clue what I am doing and as a result this might be a very stupid implementation



        HOW TO USE:

        * You can either pre assign the function using Function<Type1[], Type2> foo = Class::MethodName
        OR
        * You can type cast it inside the expression

        * the function should take in an array, it is annoying and probably easy to fix but it is how it is for now.

        */
        Function<Integer[], Integer> f = ExampleFunctions::add;
        Function<Integer[], Integer> g = ExampleFunctions::subtract;
        jr.queue(f, a, "3"); 
        jr.queue(g, a, "-1");
        jr.queue((Function<Integer[], Integer>)ExampleFunctions::add, a, "3"); //example one liner
        jr.queue(f, a, "3");
        jr.fire();
        jr.displayDebug();
    }
}