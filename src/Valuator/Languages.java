/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Valuator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author ondre
 */
public class Languages {

    private ArrayList<String> props;
    private Properties conf;
    private ArrayList<String> choices;
    private String path = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\Valuator\\";

    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public Languages() throws FileNotFoundException, IOException {
        props = new ArrayList();
        props.add(" ");
        conf = new Properties();
        FileInputStream ip = new FileInputStream(path + "config.properties");
        conf.load(ip);
        File[] files = new File(path + "lang").listFiles();
        for (File file : files) {
            if (file.isFile()) {
                props.add(file.getName());
            }
        }
        choices = new ArrayList();
        choices.add(" ");
        fillChoices(props);
    }

    /**
     *
     * @param langs
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void fillChoices(ArrayList langs) throws FileNotFoundException, IOException {
        if (langs != null) {
            for (var f : langs) {
                if (f != " ") {
                    String filePath = path + "lang\\" + f;
                    Properties p = new Properties();
                    FileInputStream ip = new FileInputStream(filePath);
                    p.load(ip);
                    choices.add(p.getProperty("lang"));
                }
            }
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getChoices() {
        return choices;
    }

    /**
     *
     * @param choice
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void setLastLang(int choice) throws FileNotFoundException, IOException {
        FileOutputStream out = new FileOutputStream(path + "config.properties");
        conf.setProperty("lang", choices.get(choice));
        conf.setProperty("lastLang", path + "lang\\" + props.get(choice));
        conf.store(out, null);
    }

    /**
     *
     * @return
     */
    public String getLastLang() {
        return conf.getProperty("lang");
    }

    /**
     *
     * @return
     */
    public String getRoute() {
        if (conf.getProperty("lastLang") != null) {
            File f = new File(path + "lang\\" + conf.getProperty("lastLang"));
            if (f.exists()) {
                return path + "lang\\" + conf.getProperty("lastLang");
            } else {
                conf.setProperty("lang", conf.getProperty("defLang"));
                return path + "lang\\" + conf.getProperty("defLang");
            }
        } else {
            return path + "lang\\" + conf.getProperty("defLang");
        }
    }

    /**
     *
     * @return
     */
    public String getDefLangType() {
        return conf.getProperty("lang");
    }
}
