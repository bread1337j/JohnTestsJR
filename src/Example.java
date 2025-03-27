import JohnTestsJR.JohnTestsJR;

import java.util.function.Function;

public class Example {


    public static void main(String[] args) {

        JohnTestsJR jr = new JohnTestsJR();

        Integer[] a = new Integer[]{1, 2};


        jr.config(true, 1_000_000, "ms"); //this will make it shorten strings that got too long, and convert time taken to miliseconds
        jr.windowConfig(true); //will turn on dark mode
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
        jr.queue((Function<Integer[], Integer>)ExampleFunctions::square, 25, "1401412418949127417281247148748901284"); //this will be wrong
        jr.queue(JohnTestsJR.funcifierII(ExampleFunctions::square2), 5, "25"); //funcifiers exist to convert non-array functions into array functions

        jr.queue(1, "1");
        jr.queue(new Integer[]{1}, "1");

        System.out.println(f.toString());
        jr.fire();
        //jr.displayDebug();
        jr.run(); //this will print to console
        jr.runScreen(); //this will output to a window
    }
}