package com.GojanDev.solucionesGojanDev.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter private long idEmpleado;
    @Column(name = "Nombre_Empleado",unique = true)
    @Getter @Setter private String nombreEmpleado;
    @Column(name = "Celular_Empleado",unique = true)
    @Getter @Setter private String celularEmpleado;
    @Column(name = "email_Empleado",unique = true)
    @Getter @Setter private String emailEmpleado;


    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Rol.class, fetch = FetchType.EAGER)
    private List<Rol> rolEmpleado;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Empresa empresaEmpleado;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany
    private List<Movimiento> movimientoEmpleado;
    @Column(name = "updateAT_Empleado")
    @Getter @Setter private Date updateAtEmpleado;
    @Column(name = "createdAT_Empleado")
    @Getter @Setter private Date createdAtEmpleado;

    public Empleado(){}

    public Empleado(long idEmpleado, String nombreEmpleado, String celularEmpleado, String emailEmpleado, Date updateAtEmpleado, Date createdAtEmpleado) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.celularEmpleado = celularEmpleado;
        this.emailEmpleado = emailEmpleado;
        this.updateAtEmpleado = updateAtEmpleado;
        this.createdAtEmpleado = createdAtEmpleado;
    }
}
