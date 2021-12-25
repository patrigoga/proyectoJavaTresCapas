/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author patri
 */
public class Ingreso {
    private int id;
    private int usuarioId;
    private String usuarionombre;
    private int trabajadorId;
    private String trabajadorNombre;
    private String tipoComprobante;
    private String serieComprobante;
    private String numComprobante;
    private Date fecha;
    private String estado;
    private List<DetalleIngreso>detalles;

    public Ingreso() {
    }

    public Ingreso(int id, int usuarioId, String usuarionombre, int trabajadorId, String trabajadorNombre, String tipoComprobante, String serieComprobante, String numComprobante, Date fecha, List<DetalleIngreso> detalles) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.usuarionombre = usuarionombre;
        this.trabajadorId = trabajadorId;
        this.trabajadorNombre = trabajadorNombre;
        this.tipoComprobante = tipoComprobante;
        this.serieComprobante = serieComprobante;
        this.numComprobante = numComprobante;
        this.fecha = fecha;
        this.detalles = detalles;
    }

    public Ingreso(int id, int usuarioId, String usuarionombre, int trabajadorId, String trabajadorNombre, String tipoComprobante, String serieComprobante, String numComprobante, Date fecha) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.usuarionombre = usuarionombre;
        this.trabajadorId = trabajadorId;
        this.trabajadorNombre = trabajadorNombre;
        this.tipoComprobante = tipoComprobante;
        this.serieComprobante = serieComprobante;
        this.numComprobante = numComprobante;
        this.fecha = fecha;
    }

    public Ingreso(int id, int usuarioId, String usuarionombre, int trabajadorId, String trabajadorNombre, String tipoComprobante, String serieComprobante, String numComprobante, List<DetalleIngreso> detalles) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.usuarionombre = usuarionombre;
        this.trabajadorId = trabajadorId;
        this.trabajadorNombre = trabajadorNombre;
        this.tipoComprobante = tipoComprobante;
        this.serieComprobante = serieComprobante;
        this.numComprobante = numComprobante;
        this.detalles = detalles;
    }
    
    

    public Ingreso(int id, int usuarioId, String usuarionombre, int trabajadorId, String trabajadorNombre, String tipoComprobante, String serieComprobante, String numComprobante, Date fecha, String estado) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.usuarionombre = usuarionombre;
        this.trabajadorId = trabajadorId;
        this.trabajadorNombre = trabajadorNombre;
        this.tipoComprobante = tipoComprobante;
        this.serieComprobante = serieComprobante;
        this.numComprobante = numComprobante;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Ingreso(int id, int usuarioId, String usuarionombre, int trabajadorId, String trabajadorNombre, String tipoComprobante, String serieComprobante, String numComprobante, String estado) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.usuarionombre = usuarionombre;
        this.trabajadorId = trabajadorId;
        this.trabajadorNombre = trabajadorNombre;
        this.tipoComprobante = tipoComprobante;
        this.serieComprobante = serieComprobante;
        this.numComprobante = numComprobante;
        this.estado = estado;
        
    }
    
    
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarionombre() {
        return usuarionombre;
    }

    public void setUsuarionombre(String usuarionombre) {
        this.usuarionombre = usuarionombre;
    }

    public int getTrabajadorId() {
        return trabajadorId;
    }

    public void setTrabajadorId(int trabajadorId) {
        this.trabajadorId = trabajadorId;
    }

    public String getTrabajadorNombre() {
        return trabajadorNombre;
    }

    public void setTrabajadorNombre(String trabajadorNombre) {
        this.trabajadorNombre = trabajadorNombre;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getSerieComprobante() {
        return serieComprobante;
    }

    public void setSerieComprobante(String serieComprobante) {
        this.serieComprobante = serieComprobante;
    }

    public String getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(String numComprobante) {
        this.numComprobante = numComprobante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    

    public List<DetalleIngreso> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleIngreso> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "Ingreso{" + "id=" + id + ", usuarioId=" + usuarioId + ", usuarionombre=" + usuarionombre + ", trabajadorId=" + trabajadorId + ", trabajadorNombre=" + trabajadorNombre + ", tipoComprobante=" + tipoComprobante + ", serieComprobante=" + serieComprobante + ", numComprobante=" + numComprobante + ", fecha=" + fecha + ", detalles=" + detalles + '}';
    }
    
    
    
}
