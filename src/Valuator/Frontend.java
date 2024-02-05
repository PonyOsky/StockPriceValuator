/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Valuator;

import component.DCFInput;
import component.DCFOutput;
import component.DDMInput;
import component.DDMOutput;
import component.GrahamInput;
import component.GrahamOutput;
import component.Help;
import component.Selector;
import component.InfoInput;
import component.Library;
import component.NAVInput;
import component.NAVOutput;
import component.RatioInput;
import component.RatioOutput;
import component.Settings;
import component.ShowOut;
import component.SummaryOutput;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import menu.Menu;
import menu.MenuEvent;

/**
 *
 * @author ondre
 *
 * Colors set up: rgb(0, 255, 246) rgb(0, 231, 255) rgb(0, 158, 255) rgb(0, 20,
 * 255)
 *
 */
public final class Frontend extends javax.swing.JFrame {

    /**
     * Creates new form Frontend
     */
    public ArrayList<String> cleaningChoices;
    public ArrayList<String> calcChoices;
    public Languages langs;
    public Controller controller;
    public SaveLoad saveLoad;
    public DCFInput dcfin;
    public DDMInput ddmin;
    public GrahamInput grahamin;
    public InfoInput info;
    public NAVInput navin;
    public RatioInput ratioin;
    public DCFOutput dcfout;
    public DDMOutput ddmout;
    public GrahamOutput grahamout;
    public NAVOutput navout;
    public RatioOutput ratioout;
    public SummaryOutput sumout;
    public Library lib;
    public Help help;
    public Selector hp;
    public ShowOut showout;
    public Settings settings;
    private JPanel[] panels;
    public Selector selector;
    private String clstr;
    private String castr;
    public Menu menu;

    /**
     *
     * @throws IOException
     */
    public Frontend() throws IOException {
        initComponents();
        setIconImage(new ImageIcon(this.getClass().getResource("/Icons/icon.png")).getImage());
        setTitle("Stock price valuator");
        langs = new Languages();
        controller = new Controller();
        saveLoad = new SaveLoad(controller);
        cleaningChoices = new ArrayList();
        calcChoices = new ArrayList();
        saveLoad.initSaves();
        initViews(langs.getRoute());
        controller.setConstants(info, ratioin, dcfin, ddmin, grahamin, navin, ratioout, dcfout, ddmout, grahamout, navout, lib, sumout);
        Properties p = new Properties();
        saveLoad.setShowout(showout, info, ratioin, dcfin, ddmin, grahamin, navin);
        FileInputStream ip;
        try {
            ip = new FileInputStream(langs.getRoute());
            p.load(ip);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RatioInput.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GrahamOutput.class.getName()).log(Level.SEVERE, null, ex);
        }
        clstr = p.getProperty("cl");
        castr = p.getProperty("ca");
        selector1.setVisible(false);
        menu2.setEvent(
                new MenuEvent() {
            @Override
            public void selected(int index, int subIndex
            ) {
                if (index == 0 && subIndex == 1) {
                    showForm(panels, info);
                }
                if (index == 0 && subIndex == 2) {
                    showForm(panels, ratioin);
                }
                if (index == 0 && subIndex == 3) {
                    showForm(panels, dcfin);
                }
                if (index == 0 && subIndex == 4) {
                    showForm(panels, ddmin);
                }
                if (index == 0 && subIndex == 5) {
                    showForm(panels, grahamin);
                }
                if (index == 0 && subIndex == 6) {
                    showForm(panels, navin);
                }
                if (index == 1 && subIndex == 1) {
                    if (cleaningChoices.contains("All")) {
                        cleaningChoices.remove(cleaningChoices.indexOf("All"));
                    } else {
                        cleaningChoices.add("All");
                    }
                }
                if (index == 1 && subIndex == 2) {
                    if (cleaningChoices.contains("Informations")) {
                        cleaningChoices.remove(cleaningChoices.indexOf("Informations"));
                    } else {
                        cleaningChoices.add("Informations");
                    }
                }
                if (index == 1 && subIndex == 3) {
                    if (cleaningChoices.contains("Ratios")) {
                        cleaningChoices.remove(cleaningChoices.indexOf("Ratios"));
                    } else {
                        cleaningChoices.add("Ratios");
                    }
                }
                if (index == 1 && subIndex == 4) {
                    if (cleaningChoices.contains("DCF")) {
                        cleaningChoices.remove(cleaningChoices.indexOf("DCF"));
                    } else {
                        cleaningChoices.add("DCF");
                    }
                }
                if (index == 1 && subIndex == 5) {
                    if (cleaningChoices.contains("DDM")) {
                        cleaningChoices.remove(cleaningChoices.indexOf("DDM"));
                    } else {
                        cleaningChoices.add("DDM");
                    }
                }
                if (index == 1 && subIndex == 6) {
                    if (cleaningChoices.contains("Graham")) {
                        cleaningChoices.remove(cleaningChoices.indexOf("Graham"));
                    } else {
                        cleaningChoices.add("Graham");
                    }
                }
                if (index == 1 && subIndex == 7) {
                    if (cleaningChoices.contains("NAV")) {
                        cleaningChoices.remove(cleaningChoices.indexOf("NAV"));
                    } else {
                        cleaningChoices.add("NAV");
                    }
                }
                if (index == 1 && subIndex == 8) {
                    controller.clean(cleaningChoices);
                    cleaningChoices.clear();
                }
                if (index == 2 && subIndex == 1) {
                    showForm(panels, sumout);
                }
                if (index == 2 && subIndex == 2) {
                    showForm(panels, ratioout);
                }
                if (index == 2 && subIndex == 3) {
                    showForm(panels, dcfout);
                }
                if (index == 2 && subIndex == 4) {
                    showForm(panels, ddmout);
                }
                if (index == 2 && subIndex == 5) {
                    showForm(panels, grahamout);
                }
                if (index == 2 && subIndex == 6) {
                    showForm(panels, navout);
                }
                if (index == 3 && subIndex == 1) {
                    if (calcChoices.contains("Ratios")) {
                        calcChoices.remove(calcChoices.indexOf("Ratios"));
                    } else {
                        calcChoices.add("Ratios");
                    }
                }
                if (index == 3 && subIndex == 2) {
                    if (calcChoices.contains("DCF")) {
                        calcChoices.remove(calcChoices.indexOf("DCF"));
                    } else {
                        calcChoices.add("DCF");
                    }
                }
                if (index == 3 && subIndex == 3) {
                    if (calcChoices.contains("DDM")) {
                        calcChoices.remove(calcChoices.indexOf("DDM"));
                    } else {
                        calcChoices.add("DDM");
                    }
                }
                if (index == 3 && subIndex == 4) {
                    if (calcChoices.contains("Graham")) {
                        calcChoices.remove(calcChoices.indexOf("Graham"));
                    } else {
                        calcChoices.add("Graham");
                    }
                }
                if (index == 3 && subIndex == 5) {
                    if (calcChoices.contains("NAV")) {
                        calcChoices.remove(calcChoices.indexOf("NAV"));
                    } else {
                        calcChoices.add("NAV");
                    }
                }
                if (index == 3 && subIndex == 6) {
                    controller.calculation(calcChoices);
                    calcChoices.clear();
                }
                if (index == 4) {
                    showForm(panels, showout);
                }
                if (index == 5) {
                    showForm(panels, lib);
                }
                if (index == 6) {
                    showForm(panels, settings);
                }
                if (index == 7) {
                    showForm(panels, help);
                }
                setSelector(cleaningChoices, calcChoices);
            }
        }
        );
    }

    /**
     *
     * @param target
     * @param panel
     */
    private void showForm(JPanel[] target, JPanel panel) {
        for (JPanel jp : target) {
            if (jp == panel) {
                jp.setVisible(true);
            } else {
                jp.setVisible(false);
            }
        }
        body.add(panel);
        body.repaint();
        body.revalidate();
    }

    /**
     *
     * @param route
     */
    private void initViews(String route) {
        info = new InfoInput(controller, route);
        ratioin = new RatioInput(controller, route);
        dcfin = new DCFInput(this, controller, route);
        ddmin = new DDMInput(this, controller, route);
        grahamin = new GrahamInput(controller, route);
        navin = new NAVInput(controller, route);
        ratioout = new RatioOutput(route);
        dcfout = new DCFOutput(this, route);
        ddmout = new DDMOutput(this, route);
        grahamout = new GrahamOutput(route);
        navout = new NAVOutput(route);
        help = new Help(route);
        lib = new Library(saveLoad, route, controller);
        settings = new Settings(langs, this, route);
        showout = new ShowOut(route);
        sumout = new SummaryOutput(route);
        panels = new JPanel[]{info, ratioin, dcfin, ddmin, grahamin, navin, ratioout, dcfout, ddmout, grahamout, navout, lib, sumout, help, settings, showout};
    }

    /**
     *
     * @param route
     */
    public void translate(String route) {
        body.removeAll();
        panels = new JPanel[]{};
        initViews(route);
        showForm(panels, settings);
        menu2.setNewLang();
        menu2.repaint();
        menu2.revalidate();
        scrollPaneWin111.repaint();
        scrollPaneWin111.revalidate();
    }

    /**
     *
     * @param cl
     * @param calc
     */
    public void setSelector(ArrayList cl, ArrayList calc) {
        if (cl.size() >= 1 || calc.size() >= 1) {
            selector1.setVisible(true);
            if (cl.size() >= 1) {
                selector1.getjLabel1().setText(clstr + " " + cl.toString());
            } else {
                selector1.getjLabel1().setText(castr + " " + calc.toString());
            }
            if (calc.size() >= 1) {
                selector1.getjLabel1().setText(castr + " " + calc.toString());
            } else {
                selector1.getjLabel1().setText(clstr + " " + cl.toString());
            }
        } else {
            selector1.setVisible(false);
            selector1.getjLabel1().setText("");
        }
        setComponentZOrder(selector1, 2);
        setComponentZOrder(body, 1);
        for (JPanel j : panels) {
            setComponentZOrder(j, 1);
        }
        body.add(selector1);
        body.repaint();
        body.revalidate();
    }

    /**
     *
     * @return
     */
    public Integer getActYear() {
        Date currentDate = new Date();
        return (int) currentDate.getYear() + 1900;
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
        selector1 = new component.Selector();

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(selector1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(heading2, javax.swing.GroupLayout.DEFAULT_SIZE, 1084, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(heading2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneWin111, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selector1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Frontend.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Frontend().setVisible(true);

            } catch (IOException ex) {
                Logger.getLogger(Frontend.class
                        .getName()).log(Level.SEVERE, null, ex);
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
    private component.Selector selector1;
    // End of variables declaration//GEN-END:variables
}
