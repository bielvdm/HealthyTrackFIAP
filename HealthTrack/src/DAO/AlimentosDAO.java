package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BO.Alimentos;

public class AlimentosDAO implements IDataHandler<Alimentos> {

	@Override
	public List<Alimentos> Getall() {
		DAO dao = new DAO();
		List<Alimentos> listA = new ArrayList<Alimentos>();
		PreparedStatement stmt;
		try {
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_ALIMENTOS");
			ResultSet result = null;
			result = dao.GetData(stmt);
			while (result.next()) {
				Alimentos a = new Alimentos();
				a.setIdAlimentos(result.getInt("ID_ALIMENTO"));
				a.setNome(result.getString("NOME_ALIMENTOS"));
				a.setQntAlimentos(result.getFloat("QNT_ALIMENTOS"));
				listA.add(a);
			}
			return listA;
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public Alimentos GetById(int id) {
		DAO dao = new DAO();
		PreparedStatement stmt;
		try {
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_ALIMENTOS WHERE ID_ALIMENTO = ?");
			stmt.setInt(1, id);
			ResultSet result = null;
			result = dao.GetData(stmt);
			while (result.next()) {
				Alimentos a = new Alimentos();
				a.setNome(result.getString("NOME_ALIMENTOS"));
				a.setQntAlimentos(result.getFloat("QNT_ALIMENTOS"));
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
	public int Update(Alimentos obj) {
		try {
			DAO dao = new DAO();
			PreparedStatement stmt = dao.GetConnection()
					.prepareStatement("UPDATE T_ALIMENTOS SET NOME_ALIMENTOS= ?, QNT_ALIMENTOS = ? WHERE ID_ALIMENTO = ?");
			stmt.setString(1, obj.getNome());
			stmt.setFloat(2, obj.getQntAlimentos());
			stmt.setInt(3, obj.getIdAlimentos());
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
			PreparedStatement stmt = dao.GetConnection().prepareStatement("DELETE FROM T_ALIMENTOS WHERE ID_ALIMENTO = ?");
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
	public int Add(Alimentos obj) { 
		DAO dao = new DAO();
		try {
			PreparedStatement stmt = dao.GetConnection()
					.prepareStatement("INSERT INTO T_ALIMENTOS VALUES (?,?,?,?)");
			stmt.setInt(1, obj.getIdAlimentos());
			stmt.setInt(2, obj.getIdUsuario());
			stmt.setString(3, obj.getNome());
			stmt.setFloat(4, obj.getQntAlimentos());
			return dao.ExecuteCommand(stmt);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
