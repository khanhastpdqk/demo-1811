package Respository;

import entity.GioHang;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utilities.jdbcUntil;

public class GioHangRespository extends daoDuAnMau<GioHang, String> {

    String insert = "insert into gioHang(ngaytao,tinhtrang) values (?,?)";
    String selectID = "select * from giohang where id=?";
    String selectAll = "select * from giohang";
    String delete = "delete giohang where id=?";
    String update = "Update gioHang set tinhtrang=? where id=?";

    @Override
    public void insert(GioHang entity) {
        try {
            jdbcUntil.update(insert, entity.getNgayTao(), entity.getTinhTrang());
        } catch (SQLException ex) {
            Logger.getLogger(GioHangRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(GioHang entity, String key) {
        try {
            jdbcUntil.update(update, entity.getTinhTrang(), key);
        } catch (SQLException ex) {
            Logger.getLogger(GioHangRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String key) {
        try {
            jdbcUntil.update(delete, key);
        } catch (SQLException ex) {
            Logger.getLogger(GioHangRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<GioHang> selectAll() {
        return selectBySql(selectAll);
    }

    @Override
    public GioHang selectById(String id) {
        return this.selectBySql(selectID, id).get(0);
    }

    @Override
    public List<GioHang> selectBySql(String sql, Object... args) {
        List<GioHang> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUntil.query(sql, args);
            while (rs.next()) {
                GioHang gh = new GioHang();
                gh.setId(rs.getString("id"));
                gh.setIdKH(rs.getString("idKH"));
                gh.setIdNv(rs.getString("idNV"));
                gh.setMa(rs.getString("ma"));
                gh.setNgayTao(rs.getDate("ngaytao"));
                gh.setNgayThanhToan(rs.getDate("ngayThanhToan"));
                gh.setTenNguoiNhan(rs.getString("TenNguoiNhan"));
                gh.setDiaChi(rs.getString("DiaChi"));
                gh.setSdt(rs.getString("sdt"));
                gh.setTinhTrang(rs.getInt("TinhTrang"));
                list.add(gh);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(GioHangRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
