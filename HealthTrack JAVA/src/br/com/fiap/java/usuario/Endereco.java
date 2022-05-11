package br.com.fiap.java.usuario;

import java.io.Serializable;

/** Classe para registrar e atualizar endereço do usuário
 * 
 * 
 * @author lambdateam
 * @version 1.0
 */

public class Endereco extends Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private String rua;
	private String cidade;
	private String bairro;
	private String estado;
	private String pais;
	private String cep;

	public Endereco() {

	}
	
	public Endereco(String rua, String cidade, String bairro, String estado, String pais, String cep) {
		this.rua = rua;
		this.cidade = cidade;
		this.bairro = bairro;
		this.estado = estado;
		this.pais = pais;
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
}