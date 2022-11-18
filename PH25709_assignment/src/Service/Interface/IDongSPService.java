package Service.Interface;

import entity.DongSP;
import java.util.List;

public interface IDongSPService {

    public List<DongSP> getAll();

    public void insert(DongSP dongSP);
}
