package entidades;

import dao.PessoaDAO;

public class Pessoa {
	
	//atributos
	private int id;
	private String nome;
	private String e_mail;
	//construtor padrão
	
	public Pessoa() {
		
	}
	
	//constutror paramétrico
	public Pessoa(String nome, String e_mail) {
		this.nome = nome;
		this.e_mail = e_mail;
	}
	
	//métodos de acesso
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	
	public void inserir() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.inserir(this);
	}
	
	
	

}
