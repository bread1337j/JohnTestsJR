import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.function.Function;

public class JohnTestsJR {

    private ArrayList<Function> ops;
    private ArrayList<Object[]> in;
    private ArrayList<String> got;
    private ArrayList<String> out;
    private ArrayList<Long> times;
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

    public void queue(Function f, Object arg, String expected){
       add(f, new Object[]{arg}, expected);
    }
    public void queue(Function f, Object[] args, String expected){
        add(f, args, expected);
    }
    private void add(Function f, Object[] args, String expected){
        ops.addFirst(f);
        in.addFirst(args);
        out.addFirst(expected);
        size++;
    }

    public void fire(){
        for(int i=0; i<size; i++){
            long time = System.nanoTime();
            Function<Object[], Object> f = ops.get(i);
            Object[] args = in.get(i);
            Object tempOut = f.apply(args); //done this way to track time more accurately
            times.add(System.nanoTime() - time);
            got.add("" + tempOut);
            String expected = out.get(i);
            //System.out.println(tempOut + " vs " + expected);
        }
    }

    public void display(){
        System.out.println(got);
        System.out.println(out);
        System.out.println(times);
    }
}
