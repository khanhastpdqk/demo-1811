package Service.service;

import Respository.GioHangChiTietRespository;
import entity.GioHangChiTiet;
import java.util.ArrayList;
import java.util.List;

public class GioHangChiTietService implements Service.Interface.IGioHangChiTietService {

    private GioHangChiTietRespository gioHangChiTietRespository;

    public GioHangChiTietService() {
        gioHangChiTietRespository = new GioHangChiTietRespository();
    }

    @Override
    public void insert(GioHangChiTiet gioHangChiTiet) {
        gioHangChiTietRespository.insert(gioHangChiTiet);
    }

    @Override
    public void update(GioHangChiTiet gioHangChiTiet, String id) {
        gioHangChiTietRespository.update(gioHangChiTiet, id);
    }

    @Override
    public List<GioHangChiTiet> getAll() {
        return gioHangChiTietRespository.selectAll();
    }

    @Override
    public void delete(String id) {
        gioHangChiTietRespository.delete(id);
    }

    

}
