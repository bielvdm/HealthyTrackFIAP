package BO;

import java.util.Date;
import java.util.List;

import DAO.PressaoUsuarioDAO;

public class PressaoUsuario {

	private int idPressao;
	private String pressaoArterial;
	private Date data;
	private int idUsuario;
	
	public int getIdPressao() {
		return idPressao;
	}
	public void setIdPressao(int idPressao) {
		this.idPressao = idPressao;
	}
	public String getPressaoArterial() {
		return pressaoArterial;
	}
	public void setPressaoArterial(String pressaoArterial) {
		this.pressaoArterial = pressaoArterial;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

	
	public int AdicionaPressao(PressaoUsuario obj) {
		PressaoUsuarioDAO aDao = new PressaoUsuarioDAO();
		return aDao.Add(obj);
	}

	public List<PressaoUsuario> VisualizaPressaoUsuario() {
		PressaoUsuarioDAO aDao = new PressaoUsuarioDAO();
		return aDao.Getall();
	}

	public PressaoUsuario SelecionaPressao(int id) {
		PressaoUsuarioDAO aDao = new PressaoUsuarioDAO();
		return aDao.GetById(id);
	}

	public int RemovePressaoUsuario(int id) {
		PressaoUsuarioDAO aDao = new PressaoUsuarioDAO();
		return aDao.Delete(id);
	}

	public int AtualizaPressaoUsuario() {
		PressaoUsuarioDAO aDao = new PressaoUsuarioDAO();
		return aDao.Update(this);
	}

	@Override
	public String toString() {
		return "PressaoUsuario [P_ID=" + idPressao + ", data=" + data + ", pressaoArterial=" + pressaoArterial
				+ ", idUsuario=" + idUsuario + "]";
	}	

}
