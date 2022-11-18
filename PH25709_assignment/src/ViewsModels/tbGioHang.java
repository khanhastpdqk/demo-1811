package ViewsModels;

public class tbGioHang {

    private String idGioHang;
    private String idChiTietSP;
    private String maSp;
    private String tenSP;
    private String ngayTao;
    private String soLuong;
    private String donGia;
    private String thanhTien;

    public tbGioHang() {
    }

    public tbGioHang(String idGioHang, String idChiTietSP, String maSp, String tenSP, String ngayTao, String soLuong, String donGia, String thanhTien) {
        this.idGioHang = idGioHang;
        this.idChiTietSP = idChiTietSP;
        this.maSp = maSp;
        this.tenSP = tenSP;
        this.ngayTao = ngayTao;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public String getIdChiTietSP() {
        return idChiTietSP;
    }

    public void setIdChiTietSP(String idChiTietSP) {
        this.idChiTietSP = idChiTietSP;
    }

    public String getIdGioHang() {
        return idGioHang;
    }

    public void setIdGioHang(String idGioHang) {
        this.idGioHang = idGioHang;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getDonGia() {
        return donGia;
    }

    public void setDonGia(String donGia) {
        this.donGia = donGia;
    }

    public String getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(String thanhTien) {
        this.thanhTien = thanhTien;
    }

}
