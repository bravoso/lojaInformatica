package Sistema.model.VO;

public class ClienteVO {
	private int id;
	private String nome;
	private long telefone;
	private String enderešo;

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

	public String getEnderešo() {
		return enderešo;
	}

	public void setEnderešo(String enderešo) {
		this.enderešo = enderešo;
	}

	public ClienteVO(int id, String nome, long telefone, String enderešo) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.enderešo = enderešo;
	}

}
