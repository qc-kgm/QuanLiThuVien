package Data;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
//import com.sun.jdi.connect.spi.Connection;
public class Connectdtb {
//	private static Connection connect ;
	public static Connection connect ;
	public static Connection getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connect=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QuanLiThuVien","sa","1234");
			System.out.println("ket noi database   ok  ------------------------------------------------------------");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Loi ket noi database ------------------------------------------------------------");
		}
		return connect;
	}
	//public static Statement stt;
//	public static ResultSet displaydata()  {
//		try {
//			stt=connect.createStatement();
//		
//		String sqlstatement="Select * from Sach";
//		ResultSet res=stt.executeQuery(sqlstatement);
//		System.out.println("okkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
//		while(res.next()) {
//			System.out.println(res.getString(1)+"\t"+res.getString(2)+"\t"+res.getString(3)+"\t"+res.getString(4)+"\t"+res.getString(5)+"\t"+res.getString(6)+"\t"+res.getString(7)+"\t"+res.getString(7)+"\t"+res.getString(8));
//			
//		}
//		return res;
//		}
//	catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		System.out.println("errorrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
//	
//	}
//		
//	}
	

}
