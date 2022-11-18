package entity;

public class GioHangChiTiet {

    private String idGioHang;
    
    private String idSanPhamCt;
    
    private int soLuong;
    
    private float donGia;
    
    private float donGiaKhiGiam;

    public GioHangChiTiet() {
    }

    public GioHangChiTiet(String idGioHang, String idSanPhamCt, int soLuong, float donGia, float donGiaKhiGiam) {
        this.idGioHang = idGioHang;
        this.idSanPhamCt = idSanPhamCt;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    public String getIdGioHang() {
        return idGioHang;
    }

    public void setIdGioHang(String idGioHang) {
        this.idGioHang = idGioHang;
    }

    public String getIdSanPhamCt() {
        return idSanPhamCt;
    }

    public void setIdSanPhamCt(String idSanPhamCt) {
        this.idSanPhamCt = idSanPhamCt;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public float getDonGiaKhiGiam() {
        return donGiaKhiGiam;
    }

    public void setDonGiaKhiGiam(float donGiaKhiGiam) {
        this.donGiaKhiGiam = donGiaKhiGiam;
    }
    
    
    
}
