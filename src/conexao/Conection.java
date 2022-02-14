package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conection {

	private static String url = "jdbc:mysql://localhost/agenciapectros?verifyServerCertificate=false&useSSL=true";
	private static String usuario = "root";
	private static String senha = "Papas1420";

	public static Connection createConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection(url, usuario, senha);

		return conn;
	}

	public static void main(String[] args) throws Exception {
		Connection conn = createConnection();

		if (conn != null) {
			System.out.println("Conexão obtida com sucesso");
		} else {
			System.out.println("Erro ao conectar");
		}
	}

}
