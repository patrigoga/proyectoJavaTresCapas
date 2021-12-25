/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author patri
 */
public class DetalleIngreso {
    private int id;
    private int ingresoId;
    private int depositoId;
    private String depositoCodigo;
    private String depositoNombre;
    private int cantidad;

    public DetalleIngreso() {
    }

    public DetalleIngreso(int id, int ingresoId, int depositoId, String depositoCodigo, String depositoNombre, int cantidad) {
        this.id = id;
        this.ingresoId = ingresoId;
        this.depositoId = depositoId;
        this.depositoCodigo = depositoCodigo;
        this.depositoNombre = depositoNombre;
        this.cantidad = cantidad;
    }

    public DetalleIngreso(int depositoId, String depositoCodigo, String depositoNombre, int cantidad) {
        this.depositoId = depositoId;
        this.depositoCodigo = depositoCodigo;
        this.depositoNombre = depositoNombre;
        this.cantidad = cantidad;
    }
    

    public DetalleIngreso(int depositoId, int cantidad) {
        this.depositoId = depositoId;
        this.cantidad = cantidad;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIngresoId() {
        return ingresoId;
    }

    public void setIngresoId(int ingresoId) {
        this.ingresoId = ingresoId;
    }

    public int getDepositoId() {
        return depositoId;
    }

    public void setDepositoId(int depositoId) {
        this.depositoId = depositoId;
    }

    public String getDepositoCodigo() {
        return depositoCodigo;
    }

    public void setDepositoCodigo(String depositoCodigo) {
        this.depositoCodigo = depositoCodigo;
    }

    public String getDepositoNombre() {
        return depositoNombre;
    }

    public void setDepositoNombre(String depositoNombre) {
        this.depositoNombre = depositoNombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
