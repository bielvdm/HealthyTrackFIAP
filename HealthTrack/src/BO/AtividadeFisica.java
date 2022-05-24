package BO;

import java.util.Date;
import java.util.List;

import DAO.AtividadeFisicaDAO;

public class AtividadeFisica {

	private int idAtividade;
	private int IdIntensidade;
	private int IdUsuario;
	private String nome;
	private float tempo;
	private Date data;
	
	public int getIdAtividade() {
		return idAtividade;
	}
	public void setIdAtividade(int idAtividade) {
		this.idAtividade = idAtividade;
	}
	public int getIdIntensidade() {
		return IdIntensidade;
	}
	public void setIdIntensidade(int idIntensidade) {
		IdIntensidade = idIntensidade;
	}
	public int getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getTempo() {
		return tempo;
	}
	public void setTempo(float tempo) {
		this.tempo = tempo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	public int AdicionaAtividade(AtividadeFisica obj) {
		AtividadeFisicaDAO afDao = new AtividadeFisicaDAO();
		return afDao.Add(obj);
	}
	
	public List<AtividadeFisica> VisualizaAtividade() {

		AtividadeFisicaDAO afDao = new AtividadeFisicaDAO();
		return afDao.Getall();
	}
	
	public AtividadeFisica SelecionaAtividade(int id) {
		AtividadeFisicaDAO afDao = new AtividadeFisicaDAO();
		return afDao.GetById(id);
	}
	
	public int RemoveAtividade(int id) {
		AtividadeFisicaDAO afDao = new AtividadeFisicaDAO();
		return afDao.Delete(id);
	}

	public int AtualizaAtividade() {
		AtividadeFisicaDAO afDao = new AtividadeFisicaDAO();
		return afDao.Update(this);
	}
	@Override
	public String toString() {
		return "AtividadeFisica [idAtividade=" + idAtividade + ", nome=" + nome + ", tempo=" + tempo + ", data=" + data
				+ "]";
	}
	
	
}
