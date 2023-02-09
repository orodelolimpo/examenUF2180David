package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;

import conexion.ConexionBD;
import modelo.Departamento;

public class DepartamentoDAO {
	
	private ConexionBD conexion;
	public DepartamentoDAO() {
		this.conexion = new ConexionBD();
	
	}
    public ArrayList<Departamento> obtenerDepartamentos() {
    	
		Connection con = conexion.getConexion();
		Statement consulta = null;
		ResultSet resultado = null;
		ArrayList<Departamento> lista = new ArrayList<Departamento>();
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from departamentos");
			
			//recorro las filas
			while(resultado.next()) {
				int cod_departamento = resultado.getInt("cod_departamento");
				int cod_centro = resultado.getInt("cod_centro");
				String tipo_dir = resultado.getString("tipo_dir");
				int presupuesto=resultado.getInt("presupuesto");
				String nombre =resultado.getString("nombre");
	
				Departamento departamento = new Departamento(cod_departamento,cod_centro,tipo_dir, 															presupuesto,nombre);
				lista.add(departamento);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre departamentos: "+e.getMessage());
		} finally {
			try {
				resultado.close();
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return lista;
    }


    public int insertarDepartamento(Departamento departamento) throws SQLException {//al solucionar el error de añadir la excepción throw 

		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		int resultado=0;
		
		try {
			consulta = con.prepareStatement("INSERT INTO Departamentos (cod_departamento,cod_centro,tipo_dir, 															presupuesto,nombre)"
					+ " VALUES (?,?,?,?,?) ");
			
			
			consulta.setInt(1, departamento.getCod_departamento() );
			consulta.setInt(2, departamento.getCod_centro());
			consulta.setString(3, departamento.getTipo_dir());//.substring(1));//he añadido substring para que coja sólo la primera lentra)
			consulta.setInt(4, departamento.getPresupuesto());
			consulta.setString(5, departamento.getNombre());
			
			resultado=consulta.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar la inserción del departamento: "
		        +e.getMessage());//en este caso me falta lo siguiente:
			throw e;//esto es controlar una excepción la vuelvo a lanzar.  me tira error
			
		} finally {
			try {
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return resultado;
    }
    
    //hay que poner un try----catch porque sino no podríamos poner finally y si no lo podríamos hacer el try...catch para poder liberar los recursosm por eso si o si hay que poner ese catch.  nosotroa ademas aquí 
    
    
}
