package Service.Interface;

import entity.GioHangChiTiet;
import java.util.List;

public interface IGioHangChiTietService {

    List<GioHangChiTiet> getAll();

    void insert(GioHangChiTiet gioHangChiTiet);

    void update(GioHangChiTiet gioHangChiTiet, String id);

    void delete(String id);

   
}
