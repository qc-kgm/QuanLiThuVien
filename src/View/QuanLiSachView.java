package View;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Data.Connectdtb;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuanLiSachView extends JPanel {
	private JTextField textTensach;
	private JTextField textTacgia;
	private JTextField textMasach;

	/**
	 * Create the panel.
	 */
	public QuanLiSachView() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên Sách :");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(28, 20, 98, 39);
		add(lblNewLabel);
		
		JLabel lblTcGi = new JLabel("Tác giả     :");
		lblTcGi.setFont(new Font("Arial", Font.BOLD, 16));
		lblTcGi.setBounds(28, 69, 98, 39);
		add(lblTcGi);
		
		JLabel lblMSch = new JLabel("Mã Sách   :");
		lblMSch.setFont(new Font("Arial", Font.BOLD, 16));
		lblMSch.setBounds(28, 121, 98, 39);
		add(lblMSch);
		
		textTensach = new JTextField();
		textTensach.setBounds(127, 28, 204, 27);
		add(textTensach);
		textTensach.setColumns(10);
		
		textTacgia = new JTextField();
		textTacgia.setColumns(10);
		textTacgia.setBounds(127, 77, 204, 27);
		add(textTacgia);
		
		textMasach = new JTextField();
		textMasach.setColumns(10);
		textMasach.setBounds(127, 129, 204, 27);
		add(textMasach);
		
		JLabel lblFind = new JLabel("Find");
		lblFind.setFont(new Font("Arial", Font.BOLD, 20));
		lblFind.setIcon(new ImageIcon("C:\\Users\\quocc\\eclipse-workspace\\QuanLiThuVien\\src\\image\\2x\\baseline_find_in_page_black_24dp.png"));
		lblFind.setBounds(374, 28, 98, 39);
		add(lblFind);
		
		JLabel lblEdit = new JLabel("Edit");
		lblEdit.setIcon(new ImageIcon("C:\\Users\\quocc\\eclipse-workspace\\QuanLiThuVien\\src\\image\\2x\\baseline_edit_black_24dp.png"));
		lblEdit.setFont(new Font("Arial", Font.BOLD, 20));
		lblEdit.setBounds(377, 103, 98, 39);
		add(lblEdit);
		
		JLabel lblNew = new JLabel("New");
		lblNew.setIcon(new ImageIcon("C:\\Users\\quocc\\eclipse-workspace\\QuanLiThuVien\\src\\image\\2x\\baseline_note_add_black_24dp.png"));
		lblNew.setFont(new Font("Arial", Font.BOLD, 20));
		lblNew.setBounds(516, 28, 98, 39);
		add(lblNew);
		
		JLabel lblDelete = new JLabel("Delete");
		lblDelete.setIcon(new ImageIcon("C:\\Users\\quocc\\eclipse-workspace\\QuanLiThuVien\\src\\image\\2x\\baseline_delete_forever_black_24dp.png"));
		lblDelete.setFont(new Font("Arial", Font.BOLD, 20));
		lblDelete.setBounds(516, 103, 117, 39);
		add(lblDelete);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 255, 224));
		panel.setBounds(0, 0, 868, 191);
		add(panel);
		
		JTextPane DisplaySach = new JTextPane();
		DisplaySach.setBounds(10, 232, 848, 479);
		add(DisplaySach);
		
	}
}
