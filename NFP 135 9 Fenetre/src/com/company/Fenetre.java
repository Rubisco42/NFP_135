package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame {

    public Fenetre() throws HeadlessException {
        this.setSize(500,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panneau=new JPanel();
        this.setContentPane(panneau);

        JButton bouton =new JButton("Click me");
        panneau.add(bouton);
        bouton.addActionListener(new ClickBouton());

        this.setVisible(true);

    }
    public class ClickBouton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("tu m'as clické !");

        }
    }
}
