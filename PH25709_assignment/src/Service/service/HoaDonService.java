package Service.service;

import Respository.HoaDonRespository;
import Service.Interface.IDongSPService;
import Views.ViewsDuAnMau;
import entity.DongSP;
import entity.HoaDon;
import java.util.List;

public class HoaDonService implements Service.Interface.IHoaDonService {
    
    private HoaDonRespository hoaDonRespository;
    
    public HoaDonService() {
        hoaDonRespository = new HoaDonRespository();
    }
    
    @Override
    public void insert(HoaDon hoaDon) {
        hoaDonRespository.insert(hoaDon);
    }
    
    @Override
    public List<HoaDon> getAll() {
        return hoaDonRespository.selectAll();
    }
    
    @Override
    public void update(HoaDon hd, String id) {
        hoaDonRespository.update(hd, id);
    }
    
}
