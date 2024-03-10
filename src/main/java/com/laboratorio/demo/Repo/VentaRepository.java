package com.laboratorio.demo.Repo;

import com.laboratorio.demo.Model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
    // Puedes agregar métodos personalizados según tus necesidades
}

