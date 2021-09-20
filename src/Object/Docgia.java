package Object;

import java.math.BigDecimal;
import java.sql.Date;

import org.apache.poi.hpsf.Decimal;

public class Docgia {
	private String tendocgia;
	private String gioitinh;
	private String email;
	private String sodienthoai;
	private BigDecimal soCMND;
	private Date ngaysinh;
	private int madocgia;
	public String getTendocgia() {
		return tendocgia;
	}
	public void setTendocgia(String tendocgia) {
		this.tendocgia = tendocgia;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSodienthoai() {
		return sodienthoai;
	}
	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}
	public BigDecimal getSoCMND() {
		return soCMND;
	}
	public void setSoCMND(BigDecimal soCMND) {
		this.soCMND = soCMND;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public int getMadocgia() {
		return madocgia;
	}
	public void setMadocgia(int madocgia) {
		this.madocgia = madocgia;
	}
	
}
