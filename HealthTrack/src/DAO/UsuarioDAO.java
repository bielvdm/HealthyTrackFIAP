package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BO.Usuario;

public class UsuarioDAO implements IDataHandler<Usuario>{
    @Override
	public List<Usuario> Getall() {
		DAO dao = new DAO();
		List<Usuario> listU = new ArrayList<Usuario>();
		PreparedStatement stmt;
		try {
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_USUARIO");
			ResultSet result = null;
			result = dao.GetData(stmt);
			while (result.next()) {
				Usuario u = new Usuario();
                System.out.println(u);
				u.setId(result.getInt("ID_USUARIO"));
				u.setNome(result.getString("NOME_USUARIO"));
				u.setId(result.getInt("EMAIL_USUARIO"));
				u.setTelefone(result.getLong("NUMERO_USUARIO"));
				u.setAltura(result.getFloat("ALTURA_USUARIO"));
				listU.add(u);
			}
			return listU;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Usuario GetById(int id) {
		DAO dao = new DAO();
		PreparedStatement stmt;
		try {
			stmt = dao.GetConnection().prepareStatement("SELECT * FROM T_USUARIO WHERE ID_USUARIO = ?");
			stmt.setInt(1, id);
			ResultSet result = null;
			result = dao.GetData(stmt);
			while (result.next()) {
				Usuario u = new Usuario();
				u.setId(result.getInt("ID_USUARIO"));
				u.setNome(result.getString("NOME_USUARIO"));
				u.setId(result.getInt("EMAIL_USUARIO"));
				u.setTelefone(result.getLong("NUMERO_USUARIO"));
				u.setAltura(result.getFloat("ALTURA_USUARIO"));
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int Add(Usuario obj) {
		DAO dao = new DAO();
		try {
			PreparedStatement stmt = dao.GetConnection()
					.prepareStatement("INSERT INTO T_USUARIO VALUES (ID_USUARIO.NEXTVAL,?,?,?,?,?)");
			stmt.setString(1, obj.getNome());
			stmt.setString(2, obj.getEmail());
			stmt.setString(3, obj.getSenha());
			stmt.setLong(4, obj.getTelefone());
			stmt.setFloat(5, obj.getAltura());
			return dao.ExecuteCommand(stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int Delete(int id) {
		try {
			DAO dao = new DAO();
			PreparedStatement stmt = dao.GetConnection().prepareStatement("DELETE FROM T_USUARIO WHERE ID_USUARIO = ?");
			stmt.setInt(1, id);
			return dao.ExecuteCommand(stmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int Update(Usuario obj) {
		try {
			DAO dao = new DAO();
			PreparedStatement stmt = dao.GetConnection()
					.prepareStatement("UPDATE T_USUARIO SET NOME_USUARIO= ? WHERE ID_USUARIO = ?");
			stmt.setString(1, obj.getNome());
			stmt.setInt(2, obj.getId());
			return dao.ExecuteCommand(stmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
