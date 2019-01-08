package main.java.com.GDA.model.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.GDA.bean.Absence;
import main.java.com.GDA.bean.Departement;
import main.java.com.GDA.bean.Function;
import main.java.com.GDA.bean.User;
import main.java.com.GDA.utils.ConnectionDB;

public class UserDAO implements IUserDAO {

	@Override
	public User findUserByEmail(String email) throws SQLException {
		
		
		User u = new User();
		
		Connection conn = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultset = null;
		
		try {
			
			conn = ConnectionDB.getConnection();
			
			String query = "SELECT * FROM user WHERE email = ?";
			
			prepareStatement = conn.prepareStatement(query);
			
			prepareStatement.setString(1, email);
			
			resultset = prepareStatement.executeQuery();
			
			while (resultset.next()) {
				
//				u.setId(resultset.getInt("id"));
//				u.setFirstname(resultset.getString("firstname"));
//				u.setName(resultset.getString("name"));
				u.setEmail(resultset.getString("email"));
//				u.setPassword(resultset.getString("password"));
//				u.setDepartement((Departement) resultset.getObject("departement"));
//				u.setFunction((Function) resultset.getObject("function"));
//				u.setNbrDaysOfLeave(resultset.getInt("nbrDaysOfLeave"));
//				u.setNbrRTT(resultset.getInt("nbrRTT"));
//				u.setAbsences((ArrayList<Absence>) resultset.getObject("absences"));
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		finally {
			
			resultset.close();
			prepareStatement.close();
			conn.close();
			
		}
		
		return u;
	}

	@Override
	public User findUserById(int id) throws SQLException {
		
		User u = new User();
		
		Connection conn = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultset = null;
		
		try {
			
			conn = ConnectionDB.getConnection();
			
			String query = "SELECT * FROM user WHERE id = ?";
			
			prepareStatement = conn.prepareStatement(query);
			
			prepareStatement.setInt(1, id);
			
			resultset = prepareStatement.executeQuery();
			
			while (resultset.next()) {
				
				u.setId(resultset.getInt("id"));
				u.setFirstname(resultset.getString("firstname"));
				u.setName(resultset.getString("name"));
				u.setEmail(resultset.getString("email"));
				u.setPassword(resultset.getString("password"));
				u.setDepartement((Departement) resultset.getObject("departement"));
				u.setFunction((Function) resultset.getObject("function"));
				u.setNbrDaysOfLeave(resultset.getInt("nbrDaysOfLeave"));
				u.setNbrRTT(resultset.getInt("nbrRTT"));
				u.setAbsences((ArrayList<Absence>) resultset.getObject("absences"));
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		finally {
			
			resultset.close();
			prepareStatement.close();
			conn.close();
			
		}
		
		return u;
	}

	@Override
	public boolean isUserExist(String email) {
						
		Connection conn = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultset = null;
		boolean isAvailable = false;
		
		try {
			
			conn = ConnectionDB.getConnection();
			
			String query = "SELECT * FROM user WHERE email = ?";
			
			prepareStatement = conn.prepareStatement(query);
			
			prepareStatement.setString(1, email);
			
			resultset = prepareStatement.executeQuery();
			
			if(resultset.next()) {
				
				isAvailable = true;
				
			}else {
				
				isAvailable = false;
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		finally {
			
			try {
				if(conn != null) {
					resultset.close();
					prepareStatement.close();
					conn.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
		}
		
		
		return isAvailable;
	}

}
