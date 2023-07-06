package JdbcSwingMysql.Util;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ConexaoUtil {

	private static String driver = "com.mysql.cj.jdbc.Driver"; //Driver JDBC para conexão MySQL;
	private static String url = "jdbc:mysql://localhost:3306/produtos_db"; //Local do arquivo do Banco de Dados (XAMPP/mysql);
	private static String usuario = "root";
	private static String senha = "";
	
	//Método para obter a conexão com o Banco de Dados:
	public static Connection getConnection() {
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, usuario, senha);
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException ("Erro na conexão: ", e);
		}
	}
	
	//Método para fechar a conexão com o Banco de Dados evitando sobrecarga do servidor:
	public static void closeConnection(Connection con) { 
		try {
			if(con != null) {
				con.close();
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	//Método de sobrecarga Connection + PreparedStatement:
	public static void closeConnection(Connection con, PreparedStatement stmt) { 
		closeConnection(con);
		try {
			if(stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	//Método de sobrecarga Connection + PreparedStatement + ResultSet:
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) { 
		closeConnection(con, stmt);
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
}
