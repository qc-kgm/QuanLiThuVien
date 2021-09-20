package Object;

import java.sql.Date;

public class Chitietphieumuon {
	private int ma_mt;
	private String masach;
	private String ghichu;
	private Date ngaytra;
	private Float tienphat;
	public int getMa_mt() {
		return ma_mt;
	}
	public void setMa_mt(int ma_mt) {
		this.ma_mt = ma_mt;
	}
	public String getMasach() {
		return masach;
	}
	public void setMasach(String masach) {
		this.masach = masach;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	public Date getNgaytra() {
		return ngaytra;
	}
	public void setNgaytra(Date ngaytra) {
		this.ngaytra = ngaytra;
	}

	public Float getTienphat() {
		return tienphat;
	}
	public void setTienphat(Float tienphat) {
		this.tienphat = tienphat;
	}
	public Chitietphieumuon() {
		super();
	}
	
}
