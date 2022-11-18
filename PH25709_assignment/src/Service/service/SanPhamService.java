package Service.service;

import Respository.SanPhamRespository;
import Service.Interface.ISanPhamService;
import entity.SanPham;
import java.util.List;

public class SanPhamService implements ISanPhamService {

    private SanPhamRespository dao;

    public SanPhamService() {
        dao = new SanPhamRespository();
    }

    @Override
    public void insert(SanPham sp) {
        dao.insert(sp);
    }

    @Override
    public List<SanPham> selectAll() {
        return dao.selectAll();
    }

}
