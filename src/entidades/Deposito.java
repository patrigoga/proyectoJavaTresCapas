/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Objects;

/**
 *
 * @author patri
 */
public class Deposito {

    private int id;
    private int referenciaId;
    private String referenciaNombre;
    private String codigo;
    private String nombre;
    private int stock;
    private int cantidad;
    private boolean activo;

    public Deposito() {
    }

    public Deposito(int id, int referenciaId, String referenciaNombre, String codigo, String nombre, int stock, int cantidad, boolean activo) {
        this.id = id;
        this.referenciaId = referenciaId;
        this.referenciaNombre = referenciaNombre;
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
        this.cantidad = cantidad;
        this.activo = activo;
    }

    public Deposito(int id, int referenciaId, String referenciaNombre, String codigo, String nombre, int stock, boolean activo) {
        this.id = id;
        this.referenciaId = referenciaId;
        this.referenciaNombre = referenciaNombre;
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
        this.activo = activo;
    }

    public Deposito(int id, String codigo, String nombre, int stock) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
    }
    
    

    public Deposito(int referenciaId, String referenciaNombre) {
        this.referenciaId = referenciaId;
        this.referenciaNombre = referenciaNombre;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReferenciaId() {
        return referenciaId;
    }

    public void setReferenciaId(int referenciaId) {
        this.referenciaId = referenciaId;
    }

    public String getReferenciaNombre() {
        return referenciaNombre;
    }

    public void setReferenciaNombre(String referenciaNombre) {
        this.referenciaNombre = referenciaNombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.id;
        hash = 19 * hash + this.referenciaId;
        hash = 19 * hash + Objects.hashCode(this.referenciaNombre);
        hash = 19 * hash + Objects.hashCode(this.codigo);
        hash = 19 * hash + Objects.hashCode(this.nombre);
        hash = 19 * hash + this.stock;
        hash = 19 * hash + this.cantidad;
        hash = 19 * hash + (this.activo ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Deposito other = (Deposito) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.referenciaId != other.referenciaId) {
            return false;
        }
        if (this.stock != other.stock) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (this.activo != other.activo) {
            return false;
        }
        if (!Objects.equals(this.referenciaNombre, other.referenciaNombre)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Deposito{" + "id=" + id + ", referenciaId=" + referenciaId + ", referenciaNombre=" + referenciaNombre + ", codigo=" + codigo + ", nombre=" + nombre + ", stock=" + stock + ", cantidad=" + cantidad + ", activo=" + activo + '}';
    }

}
