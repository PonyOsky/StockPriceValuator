/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author ondre
 */
public class NAVOutput extends javax.swing.JPanel {

    /**
     * Creates new form NAVOutput
     */
    public NAVOutput(String route) {
        initComponents();
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
        jLabel159.setText(p.getProperty("jLabel159"));
        jLabel119.setText(p.getProperty("jLabel119"));
        jLabel129.setText(p.getProperty("jLabel129"));
        jLabel1.setText(p.getProperty("jLabel1"));
        jLabel4.setText(p.getProperty("jLabel4"));
        jLabel5.setText(p.getProperty("jLabel5"));
        jLabel118.setText(p.getProperty("actprice"));
        jLabel128.setText(p.getProperty("mos"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NAVOut = new javax.swing.JPanel();
        jPanel78 = new javax.swing.JPanel();
        jLabel159 = new javax.swing.JLabel();
        jPanel83 = new javax.swing.JPanel();
        jLabel118 = new javax.swing.JLabel();
        ActPriceNAV = new javax.swing.JTextField();
        jLabel119 = new javax.swing.JLabel();
        PriceNAV = new javax.swing.JTextField();
        jLabel128 = new javax.swing.JLabel();
        PillowNAV = new javax.swing.JTextField();
        jLabel129 = new javax.swing.JLabel();
        PriceNAVMoS = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TotalAssetsNAV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TotalLiabilitiesNAV = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        SharesNAV = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();

        NAVOut.setLayout(new java.awt.BorderLayout());

        jPanel78.setBackground(new java.awt.Color(0, 153, 255));

        jLabel159.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel159.setForeground(new java.awt.Color(51, 51, 51));
        jLabel159.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel159.setText("Calculated Net Assets Value");

        javax.swing.GroupLayout jPanel78Layout = new javax.swing.GroupLayout(jPanel78);
        jPanel78.setLayout(jPanel78Layout);
        jPanel78Layout.setHorizontalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel159, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
        );
        jPanel78Layout.setVerticalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel159, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        NAVOut.add(jPanel78, java.awt.BorderLayout.PAGE_START);

        jPanel83.setBackground(new java.awt.Color(102, 255, 255));
        jPanel83.setLayout(new java.awt.GridLayout(2, 4));

        jLabel118.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(51, 51, 51));
        jLabel118.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel118.setText("Actual stock price:");
        jPanel83.add(jLabel118);

        ActPriceNAV.setEditable(false);
        ActPriceNAV.setBackground(new java.awt.Color(255, 255, 255));
        ActPriceNAV.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        ActPriceNAV.setForeground(new java.awt.Color(51, 51, 51));
        ActPriceNAV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ActPriceNAV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel83.add(ActPriceNAV);

        jLabel119.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(51, 51, 51));
        jLabel119.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel119.setText("NAV Price:");
        jPanel83.add(jLabel119);

        PriceNAV.setEditable(false);
        PriceNAV.setBackground(new java.awt.Color(255, 255, 255));
        PriceNAV.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        PriceNAV.setForeground(new java.awt.Color(51, 51, 51));
        PriceNAV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PriceNAV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel83.add(PriceNAV);

        jLabel128.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(51, 51, 51));
        jLabel128.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel128.setText("Margin of Safety:");
        jPanel83.add(jLabel128);

        PillowNAV.setEditable(false);
        PillowNAV.setBackground(new java.awt.Color(255, 255, 255));
        PillowNAV.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        PillowNAV.setForeground(new java.awt.Color(51, 51, 51));
        PillowNAV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PillowNAV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel83.add(PillowNAV);

        jLabel129.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(51, 51, 51));
        jLabel129.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel129.setText("NAV Price with MoS:");
        jPanel83.add(jLabel129);

        PriceNAVMoS.setEditable(false);
        PriceNAVMoS.setBackground(new java.awt.Color(255, 255, 255));
        PriceNAVMoS.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        PriceNAVMoS.setForeground(new java.awt.Color(51, 51, 51));
        PriceNAVMoS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PriceNAVMoS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel83.add(PriceNAVMoS);

        NAVOut.add(jPanel83, java.awt.BorderLayout.PAGE_END);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(4, 2));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Number of Total Assets");
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1);

        TotalAssetsNAV.setEditable(false);
        TotalAssetsNAV.setBackground(new java.awt.Color(255, 255, 255));
        TotalAssetsNAV.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        TotalAssetsNAV.setForeground(new java.awt.Color(51, 51, 51));
        TotalAssetsNAV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TotalAssetsNAV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(TotalAssetsNAV);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Number of Total Liabilities");
        jLabel4.setToolTipText("");
        jPanel1.add(jLabel4);

        TotalLiabilitiesNAV.setEditable(false);
        TotalLiabilitiesNAV.setBackground(new java.awt.Color(255, 255, 255));
        TotalLiabilitiesNAV.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        TotalLiabilitiesNAV.setForeground(new java.awt.Color(51, 51, 51));
        TotalLiabilitiesNAV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TotalLiabilitiesNAV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(TotalLiabilitiesNAV);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Shares outstanding");
        jLabel5.setToolTipText("");
        jPanel1.add(jLabel5);

        SharesNAV.setEditable(false);
        SharesNAV.setBackground(new java.awt.Color(255, 255, 255));
        SharesNAV.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        SharesNAV.setForeground(new java.awt.Color(51, 51, 51));
        SharesNAV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SharesNAV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(SharesNAV);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 103, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);

        NAVOut.add(jPanel1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 829, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(NAVOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(NAVOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ActPriceNAV;
    private javax.swing.JPanel NAVOut;
    private javax.swing.JTextField PillowNAV;
    private javax.swing.JTextField PriceNAV;
    private javax.swing.JTextField PriceNAVMoS;
    private javax.swing.JTextField SharesNAV;
    private javax.swing.JTextField TotalAssetsNAV;
    private javax.swing.JTextField TotalLiabilitiesNAV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel83;
    // End of variables declaration//GEN-END:variables

    public JTextField getActPriceNAV() {
        return ActPriceNAV;
    }

    public JTextField getPillowNAV() {
        return PillowNAV;
    }

    public JTextField getPriceNAV() {
        return PriceNAV;
    }

    public JTextField getPriceNAVMoS() {
        return PriceNAVMoS;
    }

    public JTextField getSharesNAV() {
        return SharesNAV;
    }

    public JTextField getTotalAssetsNAV() {
        return TotalAssetsNAV;
    }

    public JTextField getTotalLiabilitiesNAV() {
        return TotalLiabilitiesNAV;
    }

}
