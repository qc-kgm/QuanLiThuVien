package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Object.Chitietphieumuon;
import Object.Phieumuontra;
import Object.Thuthu;

public class Datamuontra {
	public static List<String> getlistsachmuon(String a) {
		String sql="select Masach_20183489 from Chitiet_Muon where MaMT_20183489 = '"+a+"'";
		List<String> listsach=new ArrayList<>();
		try {
			Statement stm=Connectdtb.getConnection().createStatement();
			ResultSet res=stm.executeQuery(sql);
			while(res.next()) {
				String s=res.getString(1);
				listsach.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listsach;
	}
	public static List<Phieumuontra> getlistphieumuon(){
		String sql="select * from Muontra order by Ngay_muon asc";
		List<Phieumuontra> list_mt=new ArrayList<>();
		try {
			Statement stm=Connectdtb.getConnection().createStatement();
			ResultSet res=stm.executeQuery(sql);
			while(res.next()) {
				Phieumuontra mt=new Phieumuontra();
				mt.setMa_mt(res.getInt(1));
				mt.setMa_dg(res.getInt(2));
				mt.setMa_tt(res.getString(3));
				mt.setNgaymuon(res.getDate(4));
				mt.setNgayhentra(res.getDate(5));
				mt.setTiencoc(res.getFloat(6));
				list_mt.add(mt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list_mt;
	}
	public static List<Chitietphieumuon> getlistchitiet(int a){
		String sql="select * from Chitiet_Muon where MaMT_20183489 ="+a;
		List<Chitietphieumuon> list_ct=new ArrayList<>();
		try {
			Statement stm=Connectdtb.getConnection().createStatement();
			ResultSet res=stm.executeQuery(sql);
			while(res.next()) {
				Chitietphieumuon mt=new Chitietphieumuon();
				mt.setMa_mt(res.getInt(1));
				mt.setMasach(res.getString(2));
				mt.setGhichu(res.getString(5));
				mt.setNgaytra(res.getDate(3));
				mt.setTienphat(res.getFloat(4));
				list_ct.add(mt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list_ct;
	}
	public static DefaultTableModel getmodelphieumuon(List<Phieumuontra> listmt,String []columns){
		DefaultTableModel dtm=new DefaultTableModel();
		dtm.setColumnIdentifiers(columns);
		Object []obj;
		for(int i=0;i<listmt.size();i++) {
			Phieumuontra vd=listmt.get(i);
			obj=new Object[columns.length];
			obj[0]=vd.getMa_mt();
			obj[1]=vd.getMa_dg();
			obj[2]=vd.getMa_tt();
			obj[3]=vd.getNgaymuon();
			obj[4]=vd.getNgayhentra();
			obj[5]=vd.getTiencoc();
			dtm.addRow(obj);
		}
		return dtm;
	}
	public static DefaultTableModel getmodelchitietmuon(List<Chitietphieumuon> listct,String []columns){
		DefaultTableModel dtm=new DefaultTableModel();
		dtm.setColumnIdentifiers(columns);
		Object []obj;
		for(int i=0;i<listct.size();i++) {
			Chitietphieumuon vd=listct.get(i);
			obj=new Object[columns.length];
			obj[0]=vd.getMa_mt();
			obj[1]=vd.getMasach();
			obj[2]=vd.getNgaytra();
			obj[3]=vd.getTienphat();
			obj[4]=vd.getGhichu();
			dtm.addRow(obj);
		}
		return dtm;
	}
	public static int insertorupdatephieu(Phieumuontra ex) {
		String sql="	merge into Muontra using ( select mamt=?,madg=?,matt=?,ngaymuon=?,ngayht=?,tiencoc=? ) as ne on Muontra.MaMT_20183489=ne.mamt "
				+ "	when matched then  "
				+ "	update set Ma_DG_20183489=madg,Ma_TT_20183489=matt,Ngay_muon=ngaymuon,Ngay_hentra=ngayht, "
				+ "	Tiencoc_20183489=tiencoc "
				+ "	when not matched then insert  values(madg,matt,ngaymuon,ngayht,tiencoc);";
		try {
			PreparedStatement ps=Connectdtb.getConnection().prepareStatement(sql);
			ps.setInt(1,ex.getMa_mt());
			ps.setInt(2,ex.getMa_dg());
			ps.setString(3,ex.getMa_tt());
			ps.setDate(4, ex.getNgaymuon());
			ps.setDate(5,ex.getNgayhentra());
			ps.setFloat(6, ex.getTiencoc());
			ps.execute();
			ps.close();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Thêm/sửa phiếu mượn thất bại","Error",JOptionPane.WARNING_MESSAGE);
		}
		return 0;
	}
	public static  int insertlistPMT(List<Phieumuontra> ls) {
		if(ls ==null) return 0;
		else {
			for(int i=0;i<ls.size();i++) {
				Phieumuontra ex=ls.get(i);
				insertorupdatephieu(ex);
			}
			return 1;
			
		}
		
	}
	public static int insertorupdatechitietmuon(Chitietphieumuon ex) {
		String sql="	merge into Chitiet_Muon using ( select mamt=?,masach=?,ngaytra=?,tienphat=?,ghichu=? ) as ne on Chitiet_Muon.MaMT_20183489=ne.mamt  and Chitiet_Muon.Masach_20183489=ne.masach "
				+ "	when matched then  "
				+ "	update set MaMT_20183489=mamt,Masach_20183489=masach,Ngay_tra_20183489=ngaytra, "
				+ "	Tien_phat_20183489=tienphat ,Ghichu_20183489=ghichu "
				+ "	when not matched then insert  values(mamt,masach,ngaytra,tienphat,ghichu);";
		try {
			PreparedStatement ps=Connectdtb.getConnection().prepareStatement(sql);
			ps.setInt(1,ex.getMa_mt());
			ps.setString(2,ex.getMasach());
			ps.setNString(5, ex.getGhichu());
			ps.setDate(3, ex.getNgaytra());
//			ps.setBoolean(4,ex.getTrangthai());
			//ps.setBoolean(4,false);
			ps.setFloat(4, ex.getTienphat());
			ps.execute();
			ps.close();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại thông tin !","Error",JOptionPane.WARNING_MESSAGE);
		}
		return 0;
		
	}
	public static void setmuontra(int a,String b) {
		String sql="	update Sach set Tinhtrang_20183489=1 where Masach_20183489= '"+b+"'";
		String sql2="	update Sach set Tinhtrang_20183489=1 where Masach_20183489='"+b+"'" ;
		try {
			Statement stm=Connectdtb.getConnection().createStatement();
			if(a==1) stm.execute(sql); else stm.execute(sql2);
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Boolean gettinhtrang(String a) {
		String sql="select Tinhtrang_20183489 from Sach where Masach_20183489='"+a+"'";
		try {
			Statement stm=Connectdtb.getConnection().createStatement();
			ResultSet res=stm.executeQuery(sql);
			if(res!=null) {
				res.next();
				Boolean s=res.getBoolean(1);
				return s;
			}
			
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static int getthelastMuontra() {
		String sql="select top(1) MaMT_20183489 from Muontra order by MaMT_20183489 desc";
		try {
			Statement stm=Connectdtb.getConnection().createStatement();
			ResultSet res=stm.executeQuery(sql);
			if(res!=null) {
			res.next();
			int a=res.getInt(1)+1;
			stm.close();
			res.close();
			return a;
			}
			else return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public static void deletesachmuon(Chitietphieumuon a) {
		String sql="delete from Chitiet_Muon where Masach_20183489 ='"+a.getMasach()+"' and MaMT_20183489 ="+ a.getMa_mt();
		try {
			Statement stm=Connectdtb.getConnection().createStatement();
			stm.execute(sql);
			stm.close();
			JOptionPane.showMessageDialog(null, "Xóa sách mượn thành công");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Xóa sách mượn thất bại","Error",JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
		
	}
	public static void deletephieumuon(Phieumuontra a) {
		String sql="delete from Muontra where MaMT_20183489="+a.getMa_mt();
		try {
			Statement stm=Connectdtb.getConnection().createStatement();
			stm.execute(sql);
			stm.close();
			JOptionPane.showMessageDialog(null, "Xóa phiếu mượn thành công");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Xóa phiếu mượn thất bại","Error",JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
		
	}
	public static void trasach(int a,String b,String c,String d,String e) {
		String sql="update Chitiet_Muon set Ngay_tra_20183489='"+c+"',Tien_phat_20183489="+d+" ,Ghichu_20183489=N'"+e+"'  "
				+ "  where Masach_20183489 ='"+b+"' and MaMT_20183489="+a;
		try {
			Statement stm=Connectdtb.getConnection().createStatement();
			stm.execute(sql);
			stm.close();
			JOptionPane.showMessageDialog(null, "Trả sách mượn thành công");

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Trả sách thất bại","Error",JOptionPane.WARNING_MESSAGE);

			e1.printStackTrace();
		}
		
	}
}
