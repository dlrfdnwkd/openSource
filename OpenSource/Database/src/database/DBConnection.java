package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBConnection {

	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public DBConnection() {
		try
		{
			Class.forName("co.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql//localhost:3306/OpenSource","root","dmlwls159");
			st =con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println("�����ͺ��̽� ���� ����" +e.getLocalizedMessage());
		}
	}
	public boolean isAdmin(String adminID, String adminPassword) {
		try
		{
			String SQL= "SELECT * FROM ADMIN WHERE adminID = '" +adminID + "' and adminPassword ='"+ adminPassword + "'";
			rs = st.executeQuery(SQL);
			if(rs.next())
			{
				return true;
			}
		}
		catch(Exception e)
		{
			System.out.println("�����ͺ��̽� �˻� ����:"+e.getMessage());
		}
		return false;
		}
	}

