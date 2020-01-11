package vn.quanlykh.bo;


public class KhachHang {
	private int id;
	private String tenKH;
	private String thongTin;
	private String trangThai;
	private String sdt;
	private String tenMien;
	private String ngay;
	private String sale;
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangthai) {
		this.trangThai = trangthai;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenkh) {
		this.tenKH = tenkh;
	}
	public String getThongTin() {
		return thongTin;
	}
	public void setThongTin(String thongtin) {
		this.thongTin = thongtin;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getTenMien() {
		return tenMien;
	}
	public void setTenMien(String tenmien) {
		this.tenMien = tenmien;
	}
	public String getNgay() {
		return ngay;
	}
	public void setNgay(String ngay) {
		this.ngay = ngay;
	}
	public String getSale() {
		return sale;
	}
	public void setSale(String sale) {
		this.sale = sale;
	}
	
}
