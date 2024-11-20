package com.damato.vista;

import javax.swing.*;

public class JFEntrada extends JFrame {
    public JPanel jPrincipal;
    public JTextField tUsuario;
    public JTextField tPassword;
    public JButton bEntrar;




    public JFEntrada() {
        setContentPane(jPrincipal);
        setTitle("Titulo");
        pack();
        // setsize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
