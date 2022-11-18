package Service.service;

import Service.Interface.ITbSanPhamService;
import Respository.TbSanPhamRespository;
import ViewsModels.tbSanPham;
import java.util.List;

public class TbSanPhamService implements ITbSanPhamService {

    private TbSanPhamRespository phamRespository;

    public TbSanPhamService() {
        phamRespository = new TbSanPhamRespository();
    }

    @Override
    public List<tbSanPham> getALl() {
        return phamRespository.getAllTbSanPham();
    }

}
