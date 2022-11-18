package Views;

import Service.service.TbChiTietHoaDonService;
import ViewsModels.TbChiTietHoaDon;
import entity.HoaDonChiTiet;
import javax.swing.table.DefaultTableModel;

public class ChiTietHoaDon extends javax.swing.JFrame {

    private TbChiTietHoaDonService tbHoaDonChiTietService = new TbChiTietHoaDonService();

    public ChiTietHoaDon(String id) {
        initComponents();
        load(id);
    }

    void load(String id) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tblChiTietHoaDOn.getModel();
        defaultTableModel.setRowCount(0);
        for (TbChiTietHoaDon hoaDonChiTiet : tbHoaDonChiTietService.getByALl()) {
            if (hoaDonChiTiet.getId().equals(id)) {
                defaultTableModel.addRow(new Object[]{hoaDonChiTiet.getTenSp(), hoaDonChiTiet.getSoLuong(), hoaDonChiTiet.getDonGia(), hoaDonChiTiet.getMauSac(), hoaDonChiTiet.getDongSP(), hoaDonChiTiet.getNhaSx()});
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChiTietHoaDOn = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();

        tblChiTietHoaDOn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Tên SP", "Số lượng", "Đơn giá", "Màu Sắc", "Dòng sp", "Nhà Sản xuất"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblChiTietHoaDOn);
        if (tblChiTietHoaDOn.getColumnModel().getColumnCount() > 0) {
            tblChiTietHoaDOn.getColumnModel().getColumn(0).setResizable(false);
            tblChiTietHoaDOn.getColumnModel().getColumn(1).setResizable(false);
            tblChiTietHoaDOn.getColumnModel().getColumn(2).setResizable(false);
            tblChiTietHoaDOn.getColumnModel().getColumn(3).setResizable(false);
            tblChiTietHoaDOn.getColumnModel().getColumn(4).setResizable(false);
            tblChiTietHoaDOn.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(368, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblChiTietHoaDOn;
    // End of variables declaration//GEN-END:variables
}
