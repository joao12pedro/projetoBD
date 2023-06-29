package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConectaBD {
	private Connection conexao;
	public ConectaBD() {
		String url = "jdbc:mariadb://localhost:3306/cap2";
		String user = "root";
		String pwd = "123";
		try {
			conexao = DriverManager.getConnection(url, user, pwd);
			System.out.println("Conexão realizada");
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	/**
	 * Metodo que retorna a conexão
	 * @return
	 */
	public Connection getConexao() {
		return conexao;
	}
	
}
