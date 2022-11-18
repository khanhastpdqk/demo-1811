package Respository;

import Utilities.jdbcUntil;
import ViewsModels.TbChiTietHoaDon;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TbChiTietHoaDonRespository {

    String sql = "  select SanPham.Ten , HoaDonChiTiet.SoLuong , HoaDonChiTiet.DonGia , DongSP.Ten , MauSac.Ten , NSX.Ten , idhoadon from HoaDonChiTiet"
            + " inner join ChiTietSP on HoaDonChiTiet.IdChiTietSP= ChiTietSP.id"
            + " inner join SanPham on ChiTietSP.IdSP= SanPham.Id "
            + "inner join DongSP on ChiTietSP.IdDongSP= DongSP.id "
            + "inner join MauSac on ChiTietSP.IdMauSac = MauSac.Id"
            + " inner join NSX on ChiTietSP.IdNsx = NSX.id ";

    public TbChiTietHoaDonRespository() {
    }

    public List<TbChiTietHoaDon> selectAll() {
        List<TbChiTietHoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUntil.query(sql);
            while (rs.next()) {
                TbChiTietHoaDon tbChiTietHoaDon = new TbChiTietHoaDon();
                tbChiTietHoaDon.setTenSp(rs.getString(1));
                tbChiTietHoaDon.setSoLuong(rs.getInt(2));
                tbChiTietHoaDon.setDonGia(rs.getFloat(3));
                tbChiTietHoaDon.setDongSP(rs.getString(4));
                tbChiTietHoaDon.setMauSac(rs.getString(5));
                tbChiTietHoaDon.setNhaSx(rs.getString(6));
                tbChiTietHoaDon.setId(rs.getString(7));
                list.add(tbChiTietHoaDon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TbChiTietHoaDonRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
