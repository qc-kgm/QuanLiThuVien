package View;

import java.awt.Color;

import javax.swing.JPanel;

import Data.DataThongke;

import javax.swing.JLabel;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ThongkeView extends JPanel {

	/**
	 * Create the panel.
	 */
	private static JLabel sach;
	private static JLabel thuthu;
	private static JLabel muon;
	private static JLabel docgia;
	public ThongkeView() {

		setBackground(new Color(141, 181, 150));
		setLayout(null);
		
		 sach = new JLabel("    SÁCH : ");
		sach.setForeground(new Color(255, 255, 255));
		sach.setBackground(new Color(77, 136, 255));
		sach.setFont(new Font("Times New Roman", Font.BOLD, 30));
		sach.setOpaque(true);
		sach.setBounds(227, 125, 314, 170);
		add(sach);
		
		 thuthu = new JLabel("    THỦ THƯ:");
		thuthu.setOpaque(true);
		thuthu.setForeground(Color.WHITE);
		thuthu.setFont(new Font("Times New Roman", Font.BOLD, 30));
		thuthu.setBackground(new Color(77, 136, 255));
		thuthu.setBounds(634, 125, 314, 170);
		add(thuthu);
		
		 muon = new JLabel("    MƯỢN TRẢ:");
		muon.setOpaque(true);
		muon.setForeground(Color.WHITE);
		muon.setFont(new Font("Times New Roman", Font.BOLD, 30));
		muon.setBackground(new Color(77, 136, 255));
		muon.setBounds(227, 349, 314, 170);
		add(muon);
		
		 docgia = new JLabel("     ĐỘC GIẢ:");
		docgia.setOpaque(true);
		docgia.setForeground(Color.WHITE);
		docgia.setFont(new Font("Times New Roman", Font.BOLD, 30));
		docgia.setBackground(new Color(77, 136, 255));
		docgia.setBounds(634, 349, 314, 170);
		add(docgia);
		updatethongtin();
		

		 muon.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		new ThongkemuontraView().setVisible(true);
		 	}
		 });
	}
	public static void updatethongtin() {
//		LocalDate l=LocalDate.now();
//		String d;
//		try {
//			d = (new SimpleDateFormat("yyyy-MM-dd").parse(l.toString())).toString();
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			d="2020-12-30";
//		}
		String d= new SimpleDateFormat("yyyy-MM-dd").format(new Date());

		sach.setText("        SÁCH : "+DataThongke.getSLSach());
		thuthu.setText("        THỦ THƯ : "+DataThongke.getSLThuthu());
		muon.setText("        MƯỢN TRẢ : "+DataThongke.getSLMuon(d));
		docgia.setText("        ĐỘC GIẢ : "+DataThongke.getSLDocgia());
	}
}
