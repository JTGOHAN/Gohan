package com.GojanDev.solucionesGojanDev.services;
import com.GojanDev.solucionesGojanDev.entities.Movimiento;
import com.GojanDev.solucionesGojanDev.repository.MovientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MovimientoServices implements ServiceInterfaceMovimiento{
    //Atributo
    Date Hoy = new Date();

    //Inyección objeto del repository de la entidad Movimiento (Lo que está en Base de Datos
    @Autowired
    MovientoRepository movimientoRepository;

    @Override
    public List<Movimiento> getMovimientos() {
        return movimientoRepository.findAll();
    }

    @Override
    public Movimiento getMovimiento(Long idMovimiento) throws Exception {
        Optional<Movimiento> MovimientoBD = movimientoRepository.findById(idMovimiento);
        if (MovimientoBD.isPresent())
        {
            return MovimientoBD.get();
        }
        throw new Exception("Id: " + idMovimiento + " No asignado a ninguna Movimiento");
    }

    @Override
    public String getCrearMovimiento(Movimiento MovimientoAdd) {
        //Primero se valida que el Id no exista
        Optional<Movimiento> MovimientoBD = movimientoRepository.findById(MovimientoAdd.getIdMovimiento());
        if (!MovimientoBD.isPresent()){ //Negado para que si no está presente la cree
            movimientoRepository.save(MovimientoAdd);
            return ("Movimiento Creada Con Exito!");
        }
        return ("El Id ya existe No fue posible crear la Movimiento");
    }

    @Override
    public Movimiento getActualizarMovimiento(Movimiento MovimientoUpdate) throws Exception {
        //Llamamos el id de la Movimiento a actualizar
        Movimiento MovimientoBD = getMovimiento(MovimientoUpdate.getIdMovimiento());

        //Actualizamos atributo
        if (MovimientoUpdate.getConceptoMovimiento()!=null && !MovimientoUpdate.getCreatedAtMovimiento().equals("")){
            MovimientoBD.setConceptoMovimiento(MovimientoUpdate.getConceptoMovimiento());
        }

        String amountCast = String.valueOf(MovimientoUpdate.getMontoMovimiento());
        if (amountCast!=null && !amountCast.equals("")){
            MovimientoBD.setMontoMovimiento(MovimientoUpdate.getMontoMovimiento());
        }

        MovimientoBD.setUpdateAtMovimiento(Hoy);
        return movimientoRepository.save(MovimientoBD);
    }

    @Override
    public String getEliminarMovimiento(Long idMovimiento) throws Exception {
        Optional<Movimiento> MovimientoDB = movimientoRepository.findById(idMovimiento);
        if(MovimientoDB.isPresent()){
            movimientoRepository.deleteById(idMovimiento);
            return ("La Movimiento ha sido Eliminada!");
        }
        throw new Exception("El Id de la Movimiento no fue encontrado");
    }
}
