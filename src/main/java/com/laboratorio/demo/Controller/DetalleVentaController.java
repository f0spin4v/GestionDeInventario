package com.laboratorio.demo.Controller;

import com.laboratorio.demo.Model.DetalleVenta;
import com.laboratorio.demo.Service.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/detallesventa")
public class DetalleVentaController {
    private final DetalleVentaService detalleVentaService;

    @Autowired
    public DetalleVentaController(DetalleVentaService detalleVentaService) {
        this.detalleVentaService = detalleVentaService;
    }

    @GetMapping
    public List<DetalleVenta> obtenerTodosLosDetallesVenta() {
        return detalleVentaService.obtenerTodosLosDetallesVenta();
    }

    @GetMapping("/{id}")
    public DetalleVenta obtenerDetalleVentaPorId(@PathVariable Long id) {
        return detalleVentaService.obtenerDetalleVentaPorId(id);
    }

    @PostMapping
    public DetalleVenta guardarDetalleVenta(@RequestBody DetalleVenta detalleVenta) {
        return detalleVentaService.guardarDetalleVenta(detalleVenta);
    }

    @DeleteMapping("/{id}")
    public void eliminarDetalleVentaPorId(@PathVariable Long id) {
        detalleVentaService.eliminarDetalleVentaPorId(id);
    }

    // Puedes agregar más métodos según tus necesidades
}
