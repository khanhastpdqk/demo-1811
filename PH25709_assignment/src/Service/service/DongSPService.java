package Service.service;

import Respository.DongSPRespository;
import Service.Interface.IDongSPService;
import entity.DongSP;
import java.util.List;

public class DongSPService implements IDongSPService {

    private DongSPRespository dao;

    public DongSPService() {
        dao = new DongSPRespository();
    }

    @Override
    public void insert(DongSP dongSP) {
        dao.insert(dongSP);
    }

    @Override
    public List<DongSP> getAll() {
        return dao.selectAll();
    }
}
