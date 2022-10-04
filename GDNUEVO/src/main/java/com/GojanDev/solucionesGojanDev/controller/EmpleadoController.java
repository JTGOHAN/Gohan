package com.GojanDev.solucionesGojanDev.controller;

import com.GojanDev.solucionesGojanDev.entities.Empleado;
import com.GojanDev.solucionesGojanDev.entities.ObjectsRespuesta;
import com.GojanDev.solucionesGojanDev.services.ServiceInterfaceEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmpleadoController {

    //Hacemos la inyeccion de un objeto de tipo ServiceInterfaceEmpleado
    @Autowired
    ServiceInterfaceEmpleado serviceInterfaceEmpleado;

    //Creamos los Mapping para Listar Empleados
    @GetMapping("/Empleado/listaEmpleados")
    public ResponseEntity<List<Empleado>> getEmpleados(){
        return new ResponseEntity<>(serviceInterfaceEmpleado.getEmpleados(), HttpStatus.ACCEPTED);
    }

    //Creamos los Mapping para Listar Una Empleado
    @GetMapping("/Empleado/Empleado{idEmpleado}")
    public ResponseEntity<Object> getEmpleado(@PathVariable Long idEmpleado){
        try {
            Empleado Empleadox = serviceInterfaceEmpleado.getEmpleado(idEmpleado);
            return new ResponseEntity<>(Empleadox, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Creamos los Mapping para Crear Una Empleado
    @PostMapping("/Empleado/crearEmpleado")
    public ResponseEntity<String> postCrearEmpleado(@RequestBody Empleado EmpleadoX){
        try{
            String message = serviceInterfaceEmpleado.getCrearEmpleado(EmpleadoX);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Creamos los Mapping para Actualizar Una Empleado
    @PutMapping("/Empleado/actualizarEmpleado")
    public ResponseEntity<ObjectsRespuesta> putActualizarEmpleado(@RequestBody Empleado EmpleadoX){
        try{
            Empleado EmpleadoBD = serviceInterfaceEmpleado.getActualizarEmpleado(EmpleadoX);
            return new ResponseEntity<> (new ObjectsRespuesta("Actualizacion exitosa", EmpleadoBD), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ObjectsRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Creamos los Mapping para Eliminar Una Empleado
    @DeleteMapping("/Empleado/eliminarEmpleado")
    public ResponseEntity<String> EliminarEmpleado(@PathVariable long idEmpleado){
        try{
            String mensaje = serviceInterfaceEmpleado.getEliminarEmpleado(idEmpleado);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
