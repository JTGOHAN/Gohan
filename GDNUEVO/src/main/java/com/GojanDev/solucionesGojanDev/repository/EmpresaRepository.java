package com.GojanDev.solucionesGojanDev.repository;

import com.GojanDev.solucionesGojanDev.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
 }
