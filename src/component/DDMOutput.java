/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package component;

import Valuator.Frontend;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;

/**
 *
 * @author ondre
 */
public class DDMOutput extends javax.swing.JPanel {

    public Frontend frontend;

    /**
     * Creates new form DDMOutput
     */
    public DDMOutput(Frontend f, String route) {
        initComponents();
        frontend = f;
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
        jLabel120.setText(p.getProperty("jLabel120"));
        jLabel122.setText(p.getProperty("jLabel122"));
        jLabel124.setText(p.getProperty("jLabel124"));
        jLabel125.setText(p.getProperty("jLabel125"));
        jLabel126.setText(p.getProperty("jLabel126"));
        jLabel121.setText(p.getProperty("actprice"));
        jLabel123.setText(p.getProperty("mos"));
        TableColumn tf = DividendsPrediction.getTableHeader().getColumnModel().getColumn(0);
        tf.setHeaderValue(p.getProperty("year"));
        for (int y = 1; y < 6; y++) {
            TableColumn c = DividendsPrediction.getTableHeader().getColumnModel().getColumn(y);
            c.setHeaderValue(frontend.getActYear() + (y - 5));
        }
        DividendsPrediction.getTableHeader().repaint();
        DividendsPrediction.setValueAt(p.getProperty("tableVal6"), 0, 0);
        DividendsPrediction.setValueAt(p.getProperty("tableVal7"), 1, 0);
        DividendsPrediction.setValueAt(p.getProperty("tableVal8"), 2, 0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DDMOut = new javax.swing.JPanel();
        jPanel59 = new javax.swing.JPanel();
        jLabel120 = new javax.swing.JLabel();
        jPanel60 = new javax.swing.JPanel();
        jLabel121 = new javax.swing.JLabel();
        ActPriceDDM = new javax.swing.JTextField();
        jLabel122 = new javax.swing.JLabel();
        PriceDDM = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        PillowDDM = new javax.swing.JTextField();
        jLabel124 = new javax.swing.JLabel();
        PriceDDMMoS = new javax.swing.JTextField();
        jPanel61 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        DividendsPrediction = new javax.swing.JTable();
        jPanel62 = new javax.swing.JPanel();
        jLabel125 = new javax.swing.JLabel();
        AvGRDDM = new javax.swing.JTextField();
        jLabel126 = new javax.swing.JLabel();
        WACCDDMOut = new javax.swing.JTextField();
        jPanel63 = new javax.swing.JPanel();
        jPanel64 = new javax.swing.JPanel();
        jPanel65 = new javax.swing.JPanel();
        jPanel66 = new javax.swing.JPanel();
        jPanel67 = new javax.swing.JPanel();
        jPanel68 = new javax.swing.JPanel();
        jPanel69 = new javax.swing.JPanel();
        jPanel70 = new javax.swing.JPanel();
        jPanel71 = new javax.swing.JPanel();

        DDMOut.setLayout(new java.awt.BorderLayout());

        jPanel59.setBackground(new java.awt.Color(0, 153, 255));

        jLabel120.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(51, 51, 51));
        jLabel120.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel120.setText("Calculated Dividend Discount Model");

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel120, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel120, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        DDMOut.add(jPanel59, java.awt.BorderLayout.PAGE_START);

        jPanel60.setBackground(new java.awt.Color(102, 255, 255));
        jPanel60.setLayout(new java.awt.GridLayout(2, 4));

        jLabel121.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(51, 51, 51));
        jLabel121.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel121.setText("Actual stock price:");
        jPanel60.add(jLabel121);

        ActPriceDDM.setEditable(false);
        ActPriceDDM.setBackground(new java.awt.Color(255, 255, 255));
        ActPriceDDM.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        ActPriceDDM.setForeground(new java.awt.Color(51, 51, 51));
        ActPriceDDM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ActPriceDDM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel60.add(ActPriceDDM);

        jLabel122.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(51, 51, 51));
        jLabel122.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel122.setText("DDM Price:");
        jPanel60.add(jLabel122);

        PriceDDM.setEditable(false);
        PriceDDM.setBackground(new java.awt.Color(255, 255, 255));
        PriceDDM.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        PriceDDM.setForeground(new java.awt.Color(51, 51, 51));
        PriceDDM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PriceDDM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel60.add(PriceDDM);

        jLabel123.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(51, 51, 51));
        jLabel123.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel123.setText("Margin of Safety:");
        jPanel60.add(jLabel123);

        PillowDDM.setEditable(false);
        PillowDDM.setBackground(new java.awt.Color(255, 255, 255));
        PillowDDM.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        PillowDDM.setForeground(new java.awt.Color(51, 51, 51));
        PillowDDM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PillowDDM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel60.add(PillowDDM);

        jLabel124.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(51, 51, 51));
        jLabel124.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel124.setText("DDM Price with MoS:");
        jPanel60.add(jLabel124);

        PriceDDMMoS.setEditable(false);
        PriceDDMMoS.setBackground(new java.awt.Color(255, 255, 255));
        PriceDDMMoS.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        PriceDDMMoS.setForeground(new java.awt.Color(51, 51, 51));
        PriceDDMMoS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PriceDDMMoS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel60.add(PriceDDMMoS);

        DDMOut.add(jPanel60, java.awt.BorderLayout.PAGE_END);

        jPanel61.setLayout(new java.awt.GridLayout(2, 1));

        DividendsPrediction.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        DividendsPrediction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Divident Payout", null, null, null, null, null},
                {"Yearly Dividends", null, null, null, null, null},
                {"Growth Rate in %", null, null, null, null, null}
            },
            new String [] {
                "Year", "2018", "2019", "2020", "2021", "2022"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DividendsPrediction.setRowHeight(25);
        DividendsPrediction.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(DividendsPrediction);

        jPanel61.add(jScrollPane4);

        jPanel62.setBackground(new java.awt.Color(255, 255, 255));
        jPanel62.setLayout(new java.awt.GridLayout(4, 4));

        jLabel125.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(51, 51, 51));
        jLabel125.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel125.setText("Average Growth Rate");
        jPanel62.add(jLabel125);

        AvGRDDM.setEditable(false);
        AvGRDDM.setBackground(new java.awt.Color(255, 255, 255));
        AvGRDDM.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        AvGRDDM.setForeground(new java.awt.Color(51, 51, 51));
        AvGRDDM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        AvGRDDM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel62.add(AvGRDDM);

        jLabel126.setBackground(new java.awt.Color(255, 255, 255));
        jLabel126.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(51, 51, 51));
        jLabel126.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel126.setText("WACC / Discount rate");
        jPanel62.add(jLabel126);

        WACCDDMOut.setEditable(false);
        WACCDDMOut.setBackground(new java.awt.Color(255, 255, 255));
        WACCDDMOut.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        WACCDDMOut.setForeground(new java.awt.Color(51, 51, 51));
        WACCDDMOut.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        WACCDDMOut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel62.add(WACCDDMOut);

        jPanel63.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
        );

        jPanel62.add(jPanel63);

        jPanel64.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
        );

        jPanel62.add(jPanel64);

        jPanel65.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
        );

        jPanel62.add(jPanel65);

        jPanel66.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
        );

        jPanel62.add(jPanel66);

        jPanel67.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel67Layout = new javax.swing.GroupLayout(jPanel67);
        jPanel67.setLayout(jPanel67Layout);
        jPanel67Layout.setHorizontalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );
        jPanel67Layout.setVerticalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
        );

        jPanel62.add(jPanel67);

        jPanel68.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel68Layout = new javax.swing.GroupLayout(jPanel68);
        jPanel68.setLayout(jPanel68Layout);
        jPanel68Layout.setHorizontalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );
        jPanel68Layout.setVerticalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
        );

        jPanel62.add(jPanel68);

        jPanel69.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
        );

        jPanel62.add(jPanel69);

        jPanel70.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel70Layout = new javax.swing.GroupLayout(jPanel70);
        jPanel70.setLayout(jPanel70Layout);
        jPanel70Layout.setHorizontalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );
        jPanel70Layout.setVerticalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
        );

        jPanel62.add(jPanel70);

        jPanel71.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel71Layout = new javax.swing.GroupLayout(jPanel71);
        jPanel71.setLayout(jPanel71Layout);
        jPanel71Layout.setHorizontalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );
        jPanel71Layout.setVerticalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
        );

        jPanel62.add(jPanel71);

        jPanel61.add(jPanel62);

        DDMOut.add(jPanel61, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 829, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(DDMOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1002, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(DDMOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ActPriceDDM;
    private javax.swing.JTextField AvGRDDM;
    private javax.swing.JPanel DDMOut;
    private javax.swing.JTable DividendsPrediction;
    private javax.swing.JTextField PillowDDM;
    private javax.swing.JTextField PriceDDM;
    private javax.swing.JTextField PriceDDMMoS;
    private javax.swing.JTextField WACCDDMOut;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables

    public JTextField getActPriceDDM() {
        return ActPriceDDM;
    }

    public JTextField getAvGRDDM() {
        return AvGRDDM;
    }

    public JPanel getDDMOut() {
        return DDMOut;
    }

    public JTable getDividendsPrediction() {
        return DividendsPrediction;
    }

    public JTextField getPillowDDM() {
        return PillowDDM;
    }

    public JTextField getPriceDDM() {
        return PriceDDM;
    }

    public JTextField getPriceDDMMoS() {
        return PriceDDMMoS;
    }

    public JTextField getWACCDDMOut() {
        return WACCDDMOut;
    }

}
