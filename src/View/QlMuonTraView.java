package View;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Data.DataThuthu;
import Data.Datamuontra;
import Object.Chitietphieumuon;
import Object.Phieumuontra;
import Object.Thuthu;
import com.toedter.components.JSpinField;
import com.toedter.calendar.JDateChooser;

public class QlMuonTraView extends JPanel {
	private JTextField txtmaphieu;
	private JTextField txtmadg;
	private JTextField txtmatt;
	private JTextField txttiencoc;
	private JTextField txtmamt;
	private JTextField txtghichu;
	private JTable tablephieumuon;
	private JTable tablechitiet;
	private JTextField txtfind;
	private static Phieumuontra phieu;
	private static Chitietphieumuon chitiet;
	private JDateChooser dateChooser_nm;
	private JDateChooser dateChooser_nht;
	private JDateChooser dateChooser_nt;
	private static JFileChooser filechooser;
	private String[]dsfind= {
			"Mã thủ thư","Mã độc giả","Mã mượn trả","Ngày mượn"
	};
	private String[]columnsphieumuon= {
			"Mã mượn trả","Mã độc giả","Mã thủ thư","Ngày mượn","Ngày hẹn trả","Tiền cọc"
	};
	private String[]columnschitietmuon= {
			"Mã mượn trả","Mã sách","Ngày trả","Tiền phạt","Ghi chú"
	};
	private JTextField txtmasach;
	private JTextField txttienphat;
	
	/**
	 * Create the panel.
	 */
	public QlMuonTraView() {
		setBackground(new Color(141, 181, 150));
		setLayout(null);
		
		JLabel lblmadocgia = new JLabel("Mã độc giả");
		lblmadocgia.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lblNewLabel.setBackground(Color.YELLOW);
//		lblNewLabel.setOpaque(true);
		lblmadocgia.setBounds(10, 107, 106, 36);
		add(lblmadocgia);
		
		JLabel lblmaphieu = new JLabel("Mã phiếu ");
		lblmaphieu.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lblMcGi.setOpaque(true);
//		lblMcGi.setBackground(Color.YELLOW);
		lblmaphieu.setBounds(10, 61, 106, 36);
		add(lblmaphieu);
		
		JLabel lblmathuthu = new JLabel("Mã thủ thư");
		lblmathuthu.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lblNewLabel_1.setOpaque(true);
//		lblNewLabel_1.setBackground(Color.YELLOW);
		lblmathuthu.setBounds(10, 153, 106, 36);
		add(lblmathuthu);
		
		JLabel lblngaymuon = new JLabel("Ngày mượn");
		lblngaymuon.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lblNewLabel_1_1.setBackground(Color.YELLOW);
//		lblNewLabel_1_1.setOpaque(true);
		lblngaymuon.setBounds(10, 199, 106, 36);
		add(lblngaymuon);
		
		JLabel lblngayhentra = new JLabel("Ngày hẹn trả");
		lblngayhentra.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lblNewLabel_1_2.setOpaque(true);
//		lblNewLabel_1_2.setBackground(Color.YELLOW);
		lblngayhentra.setBounds(10, 245, 106, 36);
		add(lblngayhentra);
		
		JLabel lbltiencoc = new JLabel("Tiền cọc ");
		lbltiencoc.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lblNewLabel_2.setBackground(Color.YELLOW);
//		lblNewLabel_2.setOpaque(true);
		lbltiencoc.setBounds(10, 291, 106, 36);
		add(lbltiencoc);
		
		JLabel lblmasach = new JLabel("Mã sách");
//		lblNewLabel_3.setOpaque(true);
		lblmasach.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lblNewLabel_3.setBackground(Color.YELLOW);
		lblmasach.setBounds(603, 107, 115, 36);
		add(lblmasach);
		
		JLabel lblmuontra = new JLabel("Mã mượn trả");
//		lblFg.setOpaque(true);
		lblmuontra.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lblFg.setBackground(Color.YELLOW);
		lblmuontra.setBounds(603, 61, 115, 36);
		add(lblmuontra);
		
		JLabel lblngaytra = new JLabel("Ngày trả");
//		lblNewLabel_1_3.setOpaque(true);
		lblngaytra.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lblNewLabel_1_3.setBackground(Color.YELLOW);
		lblngaytra.setBounds(603, 153, 115, 36);
		add(lblngaytra);
		
		JLabel lbltienphat = new JLabel("Tiền phạt");
//		lblNewLabel_1_2_1.setOpaque(true);
		lbltienphat.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lblNewLabel_1_2_1.setBackground(Color.YELLOW);
		lbltienphat.setBounds(603, 199, 115, 36);
		add(lbltienphat);
		
		JLabel lblghichu = new JLabel("Ghi chú");
//		lblNewLabel_2_1.setOpaque(true);
		lblghichu.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		lblNewLabel_2_1.setBackground(Color.YELLOW);
		lblghichu.setBounds(603, 245, 115, 36);
		add(lblghichu);
		
		txtmaphieu = new JTextField();
		txtmaphieu.setBounds(142, 61, 249, 36);
		add(txtmaphieu);
		txtmaphieu.setEditable(false);
		txtmaphieu.setColumns(10);
		
		txtmadg = new JTextField();
		txtmadg.setColumns(10);
		txtmadg.setBounds(142, 107, 249, 36);
		add(txtmadg);
		
		txtmatt = new JTextField();
		txtmatt.setColumns(10);
		txtmatt.setBounds(142, 153, 249, 36);
		add(txtmatt);
		
		txttiencoc = new JTextField();
		txttiencoc.setColumns(10);
		txttiencoc.setBounds(142, 291, 249, 36);
		add(txttiencoc);
		
		txtmamt = new JTextField();
		txtmamt.setColumns(10);
		txtmamt.setBounds(750, 61, 258, 36);
		txtmamt.setEditable(false);
		add(txtmamt);
		
		txtghichu = new JTextField();
		txtghichu.setColumns(10);
		txtghichu.setBounds(750, 245, 258, 36);
		add(txtghichu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 356, 583, 344);
		tablephieumuon =new JTable() {
	         public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	          }
	       };
		tablephieumuon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		List<Phieumuontra> list_mt=Datamuontra.getlistphieumuon();
		tablephieumuon.setModel(Datamuontra.getmodelphieumuon(list_mt, columnsphieumuon));
		//tablephieumuon.setBounds(10, 356, 583, 344);
		scrollPane.setViewportView(tablephieumuon);
		//add(tablephieumuon);
		add(scrollPane);
		
		JScrollPane scrollPane_ct = new JScrollPane();
		scrollPane_ct.setBounds(603, 356, 587, 344);
		tablechitiet =new JTable() {
	         public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	          }
	       };
		tablechitiet.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//tablechitiet.setBounds(603, 356, 587, 344);
		//add(tablechitiet);
		scrollPane_ct.setViewportView(tablechitiet);
		add(scrollPane_ct);
		
		JButton them = new JButton("New");
		them.setFont(new Font("Tahoma", Font.PLAIN, 16));
		them.setBounds(427, 64, 106, 34);
		add(them);
		
		JButton sua = new JButton("Edit");
		sua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sua.setBounds(427, 107, 106, 36);
		add(sua);
		
		JButton xoa = new JButton("Delete");
		xoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		xoa.setBounds(427, 153, 106, 36);
		add(xoa);
		
		JButton luu = new JButton("Save");
		luu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		luu.setBounds(427, 199, 106, 36);
		add(luu);
		
		JButton themmoi2 = new JButton("New");
		themmoi2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		themmoi2.setBounds(1052, 61, 106, 34);
		add(themmoi2);
		
		JButton sua2 = new JButton("Edit");
		sua2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sua2.setBounds(1052, 104, 106, 36);
		add(sua2);
		
		JButton xoa2 = new JButton("Delete");
		xoa2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		xoa2.setBounds(1052, 150, 106, 36);
		xoa2.setEnabled(false);
		add(xoa2);
		
		JButton luu2 = new JButton("Save");
		luu2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		luu2.setBounds(1052, 196, 106, 36);
		add(luu2);
		
		JButton trasach = new JButton("Trả sách");
		trasach.setFont(new Font("Tahoma", Font.BOLD, 16));
		trasach.setBounds(1052, 245, 106, 36);
		trasach.setEnabled(false);
		add(trasach);
		
		txtfind = new JTextField();
		txtfind.setBounds(142, 15, 249, 36);
		add(txtfind);
		txtfind.setColumns(10);
		
		JButton timkiem = new JButton("Find");
		timkiem.setFont(new Font("Tahoma", Font.BOLD, 16));
		timkiem.setBounds(427, 15, 106, 34);
		add(timkiem);
		
		JComboBox cbfind = new JComboBox(dsfind);
		cbfind.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbfind.setBounds(10, 15, 122, 36);
		add(cbfind);
		
		dateChooser_nm = new JDateChooser();
		dateChooser_nm.setBounds(142, 199, 249, 34);
		add(dateChooser_nm);
		
		dateChooser_nht = new JDateChooser();
		dateChooser_nht.setBounds(142, 245, 249, 34);
		add(dateChooser_nht);
		
		dateChooser_nt = new JDateChooser();
		dateChooser_nt.setBounds(750, 152, 258, 34);
		add(dateChooser_nt);
		
		txtmasach = new JTextField();
		txtmasach.setColumns(10);
		txtmasach.setBounds(750, 107, 258, 36);
		add(txtmasach);
		
		txttienphat = new JTextField();
		txttienphat.setColumns(10);
		txttienphat.setBounds(750, 196, 258, 36);
		add(txttienphat);
		
		JButton btnout = new JButton("Xuất file");
		btnout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnout.setBounds(427, 291, 106, 36);
		add(btnout);
		
		JButton btnin = new JButton("Nhập file");
		btnin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnin.setBounds(427, 245, 106, 36);
		add(btnin);
//		cbfind.add(dsfind);
		tablephieumuon.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				phieu=new Phieumuontra();
				if(tablephieumuon.getSelectedRow()!=-1) {
					DefaultTableModel model=(DefaultTableModel) tablephieumuon.getModel();
					int selectedrow=tablephieumuon.getSelectedRow();
					phieu.setMa_mt(Integer.parseInt(model.getValueAt(selectedrow, 0).toString()));
					phieu.setMa_dg((int)model.getValueAt(selectedrow, 1));
					phieu.setMa_tt(model.getValueAt(selectedrow, 2).toString());
					phieu.setNgaymuon((java.sql.Date) model.getValueAt(selectedrow, 3));
					phieu.setNgayhentra((java.sql.Date) model.getValueAt(selectedrow, 4));
					phieu.setTiencoc(Float.valueOf(model.getValueAt(selectedrow, 5).toString()));
					creattablechitietmuon(phieu.getMa_mt());
				}
			}
			
		});
		
		tablechitiet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					chitiet=new Chitietphieumuon();
					if(tablechitiet.getSelectedRow()!=-1) {
						DefaultTableModel model=(DefaultTableModel)tablechitiet.getModel();
						int selectedrow= tablechitiet.getSelectedRow();
						chitiet.setMa_mt((int)model.getValueAt(selectedrow, 0));
						chitiet.setMasach(model.getValueAt(selectedrow,1).toString());
						chitiet.setTienphat(Float.valueOf(model.getValueAt(selectedrow, 3).toString()));
						chitiet.setGhichu((String)model.getValueAt(selectedrow, 4));
						// nếu dùng phương thức toString() để ép kiểu sang string thì sẽ gặp lỗi nếu giá trị ép là null
						// ta nên dùng ép kiểu tường minh (String) để tránh lỗi 
						if(model.getValueAt(selectedrow, 2)==null) chitiet.setNgaytra(null);
						else 
						chitiet.setNgaytra((java.sql.Date)model.getValueAt(selectedrow, 2));
						
						}
			}
		});

		sua2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(chitiet !=null) {
					hienthisachdachon(chitiet);
					//dateChooser_nt.setEnabled(false);
//					if(chitiet.getTrangthai()==true) trasach.setEnabled(false);
					if(chitiet.getNgaytra() !=null) trasach.setEnabled(false);
					else trasach.setEnabled(true);
					xoa2.setEnabled(true);
				}
				
				
				
				
			}
		});

		
		sua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(phieu !=null) {
					txtmaphieu.setText(String.valueOf(phieu.getMa_mt()));
					txtmaphieu.setEditable(false);
					txtmadg.setText(String.valueOf(phieu.getMa_dg()));
					txtmatt.setText(phieu.getMa_tt());
					txttiencoc.setText(phieu.getTiencoc().toString());
					try {
						java.util.Date date=new SimpleDateFormat("yyyy-MM-dd").parse(phieu.getNgaymuon().toString());
						dateChooser_nm.setDate(date);
					} catch (Exception e2) {
						// TODO: handle exception
						System.out.println("loi get ngay vao calendar");
					}
					try {
						java.util.Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(phieu.getNgayhentra().toString());
						dateChooser_nht.setDate(date2);
					} catch (Exception e2) {
						// TODO: handle exception
						System.out.println("loi get ngay vao calendar");
					}
				}
			}
		});

		them.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtmadg.setText(null);
				//txtmamt.setText(null);
				txtmatt.setText(null);
				txttiencoc.setText(null);
				txtmaphieu.setText(String.valueOf(Datamuontra.getthelastMuontra()));
				dateChooser_nm.setDate(null);
				dateChooser_nht.setDate(null);
			}
		});

		luu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				Phieumuontra ex=new Phieumuontra();
				ex.setMa_mt(Integer.parseInt(txtmaphieu.getText()));
				ex.setMa_dg(Integer.parseInt(txtmadg.getText()));
				ex.setMa_tt(txtmatt.getText().trim());
				String t=txttiencoc.getText().trim();
				ex.setTiencoc(Float.valueOf(t));
				String dateinput=new SimpleDateFormat("yyyy-MM-dd").format(dateChooser_nm.getDate());
				String dateouput= new SimpleDateFormat("yyyy-MM-dd").format(dateChooser_nht.getDate());
				ex.setNgaymuon(java.sql.Date.valueOf(dateinput));
				ex.setNgayhentra(java.sql.Date.valueOf(dateouput));
				int q= Datamuontra.insertorupdatephieu(ex);
				if(q==1) {
				JOptionPane.showMessageDialog(null, "Thêm/sửa phiếu mượn thành công");
				}
				updatetablephieumuon();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Thêm/sửa phiếu mượn thất bại","Error",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		// TODO : listener chitietphieumuon
		themmoi2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtmamt.setText(String.valueOf(phieu.getMa_mt()));
				//txtmamt.setText(null);
				txtmasach.setText(null);
				txttienphat.setText(null);
				//txtmaphieu.setText(null);
				//txtm.setEditable(true);
				dateChooser_nt.setDate(null);
				txtghichu.setText(null);
			}
		});
		
		luu2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				Chitietphieumuon ex=new Chitietphieumuon();
				ex.setMa_mt(Integer.parseInt(txtmamt.getText()));
				ex.setMasach(txtmasach.getText().trim());
				ex.setGhichu(txtghichu.getText().trim());
				try {
				String dateouput=new SimpleDateFormat("yyyy-MM-dd").format(dateChooser_nt.getDate());
				System.out.println("dateeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee : \n "+dateouput);
				ex.setNgaytra(java.sql.Date.valueOf(dateouput));
				} catch (Exception e2) {
					// TODO: handle exception
					ex.setNgaytra(null);
				}
				
				//String dateinput= new SimpleDateFormat("yyyy-MM-dd").format(dateChooser_nht.getDate());
				//ex.setNgaymuon(java.sql.Date.valueOf(dateinput));
				
				if(txttienphat.getText().trim().equals("")) ex.setTienphat(0.0F);
				else ex.setTienphat(Float.valueOf(txttienphat.getText().trim()));
				int q= Datamuontra.insertorupdatechitietmuon(ex);
				if(q==1) {
					JOptionPane.showMessageDialog(null, "Thêm/sửa phiếu mượn thành công");
					Datamuontra.setmuontra(0, txtmasach.getText().trim());
				}
				updatetablechitietmuon();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại thông tin !","Error",JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		trasach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				String nt = null;
				//String d=new SimpleDateFormat("yyyy-MM-dd").format(LocalDate.now());
				
				try {
//											try {
							java.util.Date datemuon=new SimpleDateFormat("yyyy-MM-dd").parse(phieu.getNgayhentra().toString());
							//java.util.Date datetra=dateChooser_nt.getDate();
							LocalDate l=LocalDate.now();
							System.out.println("now : "+l);
							java.util.Date datetra=new SimpleDateFormat("yyyy-MM-dd").parse(l.toString());
							long timeinmiliseconds=datetra.getTime()-datemuon.getTime();
							long day=timeinmiliseconds/(1000*60*60*24);
							System.out.println("day ="+day);
							if(day<=0) day=0;
							txttienphat.setText(String.valueOf(day*3000));
							String nt=new SimpleDateFormat("yyyy-MM-dd").format(datetra);
							Datamuontra.trasach(Integer.parseInt(txtmamt.getText()), txtmasach.getText(),nt, txttienphat.getText(), txtghichu.getText());
							Datamuontra.setmuontra(1, txtmasach.getText());
							updatetablechitietmuon();
//									} catch (Exception e2) {
//							// TODO: handle exception
//							System.out.println("loi get ngay vao calendar");
//							JOptionPane.showMessageDialog(null, "Ngày trả không hợp lệ ","Error",JOptionPane.WARNING_MESSAGE);
//							
//									}
						

				} catch (Exception e2) {
					// TODO: handle exception
					txttienphat.setText(null);
					JOptionPane.showMessageDialog(null, "Trả sách  thất bại","Error",JOptionPane.WARNING_MESSAGE);
					

				}

			}
		});

		xoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtmaphieu.getText().isBlank() || txtmaphieu ==null || txtmaphieu.getText()==null) {
					JOptionPane.showMessageDialog(null, "Chọn phiếu cần xóa !","Error",JOptionPane.ERROR_MESSAGE);
				} else {
				int a= JOptionPane.showConfirmDialog(null, "Xóa phiếu mượn trả trong danh sách", "Question",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					Datamuontra.deletephieumuon(phieu);
					updatetablephieumuon();
				}
				}
			}
		});
		xoa2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtmamt.getText().isBlank() || txtmamt ==null || txtmamt.getText()==null) {
					JOptionPane.showMessageDialog(null, "Chọn thông tin mượn trả cần xóa !","Error",JOptionPane.ERROR_MESSAGE);
				}
				int a= JOptionPane.showConfirmDialog(null, "Xóa thông tin mượn trả trong danh sách", "Question",JOptionPane.YES_NO_OPTION);
//				System.out.println("Gia tri a = "+a);
//				chọn yes -> a=0 ,no a=1
				if(a==0) {
					Datamuontra.deletesachmuon(chitiet);
					updatetablechitietmuon();
				}
			}
		});
	
	
	btnin.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			getfilechooser();
			int a=filechooser.showOpenDialog(null);
			if(a==JFileChooser.APPROVE_OPTION) {
				String filepath=filechooser.getSelectedFile().getAbsolutePath();
				try {
					XSSFWorkbook workbook= openfileexcel(filepath);
					List<Phieumuontra> listin= getlistmuontrafromexcel(workbook);
					int s= Datamuontra.insertlistPMT(listin);
					if(s==1) JOptionPane.showMessageDialog(null, "Nhập dữ liệu thành công !");
					//updatetablethuthu();
					updatetablephieumuon();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Thêm/sửa dữ liệu thất bại","Error",JOptionPane.WARNING_MESSAGE);
				}
			}
			
		}
	});

	btnout.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			getfilechooser();
			int a=filechooser.showSaveDialog(null);
			if(a==JFileChooser.APPROVE_OPTION) {
				File temp=new File( filechooser.getSelectedFile().getAbsolutePath());
				try {
					FileOutputStream fileop=new FileOutputStream(temp);
					XSSFWorkbook wb=writeworkbook(list_mt);
					wb.write(fileop);
					fileop.close();
					JOptionPane.showMessageDialog(null,"Xuất báo cáo thành công");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,"Xuất báo cáo thất bại","Error",JOptionPane.WARNING_MESSAGE);
				}
				
			}
			
		}
	});
}
public JFileChooser getfilechooser() {
	if(filechooser ==null) {
		filechooser=new JFileChooser();
		FileNameExtensionFilter filter =new FileNameExtensionFilter("XLSX", "XLSX");
		filechooser.setFileFilter(filter);
	}
	return filechooser;
}
public XSSFWorkbook openfileexcel(String excelfilepath) throws IOException {
	FileInputStream fileip=new FileInputStream(new File(excelfilepath));
	XSSFWorkbook workbook=new XSSFWorkbook(fileip);
	
	return workbook;
}
public XSSFWorkbook writeworkbook(List<Phieumuontra>lt) {
	XSSFWorkbook workbook=new XSSFWorkbook();
	XSSFSheet sheet=workbook.createSheet("QuanLiMuonTra");
	XSSFRow row;
	
	writeHeader(sheet, 0);
	
	int size=lt.size();
	int rowid=1;
	for(int i=0;i<size;i++) {
		Phieumuontra ex=lt.get(i);
		row=sheet.createRow(rowid);
		for(int j=0;j<6;j++) {
			Cell cell=row.createCell(j);
			switch (j) {
			case 0: {
				
				cell.setCellValue(ex.getMa_mt());
				break;
			}
			case 1: {
				
				cell.setCellValue(ex.getMa_dg());
				break;
			}
			case 2: {
				
				cell.setCellValue(ex.getMa_tt());
				break;
			}
			case 3: {
				
				cell.setCellValue(ex.getNgaymuon());
				break;
			}
			case 4: {
				
				cell.setCellValue(ex.getNgayhentra());
				break;
			}
			case 5: {
				
				cell.setCellValue(ex.getTiencoc());
				break;
			}

			}
		}
		rowid++;
	}
	int columns=sheet.getRow(0).getPhysicalNumberOfCells();
	autosizeColumn(sheet, columns);
	return workbook;
}
private static void writeHeader(XSSFSheet sheet, int rowIndex) {
    // create CellStyle
    CellStyle cellStyle = createStyleForHeader(sheet);
     
    // Create row
    XSSFRow row = sheet.createRow(rowIndex);
     
    // Create cells
    Cell cell = row.createCell(0);
    cell.setCellStyle(cellStyle);
    cell.setCellValue("Mã mượn trả");

    cell = row.createCell(1);
    cell.setCellStyle(cellStyle);
    cell.setCellValue("Mã độc giả");

    cell = row.createCell(2);
    cell.setCellStyle(cellStyle);
    cell.setCellValue("Mã thủ thư");

    cell = row.createCell(3);
    cell.setCellStyle(cellStyle);
    cell.setCellValue("Ngày mượn");

    cell = row.createCell(4);
    cell.setCellStyle(cellStyle);
    cell.setCellValue("Ngày hẹn trả");
    cell = row.createCell(5);
    cell.setCellStyle(cellStyle);
    cell.setCellValue("Tiền cọc");
}
private static CellStyle createStyleForHeader(XSSFSheet sheet) {
    // Create font
    XSSFFont font = sheet.getWorkbook().createFont();
    font.setFontName("Times New Roman"); 
    font.setBold(true);
    font.setFontHeightInPoints((short) 12); // font size
    //font.setColor(IndexedColors.WHITE.getIndex()); // text color

    // Create CellStyle
    CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
    cellStyle.setFont(font);
    //cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
    //cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    //cellStyle.setBorderBottom(BorderStyle.THIN);
    return cellStyle;
}
public List<Phieumuontra> getlistmuontrafromexcel(XSSFWorkbook wb){
	XSSFRow row;
	List<Phieumuontra> listp=new ArrayList<>();
	XSSFSheet sheet=wb.getSheetAt(0);
	Iterator <Row> iteratorrow=sheet.iterator();
	while(iteratorrow.hasNext()) {
		
		row=(XSSFRow) iteratorrow.next();
		if(row.getRowNum()==0) continue;
		Iterator <Cell> iteratorcell=row.iterator();
		Phieumuontra tt=new Phieumuontra();
		while(iteratorcell.hasNext()) {
			Cell cell=iteratorcell.next();
			
//			switch(cell.getCellType()) {
//			case String: 
//			}
			int columnIndex = cell.getColumnIndex();
            
            switch (columnIndex) {
                case 0:
                	tt.setMa_mt((int)row.getCell(columnIndex).getNumericCellValue());
                	System.out.println("loi khi get matt excel");
                    break;
                case 1:
                	tt.setMa_dg((int)row.getCell(columnIndex).getNumericCellValue());
                	System.out.println("loi khi get hoten excel");
                    break;
                case 2:
                	tt.setMa_tt((String)getvalueincell(cell));
                	System.out.println("loi khi get gt excel");
                	break;
                case 3:
                	tt.setNgaymuon(java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format((java.util.Date)row.getCell(columnIndex).getDateCellValue())));
                	System.out.println("loi khi get email excel");
                	break;
                case 4:
                	tt.setNgayhentra(java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format((java.util.Date)row.getCell(columnIndex).getDateCellValue())));
                	System.out.println("get ngaysinh tc");
				break;
                case 5:
						tt.setTiencoc((float) row.getCell(columnIndex).getNumericCellValue());
						break;
            }
		}
		listp.add(tt);

	}
	
	return listp;
	
	}
public Object getvalueincell(Cell cell) {
	switch (cell.getCellType()) {
	case STRING:
		return cell.getStringCellValue();
     case NUMERIC: 
    	 return cell.getNumericCellValue();
     default :
    	 return cell.getDateCellValue();
	}
}
 private static void autosizeColumn(XSSFSheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }
	
	private void hienthisachdachon(Chitietphieumuon ct) {
		txtmamt.setText(String.valueOf(ct.getMa_mt()));
		txtmasach.setText(ct.getMasach());
		txtghichu.setText(ct.getGhichu());
		txttienphat.setText(ct.getTienphat().toString());
		try {
			java.util.Date date=new SimpleDateFormat("yyyy-MM-dd").parse(ct.getNgaytra().toString());
			dateChooser_nt.setDate(date);
		} catch (Exception e2) {
			// TODO: handle exception
			dateChooser_nt.setDate(null);
			//System.out.println("loi get ngay vao calendar");
		}
		
	}
	private void creattablechitietmuon(int a) {
		List<Chitietphieumuon> list_ct=Datamuontra.getlistchitiet(a);
		tablechitiet.setModel(Datamuontra.getmodelchitietmuon(list_ct, columnschitietmuon));
	}
	private void updatetablephieumuon() {
		List<Phieumuontra> list_pm=Datamuontra.getlistphieumuon();
		tablephieumuon.setModel(Datamuontra.getmodelphieumuon(list_pm, columnsphieumuon));
	}
	private void updatetablechitietmuon() {
		List<Chitietphieumuon> list_ct=Datamuontra.getlistchitiet(phieu.getMa_mt());
		tablechitiet.setModel(Datamuontra.getmodelchitietmuon(list_ct, columnschitietmuon));
	}
}
