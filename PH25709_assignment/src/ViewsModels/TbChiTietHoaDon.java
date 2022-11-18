package ViewsModels;

public class TbChiTietHoaDon {
    private String id;
    private String tenSp;
    private int soLuong;
    private float donGia;
    private String mauSac;
    private String dongSP;
    private String nhaSx;

    public TbChiTietHoaDon() {
    }

    public TbChiTietHoaDon(String tenSp, int soLuong, float donGia, String mauSac, String dongSP, String nhaSx) {
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.mauSac = mauSac;
        this.dongSP = dongSP;
        this.nhaSx = nhaSx;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
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

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getDongSP() {
        return dongSP;
    }

    public void setDongSP(String dongSP) {
        this.dongSP = dongSP;
    }

    public String getNhaSx() {
        return nhaSx;
    }

    public void setNhaSx(String nhaSx) {
        this.nhaSx = nhaSx;
    }

}
