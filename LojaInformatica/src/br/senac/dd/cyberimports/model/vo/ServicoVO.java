package br.senac.dd.cyberimports.model.vo;

public class ServicoVO {

	private String nome;
	private double valor;
	private String descricao;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ServicoVO(String nome, double valor, String descricao, int id) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.descricao = descricao;
		this.id = id;
	}
	public ServicoVO(String nome, double valor, String descricao) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.descricao = descricao;
	}
	public ServicoVO() {
		super();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}