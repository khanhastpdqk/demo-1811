package Service.Interface;

import entity.GioHang;
import java.util.List;

public interface IGioHangService {

    public List<GioHang> getAll();

    public void insert(GioHang gh);

    public void delete(String id);

    public void update(GioHang gh, String id);

}
