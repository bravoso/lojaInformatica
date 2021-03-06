package br.senac.dd.cyberimports.model.vo;

public class ClienteVO {
	
	private int id;
	private String nome;
	private String cpf;
	private String telefone;
	private String enderešo;
	
	public ClienteVO(int id, String nome, String cpf, String telefone, String enderešo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.enderešo = enderešo;
	}
	
	public ClienteVO() {
		super();
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEnderešo() {
		return enderešo;
	}
	public void setEnderešo(String enderešo) {
		this.enderešo = enderešo;
	}

	
}
