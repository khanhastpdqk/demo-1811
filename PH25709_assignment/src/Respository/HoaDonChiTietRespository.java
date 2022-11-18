package Respository;

import Utilities.jdbcUntil;
import entity.HoaDonChiTiet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HoaDonChiTietRespository extends daoDuAnMau<HoaDonChiTiet, String> {

    String insert = "insert into hoadonCHitiet(idhoadon,idchitietSP, soluong,dongia) values (?,?,?,?)";
    String delete = "delete hoadonchitiet where id=?";
    String update = "update hoadonchitiet set soluong=?,dongia=? where idchitietsp=?";
    String selectAll = "select * from hoadonChitiet";
    String selectid = " select * from hoadonchitiet where idHoaDon=?";

    @Override

    public void insert(HoaDonChiTiet entity) {
        try {
            jdbcUntil.update(insert, entity.getIdHoaDon(), entity.getIdChiTietSp(), entity.getSoLuong(), entity.getDonGia());
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonChiTietRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(HoaDonChiTiet entity, String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HoaDonChiTiet> selectAll() {
        return selectBySql(selectAll);
    }

    @Override
    public HoaDonChiTiet selectById(String key) {
        return selectBySql(selectid, key).get(0);
    }

    @Override
    protected List<HoaDonChiTiet> selectBySql(String sql, Object... args) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUntil.query(sql, args);
            while (rs.next()) {
                HoaDonChiTiet chiTiet = new HoaDonChiTiet();
                chiTiet.setIdHoaDon(rs.getString("idHoaDon"));
                chiTiet.setIdChiTietSp(rs.getString("idchitietSP"));
                chiTiet.setSoLuong(rs.getInt("soluong"));
                chiTiet.setDonGia(rs.getFloat("dongia"));
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonChiTietRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
