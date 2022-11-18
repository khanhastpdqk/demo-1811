package Respository;

import entity.HoaDon;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utilities.jdbcUntil;

public class HoaDonRespository extends daoDuAnMau<HoaDon, String> {

    String insert = "insert into HoaDon (ma, ngaytao, tinhtrang) values ( ? , ? , ?)";
    String update = "update HoaDOn set tinhtrang = ? where id = ?";
    String delete = "delete HoaDOn where id = ?";
    String selectAll = "select * from HoaDon";
    String selectID = "select * from HoaDOn where id = ?";

    @Override
    public void insert(HoaDon entity) {
        try {
            jdbcUntil.update(insert, entity.getMa(), entity.getNgayTao(), entity.getTinhTrang());
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(HoaDon entity, String id) {
        try {
            jdbcUntil.update(update, entity.getTinhTrang(), id);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String key) {
        try {
            jdbcUntil.update(delete, key);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<HoaDon> selectAll() {
        return selectBySql(selectAll);
    }

    @Override
    public HoaDon selectById(String key) {
        return selectBySql(selectID, key).get(0);
    }

    @Override
    public List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUntil.query(sql, args);
            while (rs.next()) {
                HoaDon don = new HoaDon();
                don.setIdHD(rs.getString("id"));
                don.setIdKH(rs.getString("idkh"));
                don.setIdNV(rs.getString("idnv"));
                don.setMa(rs.getString("ma"));
                don.setNgayTao(rs.getDate("ngayTao"));
                don.setNgayThanhToan(rs.getDate("ngayThanhToan"));
                don.setNgayShip(rs.getDate("ngayShip"));
                don.setNgayNhan(rs.getDate("ngaynhan"));
                don.setTinhTrang(rs.getInt("tinhtrang"));
                don.setTenKH(rs.getString("tennguoinhan"));
                don.setDiaChi(rs.getString("diachi"));
                don.setSoDT(rs.getString("sdt"));
                list.add(don);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
