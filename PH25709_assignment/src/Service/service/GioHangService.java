package Service.service;

import Respository.GioHangRespository;
import entity.GioHang;
import java.util.List;

public class GioHangService implements Service.Interface.IGioHangService {

    private GioHangRespository gioHangRespository;

    public GioHangService() {
        gioHangRespository = new GioHangRespository();
    }

    @Override
    public List<GioHang> getAll() {
        return gioHangRespository.selectAll();
    }

    @Override
    public void insert(GioHang gh) {
        gioHangRespository.insert(gh);
    }

    @Override
    public void delete(String id) {
        gioHangRespository.delete(id);
    }

    @Override
    public void update(GioHang gh, String id) {
        gioHangRespository.update(gh, id);
    }

}
