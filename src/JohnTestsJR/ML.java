package JohnTestsJR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ML extends MouseAdapter {
    private JLabel previous;

    @Override
    public void mouseClicked(MouseEvent e) {
        Component source = e.getComponent();
        if (!(source instanceof JLabel)) {
            return;
        }
        JLabel label = (JLabel) source;
        if (previous != null) {
            previous.setBackground(null);
            previous.setForeground(null);
            previous.setOpaque(false);
        }
        previous = label;
        label.setForeground(Color.WHITE);
        label.setBackground(Color.BLUE);
        label.setOpaque(true);
    }

}

