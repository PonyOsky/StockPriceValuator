/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Valuator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

/**
 *
 * @author ondre
 */
public class SaveLoad {

    public SaveTemplate stemp;
    public Controller cont;
    public ReworkedFrontend frontend;
    private ArrayList<String> saves;
    private Properties conf;
    private static final DecimalFormat decfor = new DecimalFormat("0.000");

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

    public void show(int fileName) throws IOException {
        SaveTemplate save = load().get(fileName);
        DividendDiscountModel ddm = new DividendDiscountModel();
        DiscountedCashFlowModel dcf = new DiscountedCashFlowModel();
        GrahamsFormulas graham = new GrahamsFormulas();
        NetAssetValue nav = new NetAssetValue();
        frontend.getjLabel163().setText(save.getName());
        frontend.getjLabel34().setText(save.getTicker());
        if (save.getValMethods().contains("CalcRatio")) {
            save.getValMethods().remove("CalcRatio");
        }
        if (save.getValMethods().contains("CalcDCF")) {
            dcf.price(save.getSharesOuts(), save.getCashCashEq(), save.getTotalDebt());
            dcf.priceMoS(save.getPillow());
            frontend.getDCFMoSAns().setText(decfor.format(dcf.getValueMoS()));
            frontend.getDCFAns().setText(decfor.format(dcf.getValue()));
        }
        if (save.getValMethods().contains("CalcDDM")) {
            ddm.getDDMPrice(save.getDividends());
            ddm.ddmMoS(save.getPillow());
            frontend.getDDMMoSAns().setText(decfor.format(ddm.getValueMoS()));
            frontend.getDDMAns().setText(decfor.format(ddm.getValue()));
        }
        if (save.getValMethods().contains("CalcGraham")) {
            graham.graham(save.getEps(), save.getGrGrRate(), save.getAaa());
            graham.grahamReversed(save.getEps(), save.getGrGrRate(), save.getAaa());
            graham.grahamMoS(save.getPillow());
            graham.grahamRevMoS(save.getPillow());
            frontend.getGrahamAns().setText(decfor.format(graham.getValue()));
            frontend.getGrahamRevAns().setText(decfor.format(graham.getValueRev()));
            frontend.getGrahamMoSAns().setText(decfor.format(graham.getValueMoS()));
            frontend.getGrahamRevMoSAns().setText(decfor.format(graham.getValueRevMoS()));
        }
        if (save.getValMethods().contains("CalcNAV")) {
            nav.valuation(save.getNAVTotAssets(), save.getNAVTotLiab(), save.getNAVTotNumOfOutShare());
            nav.valuationMoS(save.getPillow());
            frontend.getNAVAns().setText(decfor.format(nav.getValue()));
            frontend.getNAVMoSAns().setText(decfor.format(nav.getValuePillow()));
        }
        cont.makeValue(save.getValMethods().size());
        cont.makeValueMoS(save.getValMethods().size());
        frontend.getIdealPrice().setText(decfor.format(cont.getValue()));
        frontend.getIdealPriceMoS().setText(decfor.format(cont.getValueMoS()));
        frontend.getPillowAns().setText(String.valueOf(save.getPillow() * 100));
    }

    /**
     *
     * @param fileName
     * @throws IOException
     */
    public void edit(int fileName) throws IOException {
        SaveTemplate v = load().get(fileName);
        frontend.getCorpName().setText(v.getName());
        frontend.getSticker().setText(v.getTicker());
        frontend.getStockExchange().setText(v.getExchange());
        frontend.getPillow().setText(Double.toString(v.getPillow()));
        frontend.getActPrice().setText(Double.toString(v.getActPrice()));
        frontend.getNotes().setText(v.getNote());
        frontend.getTaxes().setText(Double.toString(v.getTaxes()));
        frontend.getIntExp().setText(Double.toString(v.getInterExpense()));
        frontend.getEBIT().setText(Double.toString(v.getEbit()));
        frontend.getTRevenue().setText(Double.toString(v.getTotalRevenue()));
        frontend.getNIncome().setText(Double.toString(v.getNetIncome()));
        frontend.getCurAssets().setText(Double.toString(v.getCurAssets()));
        frontend.getOrShNum().setText(Double.toString(v.getOrdinaryShareNum()));
        frontend.getTanBookVal().setText(Double.toString(v.getTanBookVal()));
        frontend.getTLiabilities().setText(Double.toString(v.getTotalLiabNetMinInt()));
        frontend.getComDiv().setText(Double.toString(v.getComStockDivPaid()));
        frontend.getTAssets().setText(Double.toString(v.getTotalAssest()));
        frontend.getTEGMI().setText(Double.toString(v.getTotalEqGrossMinInt()));
        frontend.getInv().setText(Double.toString(v.getInventory()));
        frontend.getOpExpense().setText(Double.toString(v.getOperatingExpense()));
        frontend.getCofRevenue().setText(Double.toString(v.getCostOfRevenue()));
        frontend.getOthIncome().setText(Double.toString(v.getOtherIncomeExpense()));
        frontend.getReceivable().setText(Double.toString(v.getReceivable()));
        frontend.getCurLiabilities().setText(Double.toString(v.getCurLiabilities()));
        frontend.getCapLO().setText(Double.toString(v.getCapitalLeaseObl()));
        frontend.getSHEquity().setText(Double.toString(v.getShareholdersEquity()));
        frontend.getGRDCF().setText(Double.toString(v.getGrRate()));
        frontend.getWACCDCFInn().setText(Double.toString(v.getDisRate()));
        frontend.getActFCF().setText(Double.toString(v.getActFCF()));
        frontend.getDebt().setText(Double.toString(v.getTotalDebt()));
        frontend.getShares().setText(Double.toString(v.getSharesOuts()));
        frontend.getCandC().setText(Double.toString(v.getCashCashEq()));
        frontend.getStateInn().setText(Double.toString(v.getPerpGrRate()));
        int count = 0;
        for (var d : v.getFCF()) {
            frontend.getFCF().setValueAt(d, 0, count);
            count++;
        }
        frontend.getWACCDDMInn().setText(Double.toString(v.getDiscRate()));
        count = 0;
        for (var d : v.getDividends()) {
            frontend.getDividends().setValueAt(d, 0, count);
            count++;
        }
        frontend.getEPS().setText(Double.toString(v.getEps()));
        frontend.getGR().setText(Double.toString(v.getGrGrRate()));
        frontend.getYInn().setText(Double.toString(v.getAaa()));
        frontend.getAssets().setText(Double.toString(v.getNAVTotAssets()));
        frontend.getLiabilities().setText(Double.toString(v.getNAVTotLiab()));
        frontend.getSharesNAV().setText(Double.toString(v.getNAVTotNumOfOutShare()));
    }

    /**
     *
     * @throws IOException
     */
    public void save() throws IOException {
        if (stemp != null) {
            for (int i = 0; i > 1000; i++) {
                String test = Integer.toString(i) + ".csv";
                if (!saves.contains(test)) {
                    stemp.setID(i);
                    break;
                }
            }
            File save = new File(conf.getProperty("savesLib" + stemp.getId() + ".csv"));
            FileWriter fw = new FileWriter(save, true);
            fw.write(stemp.getValues());
            fw.flush();
        }
    }

    /**
     *
     * @return @throws FileNotFoundException
     * @throws java.io.FileNotFoundException
     * @throws IOException
     */
    public ArrayList<SaveTemplate> load() throws FileNotFoundException, IOException {
        if (!saves.isEmpty()) {
            ArrayList<SaveTemplate> a = new ArrayList();
            for (String s : saves) {
                ArrayList<String> values = new ArrayList();
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(conf.getProperty("savesLib") + s)));
                if (br.readLine() != null) {
                    StringTokenizer tokens = new StringTokenizer(
                            (String) br.readLine(), ";");// this will read first line and separates values by (,) and stores them in tokens.
                    values.add(tokens.nextToken()); // this method will read the tokens values on each call.
                }
                ArrayList<String> calcs = new ArrayList<>(Arrays.asList(values.get(1).split(",")));
                ArrayList fcf = new ArrayList();
                if (calcs.contains("CalcDCF")) {
                    List<String> f = new ArrayList<>(Arrays.asList(values.get(27).split(",")));
                    for (String t : f) {
                        fcf.add(Double.valueOf(t));
                    }
                }
                ArrayList divs = new ArrayList();
                if (calcs.contains("CalcDDM")) {
                    List<String> f = new ArrayList<>(Arrays.asList(values.get(38).split(",")));
                    for (String t : f) {
                        fcf.add(Double.valueOf(t));
                    }
                }
                SaveTemplate st = new SaveTemplate(calcs,
                        values.get(1),
                        values.get(2),
                        values.get(3),
                        values.get(4),
                        Double.parseDouble(values.get(5)),
                        Double.parseDouble(values.get(6)),
                        Double.parseDouble(values.get(7)),
                        Double.parseDouble(values.get(8)),
                        Double.parseDouble(values.get(9)),
                        Double.parseDouble(values.get(10)),
                        Double.parseDouble(values.get(11)),
                        Double.parseDouble(values.get(12)),
                        Double.parseDouble(values.get(13)),
                        Double.parseDouble(values.get(14)),
                        Double.parseDouble(values.get(15)),
                        Double.parseDouble(values.get(16)),
                        Double.parseDouble(values.get(17)),
                        Double.parseDouble(values.get(18)),
                        Double.parseDouble(values.get(19)),
                        Double.parseDouble(values.get(20)),
                        Double.parseDouble(values.get(21)),
                        Double.parseDouble(values.get(22)),
                        Double.parseDouble(values.get(23)),
                        Double.parseDouble(values.get(24)),
                        Double.parseDouble(values.get(25)),
                        Double.parseDouble(values.get(26)),
                        fcf,
                        Double.parseDouble(values.get(27)),
                        Double.parseDouble(values.get(28)),
                        Double.parseDouble(values.get(29)),
                        Double.parseDouble(values.get(30)),
                        Double.parseDouble(values.get(31)),
                        Double.parseDouble(values.get(32)),
                        Double.parseDouble(values.get(33)),
                        divs,
                        Double.parseDouble(values.get(35)),
                        Double.parseDouble(values.get(36)),
                        Double.parseDouble(values.get(37)),
                        Double.parseDouble(values.get(38)),
                        Double.parseDouble(values.get(39)),
                        Double.parseDouble(values.get(40)),
                        Double.parseDouble(values.get(41)));
                a.add(st);
            }
            return a;
        }
        return null;
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
