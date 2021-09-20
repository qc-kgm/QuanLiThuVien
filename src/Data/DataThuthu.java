package Data;
import Object.Thuthu;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;
public class DataThuthu {

	public static List<Thuthu> getListThuthu() {
		Statement ps;
		ResultSet res;
		String sql="select * from Thuthu";
		List<Thuthu> listTT=new ArrayList<>();
		try {
			ps=Connectdtb.getConnection().createStatement();
			res=ps.executeQuery(sql);
			while(res.next()) {
				Thuthu vd=new Thuthu();
				vd.setMathuthu(res.getString(1));
				vd.setHovaten(res.getString(2));
				vd.setGioitinh(res.getString(3));
				vd.setNgaysinh(res.getDate(4));
				vd.setSoCMND(res.getBigDecimal(5));
				vd.setEmail(res.getString(6));
				vd.setDienthoai(res.getString(7));
				listTT.add(vd);
			}
			ps.close();
			res.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("loi khi get thong tin thu thu");
		}
		return listTT;
	}
	public static List<Thuthu> getListThuthuFind(String a,String b) {
		PreparedStatement ps;
		ResultSet res;
		String sql="select * from Thuthu where "+a+" LIKE '%"+b+"%'";
		List<Thuthu> listTT=new ArrayList<>();
		try {
			ps=Connectdtb.getConnection().prepareStatement(sql);
//			ps.setString(1, a);
//			ps.setString(2, b);
			res=ps.executeQuery();
			while(res.next()) {
				Thuthu vd=new Thuthu();
				vd.setMathuthu(res.getString(1));
				vd.setHovaten(res.getString(2));
				vd.setGioitinh(res.getString(3));
				vd.setNgaysinh(res.getDate(4));
				vd.setSoCMND(res.getBigDecimal(5));
				vd.setEmail(res.getString(6));   
				vd.setDienthoai(res.getString(7));
				listTT.add(vd);
			}
			ps.close();
			res.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("loi khi get thong tin thu thu khi tim kiem");
			System.out.println(sql);
		}
		return listTT;
	}
	
	public static List<Thuthu> getListThuthuFindN(String a,String b) {
		PreparedStatement ps;
		ResultSet res;
		String sql="select * from Thuthu where "+a+" LIKE N'%"+b+"%'";
		List<Thuthu> listTT=new ArrayList<>();
		try {
			ps=Connectdtb.getConnection().prepareStatement(sql);
			res=ps.executeQuery();
			while(res.next()) {
				Thuthu vd=new Thuthu();
				vd.setMathuthu(res.getString(1));
				vd.setHovaten(res.getString(2));
				vd.setGioitinh(res.getString(3));
				vd.setNgaysinh(res.getDate(4));
				vd.setSoCMND(res.getBigDecimal(5));
				vd.setEmail(res.getString(6));
				vd.setDienthoai(res.getString(7));
				listTT.add(vd);
			}
			ps.close();
			res.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("loi khi get thong tin thu thu khi tim kiem");
			System.out.println(sql);
		}
		return listTT;
	}

	
	public static DefaultTableModel getmodelthuthu(List<Thuthu> listtt,String[]columnsTT) {
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(columnsTT);
		Object []obj;
		Thuthu tt=null;
		for(int i=0;i<listtt.size();i++) {
			tt=listtt.get(i);
			obj=new Object[columnsTT.length];
			obj[0]=tt.getMathuthu();
			obj[1]=tt.getHovaten();
			obj[2]=tt.getGioitinh();
			obj[3]=tt.getEmail();
			obj[4]=tt.getNgaysinh();
			obj[5]=tt.getSoCMND();
			obj[6]=tt.getDienthoai();
			model.addRow(obj);
		}
		return model;
	}
	public static int DeleteRow(String key) {
		String sql="delete from Thuthu where Ma_TT_20183489 = ?";
		PreparedStatement ps;
		int a=0;
		try {
			ps=Connectdtb.getConnection().prepareStatement(sql);
			ps.setString(1, key);
			ps.execute();
			ps.close();
			
			return a=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	public static int InsertorUpdateThuthu(Thuthu tt) {
//		String sql="insert into Thuthu(Ma_TT_20183489,Ten_TT_20183489,Gioitinh_20183489,Ngaysinh_20183489,CMND_20183489,Email_20183489,Dienthoai_20183489) "
//				+ "values(?,?,?,?,?,?,?) on duplicate key update Ma_TT_20183489 =values(Ma_TT_20183489), Ten_TT_20183489= values(Ten_TT_20183489),Gioitinh_20183489=values(Gioitinh_20183489),"
//				+ "Ngaysinh_20183489=values(Ngaysinh_20183489),CMND_20183489=values(CMND_20183489),Email_20183489=values(Email_20183489),Dienthoai_20183489=values(Dienthoai_20183489) ";
//		
		String sql2="	MERGE INTO Thuthu USING (SELECT matt=?,ht=?,gt=?,ns=?,cmnd=?, email=?,sdt=?) AS ne"
				+ "  ON Thuthu.Ma_TT_20183489 =ne.matt"
				+ "  WHEN MATCHED THEN UPDATE SET Ma_TT_20183489=matt,Ten_TT_20183489=ht,Gioitinh_20183489=gt,Ngaysinh_20183489=ns,"
				+ "	CMND_20183489=cmnd,Email_20183489=email,Dienthoai_20183489=sdt"
				+ "  WHEN NOT MATCHED THEN INSERT (Ma_TT_20183489,Ten_TT_20183489,Gioitinh_20183489,Ngaysinh_20183489,"
				+ "	CMND_20183489,Email_20183489,Dienthoai_20183489) VALUES (matt,ht,gt,ns,cmnd,email,sdt);";
		try {
			PreparedStatement ps=Connectdtb.getConnection().prepareStatement(sql2,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, tt.getMathuthu());
			ps.setNString(2, tt.getHovaten());
			ps.setNString(3, tt.getGioitinh());
			ps.setDate(4, tt.getNgaysinh());
			ps.setBigDecimal(5,tt.getSoCMND());
			ps.setString(6, tt.getEmail());
			ps.setString(7, tt.getDienthoai());
			ps.execute();
			ResultSet res=ps.getGeneratedKeys();
			int genkey=0;
			if(res.next()) {
				genkey=1;
			}
			ps.close();
			return genkey;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public static  int insertlistthuthu(List<Thuthu> ls) {
		if(ls ==null) return 0;
		else {
			for(int i=0;i<ls.size();i++) {
				Thuthu ex=ls.get(i);
				InsertorUpdateThuthu(ex);
			}
			return 1;
			
		}
		
	}
	
}
