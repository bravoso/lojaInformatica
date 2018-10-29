package Sistema.model.VO;

public class ClienteVO {
	private int id;
	private String nome;
	private long telefone;
	private String endere�o;

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

	public String getEndere�o() {
		return endere�o;
	}

	public void setEndere�o(String endere�o) {
		this.endere�o = endere�o;
	}

	public ClienteVO(int id, String nome, long telefone, String endere�o) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.endere�o = endere�o;
	}

}
