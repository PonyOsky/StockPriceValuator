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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ondre
 */
public class Languages {

    private ArrayList<String> props;
    private Properties conf;
            
    public Languages() throws FileNotFoundException, IOException {
        props = new ArrayList();
        conf = new Properties();
        FileInputStream ip = new FileInputStream("./src/Valuator/config.properties");
        conf.load(ip);
        File[] files =  new File("./src/lang").listFiles();
        for (File file : files) {
            if (file.isFile()) {
                props.add(file.getName());
            }
        }
        System.out.println(props);
    }
    
    private ArrayList getChoices(ArrayList langs) {
        if(langs != null){
            ArrayList<String> choices = new ArrayList();
            for(Object f : langs){
                String filePath = (String) f;
                Properties p = new Properties();
                FileInputStream ip = null;
                try {
                    ip = new FileInputStream(filePath);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Languages.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    p.load(ip);
                } catch (IOException ex) {
                    Logger.getLogger(Languages.class.getName()).log(Level.SEVERE, null, ex);
                }
                choices.add(p.getProperty("lang"));
            }
            return choices;
        }
        return null;
    }
    
    public void setLastLang(String newLang){
        conf.setProperty("lastLang", newLang);
    }

}