import java.sql.*;

public class DB {
public static void main(String[] args) {
	String url ="jdbc:mysql://localhost:3306/?useSSL=false&user=root&password=dmlwls159";
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	try {
		Class.forName("com.mysql,jdbc.Driver");
		System.out.println("����̹� ���� ����");
		
		conn = DriverManager.getConnection(url);
		System.out.println("�����ͺ��̽� ���� ����");
	}
	catch(ClassNotFoundException cnfe) {
		cnfe.printStackTrace();
	}
	catch(SQLException se) {
		se.printStackTrace();
	}
	finally {
		if(conn!=null) try {conn.close();} catch(SQLException se) {}
		if(stmt!=null) try {stmt.close();} catch(SQLException se) {}
		if(rs!=null) try {rs.close();} catch(SQLException se) {}
	}
}
}
