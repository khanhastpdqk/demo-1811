package Service.Interface;

import entity.HoaDon;
import java.util.List;

public interface IHoaDonService {

    public void insert(HoaDon hd);

    public List<HoaDon> getAll();

    public void update(HoaDon hd, String id);
}
