package com.damato.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO implements InterfaceDAO<Usuario> {

    private Connection con;

    public UsuarioDAO() {
        con = GestionBD.getConexion();
    }

    @Override
    public Usuario login(String nombre, String password) {
        Usuario usuario = null;

        String sql = "select * from usuario where usuario=? and password=?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, nombre);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return usuario;
    }

    @Override
    public ArrayList<Usuario> getAll() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql = "select * from usuario";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            ResultSet registros = pst.executeQuery();

            while (registros.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(registros.getInt("id"));
                usuario.setUsuario(registros.getString("usuario"));
                usuario.setPassword(registros.getString("password"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuarios;
    }
}
