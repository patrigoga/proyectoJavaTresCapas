package negocio;

import datos.DepositoDAO;


import datos.VentaDAO;
import entidades.Deposito;
import entidades.DetalleVenta;
import entidades.Venta;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author patri
 */
public class VentaControl {

    private final VentaDAO DATOS;
    
    private final DepositoDAO DATOSDEP;
    private Venta obj;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;

    public VentaControl() {
        this.DATOS = new VentaDAO();
        this.obj = new Venta();
        this.registrosMostrados = 0;
        //this.DATOSREF = new ReferenciaDAO();
        this.DATOSDEP = new DepositoDAO();

    }

    public DefaultTableModel listar(String texto, int totalPorPagina, int numPagina) {
        List<Venta> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto, totalPorPagina, numPagina));

        String[] titulos = {"Id", "Id_Usuario", "Nomb_Usuario", "Id_trabajador", "Nombre Trabajador", "Tipo comprobante", "Serie comprobante", "Nº Comprobante", "Fecha", "Estado"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String estado;
        String[] registro = new String[10];
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        this.registrosMostrados = 0;
        for (Venta item : lista) {
            registro[0] = Integer.toString(item.getId());
            registro[1] = Integer.toString(item.getUsuarioId());
            registro[2] = item.getUsuarionombre();
            registro[3] = Integer.toString(item.getTrabajadorId());
            registro[4] = item.getTrabajadorNombre();
            registro[5] = item.getTipoComprobante();
            registro[6] = item.getSerieComprobante();
            registro[7] = item.getNumComprobante();
            registro[8] = sdf.format(item.getFecha());
            registro[9] = item.getEstado();

            this.modeloTabla.addRow(registro);
            this.registrosMostrados = this.registrosMostrados + 1;
        }
        return this.modeloTabla;
    }

    public DefaultTableModel listarDetalle(int id) {
        List<DetalleVenta> lista = new ArrayList();
        lista.addAll(DATOS.listarDetalle(id));

        String[] titulos = {"Id", "Codigo", "Depósito", "Cantidad"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String estado;
        String[] registro = new String[4];

        this.registrosMostrados = 0;
        for (DetalleVenta item : lista) {
            registro[0] = Integer.toString(item.getDepositoId());
            registro[1] = item.getDepositoCodigo();
            registro[2] = item.getDepositoNombre();
            registro[3] = Integer.toString(item.getCantidad());
            this.modeloTabla.addRow(registro);

        }
        return this.modeloTabla;
    }

    public Deposito obtenerDepositoCodigoVemta(String codigo) {
        Deposito dep = DATOSDEP.obtenerDepositoCodigoBarrasVentas(codigo);
        return dep;
    }

    public String insertar(int trabajador_id, String tipo_comprobante, String serie_comprobante, String num_comprobante, DefaultTableModel modeloDetalles) {
        if (DATOS.existe(serie_comprobante, num_comprobante)) {
            return "El registro ya existe.";
        } else {
            obj.setUsuarioId(Variables.usuarioId);
            obj.setTrabajadorId(trabajador_id);
            obj.setTipoComprobante(tipo_comprobante);
            obj.setSerieComprobante(serie_comprobante);
            obj.setNumComprobante(num_comprobante);

            List<DetalleVenta> detalles = new ArrayList();
            int depositoId;
            int cantidad;

            for (int i = 0; i < modeloDetalles.getRowCount(); i++) {
                depositoId = Integer.parseInt(String.valueOf(modeloDetalles.getValueAt(i, 0)));
                cantidad = Integer.parseInt(String.valueOf(modeloDetalles.getValueAt(i, 3)));

                detalles.add(new DetalleVenta(depositoId, cantidad));
            }
            obj.setDetalles(detalles);

            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "Error en el registro de detalles.";
            }
        }
    }

    public String anular(int id) {
        if (DATOS.anular(id)) {
            return "OK";
        } else {
            return "No se puede anular el registro";
        }
    }

    public int total() {
        return DATOS.total();
    }

    public int totalMostrados() {
        return this.registrosMostrados;
    }

}
