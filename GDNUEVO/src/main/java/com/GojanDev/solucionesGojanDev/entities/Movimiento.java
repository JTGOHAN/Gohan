package com.GojanDev.solucionesGojanDev.entities;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "movimiento")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    @Getter private long idMovimiento;
    @Column(name = "concepto")
    @Getter @Setter private String conceptoMovimiento;
    @Column(name = "monto")
    @Getter @Setter private float montoMovimiento;
    @Column(name = "empleado")
    @OneToMany
    @Getter @Setter private Empleado empleadoMovimiento;
    @Column(name = "empresa")
    @OneToMany
    @Getter @Setter private Empresa empresaMovimiento;
    @Column(name = "updateAT")
    @Getter @Setter private Date updateAtMovimiento;
    @Column(name = "createdAT")
    @Getter @Setter private Date createdAtMovimiento;

    public Movimiento(){}

    public Movimiento(long idMovimiento, String conceptoMovimiento, float montoMovimiento, Date updateAt, Date createdAt) {
        this.idMovimiento = idMovimiento;
        this.conceptoMovimiento = conceptoMovimiento;
        this.montoMovimiento = montoMovimiento;
        this.updateAtMovimiento = updateAtMovimiento;
        this.createdAtMovimiento = createdAtMovimiento;
    }
}
