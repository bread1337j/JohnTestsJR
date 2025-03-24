package JohnTest;

import javax.swing.*;
import java.awt.*;

public class WindowTests extends JScrollPane { //first name Window last name Tests

    private JPanel pn;
    private JFrame fr;
    private JScrollPane jsp;


    public WindowTests() {
        pn = new JPanel();
        fr = new JFrame();
        jsp = new JScrollPane(pn);
    }

    private void configStuff(){
        fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
        pn.setLayout(new BoxLayout(pn, BoxLayout.Y_AXIS));
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void open(){
        fr.add(jsp);
        fr.setVisible(true);
    }

    private JLabel formatStr(String s){
        JLabel l = new JLabel(s);
        l.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        return l;
    }

    public void fire(JohnTest[] tests){
        pn.removeAll();
        configStuff();

        pn.add(formatStr("Test # |Expected:                      | Result:                       | Correct?  | Time taken:\n"));
        pn.add(formatStr("-------|-------------------------------|-------------------------------|-----------|------------\n"));
        int c = 0;
        for(int i=0; i<tests.length; i++){
            JLabel l = formatStr(tests[i].str);
            if(tests[i].result){
                l.setForeground(Color.GREEN);
                c++;
            }else{
                l.setForeground(Color.RED);
            }
            pn.add(l);
        }

        double percentCorrect =100 * (double)c / tests.length;
        JLabel resultpt2 = (formatStr("       |                               |                               |-----------|------------\n"));
        JLabel resultpt1 = (formatStr(("-------|-------------------------------|-------------------------------| % Correct: " + percentCorrect + "%")));
        if(percentCorrect == 100){
            resultpt1.setForeground(Color.GREEN);
            resultpt2.setForeground(Color.GREEN);
        }else{
            resultpt1.setForeground(new Color(255 -(int)(percentCorrect*2.5), 0+(int)(percentCorrect*2), 0));
            resultpt2.setForeground(new Color(255 -(int)(percentCorrect*2.5), 0+(int)(percentCorrect*2), 0));
        }
        pn.add(resultpt2);
        pn.add(resultpt1);
        open();
    }


}
