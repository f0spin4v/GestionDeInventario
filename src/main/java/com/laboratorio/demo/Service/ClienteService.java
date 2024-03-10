package com.laboratorio.demo.Service;

import com.laboratorio.demo.Model.Cliente;
import java.util.List;

public interface ClienteService {
    List<Cliente> obtenerTodosLosClientes();
    Cliente obtenerClientePorId(Long id);
    void guardarCliente(Cliente cliente);
}
