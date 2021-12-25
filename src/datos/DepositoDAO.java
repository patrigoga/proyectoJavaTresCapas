/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.PreparedStatement;
import java.sql.*;
import database.Conexion;
import entidades.Deposito;
import entidades.Referencia;
import interfaces.CrudPaginadoInterface;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import interfaces.ReferenciaInterfaces;

/**
 *
 * @author patri
 */
public class DepositoDAO implements CrudPaginadoInterface<Deposito> {

    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public DepositoDAO() {
        CON = Conexion.getInstancia();
    }

    @Override
    public List<Deposito> listar(String texto, int totalPorPaginas, int numPagina) {
        List<Deposito> registros = new ArrayList();

        try {
            ps = CON.conectar().prepareStatement("SELECT a.id,a.referencia_id,c.nombre,a.codigo,a.nombre,a.stock,a.activo FROM deposito a inner join referencia c ON a.referencia_id = c.id WHERE a.codigo or a.nombre or c.nombre LIKE ? ORDER BY a.id ASC LIMIT ?,?");
            ps.setString(1, "%" + texto + "%");
            ps.setInt(2, (numPagina - 1) * totalPorPaginas);
            ps.setInt(3, totalPorPaginas);
            rs = ps.executeQuery();

            while (rs.next()) {
                registros.add(new Deposito(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getBoolean(7)));
            }
            ps.close();
            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return registros;
    }
     public List<Deposito> listarDepositoSalida(String texto, int totalPorPaginas, int numPagina) {
        List<Deposito> registros = new ArrayList();

        try {
            ps = CON.conectar().prepareStatement("SELECT a.id,a.referencia_id,c.nombre,a.codigo,a.nombre,a.stock,a.activo FROM deposito a inner join referencia c ON a.referencia_id = c.id WHERE a.codigo or a.nombre or c.nombre LIKE ? ORDER BY a.id ASC LIMIT ?,?");
            ps.setString(1, "%" + texto + "%");
            ps.setInt(2, (numPagina - 1) * totalPorPaginas);
            ps.setInt(3, totalPorPaginas);
            rs = ps.executeQuery();

            while (rs.next()) {
                registros.add(new Deposito(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getBoolean(7)));
            }
            ps.close();
            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return registros;
    }

    public List<Deposito> seleccionar() {
        List<Deposito> registros = new ArrayList();

        try {
            ps = CON.conectar().prepareStatement("SELECT id,nombre FROM deposito  ORDER BY nombre ASC");

            rs = ps.executeQuery();

            while (rs.next()) {
                registros.add(new Deposito(rs.getInt(1), rs.getString(2)));
            }
            ps.close();
            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return registros;
    }

    public Deposito obtenerDepositoCodigoBarras(String codigo) {
        Deposito dep = null;

        try {
            ps = CON.conectar().prepareStatement("SELECT id,codigo,nombre,stock FROM deposito WHERE codigo = ?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();

            if (rs.first()) {
                dep = new Deposito(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }

            ps.close();
            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return dep;
    }
        public Deposito obtenerDepositoCodigoBarrasVentas(String codigo) {
        Deposito dep = null;

        try {
            ps = CON.conectar().prepareStatement("SELECT id,codigo,nombre,stock FROM deposito WHERE codigo = ?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();

            if (rs.first()) {
                dep = new Deposito(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }

            ps.close();
            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return dep;
    }

    @Override
    public boolean insertar(Deposito obj) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("INSERT INTO deposito (referencia_id,codigo,nombre,stock,activo) VALUES (?,?,?,?,1)");
            ps.setInt(1, obj.getReferenciaId());
            ps.setString(2, obj.getCodigo());
            ps.setString(3, obj.getNombre());
            ps.setInt(4, obj.getStock());

            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean actualizar(Deposito obj) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("UPDATE deposito SET referencia_id=?, codigo=?,nombre=?,stock=? WHERE id=?");
            ps.setInt(1, obj.getReferenciaId());
            ps.setString(2, obj.getCodigo());
            ps.setString(3, obj.getNombre());
            ps.setInt(4, obj.getStock());
            ps.setInt(5, obj.getId());
            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean desactivar(int id) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("UPDATE deposito SET activo=0 WHERE id=?");
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean activar(int id) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("UPDATE deposito SET activo=1 WHERE id=?");
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public int total() {

        int totalRegistros = 0;
        try {
            ps = CON.conectar().prepareStatement("SELECT COUNT(id) FROM deposito");
            rs = ps.executeQuery();

            while (rs.next()) {
                totalRegistros = rs.getInt("COUNT(id)");
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return totalRegistros;

    }

    @Override
    public boolean existe(String texto) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("SELECT nombre FROM deposito WHERE nombre=?");
            ps.setString(1, texto);
            rs = ps.executeQuery();
            rs.last();
            if (rs.getRow() > 0) {
                resp = true;
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return resp;
    }

}
