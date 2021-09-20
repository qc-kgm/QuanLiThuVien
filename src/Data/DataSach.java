package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Object.Sach;
import java.lang.Object;
public class DataSach {


	public static void insertSachData(Sach s) {
		PreparedStatement ps;
		ResultSet res;
		//String statement="insert into Sach values('?',N'?',N'?',N'?','?',?,N'?',?)";
		String sql="	merge into Sach  using ( select mas=?,tens=?,tacgia=?,nhaxb=?,namxb=?,dongia=?,tinhtrang=?,gioithieu=?) as s "
				+ "	on Sach.Masach_20183489=s.mas "
				+ "	when matched then  "
				+ "	update set Tensach_20183489=tens,Tacgia_20183489=tacgia,NhaXB_20183489=nhaxb, NamXB_20183489=namxb, Dongia_20183489=dongia, "
				+ "	Gioithieu_20183489=gioithieu, Tinhtrang_20183489=tinhtrang "
				+ "	when not matched then "
				+ "	insert values(mas,tens,tacgia,nhaxb,namxb,dongia,gioithieu,tinhtrang);";
		try {
			ps=Connectdtb.getConnection().prepareStatement(sql);
			ps.setString(1,s.getMasach());
			ps.setNString(2,s.getTensach());
			ps.setNString(3, s.getTacgia());
			ps.setNString(4,s.getNhaxb());
			ps.setDate(5, s.getNamxb());
			ps.setFloat(6, s.getDongia());
			ps.setBoolean(7, s.getTinhtrang());
			ps.setNString(8,s.getGioithieu());
			
			//setNString
			//ps.setString(7, s.getGioithieu());
			//ps.setBoolean(8, s.getTinhtrang());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error insert");
			JOptionPane.showMessageDialog(null, "Thêm/sửa sách thất bại","Error",JOptionPane.WARNING_MESSAGE);
		}
	}
	public static int insertlistsach(List<Sach>ls) {
		if(ls==null) return 0;
		else {
			for(int i=0;i<ls.size();i++) {
				Sach s=ls.get(i);
				insertSachData(s);
			}
		}
		return 1;
	}
	public static List<Sach> findSachData(String key,String value) {
		PreparedStatement ps;
		ResultSet res;
		List<Sach > listSach=new Vector<Sach>();
		String statement="select * from Sach where "+key +" like N'%"+value+"%'";
		try {
			ps=Connectdtb.getConnection().prepareStatement(statement);
			res=ps.executeQuery();//tra ve doi tuong result 
			while(res.next()) {
				Sach a=new Sach();
				a.setMasach(res.getString("Masach_20183489"));
				a.setTensach(res.getString("Tensach_20183489"));
				a.setTacgia(res.getString("Tacgia_20183489"));
				a.setNhaxb(res.getString("NhaXB_20183489"));
				a.setNamxb(res.getDate("NamXB_20183489"));
				a.setDongia(res.getFloat("Dongia_20183489"));
				a.setGioithieu(res.getString("Gioithieu_20183489"));
				a.setTinhtrang(res.getBoolean("Tinhtrang_20183489"));
				listSach.add(a);
			}
			ps.close();
			res.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listSach;
	}
	public static List<Sach> getListSach() {
		PreparedStatement ps;
		ResultSet res;
		List<Sach > listSach=new ArrayList<>();
		String statement="select * from Sach ";
		try {
			ps=Connectdtb.getConnection().prepareStatement(statement);
			res=ps.executeQuery();//tra ve doi tuong result 
			while(res.next()) {
				Sach a=new Sach();
				a.setMasach(res.getString("Masach_20183489"));
				a.setTensach(res.getString("Tensach_20183489"));
				a.setTacgia(res.getString("Tacgia_20183489"));
				a.setNhaxb(res.getString("NhaXB_20183489"));
				a.setNamxb(res.getDate("NamXB_20183489"));
				a.setDongia(res.getFloat("Dongia_20183489"));
				a.setGioithieu(res.getString("Gioithieu_20183489"));
				a.setTinhtrang(res.getBoolean("Tinhtrang_20183489"));
				listSach.add(a);
			}
			ps.close();
			res.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listSach;
	}
	
	public void editSachData(Sach s) {
		PreparedStatement ps;
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
			JOptionPane.showMessageDialog(null, "chinh sua thanh cong","Thong bao",2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "chinh sua khong thanh cong","Error",2);
		}
	}
	public void deleteSachData(String masach) {
		PreparedStatement ps;
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
	public static DefaultTableModel modelSach(List<Sach> listS,String []column) {
		DefaultTableModel model_sach = new DefaultTableModel();
		model_sach.setColumnIdentifiers(column);
		Sach s=null;
		Object []obj2 ;
		for(int i=0;i<listS.size();i++) {
			s=listS.get(i);
			obj2= new Object[column.length];
			obj2[0]=s.getMasach();
			obj2[1]=s.getTensach();
			obj2[2]=s.getTacgia();
			obj2[3]=s.getNamxb();
			obj2[4]=s.getNhaxb();
			obj2[5]=s.getDongia();
//			if(listS.get(i).getTinhtrang()==true) obj[6]="San sang";
//			else obj2[6]="Da cho thue";
			obj2[6]=s.getTinhtrang()?"Sẵn sàng" :"Đang cho thuê";
			obj2[7]=s.getGioithieu();
			model_sach.addRow(obj2);
		}
		return model_sach;
	}
	public static int deletesach(String masach) {
		int a=0;
		String sql="delete from Sach where Masach_20183489= '"+masach+"'";
		try {
			Statement stm=Connectdtb.getConnection().createStatement();
			stm.execute(sql);
			stm.close();
			a=1;
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Xóa sách thất bại !","Error",2);

		}
		return a;
	}
//	public void viewall() {
//		String statement="select * from Sach";
//		
//	}
}
