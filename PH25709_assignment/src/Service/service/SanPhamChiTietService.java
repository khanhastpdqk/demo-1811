/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.service;

import Respository.SanPhamChiTietRespository;
import entity.SanPhamChiTiet;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public class SanPhamChiTietService implements Service.Interface.ISanPhamChiTiet {

    private SanPhamChiTietRespository sanPhamChiTietRespository;

    public SanPhamChiTietService() {
        sanPhamChiTietRespository = new SanPhamChiTietRespository();
    }

    @Override
    public void insert(SanPhamChiTiet sanPhamChiTiet) {
        sanPhamChiTietRespository.insert(sanPhamChiTiet);
    }

    @Override
    public List<SanPhamChiTiet> getAll() {
        return sanPhamChiTietRespository.selectAll();
    }

    @Override
    public SanPhamChiTiet getByID(String id) {
        return sanPhamChiTietRespository.selectById(id);
    }

    @Override
    public void delete(String id) {
        sanPhamChiTietRespository.delete(id);
    }

    @Override
    public void update(SanPhamChiTiet sanPhamChiTiet, String id) {
        sanPhamChiTietRespository.update(sanPhamChiTiet, id);
    }

}
