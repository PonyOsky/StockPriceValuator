/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Valuator;

import component.HomePage;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;
import menu.MenuEvent;

/**
 *
 * @author ondre
 *
 * Colors set up: rgb(0, 255, 246) rgb(0, 231, 255) rgb(0, 158, 255) rgb(0, 20,
 * 255)
 *
 */
public final class ReworkedFrontend extends javax.swing.JFrame {

    /**
     * Creates new form ReworkedFrontend
     */
    private final Color lightColor;
    private final Color lightDarkColor;
    private final Color darkLightColor;
    private final Color darkColor;
    private ArrayList<JPanel> activeChoices;
    public ArrayList<String> cleaningChoices;
    public ArrayList<String> calcChoices;
    public ArrayList<String> langChoices;
    public Languages langs;
    public Controller controller;
    public SaveLoad saveLoad;

    /**
     *
     * @throws IOException
     */
    public ReworkedFrontend() throws IOException {
        initComponents();
        setIconImage(new ImageIcon(this.getClass().getResource("/Icons/icon.png")).getImage());
        setTitle("Stock price valuator");
        langs = new Languages();
        controller = new Controller(this);
        saveLoad = new SaveLoad(controller);
        activeChoices = new ArrayList();
        cleaningChoices = new ArrayList();
        calcChoices = new ArrayList();
        langChoices = new ArrayList();
        lightColor = new Color(0, 255, 246);
        lightDarkColor = new Color(0, 231, 255);
        darkLightColor = new Color(0, 158, 255);
        darkColor = new Color(0, 20, 255);
        setLabels(langs.getRoute());
        //setLangChoices();
        saveLoad.initSaves();
        
        menu2.setEvent(new MenuEvent() {
            @Override
            public void selected(int index, int subIndex) {
                if(index == 0 && subIndex == 3){
                    showForm(new HomePage());
                }
            }
        });
    }
    
    private void showForm(Component com) {
        body.removeAll();
        body.add(com);
        body.repaint();
        body.revalidate();
    }
/*
    private void setLangChoices() {
        for (String item : langs.getChoices()) {
            LangChoice.addItem(item);
        }
        LangChoice.setSelectedItem(langs.getDefLangType());
    }
*/

    public void setLabels(String route) throws IOException {
        if (route != null) {
            Properties lang = new Properties();
            Properties conf = new Properties();
            FileInputStream i = new FileInputStream("./src/Valuator/config.properties");
            conf.load(i);
            FileInputStream ip = new FileInputStream(route);
            lang.load(ip);
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

        jScrollPane10 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        polygonCorner1 = new scroll.PolygonCorner();
        body = new javax.swing.JPanel();
        scrollPaneWin111 = new scroll.ScrollPaneWin11();
        menu2 = new menu.Menu();
        heading2 = new component.Heading();

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane10.setViewportView(jTable4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(null);
        setMinimumSize(new java.awt.Dimension(900, 600));

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setMaximumSize(new java.awt.Dimension(620, 600));
        body.setPreferredSize(new java.awt.Dimension(850, 600));
        body.setLayout(new javax.swing.OverlayLayout(body));

        scrollPaneWin111.setBorder(null);
        scrollPaneWin111.setViewportView(menu2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
            .addComponent(heading2, javax.swing.GroupLayout.DEFAULT_SIZE, 1084, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(heading2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneWin111, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * @param target
     * @param change
     */

    /**
     *
     * @param target
     */
    public void clickUnclick(JPanel target) {
        if (target != null) {
            if (!activeChoices.contains(target)) {
                target.setBackground(darkLightColor);
                activeChoices.add(target);
            } else {
                target.setBackground(lightDarkColor);
                activeChoices.remove(target);
            }
        }
    }

    /**
     *
     * @param choice
     */
    public void chooseCleaning(JPanel choice) {
        if (choice != null) {
            if (cleaningChoices.contains(choice.getName())) {
                cleaningChoices.remove(choice.getName());
                choice.setBackground(lightDarkColor);
            } else {
                cleaningChoices.add(choice.getName());
                choice.setBackground(darkLightColor);
            }
        }
    }

    /**
     *
     * @param choice
     */
    public void chooseCalculation(JPanel choice) {
        if (choice != null) {
            if (calcChoices.contains(choice.getName())) {
                calcChoices.remove(choice.getName());
                choice.setBackground(lightDarkColor);
            } else {
                calcChoices.add(choice.getName());
                choice.setBackground(darkLightColor);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //řeší problém se škálováním ikon
        System.setProperty("sun.java2d.uiScale", "1");
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReworkedFrontend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new ReworkedFrontend().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(ReworkedFrontend.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private component.Heading heading2;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JTable jTable4;
    private menu.Menu menu2;
    private scroll.PolygonCorner polygonCorner1;
    private scroll.ScrollPaneWin11 scrollPaneWin111;
    // End of variables declaration//GEN-END:variables
}
