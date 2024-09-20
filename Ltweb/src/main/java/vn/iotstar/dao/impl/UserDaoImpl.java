package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectionSQLServer;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.UserModel;

public class UserDaoImpl implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public UserModel findByUsername(String username) {
		String sql = "select * from users where username = ? ";
		try {
			Connection conn = new DBConnectionSQLServer().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			UserModel user = new UserModel();
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("image"));
				user.setRoleid(rs.getInt("roleid"));
				user.setPhone(rs.getString("phone"));
				user.setCreateDate(rs.getDate("createDate"));
			}
			return user;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public UserModel findById(int id) {
		String sql = "select * from users where id = ? ";
		try {
			Connection conn = new DBConnectionSQLServer().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			UserModel user = new UserModel();
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("image"));
				user.setRoleid(rs.getInt("roleid"));
				user.setPhone(rs.getString("phone"));
				user.setCreateDate(rs.getDate("createDate"));
			}
			return user;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<UserModel> findAll() {
		String sql = "select * from users";
		try {
			Connection conn = new DBConnectionSQLServer().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<UserModel> list = new ArrayList<UserModel>();
			while (rs.next()) {
				list.add(new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("email"),
						rs.getString("fullname"), rs.getString("password"), rs.getString("image"), rs.getInt("roleid"),
						rs.getString("phone"), rs.getDate("createDate")));
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO [users](email, username, fullname, password, image, roleid, phone, createdate) VALUES (?,?,?,?,?,?,?,?)";
		try {
			Connection conn = new DBConnectionSQLServer().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getFullname());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getImages());
			ps.setInt(6, user.getRoleid());
			ps.setString(7, user.getPhone());
			ps.setDate(8, (Date) user.getCreateDate());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		try {
			IUserDao userDao = new UserDaoImpl();
			System.out.println(userDao.findByUsername("khoi"));
			System.out.println(userDao.findById(1));
			System.out.println(userDao.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(UserModel user) {
		String sql = "UPDATE [users] set email = ?, fullname = ?, password = ?, image = ?, roleid = ?, phone = ?, createdate = ? where username = ?";
		try {
			Connection conn = new DBConnectionSQLServer().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(8, user.getUsername());
			ps.setString(2, user.getFullname());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getImages());
			ps.setInt(5, user.getRoleid());
			ps.setString(6, user.getPhone());
			ps.setDate(7, (Date) user.getCreateDate());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String query = "select * from [users] where email = ?";
		try {
			Connection conn = new DBConnectionSQLServer().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "select * from [users] where username = ?";
		try {
			Connection conn = new DBConnectionSQLServer().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return false;
	}
}
