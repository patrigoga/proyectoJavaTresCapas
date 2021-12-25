/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.ReferenciaDAO;
import entidades.Referencia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author patri
 */
public class ReferenciaControl {
    
    private final ReferenciaDAO DATOS;
    private Referencia obj;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;

    public ReferenciaControl() {
        this.DATOS = new ReferenciaDAO();
        this.obj = new Referencia();
        this.registrosMostrados = 0;
    }

    public DefaultTableModel listar(String texto) {
        List<Referencia> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto));

        String[] titulos = {"Id", "Nombre", "Descripción", "Estado"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String estado;
        String[] registro = new String[4];

        this.registrosMostrados = 0;
        for (Referencia item : lista) {
            if (item.isActivo()) {
                estado = "Activo";
            } else {
                estado = "Inactivo";
            }
            registro[0] = Integer.toString(item.getId());
            registro[1] = item.getNombre();
            registro[2] = item.getDescripcion();
            registro[3] = estado;
            this.modeloTabla.addRow(registro);
            this.registrosMostrados = this.registrosMostrados + 1;
        }
        return this.modeloTabla;
    }

    public String insertar(String nombre, String descripcion) {
        if (DATOS.existe(nombre)) {
            return "El registro ya existe.";
        } else {
            obj.setNombre(nombre);
            obj.setDescripcion(descripcion);
            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "Error en el registro.";
            }
        }
    }

    public String actualizar(int id, String nombre, String nombreAnt, String descripcion) {
        if (nombre.equals(nombreAnt)) {
            obj.setId(id);
            obj.setNombre(nombre);
            obj.setDescripcion(descripcion);
            if (DATOS.actualizar(obj)) {
                return "OK";
            } else {
                return "Error en la actualización.";
            }
        } else {
            if (DATOS.existe(nombre)) {
                return "El registro ya existe.";
            } else {
                obj.setId(id);
                obj.setNombre(nombre);
                obj.setDescripcion(descripcion);
                if (DATOS.actualizar(obj)) {
                    return "OK";
                } else {
                    return "Error en la actualización.";
                }
            }
        }
    }

    public String desactivar(int id) {
        if (DATOS.desactivar(id)) {
            return "OK";
        } else {
            return "No se puede desactivar el registro";
        }
    }

    public String activar(int id) {
        if (DATOS.activar(id)) {
            return "OK";
        } else {
            return "No se puede activar el registro";
        }
    }

    public int total() {
        return DATOS.total();
    }

    public int totalMostrados() {
        return this.registrosMostrados;
    }
    
}
