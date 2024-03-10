package com.laboratorio.demo.Repo;

import com.laboratorio.demo.Model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
    // Puedes agregar métodos personalizados según tus necesidades
}
