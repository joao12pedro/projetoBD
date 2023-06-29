package App;

import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import dao.PessoaDAO;
import dao.ProdutoDAO;
import entidades.Pessoa;
import entidades.Produto;

public class Main {
	public static String leString(String msg) {
		String valor = JOptionPane.showInputDialog(null, msg);
		return valor;
	}
	
	public static int menuPrincipal() {
		Scanner in = new Scanner(System.in);
		System.out.println("Selecione a tabela que deseja manipular:");
		System.out.println("1- Tabela Pessoa");
		System.out.println("2 - Tabela Produto");
		System.out.println("3 - Sair");
		return in.nextInt();

	}
	public static int menuPe() {
		Scanner in = new Scanner(System.in);
		System.out.println("MENU");
		System.out.println("1- Inserir");
		System.out.println("2 - Consultar todos");
		System.out.println("3- Consulta unica");
		System.out.println("4- Excluir");
		System.out.println("5- Atualizar");
		System.out.println("6- Sair");
		System.out.println("Digite: ");
		return in.nextInt();
		
	}
	
	public static int menuPr() {
		Scanner in = new Scanner(System.in);
		System.out.println("MENU");
		System.out.println("1- Inserir");
		System.out.println("2 - Consultar por id");
		System.out.println("3- Consultar por placa");
		System.out.println("4- Excluir");
		System.out.println("5- Atualizar");
		System.out.println("6- Sair");
		System.out.println("Digite: ");
		return in.nextInt();
	}
	public static void metodoInserirPr() {
		String chassi = leString("Digite o numero do chassi:");
		String placa = leString("Digite placa:");
		String modelo = leString("Digite o modelo:");
		String nome = leString("Digite o nome:");
		String valor = leString("Digite o valor:");
		Float v = Float.parseFloat(valor);
		Produto produto = new Produto(chassi, placa, modelo, nome, v);
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.inserir(produto);
		
		
	}
	public static void metodoInserirPe() {
		String nome = leString("Digite nome:");
		String email = leString("Digite email:");
		Pessoa pessoa = new Pessoa(nome,email);
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.inserir(pessoa);
		
	}
	public static void metodoconsultatodos() {
		List<Pessoa> registros = new PessoaDAO().consultaTodos();
		if (!registros.isEmpty()) {
			String saida = "";
			saida +="id\t|nome\t|email\n";
			for(int i = 0; i < registros.size(); i++) {
				Pessoa p = registros.get(i);
				saida +=p.getId() + "\t";
				saida = saida + p.getNome() + "\t";
				saida += p.getE_mail() + "\t\n";
			}
			JOptionPane.showMessageDialog(null, new JTextArea(saida));
		}
		else {
			System.out.println("Sem registos");
		}
	}
	
	public static void metodoExcluir() {
		String idStr = leString("Digite id para excluir");
		int id = Integer.parseInt(idStr);
		PessoaDAO dao = new PessoaDAO();
		if(dao.deletar(id)) {
			JOptionPane.showMessageDialog(null, "Registro " + id + " excluido");
		}
		else {
			JOptionPane.showMessageDialog(null, "Registro " + id + " não existe");
		}
		
	}
	public static void metodoExcluirPr() {
		String idStr = leString("Digite id para excluir");
		int id = Integer.parseInt(idStr);
		ProdutoDAO dao = new ProdutoDAO();
		if(dao.deletar(id)) {
			JOptionPane.showMessageDialog(null, "Registro " + id + " excluido");
		}
		else {
			JOptionPane.showMessageDialog(null, "Registro " + id + " não existe");
		}
		
	}
	public static Pessoa consultaId() {
		String idStr = leString("Digite id");
		int id = Integer.parseInt(idStr);
		PessoaDAO dao = new PessoaDAO();
		Pessoa pessoa = dao.consultar(id);
		return pessoa;
		
	}
	public static Produto consultaIdPr() {
		String idStr = leString("Digite id");
		int id = Integer.parseInt(idStr);
		ProdutoDAO dao = new ProdutoDAO();
		Produto produto = dao.consultar(id);
		return produto;
		
	}
	public static Produto consultaPlacaPr() {
		String placa = leString("Digite a placa");
		ProdutoDAO dao = new ProdutoDAO();
		Produto produto = dao.consultarPlaca(placa);
		return produto;
		
	}
	public static void atualizar(Pessoa p) {
		String nome1 = p.getNome();
		String email1 = p.getE_mail();
		String nome2 = leString("Alterar nome: " +nome1);
		String email2 = leString("Alterar email: " +email1);
		p.setNome(nome2);
		p.setE_mail(email2);
		PessoaDAO dao = new PessoaDAO();
		dao.atualizar(p);
	}
	public static void atualizarPr(Produto p) {
		String chassi1 = p.getChassi();
		String placa1 = p.getPlaca();
		String modelo1 = p.getModelo();
		String nome1 = p.getNome();
		double valor1 = p.getValor();
		String chassi2 = leString("Alterar numero do chassi: " +chassi1);
		String placa2 = leString("Alterar placa: " +placa1);
		String modelo2 = leString("Alterar modelo: " +modelo1);
		String nome2 = leString("Alterar nome: " +nome1);
		String valor2 = leString("Alterar placa: " +valor1);
		float valorCarro = Float.parseFloat(valor2);
		p.setChassi(chassi2);
		p.setPlaca(placa2);
		p.setModelo(modelo2);
		p.setNome(nome2);
		p.setValor(valorCarro);
		ProdutoDAO dao = new ProdutoDAO();
		dao.atualizar(p);
	}


	public static void main(String[] args) {
		int opcP;
		int opcPe;
		do {
			opcP = menuPrincipal();
			switch (opcP) {
			case 1:
				do {
					opcPe = menuPe();
					switch (opcPe){
						case 1:
							metodoInserirPe();
							break;
						case 2:
							metodoconsultatodos();
							break;
						case 3:
							Pessoa pessoa = consultaId();
							String saida = "";
							if (pessoa != null) {
								
								saida +="id\t|nome\t|email\n";
								
									saida +=pessoa.getId() + "\t";
									saida = saida + pessoa.getNome() + "\t";
									saida += pessoa.getE_mail() + "\t\n";
								}
								JOptionPane.showMessageDialog(null, new JTextArea(saida));
							break;
						case 4:
							metodoExcluir();
							break;
						case 5:
								Pessoa p = consultaId();
								if (p != null) {
									atualizar(p);
								}
							break;
							
						case 6:
							System.out.println("Saindo...");
							break;
						default:
							System.out.println("Opção inválida");
					}
				}while(opcPe != 6);
				break;
			case 2:
				do {
					opcPe = menuPr();
					switch (opcPe){
						case 1:
							metodoInserirPr();
							break;
						case 2:
							Produto produto = consultaIdPr();
							String saida = "";
							if (produto != null) {
								
								saida +="id\t|chassi\t|placa\t|modelo\t|nome\t|valor\n";
								
									saida +=produto.getId() + "\t";
									saida = saida + produto.getChassi() + "\t";
									saida += produto.getPlaca() + "\t";
									saida += produto.getModelo() + "\t";
									saida += produto.getNome() + "\t";
									saida += produto.getValor() + "\t\n";
								}
								JOptionPane.showMessageDialog(null, new JTextArea(saida));
							break;
						case 3:
							produto = consultaPlacaPr();
							saida = "";
							if (produto != null) {
								
								saida +="id\t|chassi\t|placa\t|modelo\t|nome\t|valor\n";
								
									saida +=produto.getId() + "\t";
									saida = saida + produto.getChassi() + "\t";
									saida += produto.getPlaca() + "\t";
									saida += produto.getModelo() + "\t";
									saida += produto.getNome() + "\t";
									saida += produto.getValor() + "\t\n";
								}
								JOptionPane.showMessageDialog(null, new JTextArea(saida));
							break;
						case 4:
							metodoExcluirPr();
							break;
						case 5:
							Produto p = consultaIdPr();
							if (p != null) {
								atualizarPr(p);
							}
							break;
							
						case 6:
							System.out.println("Saindo...");
							break;
						default:
							System.out.println("Opção inválida");
					}
				}while(opcPe != 6);
			case 3:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opção inválida");
				break;
			}
			
		} while (opcP != 3);
		
		
		
	}
	

}
