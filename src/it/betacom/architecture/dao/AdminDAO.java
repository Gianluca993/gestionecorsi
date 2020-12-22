package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.betacom.architecture.dao.adapter.AdapterAdminDAO;
import it.betacom.business.model.Admin;

public class AdminDAO extends AdapterAdminDAO {
	
	public static AdminDAO getFactory() throws SQLException {
		return new AdminDAO();
	}
	
	@Override
	public Admin getById(Connection conn, long id) throws SQLException {
		Admin admin = null;
		PreparedStatement ps;
		ps = conn.prepareStatement("select * from admin where id_admin = ?");
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			admin = new Admin();
			admin.setIdAdmin(rs.getLong(1));
			admin.setNomeAdmin(rs.getString(2));
			admin.setCognomeAdmin(rs.getString(3));
		}
		return admin;
}

}