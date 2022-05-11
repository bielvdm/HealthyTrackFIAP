package br.com.fiap.java.usuario;

import java.io.Serializable;

/**
 * Classe registra e atualiza nome de usuario e id
 * 
 * @author lambateam
 * @version 1.0
 */

public class Usuario implements Serializable {

	/**
	 * Classe registra e atualiza nome de usuario e id
	 * 
	 * @author lambateam
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private int id;

	public Usuario() {

	}

	public Usuario(String nome, int id) {
		this.nome = nome;
		this.id = id;
	}

	/**
	 * Registra nome de usuario
	 * 
	 * @return nome de usuario
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Registra id do usuario
	 * 
	 * @return id do usuario
	 */
	public int getId() {
		return id;
	}

	/**
	 * Atualiza nome de usu�rio e id
	 * 
	 * @param nome que ser� atualizado
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setId(int id) {
		this.id = id;
	}

}
