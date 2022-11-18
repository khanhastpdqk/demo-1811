package Service.service;

import Respository.NhaSXRespository;
import Service.Interface.INhaSanXuatService;
import entity.NhaSX;
import java.util.List;

public class NhaSanXuatService implements INhaSanXuatService {

    private NhaSXRespository dao;

    public NhaSanXuatService() {
        dao = new NhaSXRespository();
    }

    @Override
    public void insert(NhaSX nhaSX) {
        dao.insert(nhaSX);
    }

    @Override
    public List<NhaSX> selectAll() {
        return dao.selectAll();
    }

}
