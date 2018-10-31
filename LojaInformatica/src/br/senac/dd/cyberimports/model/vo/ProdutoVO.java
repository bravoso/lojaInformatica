package br.senac.dd.cyberimports.model.vo;

public class ProdutoVO {

	private int id;
	private String nome;
	private double custo;
	private double preco;
	private int quatidade;

	public ProdutoVO(int id, String nome, double custo, double preco, int quatidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.custo = custo;
		this.preco = preco;
		this.quatidade = quatidade;
	}

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

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuatidade() {
		return quatidade;
	}

	public void setQuatidade(int quatidade) {
		this.quatidade = quatidade;
	}

}
