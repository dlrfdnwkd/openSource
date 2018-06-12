import java.sql.*;

public class DB {
public static void main(String[] args) {
	String url ="jdbc:mysql://127.0.0.1/?serverTimezone=UTC&verifyServerCertificate=false&useSSL=true&user=root&password=dmlwls159";
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("----------");
		
		conn = DriverManager.getConnection(url);
		System.out.println("과소비판별");
		
		stmt =conn.createStatement();
		String useopensourcedb = "use opensourcedb";
		stmt.executeUpdate(useopensourcedb);
		
		String show과소비판별 = "select * from 과소비판별";
		rs = stmt.executeQuery(show과소비판별);
		while(rs.next()) {
			System.out.printf("%-5s\t",rs.getString(1));
			System.out.printf("%-5s\t",rs.getString(2));
			System.out.printf("%-5s\t",rs.getString(3));
			System.out.printf("%-5s\t",rs.getString(4));
			System.out.printf("%-5s\t",rs.getString(5));
			System.out.printf("%-5s\t",rs.getString(6));
			
		}
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
