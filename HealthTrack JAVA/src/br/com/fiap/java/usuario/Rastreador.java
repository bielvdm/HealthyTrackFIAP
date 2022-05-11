package br.com.fiap.java.usuario;

import java.io.Serializable;

public class Rastreador extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private float batimentos;
	private float kmCorridos;
	private float atividadeSemanal;

	public Rastreador() {
		super();
	}

	public Rastreador(float batimentos, float kmCorridos, float atividadeSemanal) {
		this.batimentos = batimentos;
		this.kmCorridos = kmCorridos;
		this.atividadeSemanal = atividadeSemanal;
	}

	public float getBatimentos() {
		return batimentos;
	}

	public float getKmCorridos() {
		return kmCorridos;
	}

	public float getAtividadeSemanal() {
		return atividadeSemanal;
	}

	public void setBatimentos(float batimentos) {
		this.batimentos = batimentos;
	}

	public void setKmCorridos(float kmCorridos) {
		this.kmCorridos = kmCorridos;
	}

	public void setAtividadeSemanal(float atividadeSemanal) {
		this.atividadeSemanal = atividadeSemanal;
	}

	@Override
	public String toString() {
		return "Rastreador resumido:  Batimentos=" + batimentos + " bpm, km Corridos=" + kmCorridos + " KM, Atividade Semanal="
				+ atividadeSemanal + " atividades por semana";
	}

}
