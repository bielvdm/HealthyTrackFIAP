package br.com.fiap.java.usuario;

import java.io.Serializable;

/** Classe para registrar e atualizar telefone do usuário
 * 
 * 
 * @author lambdateam
 * @version 1.0
 */

public class Telefone extends Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	private long numeroTelefone;
	
	public Telefone() {
		
	}
	
	public Telefone(long numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public long getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(long numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}
}
