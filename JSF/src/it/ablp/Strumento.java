package it.ablp;

public class Strumento {

// === Properties ============================================================
private String nome;
private String nomed;

// === Methods ===============================================================

	public Strumento() {
		nome=null;
		nomed=null;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNomed(String nomed) {
		this.nomed = nomed;
	}

	public String getNomed() {
		return this.nomed;

	}
}
