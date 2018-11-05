package br.senac.dd.cyberimports.model.vo;

public class ProdutoVO {

	private int id;
	private String nome;
	private double custo;
	private double preco;
	private int quantidade;

	public ProdutoVO() {
		super();
	}

	public ProdutoVO(int id, String nome, double custo, double preco, int quantidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.custo = custo;
		this.preco = preco;
		this.quantidade = quantidade;
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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
