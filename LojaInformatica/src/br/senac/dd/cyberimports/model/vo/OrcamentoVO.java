package br.senac.dd.cyberimports.model.vo;

public class OrcamentoVO {

	private int id;
	private double valor;
	private String dt_orcamento;
	private String status_orcamento;
	private String vendedor;
	private String cliente;
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	private ProdutoVO[] produtos;
	private ServicoVO[] servicos;

	public OrcamentoVO(int id, double valor, String dt_orcamento, String status_orcamento, String vendedor,
			String cliente, ProdutoVO[] produtos, ServicoVO[] servicos) {
		super();
		this.id = id;
		this.valor = valor;
		this.dt_orcamento = dt_orcamento;
		this.status_orcamento = status_orcamento;
		this.vendedor = vendedor;
		this.cliente = cliente;
		this.produtos = produtos;
		this.servicos = servicos;
	}

	public OrcamentoVO() {
		super();
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

	public String getDt_orcamento() {
		return dt_orcamento;
	}

	public void setDt_orcamento(String dt_orcamento) {
		this.dt_orcamento = dt_orcamento;
	}

	public String getStatus_orcamento() {
		return status_orcamento;
	}

	public void setStatus_orcamento(String status_orcamento) {
		this.status_orcamento = status_orcamento;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
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
