package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Object.Docgia;

public class DataDocgia {
	public static List<Docgia> getListDocgia() {
		String sql="select * from Docgia";
		List<Docgia> listdg=new ArrayList<>();
		
		try {
			Statement stm=Connectdtb.getConnection().createStatement();
			ResultSet res;
			res = stm.executeQuery(sql);
		
		while(res.next()) {
			Docgia dg=new Docgia();
			dg.setMadocgia(res.getInt(1));
			dg.setTendocgia(res.getNString(2));
			dg.setGioitinh(res.getNString(3));
			dg.setNgaysinh(res.getDate(4));
			dg.setSoCMND(res.getBigDecimal(5));
			dg.setEmail(res.getString(6));
			dg.setSodienthoai(res.getString(7));
			listdg.add(dg);
		}
		stm.close();
		res.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Loi KHI GET LIST DOC GIA");
		}
		return listdg;
	}
	public static DefaultTableModel getModeltable(List<Docgia> ls,String[]columns) {
		DefaultTableModel model= new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		Object[]obj;
		Docgia ex;
		for(int i=0;i<ls.size();i++) {
			ex=ls.get(i);
			obj=new Object[columns.length];
			obj[0]=ex.getMadocgia();
			obj[1]=ex.getTendocgia();
			obj[2]=ex.getGioitinh();
			obj[3]=ex.getEmail();
			obj[4]=ex.getNgaysinh();
			obj[5]=ex.getSoCMND();
			obj[6]=ex.getSodienthoai();
			model.addRow(obj);
		}
		return model;
	}
	public static List<Docgia> findDocgia(String a,String b){
		String sql="select * from Docgia where "+a+" like N'%"+b+"%'";
		List<Docgia> listdg=new ArrayList<>();
		try {
			Statement stm=Connectdtb.getConnection().createStatement();
			ResultSet res=stm.executeQuery(sql);
			while(res.next()) {
				Docgia dg=new Docgia();
				dg.setMadocgia(res.getInt(1));
				dg.setTendocgia(res.getNString(2));
				dg.setGioitinh(res.getNString(3));
				dg.setNgaysinh(res.getDate(4));
				dg.setSoCMND(res.getBigDecimal(5));
				dg.setEmail(res.getString(6));
				dg.setSodienthoai(res.getString(7));
				listdg.add(dg);
			}
			stm.close();
			res.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			System.out.println("LOI KHI TIM KIEM DANH SACH THU THU");
			e.printStackTrace();
		}
		return listdg;

	}
	public static int deleteDocgia(String a) {
		String sql="delete from Docgia where Ma_DG_20183489 ='"+a+"'";
		try {
			Statement stm=Connectdtb.getConnection().createStatement();
			stm.execute(sql);
			stm.close();
			return 1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("LOI KHI XOA DOC GIA");
			e.printStackTrace();
		}
		return 0;
	}
	public static void insertDocgia(Docgia ex) {
		String sql="	merge into Docgia using  "
				+ "	(select madg=?,tendg=?,gioitinh=?,ngaysinh=?,email=?, "
				+ "	sdt=?,cmnd=?) as dg "
				+ "	on Docgia.Ma_DG_20183489=dg.madg "
				+ "	when matched then  "
				+ "	update set Ten_DG_20183489=tendg, Gioitinh_20183489=gioitinh, Ngaysinh_20183489=ngaysinh, CMND_20183489=cmnd, Email_20183489=email, Dienthoai_20183489=sdt "
				+ "	when not matched then "
				+ "	insert (Ten_DG_20183489,Gioitinh_20183489,Ngaysinh_20183489,CMND_20183489,Email_20183489,Dienthoai_20183489) "
				+ "	values(tendg,gioitinh,ngaysinh,cmnd,email,sdt);";
		try {
			PreparedStatement ps=Connectdtb.getConnection().prepareStatement(sql);
//			ps.setNString(1, ex.getTendocgia());
//			ps.setDate(3, ex.getNgaysinh());
//			ps.setNString(2,ex.getGioitinh());
//			ps.setBigDecimal(4, ex.getSoCMND());
//			ps.setString(5, ex.getEmail());
//			ps.setString(6,ex.getSodienthoai());
//			ps.execute();
			ps.setInt(1, ex.getMadocgia());
			ps.setNString(2, ex.getTendocgia());
			ps.setDate(4, ex.getNgaysinh());
			ps.setNString(3,ex.getGioitinh());
			ps.setBigDecimal(7, ex.getSoCMND());
			ps.setString(5, ex.getEmail());
			ps.setString(6,ex.getSodienthoai());
			ps.execute();
//			JOptionPane.showMessageDialog(null, "Thêm/sửa độc giả thành công");
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
	}
//	public static void saveDocgia(Docgia ex) {
//		String sql=""
//	}
	public static int insertlistdocgia(List<Docgia> ls) {
		try {
		for(int i=0;i<ls.size();i++) {
			Docgia d=ls.get(i);
			insertDocgia(d);
		}
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		return 1;
	}
	public static int getthelastDocgia() {
		String sql="select top(1) Ma_DG_20183489 from DocGia order by Ma_DG_20183489 desc ";
		try {
			Statement stm=Connectdtb.getConnection().createStatement();
			ResultSet res=stm.executeQuery(sql);
			res.next();
			int a=res.getInt(1)+1;
			stm.close();
			res.close();
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
}
