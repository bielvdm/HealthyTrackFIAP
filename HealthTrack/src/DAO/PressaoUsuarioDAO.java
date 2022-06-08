package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BO.PressaoUsuario;

public class PressaoUsuarioDAO implements IDataHandler<PressaoUsuario> {

	@Override
	public List<PressaoUsuario> Getall() {
		DAO dao = new DAO();
		List<PressaoUsuario> listA = new ArrayList<PressaoUsuario>();
		PreparedStatement stmt;
		try {
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_PRESSAO_USUARIO");
			ResultSet result = null;
			result = dao.GetData(stmt);
			while (result.next()) {
				PressaoUsuario a = new PressaoUsuario();
				a.setIdPressao(result.getInt("P_ID"));
				a.setPressaoArterial(result.getString("P_ARTERIAL"));
				a.setData(result.getDate("P_DATA_HORA"));
				listA.add(a);
			}
			return listA;
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public PressaoUsuario GetById(int id) {
		DAO dao = new DAO();
		PreparedStatement stmt;
		try {
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_PRES_USUARIO WHERE P_ID = ?");
			stmt.setInt(1, id);
			ResultSet result = null;
			result = dao.GetData(stmt);
			while (result.next()) {
				PressaoUsuario a = new PressaoUsuario();
				a.setPressaoArterial(result.getString("P_ARTERIAL"));
				a.setData(result.getDate("P_DATA_HORA"));
				return a;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int Update(PressaoUsuario obj) {
		try {
			DAO dao = new DAO();
			PreparedStatement stmt = dao.GetConnection()
					.prepareStatement("UPDATE T_PRES_USUARIO SET P_ARTERIAL= ?, P_DATA_HORA = ? WHERE P_ID = ?");
			stmt.setString(1, obj.getPressaoArterial());
			stmt.setDate(2, new java.sql.Date(obj.getData().getTime()));
			stmt.setInt(3, obj.getIdPressao());
			return dao.ExecuteCommand(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
	}	
	
	@Override
	public int Delete(int id) {
		try {
			DAO dao = new DAO();
			PreparedStatement stmt = dao.GetConnection().prepareStatement("DELETE FROM T_PRES_USUARIO WHERE P_ID = ?");
			stmt.setInt(1, id);
			return dao.ExecuteCommand(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Add(PressaoUsuario obj) { 
		DAO dao = new DAO();
		try {
			PreparedStatement stmt = dao.GetConnection()
					.prepareStatement("INSERT INTO T_PRES_USUARIO VALUES (?,?,?,?)");
			stmt.setInt(1, obj.getIdPressao());
			stmt.setInt(2, obj.getIdUsuario());
			stmt.setString(3, obj.getPressaoArterial());
			stmt.setDate(4, new java.sql.Date(obj.getData().getTime()));
			return dao.ExecuteCommand(stmt);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
