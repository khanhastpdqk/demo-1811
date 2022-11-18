package Service.service;

import Respository.TbHoaDonRespository;
import ViewsModels.tbHoaDon;
import java.util.List;

public class TbHoaDonService implements Service.Interface.ITbHoaDonService {

    private TbHoaDonRespository hoaDonRespository;

    public TbHoaDonService() {
        hoaDonRespository = new TbHoaDonRespository();
    }

    @Override
    public List<tbHoaDon> getALl() {
        return hoaDonRespository.getALl();
    }

    @Override
    public List<tbHoaDon> getHdChuaThanhToan() {
        return hoaDonRespository.getChuaThanhToan();
    }

}
