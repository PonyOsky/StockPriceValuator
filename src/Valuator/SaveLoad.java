/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Valuator;

import component.DCFInput;
import component.DDMInput;
import component.GrahamInput;
import component.InfoInput;
import component.NAVInput;
import component.RatioInput;
import component.ShowOut;
import java.io.BufferedReader;
import java.io.BufferedWriter;
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
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author ondre
 */
public class SaveLoad {

    public SaveTemplate stemp;
    public Controller cont;
    public Frontend frontend;
    private ArrayList<String> saves;
    private static final DecimalFormat decfor = new DecimalFormat("0.000");
    public ShowOut showout;
    public DCFInput dcfin;
    public DDMInput ddmin;
    public GrahamInput grahamin;
    public InfoInput info;
    public NAVInput navin;
    public RatioInput ratioin;
    private String path = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\Valuator\\";

    /**
     *
     * @param cont
     * @throws java.io.FileNotFoundException
     */
    public SaveLoad(Controller cont) throws FileNotFoundException, IOException {
        this.cont = cont;
        saves = new ArrayList();
        FileInputStream i = new FileInputStream(path + "config.properties");
    }

    /**
     *
     * @param sh
     * @param i
     * @param ri
     * @param dci
     * @param ddi
     * @param gi
     * @param ni
     */
    public void setShowout(ShowOut sh, InfoInput i, RatioInput ri, DCFInput dci, DDMInput ddi, GrahamInput gi, NAVInput ni) {
        info = i;
        showout = sh;
        ratioin = ri;
        dcfin = dci;
        ddmin = ddi;
        grahamin = gi;
        navin = ni;
    }

    public void initSaves() {
        File savesDir = new File(path + "\\saves");
        if (savesDir.exists()) {
            File[] files = new File(path + "\\saves\\").listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    saves.add(file.getName());
                }
            }
        } else {
            savesDir.mkdir();
        }
    }

    /**
     *
     * @param fileName
     * @throws IOException
     */
    public void show(int fileName) throws IOException {
        SaveTemplate save = load().get(fileName);
        DividendDiscountModel ddm = new DividendDiscountModel();
        DiscountedCashFlowModel dcf = new DiscountedCashFlowModel();
        GrahamsFormulas graham = new GrahamsFormulas();
        NetAssetValue nav = new NetAssetValue();
        showout.getjLabel163().setText(save.getName());
        showout.getjLabel34().setText(save.getTicker());
        if (save.getValMethods().contains("Ratio")) {
            save.getValMethods().remove("Ratio");
        }
        if (save.getValMethods().contains("DCF")) {
            dcf.price(save.getSharesOuts(), save.getCashCashEq(), save.getTotalDebt(), save.getPerpGrRate(), save.getGrRate(), save.getDisRate(), save.getActFCF());
            dcf.priceMoS(save.getPillow());
            showout.getDCFMoSAns().setText(decfor.format(dcf.getValueMoS()));
            showout.getDCFAns().setText(decfor.format(dcf.getValue()));
        }
        if (save.getValMethods().contains("DDM")) {
            ddm.getDDMPrice((ArrayList) save.getDividends());
            ddm.ddmMoS(save.getPillow());
            showout.getDDMMoSAns().setText(decfor.format(ddm.getValueMoS()));
            showout.getDDMAns().setText(decfor.format(ddm.getValue()));
        }
        if (save.getValMethods().contains("Graham")) {
            graham.graham(save.getEps(), save.getGrGrRate(), save.getAaa());
            graham.grahamReversed(save.getEps(), save.getGrGrRate(), save.getAaa());
            graham.grahamMoS(save.getPillow());
            graham.grahamRevMoS(save.getPillow());
            showout.getGrahamAns().setText(decfor.format(graham.getValue()));
            showout.getGrahamRevAns().setText(decfor.format(graham.getValueRev()));
            showout.getGrahamMoSAns().setText(decfor.format(graham.getValueMoS()));
            showout.getGrahamRevMoSAns().setText(decfor.format(graham.getValueRevMoS()));
        }
        if (save.getValMethods().contains("NAV")) {
            nav.valuation(save.getNAVTotAssets(), save.getNAVTotLiab(), save.getNAVTotNumOfOutShare());
            nav.valuationMoS(save.getPillow());
            showout.getNAVAns().setText(decfor.format(nav.getValue()));
            showout.getNAVMoSAns().setText(decfor.format(nav.getValuePillow()));
        }
        cont.makeValue(save.getValMethods().size());
        cont.makeValueMoS(save.getValMethods().size());
        showout.getIdealPrice().setText(decfor.format(cont.getValue()));
        showout.getIdealPriceMoS().setText(decfor.format(cont.getValueMoS()));
        showout.getPillowAns().setText(String.valueOf(save.getPillow() * 100));
    }

    /**
     *
     * @param fileName
     * @throws IOException
     */
    public void edit(int fileName) throws IOException {
        SaveTemplate v = load().get(fileName);
        info.getCorpName().setText(v.getName());
        info.getSticker().setText(v.getTicker());
        info.getStockExchange().setText(v.getExchange());
        info.getPillow().setText(Double.toString(v.getPillow()));
        info.getActPrice().setText(Double.toString(v.getActPrice()));
        info.getNotes().setText(v.getNote());
        ratioin.getTaxes().setText(Double.toString(v.getTaxes()));
        ratioin.getIntExp().setText(Double.toString(v.getInterExpense()));
        ratioin.getEBIT().setText(Double.toString(v.getEbit()));
        ratioin.getTRevenue().setText(Double.toString(v.getTotalRevenue()));
        ratioin.getNIncome().setText(Double.toString(v.getNetIncome()));
        ratioin.getCurAssets().setText(Double.toString(v.getCurAssets()));
        ratioin.getOrShNum().setText(Double.toString(v.getOrdinaryShareNum()));
        ratioin.getTanBookVal().setText(Double.toString(v.getTanBookVal()));
        ratioin.getTLiabilities().setText(Double.toString(v.getTotalLiabNetMinInt()));
        ratioin.getComDiv().setText(Double.toString(v.getComStockDivPaid()));
        ratioin.getTAssets().setText(Double.toString(v.getTotalAssest()));
        ratioin.getTEGMI().setText(Double.toString(v.getTotalEqGrossMinInt()));
        ratioin.getInv().setText(Double.toString(v.getInventory()));
        ratioin.getOpExpense().setText(Double.toString(v.getOperatingExpense()));
        ratioin.getCofRevenue().setText(Double.toString(v.getCostOfRevenue()));
        ratioin.getOthIncome().setText(Double.toString(v.getOtherIncomeExpense()));
        ratioin.getReceivable().setText(Double.toString(v.getReceivable()));
        ratioin.getCurLiabilities().setText(Double.toString(v.getCurLiabilities()));
        ratioin.getCapLO().setText(Double.toString(v.getCapitalLeaseObl()));
        ratioin.getSHEquity().setText(Double.toString(v.getShareholdersEquity()));
        dcfin.getGR().setText(Double.toString(v.getGrRate()));
        dcfin.getWACCDCFInn().setText(Double.toString(v.getDisRate()));
        dcfin.getActFCF().setText(Double.toString(v.getActFCF()));
        dcfin.getDebt().setText(Double.toString(v.getTotalDebt()));
        dcfin.getShares().setText(Double.toString(v.getSharesOuts()));
        dcfin.getCandC().setText(Double.toString(v.getCashCashEq()));
        dcfin.getState().setText(Double.toString(v.getPerpGrRate()));
        int count = 0;
        for (var d : v.getFCF()) {
            dcfin.getFCF().setValueAt(d, 0, count);
            count++;
        }
        ddmin.getWACCDDM().setText(Double.toString(v.getDiscRate()));
        count = 0;
        for (var d : v.getDividends()) {
            ddmin.getDividends().setValueAt(d, 0, count);
            count++;
        }
        grahamin.getEPS().setText(Double.toString(v.getEps()));
        grahamin.getGRGraham().setText(Double.toString(v.getGrGrRate()));
        grahamin.getYInn().setText(Double.toString(v.getAaa()));
        navin.getTotalAssets().setText(Double.toString(v.getNAVTotAssets()));
        navin.getTotalLiab().setText(Double.toString(v.getNAVTotLiab()));
        navin.getSharesOut().setText(Double.toString(v.getNAVTotNumOfOutShare()));
    }

    /**
     *
     * @throws IOException
     * @param stemp
     */
    public void save(SaveTemplate stemp) throws IOException {
        if (stemp != null) {
            for (int i = 0; i >= 0; i++) {
                String test = Integer.toString(i) + ".csv";
                if (!saves.contains(test)) {
                    stemp.setID(i);
                    break;
                }
            }
        }

        FileWriter fw;
        BufferedWriter bw;
        File save = new File(path + "\\saves\\" + stemp.getId() + ".csv");
        save.createNewFile();
        fw = new FileWriter(save, true);
        bw = new BufferedWriter(fw);
        bw.append(stemp.getValues());
        bw.flush();
        bw.close();
        fw.close();
    }

    /**
     *
     * @return @throws FileNotFoundException
     * @throws java.io.FileNotFoundException
     * @throws IOException
     */
    public List<SaveTemplate> load() throws FileNotFoundException, IOException {
        if (!saves.isEmpty()) {
            List<SaveTemplate> a = new ArrayList();
            for (String s : saves) {
                List<String> values = new ArrayList();
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path + "\\saves\\" + s)));
                if (br.ready()) {
                    //StringTokenizer tokens = new StringTokenizer(
                    //        (String) br.readLine(), ";");// this will read first line and separates values by (,) and stores them in tokens.
                    //values.add(tokens.nextToken()); // this method will read the tokens values on each call.
                    values = Arrays.stream(br.readLine().split(";")).toList();
                }
                List<String> calcs = new ArrayList<>(Arrays.asList(values.get(1).split(",")));
                List fcf = new ArrayList();
                if (calcs.contains("CalcDCF")) {
                    String[] f = values.get(28).split(",");
                    for (String t : f) {
                        fcf.add(Double.valueOf(t));
                    }
                }
                List<Double> divs = new ArrayList();
                if (calcs.contains("CalcDDM")) {
                    String[] f = values.get(36).split(",");
                    for (String t : f) {
                        divs.add(Double.valueOf(t));
                    }
                }
                SaveTemplate st = new SaveTemplate(calcs,
                        values.get(2),
                        values.get(3),
                        values.get(4),
                        values.get(5),
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
                        Double.parseDouble(values.get(27)),
                        fcf,
                        Double.parseDouble(values.get(29)),
                        Double.parseDouble(values.get(30)),
                        Double.parseDouble(values.get(31)),
                        Double.parseDouble(values.get(32)),
                        Double.parseDouble(values.get(33)),
                        Double.parseDouble(values.get(34)),
                        Double.parseDouble(values.get(35)),
                        divs,
                        Double.parseDouble(values.get(37)),
                        Double.parseDouble(values.get(38)),
                        Double.parseDouble(values.get(39)),
                        Double.parseDouble(values.get(40)),
                        Double.parseDouble(values.get(41)),
                        Double.parseDouble(values.get(42)),
                        Double.parseDouble(values.get(43)));
                a.add(st);
                br.close();
            }
            return a;
        }
        return new ArrayList();
    }

    /**
     *
     * @param fileName
     */
    public void deleteSave(String fileName) {
        File target = new File(path + "\\saves\\" + fileName);
        target.delete();
    }

    /**
     *
     * @return
     */
    public List<String> getSaves() {
        return saves;
    }

}
