/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.DepositoDAO;
import datos.ReferenciaDAO;
import entidades.Deposito;
import entidades.Referencia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author patri
 */
public class DepositoControl {

    private final DepositoDAO DATOS;
    private final ReferenciaDAO DATOSREF;
    private Deposito obj;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;

    public DepositoControl() {
        this.DATOS = new DepositoDAO();
        this.obj = new Deposito();
        this.registrosMostrados = 0;
        this.DATOSREF = new ReferenciaDAO();
    }

    public DefaultTableModel listar(String texto, int totalPorPagina, int numPagina) {
        List<Deposito> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto, totalPorPagina, numPagina));

        String[] titulos = {"Id", "Categoria_Id", "Referencia", "Codigo", "Nombre", "Cantidad", "Estado"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String estado;
        String[] registro = new String[7];

        this.registrosMostrados = 0;
        for (Deposito item : lista) {
            if (item.isActivo()) {
                estado = "Activo";
            } else {
                estado = "Inactivo";
            }
            registro[0] = Integer.toString(item.getId());
            registro[1] = Integer.toString(item.getReferenciaId());
            registro[2] = item.getReferenciaNombre();
            registro[3] = item.getCodigo();
            registro[4] = item.getNombre();
            registro[5] = Integer.toString(item.getStock());
            registro[6] = estado;

            this.modeloTabla.addRow(registro);
            this.registrosMostrados = this.registrosMostrados + 1;
        }
        return this.modeloTabla;
    }
    public DefaultTableModel listarDepositoSalida(String texto, int totalPorPagina, int numPagina) {
        List<Deposito> lista = new ArrayList();
        lista.addAll(DATOS.listarDepositoSalida(texto, totalPorPagina, numPagina));

        String[] titulos = {"Id", "Categoria_Id", "Referencia", "Codigo", "Nombre", "Cantidad", "Estado"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String estado;
        String[] registro = new String[7];

        this.registrosMostrados = 0;
        for (Deposito item : lista) {
            if (item.isActivo()) {
                estado = "Activo";
            } else {
                estado = "Inactivo";
            }
            registro[0] = Integer.toString(item.getId());
            registro[1] = Integer.toString(item.getReferenciaId());
            registro[2] = item.getReferenciaNombre();
            registro[3] = item.getCodigo();
            registro[4] = item.getNombre();
            registro[5] = Integer.toString(item.getStock());
            registro[6] = estado;

            this.modeloTabla.addRow(registro);
            this.registrosMostrados = this.registrosMostrados + 1;
        }
        return this.modeloTabla;
    }

    public DefaultComboBoxModel seleccionar() {
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        List<Referencia> lista = new ArrayList<>();
        lista = DATOSREF.seleccionar();
        for (Referencia item : lista) {
            items.addElement(new Referencia(item.getId(), item.getNombre()));

        }

        return items;

    }

    public String insertar(int referenciaId, String codigo, String nombre, int stock) {
        if (DATOS.existe(nombre)) {
            return "El registro ya existe.";
        } else {
            obj.setReferenciaId(referenciaId);
            obj.setCodigo(codigo);
            obj.setNombre(nombre);
            obj.setStock(stock);

            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "Error en el registro.";
            }
        }
    }

    public String actualizar(int id, int referenciaId, String codigo, String nombre, String nombreAnt, int stock) {
        if (nombre.equals(nombreAnt)) {
            obj.setId(id);
            obj.setReferenciaId(referenciaId);
            obj.setCodigo(codigo);
            obj.setNombre(nombre);
            obj.setStock(stock);

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
                obj.setReferenciaId(referenciaId);
                obj.setCodigo(codigo);
                obj.setNombre(nombre);
                obj.setStock(stock);

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
