package Service.Interface;

import entity.SanPham;
import java.util.List;

public interface ISanPhamService {

    public void insert(SanPham sp);

    public List<SanPham> selectAll();
}
