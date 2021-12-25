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
public class DetalleVenta {
    
    private int id;
    private int ventaId;
    private int depositoId;
    private String depositoCodigo;
    private String depositoNombre;
    private int depositoStock;
    private int cantidad;

    public DetalleVenta() {
    }

    public DetalleVenta(int id, int ventaId, int depositoId, String depositoCodigo, String depositoNombre, int depositoStock, int cantidad) {
        this.id = id;
        this.ventaId = ventaId;
        this.depositoId = depositoId;
        this.depositoCodigo = depositoCodigo;
        this.depositoNombre = depositoNombre;
        this.depositoStock = depositoStock;
        this.cantidad = cantidad;
    }

    public DetalleVenta(int depositoId, String depositoCodigo, String depositoNombre, int depositoStock, int cantidad) {
        this.depositoId = depositoId;
        this.depositoCodigo = depositoCodigo;
        this.depositoNombre = depositoNombre;
        this.depositoStock = depositoStock;
        this.cantidad = cantidad;
    }

    public DetalleVenta(int depositoId, int cantidad) {
        this.depositoId = depositoId;
        this.cantidad = cantidad;
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVentaId() {
        return ventaId;
    }

    public void setVentaId(int ventaId) {
        this.ventaId = ventaId;
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

    public int getDepositoStock() {
        return depositoStock;
    }

    public void setDepositoStock(int depositoStock) {
        this.depositoStock = depositoStock;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
    
            
           
}
