/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.TrabajadorDAO;
import entidades.Trabajador;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author patri
 */
public class TrabajadorControl {
    private final TrabajadorDAO DATOS;
    private Trabajador obj;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;
    
    public TrabajadorControl(){
        this.DATOS=new TrabajadorDAO();
        this.obj=new Trabajador();
        this.registrosMostrados=0;
    }
    
    public DefaultTableModel listar(String texto,int totalPorPagina,int numPagina){
        List<Trabajador> lista=new ArrayList();
        lista.addAll(DATOS.listar(texto,totalPorPagina,numPagina));
        
        String[] titulos={"Id","Tipo Trabajador","Trabajador","Tipo Doc","Numero Doc","Dirección","Teléfono","Email","Estado"};
        this.modeloTabla=new DefaultTableModel(null,titulos);        
        
        String estado;
        String[] registro = new String[9];
        
        this.registrosMostrados=0;
        for (Trabajador item:lista){
            if (item.isActivo()){
                estado="Activo";
            } else{
                estado="Inactivo";
            }
            registro[0]=Integer.toString(item.getId());
            registro[1]=item.getTipoTrabajador();
            registro[2]=item.getNombre();
            registro[3]=item.getTipoDocumento();
            registro[4]=item.getNumDocumento();
            registro[5]=item.getDireccion();
            registro[6]=item.getTelefono();
            registro[7]=item.getEmail();
            registro[8]=estado;
            this.modeloTabla.addRow(registro);
            this.registrosMostrados=this.registrosMostrados+1;
        }
        return this.modeloTabla;
    }
    
    public DefaultTableModel listarTipo(String texto,int totalPorPagina,int numPagina,String tipoTrabajador){
        List<Trabajador> lista=new ArrayList();
        lista.addAll(DATOS.listarTipo(texto,totalPorPagina,numPagina,tipoTrabajador));
        
        String[] titulos={"Id","Tipo Trabajador","Trabajador","Documento","Numero Documento","Dirección","Teléfono","Email","Estado"};
        this.modeloTabla=new DefaultTableModel(null,titulos);        
        
        String estado;
        String[] registro = new String[9];
        
        this.registrosMostrados=0;
        for (Trabajador item:lista){
            if (item.isActivo()){
                estado="Activo";
            } else{
                estado="Inactivo";
            }
            registro[0]=Integer.toString(item.getId());
            registro[1]=item.getTipoTrabajador();
            registro[2]=item.getNombre();
            registro[3]=item.getTipoDocumento();
            registro[4]=item.getNumDocumento();
            registro[5]=item.getDireccion();
            registro[6]=item.getTelefono();
            registro[7]=item.getEmail();
            registro[8]=estado;
            this.modeloTabla.addRow(registro);
            this.registrosMostrados=this.registrosMostrados+1;
        }
        return this.modeloTabla;
    }
       
    public String insertar(String tipoTrabajador, String nombre, String tipoDocumento, String numDocumento, String direccion, String telefono, String email){
        if (DATOS.existe(nombre)){
            return "El registro ya existe.";
        }else{
            obj.setTipoTrabajador(tipoTrabajador);
            obj.setNombre(nombre);
            obj.setTipoDocumento(tipoDocumento);
            obj.setNumDocumento(numDocumento);
            obj.setDireccion(direccion);
            obj.setTelefono(telefono);
            obj.setEmail(email);
            
            if (DATOS.insertar(obj)){
                return "OK";
            }else{
                return "Error en el registro.";
            }
        }
    }
    
    public String actualizar(int id,String tipoTrabajador, String nombre, String nombreAnt, String tipoDocumento, String numDocumento, String direccion, String telefono, String email){
        if (nombre.equals(nombreAnt)){
            obj.setId(id);
            obj.setTipoTrabajador(tipoTrabajador);
            obj.setNombre(nombre);
            obj.setTipoDocumento(tipoDocumento);
            obj.setNumDocumento(numDocumento);
            obj.setDireccion(direccion);
            obj.setTelefono(telefono);
            obj.setEmail(email);
            
            if(DATOS.actualizar(obj)){
                return "OK";
            }else{
                return "Error en la actualización.";
            }
        }else{
            if (DATOS.existe(nombre)){
                return "El registro ya existe.";
            }else{
                obj.setId(id);
                obj.setTipoTrabajador(tipoTrabajador);
                obj.setNombre(nombre);
                obj.setTipoDocumento(tipoDocumento);
                obj.setNumDocumento(numDocumento);
                obj.setDireccion(direccion);
                obj.setTelefono(telefono);
                obj.setEmail(email);
            
                if (DATOS.actualizar(obj)){
                    return "OK";
                }else{
                    return "Error en la actualización.";
                }
            }
        }
    }
    
    public String desactivar(int id){
        if (DATOS.desactivar(id)){
            return "OK";
        }else{
            return "No se puede desactivar el registro";
        }
    }
    
    public String activar(int id){
        if (DATOS.activar(id)){
            return "OK";
        }else{
            return "No se puede activar el registro";
        }
    }
    
    public int total(){
        return DATOS.total();
    }
    
    public int totalMostrados(){
        return this.registrosMostrados;
    }
    
}
