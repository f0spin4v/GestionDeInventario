package com.laboratorio.demo.Service;

import com.laboratorio.demo.Model.Producto;
import com.laboratorio.demo.Repo.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    public Producto obtenerProductoPorCodigo(String codigo) {
        return productoRepository.findById(codigo).orElse(null);
    }

    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void eliminarProductoPorCodigo(String codigo) {
        productoRepository.deleteById(codigo);
    }

    // Puedes agregar más métodos según tus necesidades
}
