package JohnTest;

import java.awt.*;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.function.Function;
class JohnTest { //it's like a singular John Test like JohnTests will have multiple tests but this is just one guy
    String str;
    boolean result;
    public JohnTest(String str, boolean result) {
        this.str = str;
        this.result = result;
    }
}
public class JohnTestsJR { //first name John last name JR

    private ArrayList<Function> ops;
    private ArrayList<Object[]> in;
    private ArrayList<String> got;
    private ArrayList<String> out;
    private ArrayList<Long> times;
    private Class<?> T1;
    private Class<?> T2;
    private int size;

    public JohnTestsJR(){
        this(10);
    }

    public JohnTestsJR(int n){
        ops = new ArrayList<>(n);
        in = new ArrayList<>(n);
        got = new ArrayList<>(n);
        out = new ArrayList<>(n); //I HATE QUEUES!!!!!!!!!!!!!!!!!!!!!!!!!!!! SMITE THE ABSTRACTION DEMONS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        times = new ArrayList<>(n);
        size = 0;
    }


    public void queue(Function f, Object[] args, String expected){
        add(f, args, expected);
    }
    private void add(Function f, Object[] args, String expected){
        ops.add(f);
        in.add(args);
        out.add(expected);
        size++;
    }

    public void fire(){
        long time = System.nanoTime();
        for(int i=0; i<size; i++){
            time = System.nanoTime();
            Function<Object[], Object> f = ops.get(i);
            Object[] args = in.get(i);
            Object tempOut = f.apply(args); //done this way to track time more accurately
            times.add(System.nanoTime() - time);
            got.add("" + tempOut);
        }
    }

    public void displayDebug(){
        System.out.println(got);
        System.out.println(out);
        System.out.println(times);
        System.out.println(size);
        //System.out.println(BuildStringer(true, 1_000_000, "ms"));
        runScreen();
    }
    private String multiplyString(String s, int n){
        StringBuilder out = new StringBuilder();
        for(int i=0; i<n; i++){
            out.append(s);
        }
        return out.toString();
    }
    public JohnTest makeTest(int i, boolean isShort, int timeBase, String timeType){
        String comparator = out.get(i); //two hardest things in programming: cache invalidation and naming things.
        String comparee = got.get(i);
        int len = 30 - out.get(i).length();
        int len2 = 30 - got.get(i).length();
        int len3 = 10 - ("" + out.get(i).equals(got.get(i))).length();
        if (len < 0) len = 0;
        if (len2 < 0) len2 = 0;
        if (len3 < 0) len3 = 0; //lowkey if this happens we got bigger problems here....
        if(isShort) {


            if (comparee.length() > 27) {
                comparee = comparee.substring(0, 27) + "...";
            }
            if (comparator.length() > 27) {
                comparator = comparator.substring(0, 27) + "...";
            }
        }
        return new JohnTest(("" + i) + multiplyString(" ", 7-("" + i).length()) + "| " +
                comparator + multiplyString(" ", len) + "| " + comparee + multiplyString(" ", len2) + "| " +
                out.get(i).equals(got.get(i)) + multiplyString(" ", len3) + "| " + (double)times.get(i)/timeBase + timeType + "\n"
                , comparator.equals(comparee));

    }

    private String BuildStringer(boolean isShort, int timeBase, String timeType){
        StringBuilder str = new StringBuilder();
        str.append("Test # |Expected:                      | Result:                       | Correct?  | Time taken:\n");
        str.append("-------|-------------------------------|-------------------------------|-----------|------------\n");
        int c = 0;

        for (int i = 0; i < size; i++) {
            JohnTest test = makeTest(i, isShort, timeBase, timeType);
            str.append(test.str);
            if(test.result){
                c++;
            }
        }

        str.append("       |                               |                               |-----------|------------\n");
        str.append("-------|-------------------------------|-------------------------------| % Correct: " + 100 * (double)c / size + "%");

        return "" + str;
    }

    private void runScreen(){
        WindowTests win = new WindowTests();
        JohnTest[] arr = new JohnTest[size];
        for(int i=0; i<size; i++){
            arr[i] = makeTest(i, false, 1, "ns");
        }
        win.fire(arr);
    }


}
