package Respository;

import entity.SanPham;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utilities.jdbcUntil;

public class SanPhamRespository extends daoDuAnMau<SanPham, String> {

    String selectById = "select * from sanPham where id = ?";
    String insert = "insert into sanpham(ma,ten) values (?,?)";
    String selectAll = "select * from SanPham";

    public SanPhamRespository() {
    }

    @Override
    public void insert(SanPham entity) {
        try {
            jdbcUntil.update(insert, entity.getMa(), entity.getTen());
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(SanPham entity, String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SanPham> selectAll() {
        return this.selectBySql(selectAll);
    }

    @Override
    public SanPham selectById(String id) {
        List<SanPham> listSp = this.selectBySql(selectById, id);
        if (listSp.isEmpty()) {
            return null;
        }
        return listSp.get(0);
    }

    @Override
    public List<SanPham> selectBySql(String sql, Object... args) {
        List<SanPham> listSp = new ArrayList<>();
        try {
            ResultSet rs = jdbcUntil.query(sql, args);
            while (rs.next()) {
                SanPham pham = new SanPham(rs.getString("id"), rs.getString("ma"), rs.getString("ten"));
                listSp.add(pham);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSp;
    }

}
