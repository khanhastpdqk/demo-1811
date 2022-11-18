package ViewsModels;

public class tbHoaDon {

    private String idHoaDon;

    private String ma;

    private String ngayTao;

    private double tongTien;

    private int tinhTrang;

    public tbHoaDon() {
    }

    public tbHoaDon(String idHoaDon, String ma, String ngayTao, double tongTien, int tinhTrang) {
        this.idHoaDon = idHoaDon;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
        this.tinhTrang = tinhTrang;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

}
