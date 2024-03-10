package com.laboratorio.demo.Service;

import com.laboratorio.demo.Model.DetalleVenta;
import com.laboratorio.demo.Repo.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DetalleVentaService {
    private final DetalleVentaRepository detalleVentaRepository;

    @Autowired
    public DetalleVentaService(DetalleVentaRepository detalleVentaRepository) {
        this.detalleVentaRepository = detalleVentaRepository;
    }

    public List<DetalleVenta> obtenerTodosLosDetallesVenta() {
        return detalleVentaRepository.findAll();
    }

    public DetalleVenta obtenerDetalleVentaPorId(Long id) {
        return detalleVentaRepository.findById(id).orElse(null);
    }

    public DetalleVenta guardarDetalleVenta(DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    public void eliminarDetalleVentaPorId(Long id) {
        detalleVentaRepository.deleteById(id);
    }

    // Puedes agregar más métodos según tus necesidades
}
