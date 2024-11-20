package com.damato.vista;

import javax.swing.*;

public class JFListado extends JFrame {
    public JPanel jPrincipal;
    public JTable jTabla;
    public JTextPane jtListado;


    public JFListado() {
        setContentPane(jPrincipal);
        setTitle("Titulo");
        pack();
        // setsize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
