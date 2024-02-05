/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author ondre
 */
public class Menu extends JComponent {

    /**
     *
     * @return
     */
    public MenuEvent getEvent() {
        return event;
    }

    /**
     *
     * @param event
     */
    public void setEvent(MenuEvent event) {
        this.event = event;
    }

    private MenuEvent event;
    private MigLayout layout;
    private String[][] menuItems;

    public Menu() {
        initValues();
        init();
    }

    private void init() {
        layout = new MigLayout("wrap 1, fillx, gapy 0, inset 2", "fill");
        setLayout(layout);
        setOpaque(true);
        //  Init MenuItem
        for (int i = 0; i < menuItems.length; i++) {
            addMenu(menuItems[i][0], i);
        }

    }

    public void setNewLang() {
        initValues();
    }

    private void initValues() {
        Properties prop = new Properties();
        Properties conf = new Properties();
        FileInputStream ip;
        FileInputStream target;
        try {
            ip = new FileInputStream(FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\Valuator\\config.properties");
            conf.load(ip);
            target = new FileInputStream(FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\Valuator\\lang\\" + conf.getProperty("lastLang"));
            prop.load(target);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        menuItems = new String[][]{
            {prop.getProperty("ViewInfo"), prop.getProperty("info"), prop.getProperty("Ratios"), prop.getProperty("DCF"), prop.getProperty("DDM"), prop.getProperty("Graham"), prop.getProperty("NAV")},
            {prop.getProperty("jLabel13"), prop.getProperty("jLabel14"), prop.getProperty("jLabel15"), prop.getProperty("Ratios"), prop.getProperty("DCF"), prop.getProperty("DDM"), prop.getProperty("Graham"), prop.getProperty("NAV"), prop.getProperty("CleaningBut")},
            {prop.getProperty("valuation"), prop.getProperty("viewValSum"), prop.getProperty("Ratios"), prop.getProperty("DCF"), prop.getProperty("DDM"), prop.getProperty("Graham"), prop.getProperty("NAV")},
            {prop.getProperty("calc"), prop.getProperty("Ratios"), prop.getProperty("DCF"), prop.getProperty("DDM"), prop.getProperty("Graham"), prop.getProperty("NAV"), prop.getProperty("CleaningBut1")},
            {prop.getProperty("showSave")},
            {prop.getProperty("library")},
            {prop.getProperty("setting")},
            {prop.getProperty("help")}
        };
    }

    /**
     *
     * @param index
     * @return
     */
    private Icon getIcon(int index) {
        URL url = getClass().getResource("/Icons/" + index + ".png");
        if (url != null) {
            return new ImageIcon(url);
        } else {
            return null;
        }
    }

    /**
     *
     * @param nemuName
     * @param index
     */
    private void addMenu(String menuName, int index) {
        int length = menuItems[index].length;
        MenuItem item = new MenuItem(menuName, index, length > 1);
        Icon icon = getIcon(index);
        if (icon != null) {
            item.setIcon(icon);
        }
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (length > 1) {
                    if (!item.isSelected()) {
                        item.setSelected(true);
                        addSubMenu(item, index, length, getComponentZOrder(item));
                    } else {
                        //  Hide menu
                        hideMenu(item, index);
                        item.setSelected(false);
                    }
                } else {
                    if (event != null) {
                        event.selected(index, 0);
                    }
                }
            }
        });
        add(item);
        revalidate();
        repaint();
    }

    /**
     *
     * @param item
     * @param index
     * @param length
     * @param indexZorder
     */
    private void addSubMenu(MenuItem item, int index, int length, int indexZorder) {
        JPanel panel = new JPanel(new MigLayout("wrap 1, fillx, inset 0, gapy 0", "fill"));
        panel.setName(index + "");
        panel.setBackground(new Color(0, 231, 255));
        for (int i = 1; i < length; i++) {
            MenuItem subItem = new MenuItem(menuItems[index][i], i, false);
            subItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if (event != null) {
                        event.selected(index, subItem.getIndex());
                    }
                }
            });
            subItem.initSubMenu(i, length);
            panel.add(subItem);
        }
        add(panel, "h 0!", indexZorder + 1);
        revalidate();
        repaint();
        MenuAnimation.showMenu(panel, item, layout, true);
    }

    /**
     *
     * @param item
     * @param index
     */
    private void hideMenu(MenuItem item, int index) {
        for (Component com : getComponents()) {
            if (com instanceof JPanel && com.getName() != null && com.getName().equals(index + "")) {
                com.setName(null);
                MenuAnimation.showMenu(com, item, layout, false);
                break;
            }
        }
    }

    /**
     *
     * @param grphcs
     */
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setColor(new Color(0, 255, 246));
        g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
        super.paintComponent(grphcs);
    }

}
