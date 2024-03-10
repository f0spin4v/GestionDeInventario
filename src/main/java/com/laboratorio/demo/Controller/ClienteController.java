package com.laboratorio.demo.Controller;

import com.laboratorio.demo.Model.Cliente;
import com.laboratorio.demo.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/registro")
    public String mostrarFormularioRegistro() {
        return "cliente-form";
    }

    @PostMapping("/registrar")
    public String registrarCliente(@RequestParam String nombre, @RequestParam String direccion) {
        Cliente cliente = new Cliente(nombre, direccion);
        clienteService.guardarCliente(cliente);
        return "redirect:/clientes/registro";
    }
}