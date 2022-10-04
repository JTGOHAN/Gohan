package com.GojanDev.solucionesGojanDev.repository;

import com.GojanDev.solucionesGojanDev.entities.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovientoRepository extends JpaRepository<Movimiento, Long> {
}
