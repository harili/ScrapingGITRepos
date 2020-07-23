package com.ilies.forms;

import javax.swing.*;
import com.ilies.principal.ScraperGIT;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FExecuter {
    private JButton btnExecuter;
    private JPanel FExecuter;
    private ScraperGIT unExec = new ScraperGIT(); //Création de l'objet qui va exécuter le script



    public FExecuter() {
        btnExecuter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                unExec.executerScript(); //appel de la méthode dans la classe ScraperGIT grâce à l'objet unExec
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FExecuter");
        frame.setContentPane(new FExecuter().FExecuter);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
