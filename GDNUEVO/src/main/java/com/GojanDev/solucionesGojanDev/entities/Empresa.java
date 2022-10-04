package com.GojanDev.solucionesGojanDev.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true,nullable = false)
    @Getter private long idEmpresa;
    @Column(name = "Nombre_Empresa",unique = true)
    @Getter @Setter private String nombreEmpresa;
    @Column(name = "NIT_Empresa",unique = true)
    @Getter @Setter private String documentoEmpresa;
    @Column(name = "Telefono_Empresa")
    @Getter @Setter private String telefonoEmpresa;
    @Column(name = "Direccion_Empresa")
    @Getter @Setter private String direccionEmpresa;


    @Column(name = "Empleados_Empresa")
    @ManyToOne
    @Getter @Setter
    List<Empleado> empleadosEmpresa;
    @Column(name = "Movimiento_Empresa")
    @ManyToOne
    @Getter @Setter List<Movimiento> movimientosEmpresa;


    @Column(name = "updateAT_Empresa")
    @Getter @Setter private Date updateAtEmpresa;
    @Column(name = "createdAT_Empresa")
    @Getter @Setter private Date createdAtEmpresa;

    public Empresa(){}

    public Empresa(String nombreEmpresa, String documentoEmpresa, String telefonoEmpresa, String direccionEmpresa, Date updateAtEmpresa, Date createdAtEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.documentoEmpresa = documentoEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.updateAtEmpresa = updateAtEmpresa;
        this.createdAtEmpresa = createdAtEmpresa;
    }

}
