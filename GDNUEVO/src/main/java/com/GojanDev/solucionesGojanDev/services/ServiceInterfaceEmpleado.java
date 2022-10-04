package com.GojanDev.solucionesGojanDev.services;

import com.GojanDev.solucionesGojanDev.entities.Empleado;
import java.util.List;

public interface ServiceInterfaceEmpleado {

    //Metodo: Ver lista de Empleado
    public List<Empleado> getEmpleados();

    //Metodo: Ver Empleado
    public Empleado getEmpleado(Long idEmpleado) throws Exception; //se crea la excepción por si el id no existe. Para que no se reviente la aplicación

    //Metodo: Crear Empleado
    public String getCrearEmpleado(Empleado empleadoAdd);

    //Metodo: Actualizar datos Empleado
    public Empleado getActualizarEmpleado(Empleado empleadoUpdate) throws Exception;

    //Metodo: Eliminar Empleado
    public String getEliminarEmpleado(Long idEmpleado) throws Exception;
}
