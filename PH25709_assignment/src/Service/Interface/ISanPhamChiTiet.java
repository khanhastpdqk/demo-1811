/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import entity.SanPhamChiTiet;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public interface ISanPhamChiTiet {

    public void insert(SanPhamChiTiet sanPhamChiTiet);

    public List<SanPhamChiTiet> getAll();

    public SanPhamChiTiet getByID(String id);

    public void delete(String id);

    public void update(SanPhamChiTiet sanPhamChiTiet, String id);
}
