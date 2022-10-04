package com.GojanDev.solucionesGojanDev.controller;

import com.GojanDev.solucionesGojanDev.entities.Movimiento;
import com.GojanDev.solucionesGojanDev.entities.Movimiento;
import com.GojanDev.solucionesGojanDev.entities.ObjectsRespuesta;
import com.GojanDev.solucionesGojanDev.services.MovimientoServices;
import com.GojanDev.solucionesGojanDev.services.ServiceInterfaceMovimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class MovimientoController {
    //Hacemos la inyeccion de un objeto de tipo ServiceInterfaceMovimiento
    @Autowired
    ServiceInterfaceMovimiento serviceInterfaceMovimiento;

    //Creamos los Mapping para Listar Movimientos
    @GetMapping("/Movimiento/listaMovimientos")
    public ResponseEntity<List<Movimiento>> getMovimientos(){
        return new ResponseEntity<>(serviceInterfaceMovimiento.getMovimientos(), HttpStatus.ACCEPTED);
    }

    //Creamos los Mapping para Listar Una Movimiento
    @GetMapping("/Movimiento/Movimiento{idMovimiento}")
    public ResponseEntity<Object> getMovimiento(@PathVariable Long idMovimiento){
        try {
            Movimiento Movimientox = serviceInterfaceMovimiento.getMovimiento(idMovimiento);
            return new ResponseEntity<>(Movimientox, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Creamos los Mapping para Crear Una Movimiento
    @PostMapping("/Movimiento/crearMovimiento")
    public ResponseEntity<String> postCrearMovimiento(@RequestBody Movimiento MovimientoX){
        try{
            String message = serviceInterfaceMovimiento.getCrearMovimiento(MovimientoX);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Creamos los Mapping para Actualizar Una Movimiento
    @PutMapping("/Movimiento/actualizarMovimiento")
    public ResponseEntity<ObjectsRespuesta> putActualizarMovimiento(@RequestBody Movimiento MovimientoX){
        try{
            Movimiento MovimientoBD = serviceInterfaceMovimiento.getActualizarMovimiento(MovimientoX);
            return new ResponseEntity<> (new ObjectsRespuesta("Actualizacion exitosa", MovimientoBD), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ObjectsRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Creamos los Mapping para Eliminar Una Movimiento
    @DeleteMapping("/Movimiento/eliminarMovimiento")
    public ResponseEntity<String> EliminarMovimiento(@PathVariable long idMovimiento){
        try{
            String mensaje = serviceInterfaceMovimiento.getEliminarMovimiento(idMovimiento);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
