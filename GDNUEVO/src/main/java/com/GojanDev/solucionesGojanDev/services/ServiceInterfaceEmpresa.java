package com.GojanDev.solucionesGojanDev.services;

import com.GojanDev.solucionesGojanDev.entities.Empresa;
import java.util.List;

public interface ServiceInterfaceEmpresa {

    //Metodo: Ver lista de empresa
    public List<Empresa> getEmpresas();

    //Metodo: Ver empresa
    public Empresa getEmpresa(Long idEmpresa) throws Exception; //se crea la excepción por si el id no existe. Para que no se reviente la aplicación

    //Metodo: Crear empresa
    public String getCrearEmpresa(Empresa empresaAdd);

    //Metodo: Actualizar datos empresa
    public Empresa getActualizarEmpresa(Empresa empresaUpdate) throws Exception;

    //Metodo: Eliminar Empresa
    public String getEliminarEmpresa(Long idEmpresa) throws Exception;
}
