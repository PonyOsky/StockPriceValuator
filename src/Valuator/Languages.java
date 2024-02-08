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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ondre
 */
public class Languages {

    private ArrayList<String> props;
    private Properties conf;
    private ArrayList<String> choices;
    private String dirPath;

    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public Languages() {
        dirPath = Frontend.getDirPath();

        //create Properties
        try {
            String filePath = dirPath + "\\config\\config.properties";
            FileInputStream ip = new FileInputStream(filePath);

            conf = new Properties();
            conf.load(ip);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Languages.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Languages.class.getName()).log(Level.SEVERE, null, ex);
        }

        //fill props
        props = new ArrayList();
        props.add(" ");
        File[] files = new File(dirPath + "\\lang").listFiles();
        for (File file : files) {
            if (file.isFile()) {
                props.add(file.getName());
            }
        }

        //fill choices
        choices = new ArrayList();
        choices.add(" ");
        try {
            fillChoices(props);
        } catch (IOException ex) {
            Logger.getLogger(Languages.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                    String filePath = dirPath + "\\lang\\" + f;
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
        FileOutputStream out = new FileOutputStream(dirPath + "\\config\\config.properties");
        conf.setProperty("lang", choices.get(choice));
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
            File f = new File(dirPath + "\\lang\\" + conf.getProperty("lastLang"));
            if (f.exists()) {
                return dirPath + "\\lang\\" + conf.getProperty("lastLang");
            } else {
                conf.setProperty("lang", conf.getProperty("defLang"));
                return dirPath + "\\lang\\" + conf.getProperty("defLang");
            }
        } else {
            return dirPath + "\\lang\\" + conf.getProperty("defLang");
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
