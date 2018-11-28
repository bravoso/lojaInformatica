package br.senac.dd.cyberimports.model.vo;

import java.sql.Date;

public class FaturaVO {
	
	private int id;
	private double valor;
	private Date data_compra;
	private String tipo;
	
	public FaturaVO() {
		super();
	}
	public FaturaVO(int id, double valor, Date data_compra, String tipo) {
		super();
		this.id = id;
		this.valor = valor;
		this.data_compra = data_compra;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Date getData_compra() {
		return data_compra;
	}
	public void setData_compra(Date data_compra) {
		this.data_compra = data_compra;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
