package br.senac.dd.cyberimports.model.vo;

import java.sql.Date;

public class OrcamentoVO {
	
	private double valor;
	private Date dt_orcamento;
	private int status_orcamento;
	private VendedorVO vendedor;
	private ClienteVO cliente;
	private ProdutoVO[] produtos;
	private ServicoVO[] servicos;
	
	public OrcamentoVO(double valor, Date dt_orcamento, int status_orcamento, VendedorVO vendedor, ClienteVO cliente,
			ProdutoVO[] produtos, ServicoVO[] servicos) {
		super();
		this.valor = valor;
		this.dt_orcamento = dt_orcamento;
		this.status_orcamento = status_orcamento;
		this.vendedor = vendedor;
		this.cliente = cliente;
		this.produtos = produtos;
		this.servicos = servicos;
	}
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Date getDt_orcamento() {
		return dt_orcamento;
	}
	public void setDt_orcamento(Date dt_orcamento) {
		this.dt_orcamento = dt_orcamento;
	}
	public int getStatus_orcamento() {
		return status_orcamento;
	}
	public void setStatus_orcamento(int status_orcamento) {
		this.status_orcamento = status_orcamento;
	}
	public VendedorVO getVendedor() {
		return vendedor;
	}
	public void setVendedor(VendedorVO vendedor) {
		this.vendedor = vendedor;
	}
	public ClienteVO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}
	public ProdutoVO[] getProdutos() {
		return produtos;
	}
	public void setProdutos(ProdutoVO[] produtos) {
		this.produtos = produtos;
	}
	public ServicoVO[] getServicos() {
		return servicos;
	}
	public void setServicos(ServicoVO[] servicos) {
		this.servicos = servicos;
	}
	
	
	

}
