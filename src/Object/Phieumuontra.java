package Object;

import java.sql.Date;

public class Phieumuontra {
	private int ma_mt;
	private int ma_dg;
	private String ma_tt;
	private Date ngaymuon;
	private Date ngayhentra;
	private Float tiencoc;
	public int getMa_mt() {
		return ma_mt;
	}
	public void setMa_mt(int ma_mt) {
		this.ma_mt = ma_mt;
	}
	public int getMa_dg() {
		return ma_dg;
	}
	public void setMa_dg(int ma_dg) {
		this.ma_dg = ma_dg;
	}
	public String getMa_tt() {
		return ma_tt;
	}
	public void setMa_tt(String ma_tt) {
		this.ma_tt = ma_tt;
	}
	public Date getNgaymuon() {
		return ngaymuon;
	}
	public void setNgaymuon(Date ngaymuon) {
		this.ngaymuon = ngaymuon;
	}
	public Date getNgayhentra() {
		return ngayhentra;
	}
	public void setNgayhentra(Date ngayhentra) {
		this.ngayhentra = ngayhentra;
	}
	public Float getTiencoc() {
		return tiencoc;
	}
	public void setTiencoc(Float tiencoc) {
		this.tiencoc = tiencoc;
	}
	public Phieumuontra() {
		super();
	}
	
}
