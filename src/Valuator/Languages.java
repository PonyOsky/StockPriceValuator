/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Valuator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author ondre
 */
public class Languages {

    private ArrayList<String> props;
    private Properties conf;
    private ArrayList<String> choices;

    public Languages() throws FileNotFoundException, IOException {
        props = new ArrayList();
        props.add(" ");
        conf = new Properties();
        FileInputStream ip = new FileInputStream("./src/Valuator/config.properties");
        conf.load(ip);
        File[] files = new File("./src/lang").listFiles();
        for (File file : files) {
            if (file.isFile()) {
                props.add(file.getName());
            }
        }
        choices = new ArrayList();
        choices.add(" ");
        fillChoices(props);
    }

    private void fillChoices(ArrayList langs) throws FileNotFoundException, IOException {
        if (langs != null) {
            for (var f : langs) {
                if (f != " ") {
                    String filePath = "./src/lang/" + f;
                    Properties p = new Properties();
                    FileInputStream ip = new FileInputStream(filePath);
                    p.load(ip);
                    choices.add(p.getProperty("lang"));
                }
            }
        }
    }

    public ArrayList<String> getChoices() {
        return choices;
    }

    public void setLastLang(int choice) throws FileNotFoundException, IOException {
        conf.setProperty("lastLang", choices.get(choice));
        conf.setProperty("lastLangRoute", "./src/lang/" + props.get(choice));
    }

    public String getRoute() {
        if (conf.getProperty("lastLangRoute") != null) {
            File f = new File(conf.getProperty("lastLangRoute"));
            if (f.exists()) {
                return conf.getProperty("lastLangRoute");
            } else {
                conf.setProperty("lastLang", conf.getProperty("defLang"));
                return conf.getProperty("defLangRoute");
            }
        } else {
            return conf.getProperty("defLangRoute");
        }
    }

    public String getDefLangType() {
        return conf.getProperty("lastLang");
    }
}
