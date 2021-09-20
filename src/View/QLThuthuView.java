package View;

import javax.swing.JPanel;
import Object.Thuthu;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.microsoft.schemas.office.visio.x2012.main.CellType;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import Data.Connectdtb;
import Data.DataThuthu;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import com.toedter.calendar.JDateChooser;

public class QLThuthuView extends JPanel {
	private JTable table;
	private JTextField txtfind;
	private JTextField MaTT;
	private JTextField HovT;
	private JTextField Email;
	private JTextField SoDT;
	private JTextField SoCMND;
	private static JFileChooser filechooser;
	public static List<Thuthu> listtt;
	private static int currentedit;
	private String[] columnsthuthu= {
			"Mã thủ thư","Họ và tên","Giới tính","Email","Ngày sinh","Số CMND","Số điện thoại"
	};
	private String[] comboboxfind= {
			"Mã thủ thư","Họ và tên","Email","Số điện thoại","Giới tính","Số CMND","Ngày sinh"
	};
	private String[] gtinh= {
			"Nam","Nữ"
	};
	public Thuthu exthuthu;
	/**
	 * Create the panel.
	 */
	public QLThuthuView() {
		setBackground(new Color(141, 181, 150));
		setLayout(null);
		

		
		txtfind = new JTextField();
		txtfind.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtfind.setBounds(827, 71, 243, 37);
		add(txtfind);
		txtfind.setColumns(10);
		
		JLabel lblMatt = new JLabel("Mã thủ thư");
		lblMatt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMatt.setBounds(24, 24, 102, 37);
		add(lblMatt);
		
		JLabel lblHvt = new JLabel("Họ và tên");
		lblHvt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHvt.setBounds(24, 71, 102, 37);
		add(lblHvt);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(24, 118, 102, 37);
		add(lblEmail);
		
		JLabel lblsodt = new JLabel("Số điện thoại");
		lblsodt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblsodt.setBounds(24, 167, 102, 37);
		add(lblsodt);
		
		JLabel lblsocmnd = new JLabel("Số CMND");
		lblsocmnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblsocmnd.setBounds(24, 214, 102, 37);
		add(lblsocmnd);
		
		MaTT = new JTextField();
		MaTT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		MaTT.setBounds(168, 24, 148, 37);
		add(MaTT);
		MaTT.setColumns(10);
		
		HovT = new JTextField();
		HovT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		HovT.setColumns(10);
		HovT.setBounds(168, 71, 307, 37);
		add(HovT);
		
		Email = new JTextField();
		Email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Email.setColumns(10);
		Email.setBounds(168, 118, 307, 37);
		add(Email);
		
		SoDT = new JTextField();
		SoDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		SoDT.setColumns(10);
		SoDT.setBounds(168, 167, 307, 37);
		add(SoDT);
		
		SoCMND = new JTextField();
		SoCMND.setFont(new Font("Tahoma", Font.PLAIN, 16));
		SoCMND.setColumns(10);
		SoCMND.setBounds(168, 214, 307, 37);
		add(SoCMND);
		
		JLabel lblGt = new JLabel("Giới tính");
		lblGt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGt.setBounds(333, 24, 66, 37);
		add(lblGt);
		
		JButton btnfind = new JButton("Find");
		btnfind.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnfind.setBounds(559, 71, 123, 37);
		add(btnfind);
		
		JButton btnnew = new JButton("New");
		
		btnnew.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnnew.setBounds(559, 118, 123, 37);
		add(btnnew);
		
		JButton btnedit = new JButton("Edit");
		btnedit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnedit.setBounds(559, 165, 123, 37);
		add(btnedit);
		
		JButton btnsave = new JButton("Save");
		btnsave.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnsave.setBounds(559, 261, 123, 37);
		add(btnsave);
		
		JLabel lblNgS = new JLabel("Ngày sinh");
		lblNgS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgS.setBounds(24, 261, 102, 37);
		add(lblNgS);
		JComboBox gioitinh = new JComboBox(gtinh);
		gioitinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gioitinh.setBounds(401, 24, 74, 37);
		add(gioitinh);
		JDateChooser dateChooser_ns = new JDateChooser();
		dateChooser_ns.setBounds(168, 261, 307, 37);
		add(dateChooser_ns);
		JComboBox comboBox = new JComboBox(comboboxfind);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mã thủ thư", "Họ và tên", "Email", "Số điện thoại", "Giới tính", "Số CMND", "Ngày sinh"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setBounds(692, 73, 125, 37);
		add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 309, 1179, 394);
		
		table = new JTable() {
	         public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	          }
	       };
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
//		table.setBounds(10, 314, 1179, 389);
		
		//List<Thuthu> listthuthu=DataThuthu.getListThuthu();
		 listtt=DataThuthu.getListThuthu();
		table.setModel(DataThuthu.getmodelthuthu(listtt,columnsthuthu));
//		table.setRow
//		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//			
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				// TODO Auto-generated method stub
//				System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
//				
//			}
//		});
//		table.addMouseListener(new MouseAdapter() {
//	         public void mouseClicked(MouseEvent me) {
//	            if (me.getClickCount() == 2) {     // to detect doble click events
//	               JTable target = (JTable)me.getSource();
//	               int row = target.getSelectedRow(); // select a row
//	               int column = target.getSelectedColumn(); // select a column
//	               System.out.println("row"+row+" column "+column);
//	               System.out.println(table.getValueAt(row, column).toString()); // get the value of a row and column.
//	            }
//	         }
//	      });

//		comboBox.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				switch ((String)comboBox.getSelectedItem()) {
//				case "Ngày sinh": {
//					
//				}
//				default:
//					throw new IllegalArgumentException("Unexpected value: " + (String)comboBox.getSelectedItem());
//				}
//			} 
//		});
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				exthuthu=new Thuthu();
				if(table.getSelectedRow()!=-1) {
					DefaultTableModel model=(DefaultTableModel) table.getModel();
					int selectedrow=table.getSelectedRow();
					exthuthu.setMathuthu((String)model.getValueAt(selectedrow,0 ));
					exthuthu.setHovaten((String)model.getValueAt(selectedrow, 1));
					exthuthu.setGioitinh((String)model.getValueAt(selectedrow, 2));
					exthuthu.setEmail((String) model.getValueAt(selectedrow, 3));
					//exthuthu.setNgaysinh(Date.valueOf((String)model.getValueAt(selectedrow, 4)));
					//String ns=(String)model.getValueAt(selectedrow, 4);
					//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					//Date convertedCurrentDate;
					//java.sql.Date dt=java.sql.Date.valueOf(ns);
					exthuthu.setNgaysinh((java.sql.Date) model.getValueAt(selectedrow, 4));
//					try {
//						convertedCurrentDate = sdf.parse((String) model.getValueAt(selectedrow, 4));
//						exthuthu.setNgaysinh(convertedCurrentDate);
//					} catch (ParseException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
					
					exthuthu.setSoCMND((BigDecimal)model.getValueAt(selectedrow, 5));
					exthuthu.setDienthoai((String)model.getValueAt(selectedrow, 6));
					System.out.println(model.getValueAt(selectedrow, 0));
				}
			}
			
		});
		btnfind.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println((String)comboBox.getSelectedItem());
//				if((String)comboBox.getSelectedItem()=="Mã thủ thư") {
//					List<Thuthu> lt=DataThuthu.getListThuthuFindN("Ma_TT_20183489",txtfind.getText().trim());
//					//((AbstractTableModel) table.getModel()).fireTableDataChanged();
//					table.setModel(DataThuthu.getmodelthuthu(lt, columnsthuthu));
//					table.repaint();
//					System.out.println("text : "+txtfind.getText().trim());
//				}
				switch ((String)comboBox.getSelectedItem()) {
				case "Mã thủ thư" : {
					listtt=DataThuthu.getListThuthuFind("Ma_TT_20183489",txtfind.getText().trim());
					table.setModel(DataThuthu.getmodelthuthu(listtt, columnsthuthu));
					table.repaint();
					System.out.println("text : "+txtfind.getText().trim());
					break;
				}
				case "Họ và tên" : {
					listtt=DataThuthu.getListThuthuFindN("Ten_TT_20183489",txtfind.getText().trim());
					table.setModel(DataThuthu.getmodelthuthu(listtt, columnsthuthu));
					table.repaint();
					System.out.println("text : "+txtfind.getText().trim());
					break;
				}
				case "Ngày sinh" : {
					listtt=DataThuthu.getListThuthuFind("Ngaysinh_20183489",txtfind.getText().trim());
					table.setModel(DataThuthu.getmodelthuthu(listtt, columnsthuthu));
					table.repaint();
					System.out.println("text : "+txtfind.getText().trim());
					break;
				}
				case "Số CMND" : {
					listtt=DataThuthu.getListThuthuFind("CMND_20183489",txtfind.getText().trim());
					table.setModel(DataThuthu.getmodelthuthu(listtt, columnsthuthu));
					table.repaint();
					System.out.println("text : "+txtfind.getText().trim());
					break;
				}
				case "Số điện thoại" : {
					listtt=DataThuthu.getListThuthuFind("Dienthoai_20183489",txtfind.getText().trim());
					table.setModel(DataThuthu.getmodelthuthu(listtt, columnsthuthu));
					table.repaint();
					System.out.println("text : "+txtfind.getText().trim());
					break;
				}
				case "Email" : {
					listtt=DataThuthu.getListThuthuFind("Email_20183489",txtfind.getText().trim());
					table.setModel(DataThuthu.getmodelthuthu(listtt, columnsthuthu));
					table.repaint();
					System.out.println("text : "+txtfind.getText().trim());
					break;
				}
				case "Giới tính":{
					listtt=DataThuthu.getListThuthuFindN("Gioitinh_20183489",txtfind.getText().trim());
					table.setModel(DataThuthu.getmodelthuthu(listtt, columnsthuthu));
					table.repaint();
					System.out.println("text : "+txtfind.getText().trim());
					break;
				}
//				default:
//					throw new IllegalArgumentException("Unexpected value: " + (String)comboBox.getSelectedItem());
				}
				
			}
		});
		scrollPane.setViewportView(table);
		add(scrollPane);
		
		JButton btndelete = new JButton("Delete");
		
		btndelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btndelete.setBounds(559, 214, 123, 37);
		add(btndelete);
		
		JButton btnin = new JButton("Nhập dữ liệu");
		btnin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnin.setBounds(559, 24, 180, 37);
		add(btnin);
		
		JButton btnout = new JButton("Xuất báo cáo");
		btnout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnout.setBounds(772, 24, 180, 37);
		add(btnout);
		

		
		btnedit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(exthuthu !=null) {
					currentedit=table.getSelectedRow();
					MaTT.setText(exthuthu.getMathuthu());
					MaTT.setEditable(false);
					//Gio.setText(exthuthu.getGioitinh());
					if(exthuthu.getGioitinh().equals(gtinh[0])) gioitinh.setSelectedItem(gtinh[0]); else gioitinh.setSelectedItem(gtinh[1]);;
					Email.setText(exthuthu.getEmail());
					HovT.setText(exthuthu.getHovaten());
					SoCMND.setText(exthuthu.getSoCMND().toString());
					SoDT.setText(exthuthu.getDienthoai().toString());
					//Ngaysinh.setText(exthuthu.getNgaysinh().toString());
					try {
						java.util.Date date=new SimpleDateFormat("yyyy-MM-dd").parse(exthuthu.getNgaysinh().toString());
						dateChooser_ns.setDate(date);
					} catch (Exception e2) {
						// TODO: handle exception
						System.out.println("loi get ngay vao calendar");
					}
					
				}
			}
		});
		Thuthu temp=new Thuthu();
		btnsave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
				
				if(MaTT !=null) {
//					String s="12131";
//					BigDecimal a= new BigDecimal(s);
					System.out.println("gia tri temp: ");
					System.out.println(temp.getMathuthu()+temp.getHovaten()+temp.getGioitinh()+temp.getNgaysinh()+temp.getSoCMND()+temp.getDienthoai()+temp.getEmail());
					temp.setDienthoai(SoDT.getText().trim());
					temp.setSoCMND(new BigDecimal(SoCMND.getText().toString().trim()));
					temp.setHovaten(HovT.getText().toString().trim());
					temp.setGioitinh(gioitinh.getSelectedItem().toString().trim());
					temp.setMathuthu(MaTT.getText().toString().trim());
					temp.setEmail(Email.getText().toString().trim());
					String date=new SimpleDateFormat("yyyy-MM-dd").format(dateChooser_ns.getDate());
					temp.setNgaysinh(java.sql.Date.valueOf(date));
					System.out.println("gia tri temp sau do : ");
					System.out.println(temp.getMathuthu()+temp.getHovaten()+temp.getGioitinh()+temp.getNgaysinh()+temp.getSoCMND()+temp.getDienthoai()+temp.getEmail());

					int j= DataThuthu.InsertorUpdateThuthu(temp);
					if(j==1) JOptionPane.showMessageDialog(null, "Thêm/sửa dữ liệu thành công");
					MaTT.setText(null);
					MaTT.setEditable(true);
					gioitinh.setSelectedIndex(0);
					Email.setText(null);
					HovT.setText(null);
					SoCMND.setText(null);
					SoDT.setText(null);
					dateChooser_ns.setDate(null);
					listtt=DataThuthu.getListThuthuFind("Ma_TT_20183489","");
					table.setModel(DataThuthu.getmodelthuthu(listtt, columnsthuthu));
					table.repaint();
					
				}
				} 
				catch (Exception em) {
					JOptionPane.showMessageDialog(null, "Thêm/sửa dữ liệu thất bại","Error",JOptionPane.WARNING_MESSAGE);
				}
				finally {
					// TODO: handle finally clause
					System.out.println(temp.getMathuthu()+temp.getHovaten()+temp.getGioitinh()+temp.getNgaysinh()+temp.getSoCMND()+temp.getDienthoai()+temp.getEmail());
					
					
				}
				
			}
		});
		btndelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				if((String)txtdelete.getText()!=null) {
//					DataThuthu.DeleteRow((String)txtdelete.getText());
////					table.setModel(table.getModel().fireT);
//					List<Thuthu> lt=DataThuthu.getListThuthu();
//					table.setModel(DataThuthu.getmodelthuthu(lt, columnsthuthu));
//					//table.repaint();
//					
//				}
				System.out.println("noi dung MaTT:"+ MaTT.getText().toString());
				if(MaTT.getText().isBlank() || MaTT ==null || MaTT.getText()==null) {
					JOptionPane.showMessageDialog(null, "Chọn thủ thư cần xóa !","Error",JOptionPane.ERROR_MESSAGE);
				}
				else {
					int b= JOptionPane.showConfirmDialog(null, "Xóa thủ thư "+HovT.getText()+" ?", "Question",JOptionPane.YES_NO_OPTION);
					if(b==0) {
					
					int a=DataThuthu.DeleteRow(MaTT.getText().toString().trim());
					if(a==1) {
						
						JOptionPane.showMessageDialog(null, "Xóa thành công !");
//						int selectedrow=table.getSelectedRow();
						MaTT.setText(null);
						MaTT.setEditable(true);
						gioitinh.setSelectedIndex(0);
						Email.setText(null);
						HovT.setText(null);
						SoCMND.setText(null);
						SoDT.setText(null);
						dateChooser_ns.setDate(null);
						listtt.remove(currentedit);//dung de cap nhat lai bang ma chi xoa dong do
						//listtt=DataThuthu.getListThuthu();
						table.setModel(DataThuthu.getmodelthuthu(listtt, columnsthuthu));
						table.repaint();
						//btnfind.click;
					}
					}
				}
			}
		});
		btnnew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MaTT.setText(null);
				MaTT.setEditable(true);
				gioitinh.setSelectedIndex(0);
				Email.setText(null);
				HovT.setText(null);
				SoCMND.setText(null);
				SoDT.setText(null);
				dateChooser_ns.setDate(null);
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
						List<Thuthu> listin= getlistthuthufromexcel(workbook);
						int s= DataThuthu.insertlistthuthu(listin);
						if(s==1) JOptionPane.showMessageDialog(null, "Nhập dữ liệu thành công !");
						updatetablethuthu();
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
						XSSFWorkbook wb=writeworkbook(listtt);
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
			FileNameExtensionFilter filter =new FileNameExtensionFilter("XLSX", "xlsx");
			filechooser.setFileFilter(filter);
		}
		return filechooser;
	}
	public XSSFWorkbook openfileexcel(String excelfilepath) throws IOException {
		FileInputStream fileip=new FileInputStream(new File(excelfilepath));
		XSSFWorkbook workbook=new XSSFWorkbook(fileip);
		
		return workbook;
	}
	public XSSFWorkbook writeworkbook(List<Thuthu>lt) {
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("QuanLiThuThu");
		XSSFRow row;
		
		writeHeader(sheet, 0);
		
		int size=lt.size();
		int rowid=1;
		for(int i=0;i<size;i++) {
			Thuthu ex=lt.get(i);
			row=sheet.createRow(rowid);
			for(int j=0;j<7;j++) {
				Cell cell=row.createCell(j);
				switch (j) {
				case 0: {
					
					cell.setCellValue(ex.getMathuthu());
					break;
				}
				case 1: {
					
					cell.setCellValue(ex.getHovaten());
					break;
				}
				case 2: {
					
					cell.setCellValue(ex.getGioitinh());
					break;
				}
				case 3: {
					
					cell.setCellValue(ex.getEmail());
					break;
				}
				case 4: {
					
					cell.setCellValue(ex.getNgaysinh());
					break;
				}
				case 5: {
					
					cell.setCellValue(String.valueOf(ex.getSoCMND()));
					break;
				}
				case 6:{
					cell.setCellValue(String.valueOf(ex.getDienthoai()));
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
        cell.setCellValue("Mã Thủ thư");
 
        cell = row.createCell(1);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Họ và tên");
 
        cell = row.createCell(2);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Giới tính");
 
        cell = row.createCell(3);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Email");
 
        cell = row.createCell(4);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Ngày sinh");
        cell = row.createCell(5);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Số CMND");
        cell = row.createCell(6);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Số điện thoại");
        
    }
    private static CellStyle createStyleForHeader(XSSFSheet sheet) {
        // Create font
        XSSFFont font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman"); 
        font.setBold(true);
        font.setFontHeightInPoints((short) 14); // font size
        //font.setColor(IndexedColors.WHITE.getIndex()); // text color
 
        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        //cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        //cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }
	public List<Thuthu> getlistthuthufromexcel(XSSFWorkbook wb){
		XSSFRow row;
		List<Thuthu> listtt=new ArrayList<>();
		XSSFSheet sheet=wb.getSheetAt(0);
		Iterator <Row> iteratorrow=sheet.iterator();
		while(iteratorrow.hasNext()) {
			
			row=(XSSFRow) iteratorrow.next();
			if(row.getRowNum()==0) continue;
			Iterator <Cell> iteratorcell=row.iterator();
			Thuthu tt=new Thuthu();
			while(iteratorcell.hasNext()) {
				Cell cell=iteratorcell.next();
				
//				switch(cell.getCellType()) {
//				case String: 
//				}
				int columnIndex = cell.getColumnIndex();
                
                switch (columnIndex) {
                    case 0:
                    	tt.setMathuthu((String)getvalueincell(cell));
                    	System.out.println("loi khi get matt excel");
                        break;
                    case 1:
                    	tt.setHovaten((String)getvalueincell(cell));
                    	System.out.println("loi khi get hoten excel");
                        break;
                    case 2:
                    	tt.setGioitinh((String)getvalueincell(cell));
                    	System.out.println("loi khi get gt excel");
                    	break;
                    case 3:
                    	tt.setEmail((String)getvalueincell(cell));
                    	System.out.println("loi khi get email excel");
                    	break;
                    case 4:
					try {
						//String d=(String)getvalueincell(cell);
						System.out.println(getvalueincell(cell));
						//java.util.Date date2=new SimpleDateFormat("M/d/yyyy").parse(d);
						tt.setNgaysinh(java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format((java.util.Date)row.getCell(columnIndex).getDateCellValue())));
						System.out.println("get ngaysinh tc");
						System.out.println(tt.getNgaysinh());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("loi khi get list excel");
						e.printStackTrace();
					}
					break;
                    case 5:
                    	try {
							
						
//                    	tt.setSoCMND(new BigDecimal((Double)getvalueincell(cell)));
                    	tt.setSoCMND(new BigDecimal(row.getCell(columnIndex).getNumericCellValue()));
                    	
                    	System.out.println("loi khi get decimal excel");
                    	System.out.println(tt.getSoCMND());
                    	break;
                    	} catch (Exception e) {
							// TODO: handle exception
                    		tt.setSoCMND(new BigDecimal((String)getvalueincell(cell)));
                    		break;
						}
                    case 6:
                        tt.setDienthoai((String)getvalueincell(cell));
                        System.out.println("loi khi get dt excel");
                        break;
                }
			}
			listtt.add(tt);

		}
		
		return listtt;
		
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
	public void updatetablethuthu() {
		listtt=DataThuthu.getListThuthu();
		table.setModel(DataThuthu.getmodelthuthu(listtt, columnsthuthu));
	}
}
