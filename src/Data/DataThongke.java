package Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import Object.Chitietphieumuon;

public class DataThongke {
	public static int getSLSach() {
		String sql="select count(Masach_20183489) from Sach";
		try {
			Statement stm=Connectdtb.getConnection().createStatement();
			ResultSet res=stm.executeQuery(sql);
			res.next();
			int a=res.getInt(1);
			stm.close();
			res.close();
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		
	}
	public static int getSLThuthu() {
		String sql="select count(Ma_TT_20183489) from Thuthu";
		try {
			Statement stm=Connectdtb.getConnection().createStatement();
			ResultSet res=stm.executeQuery(sql);
			res.next();
			int a=res.getInt(1);
			stm.close();
			res.close();
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		
	}
	public static int getSLDocgia() {
		String sql="select count(Ma_DG_20183489) from Docgia";
		try {
			Statement stm=Connectdtb.getConnection().createStatement();
			ResultSet res=stm.executeQuery(sql);
			res.next();
			int a=res.getInt(1);
			stm.close();
			res.close();
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		
	}
	public static int getSLMuon(String s) {
		String sql="	select count(MaMT_20183489) from Muontra where Ngay_muon between '2010-01-01' and '"+s+"'";
		try {
			Statement stm=Connectdtb.getConnection().createStatement();
			ResultSet res=stm.executeQuery(sql);
			res.next();
			int a=res.getInt(1);
			stm.close();
			res.close();
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		
	}
	public static int getSLMuon2(String s,String q) {
		String sql="	select count(MaMT_20183489) from Muontra where Ngay_muon between '"+s+"' and '"+q+"'";
		try {
			Statement stm=Connectdtb.getConnection().createStatement();
			ResultSet res=stm.executeQuery(sql);
			res.next();
			int a=res.getInt(1);
			stm.close();
			res.close();
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		
	}
	public static int getSLSachMuon(String s,String q) {
		String sql="	select count(*) from Chitiet_Muon join Muontra on Chitiet_Muon.MaMT_20183489=Muontra.MaMT_20183489 where Ngay_muon between '"+s+"' and '"+q+"'";
		try {
			Statement stm=Connectdtb.getConnection().createStatement();
			ResultSet res=stm.executeQuery(sql);
			res.next();
			int a=res.getInt(1);
			stm.close();
			res.close();
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		
	}
	public static int[][] thongke1thang(int i,int q) {
		String sql="select count(MaMT_20183489) from Muontra where month(Ngay_muon)="+i+"and year(Ngay_muon)="+q;
		String sql2="select count(*) from Chitiet_Muon join Muontra on Chitiet_Muon.MaMT_20183489=Muontra.MaMT_20183489  "
				+ "	where month(Ngay_muon)="+i+"and year(Ngay_muon)="+q;
		int temp[][]=new int[1][3];
		try {
			temp[0][0]=i;
			Statement stm=Connectdtb.getConnection().createStatement();
			ResultSet res=stm.executeQuery(sql);
			res.next();
			temp[0][1]=res.getInt(1);
			res=stm.executeQuery(sql2);
			res.next();
			temp[0][2]=res.getInt(1);
			stm.close();
			res.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	public static int[][] thongke4thang(Date d) {
		int i=d.getMonth()+1;
		int q=d.getYear()+1900;
		int temp[][]=new int[4][3];
		for(int j=0;j<4;j++) {
			if(i==0) {
				i=12;
				q--;
			}
			temp[j][0]=i;
			int k[][]=thongke1thang(i,q);
			temp[j][1]=k[0][1];
			temp[j][2]=k[0][2];
			i--;
		}
		
		return temp;
	}
	public static int[][] thongke12thang(Date d) {
		int i=d.getMonth()+1;
		int q=d.getYear()+1900;
		int temp[][]=new int[12][3];
		for(int j=0;j<12;j++) {
			if(i==0) {
				i=12;
				q--;
			}
			temp[j][0]=i;
			int k[][]=thongke1thang(i,q);
			temp[j][1]=k[0][1];
			temp[j][2]=k[0][2];
			i--;
		}
		return temp;
		
	}
	public static DefaultTableModel gettablemodel(int[][]v,String[]columns,int j) {
		DefaultTableModel dtm=new DefaultTableModel();
		dtm.setColumnIdentifiers(columns);
		Object []obj;
		for(int i=0;i<j;i++) {
			obj=new Object[columns.length];
			obj[0]=v[i][0];
			obj[1]=v[i][1];
			obj[2]=v[i][2];
			dtm.addRow(obj);
		}
		return dtm;
	}
	public static DefaultTableModel gettablemodel2(String[]columns,int a,int b) {
		DefaultTableModel dtm=new DefaultTableModel();
		dtm.setColumnIdentifiers(columns);
		Object []obj;
			obj=new Object[columns.length];
			
			obj[1]=a;
			obj[2]=b;
			dtm.addRow(obj);
		return dtm;
	}
	
}
