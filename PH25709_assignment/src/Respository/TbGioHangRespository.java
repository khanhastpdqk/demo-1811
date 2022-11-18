package Respository;

import Utilities.jdbcUntil;
import ViewsModels.tbGioHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TbGioHangRespository {
    
    public List<tbGioHang> getALl() {
        List<tbGioHang> list = new ArrayList<>();
        try {
            String sql = "  select giohang.id, SanPham.Ma ,SanPham.Ten, GioHangChiTiet.SoLuong,GioHang.NgayTao,GioHangChiTiet.DonGia,GioHangChiTiet.DonGia * GioHangChiTiet.SoLuong ,GioHangChiTiet.idChiTietSP from GioHang "
                    + "  inner join GioHangChiTiet on GioHang.id= GioHangChiTiet.IdGioHang "
                    + "  inner join ChiTietSP on GioHangChiTiet.IdChiTietSP = ChiTietSP.Id "
                    + "  inner join SanPham on ChiTietSP.IdSP= SanPham.Id where GioHang.TinhTrang=0";
            ResultSet rs = jdbcUntil.query(sql);
            while (rs.next()) {
                tbGioHang gh = new tbGioHang();
                gh.setIdGioHang(rs.getString(1));
                gh.setMaSp(rs.getString(2));
                gh.setTenSP(rs.getString(3));
                gh.setSoLuong(rs.getString(4));
                gh.setNgayTao(rs.getString(5));
                gh.setDonGia(rs.getString(6));
                gh.setThanhTien(rs.getString(7));
                gh.setIdChiTietSP(rs.getString(8));
                list.add(gh);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TbSanPhamRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
