package Respository;

import Utilities.jdbcUntil;
import ViewsModels.tbSanPham;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TbSanPhamRespository {

    public TbSanPhamRespository() {
    }

    public List<tbSanPham> getAllTbSanPham() {
        List<tbSanPham> list = new ArrayList<>();
        try {
            String sql = "select SanPham.Ma ,SanPham.Ten ,ChiTietSP.NamBH,ChiTietSP.SoLuongTon,ChiTietSP.GiaNhap,ChiTietSP.GiaBan ,MauSac.Ten ,DongSP.Ten,NSX.Ten ,ChiTietSP.MoTa "
                    + "from ChiTietSP inner join SanPham on ChiTietSP.IdSP= SanPham.Id "
                    + "inner join MauSac on ChiTietSP.IdMauSac= MauSac.Id "
                    + "inner join DongSP on ChiTietSP.IdDongSP= DongSP.Id "
                    + "inner join NSX on ChiTietSP.IdNsx= NSX.Id";
            ResultSet rs = jdbcUntil.query(sql);

            while (rs.next()) {
                tbSanPham pham = new tbSanPham();
                pham.setMaSP(rs.getString(1));
                pham.setTenSp(rs.getString(2));
                pham.setNamBH(rs.getString(3));
                pham.setSoLuong(rs.getString(4));
                pham.setGiaNhap(rs.getString(5));
                pham.setGiaBan(rs.getString(6));
                pham.setMauSac(rs.getString(7));
                pham.setDongSP(rs.getString(8));
                pham.setNhaSx(rs.getString(9));
                pham.setMoTa(rs.getString(10));
                list.add(pham);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TbSanPhamRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

 

}
