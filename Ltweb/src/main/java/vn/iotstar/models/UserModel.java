package vn.iotstar.models;

import java.io.Serializable;
import java.util.Date;

import javax.xml.crypto.Data;

public class UserModel implements Serializable{
	private static final long serialVersionUID= 1L;
	
	//
	private int id;
	private String username;
	private String email;
	private String fullname;
	private String password;
	private String images;
	private int roleid;
	private String phone;
	private Date createDate;
	
	//tạo Contructor
	public UserModel() {
		super();
	}

	//Tạo getter and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", username=" + username + ", email=" + email + ", fullname=" + fullname
				+ ", password=" + password + ", images=" + images + ", roleid=" + roleid + ", phone=" + phone
				+ ", createDate=" + createDate + "]";
	}

}
