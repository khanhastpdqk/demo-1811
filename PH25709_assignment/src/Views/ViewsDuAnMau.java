package Views;

import Service.service.DongSPService;
import Service.service.GioHangChiTietService;
import Service.service.GioHangService;
import Service.service.HoaDonChiTietService;
import Service.service.HoaDonService;
import Service.service.MauService;
import Service.service.NhaSanXuatService;
import Service.service.SanPhamChiTietService;
import Service.service.SanPhamService;
import Service.service.TbGioHangService;
import Service.service.TbHoaDonService;
import Service.service.TbSanPhamService;

import ViewsModels.tbGioHang;
import ViewsModels.tbHoaDon;
import ViewsModels.tbSanPham;

import entity.DongSP;
import entity.GioHang;
import entity.GioHangChiTiet;
import entity.HoaDon;
import entity.HoaDonChiTiet;
import entity.Mau;
import entity.NhaSX;
import entity.SanPham;
import entity.SanPhamChiTiet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ViewsDuAnMau extends javax.swing.JFrame {

    // khai báo các lớp 
    private NhaSanXuatService nhaSanXuatService = new NhaSanXuatService();
    private SanPhamService sanPhamService = new SanPhamService();
    private DongSPService dongSPService = new DongSPService();
    private MauService mauService = new MauService();
    private TbSanPhamService tbSanPhamService = new TbSanPhamService();
    private TbGioHangService tbGioHangService = new TbGioHangService();
    private TbHoaDonService tbHoaDonService = new TbHoaDonService();
    private GioHangService gh = new GioHangService();
    private SanPhamChiTietService sanPhamChiTietService = new SanPhamChiTietService();
    private HoaDonService hoaDonService = new HoaDonService();
    private GioHangChiTietService gioHangChiTietService = new GioHangChiTietService();
    private HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietService();
// khai bao cac form khac
    private AddMau m = new AddMau();
    private AddDongSp d = new AddDongSp();
    private AddNsx n = new AddNsx();
    private AddSp htsp = new AddSp();
    String idHoaDon = "";

    public ViewsDuAnMau() {
        initComponents();
        loadSanPham();
        loadMau();
        loadNsx();
        loadDongSp();
        loadSpCombobox();
        loadGioHang();
        loadHoaDon();
    }

    // load san pham len table
    void loadSanPham() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tblSanPham.getModel();
        defaultTableModel.setRowCount(0);
        int stt = 1;
        for (tbSanPham sp : tbSanPhamService.getALl()) {
            defaultTableModel.addRow(new Object[]{stt, sp.getMaSP(), sp.getTenSp(), sp.getNamBH(), sp.getSoLuong(), sp.getGiaNhap(), sp.getGiaBan(), sp.getMauSac(), sp.getDongSP(), sp.getNhaSx(), sp.getMoTa()});
            stt = stt + 1;
        }
    }

    //load sản phẩm lên giỏ hàng
    void loadGioHang() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tblGioHang.getModel();
        defaultTableModel.setRowCount(0);
        int stt = 1;
        for (tbGioHang gh : tbGioHangService.getALl()) {
            defaultTableModel.addRow(new Object[]{stt, gh.getMaSp(), gh.getTenSP(), gh.getNgayTao(), gh.getSoLuong(), gh.getDonGia(), gh.getThanhTien()});
            stt = stt + 1;
        }

    }

    void loadHoaDon() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tblHoaDon1.getModel();
        defaultTableModel.setRowCount(0);
        int stt = 1;
        for (tbHoaDon hoaDon : tbHoaDonService.getALl()) {
            defaultTableModel.addRow(new Object[]{stt, hoaDon.getMa(), hoaDon.getNgayTao(), hoaDon.getTongTien(), hoaDon.getTinhTrang() == 1 ? "da thanh toan" : "chua thanh toan"});
            stt = stt + 1;
        }
        List<tbHoaDon> list = tbHoaDonService.getHdChuaThanhToan();
        if (list.isEmpty() == false) {
            String ma = "", date = "";
            for (tbHoaDon hoaDon : list) {
                ma = hoaDon.getMa();
                date = hoaDon.getNgayTao();
            }

            int rowCount = tblGioHang.getRowCount();
            float tongTien = 0;
            for (int i = 0; i < rowCount; i++) {
                int sl = Integer.parseInt(tblGioHang.getValueAt(i, 4).toString());
                float donGia = Float.parseFloat(tblGioHang.getValueAt(i, 5).toString());
                tongTien = tongTien + sl * donGia;
            }
            defaultTableModel.addRow(new Object[]{tblHoaDon1.getRowCount() + 1, ma, date, tongTien, "chua thanh toan"});
        }
    }

    // load màu lên combobox
    void loadMau() {
        DefaultComboBoxModel defaultComboBoxModel = (DefaultComboBoxModel) cbMau.getModel();
        for (int i = 0; i < mauService.getAll().size(); i++) {
            defaultComboBoxModel.addElement(mauService.getAll().get(i).getTen());
        }
    }

    // load nhà sản xuất lên combobox
    void loadNsx() {
        DefaultComboBoxModel defaultComboBoxModel = (DefaultComboBoxModel) cbNSX.getModel();
        for (int i = 0; i < nhaSanXuatService.selectAll().size(); i++) {
            defaultComboBoxModel.addElement(nhaSanXuatService.selectAll().get(i).getTen());
        }
    }

    // load dòng sản phẩm lên combo box
    void loadDongSp() {
        DefaultComboBoxModel defaultComboBoxModel = (DefaultComboBoxModel) cbDong.getModel();
        for (int i = 0; i < dongSPService.getAll().size(); i++) {
            defaultComboBoxModel.addElement(dongSPService.getAll().get(i).getTen());
        }
    }

    // load loại san phẩm lên combobox
    void loadSpCombobox() {
        DefaultComboBoxModel defaultComboBoxModel = (DefaultComboBoxModel) cbSanPham.getModel();
        for (int i = 0; i < sanPhamService.selectAll().size(); i++) {
            defaultComboBoxModel.addElement(sanPhamService.selectAll().get(i).getTen());
        }
    }

    // set lai cac o text ve trang thai ban dau
    void clear() {
        txtNamBH.setText("");
        txtSoLuong.setText("");
        txtGiaNhap.setText("");
        txtGiaBan.setText("");
        txtMoTa.setText("");
        cbDong.setSelectedIndex(0);
        cbMau.setSelectedIndex(0);
        cbNSX.setSelectedIndex(0);
        cbSanPham.setSelectedIndex(0);
        tblSanPham.removeRowSelectionInterval(0, tblSanPham.getRowCount() - 1);

        txtDonGia.setText("");
        txtMaSPGioHang.setText("");
        txtTenSPGioHang.setText("");
        txtThanhTien.setText("");
        txtSoLuongGioHang.setText("");
        txtNgayTao.setText("");
        if (tblGioHang.getRowCount() > 0) {
            tblGioHang.removeRowSelectionInterval(0, tblGioHang.getRowCount() - 1);
        }
    }

    SanPhamChiTiet getDuLieu() {
        SanPhamChiTiet spct = new SanPhamChiTiet();
        // set cac thuoc tinh san co
        spct.setNamBH(Integer.parseInt(txtNamBH.getText().trim()));
        spct.setSoLuong(Integer.parseInt(txtSoLuong.getText().trim()));
        spct.setGiaNhap(Float.parseFloat(txtGiaNhap.getText().trim()));
        spct.setGiaBan(Float.parseFloat(txtGiaBan.getText().trim()));
        spct.setMota(txtMoTa.getText());

        // lay ten  mau dong sp, nsx tu combobox
        String mau = cbMau.getSelectedItem().toString();
        String dongSP = cbDong.getSelectedItem().toString();
        String nsx = cbNSX.getSelectedItem().toString();
        String sp = cbSanPham.getSelectedItem().toString();

        // truyen ten mau, nsx, dong vao ham getid -> nhan lai id
        List<String> list = getID(mau, nsx, dongSP, sp);
        spct.setIdMauSac(list.get(0));
        spct.setIdNhaSX(list.get(1));
        spct.setIdDongSP(list.get(2));
        spct.setIdSp(list.get(3));

        return spct;
    }

    // get id mau sac, nha san xuat, dong san pham, loai san pham
    List<String> getID(String mauSac, String nhaSX, String dongSp, String sp) {
        String idMau = "", idNsx = "", idDong = "", idsp = "";
        for (Mau SP : mauService.getAll()) {
            if (mauSac.trim().equals(SP.getTen()) == true) {
                idMau = SP.getId();
                break;
            }
        }
        for (NhaSX SP : nhaSanXuatService.selectAll()) {
            if (nhaSX.trim().equals(SP.getTen()) == true) {
                idNsx = SP.getId();
                break;
            }
        }
        for (DongSP SP : dongSPService.getAll()) {
            if (dongSp.trim().equals(SP.getTen()) == true) {
                idDong = SP.getId();
                break;
            }
        }
        for (SanPham SP : sanPhamService.selectAll()) {
            if (sp.trim().equals(SP.getTen()) == true) {
                idsp = SP.getId();
                break;
            }
        }
        List list = new ArrayList<>();
        list.add(idMau);
        list.add(idNsx);
        list.add(idDong);
        list.add(idsp);

        return list;
    }

    // lay id cua san pham chi tiet
    String getIDSanPhamCT() {
        // xac nhan xem da chon hay chua
        int row = tblSanPham.getSelectedRow();
        if (row == -1) {
            return null;
        }

        // lay du lieu tu bang
        String maSP = tblSanPham.getValueAt(row, 1).toString();
        int namBh = Integer.parseInt(tblSanPham.getValueAt(row, 3).toString());
        int soLuong = Integer.parseInt(tblSanPham.getValueAt(row, 4).toString());
        float giaNhap = Float.parseFloat(tblSanPham.getValueAt(row, 5).toString());
        float giaBan = Float.parseFloat(tblSanPham.getValueAt(row, 6).toString());
        String moTa = tblSanPham.getValueAt(row, 10).toString();

        String mauSac = tblSanPham.getValueAt(row, 7).toString();
        String dongSp = tblSanPham.getValueAt(row, 8).toString();
        String nhaSX = tblSanPham.getValueAt(row, 9).toString();
        String tenSp = tblSanPham.getValueAt(row, 2).toString();

        // truyen mau sac, nha san xuat, dong san pham -> nhan lai id
        List<String> list = this.getID(mauSac, nhaSX, dongSp, tenSp);

        // tim kiem id san pham chi tiet thong qua tat ca cac du lieu trong bang
        for (SanPhamChiTiet sanPhamChiTiet : sanPhamChiTietService.getAll()) {
            if (list.get(3).equals(sanPhamChiTiet.getIdSp())
                    && list.get(0).equals(sanPhamChiTiet.getIdMauSac())
                    && list.get(1).equals(sanPhamChiTiet.getIdNhaSX())
                    && list.get(2).equals(sanPhamChiTiet.getIdDongSP())
                    && namBh == sanPhamChiTiet.getNamBH()
                    && moTa.equals(sanPhamChiTiet.getMota())
                    && soLuong == sanPhamChiTiet.getSoLuong()
                    && giaNhap == sanPhamChiTiet.getGiaNhap()
                    && giaBan == sanPhamChiTiet.getGiaBan()) {
                // tim thay thi return id
                return sanPhamChiTiet.getId();
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        views = new javax.swing.JTabbedPane();
        jPanelSanPham = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNamBH = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        txtGiaNhap = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        btnThem = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        cbMau = new javax.swing.JComboBox<>();
        cbDong = new javax.swing.JComboBox<>();
        cbNSX = new javax.swing.JComboBox<>();
        btnThemMau = new javax.swing.JButton();
        btnThemDong = new javax.swing.JButton();
        btnThemNsx = new javax.swing.JButton();
        cbSanPham = new javax.swing.JComboBox<>();
        btnThemSp = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnAddGioHang = new javax.swing.JButton();
        txtSoLuongThemGiohang = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanelGioHang = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        txtMaSPGioHang = new javax.swing.JTextField();
        txtSoLuongGioHang = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        txtThanhTien = new javax.swing.JTextField();
        btnXoaGioHang = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        txtTenSPGioHang = new javax.swing.JTextField();
        btnUpdateGioHang = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblHoaDon1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnTaoHoaDon = new javax.swing.JButton();
        btnReset1 = new javax.swing.JButton();
        btnThongtinchitiet = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        txtTinhTrang = new javax.swing.JTextField();
        txtNgayTaoHD = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel3.setText("Năm BH");

        jLabel4.setText("Số lượng");

        jLabel5.setText("Giá nhập");

        jLabel6.setText("Giá Bán");

        jLabel7.setText("Mô tả");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane1.setViewportView(txtMoTa);

        btnThem.setText("Add");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        cbMau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Màu sắc" }));
        cbMau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbMauMouseClicked(evt);
            }
        });

        cbDong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dòng sp" }));
        cbDong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbDongMouseClicked(evt);
            }
        });

        cbNSX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhà sx" }));
        cbNSX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbNSXMouseClicked(evt);
            }
        });

        btnThemMau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/plus.png"))); // NOI18N
        btnThemMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMauActionPerformed(evt);
            }
        });

        btnThemDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/plus.png"))); // NOI18N
        btnThemDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDongActionPerformed(evt);
            }
        });

        btnThemNsx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/plus.png"))); // NOI18N
        btnThemNsx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNsxActionPerformed(evt);
            }
        });

        cbSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sản phẩm" }));
        cbSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbSanPhamMouseClicked(evt);
            }
        });

        btnThemSp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Views/plus.png"))); // NOI18N
        btnThemSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtGiaBan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNamBH, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnThemNsx, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnThemSp, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(cbDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnThemDong, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addGap(99, 99, 99)
                                    .addComponent(btnThemMau, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnThem)
                        .addGap(15, 15, 15)
                        .addComponent(btnUpdate)
                        .addGap(15, 15, 15)
                        .addComponent(btnDelete)
                        .addGap(15, 15, 15)
                        .addComponent(btnReset)))
                .addContainerGap())
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnThemDong, btnThemNsx});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnThemMau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnThemSp))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThemDong))
                    .addComponent(cbNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemNsx))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNamBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnReset))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Năm BH", "Số lượng SP", "Giá nhập", "Giá bán", "Màu sắc", "Dòng sản phẩm", "NSX", "Mô tả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblSanPham);

        btnAddGioHang.setText("Thêm giỏ hàng");
        btnAddGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddGioHangActionPerformed(evt);
            }
        });

        jLabel1.setText("Số lượng");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(42, 42, 42)
                        .addComponent(txtSoLuongThemGiohang, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnAddGioHang)
                        .addGap(0, 461, Short.MAX_VALUE))
                    .addComponent(jScrollPane4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddGioHang)
                            .addComponent(txtSoLuongThemGiohang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelSanPhamLayout = new javax.swing.GroupLayout(jPanelSanPham);
        jPanelSanPham.setLayout(jPanelSanPhamLayout);
        jPanelSanPhamLayout.setHorizontalGroup(
            jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelSanPhamLayout.setVerticalGroup(
            jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        views.addTab("Sản Phẩm", jPanelSanPham);

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel8.setText("Mã SP");

        jLabel9.setText("Tên SP");

        jLabel10.setText("Số lượng");

        jLabel11.setText("Đơn giá");

        jLabel12.setText("Thành Tiền");

        txtNgayTao.setEnabled(false);

        txtMaSPGioHang.setEnabled(false);

        txtDonGia.setEnabled(false);

        txtThanhTien.setEnabled(false);

        btnXoaGioHang.setText("Delete");
        btnXoaGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaGioHangActionPerformed(evt);
            }
        });

        jLabel24.setText("Ngày tạo");

        txtTenSPGioHang.setEnabled(false);

        btnUpdateGioHang.setText("Update");
        btnUpdateGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateGioHangActionPerformed(evt);
            }
        });

        btnThanhToan.setText("Thanh Toan");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenSPGioHang)
                            .addComponent(txtMaSPGioHang)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSoLuongGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnXoaGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateGioHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtDonGia, txtMaSPGioHang, txtNgayTao, txtSoLuongGioHang, txtThanhTien});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSPGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(13, 13, 13)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenSPGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaGioHang)
                    .addComponent(btnUpdateGioHang))
                .addGap(18, 18, 18)
                .addComponent(btnThanhToan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Ngày tạo", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblGioHang);

        tblHoaDon1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã HĐ", "Ngày tạo", "Tổng tiền", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon1.setFocusTraversalPolicyProvider(true);
        tblHoaDon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDon1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblHoaDon1);
        if (tblHoaDon1.getColumnModel().getColumnCount() > 0) {
            tblHoaDon1.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnTaoHoaDon.setText("Tao hoa don");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        btnReset1.setText("Reset");
        btnReset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset1ActionPerformed(evt);
            }
        });

        btnThongtinchitiet.setText("Thong tin chi tiet");
        btnThongtinchitiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongtinchitietActionPerformed(evt);
            }
        });

        jLabel2.setText("Mã HD");

        jLabel13.setText("Ngày tạo");

        jLabel14.setText("Tổng tiền");

        jLabel15.setText("Tình trạng");

        txtMaHD.setEnabled(false);

        txtTongTien.setEnabled(false);

        txtTinhTrang.setEnabled(false);

        txtNgayTaoHD.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThongtinchitiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTinhTrang, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(txtNgayTaoHD)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNgayTaoHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoHoaDon)
                    .addComponent(btnReset1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThongtinchitiet)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelGioHangLayout = new javax.swing.GroupLayout(jPanelGioHang);
        jPanelGioHang.setLayout(jPanelGioHangLayout);
        jPanelGioHangLayout.setHorizontalGroup(
            jPanelGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGioHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanelGioHangLayout.setVerticalGroup(
            jPanelGioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGioHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        views.addTab("Giỏ Hàng", jPanelGioHang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(views)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(views))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        String ma = JOptionPane.showInputDialog(this, "Nhap ma hoa don");
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        int tinhTrang = 0;
        HoaDon don = new HoaDon();
        don.setMa(ma);
        don.setNgayTao(date);
        don.setTinhTrang(tinhTrang);
        int xacNhan = JOptionPane.showConfirmDialog(this, "Xac nhan tao hoa don", "", JOptionPane.YES_NO_OPTION);
        if (xacNhan == JOptionPane.YES_OPTION) {
            hoaDonService.insert(don);
            loadHoaDon();
            JOptionPane.showMessageDialog(this, "Tao hoa don thanh cong");
        }

    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void btnAddGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddGioHangActionPerformed
        int slThem = 0;
        try {
            slThem = Integer.parseInt(txtSoLuongThemGiohang.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nhập số lượng sản phẩm muốn thêm vào giỏ hàng");
            return;
        }

        for (GioHang gioHang : gh.getAll()) {
            if (gioHang.getTinhTrang() == 0) {
        // them san pham vao gio hang chi tiet
                GioHangChiTiet chiTiet = new GioHangChiTiet();

                SanPhamChiTiet sanPhamChiTiet = sanPhamChiTietService.getByID(getIDSanPhamCT());
                chiTiet.setIdGioHang(gioHang.getId());
//                for (GioHangChiTiet gioHangChiTiet : gioHangChiTietService.getAll()) {
//                    if (gioHangChiTiet.getIdSanPhamCt().equals(getIDSanPhamCT()) == false) {
                        chiTiet.setIdSanPhamCt(getIDSanPhamCT());

                        chiTiet.setSoLuong(slThem);
                        chiTiet.setDonGia(sanPhamChiTiet.getGiaBan());

                        gioHangChiTietService.insert(chiTiet);
                        loadGioHang();
                        loadHoaDon();
                        txtSoLuongThemGiohang.setText("");
                        return;
//                    } else {
//                        JOptionPane.showMessageDialog(this, "da co san pham trong gio hang");
//                        return;
//                    }
//                }

            }
        }

        GioHang hang = new GioHang();
        // ngay he thong
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);

        hang.setNgayTao(date);
        hang.setTinhTrang(0);// 0 neu chua thanh toan, 1 la da thanh toan
        gh.insert(hang);// them mot gio hang moi
        btnAddGioHangActionPerformed(evt);
    }//GEN-LAST:event_btnAddGioHangActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked

        int row = tblSanPham.getSelectedRow();
        //txtMaSP.setText(tblSanPham.getValueAt(row, 1).toString());
        txtNamBH.setText(tblSanPham.getValueAt(row, 3).toString());
        txtSoLuong.setText(tblSanPham.getValueAt(row, 4).toString());
        txtGiaNhap.setText(tblSanPham.getValueAt(row, 5).toString());
        txtGiaBan.setText(tblSanPham.getValueAt(row, 6).toString());
        txtMoTa.setText(tblSanPham.getValueAt(row, 10).toString());

        cbSanPham.setSelectedItem(tblSanPham.getValueAt(row, 2).toString());
        cbMau.setSelectedItem(tblSanPham.getValueAt(row, 7).toString());
        cbDong.setSelectedItem(tblSanPham.getValueAt(row, 8).toString());
        cbNSX.setSelectedItem(tblSanPham.getValueAt(row, 9).toString());
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnThemSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSpActionPerformed
        htsp.setVisible(true);
    }//GEN-LAST:event_btnThemSpActionPerformed

    private void cbSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbSanPhamMouseClicked
        if (htsp.tempSP == -1) {
            loadSpCombobox();
        }
        htsp.tempSP = 0;
    }//GEN-LAST:event_cbSanPhamMouseClicked

    private void btnThemNsxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNsxActionPerformed
        // hiện frame thêm nhà sản xuất mới
        n.setVisible(true);
    }//GEN-LAST:event_btnThemNsxActionPerformed

    private void btnThemDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDongActionPerformed
        // hiện frame thêm dòng sản phầm
        d.setVisible(true);
    }//GEN-LAST:event_btnThemDongActionPerformed

    private void btnThemMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMauActionPerformed
        // hiện frame thêm màu mới
        m.setVisible(true);
    }//GEN-LAST:event_btnThemMauActionPerformed

    private void cbNSXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbNSXMouseClicked
        // sau khi thêm thì load lại
        if (n.tempN == 1) {
            loadNsx();
        }
        n.tempN = 0;
    }//GEN-LAST:event_cbNSXMouseClicked

    private void cbDongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbDongMouseClicked
        // sau khi thêm dong mơi thì sẽ load lại màu vào combobox
        if (d.tempD == 1) {
            loadDongSp();
        }
        d.tempD = 0;
    }//GEN-LAST:event_cbDongMouseClicked

    private void cbMauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbMauMouseClicked
        // sau khi thêm màu mới sẽ load lại màu mới vào combobox
        if (m.temp == 1) {
            loadMau();
        }
        m.temp = 0;
    }//GEN-LAST:event_cbMauMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        clear();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // delete sản phẩm
        int row = tblSanPham.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "hay chon san pham muon delete o bang ben trai truoc");
            return;
        }
        if (getIDSanPhamCT() == null) {
            return;
        }
        sanPhamChiTietService.delete(getIDSanPhamCT());
        loadSanPham();
        JOptionPane.showMessageDialog(this, "Xong");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // update sản phẩm
        int row = tblSanPham.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "hay chon san pham muon update o bang ben trai truoc");
            return;
        }
        SanPhamChiTiet spct = this.getDuLieu();
        if (spct == null) {
            return;
        }
        sanPhamChiTietService.update(spct, getIDSanPhamCT());
        loadSanPham();
        clear();
        JOptionPane.showMessageDialog(this, "Xong");
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // thêm sản phẩm mới
        SanPhamChiTiet spct = this.getDuLieu();
        if (spct == null) {
            return;
        }

        for (SanPhamChiTiet sanPhamChiTiet : sanPhamChiTietService.getAll()) {
            if (spct.getIdSp().equals(sanPhamChiTiet.getIdSp())
                    && spct.getIdMauSac().equals(sanPhamChiTiet.getIdMauSac())
                    && spct.getIdNhaSX().equals(sanPhamChiTiet.getIdNhaSX())
                    && spct.getIdDongSP().equals(sanPhamChiTiet.getIdDongSP())
                    && spct.getNamBH() == sanPhamChiTiet.getNamBH()
                    && spct.getMota().equals(sanPhamChiTiet.getMota())
                    && spct.getSoLuong() == sanPhamChiTiet.getSoLuong()
                    && spct.getGiaNhap() == sanPhamChiTiet.getGiaNhap()
                    && spct.getGiaBan() == sanPhamChiTiet.getGiaBan()) {
                JOptionPane.showMessageDialog(this, "Da co san pham");
                return;
            }
        }
        sanPhamChiTietService.insert(spct);
        clear();
        loadSanPham();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        int tl = JOptionPane.showConfirmDialog(this, "Ban se thanh toan het san pham trong gio hang ?", "Xac nhan thanh toan", JOptionPane.YES_NO_OPTION);
        int temp = 1;
        if (tl == JOptionPane.YES_OPTION) {
            String idHoaDon = "";
            for (GioHangChiTiet gioHangChiTiet : gioHangChiTietService.getAll()) {
                HoaDonChiTiet chiTiet = new HoaDonChiTiet();
                chiTiet.setIdChiTietSp(gioHangChiTiet.getIdSanPhamCt());
                chiTiet.setSoLuong(gioHangChiTiet.getSoLuong());
                chiTiet.setDonGia(gioHangChiTiet.getDonGia());
                for (HoaDon hoaDon : hoaDonService.getAll()) {
                    if (hoaDon.getTinhTrang() == 0) {
                        chiTiet.setIdHoaDon(hoaDon.getIdHD());
                        idHoaDon = hoaDon.getIdHD();
                        hoaDonChiTietService.insert(chiTiet);
                        temp = 0;
                        break;
                    }
                }
                if (temp == 1) {
                    JOptionPane.showMessageDialog(this, "can tao hoa don truoc");
                    return;
                }
            }

            for (GioHangChiTiet ghct : gioHangChiTietService.getAll()) {
                gioHangChiTietService.delete(ghct.getIdSanPhamCt());
                
            }
            gh.delete(gh.getAll().get(0).getId());
            HoaDon don = new HoaDon();
            don.setTinhTrang(1);
            hoaDonService.update(don, idHoaDon);
            loadGioHang();
            loadHoaDon();
            clear();
            JOptionPane.showMessageDialog(this, "oke");
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        int row = tblGioHang.getSelectedRow();
        txtNgayTao.setText(tblGioHang.getValueAt(row, 3).toString());
        txtMaSPGioHang.setText(tblGioHang.getValueAt(row, 1).toString());
        txtTenSPGioHang.setText(tblGioHang.getValueAt(row, 2).toString());
        txtSoLuongGioHang.setText(tblGioHang.getValueAt(row, 4).toString());
        txtDonGia.setText(tblGioHang.getValueAt(row, 5).toString());
        txtThanhTien.setText(tblGioHang.getValueAt(row, 6).toString());
    }//GEN-LAST:event_tblGioHangMouseClicked
    private void btnThongtinchitietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongtinchitietActionPerformed
        if (tblHoaDon1.getSelectedRow() != -1) {
            if (tblHoaDon1.getValueAt(tblHoaDon1.getSelectedRow(), 4).equals("chua thanh toan")) {
                JOptionPane.showMessageDialog(this, "hoa don chua co san pham");
                return;
            }
            tbHoaDon hoaDon = tbHoaDonService.getALl().get(tblHoaDon1.getSelectedRow());
            idHoaDon = hoaDon.getIdHoaDon();
            new ChiTietHoaDon(idHoaDon).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "chon hoa don muon xem");
        }
    }//GEN-LAST:event_btnThongtinchitietActionPerformed

    private void btnXoaGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaGioHangActionPerformed
        int row = tblGioHang.getSelectedRow();
        tbGioHang gioHang = tbGioHangService.getALl().get(row);
        this.gioHangChiTietService.delete(gioHang.getIdChiTietSP());
        JOptionPane.showMessageDialog(this, "update thanh cong");
        clear();
        loadGioHang();
    }//GEN-LAST:event_btnXoaGioHangActionPerformed

    private void btnUpdateGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateGioHangActionPerformed
        int row = tblGioHang.getSelectedRow();
        tbGioHang gioHang = tbGioHangService.getALl().get(row);
        GioHangChiTiet ghct = new GioHangChiTiet();
        ghct.setSoLuong(Integer.parseInt(txtSoLuongGioHang.getText()));
        this.gioHangChiTietService.update(ghct, gioHang.getIdChiTietSP());
        JOptionPane.showMessageDialog(this, "Update thanh cong");
        clear();
        loadGioHang();
    }//GEN-LAST:event_btnUpdateGioHangActionPerformed

    private void tblHoaDon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDon1MouseClicked
        int row = tblHoaDon1.getSelectedRow();
        txtMaHD.setText(tblHoaDon1.getValueAt(row, 1).toString());
        txtNgayTaoHD.setText(tblHoaDon1.getValueAt(row, 2).toString());
        txtTongTien.setText(tblHoaDon1.getValueAt(row, 3).toString());
        txtTinhTrang.setText(tblHoaDon1.getValueAt(row, 4).toString());
    }//GEN-LAST:event_tblHoaDon1MouseClicked

    private void btnReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset1ActionPerformed
        txtMaHD.setText("");
        txtNgayTaoHD.setText("");
        txtTongTien.setText("");
        txtTinhTrang.setText("");
    }//GEN-LAST:event_btnReset1ActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddGioHang;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnReset1;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemDong;
    private javax.swing.JButton btnThemMau;
    private javax.swing.JButton btnThemNsx;
    private javax.swing.JButton btnThemSp;
    private javax.swing.JButton btnThongtinchitiet;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdateGioHang;
    private javax.swing.JButton btnXoaGioHang;
    private javax.swing.JComboBox<String> cbDong;
    private javax.swing.JComboBox<String> cbMau;
    private javax.swing.JComboBox<String> cbNSX;
    private javax.swing.JComboBox<String> cbSanPham;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelGioHang;
    private javax.swing.JPanel jPanelSanPham;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon1;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaSPGioHang;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtNamBH;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtNgayTaoHD;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtSoLuongGioHang;
    private javax.swing.JTextField txtSoLuongThemGiohang;
    private javax.swing.JTextField txtTenSPGioHang;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTinhTrang;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTabbedPane views;
    // End of variables declaration//GEN-END:variables
}
