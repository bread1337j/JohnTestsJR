package JohnTestsJR;

import javax.swing.*;
import java.awt.*;

public class JLTest extends JLabel{ //not part of the Tests family, kinda an outcast
    //stores all the info to make his test, and can toggle whether the JFrame text is compacted

    //public JLTest label;
    public int i;
    public boolean isShort;
    public String tb;
    public int t;
    public JohnTest test;
    public JohnTestsJR tester; //has to be binded to a JohnTestsJR


    public JLTest(String str){
        super(str);
    }
    public JLTest(JohnTestsJR tester, int i, String tb, int t){
        this.i = i;
        this.tb = tb;
        this.t = t;
        this.isShort = true;
        this.tester = tester;
        this.test = tester.makeTest(i, true, t, tb);
        //this.label = new JLTest(test.str); //a person who thinks all the time has nothing to think about except thoughts
        this.setText(this.test.str);
    }

    private JLabel formatStr(String s){
        JLabel l = new JLabel(s);
        l.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        return l;
    }

    public void toggleShort(){
        this.isShort = !this.isShort;
        this.test = this.tester.makeTest(i, this.isShort, t, tb);
        this.setText(test.str);
    }
}
