package Sistema.model.VO;

public class ClienteVO {
	private int id;
	private String nome;
	private long telefone;
	private String endereço;

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

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	public ClienteVO(int id, String nome, long telefone, String endereço) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.endereço = endereço;
	}

}
