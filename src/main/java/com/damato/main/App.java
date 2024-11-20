package com.damato.main;

import com.damato.controlador.ControladorUsuario;
import com.damato.modelo.UsuarioDAO;
import com.damato.vista.JFEntrada;
import com.damato.vista.JFListado;

public class App {
    public static void main(String[] args) {

        UsuarioDAO modelo = new UsuarioDAO();
        JFEntrada vistaEntrada = new JFEntrada();
        JFListado vistaListado = new JFListado();

        ControladorUsuario controladorUsuario = new ControladorUsuario(modelo, vistaEntrada, vistaListado);


    }
}