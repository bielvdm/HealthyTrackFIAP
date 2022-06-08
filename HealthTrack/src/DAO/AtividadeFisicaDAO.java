package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BO.AtividadeFisica;

public class AtividadeFisicaDAO implements IDataHandler<AtividadeFisica> {

	@Override
	public List<AtividadeFisica> Getall() {
		DAO dao = new DAO();
		List<AtividadeFisica> listAF = new ArrayList<AtividadeFisica>();
		PreparedStatement stmt;
		try {
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_ATIVIDADE_FISICA");
			ResultSet result = null;
			result = dao.GetData(stmt);
			while (result.next()) {
				AtividadeFisica af = new AtividadeFisica();
				af.setIdAtividade(result.getInt("ID_ATIVIDADE_FISICA"));
				af.setNome(result.getString("NOME_ATIVIDADE"));
				af.setTempo(result.getFloat("TEMPO_ATIVIDADE"));
				af.setData(result.getDate("DATA_ATIVIDADE"));
				listAF.add(af);
			}
			return listAF;
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public AtividadeFisica GetById(int id) {
		DAO dao = new DAO();
		PreparedStatement stmt;
		try {
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_ATIVIDADE_FISICA WHERE ID_ATIVIDADE_FISICA = ?");
			stmt.setInt(1, id);
			ResultSet result = null;
			result = dao.GetData(stmt);
			while (result.next()) {
				AtividadeFisica af = new AtividadeFisica();
				af.setNome(result.getString("NOME_ATIVIDADE"));
				af.setTempo(result.getFloat("TEMPO_ATIVIDADE"));
				af.setData(result.getDate("DATA_ATIVIDADE"));
				return af;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public int Add(AtividadeFisica obj) {
		DAO dao = new DAO();
		try {
			PreparedStatement stmt = dao.GetConnection()
					.prepareStatement("INSERT INTO T_ATIVIDADE_FISICA VALUES (?,?,?,?,?,?)");
			stmt.setInt(1, obj.getIdAtividade());
			stmt.setInt(2, obj.getIdIntensidade());
			stmt.setInt(3, obj.getIdUsuario());
			stmt.setString(4, obj.getNome());
			stmt.setFloat(5, obj.getTempo());
			stmt.setDate(6, new java.sql.Date(obj.getData().getTime()));
			return dao.ExecuteCommand(stmt);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int Delete(int id) {
		try {
			DAO dao = new DAO();
			PreparedStatement stmt = dao.GetConnection().prepareStatement("DELETE FROM T_ATIVIDADE_FISICA WHERE ID_ATIVIDADE_FISICA = ?");
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
	public int Update(AtividadeFisica obj) {
		try {
			DAO dao = new DAO();
			PreparedStatement stmt = dao.GetConnection()
					.prepareStatement("UPDATE T_ATIVIDADE_FISICA SET NOME_ATIVIDADE= ?, TEMPO_ATIVIDADE = ?, DATA_ATIVIDADE = ? WHERE ID_ATIVIDADE_FISICA = ?");
			stmt.setString(1, obj.getNome());
			stmt.setFloat(2, obj.getTempo());
			stmt.setDate(3, (Date) obj.getData());
			stmt.setInt(4, obj.getIdAtividade());
			return dao.ExecuteCommand(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
	}

}
