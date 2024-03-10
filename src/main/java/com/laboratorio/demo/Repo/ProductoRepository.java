package com.laboratorio.demo.Repo;

import com.laboratorio.demo.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, String> {
    // Puedes agregar métodos personalizados según tus necesidades
}
