package Respository;

import Utilities.jdbcUntil;
import ViewsModels.tbHoaDon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TbHoaDonRespository {
    
    public List<tbHoaDon> getALl() {
        List<tbHoaDon> list = new ArrayList<>();
        try {
            String sql = " select HoaDon.Ma,HoaDon.NgayTao,sum(soluong*DonGia) ,hoadon.TinhTrang ,hoadon.id from HoaDonChiTiet inner join hoadon on hoadonchitiet.IdHoaDon=hoadon.id group by HoaDon.id, HoaDon.Ma,HoaDon.NgayTao,HoaDon.TinhTrang";
            ResultSet rs = jdbcUntil.query(sql);
            while (rs.next()) {
                tbHoaDon hd = new tbHoaDon();
                hd.setMa(rs.getString(1));
                hd.setNgayTao(rs.getString(2));
                hd.setTongTien(rs.getDouble(3));
                hd.setTinhTrang(rs.getInt(4));
                hd.setIdHoaDon(rs.getString(5));
                list.add(hd);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TbSanPhamRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<tbHoaDon> getChuaThanhToan() {
        List<tbHoaDon> list = new ArrayList<>();
        try {
            String sql = " select HoaDon.Ma,HoaDon.NgayTao ,hoadon.TinhTrang from  hoadon where tinhTrang=?";
            ResultSet rs = jdbcUntil.query(sql, 0);
            while (rs.next()) {
                tbHoaDon hd = new tbHoaDon();
                hd.setMa(rs.getString(1));
                hd.setNgayTao(rs.getString(2));
                hd.setTinhTrang(rs.getInt(3));
                list.add(hd);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TbSanPhamRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
