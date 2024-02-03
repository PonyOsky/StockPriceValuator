/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package component;

import Valuator.Controller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;

/**
 *
 * @author ondre
 */
public class DDMInput extends javax.swing.JPanel {

    public Controller controller;

    /**
     * Creates new form DDMInput
     */
    public DDMInput(Controller c, String route) {
        initComponents();
        controller = c;
        setLabels(route);
    }

    public void setLabels(String fileRoute) {
        Properties p = new Properties();
        FileInputStream ip;
        try {
            ip = new FileInputStream(fileRoute);
            p.load(ip);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RatioInput.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GrahamOutput.class.getName()).log(Level.SEVERE, null, ex);
        }
        jLabel57.setText(p.getProperty("jLabel57"));
        jLabel58.setText(p.getProperty("jLabel58"));
        TableColumn tb = Dividends.getTableHeader().getColumnModel().getColumn(0);
        tb.setHeaderValue(p.getProperty("year"));
        TableColumn tc = Dividends.getTableHeader().getColumnModel().getColumn(1);
        tc.setHeaderValue(p.getProperty("titleCol2"));
        Dividends.getTableHeader().repaint();
        for (int y = 0; y < 5; y++) {
            Dividends.setValueAt(controller.getActYear() - y, y, 0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DDMIn = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Dividends = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        WACCDDM = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();

        DDMIn.setBackground(new java.awt.Color(70, 73, 75));
        DDMIn.setPreferredSize(new java.awt.Dimension(850, 600));
        DDMIn.setLayout(new java.awt.BorderLayout());

        jPanel10.setBackground(new java.awt.Color(0, 153, 255));

        jLabel57.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(51, 51, 51));
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("Dividend Discount Model Inputs");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        DDMIn.add(jPanel10, java.awt.BorderLayout.PAGE_START);

        jPanel11.setLayout(new java.awt.GridLayout(1, 2));

        Dividends.setBackground(new java.awt.Color(255, 255, 255));
        Dividends.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Dividends.setForeground(new java.awt.Color(51, 51, 51));
        Dividends.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"2023", null},
                {"2022", null},
                {"2021", null},
                {"2020", null},
                {"2019", null}
            },
            new String [] {
                "Year", "Dividend"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Dividends.setRowHeight(40);
        Dividends.setRowMargin(1);
        Dividends.setShowGrid(true);
        Dividends.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Dividends);

        jPanel11.add(jScrollPane1);

        jPanel12.setLayout(new java.awt.GridLayout());

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setLayout(new java.awt.GridLayout(6, 2));

        jLabel58.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(51, 51, 51));
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("Discount Rate");
        jPanel19.add(jLabel58);

        WACCDDM.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        WACCDDM.setForeground(new java.awt.Color(204, 204, 204));
        WACCDDM.setBorder(null);
        WACCDDM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                WACCDDMKeyTyped(evt);
            }
        });
        jPanel19.add(WACCDDM);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 83, Short.MAX_VALUE)
        );

        jPanel19.add(jPanel20);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 83, Short.MAX_VALUE)
        );

        jPanel19.add(jPanel21);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 83, Short.MAX_VALUE)
        );

        jPanel19.add(jPanel22);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 83, Short.MAX_VALUE)
        );

        jPanel19.add(jPanel23);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 83, Short.MAX_VALUE)
        );

        jPanel19.add(jPanel24);

        jPanel12.add(jPanel19);

        jPanel11.add(jPanel12);

        DDMIn.add(jPanel11, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(DDMIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(DDMIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void WACCDDMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_WACCDDMKeyTyped
        controller.keyCheck(evt);
    }//GEN-LAST:event_WACCDDMKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DDMIn;
    private javax.swing.JTable Dividends;
    private javax.swing.JTextField WACCDDM;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public JTable getDividends() {
        return Dividends;
    }

    public JTextField getWACCDDM() {
        return WACCDDM;
    }

}
