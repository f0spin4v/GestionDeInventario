package com.laboratorio.demo.Controller;

import com.laboratorio.demo.Model.Cliente;
import com.laboratorio.demo.Model.DetalleVenta;
import com.laboratorio.demo.Model.Producto;
import com.laboratorio.demo.Model.Venta;
import com.laboratorio.demo.Service.ClienteService;
import com.laboratorio.demo.Service.ProductoService;
import com.laboratorio.demo.Service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/ventas")
public class VentaController {
    private final VentaService ventaService;
    private final ClienteService clienteService;
    private final ProductoService productoService;

    @Autowired
    public VentaController(VentaService ventaService, ClienteService clienteService, ProductoService productoService) {
        this.ventaService = ventaService;
        this.clienteService = clienteService;
        this.productoService = productoService;
    }

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        List<Cliente> clientes = clienteService.obtenerTodosLosClientes();
        List<Producto> productos = productoService.obtenerTodosLosProductos();
        model.addAttribute("clientes", clientes);
        model.addAttribute("productos", productos);
        return "venta-form";
    }

    @PostMapping("/registrar")
    public String registrarVenta(@RequestParam Long idCliente, @RequestParam String codigoProducto, @RequestParam int cantidad) {
        Cliente cliente = clienteService.obtenerClientePorId(idCliente);
        Producto producto = productoService.obtenerProductoPorCodigo(codigoProducto);
        if (cliente != null && producto != null) {
            Venta venta = new Venta(cliente);
            DetalleVenta detalleVenta = new DetalleVenta(producto, cantidad);
            venta.agregarDetalleVenta(detalleVenta);
            ventaService.guardarVenta(venta);
        }
        return "redirect:/ventas/registro";
    }
}
