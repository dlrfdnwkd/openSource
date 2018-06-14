package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.sql.*;



public class Main extends Application {
	
	public static Stage parentWindow;

	@Override
	public void start(Stage primaryStage) throws Exception{
			parentWindow = primaryStage;
			Parent login = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
			Scene loginscene = new Scene(login);
			primaryStage.setScene(loginscene);
			primaryStage.setTitle("신호등 가계부");
			primaryStage.getIcons().add(new Image("file:image/신호등.png"));
			primaryStage.show();
	}

	public static void main(String[] args) {
		/*String url ="jdbc:mysql://127.0.0.1/?serverTimezone=UTC&verifyServerCertificate=false&useSSL=true&user=root&password=dmlwls159";
		   Connection conn=null;
		   Statement stmt=null;
		   ResultSet rs=null;
		   try {
		      Class.forName("com.mysql.cj.jdbc.Driver");
		      System.out.println("드라이버 연결성공");
		      
		      conn = DriverManager.getConnection(url);
		      System.out.println("데이터베이스 연동성공");
		      
		      stmt =conn.createStatement();
		      String useopensourcedb = "use opensourcedb";
		      stmt.executeUpdate(useopensourcedb);
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
		   }*/
		launch(args);
	}
}
