package View;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;
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

import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.toedter.calendar.JDateChooser;

import Data.DataDocgia;
import Data.DataSach;
import Data.DataThuthu;
import Object.Docgia;
import Object.Sach;
import Object.Thuthu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

public class QLDocGiaView extends JPanel {
	private JTextField txtfind;
	private JTextField txtmadg;
	private JTextField txthoten;
	private JTextField txtemail;
	private JTextField txtsdt;
	private JTextField txtcmnd;
	private static JTable table;
	private static JFileChooser filechooser;
	public static List<Docgia> listdg;
	private static int currentedit;
	private static Docgia exsach;
	private static int selectedrow;
	private static String[] columnsdocgia= {
			"Mã độc giả","Họ và tên","Giới tính","Email","Ngày sinh","Số CMND","Số điện thoại"

	};
	private static String[] gtinh= {
			"Nam","Nữ"
	};
	private String[] finds= {
			"Mã độc giả","Tên độc giả","Số điện thoại","Số CMND"
	};
	public static Docgia exdocgia;
	/**
	 * Create the panel.
	 */
	public QLDocGiaView() {
		setBackground(new Color(141, 181, 150));
		setLayout(null);
		
		txtfind = new JTextField();
		txtfind.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtfind.setColumns(10);
		txtfind.setBounds(829, 67, 243, 37);
		add(txtfind);
		
		JLabel lblMcGi = new JLabel("Mã độc giả");
		lblMcGi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMcGi.setBounds(26, 20, 102, 37);
		add(lblMcGi);
		
		JLabel lblHvt = new JLabel("Họ và tên");
		lblHvt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHvt.setBounds(26, 67, 102, 37);
		add(lblHvt);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(26, 114, 102, 37);
		add(lblEmail);
		
		JLabel lblsodt = new JLabel("Số điện thoại");
		lblsodt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblsodt.setBounds(26, 163, 102, 37);
		add(lblsodt);
		
		JLabel lblsocmnd = new JLabel("Số CMND");
		lblsocmnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblsocmnd.setBounds(26, 210, 102, 37);
		add(lblsocmnd);
		
		txtmadg = new JTextField();
		txtmadg.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtmadg.setColumns(10);
		txtmadg.setEditable(false);
		txtmadg.setBounds(170, 20, 148, 37);
		add(txtmadg);
		
		txthoten = new JTextField();
		txthoten.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txthoten.setColumns(10);
		txthoten.setBounds(170, 67, 307, 37);
		add(txthoten);
		
		txtemail = new JTextField();
		txtemail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtemail.setColumns(10);
		txtemail.setBounds(170, 114, 307, 37);
		add(txtemail);
		
		txtsdt = new JTextField();
		txtsdt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtsdt.setColumns(10);
		txtsdt.setBounds(170, 163, 307, 37);
		add(txtsdt);
		
		txtcmnd = new JTextField();
		txtcmnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtcmnd.setColumns(10);
		txtcmnd.setBounds(170, 210, 307, 37);
		add(txtcmnd);
		
		JLabel lblGt = new JLabel("Giới tính");
		lblGt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGt.setBounds(335, 20, 66, 37);
		add(lblGt);
		
		JButton btnfind = new JButton("Find");
		btnfind.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnfind.setBounds(561, 67, 123, 37);
		add(btnfind);
		
		JButton btnnew = new JButton("New");
		btnnew.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnnew.setBounds(561, 114, 123, 37);
		add(btnnew);
		
		JButton btnedit = new JButton("Edit");
		btnedit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnedit.setBounds(561, 161, 123, 37);
		add(btnedit);
		
		JButton btnsave = new JButton("Save");
		btnsave.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnsave.setBounds(561, 257, 123, 37);
		add(btnsave);
		
		JLabel lblNgS = new JLabel("Ngày sinh");
		lblNgS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgS.setBounds(26, 257, 102, 37);
		add(lblNgS);
		
		JComboBox comboboxgt = new JComboBox(gtinh);
		comboboxgt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboboxgt.setBounds(403, 20, 74, 37);
		add(comboboxgt);
		
		JComboBox comboboxfind = new JComboBox(finds);
		comboboxfind.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboboxfind.setBounds(694, 69, 125, 37);
		add(comboboxfind);
		
		JButton btndelete = new JButton("Delete");
		btndelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btndelete.setBounds(561, 210, 123, 37);
		add(btndelete);
		
		JButton btnin = new JButton("Nhập dữ liệu");
		btnin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnin.setBounds(561, 20, 180, 37);
		add(btnin);
		
		JButton btnout = new JButton("Xuất báo cáo");
		btnout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnout.setBounds(774, 20, 180, 37);
		add(btnout);
		
		
		
		JDateChooser dateChooser_ns = new JDateChooser();
		dateChooser_ns.setBounds(170, 257, 307, 37);
		add(dateChooser_ns);
		
		table = new JTable() {
	         public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	          }
	       };
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    
	       table.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					exdocgia=new Docgia();
					if(table.getSelectedRow()!=-1) {
						DefaultTableModel model=(DefaultTableModel) table.getModel();
						selectedrow=table.getSelectedRow();
						exdocgia.setMadocgia(Integer.parseInt(model.getValueAt(selectedrow,0 ).toString()));
						exdocgia.setTendocgia((String)model.getValueAt(selectedrow, 1));
						exdocgia.setGioitinh((String)model.getValueAt(selectedrow, 2));
						exdocgia.setEmail((String) model.getValueAt(selectedrow, 3));
						//exthuthu.setNgaysinh(Date.valueOf((String)model.getValueAt(selectedrow, 4)));
						//String ns=(String)model.getValueAt(selectedrow, 4);
						//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						//Date convertedCurrentDate;
						//java.sql.Date dt=java.sql.Date.valueOf(ns);
						exdocgia.setNgaysinh((java.sql.Date) model.getValueAt(selectedrow, 4));
//						try {
//							convertedCurrentDate = sdf.parse((String) model.getValueAt(selectedrow, 4));
//							exthuthu.setNgaysinh(convertedCurrentDate);
//						} catch (ParseException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
						
						exdocgia.setSoCMND((BigDecimal)model.getValueAt(selectedrow, 5));
						exdocgia.setSodienthoai((String)model.getValueAt(selectedrow, 6));
						System.out.println(model.getValueAt(selectedrow, 0));
					}
				}
				
			});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		updatetable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 311, 1177, 391);
		scrollPane.setViewportView(table);
		add(scrollPane);
		

		btnfind.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switch ((String)comboboxfind.getSelectedItem()) {
				case "Mã độc giả": {
					listdg=DataDocgia.findDocgia("Ma_DG_20183489", txtfind.getText().trim());
					DefaultTableModel model= DataDocgia.getModeltable(listdg, columnsdocgia);
					table.setModel(model);
					break;
				}
				case "Tên độc giả":{
					listdg=DataDocgia.findDocgia("Ten_DG_20183489", txtfind.getText().trim());
					DefaultTableModel model= DataDocgia.getModeltable(listdg, columnsdocgia);
					table.setModel(model);
					break;
				}
				case "Số điện thoại":{
					listdg=DataDocgia.findDocgia("Dienthoai_20183489", txtfind.getText().trim());
					DefaultTableModel model= DataDocgia.getModeltable(listdg, columnsdocgia);
					table.setModel(model);
					break;
				}
				case "Số CMND":{
					listdg=DataDocgia.findDocgia("CMND_20183489", txtfind.getText().trim());
					DefaultTableModel model= DataDocgia.getModeltable(listdg, columnsdocgia);
					table.setModel(model);
					break;
				}
				}
			}
		});
		

		btndelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtmadg.getText().isBlank() || txtmadg ==null || txtmadg.getText()==null) {
					JOptionPane.showMessageDialog(null, "Chọn độc giả cần xóa !","Error",JOptionPane.ERROR_MESSAGE);
				}
				else {
					int b= JOptionPane.showConfirmDialog(null, "Xóa độc giả có mã số : "+txtmadg.getText()+" ?", "Question",JOptionPane.YES_NO_OPTION);
					if(b==0) {
					
					int a=DataDocgia.deleteDocgia(txtmadg.getText().toString().trim());
					if(a==1) {
						listdg.remove(currentedit);
						JOptionPane.showMessageDialog(null, "Xóa thành công !");
//						int selectedrow=table.getSelectedRow();
						txtmadg.setText(null);
						txtmadg.setEditable(true);
						comboboxgt.setSelectedIndex(0);
						txtemail.setText(null);
						txthoten.setText(null);
						txtcmnd.setText(null);
						txtsdt.setText(null);
						dateChooser_ns.setDate(null);
						//dung de cap nhat lai bang ma chi xoa dong do
						//listtt=DataThuthu.getListThuthu();
						table.setModel(DataDocgia.getModeltable(listdg, columnsdocgia));
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
				txtmadg.setText(String.valueOf(DataDocgia.getthelastDocgia()));
				//txtmadg.setEditable(true);
				comboboxgt.setSelectedIndex(0);
				txtemail.setText(null);
				txthoten.setText(null);
				txtcmnd.setText(null);
				txtsdt.setText(null);
				dateChooser_ns.setDate(null);
			}
		});
		

		btnedit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(exdocgia!=null) {
					currentedit=selectedrow;
					txtmadg.setText(String.valueOf(exdocgia.getMadocgia()));
					txthoten.setText(exdocgia.getTendocgia());
					txtemail.setText(exdocgia.getEmail());
					txtsdt.setText(exdocgia.getSodienthoai());
					if(exdocgia.getGioitinh().equals(new String("Nam"))) comboboxgt.setSelectedIndex(0);
					else comboboxgt.setSelectedIndex(1);
					txtcmnd.setText(String.valueOf(exdocgia.getSoCMND()));
					try {
						java.util.Date date=new SimpleDateFormat("yyyy-MM-dd").parse(exdocgia.getNgaysinh().toString());
						dateChooser_ns.setDate(date);
					} catch (Exception e2) {
						// TODO: handle exception
						System.out.println("loi set ngay sinh vao calendar");
					}
				}
			}
		});

		btnsave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				
					Docgia ex=new Docgia();
					ex.setMadocgia(Integer.parseInt(txtmadg.getText().toString()));
					ex.setTendocgia(txthoten.getText().trim());
					ex.setEmail(txtemail.getText().trim());
					ex.setSodienthoai(txtsdt.getText().trim());
					if((String)comboboxgt.getSelectedItem()=="Nam") ex.setGioitinh("Nam");
					else ex.setGioitinh("Nữ");
					ex.setSoCMND(new BigDecimal((String)txtcmnd.getText().trim()));
					String date=new SimpleDateFormat("yyyy-MM-dd").format(dateChooser_ns.getDate());
					ex.setNgaysinh(java.sql.Date.valueOf(date));
					DataDocgia.insertDocgia(ex);
					JOptionPane.showMessageDialog(null, "Thêm/sửa độc giả thành công");
					updatetable();
					txtmadg.setText(String.valueOf(DataDocgia.getthelastDocgia()));
					//txtmadg.setEditable(true);
					comboboxgt.setSelectedIndex(0);
					txtemail.setText(null);
					txthoten.setText(null);
					txtcmnd.setText(null);
					txtsdt.setText(null);
					dateChooser_ns.setDate(null);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Vui lòng nhập lại thông tin ","Error",JOptionPane.WARNING_MESSAGE);
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
						List<Docgia> listin= getlistdocgiafromexcel(workbook);
						int s=DataDocgia.insertlistdocgia(listin);
						if(s==1) JOptionPane.showMessageDialog(null, "Nhập dữ liệu thành công !");
						updatetable();
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
						XSSFWorkbook wb=writeworkbook(listdg);
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

public List<Docgia> getlistdocgiafromexcel(XSSFWorkbook wb){
	XSSFRow row;
	List<Docgia> listDG=new ArrayList<>();
	XSSFSheet sheet=wb.getSheetAt(0);
	Iterator <Row> iteratorrow=sheet.iterator();
	//iteratorrow.next();
	//bor qua hang dau tien chua header cua file excel
	while(iteratorrow.hasNext()) {
		row=(XSSFRow) iteratorrow.next();
		if(row.getRowNum()==0) continue;
		Iterator <Cell> iteratorcell=row.iterator();
		Docgia s=new Docgia();
//		s.setMadocgia(0);
		while(iteratorcell.hasNext()) {
			Cell cell=iteratorcell.next();
			
//			switch(cell.getCellType()) {
//			case String: 
//			}
			int columnIndex = cell.getColumnIndex();
            
            switch (columnIndex) {
                case 0:
                	//s.setMasach((String)getvalueincell(cell));
                	s.setTendocgia((String)getvalueincell(cell));
                	System.out.println("get hoten excel");
                    break;
                case 1:
                	//s.setTensach((String)getvalueincell(cell));
                	s.setGioitinh((String)getvalueincell(cell));
                	System.out.println(" get gioitinh excel");
                    break;
                case 2:
                	//s.setTacgia((String)getvalueincell(cell));
                	s.setEmail((String)getvalueincell(cell));
                	System.out.println("get email excel");
                	break;
                
                case 3:
				try {
					//String d=(String)getvalueincell(cell);
					System.out.println(getvalueincell(cell));
					//java.util.Date date2=new SimpleDateFormat("M/d/yyyy").parse(d);
					s.setNgaysinh(java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format((java.util.Date)row.getCell(columnIndex).getDateCellValue())));
					System.out.println("get ngaysinh tc");
//					System.out.println(s.getNamxb());
					break;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("loi khi get ns excel");
					e.printStackTrace();
				}
                case 4:
                	//s.setNhaxb((String)getvalueincell(cell));
                	s.setSoCMND(new BigDecimal(row.getCell(columnIndex).getNumericCellValue()));
                	System.out.println(" get cmnd excel");
                	break;
				
                case 5:
                	//s.setDongia((float)row.getCell(columnIndex).getNumericCellValue());
                	s.setSodienthoai((String)getvalueincell(cell));
                	System.out.println("get sdt");
                	break;
//                	try {
//						
//					
////                	tt.setSoCMND(new BigDecimal((Double)getvalueincell(cell)));
//                	tt.setSoCMND(new BigDecimal(row.getCell(columnIndex).getNumericCellValue()));
//                	
//                	System.out.println("loi khi get decimal excel");
//                	System.out.println(tt.getSoCMND());
//                	break;
//                	} catch (Exception e) {
//						// TODO: handle exception
//                		tt.setSoCMND(new BigDecimal((String)getvalueincell(cell)));
//                		break;
//					}
            }
		}
		listDG.add(s);

	}
	
	return listDG;
	
	}

public XSSFWorkbook writeworkbook(List<Docgia>lt) {
	XSSFWorkbook workbook=new XSSFWorkbook();
	XSSFSheet sheet=workbook.createSheet("Quản Lí Độc Giả");
	XSSFRow row;
	
	writeHeader(sheet, 0);
	
	int size=lt.size();
	int rowid=1;
	for(int i=0;i<size;i++) {
		Docgia ex=lt.get(i);
		row=sheet.createRow(rowid);
		for(int j=0;j<7;j++) {
			Cell cell=row.createCell(j);
			switch (j) {
			case 0: {
				
				cell.setCellValue(ex.getMadocgia());
				break;
			}
			case 1: {
				
				cell.setCellValue(ex.getTendocgia());
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
				cell.setCellValue(String.valueOf(ex.getSodienthoai()));
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
    cell.setCellValue("Mã Độc giả");

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
    font.setFontHeightInPoints((short) 14);
    CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
    cellStyle.setFont(font);
    return cellStyle;
}

	public Object getvalueincell(Cell cell) {
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			return cell.getNumericCellValue();
		default:
			return cell.getDateCellValue();
		}
	}
	public XSSFWorkbook openfileexcel(String excelfilepath) throws IOException {
		FileInputStream fileip=new FileInputStream(new File(excelfilepath));
		XSSFWorkbook workbook=new XSSFWorkbook(fileip);
		
		return workbook;
	}
	 private static void autosizeColumn(XSSFSheet sheet, int lastColumn) {
	        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
	            sheet.autoSizeColumn(columnIndex);
	        }
	    }
	private static void updatetable() { 
		listdg=DataDocgia.getListDocgia();
		table.setModel(DataDocgia.getModeltable(listdg, columnsdocgia));
	}
	private JFileChooser getfilechooser() {
		if(filechooser ==null) {
			filechooser=new JFileChooser();
			FileNameExtensionFilter filter =new FileNameExtensionFilter("XLSX", "XLSX");
			filechooser.setFileFilter(filter);
		}
		return filechooser;
	}
}

















