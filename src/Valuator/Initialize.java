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
public class Initialize {

    private ReworkedFrontend frontend;
    private ArrayList<String> choices;
    private ArrayList<String> propPaths;
    private Properties prop;
    private String propLang;
            
    public Initialize(ReworkedFrontend f) throws FileNotFoundException, IOException {
        this.frontend = f;
        choices = new ArrayList();
        propPaths = new ArrayList();
        prop = new Properties();
        FileInputStream ip = new FileInputStream("./src/Valuator/config.properties");
        prop.load(ip);
        propLang = prop.getProperty("lastLang");
        File[] files =  new File("./src/lang").listFiles();
        for (File file : files) {
            if (file.isFile()) {
                propPaths.add(file.getPath());
            }
        }
        try {
            getChoices(propPaths);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Initialize.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void getChoices(ArrayList langs) throws FileNotFoundException{
        if(langs != null){
            for(Object f : langs){
                String filePath = (String) f;
                Properties p = new Properties();
                FileInputStream ip = new FileInputStream(filePath);
                try {
                    p.load(ip);
                } catch (IOException ex) {
                    Logger.getLogger(Initialize.class.getName()).log(Level.SEVERE, null, ex);
                }
                choices.add(p.getProperty("lang"));
            }
        }
    }
    
    public void init(){
        if(choices.contains(prop.getProperty("lastLang"))){
        
        }
    }
    
    public void setLastLang(String newLang){
        prop.setProperty("lastLang", newLang);
    }
    
    public String getLastLang(){
        return propLang;
    }

    public ArrayList getLangChoices() {
        return choices;
    }
}
