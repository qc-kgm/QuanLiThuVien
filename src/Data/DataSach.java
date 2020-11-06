package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Object.Sach;
public class DataSach {
	public PreparedStatement ps;
	public ResultSet res;
	public void insertSachData(Sach s) {
		String statement="insert into Sach values('?',N'?',N'?',N'?','?',?,N'?',?)";
		try {
			ps=Connectdtb.getConnection().prepareStatement(statement);
			ps.setString(1,s.getMasach());
			ps.setString(2,s.getTensach());
			ps.setString(3, s.getTacgia());
			ps.setString(4,s.getNhaxb());
			ps.setDate(5, s.getNamxb());
			ps.setFloat(6, s.getDongia());
			ps.setString(7, s.getGioithieu());
			ps.setBoolean(8, s.getTinhtrang());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error insert");
		}
	}
	public void findSachData(String tensach,String masach,String tentg) {
		String statement="select * from Sach where Masach_20183489='?' or Tensach_20183489=N'?' or Tacgia_20183489 =N'?' ";
		try {
			ps=Connectdtb.getConnection().prepareStatement(statement);
			ps.setString(1, masach);
			ps.setString(2, tensach);
			ps.setString(3, tentg);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void editSachData(Sach s) {
		String statement="update Sach set Tensach_20183489=N'?', Tacgia_20183489 =N'?',NhaXB_20183489=N'?',NamXB_20183489='?',Dongia_20183489=?,Gioithieu_20183489=N'?',Tinhtrang_20183489=? where Masach_20183489='?' ";
		try {
			ps=Connectdtb.getConnection().prepareStatement(statement);
//			ps.setString(1,s.getMasach());
			ps.setString(2,s.getTensach());
			ps.setString(3, s.getTacgia());
			ps.setString(4,s.getNhaxb());
			ps.setDate(5, s.getNamxb());
			ps.setFloat(6, s.getDongia());
			ps.setString(7, s.getGioithieu());
			ps.setBoolean(8, s.getTinhtrang());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteSachData(String masach) {
		String statement="delete from Sach where Masach_20183489='?'";
		try {
			ps=Connectdtb.getConnection().prepareStatement(statement);
			ps.setString(1, masach);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
