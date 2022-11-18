package Service.service;

import Respository.TbChiTietHoaDonRespository;
import ViewsModels.TbChiTietHoaDon;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TbChiTietHoaDonService implements Service.Interface.ITbChiTietHoaDonService {

    private TbChiTietHoaDonRespository tbChiTietHoaDonRespository;

    public TbChiTietHoaDonService() {
        tbChiTietHoaDonRespository = new TbChiTietHoaDonRespository();
    }

    @Override
    public List<TbChiTietHoaDon> getByALl() {
        return tbChiTietHoaDonRespository.selectAll();

    }

}
