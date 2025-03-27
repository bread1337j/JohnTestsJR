package JohnTestsJR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ML extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
        Component source = e.getComponent();
        if (!(source instanceof JLabel)) {
            return;
        }
        JLTest label = (JLTest) source;
        label.toggleShort();
        //label.setText(label.test.str);

    }

}

