package com.GojanDev.solucionesGojanDev.services;

import com.GojanDev.solucionesGojanDev.entities.Empleado;
import com.GojanDev.solucionesGojanDev.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServices implements ServiceInterfaceEmpleado {

    //Atributo
    Date Hoy = new Date();

    //Inyección objeto del repository de la entidad Empleado (Lo que está en Base de Datos
    @Autowired
    EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> getEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado getEmpleado(Long idEmpleado) throws Exception {
        Optional<Empleado> EmpleadoBD = empleadoRepository.findById(idEmpleado);
        if (EmpleadoBD.isPresent())
        {
            return EmpleadoBD.get();
        }
        throw new Exception("Id: " + idEmpleado + " No asignado a un Empleado");
    }

    @Override
    public String getCrearEmpleado(Empleado empleadoAdd) {
        //Primero se valida que el Id no exista
        Optional<Empleado> EmpleadoBD = empleadoRepository.findById(empleadoAdd.getIdEmpleado());
        if (!EmpleadoBD.isPresent()){ //Negado para que si no está presente la cree
            empleadoRepository.save(empleadoAdd);
            return ("Empleado Creado Con Exito!");
        }
        return ("El Id ya existe No fue posible crear el Empleado");
    }

    @Override
    public Empleado getActualizarEmpleado(Empleado empleadoUpdate) throws Exception {
        //Llamamos el id de la empresa a actualizar
        Empleado EmpleadoBD = getEmpleado(empleadoUpdate.getIdEmpleado());

        //Actualizamos atributos (siempre se valida que no sea nulo ni esté vacio.
        if(empleadoUpdate.getNombreEmpleado() != null && !empleadoUpdate.getNombreEmpleado().equals("")){
            EmpleadoBD.setNombreEmpleado(empleadoUpdate.getNombreEmpleado());
        }

        if(empleadoUpdate.getCelularEmpleado() != null && !empleadoUpdate.getCelularEmpleado().equals("")){
            EmpleadoBD.setCelularEmpleado(empleadoUpdate.getCelularEmpleado());
        }

        if(empleadoUpdate.getEmailEmpleado() != null && !empleadoUpdate.getEmailEmpleado().equals("")){
            EmpleadoBD.setCelularEmpleado(empleadoUpdate.getEmailEmpleado());
        }

        if(empleadoUpdate.getRolEmpleado() != null && !empleadoUpdate.getRolEmpleado().equals("")){
            EmpleadoBD.setRolEmpleado(empleadoUpdate.getRolEmpleado());
        }

        EmpleadoBD.setUpdateAtEmpleado(Hoy);
        return empleadoRepository.save(EmpleadoBD);
    }

    @Override
    public String getEliminarEmpleado(Long idEmpleado) throws Exception {
        Optional<Empleado> EmpleadoDB = empleadoRepository.findById(idEmpleado);
        if(EmpleadoDB.isPresent()){
            empleadoRepository.deleteById(idEmpleado);
            return ("El Empleado ha sido Eliminado!");
        }
        throw new Exception("El Id del Empleado no fue encontrado");
    }

}
