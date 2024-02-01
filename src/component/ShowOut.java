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
public class ShowOut extends javax.swing.JPanel {

    /**
     * Creates new form ShowOut
     */
    public ShowOut() {
        initComponents();
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
        jLabel182.setText(p.getProperty("DCF"));
        jLabel183.setText(p.getProperty("DDM"));
        jLabel184.setText(p.getProperty("Graham"));
        jLabel185.setText(p.getProperty("jLabel88"));
        jLabel186.setText(p.getProperty("NAV"));
        jLabel187.setText(p.getProperty("price"));
        jLabel188.setText(p.getProperty("price"));
        jLabel189.setText(p.getProperty("price"));
        jLabel190.setText(p.getProperty("price"));
        jLabel193.setText(p.getProperty("price"));
        jLabel218.setText(p.getProperty("pricemos"));
        jLabel219.setText(p.getProperty("pricemos"));
        jLabel220.setText(p.getProperty("pricemos"));
        jLabel221.setText(p.getProperty("pricemos"));
        jLabel222.setText(p.getProperty("pricemos"));
        jLabel178.setText(p.getProperty("jLabel178"));
        jLabel179.setText(p.getProperty("jLabel179"));
        jLabel181.setText(p.getProperty("mos"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ShowOut = new javax.swing.JPanel();
        jPanel82 = new javax.swing.JPanel();
        jLabel163 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel84 = new javax.swing.JPanel();
        jLabel178 = new javax.swing.JLabel();
        IdealPrice1 = new javax.swing.JTextField();
        jLabel179 = new javax.swing.JLabel();
        IdealPriceMoS1 = new javax.swing.JTextField();
        jLabel181 = new javax.swing.JLabel();
        PillowAns1 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jPanel85 = new javax.swing.JPanel();
        jLabel182 = new javax.swing.JLabel();
        jLabel183 = new javax.swing.JLabel();
        jLabel184 = new javax.swing.JLabel();
        jLabel185 = new javax.swing.JLabel();
        jLabel186 = new javax.swing.JLabel();
        jPanel86 = new javax.swing.JPanel();
        jLabel187 = new javax.swing.JLabel();
        DCFAns1 = new javax.swing.JTextField();
        jPanel88 = new javax.swing.JPanel();
        jLabel188 = new javax.swing.JLabel();
        DDMAns1 = new javax.swing.JTextField();
        jPanel89 = new javax.swing.JPanel();
        jLabel189 = new javax.swing.JLabel();
        GrahamAns1 = new javax.swing.JTextField();
        jPanel90 = new javax.swing.JPanel();
        jLabel190 = new javax.swing.JLabel();
        GrahamRevAns1 = new javax.swing.JTextField();
        jPanel91 = new javax.swing.JPanel();
        jLabel193 = new javax.swing.JLabel();
        NAVAns1 = new javax.swing.JTextField();
        jPanel100 = new javax.swing.JPanel();
        jLabel218 = new javax.swing.JLabel();
        DCFMoSAns1 = new javax.swing.JTextField();
        jPanel101 = new javax.swing.JPanel();
        jLabel219 = new javax.swing.JLabel();
        DDMMoSAns1 = new javax.swing.JTextField();
        jPanel102 = new javax.swing.JPanel();
        jLabel220 = new javax.swing.JLabel();
        GrahamMoSAns1 = new javax.swing.JTextField();
        jPanel103 = new javax.swing.JPanel();
        jLabel221 = new javax.swing.JLabel();
        GrahamRevMoSAns1 = new javax.swing.JTextField();
        jPanel104 = new javax.swing.JPanel();
        jLabel222 = new javax.swing.JLabel();
        NAVMoSAns1 = new javax.swing.JTextField();
        jPanel105 = new javax.swing.JPanel();
        jPanel106 = new javax.swing.JPanel();
        jPanel115 = new javax.swing.JPanel();
        jPanel116 = new javax.swing.JPanel();
        jPanel117 = new javax.swing.JPanel();

        ShowOut.setLayout(new java.awt.BorderLayout());

        jPanel82.setBackground(new java.awt.Color(0, 153, 255));
        jPanel82.setLayout(new java.awt.GridLayout(1, 2));

        jLabel163.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel163.setForeground(new java.awt.Color(51, 51, 51));
        jLabel163.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel163.setText("Saving works! Yay!");
        jPanel82.add(jLabel163);

        jLabel34.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(51, 51, 51));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("jLabel34");
        jLabel34.setPreferredSize(new java.awt.Dimension(88, 30));
        jPanel82.add(jLabel34);

        ShowOut.add(jPanel82, java.awt.BorderLayout.PAGE_START);

        jPanel84.setBackground(new java.awt.Color(102, 255, 255));
        jPanel84.setLayout(new java.awt.GridLayout(2, 4));

        jLabel178.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel178.setForeground(new java.awt.Color(51, 51, 51));
        jLabel178.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel178.setText("Average price:");
        jPanel84.add(jLabel178);

        IdealPrice1.setEditable(false);
        IdealPrice1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        IdealPrice1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel84.add(IdealPrice1);

        jLabel179.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel179.setForeground(new java.awt.Color(51, 51, 51));
        jLabel179.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel179.setText("Averige price with margin:");
        jPanel84.add(jLabel179);

        IdealPriceMoS1.setEditable(false);
        IdealPriceMoS1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        IdealPriceMoS1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel84.add(IdealPriceMoS1);

        jLabel181.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel181.setForeground(new java.awt.Color(51, 51, 51));
        jLabel181.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel181.setText("Margin of Safety:");
        jPanel84.add(jLabel181);

        PillowAns1.setEditable(false);
        PillowAns1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        PillowAns1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel84.add(PillowAns1);

        jPanel8.setBackground(new java.awt.Color(102, 255, 255));
        jPanel8.setMinimumSize(new java.awt.Dimension(100, 32));
        jPanel8.setPreferredSize(new java.awt.Dimension(252, 32));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 252, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jPanel84.add(jPanel8);

        ShowOut.add(jPanel84, java.awt.BorderLayout.PAGE_END);

        jPanel85.setBackground(new java.awt.Color(255, 255, 255));
        jPanel85.setLayout(new java.awt.GridLayout(4, 5));

        jLabel182.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel182.setForeground(new java.awt.Color(0, 102, 255));
        jLabel182.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel182.setText("DCF");
        jPanel85.add(jLabel182);

        jLabel183.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel183.setForeground(new java.awt.Color(0, 102, 255));
        jLabel183.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel183.setText("DDM");
        jPanel85.add(jLabel183);

        jLabel184.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel184.setForeground(new java.awt.Color(0, 102, 255));
        jLabel184.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel184.setText("Grahams Formulas");
        jPanel85.add(jLabel184);

        jLabel185.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel185.setForeground(new java.awt.Color(0, 102, 255));
        jLabel185.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel185.setText("Grahams Revs Formula");
        jPanel85.add(jLabel185);

        jLabel186.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel186.setForeground(new java.awt.Color(0, 102, 255));
        jLabel186.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel186.setText("NAV");
        jPanel85.add(jLabel186);

        jPanel86.setBackground(new java.awt.Color(255, 255, 255));
        jPanel86.setLayout(new java.awt.GridLayout());

        jLabel187.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel187.setForeground(new java.awt.Color(51, 51, 51));
        jLabel187.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel187.setText("Price:");
        jPanel86.add(jLabel187);

        DCFAns1.setEditable(false);
        DCFAns1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        DCFAns1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel86.add(DCFAns1);

        jPanel85.add(jPanel86);

        jPanel88.setBackground(new java.awt.Color(255, 255, 255));
        jPanel88.setLayout(new java.awt.GridLayout(1, 2));

        jLabel188.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel188.setForeground(new java.awt.Color(51, 51, 51));
        jLabel188.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel188.setText("Price:");
        jPanel88.add(jLabel188);

        DDMAns1.setEditable(false);
        DDMAns1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        DDMAns1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel88.add(DDMAns1);

        jPanel85.add(jPanel88);

        jPanel89.setBackground(new java.awt.Color(255, 255, 255));
        jPanel89.setLayout(new java.awt.GridLayout());

        jLabel189.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel189.setForeground(new java.awt.Color(51, 51, 51));
        jLabel189.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel189.setText("Price:");
        jPanel89.add(jLabel189);

        GrahamAns1.setEditable(false);
        GrahamAns1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        GrahamAns1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel89.add(GrahamAns1);

        jPanel85.add(jPanel89);

        jPanel90.setBackground(new java.awt.Color(255, 255, 255));
        jPanel90.setLayout(new java.awt.GridLayout());

        jLabel190.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel190.setForeground(new java.awt.Color(51, 51, 51));
        jLabel190.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel190.setText("Price:");
        jPanel90.add(jLabel190);

        GrahamRevAns1.setEditable(false);
        GrahamRevAns1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        GrahamRevAns1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel90.add(GrahamRevAns1);

        jPanel85.add(jPanel90);

        jPanel91.setBackground(new java.awt.Color(255, 255, 255));
        jPanel91.setLayout(new java.awt.GridLayout());

        jLabel193.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel193.setForeground(new java.awt.Color(51, 51, 51));
        jLabel193.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel193.setText("Price:");
        jPanel91.add(jLabel193);

        NAVAns1.setEditable(false);
        NAVAns1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        NAVAns1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel91.add(NAVAns1);

        jPanel85.add(jPanel91);

        jPanel100.setBackground(new java.awt.Color(255, 255, 255));
        jPanel100.setLayout(new java.awt.GridLayout());

        jLabel218.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel218.setForeground(new java.awt.Color(51, 51, 51));
        jLabel218.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel218.setText("Price with MoS:");
        jPanel100.add(jLabel218);

        DCFMoSAns1.setEditable(false);
        DCFMoSAns1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        DCFMoSAns1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel100.add(DCFMoSAns1);

        jPanel85.add(jPanel100);

        jPanel101.setBackground(new java.awt.Color(255, 255, 255));
        jPanel101.setLayout(new java.awt.GridLayout());

        jLabel219.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel219.setForeground(new java.awt.Color(51, 51, 51));
        jLabel219.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel219.setText("Price with MoS:");
        jPanel101.add(jLabel219);

        DDMMoSAns1.setEditable(false);
        DDMMoSAns1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        DDMMoSAns1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel101.add(DDMMoSAns1);

        jPanel85.add(jPanel101);

        jPanel102.setBackground(new java.awt.Color(255, 255, 255));
        jPanel102.setLayout(new java.awt.GridLayout());

        jLabel220.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel220.setForeground(new java.awt.Color(51, 51, 51));
        jLabel220.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel220.setText("Price with MoS:");
        jPanel102.add(jLabel220);

        GrahamMoSAns1.setEditable(false);
        GrahamMoSAns1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        GrahamMoSAns1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel102.add(GrahamMoSAns1);

        jPanel85.add(jPanel102);

        jPanel103.setBackground(new java.awt.Color(255, 255, 255));
        jPanel103.setLayout(new java.awt.GridLayout());

        jLabel221.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel221.setForeground(new java.awt.Color(51, 51, 51));
        jLabel221.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel221.setText("Price with MoS:");
        jPanel103.add(jLabel221);

        GrahamRevMoSAns1.setEditable(false);
        GrahamRevMoSAns1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        GrahamRevMoSAns1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel103.add(GrahamRevMoSAns1);

        jPanel85.add(jPanel103);

        jPanel104.setBackground(new java.awt.Color(255, 255, 255));
        jPanel104.setLayout(new java.awt.GridLayout());

        jLabel222.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel222.setForeground(new java.awt.Color(51, 51, 51));
        jLabel222.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel222.setText("Price with MoS:");
        jPanel104.add(jLabel222);

        NAVMoSAns1.setEditable(false);
        NAVMoSAns1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        NAVMoSAns1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel104.add(NAVMoSAns1);

        jPanel85.add(jPanel104);

        jPanel105.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel105Layout = new javax.swing.GroupLayout(jPanel105);
        jPanel105.setLayout(jPanel105Layout);
        jPanel105Layout.setHorizontalGroup(
            jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 202, Short.MAX_VALUE)
        );
        jPanel105Layout.setVerticalGroup(
            jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
        );

        jPanel85.add(jPanel105);

        jPanel106.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel106Layout = new javax.swing.GroupLayout(jPanel106);
        jPanel106.setLayout(jPanel106Layout);
        jPanel106Layout.setHorizontalGroup(
            jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 202, Short.MAX_VALUE)
        );
        jPanel106Layout.setVerticalGroup(
            jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
        );

        jPanel85.add(jPanel106);

        jPanel115.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel115Layout = new javax.swing.GroupLayout(jPanel115);
        jPanel115.setLayout(jPanel115Layout);
        jPanel115Layout.setHorizontalGroup(
            jPanel115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 202, Short.MAX_VALUE)
        );
        jPanel115Layout.setVerticalGroup(
            jPanel115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
        );

        jPanel85.add(jPanel115);

        jPanel116.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel116Layout = new javax.swing.GroupLayout(jPanel116);
        jPanel116.setLayout(jPanel116Layout);
        jPanel116Layout.setHorizontalGroup(
            jPanel116Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 202, Short.MAX_VALUE)
        );
        jPanel116Layout.setVerticalGroup(
            jPanel116Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
        );

        jPanel85.add(jPanel116);

        jPanel117.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel117Layout = new javax.swing.GroupLayout(jPanel117);
        jPanel117.setLayout(jPanel117Layout);
        jPanel117Layout.setHorizontalGroup(
            jPanel117Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 202, Short.MAX_VALUE)
        );
        jPanel117Layout.setVerticalGroup(
            jPanel117Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
        );

        jPanel85.add(jPanel117);

        ShowOut.add(jPanel85, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1010, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(ShowOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(ShowOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DCFAns1;
    private javax.swing.JTextField DCFMoSAns1;
    private javax.swing.JTextField DDMAns1;
    private javax.swing.JTextField DDMMoSAns1;
    private javax.swing.JTextField GrahamAns1;
    private javax.swing.JTextField GrahamMoSAns1;
    private javax.swing.JTextField GrahamRevAns1;
    private javax.swing.JTextField GrahamRevMoSAns1;
    private javax.swing.JTextField IdealPrice1;
    private javax.swing.JTextField IdealPriceMoS1;
    private javax.swing.JTextField NAVAns1;
    private javax.swing.JTextField NAVMoSAns1;
    private javax.swing.JTextField PillowAns1;
    private javax.swing.JPanel ShowOut;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel218;
    private javax.swing.JLabel jLabel219;
    private javax.swing.JLabel jLabel220;
    private javax.swing.JLabel jLabel221;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JPanel jPanel100;
    private javax.swing.JPanel jPanel101;
    private javax.swing.JPanel jPanel102;
    private javax.swing.JPanel jPanel103;
    private javax.swing.JPanel jPanel104;
    private javax.swing.JPanel jPanel105;
    private javax.swing.JPanel jPanel106;
    private javax.swing.JPanel jPanel115;
    private javax.swing.JPanel jPanel116;
    private javax.swing.JPanel jPanel117;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel82;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel85;
    private javax.swing.JPanel jPanel86;
    private javax.swing.JPanel jPanel88;
    private javax.swing.JPanel jPanel89;
    private javax.swing.JPanel jPanel90;
    private javax.swing.JPanel jPanel91;
    // End of variables declaration//GEN-END:variables

    public JTextField getDCFAns1() {
        return DCFAns1;
    }

    public JTextField getDCFMoSAns1() {
        return DCFMoSAns1;
    }

    public JTextField getDDMAns1() {
        return DDMAns1;
    }

    public JTextField getDDMMoSAns1() {
        return DDMMoSAns1;
    }

    public JTextField getGrahamAns1() {
        return GrahamAns1;
    }

    public JTextField getGrahamMoSAns1() {
        return GrahamMoSAns1;
    }

    public JTextField getGrahamRevAns1() {
        return GrahamRevAns1;
    }

    public JTextField getGrahamRevMoSAns1() {
        return GrahamRevMoSAns1;
    }

    public JTextField getIdealPrice1() {
        return IdealPrice1;
    }

    public JTextField getIdealPriceMoS1() {
        return IdealPriceMoS1;
    }

    public JTextField getNAVAns1() {
        return NAVAns1;
    }

    public JTextField getNAVMoSAns1() {
        return NAVMoSAns1;
    }

    public JTextField getPillowAns1() {
        return PillowAns1;
    }

}
