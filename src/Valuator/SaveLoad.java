/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Valuator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author ondre
 */
public class SaveLoad {

    public SaveTemplate stemp;
    public Controller cont;
    private ArrayList<String> saves;
    private Properties conf;

    /**
     *
     * @param cont
     * @throws java.io.FileNotFoundException
     */
    public SaveLoad(Controller cont) throws FileNotFoundException, IOException {
        this.cont = cont;
        conf = new Properties();
        FileInputStream i = new FileInputStream("./src/Valuator/config.properties");
        conf.load(i);
    }

    public void initSaves() {
        File savesDir = new File(conf.getProperty("savesLib"));
        if (savesDir.exists()) {
            File[] files = new File(conf.getProperty("savesLib")).listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    saves.add(file.getName());
                }
            }
        } else {
            savesDir.mkdir();
        }
    }
    //show - calculate from inputs to complete view
    //edit - loads inputs from save

    /**
     *
     * @throws IOException
     */
    public void save() throws IOException {
        if (stemp != null) {
            String name = null;
            String d = ";";
            for (int i = 0; i > 1000; i++) {
                String test = Integer.toString(i) + ".csv";
                if (!saves.contains(test)) {
                    name = test;
                    stemp.setID(i);
                    break;
                }
            }
            File save = new File(conf.getProperty("savesLib" + name));
            save.createNewFile();
            FileWriter fw = new FileWriter(save, true);
            fw.write(stemp.getId());
            fw.write(d);
            for (String s : stemp.getValMethods()) {
                fw.write(s);
            }
            fw.write(d);
            fw.write(stemp.getName());
            fw.write(d);
            fw.write(stemp.getTicker());
            fw.write(d);
            fw.write(stemp.getExchange());
            fw.write(d);
            fw.write(stemp.getNote());
            fw.write(d);
            fw.write(String.valueOf(stemp.getActPrice()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getPillow()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getTotalRevenue()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getCostOfRevenue()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getOperatingExpense()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getOtherIncomeExpense()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getNetIncome()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getEbit()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getComStockDivPaid()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getTaxes()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getInterExpense()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getTotalAssest()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getCurAssets()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getReceivable()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getInventory()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getTotalLiabNetMinInt()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getCurLiabilities()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getTotalEqGrossMinInt()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getShareholdersEquity()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getCapitalLeaseObl()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getTanBookVal()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getOrdinaryShareNum()));
            fw.write(d);
            for (double n : stemp.getFCF()) {
                fw.write(String.valueOf(n));
            }
            fw.write(d);
            fw.write(String.valueOf(stemp.getGrRate()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getDisRate()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getActFCF()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getTotalDebt()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getSharesOuts()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getCashCashEq()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getPerpGrRate()));
            fw.write(d);
            for (double n : stemp.getDividends()) {
                fw.write(String.valueOf(n));
            }
            fw.write(d);
            fw.write(String.valueOf(stemp.getDiscRate()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getEps()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getGrGrRate()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getAaa()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getNAVTotAssets()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getNAVTotLiab()));
            fw.write(d);
            fw.write(String.valueOf(stemp.getNAVTotNumOfOutShare()));
            fw.flush();
        }
    }

    /**
     *
     * @param fileName
     */
    public void deleteSave(String fileName) {
        File target = new File(conf.getProperty("savesLib") + fileName);
        target.delete();
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getSaves() {
        return saves;
    }

}
