package com.userdao;

import java.sql.*;
import java.util.*;

import com.user.pojo.Pojo;

public class UserDao {

	public static boolean insertUser(Pojo pj) throws ClassNotFoundException, SQLException {
		Connection con = DBConnect.getConnect();
		String INSERT_USER = "INSERT INTO user(Name, Email, Contact) values(?,?,?)";
		PreparedStatement pst = con.prepareStatement(INSERT_USER);
		pst.setString(1, pj.getName());
		pst.setString(2, pj.getEmail());
		pst.setString(3, pj.getContact());

		int status = pst.executeUpdate();

		if(status > 0) {
			return true;
		}
		return false;
	}

	public static boolean updateUser(Pojo pj) throws ClassNotFoundException, SQLException {
		Connection con = DBConnect.getConnect();
		String UPDATE_USER = "UPDATE user SET Name=?,Email=?,Contact=? where Id = "+pj.getId();
		PreparedStatement pst = con.prepareStatement(UPDATE_USER);
		pst.setString(1, pj.getName());
		pst.setString(2, pj.getEmail());
		pst.setString(3, pj.getContact());

		int status = pst.executeUpdate();

		if(status > 0) {
			return true;
		}

		return false;
	}

	public static boolean deleteUser(int Id) throws ClassNotFoundException, SQLException {
		Connection con = DBConnect.getConnect();
		String DELETE_USER = "DELETE FROM user where id = ?";
		PreparedStatement pst = con.prepareStatement(DELETE_USER);
		pst.setInt(1, Id);

		int status = pst.executeUpdate();

		if(status > 0) {
			return true;
		}
		return false;
	}
	
	public static Pojo selectByID(int id) throws ClassNotFoundException, SQLException {
		Connection con = DBConnect.getConnect();
		String SELECT_ID = "SELECT Name,EMail,Contact FROM user where Id = ?";
		PreparedStatement pst = con.prepareStatement(SELECT_ID);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		Pojo pj = new Pojo();
		while(rs.next()) {
			pj.setName(rs.getString("Name"));
			pj.setEmail(rs.getString("Email"));
			pj.setContact(rs.getString("Contact"));
		}
		return pj;
	}
	
	public static List<Pojo> selectAll() throws ClassNotFoundException, SQLException {
		Connection con = DBConnect.getConnect();
		String SELECT_ALL = "SELECT * from user";
		PreparedStatement pst = con.prepareStatement(SELECT_ALL);
		ResultSet rs = pst.executeQuery();
		List<Pojo> list = new ArrayList();
		while(rs.next()) {
			list.add(new Pojo(rs.getInt("Id"),rs.getString("Name"),rs.getString("Email"),rs.getString("Contact")));
		}
		return list;
	}
}
