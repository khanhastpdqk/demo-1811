package Service.service;

import Respository.HoaDonChiTietRespository;
import entity.HoaDonChiTiet;

public class HoaDonChiTietService implements Service.Interface.IHoaDonChiTietService {

    private HoaDonChiTietRespository hoaDonChiTietRespository;

    public HoaDonChiTietService() {
        hoaDonChiTietRespository = new HoaDonChiTietRespository();
    }

    @Override
    public void insert(HoaDonChiTiet hoaDonChiTiet) {
        hoaDonChiTietRespository.insert(hoaDonChiTiet);
    }

   

}
