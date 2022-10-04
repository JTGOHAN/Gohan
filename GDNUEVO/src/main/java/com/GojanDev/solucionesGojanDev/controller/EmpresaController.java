package com.GojanDev.solucionesGojanDev.controller;

import com.GojanDev.solucionesGojanDev.entities.Empresa;
import com.GojanDev.solucionesGojanDev.entities.ObjectsRespuesta;
import com.GojanDev.solucionesGojanDev.services.ServiceInterfaceEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmpresaController {

    //Hacemos la inyeccion de un objeto de tipo ServiceInterfaceEmpresa
    @Autowired
    ServiceInterfaceEmpresa serviceInterfaceEmpresa;

    //Creamos los Mapping para Listar Empresas
    @GetMapping("/empresa/listaempresas")
    public ResponseEntity <List<Empresa>> getEmpresas(){
        return new ResponseEntity<>(serviceInterfaceEmpresa.getEmpresas(), HttpStatus.ACCEPTED);
    }

    //Creamos los Mapping para Listar Una Empresa
    @GetMapping("/empresa/empresa{idEmpresa}")
    public ResponseEntity<Object> getEmpresa(@PathVariable Long idEmpresa){
        try {
            Empresa Empresax = serviceInterfaceEmpresa.getEmpresa(idEmpresa);
            return new ResponseEntity<>(Empresax, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Creamos los Mapping para Crear Una Empresa
    @PostMapping("/empresa/crearempresa")
    public ResponseEntity<String> postCrearEmpresa(@RequestBody Empresa EmpresaX){
        try{
            String message = serviceInterfaceEmpresa.getCrearEmpresa(EmpresaX);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Creamos los Mapping para Actualizar Una Empresa
    @PutMapping("/empresa/actualizarempresa")
    public ResponseEntity<ObjectsRespuesta> putActualizarEmpresa(@RequestBody Empresa EmpresaX){
        try{
            Empresa EmpresaBD = serviceInterfaceEmpresa.getActualizarEmpresa(EmpresaX);
            return new ResponseEntity<> (new ObjectsRespuesta("Actualizacion exitosa", EmpresaBD), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ObjectsRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Creamos los Mapping para Eliminar Una Empresa
    @DeleteMapping("/empresa/eliminarempresa")
    public ResponseEntity<String> EliminarEmpresa(@PathVariable long idEmpresa){
        try{
            String mensaje = serviceInterfaceEmpresa.getEliminarEmpresa(idEmpresa);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
