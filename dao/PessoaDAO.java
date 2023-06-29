package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entidades.Pessoa;

public class PessoaDAO {
	// CRUD
	// C - create | R - Retrieve | U - Update | D - Delete
	public void inserir(Pessoa pessoa) {
		ConectaBD conexao = new ConectaBD();
		String sql = "INSERT INTO pessoa (nome,e_mail) VALUES (?,?)";
		try {
			PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
			pst.setString(1, pessoa.getNome());
			pst.setString(2, pessoa.getE_mail());
			pst.execute();
			System.out.println(pessoa.getNome() + "inserido");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public Pessoa consultar(int id) {
		//SELECT
		ConectaBD con = new ConectaBD();
		String sql = "SELECT * FROM pessoa WHERE idpessoa = ?";
		Pessoa pessoa = null;
		
		try {
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				int idpessoa = rs.getInt("idpessoa");
				String nome = rs.getString("nome");
				String email = rs.getString("e_mail");
				pessoa = new Pessoa(nome, email);
				pessoa.setId(idpessoa);
				
			}
			else {
				System.out.println("Registro não encontrado");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Consultado");
		return pessoa;
	}
	
	public List<Pessoa> consultaTodos(){
		ConectaBD con = new ConectaBD();
		String sql = "SELECT * FROM pessoa";
		List<Pessoa> lista = new LinkedList<Pessoa>();
		try {
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Pessoa pessoa = new Pessoa();
				int id = rs.getInt("idpessoa");
				String nome = rs.getString("nome");
				String email = rs.getString("e_mail");
				pessoa.setId(id);
				pessoa.setNome(nome);
				pessoa.setE_mail(email);
				lista.add(pessoa);
			}
			
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			
		}
		return lista;
	}
	
	public boolean deletar(int id) {
		String sql = "DELETE FROM pessoa WHERE idpessoa = ?";
		List<Pessoa> lista = new LinkedList<Pessoa>();
		Pessoa pessoa = null;
		try {
			ConectaBD con = new ConectaBD();
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			pst.setInt(1, id);
			pst.execute();
			return pst.getUpdateCount()>0;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	 }
	 
	public boolean atualizar(Pessoa pessoa) {
		try {
			String sql = "UPDATE pessoa SET nome = ?, e_mail = ? WHERE idpessoa = ?";
			ConectaBD con = new ConectaBD();
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			pst.setString(1, pessoa.getNome());
			pst.setString(2, pessoa.getE_mail());
			pst.setInt(3, pessoa.getId());
			int linhas = pst.executeUpdate();
			return linhas>0;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
}


 