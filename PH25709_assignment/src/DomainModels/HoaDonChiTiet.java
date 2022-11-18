package entity;

public class HoaDonChiTiet {

    private String idHoaDon;
    
    private String idChiTietSp;
    
    private int soLuong;
    
    private float donGia;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String idHoaDon, String idChiTietSp, int soLuong, float donGia) {
        this.idHoaDon = idHoaDon;
        this.idChiTietSp = idChiTietSp;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getIdChiTietSp() {
        return idChiTietSp;
    }

    public void setIdChiTietSp(String idChiTietSp) {
        this.idChiTietSp = idChiTietSp;
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

}
