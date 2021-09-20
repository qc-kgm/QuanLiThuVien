package Object;

import java.math.BigDecimal;
import java.sql.Date;


public class Thuthu {
	private String mathuthu;
	private String hovaten;
	private String gioitinh;
	private BigDecimal soCMND;
	private String email;
	private String dienthoai;
	private Date ngaysinh;
	
	public Thuthu() {
		
	}
	public Thuthu(String mathuthu, String hovaten, String gioitinh, BigDecimal soCMND, String email, String dienthoai,
			Date ngaysinh) {
		super();
		this.mathuthu = mathuthu;
		this.hovaten = hovaten;
		this.gioitinh = gioitinh;
		this.soCMND = soCMND;
		this.email = email;
		this.dienthoai = dienthoai;
		this.ngaysinh = ngaysinh;
	}
	public String getMathuthu() {
		return mathuthu;
	}
	public void setMathuthu(String mathuthu) {
		this.mathuthu = mathuthu;
	}
	public String getHovaten() {
		return hovaten;
	}
	public void setHovaten(String hovaten) {
		this.hovaten = hovaten;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public BigDecimal getSoCMND() {
		return soCMND;
	}
	public void setSoCMND(BigDecimal soCMND) {
		this.soCMND = soCMND;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDienthoai() {
		return dienthoai;
	}
	public void setDienthoai(String dienthoai) {
		this.dienthoai = dienthoai;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	
	
}
