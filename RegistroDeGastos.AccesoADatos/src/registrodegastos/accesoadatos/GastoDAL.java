
package registrodegastos.accesoadatos;

import java.util.*;
import java.sql.*;
import registrodegastos.entidadesdenegocio.*;
import java.time.LocalDate;

public class GastoDAL {
   static String obtenerCampos() {
        return "e.Id, e.IdCategoria,IdUsuario, e.Monto, e.Fecha, e.Descripcion";
    }
    
    private static String obtenerSelect(Gasto pGasto) {
        String sql;
        sql = "SELECT ";
        if (pGasto.getTop_aux() > 0 && ComunDB.TIPODB == ComunDB.TipoDB.SQLSERVER) {
             sql += "TOP " + pGasto.getTop_aux() + " ";
        }
        sql += (obtenerCampos() + " FROM Gasto e");
        return sql;
    }
    
    private static String agregarOrderBy(Gasto pGasto) {
        String sql = " ORDER BY e.Id DESC";
        if (pGasto.getTop_aux() > 0 && ComunDB.TIPODB == ComunDB.TipoDB.MYSQL) {
            sql += " LIMIT " + pGasto.getTop_aux() + " ";
        }
        return sql;
    }
    
    public static int crear(Gasto pGasto) throws Exception {
        int result;
        String sql;
        
        try ( Connection conn = ComunDB.obtenerConexion();) {
            sql = "INSERT INTO Gasto(IdCategoria,IdUsuario,Monto,Fecha,Descripcion) VALUES(?,?,?,?,?)";
            try ( PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) {
                ps.setInt(1, pGasto.getIdCategoria());
                ps.setInt(2, pGasto.getIdUsuario());
                ps.setDouble(3, pGasto.getMonto());
                ps.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
                ps.setString(5, pGasto.getDescripcion());
                result = ps.executeUpdate();
                ps.close();
            } catch (SQLException ex) {
                throw ex;
            }
            conn.close();
        } catch (SQLException ex) {
            throw ex;
        }
        
        return result;
    }
    
    public static int modificar(Gasto pGasto) throws Exception {
        int result;
        String sql;
        try ( Connection conn = ComunDB.obtenerConexion();) {
            sql = "UPDATE Gasto SET IdCategoria=?, IdUsuario=?, Monto=?, fecha=?, Descripcion=? WHERE Id=?";
            try ( PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) {
                ps.setInt(1, pGasto.getIdCategoria());
                ps.setInt(2, pGasto.getIdUsuario());
                ps.setDouble(3, pGasto.getMonto());
                ps.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
                ps.setString(5, pGasto.getDescripcion());
                ps.setInt(6, pGasto.getId());
                result = ps.executeUpdate();
                ps.close();
            } catch (SQLException ex) {
                throw ex;
            }
            conn.close();
        } catch (SQLException ex) {
            throw ex;
        }
        
        return result;
    }
    
    public static int eliminar(Gasto pGasto) throws Exception {
        int result;
        String sql;
        try (Connection conn = ComunDB.obtenerConexion();) { 
            sql = "DELETE FROM Gasto WHERE Id=?"; 
            try (PreparedStatement ps = ComunDB.createPreparedStatement(conn, sql);) {
                ps.setInt(1, pGasto.getId());
                result = ps.executeUpdate();
                ps.close();
            } catch (SQLException ex) {
                throw ex;
            }
            conn.close();
        }
        catch (SQLException ex) {
            throw ex;
        }
        return result;
    }
    
    static int asignarDatosResultSet(Gasto pGasto, ResultSet pResultSet, int pIndex) throws Exception {
        pIndex++;
        pGasto.setId(pResultSet.getInt(pIndex)); 
        pIndex++;
        pGasto.setIdCategoria(pResultSet.getInt(pIndex)); 
        pIndex++;
        pGasto.setMonto(pResultSet.getDouble(pIndex)); 
        pIndex++;
        pGasto.setFecha(pResultSet.getDate(pIndex).toLocalDate()); 
        pIndex++;
        pGasto.setDescripcion(pResultSet.getString(pIndex)); 
        pIndex++;
        pGasto.setDescripcion(pResultSet.getString(pIndex)); 
        return pIndex;
    }
    
    private static void obtenerDatos(PreparedStatement pPS, ArrayList<Gasto> pGasto) throws Exception {
        try (ResultSet resultSet = ComunDB.obtenerResultSet(pPS);) { 
            while (resultSet.next()) {
                Gasto gasto = new Gasto();
                asignarDatosResultSet(gasto, resultSet, 0);
                pGasto.add(gasto);
            }
            resultSet.close();
        } catch (SQLException ex) {
            throw ex;
        }
    }
    
    }
