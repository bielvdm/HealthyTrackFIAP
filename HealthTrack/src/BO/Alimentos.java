package BO;

import java.util.List;

import DAO.AlimentosDAO;

public class Alimentos {

	private int idAlimentos;
	private String nome;
	private float qntAlimentos;
	private int idUsuario;
	
	public int getIdAlimentos() {
		return idAlimentos;
	}
	public void setIdAlimentos(int idAlimentos) {
		this.idAlimentos = idAlimentos;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getQntAlimentos() {
		return qntAlimentos;
	}
	public void setQntAlimentos(float qntAlimentos) {
		this.qntAlimentos = qntAlimentos;
	}	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public int AdicionaAlimentos(Alimentos obj) {
		AlimentosDAO aDao = new AlimentosDAO();
		return aDao.Add(obj);
	}
	
	public List<Alimentos> VisualizaAlimentos() {

		AlimentosDAO aDao = new AlimentosDAO();
		return aDao.Getall();
	}
	
	public Alimentos SelecionaAlimentos(int id) {
		AlimentosDAO aDao = new AlimentosDAO();
		return aDao.GetById(id);
	}
	
	public int RemoveAlimentos(int id) {
		AlimentosDAO aDao = new AlimentosDAO();
		return aDao.Delete(id);
	}

	public int AtualizaAlimentos() {
		AlimentosDAO aDao = new AlimentosDAO();
		return aDao.Update(this);
	}
	@Override
	public String toString() {
		return "Alimentos [idAlimentos=" + idAlimentos + ", nome=" + nome + ", qntAlimentos=" + qntAlimentos
				+ ", idUsuario=" + idUsuario + "]";
	}	
}
