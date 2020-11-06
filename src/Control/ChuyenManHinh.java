package Control;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import View.QLThuthuView;
import View.QuanLiSachView;
public class ChuyenManHinh {
	private JPanel view;
	private String scene;
	
	public ChuyenManHinh(JPanel view) {
		this.view = view;

	}
	public void setView(JPanel views) {
//		jpn.setBackground(new Color(100,100,100));
//		jlb.setBackground(new Color(100,100,100));
		view.removeAll();
		view.setLayout(new BorderLayout());
		view.add(views);
		//Menu[i] truyen vao mang menu va thu tu (switch case) 
		view.validate();
		view.repaint();
	}
	public void setEventMenu(Menu []a) {
//		for(Menu s :a) {
//			s.getJpn().addMouseListener(new ClickEvent(s.getMenu(), s.getJpn(), s.getJlb()));
//		}
		a[0].getJpn().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.println("mouse click done");
				markColorLabel(0, a);
//				a[0].getJpn().setBackground(new Color(100,100,100));
//				a[0].getJlb().setBackground(new Color(100,100,100));
				setView(new QuanLiSachView());
			}
		});
		a[1].getJpn().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.println("mouse 2 click done");
				markColorLabel(1, a);
//				a[1].getJpn().setBackground(new Color(100,100,100));
//				a[1].getJlb().setBackground(new Color(100,100,100));
				setView(new QLThuthuView());
			}
		});
		a[2].getJpn().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.println("mouse 2 click done");
				markColorLabel(2, a);
//				a[1].getJpn().setBackground(new Color(100,100,100));
//				a[1].getJlb().setBackground(new Color(100,100,100));
				setView(new QLThuthuView());
			}
		});
		a[3].getJpn().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.println("mouse 2 click done");
				markColorLabel(3, a);
//				a[1].getJpn().setBackground(new Color(100,100,100));
//				a[1].getJlb().setBackground(new Color(100,100,100));
				setView(new QLThuthuView());
			}
		});
		a[4].getJpn().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.println("mouse 2 click done");
				markColorLabel(4, a);
//				a[1].getJpn().setBackground(new Color(100,100,100));
//				a[1].getJlb().setBackground(new Color(100,100,100));
				setView(new QLThuthuView());
			}
		});
	}
	public void markColorLabel(int i,Menu []m) {
		for(int j=0;j<5;j++) {
			if(j==i) {
				m[j].getJpn().setBackground(new Color(45, 168, 51));
				m[j].getJlb().setBackground(new Color(45, 168, 51));
			}
			else {
				m[j].getJpn().setBackground(new Color(100, 149, 237));
				m[j].getJlb().setBackground(new Color(100, 149, 237));
			}
		
	}
	
}
}
//class ClickEvent implements MouseListener{
//
//	private int menu;
//	private JPanel jpn;
//	private JLabel jlb;
//	
//	public int getMenu() {
//		return menu;
//	}
//
//	public void setMenu(int menu) {
//		this.menu = menu;
//	}
//
//	public JPanel getJpn() {
//		return jpn;
//	}
//
//	public void setJpn(JPanel jpn) {
//		this.jpn = jpn;
//	}
//
//	public JLabel getJlb() {
//		return jlb;
//	}
//
//	public ClickEvent(int menu, JPanel jpn, JLabel jlb) {
//		this.menu = menu;
//		this.jpn = jpn;
//		this.jlb = jlb;
//	}
//
//	public void setJlb(JLabel jlb) {
//		this.jlb = jlb;
//	}
//
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		// TODO Auto-generated method stub
//		jpn.setBackground(new Color(100,100,100));
//		jlb.setBackground(new Color(100,100,100));
////		view.removeAll();
////		view.setLayout(new BorderLayout());
////		view.add(new QuanLiSachView());
////		//Menu[i] truyen vao mang menu va thu tu (switch case) 
////		view.repaint();
//		
//		
//	}
//
//	@Override
//	public void mousePressed(MouseEvent e) {
//		// TODO Auto-generated method stub
//		switch (menu) {
//		case 1: {
//			
//		}
//		case 2:{
//		}
//		case 3:{
//		}
//		case 4: {
//			
//		}
//		case 5:{
//			
//		}
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseEntered(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseExited(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//}
