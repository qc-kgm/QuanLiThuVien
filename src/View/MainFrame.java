package View;

import java.awt.BorderLayout;
import Data.Connectdtb;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Window.Type;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Point;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.ImageIcon;
import Control.ChuyenManHinh;
import Control.Menu;
import javax.swing.JTextPane;
public class MainFrame extends JFrame {

	private JPanel contentPane;
	private final JPanel PanelMenu = new JPanel();
	private Menu[] mn;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setLocation(new Point(100, 100));
		setFont(new Font("Arial", Font.PLAIN, 14));
		setTitle("Quan Li Thu Vien");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1155, 751);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		PanelMenu.setBackground(Color.GRAY);
		PanelMenu.setBounds(0, 0, 278, 714);
		contentPane.add(PanelMenu);
		PanelMenu.setLayout(null);
		JPanel PanelView = new JPanel();
		PanelView.setBounds(283, 0, 858, 714);
		contentPane.add(PanelView);
		PanelView.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel jpnQL_sach = new JPanel();
		jpnQL_sach.setBackground(new Color(100, 149, 237));
		jpnQL_sach.setBounds(0, 108, 278, 84);
		PanelMenu.add(jpnQL_sach);
		jpnQL_sach.setLayout(null);
		
		JLabel jlbQL_Sach = new JLabel("QUẢN LÝ SÁCH ");
		jlbQL_Sach.setIcon(new ImageIcon("C:\\Users\\quocc\\eclipse-workspace\\QuanLiThuVien\\src\\image\\2x\\baseline_menu_book_white_24dp.png"));
		jlbQL_Sach.setForeground(new Color(255, 255, 255));
		jlbQL_Sach.setHorizontalAlignment(SwingConstants.CENTER);
		jlbQL_Sach.setFont(new Font("Arial", Font.BOLD, 20));
		jlbQL_Sach.setBounds(23, 10, 224, 64);
		jpnQL_sach.add(jlbQL_Sach);
		
		JPanel jpnQL_thuthu = new JPanel();
		jpnQL_thuthu.setLayout(null);
		jpnQL_thuthu.setBackground(new Color(100, 149, 237));
		jpnQL_thuthu.setBounds(0, 202, 278, 91);
		PanelMenu.add(jpnQL_thuthu);
		
		JLabel jlbQL_Thuthu = new JLabel("QUẢN LÝ THỦ THƯ");
		jlbQL_Thuthu.setIcon(new ImageIcon("C:\\Users\\quocc\\eclipse-workspace\\QuanLiThuVien\\src\\image\\2x\\baseline_admin_panel_settings_white_24dp.png"));
		jlbQL_Thuthu.setHorizontalAlignment(SwingConstants.CENTER);
		jlbQL_Thuthu.setForeground(Color.WHITE);
		jlbQL_Thuthu.setFont(new Font("Arial", Font.BOLD, 20));
		jlbQL_Thuthu.setBounds(21, 10, 236, 64);
		jpnQL_thuthu.add(jlbQL_Thuthu);
		
		JPanel jpnQL_docgia = new JPanel();
		jpnQL_docgia.setLayout(null);
		jpnQL_docgia.setBackground(new Color(100, 149, 237));
		jpnQL_docgia.setBounds(0, 303, 278, 91);
		PanelMenu.add(jpnQL_docgia);
		
		JLabel jlbQL_docgia = new JLabel("QUẢN LÝ ĐỘC GIẢ");
		jlbQL_docgia.setIcon(new ImageIcon("C:\\Users\\quocc\\eclipse-workspace\\QuanLiThuVien\\src\\image\\2x\\baseline_people_alt_white_24dp.png"));
		jlbQL_docgia.setHorizontalAlignment(SwingConstants.CENTER);
		jlbQL_docgia.setForeground(Color.WHITE);
		jlbQL_docgia.setFont(new Font("Arial", Font.BOLD, 20));
		jlbQL_docgia.setBounds(10, 10, 247, 64);
		jpnQL_docgia.add(jlbQL_docgia);
		
		JPanel jpnQL_muontra = new JPanel();
		jpnQL_muontra.setLayout(null);
		jpnQL_muontra.setBackground(new Color(100, 149, 237));
		jpnQL_muontra.setBounds(0, 404, 278, 91);
		PanelMenu.add(jpnQL_muontra);
		
		JLabel jlbQL_muontra = new JLabel("QUẢN LÝ MƯỢN TRẢ");
		jlbQL_muontra.setIcon(new ImageIcon("C:\\Users\\quocc\\eclipse-workspace\\QuanLiThuVien\\src\\image\\2x\\baseline_monetization_on_white_24dp.png"));
		jlbQL_muontra.setHorizontalAlignment(SwingConstants.CENTER);
		jlbQL_muontra.setForeground(Color.WHITE);
		jlbQL_muontra.setFont(new Font("Arial", Font.BOLD, 20));
		jlbQL_muontra.setBounds(10, 10, 258, 74);
		jpnQL_muontra.add(jlbQL_muontra);
		
		JPanel jpnHome = new JPanel();
		jpnHome.setLayout(null);
		jpnHome.setBackground(new Color(255, 0, 0));
		jpnHome.setBounds(0, 0, 278, 98);
		PanelMenu.add(jpnHome);
		
		JLabel lblHome = new JLabel("THƯ VIỆN BK");
		lblHome.setIcon(new ImageIcon("C:\\Users\\quocc\\eclipse-workspace\\QuanLiThuVien\\src\\image\\2x\\baseline_school_white_24dp.png"));
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setForeground(Color.WHITE);
		lblHome.setFont(new Font("Arial", Font.BOLD, 20));
		lblHome.setBounds(10, 20, 258, 48);
		jpnHome.add(lblHome);
		
		JPanel jpnThongke = new JPanel();
		jpnThongke.setLayout(null);
		jpnThongke.setBackground(new Color(100, 149, 237));
		jpnThongke.setBounds(0, 505, 278, 91);
		PanelMenu.add(jpnThongke);
		
		JLabel jlbThongke = new JLabel("THỐNG KÊ DỮ LIỆU");
		jlbThongke.setIcon(new ImageIcon("C:\\Users\\quocc\\eclipse-workspace\\QuanLiThuVien\\src\\image\\2x\\baseline_analytics_white_24dp.png"));
		jlbThongke.setHorizontalAlignment(SwingConstants.CENTER);
		jlbThongke.setForeground(Color.WHITE);
		jlbThongke.setFont(new Font("Arial", Font.BOLD, 20));
		jlbThongke.setBounds(10, 10, 258, 71);
		jpnThongke.add(jlbThongke);
		ChuyenManHinh switchView=new ChuyenManHinh(PanelView);
		//switchView.setView(jpnQL_sach,jlbQL_Sach);
		mn=new Menu[5];
		mn[0]=new Menu(1,jpnQL_sach,jlbQL_Sach);
		mn[1]=new Menu(2,jpnQL_thuthu,jlbQL_Thuthu);
		mn[2]=new Menu(3,jpnQL_docgia,jlbQL_Thuthu);
		mn[3]=new Menu(4,jpnQL_muontra,jlbQL_muontra);
		mn[4]=new Menu(5,jpnThongke,jlbThongke);
		switchView.setEventMenu(mn);
		Connectdtb.getConnection();
		//Connectdtb.displaydata();
		

	}
	

}
