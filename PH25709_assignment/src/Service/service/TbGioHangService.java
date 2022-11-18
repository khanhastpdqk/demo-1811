package Service.service;

import Respository.TbGioHangRespository;
import ViewsModels.tbGioHang;
import java.util.List;

public class TbGioHangService implements Service.Interface.ITbGioHangService {

    private TbGioHangRespository gioHangRespository;

    public TbGioHangService() {
        gioHangRespository = new TbGioHangRespository();
    }

    @Override
    public List<tbGioHang> getALl() {
        return gioHangRespository.getALl();
    }
    

}
