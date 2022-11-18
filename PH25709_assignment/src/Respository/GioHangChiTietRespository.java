package Respository;

import Utilities.jdbcUntil;
import Respository.daoDuAnMau;
import entity.GioHangChiTiet;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GioHangChiTietRespository extends daoDuAnMau<GioHangChiTiet, String> {

    String selectID = "select * from GioHangChiTiet where idChiTietSP = ?";
    String selectAll = "select * from GioHangChiTiet";
    String insert = "insert into GioHangChiTiet(idgiohang, idchiTietSP, soluong, dongia, dongiakhigiam) values (? , ? , ? , ? , ?)";
    String delete = "delete gioHangChiTIet where IdChiTietSP = ? ";
    String update = "update gioHangChiTIet set soluong = ? where IdChiTietSP = ?";

    @Override

    public void insert(GioHangChiTiet entity) {
        try {
            jdbcUntil.update(insert, entity.getIdGioHang(), entity.getIdSanPhamCt(), entity.getSoLuong(), entity.getDonGia(), entity.getDonGiaKhiGiam());
        } catch (SQLException ex) {
            Logger.getLogger(GioHangChiTietRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(GioHangChiTiet entity, String key) {
        try {
            jdbcUntil.update(update, entity.getSoLuong(),key);
        } catch (SQLException ex) {
            Logger.getLogger(GioHangChiTietRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String key) {
        try {
            jdbcUntil.update(delete, key);
        } catch (SQLException ex) {
            Logger.getLogger(GioHangChiTietRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<GioHangChiTiet> selectAll() {
        return selectBySql(selectAll);
    }

    @Override
    public GioHangChiTiet selectById(String key) {
        return selectBySql(selectID, key).get(0);
    }

    @Override
    protected List<GioHangChiTiet> selectBySql(String sql, Object... args) {
        List<GioHangChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUntil.query(sql, args);
            while (rs.next()) {
                GioHangChiTiet ghct = new GioHangChiTiet();
                ghct.setIdGioHang(rs.getString("idGioHang"));
                ghct.setIdSanPhamCt(rs.getString("idChiTietSP"));
                ghct.setSoLuong(rs.getInt("soLuong"));
                ghct.setDonGia(rs.getFloat("Dongia"));
                ghct.setDonGiaKhiGiam(rs.getFloat("DonGiaKhiGiam"));
                list.add(ghct);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(GioHangChiTietRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
