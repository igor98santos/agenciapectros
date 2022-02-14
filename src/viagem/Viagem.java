package viagem;

import java.sql.Date;

public class Viagem {
	private Date ida;
	private Date volta;
	private String origem;
	private String destino;

	public Viagem(Date ida, Date volta, String origem, String destino) {
	
		this.ida = ida;
		this.volta = volta;
		this.origem = origem;
		this.destino = destino;
	}
	
	public Viagem(Date ida, String origem, String destino) {
		this.ida = ida;
		this.origem = origem;
		this.destino = destino;
	}

	public Date getIda() {
		return ida;
	}

	public void setIda(Date ida) {
		this.ida = ida;
	}

	public Date getVolta() {
		return volta;
	}

	public void setVolta(Date volta) {
		this.volta = volta;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

}
