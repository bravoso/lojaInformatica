package br.senac.dd.cyberimports.model.vo;

public class ServicoVO {

	private String Nome;
	private int ID;
	private double Valor;

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public double getValor() {
		return Valor;
	}

	public void setValor(double valor) {
		Valor = valor;
	}

	public ServicoVO(String nome, int iD, double valor) {
		super();
		Nome = nome;
		ID = iD;
		Valor = valor;
	}

}
