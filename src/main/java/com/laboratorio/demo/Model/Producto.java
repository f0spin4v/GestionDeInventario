package com.laboratorio.demo.Model;
//import javax.persistence.Entity;
//import javax.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Producto {
    @Id
    private String codigo;
    private String nombre;
    private double precio;
    private int cantidadInventario;

    public Producto() {}

    public Producto(String codigo, String nombre, double precio, int cantidadInventario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadInventario = cantidadInventario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadInventario() {
        return cantidadInventario;
    }

    public void setCantidadInventario(int cantidadInventario) {
        this.cantidadInventario = cantidadInventario;
    }
}

