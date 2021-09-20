package View;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Data.Connectdtb;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import Data.DataSach;
import Data.DataThuthu;
import Object.Sach;
import Object.Thuthu;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
public class QuanLiSachView extends JPanel {
	private JTable table;
	private static JFileChooser filechooser;
	private static Sach exsach;
	private DataSach dtsach;
	private JTextField txtmasach;
	private JTextField txttensach;
	private JTextField txttacgia;
	private JTextField txtnhaxb;
	private JTextField txtdongia;
	private JTextField txtfind;
	private static int currentedit;
	private static int selectedrow;
	private List<Sach> listbook;
	private static String[] cbtinhtrang= {
			"Đang cho thuê","Sẵn sàng"
	};
	private static String[] cbfind= {
			"Mã sách","Tên sách","Năm xuất bản","Tác giả"
	};
	public static String[] columns_Sach= {
			"Mã sách","Tên sách","Tác giả","Năm xuất bản","Nhà xuất bản","Đơn giá","Tình trạng","Giới thiệu"
	};
	/**
	 * Create the panel.
	 */
	public QuanLiSachView() {
		setBackground(new Color(141, 181, 150));
		setLayout(null);
		
//		JTextPane DisplaySach = new JTextPane();
//		DisplaySach.setBounds(10, 232, 848, 479);
//		add(DisplaySach);
		
		
		JLabel lblMatt = new JLabel("Mã Sách");
		lblMatt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMatt.setBounds(33, 11, 102, 37);
		add(lblMatt);
		
		JLabel lblHvt = new JLabel("Tên Sách");
		lblHvt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHvt.setBounds(33, 58, 102, 37);
		add(lblHvt);
		
		JLabel lblEmail = new JLabel("Tác giả");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(33, 105, 102, 37);
		add(lblEmail);
		
		JLabel lblsodt = new JLabel("Năm xuất bản");
		lblsodt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblsodt.setBounds(33, 154, 102, 37);
		add(lblsodt);
		
		JLabel lblsocmnd = new JLabel("Nhà xuất bản");
		lblsocmnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblsocmnd.setBounds(33, 201, 102, 37);
		add(lblsocmnd);
		
		txtmasach = new JTextField();
		txtmasach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtmasach.setColumns(10);
		txtmasach.setEditable(false);
		txtmasach.setBounds(177, 11, 112, 37);
		add(txtmasach);
		
		txttensach = new JTextField();
		txttensach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txttensach.setColumns(10);
		txttensach.setBounds(177, 58, 307, 37);
		add(txttensach);
		
		txttacgia = new JTextField();
		txttacgia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txttacgia.setColumns(10);
		txttacgia.setBounds(177, 105, 307, 37);
		add(txttacgia);
		
		txtnhaxb = new JTextField();
		txtnhaxb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtnhaxb.setColumns(10);
		txtnhaxb.setBounds(177, 201, 307, 37);
		add(txtnhaxb);
		
		JLabel lblGt = new JLabel("Tình trạng");
		lblGt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGt.setBounds(293, 11, 81, 37);
		add(lblGt);
		
		JButton btnnew = new JButton("New");
		btnnew.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnnew.setBounds(568, 58, 123, 37);
		add(btnnew);
		
		JButton btnedit = new JButton("Edit");
		btnedit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnedit.setBounds(568, 107, 123, 37);
		add(btnedit);
		
		JButton btnsave = new JButton("Save");
		btnsave.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnsave.setBounds(703, 107, 123, 37);
		add(btnsave);
		
		JLabel lblNgS = new JLabel("Đơn giá");
		lblNgS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgS.setBounds(33, 248, 102, 37);
		add(lblNgS);
		
		JComboBox comboboxtt = new JComboBox(cbtinhtrang);
		comboboxtt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboboxtt.setBounds(372, 11, 112, 37);
		add(comboboxtt);
		
		txtdongia = new JTextField();
		txtdongia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtdongia.setColumns(10);
		txtdongia.setBounds(177, 248, 307, 37);
		add(txtdongia);
		
		JButton btndelete = new JButton("Delete");
		btndelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btndelete.setBounds(703, 58, 123, 37);
		add(btndelete);
		
		JButton btnin = new JButton("Nhập dữ liệu");
		btnin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnin.setBounds(568, 11, 180, 37);
		add(btnin);
		
		JButton btnout = new JButton("Xuất báo cáo");
		btnout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnout.setBounds(781, 11, 180, 37);
		add(btnout);
		
		JTextPane txtgioithieu = new JTextPane();
		txtgioithieu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtgioithieu.setBounds(647, 203, 333, 82);
		add(txtgioithieu);
		
		JLabel lblNewLabel = new JLabel("Giới thiệu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(568, 246, 96, 37);
		add(lblNewLabel);
		
		JComboBox comboBoxfind = new JComboBox(cbfind);
		comboBoxfind.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxfind.setBounds(701, 156, 125, 37);
		add(comboBoxfind);
		
		JButton btnfind = new JButton("Find");
		btnfind.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnfind.setBounds(568, 154, 123, 37);
		add(btnfind);
		
		txtfind = new JTextField();
		txtfind.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtfind.setColumns(10);
		txtfind.setBounds(836, 154, 144, 37);
		add(txtfind);

		JDateChooser dateChooser_xb = new JDateChooser();
		dateChooser_xb.setBounds(177, 154, 307, 37);
		add(dateChooser_xb);
		
		
		JScrollPane scrollPane=new JScrollPane();
		scrollPane.setBounds(10, 295, 1180, 416);
		table = new JTable() {
	         public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	          }
	       };
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//List<Sach> listdatasach=DataSach.getListSach();
		//DefaultTableModel dtm=DataSach.modelSach(listdatasach,columns_Sach);
		updatetablesach();
		//table.setModel(dtm);
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				exsach=new Sach();
				if(table.getSelectedRow()!=-1) {
					DefaultTableModel model=(DefaultTableModel) table.getModel();
					 selectedrow=table.getSelectedRow();
//					exthuthu.setMathuthu((String)model.getValueAt(selectedrow,0 ));
//					exthuthu.setHovaten((String)model.getValueAt(selectedrow, 1));
//					exthuthu.setGioitinh((String)model.getValueAt(selectedrow, 2));
//					exthuthu.setEmail((String) model.getValueAt(selectedrow, 3));
					//exthuthu.setNgaysinh(Date.valueOf((String)model.getValueAt(selectedrow, 4)));
					//String ns=(String)model.getValueAt(selectedrow, 4);
					//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					//Date convertedCurrentDate;
					//java.sql.Date dt=java.sql.Date.valueOf(ns);
					//exthuthu.setNgaysinh((java.sql.Date) model.getValueAt(selectedrow, 4));
					exsach.setMasach((String)model.getValueAt(selectedrow, 0));
					exsach.setTensach((String)model.getValueAt(selectedrow , 1));
					exsach.setTacgia((String)model.getValueAt(selectedrow, 2));
					exsach.setNhaxb((String)model.getValueAt(selectedrow, 4));
					exsach.setNamxb((java.sql.Date)model.getValueAt(selectedrow, 3));
					exsach.setDongia(Float.parseFloat(model.getValueAt(selectedrow, 5).toString()));
					if(model.getValueAt(selectedrow, 6).equals("Sẵn sàng")) 
						exsach.setTinhtrang(true);
					else exsach.setTinhtrang(false);
					exsach.setGioithieu((String)model.getValueAt(selectedrow, 7));
//					try {
//						convertedCurrentDate = sdf.parse((String) model.getValueAt(selectedrow, 4));
//						exthuthu.setNgaysinh(convertedCurrentDate);
//					} catch (ParseException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
					
					//exthuthu.setSoCMND((BigDecimal)model.getValueAt(selectedrow, 5));
					//exthuthu.setDienthoai((String)model.getValueAt(selectedrow, 6));
					System.out.println(model.getValueAt(selectedrow, 0));
				}
			}
			
		});
		scrollPane.setViewportView(table);
		add(scrollPane);
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		btnnew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtmasach.setText(null);
				txtmasach.setEditable(true);
				txttensach.setText(null);
				txttacgia.setText(null);
				txtdongia.setText(null);
				txtnhaxb.setText(null);
				comboboxtt.setSelectedItem(new String("Sẵn sàng"));
				txtgioithieu.setText(null);
				dateChooser_xb.setDate(null);
			
				
			}
		});

		btnedit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(exsach!=null) {
					currentedit=selectedrow;
					txtmasach.setText(exsach.getMasach());
					txtmasach.setEditable(false);
					txttensach.setText(exsach.getTensach());
					txttacgia.setText(exsach.getTacgia());
					txtdongia.setText(String.valueOf(exsach.getDongia()));
					txtnhaxb.setText(exsach.getNhaxb());
					txtgioithieu.setText(exsach.getGioithieu());
					if(exsach.getTinhtrang()) comboboxtt.setSelectedIndex(1);
					else comboboxtt.setSelectedIndex(0);
					//txtnamxb.setText(null);
					try {
						java.util.Date date=new SimpleDateFormat("yyyy-MM-dd").parse(exsach.getNamxb().toString());
						dateChooser_xb.setDate(date);
					} catch (Exception e2) {
						// TODO: handle exception
						System.out.println("loi get ngay vao calendar");
					}
				}
			}
		});

		btnsave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
				
				Sach ex=new Sach();
				ex.setMasach(txtmasach.getText());
				ex.setTensach((String)txttensach.getText().trim());
				ex.setGioithieu((String)txtgioithieu.getText().trim());
				ex.setNhaxb((String)txtnhaxb.getText().trim());
				ex.setDongia(Float.parseFloat(txtdongia.getText().trim()));
				if(((String)comboboxtt.getSelectedItem()).equals(new String("Sẵn sàng"))) ex.setTinhtrang(true);
				else ex.setTinhtrang(false);
				ex.setTacgia(txttacgia.getText().trim());
				String date=new SimpleDateFormat("yyyy-MM-dd").format(dateChooser_xb.getDate());
				ex.setNamxb(java.sql.Date.valueOf(date));
//				DataSach
				DataSach.insertSachData(ex);
				JOptionPane.showMessageDialog(null, "Thêm/sửa phiếu mượn thành công");
				txtmasach.setText(null);
				txtmasach.setEditable(true);
				txttensach.setText(null);
				txttacgia.setText(null);
				txtdongia.setText(null);
				txtnhaxb.setText(null);
				txtgioithieu.setText(null);
				dateChooser_xb.setDate(null);
				updatetablesach();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Vui lòng nhập lại thông tin ","Error",JOptionPane.WARNING_MESSAGE);

				}
			}
		});

		btnfind.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switch ((String)comboBoxfind.getSelectedItem()) {
				case "Mã sách" : {
					listbook=DataSach.findSachData("Masach_20183489", txtfind.getText().trim());
					table.setModel(DataSach.modelSach(listbook, columns_Sach));
					table.repaint();
					break;
				}
				case "Tác giả":{
					listbook=DataSach.findSachData("Tacgia_20183489", txtfind.getText().trim());
					table.setModel(DataSach.modelSach(listbook, columns_Sach));
					table.repaint();
					break;
					
				}
				case "Tên sách":{
					listbook=DataSach.findSachData("Tensach_20183489", txtfind.getText().trim());
					table.setModel(DataSach.modelSach(listbook, columns_Sach));
					table.repaint();
					break;
				}
				case "Năm xuất bản":{
					listbook=DataSach.findSachData("NamXB_20183489", txtfind.getText().trim());
					table.setModel(DataSach.modelSach(listbook, columns_Sach));
					table.repaint();
					break;
				}
				}
			}
		});
		btndelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtmasach.getText().isBlank() || txtmasach ==null || txtmasach.getText()==null) {
					JOptionPane.showMessageDialog(null, "Chọn sách cần xóa !","Error",JOptionPane.ERROR_MESSAGE);
				}
				else {
					int b= JOptionPane.showConfirmDialog(null, "Xóa Sách "+txttensach.getText()+" ?", "Question",JOptionPane.YES_NO_OPTION);
					if(b==0) {
					
					int a=DataSach.deletesach(txtmasach.getText().toString());
					if(a==1) {
						
						JOptionPane.showMessageDialog(null, "Xóa thành công !");
//						int selectedrow=table.getSelectedRow();
						listbook.remove(currentedit);//dung de cap nhat lai bang ma chi xoa dong do
						//listtt=DataThuthu.getListThuthu();
						txtmasach.setText(null);
						txtmasach.setEditable(true);
						txttensach.setText(null);
						txttacgia.setText(null);
						txtdongia.setText(null);
						txtnhaxb.setText(null);
						txtgioithieu.setText(null);
						
						dateChooser_xb.setDate(null);
						table.setModel(DataSach.modelSach(listbook, columns_Sach));
						table.repaint();
						//btnfind.click;
					}
					}
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
						List<Sach> listin= getlistsachfromexcel(workbook);
						int s=DataSach.insertlistsach(listin);
						if(s==1) JOptionPane.showMessageDialog(null, "Nhập dữ liệu thành công !");
						updatetablesach();
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
						XSSFWorkbook wb=writeworkbook(listbook);
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
public XSSFWorkbook writeworkbook(List<Sach>ls) {
	XSSFWorkbook workbook=new XSSFWorkbook();
	XSSFSheet sheet=workbook.createSheet("QuanLiSach");
	XSSFRow row;
	writeHeader(sheet, 0);
	
	int size=ls.size();
	int rowid=1;
	for(int i=0;i<size;i++) {
		Sach ex=ls.get(i);
		row=sheet.createRow(rowid);
		for(int j=0;j<8;j++) {
			Cell cell=row.createCell(j);
//			"Mã sách","Tên sách","Tác giả","Năm xuất bản","Nhà xuất bản","Đơn giá","Tình trạng","Giới thiệu"
			switch (j) {
			case 0: {
				
				cell.setCellValue(ex.getMasach());
				break;
			}
			case 1: {
				
				cell.setCellValue(ex.getTensach());
				break;
			}
			case 2: {
				
				cell.setCellValue(ex.getTacgia());
				break;
			}
			case 3: {
				
				cell.setCellValue(ex.getNamxb());
				break;
			}
			case 4: {
				
				cell.setCellValue(ex.getNhaxb());
				break;
			}
			case 5: {
				
				cell.setCellValue(ex.getDongia());
				break;
			}
			case 6:{
				if(ex.getTinhtrang()) cell.setCellValue("Sẵn sàng");
				else cell.setCellValue("Đang cho thuê");
//				cell.setCellValue(ex.getTinhtrang());
				break;
			}

			case 7:{
				cell.setCellValue(ex.getGioithieu());
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
    cell.setCellValue("Mã Sách");

    cell = row.createCell(1);
    cell.setCellStyle(cellStyle);
    cell.setCellValue("Tên Sách");

    cell = row.createCell(2);
    cell.setCellStyle(cellStyle);
    cell.setCellValue("Tác Giả");

    cell = row.createCell(3);
    cell.setCellStyle(cellStyle);
    cell.setCellValue("Năm xuất bản");

    cell = row.createCell(4);
    cell.setCellStyle(cellStyle);
    cell.setCellValue("Nhà xuất bản");
    cell = row.createCell(5);
    cell.setCellStyle(cellStyle);
    cell.setCellValue("Đơn giá");
    cell = row.createCell(6);
    cell.setCellStyle(cellStyle);
    cell.setCellValue("Tình trạng");
    cell=row.createCell(7);
    cell.setCellStyle(cellStyle);
    cell.setCellValue("Giới thiệu");
    
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
public List<Sach> getlistsachfromexcel(XSSFWorkbook wb){
	XSSFRow row;
	List<Sach> listS=new ArrayList<>();
	XSSFSheet sheet=wb.getSheetAt(0);
	Iterator <Row> iteratorrow=sheet.iterator();
	//iteratorrow.next();
	//bor qua hang dau tien chua header cua file excel
	while(iteratorrow.hasNext()) {
		row=(XSSFRow) iteratorrow.next();
		if(row.getRowNum()==0) continue;
		Iterator <Cell> iteratorcell=row.iterator();
		Sach s=new Sach();
		while(iteratorcell.hasNext()) {
			Cell cell=iteratorcell.next();
			
//			switch(cell.getCellType()) {
//			case String: 
//			}
			int columnIndex = cell.getColumnIndex();
            
            switch (columnIndex) {
                case 0:
                	s.setMasach((String)getvalueincell(cell));
                	System.out.println("loi khi get matt excel");
                    break;
                case 1:
                	s.setTensach((String)getvalueincell(cell));
                	System.out.println("loi khi get hoten excel");
                    break;
                case 2:
                	s.setTacgia((String)getvalueincell(cell));
                	System.out.println("loi khi get gt excel");
                	break;
                
                case 3:
				try {
					//String d=(String)getvalueincell(cell);
					System.out.println(getvalueincell(cell));
					//java.util.Date date2=new SimpleDateFormat("M/d/yyyy").parse(d);
					s.setNamxb(java.sql.Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format((java.util.Date)row.getCell(columnIndex).getDateCellValue())));
					System.out.println("get ngaysinh tc");
					System.out.println(s.getNamxb());
					break;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("loi khi get nam xb excel");
					e.printStackTrace();
				}
                case 4:
                	s.setNhaxb((String)getvalueincell(cell));
                	System.out.println("loi khi get nha xb excel");
                	break;
				
                case 5:
                	s.setDongia((float)row.getCell(columnIndex).getNumericCellValue());
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
                case 6:
                    String d=row.getCell(columnIndex).toString().trim();
                    if(d.equals(new String("Đang cho thuê"))) s.setTinhtrang(false);
                    else s.setTinhtrang(true);
                    break;
                case 7:
                	s.setGioithieu((String)getvalueincell(cell));
                	break;
            }
		}
		listS.add(s);

	}
	
	return listS;
	
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
	 private static void autosizeColumn(XSSFSheet sheet, int lastColumn) {
	        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
	            sheet.autoSizeColumn(columnIndex);
	        }
	    }
	public void updatetablesach() {
		listbook = DataSach.getListSach();
		table.setModel(DataSach.modelSach(listbook, columns_Sach));
	}
	
	
}
