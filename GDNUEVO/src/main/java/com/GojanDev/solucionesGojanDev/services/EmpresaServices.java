package com.GojanDev.solucionesGojanDev.services;

import com.GojanDev.solucionesGojanDev.entities.Empresa;
import com.GojanDev.solucionesGojanDev.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServices implements ServiceInterfaceEmpresa {

    //Atributo
    Date Hoy = new Date();

    //Inyección objeto del repository de la entidad Empresa (Lo que está en Base de Datos
    @Autowired
    EmpresaRepository empresaRepository;

    @Override
    public List<Empresa> getEmpresas() {
        return empresaRepository.findAll();
    }

    @Override
    public Empresa getEmpresa(Long idEmpresa) throws Exception {
        Optional<Empresa> EmpresaBD = empresaRepository.findById(idEmpresa);
        if (EmpresaBD.isPresent())
        {
            return EmpresaBD.get();
        }
        throw new Exception("Id: " + idEmpresa + " No asignado a ninguna empresa");
    }

    @Override
    public String getCrearEmpresa(Empresa empresaAdd) {
        //Primero se valida que el Id no exista
        Optional<Empresa> EmpresaBD = empresaRepository.findById(empresaAdd.getIdEmpresa());
        if (!EmpresaBD.isPresent()){ //Negado para que si no está presente la cree
            empresaRepository.save(empresaAdd);
            return ("Empresa Creada Con Exito!");
        }
        return ("El Id ya existe No fue posible crear la Empresa");
    }

    @Override
    public Empresa getActualizarEmpresa(Empresa empresaUpdate) throws Exception {
        //Llamamos el id de la empresa a actualizar
        Empresa empresaBD = getEmpresa(empresaUpdate.getIdEmpresa());

        //Actualizamos atributos (siempre se valida que no sea nulo ni esté vacio.
        if(empresaUpdate.getNombreEmpresa() != null && !empresaUpdate.getNombreEmpresa().equals("")){
            empresaBD.setNombreEmpresa(empresaUpdate.getNombreEmpresa());
        }

        if(empresaUpdate.getDocumentoEmpresa() != null && !empresaUpdate.getDocumentoEmpresa().equals("")){
            empresaBD.setDocumentoEmpresa(empresaUpdate.getDocumentoEmpresa());
        }

        if(empresaUpdate.getTelefonoEmpresa() != null && !empresaUpdate.getTelefonoEmpresa().equals("")){
            empresaBD.setTelefonoEmpresa(empresaUpdate.getTelefonoEmpresa());
        }

        if(empresaUpdate.getDireccionEmpresa() != null && !empresaUpdate.getDireccionEmpresa().equals("")){
            empresaBD.setDireccionEmpresa(empresaUpdate.getDireccionEmpresa());
        }

        empresaBD.setUpdateAtEmpresa(Hoy);
        return empresaRepository.save(empresaBD);
    }

    @Override
    public String getEliminarEmpresa(Long idEmpresa) throws Exception {
        Optional<Empresa> empresaDB = empresaRepository.findById(idEmpresa);
        if(empresaDB.isPresent()){
            empresaRepository.deleteById(idEmpresa);
            return ("La Empresa ha sido Eliminada!");
        }
        throw new Exception("El Id de la Empresa no fue encontrado");
    }
}
