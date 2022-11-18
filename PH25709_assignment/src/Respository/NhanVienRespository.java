package Respository;

import Utilities.jdbcUntil;
import entity.NhanVien;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhanVienRespository extends daoDuAnMau<NhanVien, String> {
    
    String selectAll = "select * from nhanvien";
    String selectID = "select * from nhanvien where id=?";
    
    @Override
    public void insert(NhanVien entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void update(NhanVien entity, String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public List<NhanVien> selectAll() {
        return selectBySql(selectAll);
    }
    
    @Override
    public NhanVien selectById(String id) {
        return selectBySql(selectID, id).get(0);
    }
    
    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcUntil.query(sql, args);
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                
                nv.setId(rs.getString("id"));
                nv.setMa(rs.getString("ma"));
                nv.setTen(rs.getString("ten"));
                nv.setTenDem(rs.getString("tendem"));
                nv.setHo(rs.getString("ho"));
                nv.setIdCV(rs.getString("idCv"));
                nv.setIdCH(rs.getString("idCH"));
                nv.setIdGuiBC(rs.getString("idGuiBC"));
                nv.setTrangThai(rs.getString("trangthai"));
                nv.setMatKhau(rs.getString("matkhau"));
                nv.setSoDT(rs.getString("sdt"));
                nv.setDiaChi(rs.getString("diachi"));
                nv.setNgaySinh(rs.getDate("ngaysinh"));
                nv.setGioiTinh(rs.getString("gioitinh"));
                
                list.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienRespository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
