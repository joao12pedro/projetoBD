package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entidades.Pessoa;
import entidades.Produto;

public class ProdutoDAO {
	public void inserir(Produto produto) {
		ConectaBD conexao = new ConectaBD();
		String sql = "INSERT INTO produto (numeroChassi,placa,modelo, nome, valor) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
			pst.setString(1, produto.getChassi());
			pst.setString(2, produto.getPlaca());
			pst.setString(3, produto.getModelo());
			pst.setString(4, produto.getNome());
			pst.setFloat(5, produto.getValor());
			pst.execute();
			System.out.println(produto.getNome() + " inserido");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public Produto consultar(int id) {
		//SELECT
		ConectaBD con = new ConectaBD();
		String sql = "SELECT * FROM produto WHERE idCarro = ?";
		Produto produto = null;
		
		try {
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				
				int idCarro = rs.getInt("idCarro");
				String  chassi= rs.getString("numeroChassi");
				String placa = rs.getString("placa");
				String modelo = rs.getString("modelo");
				String nome = rs.getString("nome");
				float valor = rs.getFloat("valor");
				produto = new Produto(chassi, placa, modelo, nome, 32000);
				produto.setId(idCarro);
				
			}
			else {
				System.out.println("Registro não encontrado");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Consultado");
		return produto;
	}
	
	public Produto consultarPlaca(String placa) {
		//SELECT
		ConectaBD con = new ConectaBD();
		String sql = "SELECT * FROM produto WHERE placa = ?";
		Produto produto = null;
		
		try {
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			pst.setString(1, placa);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				
				int idCarro = rs.getInt("idCarro");
				String  chassi= rs.getString("numeroChassi");
				String placa1 = rs.getString("placa");
				String modelo = rs.getString("modelo");
				String nome = rs.getString("nome");
				float valor = rs.getFloat("valor");
				produto = new Produto(chassi, placa1, modelo, nome, valor);
				produto.setId(idCarro);
				
			}
			else {
				System.out.println("Registro não encontrado");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Consultado");
		return produto;
	}
	public boolean deletar(int id) {
		String sql = "DELETE FROM produto WHERE idCarro = ?";
		List<Produto> lista = new LinkedList<Produto>();
		Produto produto = null;
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
	public boolean atualizar(Produto produto) {
		try {
			String sql = "UPDATE produto SET numeroChassi = ?, placa = ?, modelo = ?, nome = ?, valor = ? WHERE idCarro = ?";
			ConectaBD con = new ConectaBD();
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			pst.setString(1, produto.getChassi());
			pst.setString(2, produto.getPlaca());
			pst.setString(3, produto.getModelo());
			pst.setString(4, produto.getNome());
			pst.setDouble(5, produto.getValor());
			pst.setInt(6, produto.getId());
			int linhas = pst.executeUpdate();
			return linhas>0;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

}
