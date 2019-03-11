package com.syeedode.hardcorejava.a_06_1_inner_classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InnerClassDemo extends JDialog {

    private int beepCount = 1;
    private final Container contentPane;
    private final String LOGO = "This is my logo";

    public InnerClassDemo(final int beepCount) {
        super();
        setTitle("Anonymous Demo");
        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JLabel logoLabel = new JLabel(LOGO);
        contentPane.add(BorderLayout.NORTH, logoLabel);
        JButton btn = new BeepButton("Beep");
        contentPane.add(BorderLayout.SOUTH, btn);
        pack();
        this.beepCount = beepCount;
    }

    private class BeepButton extends JButton implements ActionListener {

        public BeepButton(final String text) {
            super(text);
            addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                for(int count = 0; count < beepCount; count++) {
                    Toolkit.getDefaultToolkit().beep();
                    Thread.sleep(100);
                }
            } catch (final InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
