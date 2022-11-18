package Respository;

import Utilities.jdbcUntil;
import entity.KhachHang;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KhachHangRespository extends daoDuAnMau<KhachHang, String> {

    String selectAll = "select * from khachHang";
    String selectId = "select * from khachHang where id=?";

    @Override
    public void insert(KhachHang entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(KhachHang entity, String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<KhachHang> selectAll() {
        return selectBySql(selectAll);
    }

    @Override
    public KhachHang selectById(String id) {
        return selectBySql(selectId, id).get(0);
    }

    @Override
    protected List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUntil.query(sql, args);
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setId(rs.getString("id"));
                kh.setMa(rs.getString("ma"));
                kh.setTen(rs.getString("ten"));
                kh.setTenDem(rs.getString("tenDem"));
                kh.setHo(rs.getString("ho"));
                kh.setNgaySinh(rs.getDate("ngaySinh"));
                kh.setDiaChi(rs.getString("diachi"));
                kh.setSoDT(rs.getString("sdt"));
                kh.setThanhPho(rs.getString("thanhpho"));
                kh.setQuocGia(rs.getString("quocgia"));
                kh.setMatKhau(rs.getString("matkhau"));
                list.add(kh);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
