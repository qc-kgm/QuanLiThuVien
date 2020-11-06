package Control;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu {
	private int menu;
	private JPanel jpn;
	private JLabel jlb;
	
	public Menu(int menu, JPanel jpn, JLabel jlb) {
		this.menu = menu;
		this.jpn = jpn;
		this.jlb = jlb;
	}
	public int getMenu() {
		return menu;
	}
	public void setMenu(int menu) {
		this.menu = menu;
	}
	public JPanel getJpn() {
		return jpn;
	}
	public void setJpn(JPanel jpn) {
		this.jpn = jpn;
	}
	public JLabel getJlb() {
		return jlb;
	}
	public void setJlb(JLabel jlb) {
		this.jlb = jlb;
	}
	
	
}
