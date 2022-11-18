package Service.service;

import Respository.MauRespository;
import Service.Interface.IMauService;
import entity.Mau;
import java.util.List;

public class MauService implements IMauService{

    private MauRespository dao;

    public MauService() {
        dao = new MauRespository();
    }

    @Override
    public void insert(Mau mau) {
        dao.insert(mau);
    }

    @Override
    public List<Mau> getAll() {
        return dao.selectAll();
    }
}
