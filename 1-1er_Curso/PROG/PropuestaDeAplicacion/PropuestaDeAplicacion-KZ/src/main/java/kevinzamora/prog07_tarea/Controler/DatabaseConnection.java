package kevinzamora.prog07_tarea.Controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseConnection {
	private String user;
	private String password;
	private Connection conn;

	public DatabaseConnection(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}
    // Chris: para conecta el baso de datos 
	public Connection getConn() throws ClassNotFoundException {
		String urlConnection;
		Properties infoConnection;

		urlConnection = "jdbc:mysql://localhost:3306/gestiondeadoptar";
		infoConnection = new Properties();
		infoConnection.put("user", this.user);
		infoConnection.put("password", this.password);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(urlConnection, infoConnection);
			System.err.println("Conexion Establecidad");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public ResultSet dameTipoTel() throws SQLException {
		ResultSet rs = null;
		String query = "select * from tipotelefono";

		Statement st;

		try {
			conn = getConn();
			st = conn.createStatement();
			rs = st.executeQuery(query);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}
	 // Chris : para guarda persona
//	public void insertaPersona(Persona p) throws SQLException {
//		String query1 = "INSERT INTO `gestiondeadoptar`.`persona` (`nombre`, `primerApellido`, "
//				+ "`segundoApellido`, `direccion`, `correo`, `usuario`, `password`) " + "VALUES (?, ?, ?, ?, ?, ?, ?)";
//		PreparedStatement ps = null;
//		PreparedStatement ps1 = null ;
//
//		try {
//			conn = getConn();
//			conn.setAutoCommit(false);
//
//			Long lastInsertId = 0L;
//
//			ps = conn.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
//			ps.setString(1, p.getNombre());
//			ps.setString(2, p.getPrimerApellido());
//			ps.setString(3, p.getSegundoApellido());
//			ps.setString(4, p.getDireccion());
//			ps.setString(5, p.getCorreo());
//			ps.setString(6, p.getUsuario());
//			ps.setString(7, p.getPassword());
//
//			int totalInsert = ps.executeUpdate();
//
//			if (totalInsert > 0 && p.getTelefono() != null) {
//				ResultSet generatedKeys = ps.getGeneratedKeys();
//
//				if (generatedKeys.next()) {
//					lastInsertId = generatedKeys.getLong(1);
//				}
//				
//				String query2 ="INSERT INTO `gestiondeadoptar`.`telefono` (`numero`, `idTipoTelefono`, `idPersona`) "
//						+ "VALUES (?, ?, ?)";
//				ps1 = conn.prepareStatement(query2);
//				
//				ps1.setString(1, p.getTelefono());
//				ps1.setInt(2, p.getTipoTelefono());
//				ps1.setLong(3, lastInsertId);
//				ps1.executeUpdate();
//			}
//			
//			conn.commit();
//
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			
//			ps.close();
//			ps1.close();
//			conn.setAutoCommit(true);
//		}
//
//	}
	

}
