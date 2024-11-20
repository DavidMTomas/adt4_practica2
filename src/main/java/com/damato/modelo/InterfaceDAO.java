package com.damato.modelo;

import java.util.ArrayList;

public interface InterfaceDAO<T> {

    public Usuario login(String usuario, String password);
    public ArrayList<T> getAll();
}
