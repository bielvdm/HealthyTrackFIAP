package BO;

import java.util.List;

import DAO.UsuarioDAO;

/**
 * Classe registra e atualiza nome de usuario e id
 * 
 * @author lambateam
 * @version 1.0
 */

public class Usuario {

	/**
	 * Classe registra e atualiza nome de usuario e id
	 * 
	 * @author lambateam
	 * @version 1.0
	 */
	private int id;
	private String nome;
	private String email;
	private String senha;
	private long telefone;
	private float altura;
	private Alimentos alimentos;
	private AtividadeFisica atividade;
	private HistoricoPeso peso;
	private IntensidadeAtividade intensidade;
	private PressaoUsuario pressao;
	
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
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public long getTelefone() {
		return telefone;
	}
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public Alimentos getAlimentos() {
		return alimentos;
	}
	public void setAlimentos(Alimentos alimentos) {
		this.alimentos = alimentos;
	}
	public AtividadeFisica getAtividade() {
		return atividade;
	}
	public void setAtividade(AtividadeFisica atividade) {
		this.atividade = atividade;
	}
	public HistoricoPeso getPeso() {
		return peso;
	}
	public void setPeso(HistoricoPeso peso) {
		this.peso = peso;
	}
	public IntensidadeAtividade getIntensidade() {
		return intensidade;
	}
	public void setIntensidade(IntensidadeAtividade intensidade) {
		this.intensidade = intensidade;
	}
	public PressaoUsuario getPressao() {
		return pressao;
	}
	public void setPressao(PressaoUsuario pressao) {
		this.pressao = pressao;
	}
	
	public List<Usuario> visualizaUsuarios() {

		UsuarioDAO uDao = new UsuarioDAO();
		return uDao.Getall();
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", Nome=" + nome+ "]";
	}
	

}
