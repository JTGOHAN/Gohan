package com.GojanDev.solucionesGojanDev.services;

import com.GojanDev.solucionesGojanDev.entities.Movimiento;

import java.util.List;

public interface ServiceInterfaceMovimiento {
    //Metodo: Ver lista de Movimiento
    public List<Movimiento> getMovimientos();

    //Metodo: Ver Movimiento
    public Movimiento getMovimiento(Long idMovimiento) throws Exception; //se crea la excepción por si el id no existe. Para que no se reviente la aplicación

    //Metodo: Crear Movimiento
    public String getCrearMovimiento(Movimiento MovimientoAdd);

    //Metodo: Actualizar datos Movimiento
    public Movimiento getActualizarMovimiento(Movimiento MovimientoUpdate) throws Exception;

    //Metodo: Eliminar Movimiento
    public String getEliminarMovimiento(Long idMovimiento) throws Exception;
}
