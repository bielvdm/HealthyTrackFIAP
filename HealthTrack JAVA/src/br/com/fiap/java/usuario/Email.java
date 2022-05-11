package br.com.fiap.java.usuario;

import java.io.Serializable;

/** Classe para registrar e atualizar email do usuário
 * 
 * 
 * @author lambdateam
 * @version 1.0
 */

public class Email extends Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	private String enderecoEmail;
	
	public Email() {
		
	}
	
	public Email(String enderecoEmail) {
		this.enderecoEmail = enderecoEmail;
	}

	public String getEnderecoEmail() {
		return enderecoEmail;
	}

	public void setEnderecoEmail(String enderecoEmail) {
		this.enderecoEmail = enderecoEmail;
	}
}
