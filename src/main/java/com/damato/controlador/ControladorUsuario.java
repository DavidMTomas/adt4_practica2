package com.damato.controlador;

import com.damato.modelo.Usuario;
import com.damato.modelo.UsuarioDAO;
import com.damato.vista.JFEntrada;
import com.damato.vista.JFListado;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorUsuario implements ActionListener {

    private UsuarioDAO modelo;
    private JFListado vistaListado;
    private JFEntrada vistaEntrada;

    public ControladorUsuario(UsuarioDAO modelo, JFEntrada entrada, JFListado listado) {
        this.modelo = modelo;
        this.vistaEntrada = entrada;
        this.vistaListado = listado;

        vistaEntrada.bEntrar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vistaEntrada.bEntrar) {
            String usuario = vistaEntrada.tUsuario.getText();
            String password = vistaEntrada.tPassword.getText();
            Usuario logeado = modelo.login(usuario, password);

            if(logeado == null) {
                JOptionPane.showMessageDialog(null,"El usuario no existe");
            }else {
                JOptionPane.showMessageDialog(null,"Usuario Logeado correctamente");
                vistaListado.setLocationRelativeTo(null);
                vistaListado.setVisible(true);
                mostrarTabla();
                mostrarListado();
            }
        }
    }

    private void mostrarListado() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios=modelo.getAll();
        vistaListado.jtListado.setText(usuarios.toString());
    }

    private void mostrarTabla() {
        DefaultTableModel modeloT = new DefaultTableModel();
        vistaListado.jTabla.setModel(modeloT);

        modeloT.addColumn("ID");
        modeloT.addColumn("USUARIO");
        modeloT.addColumn("PASSWORD");

        Object[] columna =new Object[modeloT.getColumnCount()];

        ArrayList<Usuario> usuarios = modelo.getAll();

        int numRegistros = usuarios.size();

        for (int i = 0; i < numRegistros; i++) {
            columna[0] = usuarios.get(i).getId();
            columna[1] = usuarios.get(i).getUsuario();
            columna[2] = usuarios.get(i).getPassword();
            modeloT.addRow(columna);
        }

    }
}
