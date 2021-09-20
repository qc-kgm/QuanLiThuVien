package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import com.toedter.calendar.JDateChooser;

import Data.DataThongke;
import Object.Phieumuontra;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class ThongkemuontraView extends JFrame {

	private JPanel contentPane;
	private String[]baocao= {
			"Trong 1 tháng","Trong 4 tháng","Trong 12 tháng","Từ ngày ...đến ngày ..."
	};
	private String[]columnstb= {
			"Tháng","Số lượt mượn sách","Số cuốn sách được mượn"
	};
	private static JTable table;
	private static JFileChooser filechooser;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ThongkemuontraView frame = new ThongkemuontraView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ThongkemuontraView() {
		setTitle("THỐNG KÊ MƯỢN TRẢ SÁCH CỦA THƯ VIỆN");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1044, 709);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnout = new JButton("Xuất báo cáo");
		btnout.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnout.setBounds(826, 9, 169, 43);
		contentPane.add(btnout);
		
		JComboBox comboBox = new JComboBox(baocao);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setBounds(341, 10, 287, 43);
		contentPane.add(comboBox);
		

		
		JDateChooser dateChooser_from = new JDateChooser();
		dateChooser_from.setBounds(338, 78, 127, 30);
		contentPane.add(dateChooser_from);
		
		JDateChooser dateChooser_to = new JDateChooser();
		dateChooser_to.setBounds(501, 78, 127, 30);
		contentPane.add(dateChooser_to);
		
		JLabel lblNewLabel = new JLabel("->");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(475, 78, 23, 26);
		contentPane.add(lblNewLabel);

		table =new JTable() {
	         public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	          }
	       };
	       //Date d=new Date();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 118, 1010, 544);
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
		
		JButton btnNewButton_1 = new JButton("Thống kê");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Date d=new Date();
				switch ((String)comboBox.getSelectedItem()) {
				case "Trong 1 tháng": {
				//"Trong 1 tháng ","Trong 4 tháng","Trong 12 tháng","Từ ngày ...đến ngày ..."	
					table.setModel(DataThongke.gettablemodel(DataThongke.thongke1thang(d.getMonth(),d.getYear()), columnstb, 1));
					break;
				}
				case "Trong 4 tháng":{
					table.setModel(DataThongke.gettablemodel(DataThongke.thongke4thang(d), columnstb, 4));
					break;
					
				}
				case "Trong 12 tháng": {
					table.setModel(DataThongke.gettablemodel(DataThongke.thongke12thang(d), columnstb, 12));
					break;
				}
				case "Từ ngày ...đến ngày ...":{
					try {
						String dateinput=new SimpleDateFormat("yyyy-MM-dd").format(dateChooser_from.getDate());
						String dateouput= new SimpleDateFormat("yyyy-MM-dd").format(dateChooser_to.getDate());
						table.setModel(DataThongke.gettablemodel2(columnstb, DataThongke.getSLMuon2(dateinput,dateouput),DataThongke.getSLSachMuon(dateinput, dateouput)));
						break;
					} catch (Exception e2) {
						// TODO: handle exception
						System.out.println("Error");
						String dateinput=null;
						String dateoutput=null;
						
					}
					
				}
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(638, 10, 110, 42);
		contentPane.add(btnNewButton_1);
		
		
		btnout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getfilechooser();
				int a=filechooser.showSaveDialog(null);
				if(a==JFileChooser.APPROVE_OPTION) {
					File temp=new File( filechooser.getSelectedFile().getAbsolutePath());
					try {
						FileOutputStream fileop=new FileOutputStream(temp);
						XSSFWorkbook wb=writeworkbook();
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
public XSSFWorkbook writeworkbook() {
	XSSFWorkbook workbook=new XSSFWorkbook();
	XSSFSheet sheet=workbook.createSheet("ThongKeMuonTra");
	XSSFRow row;
	writeHeader(sheet, 0);
	int rowid=1;
	DefaultTableModel model=(DefaultTableModel) table.getModel();
	int a= table.getModel().getRowCount();
	for(int i=0;i<a;i++) {
		
		row=sheet.createRow(rowid);
		for(int j=0;j<3;j++) {
			Cell cell=row.createCell(j);
			switch (j) {
			case 0: {
				if(model.getValueAt(i, j)!=null) {
					cell.setCellValue((int)model.getValueAt(i, j));
				}
				else cell.setCellValue("");
				break;
			}
			case 1: {
				
				cell.setCellValue((int)model.getValueAt(i, j));
				break;
			}
			case 2: {
				
				cell.setCellValue((int)model.getValueAt(i, j));
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
    cell.setCellValue("Tháng");

    cell = row.createCell(1);
    cell.setCellStyle(cellStyle);
    cell.setCellValue("Số lượt độc giả mượn sách");

    cell = row.createCell(2);
    cell.setCellStyle(cellStyle);
    cell.setCellValue("Số lượt sách được mượn");

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
 private static void autosizeColumn(XSSFSheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }
}
