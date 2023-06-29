package entidades;

public class Produto {
	private int id;
	private String numeroChassi;
	private String placa;
	private String modelo;
	private String nome;
	private float valor;
	
	public Produto() {
		
	}
	
	public Produto(String numeroChassi, String placa, String modelo, String nome, float valor) {
		this.numeroChassi = numeroChassi;
		this.placa = placa;
		this.modelo = modelo;
		this.nome = nome;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChassi() {
		return numeroChassi;
	}

	public void setChassi(String chassi) {
		this.numeroChassi = chassi;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	

}
