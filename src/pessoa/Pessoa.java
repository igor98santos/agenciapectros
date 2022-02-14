package pessoa;

public class Pessoa {
	private int id;
	private String nome;
	private String email;
	private String senha;
	
	
	public Pessoa(int id, String nome, String email, String senhaString) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senhaString;
	}
	public  Pessoa(){
		
	}
	public Pessoa(int int1, String string) {
		// TODO Auto-generated constructor stub
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senhaString) {
		this.senha = senhaString;
	}
	
	
}