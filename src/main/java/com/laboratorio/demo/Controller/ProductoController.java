package com.laboratorio.demo.Controller;

import com.laboratorio.demo.Model.Producto;
import com.laboratorio.demo.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Controller
@RequestMapping("/productos")
public class ProductoController {
    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/cargar")
    public String mostrarFormularioCargar() {
        return "producto-upload-form";
    }

    @PostMapping("/cargar")
    public String cargarProductos(@RequestParam("file") MultipartFile file, Model model) {
        if (file.isEmpty()) {
            model.addAttribute("mensaje", "Por favor seleccione un archivo");
        } else {
            try {
                productoService.cargarProductosDesdeArchivo(file);
                model.addAttribute("mensaje", "Productos cargados exitosamente");
            } catch (IOException e) {
                model.addAttribute("mensaje", "Error al cargar productos desde el archivo");
                e.printStackTrace();
            }
        }
        return "producto-upload-form";
    }
}
