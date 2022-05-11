package br.com.fiap.java.usuario;

import java.io.Serializable;

/**
 * Classe para registrar e atualizar informa��es de peso, altura, imc e genero
 * do usuario
 * 
 * @author lambdateam
 * @version 1.0
 */

public class Informacoes implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private double peso;
	private double altura;
	private double imc;
	private String genero;

	public Informacoes() {
		super();
	}

	public Informacoes(double peso, double altura, String genero ) {
		this.peso = peso;
		this.altura = altura;
		this.genero = genero;
		this.imc = peso / ((altura / 100) * (altura/ 100)) ;
	}

	/**
	 * Registra informações de peso, altura, imc e genero
	 * 
	 * @return informações de peso, altura, imc e genero
	 */
	public double getPeso() {
		return peso;
	}

	public double getAltura() {
		return altura;
	}

	public double getImc() {
		return imc;
	}

	public String getGenero() {
		return genero;
	}

	/**
	 * Atualiza informações de peso, altura, imc e genero
	 * 
	 * @param atualização de informações
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Informacoes [peso=" + peso + ", altura=" + altura + ", imc=" + imc + ", genero=" + genero + "]";
	}
}
