package tourist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.catalina.connector.Response;

public class tourist {

	public static boolean login(long mob, String pass) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tourist","root","12345");
		Statement s=con.createStatement();
		ResultSet r=s.executeQuery("select mobile from signin");
		long mobile=0;
		String password="";
		while(r.next()) {
			mobile=r.getLong(1);
			if(mobile==mob) {
				break;
			}
		}
		if(mobile==mob) {
			r=s.executeQuery("select setpass from signin where mobile="+mob);
			if(r.next()) {
				password=r.getString(1);
			}
			if(password.equals(pass)) {
				
				return true;
			}else {
				return false;
			}
			
		}else {
			return false;
		}
		
	}
	public static void signin(String user, String email, long number, String pass)  throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tourist","root","12345");
		Statement s=con.createStatement();
		String a="insert into signin values('"+number+"','"+user+"','"+email+"','"+pass+"')";
		s.executeUpdate(a);
	
	}
	
}