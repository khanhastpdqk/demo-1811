package Service.Interface;

import entity.NhaSX;
import java.util.List;

public interface INhaSanXuatService {

    public void insert(NhaSX nhaSX);

    public List<NhaSX> selectAll();
}
