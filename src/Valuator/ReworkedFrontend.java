/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Valuator;

import java.awt.Color;
import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumn;

/**
 *
 * @author ondre
 *
 * Colors set up: rgb(0, 255, 246) rgb(0, 231, 255) rgb(0, 158, 255) rgb(0, 20,
 * 255)
 *
 */
public final class ReworkedFrontend extends javax.swing.JFrame {

    /**
     * Creates new form ReworkedFrontend
     */
    private final Color lightColor;
    private final Color lightDarkColor;
    private final Color darkLightColor;
    private final Color darkColor;
    private ArrayList<JPanel> activeChoices;
    public ArrayList<String> cleaningChoices;
    public ArrayList<String> calcChoices;
    public ArrayList<String> langChoices;
    public final JPanel[] views;
    private boolean hiddenInputs = true;
    private boolean hiddenOutputs = true;
    private boolean hiddenCleaning = true;
    private boolean hiddenCalc = true;
    private JPanel actShowing;
    private JPanel actMenuItem;
    public Languages langs;
    public Controller controller;

    public ReworkedFrontend() throws IOException {
        initComponents();
        setIconImage(new ImageIcon(this.getClass().getResource("/Icons/icon.png")).getImage());
        setTitle("Stock price valuator");
        langs = new Languages();
        controller = new Controller(this);
        HidingMenuInputs.setVisible(false);
        HidingMenuOutputs.setVisible(false);
        HidingMenuCleaning.setVisible(false);
        HidingMenuCalculation.setVisible(false);
        activeChoices = new ArrayList();
        cleaningChoices = new ArrayList();
        calcChoices = new ArrayList();
        langChoices = new ArrayList();
        views = new JPanel[]{InfoIn, RatioIn, DCFIn, DDMIn, GrahamIn, NAVIn, SummaryOut, RatioOut, DCFOut, DDMOut, GrahamOut, NAVOut, Settings, Help, Save, Library};
        lightColor = new Color(0, 255, 246);
        lightDarkColor = new Color(0, 231, 255);
        darkLightColor = new Color(0, 158, 255);
        darkColor = new Color(0, 20, 255);
        makeUnvisibleViews();
        setChoicesNames();
        setLabels(langs.getRoute());
        getActYear();
        setLangChoices();
    }

    private void setLangChoices() {
        for (String item : langs.getChoices()) {
            LangChoice.addItem(item);
        }
        LangChoice.setSelectedItem(langs.getDefLangType());
    }

    public Integer getActYear() {
        Date currentDate = new Date();
        return (int) currentDate.getYear() + 1900;
    }

    private void setLabels(String route) throws IOException {
        if (route != null) {
            Properties lang = new Properties();
            Properties conf = new Properties();
            FileInputStream i = new FileInputStream("./src/Valuator/config.properties");
            conf.load(i);
            FileInputStream ip = new FileInputStream(route);
            lang.load(ip);
            //Hiding menu of Inputs
            jLabel2.setText(lang.getProperty("jLabel2"));
            ViewInfo.setText(lang.getProperty("ViewInfo"));
            ViewRatioIn.setText(lang.getProperty("Ratios"));
            ViewDCFIn.setText(lang.getProperty("DCF"));
            ViewDDMIn.setText(lang.getProperty("DDM"));
            ViewGrahamIn.setText(lang.getProperty("Graham"));
            ViewNAVIn.setText(lang.getProperty("NAV"));
            //Hiding menu of Outputs
            jLabel3.setText(lang.getProperty("jLabel3"));
            viewValSum.setText(lang.getProperty("viewValSum"));
            viewCalcRatio.setText(lang.getProperty("viewCalcRatio"));
            viewDCFVal.setText(lang.getProperty("viewDCFVal"));
            viewDDMVal.setText(lang.getProperty("viewDDMVal"));
            viewGrahamVal.setText(lang.getProperty("viewGrahamVal"));
            viewNAVVal.setText(lang.getProperty("viewNAVVal"));
            //Hiding menu of cleaning choices
            jLabel13.setText(lang.getProperty("jLabel13"));
            jLabel14.setText(lang.getProperty("jLabel14"));
            jLabel15.setText(lang.getProperty("jLabel15"));
            jLabel16.setText(lang.getProperty("Ratios"));
            jLabel17.setText(lang.getProperty("DCF"));
            jLabel18.setText(lang.getProperty("DDM"));
            jLabel19.setText(lang.getProperty("Graham"));
            jLabel26.setText(lang.getProperty("NAV"));
            CleaningBut.setText(lang.getProperty("CleaningBut"));
            //Hiding menu of claculation choices
            jLabel20.setText(lang.getProperty("jLabel20"));
            jLabel22.setText(lang.getProperty("Ratios"));
            jLabel23.setText(lang.getProperty("DCF"));
            jLabel24.setText(lang.getProperty("DDM"));
            jLabel25.setText(lang.getProperty("Graham"));
            jLabel27.setText(lang.getProperty("NAV"));
            CleaningBut1.setText(lang.getProperty("CleaningBut1"));
            //Informations inputs
            jLabel54.setText(lang.getProperty("jLabel54"));
            jLabel55.setText(lang.getProperty("jLabel55"));
            jLabel28.setText(lang.getProperty("jLabel28"));
            jLabel29.setText(lang.getProperty("jLabel29"));
            jLabel30.setText(lang.getProperty("jLabel30"));
            jLabel44.setText(lang.getProperty("jLabel44"));
            jLabel166.setText(lang.getProperty("jLabel166"));
            jLabel31.setText(lang.getProperty("jLabel31"));
            //Ratios inputs
            jLabel191.setText(lang.getProperty("jLabel191"));
            jLabel192.setText(lang.getProperty("jLabel192"));
            jLabel194.setText(lang.getProperty("jLabel194"));
            jLabel195.setText(lang.getProperty("jLabel195"));
            jLabel196.setText(lang.getProperty("jLabel196"));
            jLabel197.setText(lang.getProperty("jLabel197"));
            jLabel198.setText(lang.getProperty("jLabel198"));
            jLabel199.setText(lang.getProperty("jLabel199"));
            jLabel200.setText(lang.getProperty("jLabel200"));
            jLabel201.setText(lang.getProperty("jLabel201"));
            jLabel202.setText(lang.getProperty("jLabel202"));
            jLabel203.setText(lang.getProperty("jLabel203"));
            jLabel204.setText(lang.getProperty("jLabel204"));
            jLabel205.setText(lang.getProperty("jLabel205"));
            jLabel206.setText(lang.getProperty("jLabel206"));
            jLabel207.setText(lang.getProperty("jLabel207"));
            jLabel208.setText(lang.getProperty("jLabel208"));
            jLabel209.setText(lang.getProperty("jLabel209"));
            jLabel210.setText(lang.getProperty("jLabel210"));
            jLabel211.setText(lang.getProperty("jLabel211"));
            jLabel212.setText(lang.getProperty("jLabel212"));
            jLabel213.setText(lang.getProperty("jLabel213"));
            jLabel214.setText(lang.getProperty("jLabel214"));
            jLabel215.setText(lang.getProperty("jLabel215"));
            jLabel216.setText(lang.getProperty("jLabel216"));
            jLabel217.setText(lang.getProperty("jLabel217"));
            //DCF inputs
            jLabel45.setText(lang.getProperty("jLabel45"));
            jLabel134.setText(lang.getProperty("jLabel134"));
            jLabel135.setText(lang.getProperty("jLabel135"));
            jLabel136.setText(lang.getProperty("jLabel136"));
            jLabel137.setText(lang.getProperty("jLabel137"));
            jLabel141.setText(lang.getProperty("jLabel141"));
            jLabel142.setText(lang.getProperty("jLabel142"));
            jLabel164.setText(lang.getProperty("jLabel164"));
            TableColumn t = FCF2.getTableHeader().getColumnModel().getColumn(0);
            t.setHeaderValue(lang.getProperty("year"));
            TableColumn ta = FCF2.getTableHeader().getColumnModel().getColumn(1);
            ta.setHeaderValue(lang.getProperty("titleCol1"));
            FCF2.getTableHeader().repaint();
            for (int y = 0; y < 9; y++) {
                FCF2.setValueAt(getActYear() - y, y, 0);
            }
            //DDM inputs
            jLabel57.setText(lang.getProperty("jLabel57"));
            jLabel58.setText(lang.getProperty("jLabel58"));
            TableColumn tb = Dividends.getTableHeader().getColumnModel().getColumn(0);
            tb.setHeaderValue(lang.getProperty("year"));
            TableColumn tc = Dividends.getTableHeader().getColumnModel().getColumn(1);
            tc.setHeaderValue(lang.getProperty("titleCol2"));
            Dividends.getTableHeader().repaint();
            for (int y = 0; y < 5; y++) {
                Dividends.setValueAt(getActYear() - y, y, 0);
            }
            //Graham inputs
            jLabel59.setText(lang.getProperty("jLabel59"));
            jLabel60.setText(lang.getProperty("jLabel60"));
            jLabel61.setText(lang.getProperty("jLabel61"));
            jLabel62.setText(lang.getProperty("jLabel62"));
            //NAV inputs
            jLabel63.setText(lang.getProperty("jLabel63"));
            jLabel64.setText(lang.getProperty("jLabel64"));
            jLabel65.setText(lang.getProperty("jLabel65"));
            jLabel66.setText(lang.getProperty("jLabel66"));
            //Summary outputs
            jLabel67.setText(lang.getProperty("jLabel67"));
            jLabel72.setText(lang.getProperty("DCF"));
            jLabel73.setText(lang.getProperty("DDM"));
            jLabel74.setText(lang.getProperty("Graham"));
            jLabel88.setText(lang.getProperty("jLabel88"));
            jLabel75.setText(lang.getProperty("NAV"));
            jLabel76.setText(lang.getProperty("price"));
            jLabel77.setText(lang.getProperty("price"));
            jLabel78.setText(lang.getProperty("price"));
            jLabel79.setText(lang.getProperty("price"));
            jLabel80.setText(lang.getProperty("price"));
            jLabel81.setText(lang.getProperty("pricemos"));
            jLabel82.setText(lang.getProperty("pricemos"));
            jLabel83.setText(lang.getProperty("pricemos"));
            jLabel84.setText(lang.getProperty("pricemos"));
            jLabel85.setText(lang.getProperty("pricemos"));
            jLabel68.setText(lang.getProperty("jLabel68"));
            jLabel70.setText(lang.getProperty("jLabel70"));
            jLabel69.setText(lang.getProperty("jLabel69"));
            jLabel71.setText(lang.getProperty("mos"));
            //Ratios outputs
            jLabel86.setText(lang.getProperty("jLabel86"));
            jLabel89.setText(lang.getProperty("jLabel89"));
            jLabel90.setText(lang.getProperty("jLabel90"));
            jLabel91.setText(lang.getProperty("jLabel91"));
            jLabel92.setText(lang.getProperty("jLabel92"));
            jLabel93.setText(lang.getProperty("jLabel93"));
            jLabel94.setText(lang.getProperty("jLabel94"));
            jLabel95.setText(lang.getProperty("jLabel95"));
            jLabel96.setText(lang.getProperty("jLabel96"));
            jLabel101.setText(lang.getProperty("jLabel101"));
            jLabel102.setText(lang.getProperty("jLabel102"));
            jLabel103.setText(lang.getProperty("jLabel103"));
            jLabel104.setText(lang.getProperty("jLabel104"));
            jLabel105.setText(lang.getProperty("jLabel105"));
            jLabel106.setText(lang.getProperty("jLabel106"));
            jLabel107.setText(lang.getProperty("jLabel107"));
            jLabel108.setText(lang.getProperty("jLabel108"));
            //DCF outputs
            jLabel87.setText(lang.getProperty("jLabel87"));
            jLabel98.setText(lang.getProperty("jLabel98"));
            jLabel100.setText(lang.getProperty("jLabel100"));
            jLabel116.setText(lang.getProperty("jLabel116"));
            jLabel117.setText(lang.getProperty("jLabel117"));
            jLabel109.setText(lang.getProperty("jLabel109"));
            jLabel110.setText(lang.getProperty("jLabel110"));
            jLabel111.setText(lang.getProperty("jLabel111"));
            jLabel112.setText(lang.getProperty("jLabel112"));
            jLabel113.setText(lang.getProperty("jLabel113"));
            jLabel114.setText(lang.getProperty("jLabel114"));
            jLabel115.setText(lang.getProperty("jLabel115"));
            jLabel97.setText(lang.getProperty("actprice"));
            jLabel99.setText(lang.getProperty("mos"));
            TableColumn td = LastFCF.getTableHeader().getColumnModel().getColumn(0);
            td.setHeaderValue(lang.getProperty("year"));
            for (int y = 1; y < 9; y++) {
                TableColumn c = LastFCF.getTableHeader().getColumnModel().getColumn(y);
                c.setHeaderValue(getActYear() + (y - 8));
            }
            LastFCF.getTableHeader().repaint();
            LastFCF.setValueAt(lang.getProperty("tableVal1"), 0, 0);
            LastFCF.setValueAt(lang.getProperty("tableVal2"), 1, 0);
            TableColumn te = FutureFCF.getTableHeader().getColumnModel().getColumn(0);
            te.setHeaderValue(lang.getProperty("titleCol3"));
            for (int y = 1; y < 14; y++) {
                TableColumn c = FutureFCF.getTableHeader().getColumnModel().getColumn(y);
                c.setHeaderValue(y);
            }
            FutureFCF.getTableHeader().repaint();
            FutureFCF.setValueAt(lang.getProperty("year"), 0, 0);
            for (int y = 1; y < 13; y++) {
                FutureFCF.setValueAt(getActYear() + y, 0, y);
            }
            FutureFCF.setValueAt(lang.getProperty("tableVal3"), 0, 13);
            FutureFCF.setValueAt(lang.getProperty("tableVal4"), 1, 0);
            FutureFCF.setValueAt(lang.getProperty("tableVal5"), 2, 0);
            //DDM outputs
            jLabel120.setText(lang.getProperty("jLabel120"));
            jLabel122.setText(lang.getProperty("jLabel122"));
            jLabel124.setText(lang.getProperty("jLabel124"));
            jLabel125.setText(lang.getProperty("jLabel125"));
            jLabel126.setText(lang.getProperty("jLabel126"));
            jLabel121.setText(lang.getProperty("actprice"));
            jLabel123.setText(lang.getProperty("mos"));
            TableColumn tf = DividendsPrediction.getTableHeader().getColumnModel().getColumn(0);
            tf.setHeaderValue(lang.getProperty("year"));
            for (int y = 1; y < 6; y++) {
                TableColumn c = DividendsPrediction.getTableHeader().getColumnModel().getColumn(y);
                c.setHeaderValue(getActYear() + (y - 5));
            }
            DividendsPrediction.getTableHeader().repaint();
            DividendsPrediction.setValueAt(lang.getProperty("tableVal6"), 0, 0);
            DividendsPrediction.setValueAt(lang.getProperty("tableVal7"), 1, 0);
            DividendsPrediction.setValueAt(lang.getProperty("tableVal8"), 2, 0);
            //Graham outputs
            jLabel127.setText(lang.getProperty("jLabel127"));
            jLabel156.setText(lang.getProperty("jLabel156"));
            jLabel157.setText(lang.getProperty("jLabel157"));
            jLabel158.setText(lang.getProperty("jLabel158"));
            jLabel139.setText(lang.getProperty("jLabel139"));
            jLabel143.setText(lang.getProperty("jLabel143"));
            jLabel146.setText(lang.getProperty("jLabel146"));
            jLabel147.setText(lang.getProperty("jLabel147"));
            jLabel150.setText(lang.getProperty("jLabel150"));
            jLabel153.setText(lang.getProperty("jLabel153"));
            jLabel154.setText(lang.getProperty("jLabel154"));
            jLabel155.setText(lang.getProperty("jLabel155"));
            jLabel138.setText(lang.getProperty("actprice"));
            jLabel140.setText(lang.getProperty("mos"));
            jLabel144.setText(conf.getProperty("PE"));
            jLabel145.setText(conf.getProperty("PERev"));
            jLabel148.setText(conf.getProperty("GRM"));
            jLabel149.setText(conf.getProperty("GRMRev"));
            jLabel151.setText(conf.getProperty("AvgrYeald"));
            jLabel152.setText(conf.getProperty("AvgrYeald"));
            //NAV outputs
            jLabel159.setText(lang.getProperty("jLabel159"));
            jLabel119.setText(lang.getProperty("jLabel119"));
            jLabel129.setText(lang.getProperty("jLabel129"));
            jLabel1.setText(lang.getProperty("jLabel1"));
            jLabel4.setText(lang.getProperty("jLabel4"));
            jLabel5.setText(lang.getProperty("jLabel5"));
            jLabel118.setText(lang.getProperty("actprice"));
            jLabel128.setText(lang.getProperty("mos"));
            //Help page
            jLabel161.setText(lang.getProperty("jLabel161"));
            //Setting page
            jLabel160.setText(lang.getProperty("jLabel160"));
            jLabel6.setText(lang.getProperty("jLabel6"));
            jButton1.setText(lang.getProperty("jButton1"));
        }
    }

    public void makeUnvisibleViews() {
        if (views != null) {
            for (JPanel a : views) {
                a.setVisible(false);
            }
        }
    }

    public void setChoicesNames() {
        CleanAll.setName("CleanAll");
        CleanInfo.setName("CleanInfo");
        CleanRatio.setName("CleanRatio");
        CleanDCF.setName("CleanDCF");
        CleanDDM.setName("CleanDDM");
        CleanGraham.setName("CleanGraham");
        CleanNAV.setName("CleanNAV");
        CalcRatio.setName("CalcRatio");
        CalcDCF.setName("CalcDCF");
        CalcDDM.setName("CalcDDM");
        CalcGraham.setName("CalcGraham");
        CalcNAV.setName("CalcNAV");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPanel();
        MenuColumn = new javax.swing.JPanel();
        InputBut = new javax.swing.JPanel();
        innLabel = new javax.swing.JLabel();
        CleanBut = new javax.swing.JPanel();
        cleanLabel = new javax.swing.JLabel();
        ResultBut = new javax.swing.JPanel();
        resultLabel = new javax.swing.JLabel();
        SaveBut = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        LibraryBut = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        CalcBut = new javax.swing.JPanel();
        calcLabel = new javax.swing.JLabel();
        Space0 = new javax.swing.JPanel();
        Space1 = new javax.swing.JPanel();
        SettingBut = new javax.swing.JPanel();
        setttingLabel = new javax.swing.JLabel();
        HelpBut = new javax.swing.JPanel();
        helpLabel = new javax.swing.JLabel();
        HidingMenuInputs = new javax.swing.JPanel();
        LocalizatorIn = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Info = new javax.swing.JPanel();
        ViewInfo = new javax.swing.JLabel();
        InRatio = new javax.swing.JPanel();
        ViewRatioIn = new javax.swing.JLabel();
        InDCF = new javax.swing.JPanel();
        ViewDCFIn = new javax.swing.JLabel();
        InDDM = new javax.swing.JPanel();
        ViewDDMIn = new javax.swing.JLabel();
        InGraham = new javax.swing.JPanel();
        ViewGrahamIn = new javax.swing.JLabel();
        InNAV = new javax.swing.JPanel();
        ViewNAVIn = new javax.swing.JLabel();
        HidingMenuOutputs = new javax.swing.JPanel();
        LocalizatorOut = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        OutSummary = new javax.swing.JPanel();
        viewValSum = new javax.swing.JLabel();
        OutRatio = new javax.swing.JPanel();
        viewCalcRatio = new javax.swing.JLabel();
        OutDCF = new javax.swing.JPanel();
        viewDCFVal = new javax.swing.JLabel();
        OutDDM = new javax.swing.JPanel();
        viewDDMVal = new javax.swing.JLabel();
        OutGraham = new javax.swing.JPanel();
        viewGrahamVal = new javax.swing.JLabel();
        OutNAV = new javax.swing.JPanel();
        viewNAVVal = new javax.swing.JLabel();
        HidingMenuCleaning = new javax.swing.JPanel();
        LocalizatorCleaning = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        CleanAll = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        CleanInfo = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        CleanRatio = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        CleanDCF = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        CleanDDM = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        CleanGraham = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        CleanNAV = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        Clean = new javax.swing.JPanel();
        CleaningBut = new javax.swing.JLabel();
        HidingMenuCalculation = new javax.swing.JPanel();
        LocalizatorCalculating = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        CalcRatio = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        CalcDCF = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        CalcDDM = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        CalcGraham = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        CalcNAV = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        Calc = new javax.swing.JPanel();
        CleaningBut1 = new javax.swing.JLabel();
        WelcomePanel = new javax.swing.JPanel();
        RatioIn = new javax.swing.JPanel();
        jPanel92 = new javax.swing.JPanel();
        jLabel191 = new javax.swing.JLabel();
        jLabel192 = new javax.swing.JLabel();
        jPanel93 = new javax.swing.JPanel();
        jPanel94 = new javax.swing.JPanel();
        jLabel194 = new javax.swing.JLabel();
        TRevenue2 = new javax.swing.JTextField();
        jLabel195 = new javax.swing.JLabel();
        CofRevenue2 = new javax.swing.JTextField();
        jLabel196 = new javax.swing.JLabel();
        OpExpense2 = new javax.swing.JTextField();
        jLabel197 = new javax.swing.JLabel();
        OthIncome2 = new javax.swing.JTextField();
        jLabel198 = new javax.swing.JLabel();
        NIncome2 = new javax.swing.JTextField();
        jLabel199 = new javax.swing.JLabel();
        EBIT2 = new javax.swing.JTextField();
        jPanel95 = new javax.swing.JPanel();
        jLabel200 = new javax.swing.JLabel();
        jPanel96 = new javax.swing.JPanel();
        jLabel201 = new javax.swing.JLabel();
        jLabel202 = new javax.swing.JLabel();
        ComDiv2 = new javax.swing.JTextField();
        jPanel97 = new javax.swing.JPanel();
        jLabel203 = new javax.swing.JLabel();
        jPanel98 = new javax.swing.JPanel();
        jLabel204 = new javax.swing.JLabel();
        jLabel205 = new javax.swing.JLabel();
        Taxes2 = new javax.swing.JTextField();
        jLabel206 = new javax.swing.JLabel();
        IntExp2 = new javax.swing.JTextField();
        jPanel99 = new javax.swing.JPanel();
        jLabel207 = new javax.swing.JLabel();
        TAssets2 = new javax.swing.JTextField();
        jLabel208 = new javax.swing.JLabel();
        CurAssets2 = new javax.swing.JTextField();
        jLabel209 = new javax.swing.JLabel();
        Receivable2 = new javax.swing.JTextField();
        jLabel210 = new javax.swing.JLabel();
        Inv2 = new javax.swing.JTextField();
        jLabel211 = new javax.swing.JLabel();
        TLiabilities2 = new javax.swing.JTextField();
        jLabel212 = new javax.swing.JLabel();
        CurLiabilities2 = new javax.swing.JTextField();
        jLabel213 = new javax.swing.JLabel();
        TEGMI2 = new javax.swing.JTextField();
        jLabel214 = new javax.swing.JLabel();
        SHEquity2 = new javax.swing.JTextField();
        jLabel215 = new javax.swing.JLabel();
        CapLO2 = new javax.swing.JTextField();
        jLabel216 = new javax.swing.JLabel();
        TanBookVal2 = new javax.swing.JTextField();
        jLabel217 = new javax.swing.JLabel();
        OrShNum2 = new javax.swing.JTextField();
        GrahamOut = new javax.swing.JPanel();
        jPanel72 = new javax.swing.JPanel();
        jLabel127 = new javax.swing.JLabel();
        jPanel73 = new javax.swing.JPanel();
        jLabel138 = new javax.swing.JLabel();
        ActPriceGraham = new javax.swing.JTextField();
        jLabel140 = new javax.swing.JLabel();
        PillowGraham = new javax.swing.JTextField();
        jPanel74 = new javax.swing.JPanel();
        jPanel75 = new javax.swing.JPanel();
        jLabel156 = new javax.swing.JLabel();
        jPanel76 = new javax.swing.JPanel();
        jLabel157 = new javax.swing.JLabel();
        jPanel77 = new javax.swing.JPanel();
        jLabel158 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        EPSGraham = new javax.swing.JTextField();
        EPSGrahamRev = new javax.swing.JTextField();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        GRGraham = new javax.swing.JTextField();
        GRGrahamRev = new javax.swing.JTextField();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        YGraham = new javax.swing.JTextField();
        YGrahamRev = new javax.swing.JTextField();
        jLabel154 = new javax.swing.JLabel();
        EndGraham = new javax.swing.JTextField();
        EndGrahamRev = new javax.swing.JTextField();
        jLabel155 = new javax.swing.JLabel();
        EndGrahamMoS = new javax.swing.JTextField();
        EndGrahamRevMoS = new javax.swing.JTextField();
        SummaryOut = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        SumSticker = new javax.swing.JTextField();
        ActPriceAns = new javax.swing.JTextField();
        jPanel34 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        IdealPrice = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        IdealPriceMoS = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        Diff = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        PillowAns = new javax.swing.JTextField();
        jPanel35 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        DCFAns = new javax.swing.JTextField();
        jPanel37 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        DDMAns = new javax.swing.JTextField();
        jPanel38 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        GrahamAns = new javax.swing.JTextField();
        jPanel39 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        GrahamRevAns = new javax.swing.JTextField();
        jPanel40 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        NAVAns = new javax.swing.JTextField();
        jPanel41 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        DCFMoSAns = new javax.swing.JTextField();
        jPanel42 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        DDMMoSAns = new javax.swing.JTextField();
        jPanel43 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        GrahamMoSAns = new javax.swing.JTextField();
        jPanel44 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        GrahamRevMoSAns = new javax.swing.JTextField();
        jPanel45 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        NAVMoSAns = new javax.swing.JTextField();
        jPanel46 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        Help = new javax.swing.JPanel();
        jPanel80 = new javax.swing.JPanel();
        jLabel161 = new javax.swing.JLabel();
        DDMOut = new javax.swing.JPanel();
        jPanel59 = new javax.swing.JPanel();
        jLabel120 = new javax.swing.JLabel();
        jPanel60 = new javax.swing.JPanel();
        jLabel121 = new javax.swing.JLabel();
        ActPriceDDM = new javax.swing.JTextField();
        jLabel122 = new javax.swing.JLabel();
        PriceDDM = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        PillowDDM = new javax.swing.JTextField();
        jLabel124 = new javax.swing.JLabel();
        PriceDDMMoS = new javax.swing.JTextField();
        jPanel61 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        DividendsPrediction = new javax.swing.JTable();
        jPanel62 = new javax.swing.JPanel();
        jLabel125 = new javax.swing.JLabel();
        AvGRDDM = new javax.swing.JTextField();
        jLabel126 = new javax.swing.JLabel();
        WACCDDMOut = new javax.swing.JTextField();
        jPanel63 = new javax.swing.JPanel();
        jPanel64 = new javax.swing.JPanel();
        jPanel65 = new javax.swing.JPanel();
        jPanel66 = new javax.swing.JPanel();
        jPanel67 = new javax.swing.JPanel();
        jPanel68 = new javax.swing.JPanel();
        jPanel69 = new javax.swing.JPanel();
        jPanel70 = new javax.swing.JPanel();
        jPanel71 = new javax.swing.JPanel();
        GrahamIn = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        EPS = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        GRGrahamInn = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        Y = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        DCFOut = new javax.swing.JPanel();
        jPanel53 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        jLabel97 = new javax.swing.JLabel();
        ActPriceDCF = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        PriceDCF = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        PillowDCF = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        PriceDCFMoS = new javax.swing.JTextField();
        jPanel55 = new javax.swing.JPanel();
        jPanel56 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        LastFCF = new javax.swing.JTable();
        jPanel58 = new javax.swing.JPanel();
        jLabel116 = new javax.swing.JLabel();
        GRDCF = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        AvGRDCF = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        FutureFCF = new javax.swing.JTable();
        jPanel57 = new javax.swing.JPanel();
        jLabel109 = new javax.swing.JLabel();
        StateDCF = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        WACCDCFOut = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        CashDCF = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        SumFCFDCF = new javax.swing.JTextField();
        jLabel113 = new javax.swing.JLabel();
        DebtDCF = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        EVDCF = new javax.swing.JTextField();
        jLabel115 = new javax.swing.JLabel();
        SharesDCF = new javax.swing.JTextField();
        DDMIn = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Dividends = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        WACCDDM = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        Library = new javax.swing.JPanel();
        jPanel81 = new javax.swing.JPanel();
        jLabel162 = new javax.swing.JLabel();
        Settings = new javax.swing.JPanel();
        jPanel79 = new javax.swing.JPanel();
        jLabel160 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        LangChoice = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        RatioOut = new javax.swing.JPanel();
        jPanel51 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jPanel52 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        GM = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        OM = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        EPSRatio = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        PpE = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        CLiq = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        PpB = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        DpE = new javax.swing.JTextField();
        jLabel96 = new javax.swing.JLabel();
        PayOut = new javax.swing.JTextField();
        jLabel101 = new javax.swing.JLabel();
        ROA = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        ROE = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        ROS = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        RN = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        Indebtedness = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        ReceivablesTime = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        LiabilitiesTime = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        InventoryTime = new javax.swing.JTextField();
        DCFIn = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        FCF2 = new javax.swing.JTable();
        jPanel87 = new javax.swing.JPanel();
        jLabel134 = new javax.swing.JLabel();
        GR3 = new javax.swing.JTextField();
        jLabel135 = new javax.swing.JLabel();
        WACCDCFInn = new javax.swing.JTextField();
        jLabel136 = new javax.swing.JLabel();
        ActFCF2 = new javax.swing.JTextField();
        jLabel137 = new javax.swing.JLabel();
        Debt2 = new javax.swing.JTextField();
        jLabel141 = new javax.swing.JLabel();
        Shares2 = new javax.swing.JTextField();
        jLabel142 = new javax.swing.JLabel();
        CandC2 = new javax.swing.JTextField();
        jLabel164 = new javax.swing.JLabel();
        State2 = new javax.swing.JTextField();
        NAVOut = new javax.swing.JPanel();
        jPanel78 = new javax.swing.JPanel();
        jLabel159 = new javax.swing.JLabel();
        jPanel83 = new javax.swing.JPanel();
        jLabel118 = new javax.swing.JLabel();
        ActPriceNAV = new javax.swing.JTextField();
        jLabel119 = new javax.swing.JLabel();
        PriceNAV = new javax.swing.JTextField();
        jLabel128 = new javax.swing.JLabel();
        PillowNAV = new javax.swing.JTextField();
        jLabel129 = new javax.swing.JLabel();
        PriceNAVMoS = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TotalAssetsNAV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TotalLiabilitiesNAV = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        SharesNAV = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        InfoIn = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        CorpNameField = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        CorpStickerField = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        StockExchField = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        ActPrice = new javax.swing.JTextField();
        jLabel166 = new javax.swing.JLabel();
        Pillow2 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        NotesField = new javax.swing.JTextField();
        Save = new javax.swing.JPanel();
        jPanel82 = new javax.swing.JPanel();
        jLabel163 = new javax.swing.JLabel();
        NAVIn = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        TotalAssets = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        TotalLiab = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        SharesOut = new javax.swing.JTextField();
        jPanel30 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(null);
        setMinimumSize(new java.awt.Dimension(900, 600));

        Menu.setBackground(new java.awt.Color(0, 231, 255));
        Menu.setMaximumSize(new java.awt.Dimension(50, 600));
        Menu.setPreferredSize(new java.awt.Dimension(50, 600));

        MenuColumn.setBackground(new java.awt.Color(0, 255, 246));
        MenuColumn.setMaximumSize(new java.awt.Dimension(50, 400));
        MenuColumn.setPreferredSize(new java.awt.Dimension(50, 400));
        MenuColumn.setLayout(new java.awt.GridLayout(10, 1));

        InputBut.setBackground(new java.awt.Color(0, 255, 246));
        InputBut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        InputBut.setPreferredSize(new java.awt.Dimension(50, 50));
        InputBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InputButMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                InputButMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                InputButMouseExited(evt);
            }
        });

        innLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        innLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/inputs.png"))); // NOI18N
        innLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        innLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout InputButLayout = new javax.swing.GroupLayout(InputBut);
        InputBut.setLayout(InputButLayout);
        InputButLayout.setHorizontalGroup(
            InputButLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(innLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        InputButLayout.setVerticalGroup(
            InputButLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(innLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        MenuColumn.add(InputBut);

        CleanBut.setBackground(new java.awt.Color(0, 255, 246));
        CleanBut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CleanBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CleanButMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CleanButMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CleanButMouseExited(evt);
            }
        });

        cleanLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cleanLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/rubber.png"))); // NOI18N

        javax.swing.GroupLayout CleanButLayout = new javax.swing.GroupLayout(CleanBut);
        CleanBut.setLayout(CleanButLayout);
        CleanButLayout.setHorizontalGroup(
            CleanButLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cleanLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        CleanButLayout.setVerticalGroup(
            CleanButLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cleanLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        MenuColumn.add(CleanBut);

        ResultBut.setBackground(new java.awt.Color(0, 255, 246));
        ResultBut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ResultBut.setPreferredSize(new java.awt.Dimension(50, 50));
        ResultBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResultButMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ResultButMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ResultButMouseExited(evt);
            }
        });

        resultLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/result.png"))); // NOI18N
        resultLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout ResultButLayout = new javax.swing.GroupLayout(ResultBut);
        ResultBut.setLayout(ResultButLayout);
        ResultButLayout.setHorizontalGroup(
            ResultButLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resultLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        ResultButLayout.setVerticalGroup(
            ResultButLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resultLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        MenuColumn.add(ResultBut);

        SaveBut.setBackground(new java.awt.Color(0, 255, 246));
        SaveBut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SaveBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveButMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SaveButMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SaveButMouseExited(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/save.png"))); // NOI18N

        javax.swing.GroupLayout SaveButLayout = new javax.swing.GroupLayout(SaveBut);
        SaveBut.setLayout(SaveButLayout);
        SaveButLayout.setHorizontalGroup(
            SaveButLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        SaveButLayout.setVerticalGroup(
            SaveButLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        MenuColumn.add(SaveBut);

        LibraryBut.setBackground(new java.awt.Color(0, 255, 246));
        LibraryBut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LibraryBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LibraryButMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LibraryButMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LibraryButMouseExited(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/library.png"))); // NOI18N

        javax.swing.GroupLayout LibraryButLayout = new javax.swing.GroupLayout(LibraryBut);
        LibraryBut.setLayout(LibraryButLayout);
        LibraryButLayout.setHorizontalGroup(
            LibraryButLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        LibraryButLayout.setVerticalGroup(
            LibraryButLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        MenuColumn.add(LibraryBut);

        CalcBut.setBackground(new java.awt.Color(0, 255, 246));
        CalcBut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CalcBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CalcButMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CalcButMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CalcButMouseExited(evt);
            }
        });

        calcLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        calcLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/calc.png"))); // NOI18N

        javax.swing.GroupLayout CalcButLayout = new javax.swing.GroupLayout(CalcBut);
        CalcBut.setLayout(CalcButLayout);
        CalcButLayout.setHorizontalGroup(
            CalcButLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(calcLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        CalcButLayout.setVerticalGroup(
            CalcButLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(calcLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        MenuColumn.add(CalcBut);

        Space0.setBackground(new java.awt.Color(0, 255, 246));

        javax.swing.GroupLayout Space0Layout = new javax.swing.GroupLayout(Space0);
        Space0.setLayout(Space0Layout);
        Space0Layout.setHorizontalGroup(
            Space0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        Space0Layout.setVerticalGroup(
            Space0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        MenuColumn.add(Space0);

        Space1.setBackground(new java.awt.Color(0, 255, 246));

        javax.swing.GroupLayout Space1Layout = new javax.swing.GroupLayout(Space1);
        Space1.setLayout(Space1Layout);
        Space1Layout.setHorizontalGroup(
            Space1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        Space1Layout.setVerticalGroup(
            Space1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        MenuColumn.add(Space1);

        SettingBut.setBackground(new java.awt.Color(0, 255, 246));
        SettingBut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SettingBut.setPreferredSize(new java.awt.Dimension(50, 50));
        SettingBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SettingButMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SettingButMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SettingButMouseExited(evt);
            }
        });

        setttingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        setttingLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/settings.png"))); // NOI18N
        setttingLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout SettingButLayout = new javax.swing.GroupLayout(SettingBut);
        SettingBut.setLayout(SettingButLayout);
        SettingButLayout.setHorizontalGroup(
            SettingButLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(setttingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        SettingButLayout.setVerticalGroup(
            SettingButLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(setttingLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        MenuColumn.add(SettingBut);

        HelpBut.setBackground(new java.awt.Color(0, 255, 246));
        HelpBut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HelpBut.setPreferredSize(new java.awt.Dimension(50, 50));
        HelpBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HelpButMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HelpButMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HelpButMouseExited(evt);
            }
        });

        helpLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        helpLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/info.png"))); // NOI18N
        helpLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        helpLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout HelpButLayout = new javax.swing.GroupLayout(HelpBut);
        HelpBut.setLayout(HelpButLayout);
        HelpButLayout.setHorizontalGroup(
            HelpButLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(helpLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        HelpButLayout.setVerticalGroup(
            HelpButLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(helpLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        MenuColumn.add(HelpBut);

        HidingMenuInputs.setBackground(new java.awt.Color(0, 231, 255));
        HidingMenuInputs.setMaximumSize(new java.awt.Dimension(270, 400));
        HidingMenuInputs.setOpaque(false);
        HidingMenuInputs.setPreferredSize(new java.awt.Dimension(270, 400));
        HidingMenuInputs.setLayout(new java.awt.GridLayout(7, 1));

        LocalizatorIn.setBackground(new java.awt.Color(0, 20, 255));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Inputs for calculation");
        jLabel2.setMaximumSize(new java.awt.Dimension(50, 22));
        jLabel2.setMinimumSize(new java.awt.Dimension(50, 22));
        jLabel2.setPreferredSize(new java.awt.Dimension(50, 22));

        javax.swing.GroupLayout LocalizatorInLayout = new javax.swing.GroupLayout(LocalizatorIn);
        LocalizatorIn.setLayout(LocalizatorInLayout);
        LocalizatorInLayout.setHorizontalGroup(
            LocalizatorInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        LocalizatorInLayout.setVerticalGroup(
            LocalizatorInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        );

        HidingMenuInputs.add(LocalizatorIn);

        Info.setBackground(new java.awt.Color(0, 231, 255));
        Info.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InfoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                InfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                InfoMouseExited(evt);
            }
        });

        ViewInfo.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        ViewInfo.setForeground(new java.awt.Color(51, 51, 51));
        ViewInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ViewInfo.setText("Informations");

        javax.swing.GroupLayout InfoLayout = new javax.swing.GroupLayout(Info);
        Info.setLayout(InfoLayout);
        InfoLayout.setHorizontalGroup(
            InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ViewInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        InfoLayout.setVerticalGroup(
            InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ViewInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        );

        HidingMenuInputs.add(Info);

        InRatio.setBackground(new java.awt.Color(0, 231, 255));
        InRatio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        InRatio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InRatioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                InRatioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                InRatioMouseExited(evt);
            }
        });

        ViewRatioIn.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        ViewRatioIn.setForeground(new java.awt.Color(51, 51, 51));
        ViewRatioIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ViewRatioIn.setText("Ratios");

        javax.swing.GroupLayout InRatioLayout = new javax.swing.GroupLayout(InRatio);
        InRatio.setLayout(InRatioLayout);
        InRatioLayout.setHorizontalGroup(
            InRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ViewRatioIn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        InRatioLayout.setVerticalGroup(
            InRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ViewRatioIn, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        );

        HidingMenuInputs.add(InRatio);

        InDCF.setBackground(new java.awt.Color(0, 231, 255));
        InDCF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InDCFMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                InDCFMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                InDCFMouseExited(evt);
            }
        });

        ViewDCFIn.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        ViewDCFIn.setForeground(new java.awt.Color(51, 51, 51));
        ViewDCFIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ViewDCFIn.setText("DCF");
        ViewDCFIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout InDCFLayout = new javax.swing.GroupLayout(InDCF);
        InDCF.setLayout(InDCFLayout);
        InDCFLayout.setHorizontalGroup(
            InDCFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ViewDCFIn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        InDCFLayout.setVerticalGroup(
            InDCFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ViewDCFIn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        );

        HidingMenuInputs.add(InDCF);

        InDDM.setBackground(new java.awt.Color(0, 231, 255));
        InDDM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        InDDM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InDDMMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                InDDMMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                InDDMMouseExited(evt);
            }
        });

        ViewDDMIn.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        ViewDDMIn.setForeground(new java.awt.Color(51, 51, 51));
        ViewDDMIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ViewDDMIn.setText("DDM");

        javax.swing.GroupLayout InDDMLayout = new javax.swing.GroupLayout(InDDM);
        InDDM.setLayout(InDDMLayout);
        InDDMLayout.setHorizontalGroup(
            InDDMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ViewDDMIn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        InDDMLayout.setVerticalGroup(
            InDDMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ViewDDMIn, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        );

        HidingMenuInputs.add(InDDM);

        InGraham.setBackground(new java.awt.Color(0, 231, 255));
        InGraham.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        InGraham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InGrahamMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                InGrahamMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                InGrahamMouseExited(evt);
            }
        });

        ViewGrahamIn.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        ViewGrahamIn.setForeground(new java.awt.Color(51, 51, 51));
        ViewGrahamIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ViewGrahamIn.setText("Grahams Fromula");

        javax.swing.GroupLayout InGrahamLayout = new javax.swing.GroupLayout(InGraham);
        InGraham.setLayout(InGrahamLayout);
        InGrahamLayout.setHorizontalGroup(
            InGrahamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ViewGrahamIn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        InGrahamLayout.setVerticalGroup(
            InGrahamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ViewGrahamIn, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        );

        HidingMenuInputs.add(InGraham);

        InNAV.setBackground(new java.awt.Color(0, 231, 255));
        InNAV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        InNAV.setPreferredSize(new java.awt.Dimension(270, 30));
        InNAV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InNAVMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                InNAVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                InNAVMouseExited(evt);
            }
        });

        ViewNAVIn.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        ViewNAVIn.setForeground(new java.awt.Color(51, 51, 51));
        ViewNAVIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ViewNAVIn.setText("NAV");

        javax.swing.GroupLayout InNAVLayout = new javax.swing.GroupLayout(InNAV);
        InNAV.setLayout(InNAVLayout);
        InNAVLayout.setHorizontalGroup(
            InNAVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ViewNAVIn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        InNAVLayout.setVerticalGroup(
            InNAVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ViewNAVIn, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        );

        HidingMenuInputs.add(InNAV);

        HidingMenuOutputs.setMaximumSize(new java.awt.Dimension(270, 400));
        HidingMenuOutputs.setOpaque(false);
        HidingMenuOutputs.setPreferredSize(new java.awt.Dimension(270, 400));
        HidingMenuOutputs.setLayout(new java.awt.GridLayout(7, 1));

        LocalizatorOut.setBackground(new java.awt.Color(0, 20, 255));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Outputs of valuation");
        jLabel3.setMaximumSize(new java.awt.Dimension(50, 22));
        jLabel3.setMinimumSize(new java.awt.Dimension(50, 22));
        jLabel3.setPreferredSize(new java.awt.Dimension(50, 22));

        javax.swing.GroupLayout LocalizatorOutLayout = new javax.swing.GroupLayout(LocalizatorOut);
        LocalizatorOut.setLayout(LocalizatorOutLayout);
        LocalizatorOutLayout.setHorizontalGroup(
            LocalizatorOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        LocalizatorOutLayout.setVerticalGroup(
            LocalizatorOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        );

        HidingMenuOutputs.add(LocalizatorOut);

        OutSummary.setBackground(new java.awt.Color(0, 231, 255));
        OutSummary.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OutSummary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OutSummaryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OutSummaryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OutSummaryMouseExited(evt);
            }
        });

        viewValSum.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        viewValSum.setForeground(new java.awt.Color(51, 51, 51));
        viewValSum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewValSum.setText("Valuation Summary");
        viewValSum.setMaximumSize(new java.awt.Dimension(50, 22));
        viewValSum.setMinimumSize(new java.awt.Dimension(50, 22));
        viewValSum.setPreferredSize(new java.awt.Dimension(50, 22));

        javax.swing.GroupLayout OutSummaryLayout = new javax.swing.GroupLayout(OutSummary);
        OutSummary.setLayout(OutSummaryLayout);
        OutSummaryLayout.setHorizontalGroup(
            OutSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewValSum, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        OutSummaryLayout.setVerticalGroup(
            OutSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewValSum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        );

        HidingMenuOutputs.add(OutSummary);

        OutRatio.setBackground(new java.awt.Color(0, 231, 255));
        OutRatio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OutRatio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OutRatioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OutRatioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OutRatioMouseExited(evt);
            }
        });

        viewCalcRatio.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        viewCalcRatio.setForeground(new java.awt.Color(51, 51, 51));
        viewCalcRatio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewCalcRatio.setText("Calculated Ratios");

        javax.swing.GroupLayout OutRatioLayout = new javax.swing.GroupLayout(OutRatio);
        OutRatio.setLayout(OutRatioLayout);
        OutRatioLayout.setHorizontalGroup(
            OutRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewCalcRatio, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        OutRatioLayout.setVerticalGroup(
            OutRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewCalcRatio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        );

        HidingMenuOutputs.add(OutRatio);

        OutDCF.setBackground(new java.awt.Color(0, 231, 255));
        OutDCF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OutDCF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OutDCFMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OutDCFMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OutDCFMouseExited(evt);
            }
        });

        viewDCFVal.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        viewDCFVal.setForeground(new java.awt.Color(51, 51, 51));
        viewDCFVal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewDCFVal.setText("DCF Valuation");
        viewDCFVal.setMaximumSize(new java.awt.Dimension(50, 28));
        viewDCFVal.setMinimumSize(new java.awt.Dimension(50, 28));
        viewDCFVal.setPreferredSize(new java.awt.Dimension(50, 28));

        javax.swing.GroupLayout OutDCFLayout = new javax.swing.GroupLayout(OutDCF);
        OutDCF.setLayout(OutDCFLayout);
        OutDCFLayout.setHorizontalGroup(
            OutDCFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewDCFVal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        OutDCFLayout.setVerticalGroup(
            OutDCFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewDCFVal, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        );

        HidingMenuOutputs.add(OutDCF);

        OutDDM.setBackground(new java.awt.Color(0, 231, 255));
        OutDDM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OutDDM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OutDDMMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OutDDMMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OutDDMMouseExited(evt);
            }
        });

        viewDDMVal.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        viewDDMVal.setForeground(new java.awt.Color(51, 51, 51));
        viewDDMVal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewDDMVal.setText("DDM Valuation");

        javax.swing.GroupLayout OutDDMLayout = new javax.swing.GroupLayout(OutDDM);
        OutDDM.setLayout(OutDDMLayout);
        OutDDMLayout.setHorizontalGroup(
            OutDDMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewDDMVal, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        OutDDMLayout.setVerticalGroup(
            OutDDMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewDDMVal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        );

        HidingMenuOutputs.add(OutDDM);

        OutGraham.setBackground(new java.awt.Color(0, 231, 255));
        OutGraham.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OutGraham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OutGrahamMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OutGrahamMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OutGrahamMouseExited(evt);
            }
        });

        viewGrahamVal.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        viewGrahamVal.setForeground(new java.awt.Color(51, 51, 51));
        viewGrahamVal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewGrahamVal.setText("Grahams Valuation");

        javax.swing.GroupLayout OutGrahamLayout = new javax.swing.GroupLayout(OutGraham);
        OutGraham.setLayout(OutGrahamLayout);
        OutGrahamLayout.setHorizontalGroup(
            OutGrahamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewGrahamVal, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        OutGrahamLayout.setVerticalGroup(
            OutGrahamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewGrahamVal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        );

        HidingMenuOutputs.add(OutGraham);

        OutNAV.setBackground(new java.awt.Color(0, 231, 255));
        OutNAV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OutNAV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OutNAVMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OutNAVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OutNAVMouseExited(evt);
            }
        });

        viewNAVVal.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        viewNAVVal.setForeground(new java.awt.Color(51, 51, 51));
        viewNAVVal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewNAVVal.setText("NAV Valuation");

        javax.swing.GroupLayout OutNAVLayout = new javax.swing.GroupLayout(OutNAV);
        OutNAV.setLayout(OutNAVLayout);
        OutNAVLayout.setHorizontalGroup(
            OutNAVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewNAVVal, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        OutNAVLayout.setVerticalGroup(
            OutNAVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewNAVVal, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        );

        HidingMenuOutputs.add(OutNAV);

        HidingMenuCleaning.setLayout(new java.awt.GridLayout(9, 1));

        LocalizatorCleaning.setBackground(new java.awt.Color(0, 20, 255));

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Cleaning choices");

        javax.swing.GroupLayout LocalizatorCleaningLayout = new javax.swing.GroupLayout(LocalizatorCleaning);
        LocalizatorCleaning.setLayout(LocalizatorCleaningLayout);
        LocalizatorCleaningLayout.setHorizontalGroup(
            LocalizatorCleaningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        LocalizatorCleaningLayout.setVerticalGroup(
            LocalizatorCleaningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        HidingMenuCleaning.add(LocalizatorCleaning);

        CleanAll.setBackground(new java.awt.Color(0, 231, 255));
        CleanAll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CleanAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CleanAllMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CleanAllMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CleanAllMouseExited(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("All");

        javax.swing.GroupLayout CleanAllLayout = new javax.swing.GroupLayout(CleanAll);
        CleanAll.setLayout(CleanAllLayout);
        CleanAllLayout.setHorizontalGroup(
            CleanAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        CleanAllLayout.setVerticalGroup(
            CleanAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        HidingMenuCleaning.add(CleanAll);

        CleanInfo.setBackground(new java.awt.Color(0, 231, 255));
        CleanInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CleanInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CleanInfoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CleanInfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CleanInfoMouseExited(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Informations");

        javax.swing.GroupLayout CleanInfoLayout = new javax.swing.GroupLayout(CleanInfo);
        CleanInfo.setLayout(CleanInfoLayout);
        CleanInfoLayout.setHorizontalGroup(
            CleanInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        CleanInfoLayout.setVerticalGroup(
            CleanInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        HidingMenuCleaning.add(CleanInfo);

        CleanRatio.setBackground(new java.awt.Color(0, 231, 255));
        CleanRatio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CleanRatio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CleanRatioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CleanRatioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CleanRatioMouseExited(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Ratios");

        javax.swing.GroupLayout CleanRatioLayout = new javax.swing.GroupLayout(CleanRatio);
        CleanRatio.setLayout(CleanRatioLayout);
        CleanRatioLayout.setHorizontalGroup(
            CleanRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        CleanRatioLayout.setVerticalGroup(
            CleanRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        HidingMenuCleaning.add(CleanRatio);

        CleanDCF.setBackground(new java.awt.Color(0, 231, 255));
        CleanDCF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CleanDCF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CleanDCFMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CleanDCFMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CleanDCFMouseExited(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("DCF");

        javax.swing.GroupLayout CleanDCFLayout = new javax.swing.GroupLayout(CleanDCF);
        CleanDCF.setLayout(CleanDCFLayout);
        CleanDCFLayout.setHorizontalGroup(
            CleanDCFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        CleanDCFLayout.setVerticalGroup(
            CleanDCFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        HidingMenuCleaning.add(CleanDCF);

        CleanDDM.setBackground(new java.awt.Color(0, 231, 255));
        CleanDDM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CleanDDM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CleanDDMMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CleanDDMMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CleanDDMMouseExited(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("DDM");

        javax.swing.GroupLayout CleanDDMLayout = new javax.swing.GroupLayout(CleanDDM);
        CleanDDM.setLayout(CleanDDMLayout);
        CleanDDMLayout.setHorizontalGroup(
            CleanDDMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        CleanDDMLayout.setVerticalGroup(
            CleanDDMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        HidingMenuCleaning.add(CleanDDM);

        CleanGraham.setBackground(new java.awt.Color(0, 231, 255));
        CleanGraham.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CleanGraham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CleanGrahamMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CleanGrahamMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CleanGrahamMouseExited(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Grahams Formulas");

        javax.swing.GroupLayout CleanGrahamLayout = new javax.swing.GroupLayout(CleanGraham);
        CleanGraham.setLayout(CleanGrahamLayout);
        CleanGrahamLayout.setHorizontalGroup(
            CleanGrahamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        CleanGrahamLayout.setVerticalGroup(
            CleanGrahamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        HidingMenuCleaning.add(CleanGraham);

        CleanNAV.setBackground(new java.awt.Color(0, 231, 255));
        CleanNAV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CleanNAV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CleanNAVMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CleanNAVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CleanNAVMouseExited(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 51, 51));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("NAV");

        javax.swing.GroupLayout CleanNAVLayout = new javax.swing.GroupLayout(CleanNAV);
        CleanNAV.setLayout(CleanNAVLayout);
        CleanNAVLayout.setHorizontalGroup(
            CleanNAVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        CleanNAVLayout.setVerticalGroup(
            CleanNAVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        HidingMenuCleaning.add(CleanNAV);

        Clean.setBackground(new java.awt.Color(0, 20, 255));
        Clean.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Clean.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CleanMouseClicked(evt);
            }
        });

        CleaningBut.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        CleaningBut.setForeground(new java.awt.Color(255, 255, 255));
        CleaningBut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CleaningBut.setText("CLEAN");

        javax.swing.GroupLayout CleanLayout = new javax.swing.GroupLayout(Clean);
        Clean.setLayout(CleanLayout);
        CleanLayout.setHorizontalGroup(
            CleanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CleaningBut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        CleanLayout.setVerticalGroup(
            CleanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CleaningBut, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        HidingMenuCleaning.add(Clean);

        HidingMenuCalculation.setLayout(new java.awt.GridLayout(7, 1));

        LocalizatorCalculating.setBackground(new java.awt.Color(0, 20, 255));

        jLabel20.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Calculation choices");

        javax.swing.GroupLayout LocalizatorCalculatingLayout = new javax.swing.GroupLayout(LocalizatorCalculating);
        LocalizatorCalculating.setLayout(LocalizatorCalculatingLayout);
        LocalizatorCalculatingLayout.setHorizontalGroup(
            LocalizatorCalculatingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
        );
        LocalizatorCalculatingLayout.setVerticalGroup(
            LocalizatorCalculatingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        HidingMenuCalculation.add(LocalizatorCalculating);

        CalcRatio.setBackground(new java.awt.Color(0, 231, 255));
        CalcRatio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CalcRatio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CalcRatioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CalcRatioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CalcRatioMouseExited(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Ratios");

        javax.swing.GroupLayout CalcRatioLayout = new javax.swing.GroupLayout(CalcRatio);
        CalcRatio.setLayout(CalcRatioLayout);
        CalcRatioLayout.setHorizontalGroup(
            CalcRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
        );
        CalcRatioLayout.setVerticalGroup(
            CalcRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        HidingMenuCalculation.add(CalcRatio);

        CalcDCF.setBackground(new java.awt.Color(0, 231, 255));
        CalcDCF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CalcDCF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CalcDCFMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CalcDCFMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CalcDCFMouseExited(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("DCF");

        javax.swing.GroupLayout CalcDCFLayout = new javax.swing.GroupLayout(CalcDCF);
        CalcDCF.setLayout(CalcDCFLayout);
        CalcDCFLayout.setHorizontalGroup(
            CalcDCFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
        );
        CalcDCFLayout.setVerticalGroup(
            CalcDCFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        HidingMenuCalculation.add(CalcDCF);

        CalcDDM.setBackground(new java.awt.Color(0, 231, 255));
        CalcDDM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CalcDDM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CalcDDMMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CalcDDMMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CalcDDMMouseExited(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("DDM");

        javax.swing.GroupLayout CalcDDMLayout = new javax.swing.GroupLayout(CalcDDM);
        CalcDDM.setLayout(CalcDDMLayout);
        CalcDDMLayout.setHorizontalGroup(
            CalcDDMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
        );
        CalcDDMLayout.setVerticalGroup(
            CalcDDMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        HidingMenuCalculation.add(CalcDDM);

        CalcGraham.setBackground(new java.awt.Color(0, 231, 255));
        CalcGraham.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CalcGraham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CalcGrahamMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CalcGrahamMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CalcGrahamMouseExited(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Grahams Formulas");

        javax.swing.GroupLayout CalcGrahamLayout = new javax.swing.GroupLayout(CalcGraham);
        CalcGraham.setLayout(CalcGrahamLayout);
        CalcGrahamLayout.setHorizontalGroup(
            CalcGrahamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
        );
        CalcGrahamLayout.setVerticalGroup(
            CalcGrahamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        HidingMenuCalculation.add(CalcGraham);

        CalcNAV.setBackground(new java.awt.Color(0, 231, 255));
        CalcNAV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CalcNAV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CalcNAVMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CalcNAVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CalcNAVMouseExited(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(51, 51, 51));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("NAV");

        javax.swing.GroupLayout CalcNAVLayout = new javax.swing.GroupLayout(CalcNAV);
        CalcNAV.setLayout(CalcNAVLayout);
        CalcNAVLayout.setHorizontalGroup(
            CalcNAVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
        );
        CalcNAVLayout.setVerticalGroup(
            CalcNAVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        HidingMenuCalculation.add(CalcNAV);

        Calc.setBackground(new java.awt.Color(0, 20, 255));
        Calc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Calc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CalcMouseClicked(evt);
            }
        });

        CleaningBut1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        CleaningBut1.setForeground(new java.awt.Color(255, 255, 255));
        CleaningBut1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CleaningBut1.setText("CALCULATE");

        javax.swing.GroupLayout CalcLayout = new javax.swing.GroupLayout(Calc);
        Calc.setLayout(CalcLayout);
        CalcLayout.setHorizontalGroup(
            CalcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CleaningBut1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
        );
        CalcLayout.setVerticalGroup(
            CalcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CleaningBut1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        HidingMenuCalculation.add(Calc);

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addComponent(MenuColumn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(HidingMenuOutputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HidingMenuInputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HidingMenuCleaning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(HidingMenuCalculation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HidingMenuOutputs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MenuColumn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(HidingMenuInputs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(HidingMenuCleaning, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(MenuLayout.createSequentialGroup()
                .addComponent(HidingMenuCalculation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(Menu, java.awt.BorderLayout.LINE_START);

        WelcomePanel.setMaximumSize(new java.awt.Dimension(620, 600));
        WelcomePanel.setPreferredSize(new java.awt.Dimension(850, 600));
        WelcomePanel.setLayout(new javax.swing.OverlayLayout(WelcomePanel));

        RatioIn.setBackground(new java.awt.Color(255, 255, 255));
        RatioIn.setForeground(new java.awt.Color(204, 204, 204));
        RatioIn.setLayout(new java.awt.BorderLayout());

        jPanel92.setBackground(new java.awt.Color(0, 153, 255));
        jPanel92.setLayout(new java.awt.GridLayout(1, 2));

        jLabel191.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel191.setForeground(new java.awt.Color(51, 51, 51));
        jLabel191.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel191.setText("Income Statement");
        jPanel92.add(jLabel191);

        jLabel192.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel192.setForeground(new java.awt.Color(51, 51, 51));
        jLabel192.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel192.setText("Balance Sheet");
        jPanel92.add(jLabel192);

        RatioIn.add(jPanel92, java.awt.BorderLayout.PAGE_START);

        jPanel93.setBackground(new java.awt.Color(255, 255, 255));
        jPanel93.setLayout(new java.awt.GridLayout(1, 2));

        jPanel94.setBackground(new java.awt.Color(255, 255, 255));
        jPanel94.setForeground(new java.awt.Color(51, 51, 51));
        jPanel94.setLayout(new java.awt.GridLayout(12, 2));

        jLabel194.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel194.setForeground(new java.awt.Color(51, 51, 51));
        jLabel194.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel194.setText("Total Revenue");
        jPanel94.add(jLabel194);

        TRevenue2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        TRevenue2.setForeground(new java.awt.Color(204, 204, 204));
        TRevenue2.setBorder(null);
        TRevenue2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TRevenue2KeyTyped(evt);
            }
        });
        jPanel94.add(TRevenue2);

        jLabel195.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel195.setForeground(new java.awt.Color(51, 51, 51));
        jLabel195.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel195.setText("Cost of Revenue");
        jPanel94.add(jLabel195);

        CofRevenue2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        CofRevenue2.setForeground(new java.awt.Color(204, 204, 204));
        CofRevenue2.setBorder(null);
        CofRevenue2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CofRevenue2KeyTyped(evt);
            }
        });
        jPanel94.add(CofRevenue2);

        jLabel196.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel196.setForeground(new java.awt.Color(51, 51, 51));
        jLabel196.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel196.setText("Operating expense ");
        jPanel94.add(jLabel196);

        OpExpense2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        OpExpense2.setForeground(new java.awt.Color(204, 204, 204));
        OpExpense2.setBorder(null);
        OpExpense2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                OpExpense2KeyTyped(evt);
            }
        });
        jPanel94.add(OpExpense2);

        jLabel197.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel197.setForeground(new java.awt.Color(51, 51, 51));
        jLabel197.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel197.setText("Other Income Expense");
        jPanel94.add(jLabel197);

        OthIncome2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        OthIncome2.setForeground(new java.awt.Color(204, 204, 204));
        OthIncome2.setBorder(null);
        OthIncome2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                OthIncome2KeyTyped(evt);
            }
        });
        jPanel94.add(OthIncome2);

        jLabel198.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel198.setForeground(new java.awt.Color(51, 51, 51));
        jLabel198.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel198.setText("Net Income");
        jPanel94.add(jLabel198);

        NIncome2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        NIncome2.setForeground(new java.awt.Color(204, 204, 204));
        NIncome2.setBorder(null);
        NIncome2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NIncome2KeyTyped(evt);
            }
        });
        jPanel94.add(NIncome2);

        jLabel199.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel199.setForeground(new java.awt.Color(51, 51, 51));
        jLabel199.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel199.setText("EBIT");
        jPanel94.add(jLabel199);

        EBIT2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        EBIT2.setForeground(new java.awt.Color(204, 204, 204));
        EBIT2.setBorder(null);
        EBIT2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EBIT2KeyTyped(evt);
            }
        });
        jPanel94.add(EBIT2);

        jPanel95.setBackground(new java.awt.Color(0, 153, 255));

        jLabel200.setBackground(new java.awt.Color(0, 153, 255));
        jLabel200.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel200.setForeground(new java.awt.Color(51, 51, 51));
        jLabel200.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel200.setText("Cash Flow");

        javax.swing.GroupLayout jPanel95Layout = new javax.swing.GroupLayout(jPanel95);
        jPanel95.setLayout(jPanel95Layout);
        jPanel95Layout.setHorizontalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel200, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
        );
        jPanel95Layout.setVerticalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel200, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel94.add(jPanel95);

        jPanel96.setBackground(new java.awt.Color(0, 153, 255));

        jLabel201.setBackground(new java.awt.Color(0, 153, 255));
        jLabel201.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel201.setForeground(new java.awt.Color(51, 51, 51));
        jLabel201.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel201.setText("Statement");

        javax.swing.GroupLayout jPanel96Layout = new javax.swing.GroupLayout(jPanel96);
        jPanel96.setLayout(jPanel96Layout);
        jPanel96Layout.setHorizontalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel201, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
        );
        jPanel96Layout.setVerticalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel201, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel94.add(jPanel96);

        jLabel202.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel202.setForeground(new java.awt.Color(51, 51, 51));
        jLabel202.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel202.setText("Common Stock Dividend Paid");
        jPanel94.add(jLabel202);

        ComDiv2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        ComDiv2.setForeground(new java.awt.Color(204, 204, 204));
        ComDiv2.setBorder(null);
        ComDiv2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ComDiv2KeyTyped(evt);
            }
        });
        jPanel94.add(ComDiv2);

        jPanel97.setBackground(new java.awt.Color(0, 153, 255));

        jLabel203.setBackground(new java.awt.Color(0, 153, 255));
        jLabel203.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel203.setForeground(new java.awt.Color(51, 51, 51));
        jLabel203.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel203.setText("EBIT");

        javax.swing.GroupLayout jPanel97Layout = new javax.swing.GroupLayout(jPanel97);
        jPanel97.setLayout(jPanel97Layout);
        jPanel97Layout.setHorizontalGroup(
            jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel203, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
        );
        jPanel97Layout.setVerticalGroup(
            jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel203, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel94.add(jPanel97);

        jPanel98.setBackground(new java.awt.Color(0, 153, 255));

        jLabel204.setBackground(new java.awt.Color(0, 153, 255));
        jLabel204.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel204.setForeground(new java.awt.Color(51, 51, 51));
        jLabel204.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel204.setText("Calculation");

        javax.swing.GroupLayout jPanel98Layout = new javax.swing.GroupLayout(jPanel98);
        jPanel98.setLayout(jPanel98Layout);
        jPanel98Layout.setHorizontalGroup(
            jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel204, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
        );
        jPanel98Layout.setVerticalGroup(
            jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel204, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel94.add(jPanel98);

        jLabel205.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel205.setForeground(new java.awt.Color(51, 51, 51));
        jLabel205.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel205.setText("Taxes");
        jPanel94.add(jLabel205);

        Taxes2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        Taxes2.setForeground(new java.awt.Color(204, 204, 204));
        Taxes2.setBorder(null);
        Taxes2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Taxes2KeyTyped(evt);
            }
        });
        jPanel94.add(Taxes2);

        jLabel206.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel206.setForeground(new java.awt.Color(51, 51, 51));
        jLabel206.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel206.setText("Interest Expense");
        jPanel94.add(jLabel206);

        IntExp2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        IntExp2.setForeground(new java.awt.Color(204, 204, 204));
        IntExp2.setBorder(null);
        IntExp2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                IntExp2KeyTyped(evt);
            }
        });
        jPanel94.add(IntExp2);

        jPanel93.add(jPanel94);

        jPanel99.setBackground(new java.awt.Color(255, 255, 255));
        jPanel99.setLayout(new java.awt.GridLayout(11, 2));

        jLabel207.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel207.setForeground(new java.awt.Color(51, 51, 51));
        jLabel207.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel207.setText("Total Assets");
        jPanel99.add(jLabel207);

        TAssets2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        TAssets2.setForeground(new java.awt.Color(204, 204, 204));
        TAssets2.setBorder(null);
        TAssets2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TAssets2KeyTyped(evt);
            }
        });
        jPanel99.add(TAssets2);

        jLabel208.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel208.setForeground(new java.awt.Color(51, 51, 51));
        jLabel208.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel208.setText("Current Assets");
        jPanel99.add(jLabel208);

        CurAssets2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        CurAssets2.setForeground(new java.awt.Color(204, 204, 204));
        CurAssets2.setBorder(null);
        CurAssets2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CurAssets2KeyTyped(evt);
            }
        });
        jPanel99.add(CurAssets2);

        jLabel209.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel209.setForeground(new java.awt.Color(51, 51, 51));
        jLabel209.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel209.setText("Receivable");
        jPanel99.add(jLabel209);

        Receivable2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        Receivable2.setForeground(new java.awt.Color(204, 204, 204));
        Receivable2.setBorder(null);
        Receivable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Receivable2KeyTyped(evt);
            }
        });
        jPanel99.add(Receivable2);

        jLabel210.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel210.setForeground(new java.awt.Color(51, 51, 51));
        jLabel210.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel210.setText("Inventory");
        jPanel99.add(jLabel210);

        Inv2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        Inv2.setForeground(new java.awt.Color(204, 204, 204));
        Inv2.setBorder(null);
        Inv2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Inv2KeyTyped(evt);
            }
        });
        jPanel99.add(Inv2);

        jLabel211.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel211.setForeground(new java.awt.Color(51, 51, 51));
        jLabel211.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel211.setText("Total Liabilities Net Minority Interest");
        jPanel99.add(jLabel211);

        TLiabilities2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        TLiabilities2.setForeground(new java.awt.Color(204, 204, 204));
        TLiabilities2.setBorder(null);
        TLiabilities2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TLiabilities2KeyTyped(evt);
            }
        });
        jPanel99.add(TLiabilities2);

        jLabel212.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel212.setForeground(new java.awt.Color(51, 51, 51));
        jLabel212.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel212.setText("Current Liabilities");
        jPanel99.add(jLabel212);

        CurLiabilities2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        CurLiabilities2.setForeground(new java.awt.Color(204, 204, 204));
        CurLiabilities2.setBorder(null);
        CurLiabilities2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CurLiabilities2KeyTyped(evt);
            }
        });
        jPanel99.add(CurLiabilities2);

        jLabel213.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel213.setForeground(new java.awt.Color(51, 51, 51));
        jLabel213.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel213.setText("Total Equity Gross Minority Interest");
        jPanel99.add(jLabel213);

        TEGMI2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        TEGMI2.setForeground(new java.awt.Color(204, 204, 204));
        TEGMI2.setBorder(null);
        TEGMI2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TEGMI2KeyTyped(evt);
            }
        });
        jPanel99.add(TEGMI2);

        jLabel214.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel214.setForeground(new java.awt.Color(51, 51, 51));
        jLabel214.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel214.setText("Shareholders Equity");
        jPanel99.add(jLabel214);

        SHEquity2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        SHEquity2.setForeground(new java.awt.Color(204, 204, 204));
        SHEquity2.setBorder(null);
        SHEquity2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SHEquity2KeyTyped(evt);
            }
        });
        jPanel99.add(SHEquity2);

        jLabel215.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel215.setForeground(new java.awt.Color(51, 51, 51));
        jLabel215.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel215.setText("Capital Lease Obligations");
        jPanel99.add(jLabel215);

        CapLO2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        CapLO2.setForeground(new java.awt.Color(204, 204, 204));
        CapLO2.setBorder(null);
        CapLO2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CapLO2KeyTyped(evt);
            }
        });
        jPanel99.add(CapLO2);

        jLabel216.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel216.setForeground(new java.awt.Color(51, 51, 51));
        jLabel216.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel216.setText("Tangible Book Value");
        jPanel99.add(jLabel216);

        TanBookVal2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        TanBookVal2.setForeground(new java.awt.Color(204, 204, 204));
        TanBookVal2.setBorder(null);
        TanBookVal2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TanBookVal2KeyTyped(evt);
            }
        });
        jPanel99.add(TanBookVal2);

        jLabel217.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel217.setForeground(new java.awt.Color(51, 51, 51));
        jLabel217.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel217.setText("Ordinary Shares Number");
        jPanel99.add(jLabel217);

        OrShNum2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        OrShNum2.setForeground(new java.awt.Color(204, 204, 204));
        OrShNum2.setBorder(null);
        OrShNum2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                OrShNum2KeyTyped(evt);
            }
        });
        jPanel99.add(OrShNum2);

        jPanel93.add(jPanel99);

        RatioIn.add(jPanel93, java.awt.BorderLayout.CENTER);

        WelcomePanel.add(RatioIn);

        GrahamOut.setForeground(new java.awt.Color(204, 204, 204));
        GrahamOut.setLayout(new java.awt.BorderLayout());

        jPanel72.setBackground(new java.awt.Color(0, 153, 255));

        jLabel127.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(51, 51, 51));
        jLabel127.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel127.setText("Calculated Grahams Formulas");

        javax.swing.GroupLayout jPanel72Layout = new javax.swing.GroupLayout(jPanel72);
        jPanel72.setLayout(jPanel72Layout);
        jPanel72Layout.setHorizontalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel127, javax.swing.GroupLayout.DEFAULT_SIZE, 2183, Short.MAX_VALUE)
        );
        jPanel72Layout.setVerticalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel127, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        GrahamOut.add(jPanel72, java.awt.BorderLayout.PAGE_START);

        jPanel73.setBackground(new java.awt.Color(102, 255, 255));
        jPanel73.setLayout(new java.awt.GridLayout(2, 4));

        jLabel138.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel138.setForeground(new java.awt.Color(51, 51, 51));
        jLabel138.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel138.setText("Actual stock price:");
        jPanel73.add(jLabel138);

        ActPriceGraham.setEditable(false);
        ActPriceGraham.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        ActPriceGraham.setForeground(new java.awt.Color(204, 204, 204));
        jPanel73.add(ActPriceGraham);

        jLabel140.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel140.setForeground(new java.awt.Color(51, 51, 51));
        jLabel140.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel140.setText("Margin of Safety:");
        jPanel73.add(jLabel140);

        PillowGraham.setEditable(false);
        PillowGraham.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        PillowGraham.setForeground(new java.awt.Color(204, 204, 204));
        jPanel73.add(PillowGraham);

        GrahamOut.add(jPanel73, java.awt.BorderLayout.PAGE_END);

        jPanel74.setBackground(new java.awt.Color(255, 255, 255));
        jPanel74.setLayout(new java.awt.GridLayout(9, 3));

        jPanel75.setBackground(new java.awt.Color(102, 255, 255));

        jLabel156.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel156.setForeground(new java.awt.Color(51, 51, 51));
        jLabel156.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel156.setText("Partition");

        javax.swing.GroupLayout jPanel75Layout = new javax.swing.GroupLayout(jPanel75);
        jPanel75.setLayout(jPanel75Layout);
        jPanel75Layout.setHorizontalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel156, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
        );
        jPanel75Layout.setVerticalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel156, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );

        jPanel74.add(jPanel75);

        jPanel76.setBackground(new java.awt.Color(102, 255, 255));

        jLabel157.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel157.setForeground(new java.awt.Color(51, 51, 51));
        jLabel157.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel157.setText("Grahams Formula");

        javax.swing.GroupLayout jPanel76Layout = new javax.swing.GroupLayout(jPanel76);
        jPanel76.setLayout(jPanel76Layout);
        jPanel76Layout.setHorizontalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel157, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
        );
        jPanel76Layout.setVerticalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel157, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );

        jPanel74.add(jPanel76);

        jPanel77.setBackground(new java.awt.Color(102, 255, 255));

        jLabel158.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel158.setForeground(new java.awt.Color(51, 51, 51));
        jLabel158.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel158.setText("Grahams Reversed Formula");

        javax.swing.GroupLayout jPanel77Layout = new javax.swing.GroupLayout(jPanel77);
        jPanel77.setLayout(jPanel77Layout);
        jPanel77Layout.setHorizontalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel158, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
        );
        jPanel77Layout.setVerticalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel158, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );

        jPanel74.add(jPanel77);

        jLabel139.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel139.setForeground(new java.awt.Color(51, 51, 51));
        jLabel139.setText("EPS");
        jPanel74.add(jLabel139);

        EPSGraham.setEditable(false);
        EPSGraham.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        EPSGraham.setForeground(new java.awt.Color(204, 204, 204));
        jPanel74.add(EPSGraham);

        EPSGrahamRev.setEditable(false);
        EPSGrahamRev.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        EPSGrahamRev.setForeground(new java.awt.Color(204, 204, 204));
        jPanel74.add(EPSGrahamRev);

        jLabel143.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel143.setForeground(new java.awt.Color(51, 51, 51));
        jLabel143.setText("P/E ratio");
        jPanel74.add(jLabel143);

        jLabel144.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel144.setForeground(new java.awt.Color(51, 51, 51));
        jLabel144.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel144.setText("8.50");
        jPanel74.add(jLabel144);

        jLabel145.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel145.setForeground(new java.awt.Color(51, 51, 51));
        jLabel145.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel145.setText("7.00");
        jPanel74.add(jLabel145);

        jLabel146.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel146.setForeground(new java.awt.Color(51, 51, 51));
        jLabel146.setText("Growth rate (next 5 years)");
        jPanel74.add(jLabel146);

        GRGraham.setEditable(false);
        GRGraham.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        GRGraham.setForeground(new java.awt.Color(204, 204, 204));
        jPanel74.add(GRGraham);

        GRGrahamRev.setEditable(false);
        GRGrahamRev.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        GRGrahamRev.setForeground(new java.awt.Color(204, 204, 204));
        jPanel74.add(GRGrahamRev);

        jLabel147.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel147.setForeground(new java.awt.Color(51, 51, 51));
        jLabel147.setText("Multiplier for Growth rate");
        jPanel74.add(jLabel147);

        jLabel148.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel148.setForeground(new java.awt.Color(51, 51, 51));
        jLabel148.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel148.setText("2.00");
        jPanel74.add(jLabel148);

        jLabel149.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel149.setForeground(new java.awt.Color(51, 51, 51));
        jLabel149.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel149.setText("1.00");
        jPanel74.add(jLabel149);

        jLabel150.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel150.setForeground(new java.awt.Color(51, 51, 51));
        jLabel150.setText("Average yeald");
        jPanel74.add(jLabel150);

        jLabel151.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel151.setForeground(new java.awt.Color(51, 51, 51));
        jLabel151.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel151.setText("4.40");
        jPanel74.add(jLabel151);

        jLabel152.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel152.setForeground(new java.awt.Color(51, 51, 51));
        jLabel152.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel152.setText("4.40");
        jPanel74.add(jLabel152);

        jLabel153.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel153.setForeground(new java.awt.Color(51, 51, 51));
        jLabel153.setText("AAA Current Yield (Y)");
        jPanel74.add(jLabel153);

        YGraham.setEditable(false);
        YGraham.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        YGraham.setForeground(new java.awt.Color(204, 204, 204));
        jPanel74.add(YGraham);

        YGrahamRev.setEditable(false);
        YGrahamRev.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        YGrahamRev.setForeground(new java.awt.Color(204, 204, 204));
        jPanel74.add(YGrahamRev);

        jLabel154.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel154.setForeground(new java.awt.Color(51, 51, 51));
        jLabel154.setText("Instrinsic value");
        jPanel74.add(jLabel154);

        EndGraham.setEditable(false);
        EndGraham.setBackground(new java.awt.Color(204, 255, 204));
        EndGraham.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        EndGraham.setForeground(new java.awt.Color(204, 204, 204));
        jPanel74.add(EndGraham);

        EndGrahamRev.setEditable(false);
        EndGrahamRev.setBackground(new java.awt.Color(204, 255, 204));
        EndGrahamRev.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        EndGrahamRev.setForeground(new java.awt.Color(204, 204, 204));
        jPanel74.add(EndGrahamRev);

        jLabel155.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel155.setForeground(new java.awt.Color(51, 51, 51));
        jLabel155.setText("Instrinsic value with MoS");
        jPanel74.add(jLabel155);

        EndGrahamMoS.setEditable(false);
        EndGrahamMoS.setBackground(new java.awt.Color(255, 255, 204));
        EndGrahamMoS.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        EndGrahamMoS.setForeground(new java.awt.Color(204, 204, 204));
        jPanel74.add(EndGrahamMoS);

        EndGrahamRevMoS.setEditable(false);
        EndGrahamRevMoS.setBackground(new java.awt.Color(255, 255, 204));
        EndGrahamRevMoS.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        EndGrahamRevMoS.setForeground(new java.awt.Color(204, 204, 204));
        jPanel74.add(EndGrahamRevMoS);

        GrahamOut.add(jPanel74, java.awt.BorderLayout.CENTER);

        WelcomePanel.add(GrahamOut);

        SummaryOut.setLayout(new java.awt.BorderLayout());

        jPanel31.setBackground(new java.awt.Color(0, 153, 255));

        jLabel67.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(51, 51, 51));
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setText("Summary valuation of stock");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, 2183, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        SummaryOut.add(jPanel31, java.awt.BorderLayout.PAGE_START);

        jPanel32.setLayout(new java.awt.BorderLayout());

        jPanel33.setBackground(new java.awt.Color(0, 51, 255));
        jPanel33.setLayout(new java.awt.GridLayout(1, 2));

        SumSticker.setEditable(false);
        SumSticker.setBackground(new java.awt.Color(0, 51, 255));
        SumSticker.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        SumSticker.setForeground(new java.awt.Color(255, 255, 255));
        SumSticker.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SumSticker.setText("Sticker");
        jPanel33.add(SumSticker);

        ActPriceAns.setEditable(false);
        ActPriceAns.setBackground(new java.awt.Color(0, 51, 255));
        ActPriceAns.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        ActPriceAns.setForeground(new java.awt.Color(255, 255, 255));
        ActPriceAns.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ActPriceAns.setText("Actual Stock Price");
        jPanel33.add(ActPriceAns);

        jPanel32.add(jPanel33, java.awt.BorderLayout.PAGE_START);

        jPanel34.setBackground(new java.awt.Color(102, 255, 255));
        jPanel34.setLayout(new java.awt.GridLayout(2, 4));

        jLabel68.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(51, 51, 51));
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setText("Average price:");
        jPanel34.add(jLabel68);

        IdealPrice.setEditable(false);
        IdealPrice.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        IdealPrice.setForeground(new java.awt.Color(204, 204, 204));
        jPanel34.add(IdealPrice);

        jLabel70.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(51, 51, 51));
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("Averige price with margin:");
        jPanel34.add(jLabel70);

        IdealPriceMoS.setEditable(false);
        IdealPriceMoS.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        IdealPriceMoS.setForeground(new java.awt.Color(204, 204, 204));
        jPanel34.add(IdealPriceMoS);

        jLabel69.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(51, 51, 51));
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel69.setText("Difference:");
        jPanel34.add(jLabel69);

        Diff.setEditable(false);
        Diff.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        Diff.setForeground(new java.awt.Color(204, 204, 204));
        jPanel34.add(Diff);

        jLabel71.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(51, 51, 51));
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("Margin of Safety:");
        jPanel34.add(jLabel71);

        PillowAns.setEditable(false);
        PillowAns.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        PillowAns.setForeground(new java.awt.Color(204, 204, 204));
        jPanel34.add(PillowAns);

        jPanel32.add(jPanel34, java.awt.BorderLayout.PAGE_END);

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.setLayout(new java.awt.GridLayout(4, 5));

        jLabel72.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(0, 102, 255));
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setText("DCF");
        jPanel35.add(jLabel72);

        jLabel73.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(0, 102, 255));
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setText("DDM");
        jPanel35.add(jLabel73);

        jLabel74.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(0, 102, 255));
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel74.setText("Grahams Formulas");
        jPanel35.add(jLabel74);

        jLabel88.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(0, 102, 255));
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setText("Grahams Revs Formula");
        jPanel35.add(jLabel88);

        jLabel75.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(0, 102, 255));
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("NAV");
        jPanel35.add(jLabel75);

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));
        jPanel36.setLayout(new java.awt.GridLayout(1, 0));

        jLabel76.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(51, 51, 51));
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel76.setText("Price:");
        jPanel36.add(jLabel76);

        DCFAns.setEditable(false);
        DCFAns.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        DCFAns.setForeground(new java.awt.Color(204, 204, 204));
        jPanel36.add(DCFAns);

        jPanel35.add(jPanel36);

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setLayout(new java.awt.GridLayout(1, 2));

        jLabel77.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(51, 51, 51));
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel77.setText("Price:");
        jPanel37.add(jLabel77);

        DDMAns.setEditable(false);
        DDMAns.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        DDMAns.setForeground(new java.awt.Color(204, 204, 204));
        jPanel37.add(DDMAns);

        jPanel35.add(jPanel37);

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38.setLayout(new java.awt.GridLayout(1, 0));

        jLabel78.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(51, 51, 51));
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel78.setText("Price:");
        jPanel38.add(jLabel78);

        GrahamAns.setEditable(false);
        GrahamAns.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        GrahamAns.setForeground(new java.awt.Color(204, 204, 204));
        jPanel38.add(GrahamAns);

        jPanel35.add(jPanel38);

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setLayout(new java.awt.GridLayout(1, 0));

        jLabel79.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(51, 51, 51));
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel79.setText("Price:");
        jPanel39.add(jLabel79);

        GrahamRevAns.setEditable(false);
        GrahamRevAns.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        GrahamRevAns.setForeground(new java.awt.Color(204, 204, 204));
        jPanel39.add(GrahamRevAns);

        jPanel35.add(jPanel39);

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setLayout(new java.awt.GridLayout(1, 0));

        jLabel80.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(51, 51, 51));
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel80.setText("Price:");
        jPanel40.add(jLabel80);

        NAVAns.setEditable(false);
        NAVAns.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        NAVAns.setForeground(new java.awt.Color(204, 204, 204));
        jPanel40.add(NAVAns);

        jPanel35.add(jPanel40);

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));
        jPanel41.setLayout(new java.awt.GridLayout(1, 0));

        jLabel81.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(51, 51, 51));
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel81.setText("Price with MoS:");
        jPanel41.add(jLabel81);

        DCFMoSAns.setEditable(false);
        DCFMoSAns.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        DCFMoSAns.setForeground(new java.awt.Color(204, 204, 204));
        jPanel41.add(DCFMoSAns);

        jPanel35.add(jPanel41);

        jPanel42.setBackground(new java.awt.Color(255, 255, 255));
        jPanel42.setLayout(new java.awt.GridLayout(1, 0));

        jLabel82.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(51, 51, 51));
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel82.setText("Price with MoS:");
        jPanel42.add(jLabel82);

        DDMMoSAns.setEditable(false);
        DDMMoSAns.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        DDMMoSAns.setForeground(new java.awt.Color(204, 204, 204));
        jPanel42.add(DDMMoSAns);

        jPanel35.add(jPanel42);

        jPanel43.setBackground(new java.awt.Color(255, 255, 255));
        jPanel43.setLayout(new java.awt.GridLayout(1, 0));

        jLabel83.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(51, 51, 51));
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel83.setText("Price with MoS:");
        jPanel43.add(jLabel83);

        GrahamMoSAns.setEditable(false);
        GrahamMoSAns.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        GrahamMoSAns.setForeground(new java.awt.Color(204, 204, 204));
        jPanel43.add(GrahamMoSAns);

        jPanel35.add(jPanel43);

        jPanel44.setBackground(new java.awt.Color(255, 255, 255));
        jPanel44.setLayout(new java.awt.GridLayout(1, 0));

        jLabel84.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(51, 51, 51));
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel84.setText("Price with MoS:");
        jPanel44.add(jLabel84);

        GrahamRevMoSAns.setEditable(false);
        GrahamRevMoSAns.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        GrahamRevMoSAns.setForeground(new java.awt.Color(204, 204, 204));
        jPanel44.add(GrahamRevMoSAns);

        jPanel35.add(jPanel44);

        jPanel45.setBackground(new java.awt.Color(255, 255, 255));
        jPanel45.setLayout(new java.awt.GridLayout(1, 0));

        jLabel85.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(51, 51, 51));
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel85.setText("Price with MoS:");
        jPanel45.add(jLabel85);

        NAVMoSAns.setEditable(false);
        NAVMoSAns.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        NAVMoSAns.setForeground(new java.awt.Color(204, 204, 204));
        jPanel45.add(NAVMoSAns);

        jPanel35.add(jPanel45);

        jPanel46.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
        );

        jPanel35.add(jPanel46);

        jPanel47.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
        );

        jPanel35.add(jPanel47);

        jPanel48.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
        );

        jPanel35.add(jPanel48);

        jPanel49.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
        );

        jPanel35.add(jPanel49);

        jPanel50.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
        );

        jPanel35.add(jPanel50);

        jPanel32.add(jPanel35, java.awt.BorderLayout.CENTER);

        SummaryOut.add(jPanel32, java.awt.BorderLayout.CENTER);

        WelcomePanel.add(SummaryOut);

        Help.setLayout(new java.awt.BorderLayout());

        jPanel80.setBackground(new java.awt.Color(0, 153, 255));

        jLabel161.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel161.setForeground(new java.awt.Color(51, 51, 51));
        jLabel161.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel161.setText("Help and FAQ");

        javax.swing.GroupLayout jPanel80Layout = new javax.swing.GroupLayout(jPanel80);
        jPanel80.setLayout(jPanel80Layout);
        jPanel80Layout.setHorizontalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel161, javax.swing.GroupLayout.DEFAULT_SIZE, 2183, Short.MAX_VALUE)
        );
        jPanel80Layout.setVerticalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel161, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        Help.add(jPanel80, java.awt.BorderLayout.PAGE_START);

        WelcomePanel.add(Help);

        DDMOut.setLayout(new java.awt.BorderLayout());

        jPanel59.setBackground(new java.awt.Color(0, 153, 255));

        jLabel120.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(51, 51, 51));
        jLabel120.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel120.setText("Calculated Dividend Discount Model");

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel120, javax.swing.GroupLayout.DEFAULT_SIZE, 2183, Short.MAX_VALUE)
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel120, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        DDMOut.add(jPanel59, java.awt.BorderLayout.PAGE_START);

        jPanel60.setBackground(new java.awt.Color(102, 255, 255));
        jPanel60.setLayout(new java.awt.GridLayout(2, 4));

        jLabel121.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(51, 51, 51));
        jLabel121.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel121.setText("Actual stock price:");
        jPanel60.add(jLabel121);

        ActPriceDDM.setEditable(false);
        ActPriceDDM.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        ActPriceDDM.setForeground(new java.awt.Color(204, 204, 204));
        jPanel60.add(ActPriceDDM);

        jLabel122.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(51, 51, 51));
        jLabel122.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel122.setText("DDM Price:");
        jPanel60.add(jLabel122);

        PriceDDM.setEditable(false);
        PriceDDM.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        PriceDDM.setForeground(new java.awt.Color(204, 204, 204));
        jPanel60.add(PriceDDM);

        jLabel123.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(51, 51, 51));
        jLabel123.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel123.setText("Margin of Safety:");
        jPanel60.add(jLabel123);

        PillowDDM.setEditable(false);
        PillowDDM.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        PillowDDM.setForeground(new java.awt.Color(204, 204, 204));
        jPanel60.add(PillowDDM);

        jLabel124.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(51, 51, 51));
        jLabel124.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel124.setText("DDM Price with MoS:");
        jPanel60.add(jLabel124);

        PriceDDMMoS.setEditable(false);
        PriceDDMMoS.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        PriceDDMMoS.setForeground(new java.awt.Color(204, 204, 204));
        jPanel60.add(PriceDDMMoS);

        DDMOut.add(jPanel60, java.awt.BorderLayout.PAGE_END);

        jPanel61.setLayout(new java.awt.GridLayout(2, 1));

        DividendsPrediction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Divident Payout", null, null, null, null, null},
                {"Yearly Dividends", null, null, null, null, null},
                {"Growth Rate in %", null, null, null, null, null}
            },
            new String [] {
                "Year", "2018", "2019", "2020", "2021", "2022"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(DividendsPrediction);

        jPanel61.add(jScrollPane4);

        jPanel62.setBackground(new java.awt.Color(255, 255, 255));
        jPanel62.setLayout(new java.awt.GridLayout(4, 4));

        jLabel125.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(51, 51, 51));
        jLabel125.setText("Average Growth Rate");
        jPanel62.add(jLabel125);

        AvGRDDM.setEditable(false);
        AvGRDDM.setBackground(new java.awt.Color(70, 73, 75));
        AvGRDDM.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        AvGRDDM.setForeground(new java.awt.Color(204, 204, 204));
        jPanel62.add(AvGRDDM);

        jLabel126.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(51, 51, 51));
        jLabel126.setText("WACC / Discount rate");
        jPanel62.add(jLabel126);

        WACCDDMOut.setEditable(false);
        WACCDDMOut.setBackground(new java.awt.Color(70, 73, 75));
        WACCDDMOut.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        WACCDDMOut.setForeground(new java.awt.Color(204, 204, 204));
        jPanel62.add(WACCDDMOut);

        jPanel63.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel62.add(jPanel63);

        jPanel64.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel62.add(jPanel64);

        jPanel65.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(jPanel65);
        jPanel65.setLayout(jPanel65Layout);
        jPanel65Layout.setHorizontalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );
        jPanel65Layout.setVerticalGroup(
            jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel62.add(jPanel65);

        jPanel66.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel62.add(jPanel66);

        jPanel67.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel67Layout = new javax.swing.GroupLayout(jPanel67);
        jPanel67.setLayout(jPanel67Layout);
        jPanel67Layout.setHorizontalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );
        jPanel67Layout.setVerticalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel62.add(jPanel67);

        jPanel68.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel68Layout = new javax.swing.GroupLayout(jPanel68);
        jPanel68.setLayout(jPanel68Layout);
        jPanel68Layout.setHorizontalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );
        jPanel68Layout.setVerticalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel62.add(jPanel68);

        jPanel69.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel62.add(jPanel69);

        jPanel70.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel70Layout = new javax.swing.GroupLayout(jPanel70);
        jPanel70.setLayout(jPanel70Layout);
        jPanel70Layout.setHorizontalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );
        jPanel70Layout.setVerticalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel62.add(jPanel70);

        jPanel71.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel71Layout = new javax.swing.GroupLayout(jPanel71);
        jPanel71.setLayout(jPanel71Layout);
        jPanel71Layout.setHorizontalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );
        jPanel71Layout.setVerticalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel62.add(jPanel71);

        jPanel61.add(jPanel62);

        DDMOut.add(jPanel61, java.awt.BorderLayout.CENTER);

        WelcomePanel.add(DDMOut);

        GrahamIn.setLayout(new java.awt.BorderLayout());

        jPanel25.setBackground(new java.awt.Color(0, 153, 255));

        jLabel59.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(51, 51, 51));
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("Grahams and Grahams Reversed Formula Inputs");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, 2183, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        GrahamIn.add(jPanel25, java.awt.BorderLayout.PAGE_START);

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setForeground(new java.awt.Color(51, 51, 51));
        jPanel26.setLayout(new java.awt.GridLayout(6, 2));

        jLabel60.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(51, 51, 51));
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("EPS (TTM)");
        jPanel26.add(jLabel60);

        EPS.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        EPS.setForeground(new java.awt.Color(204, 204, 204));
        EPS.setBorder(null);
        EPS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EPSKeyTyped(evt);
            }
        });
        jPanel26.add(EPS);

        jLabel61.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(51, 51, 51));
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("Growth rate (next 5y) [ % ]");
        jPanel26.add(jLabel61);

        GRGrahamInn.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        GRGrahamInn.setForeground(new java.awt.Color(204, 204, 204));
        GRGrahamInn.setBorder(null);
        GRGrahamInn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                GRGrahamInnKeyTyped(evt);
            }
        });
        jPanel26.add(GRGrahamInn);

        jLabel62.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(51, 51, 51));
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("AAA current yield");
        jPanel26.add(jLabel62);

        Y.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        Y.setForeground(new java.awt.Color(204, 204, 204));
        Y.setBorder(null);
        Y.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                YKeyTyped(evt);
            }
        });
        jPanel26.add(Y);

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1091, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jPanel26.add(jPanel27);

        GrahamIn.add(jPanel26, java.awt.BorderLayout.CENTER);

        WelcomePanel.add(GrahamIn);

        DCFOut.setLayout(new java.awt.BorderLayout());

        jPanel53.setBackground(new java.awt.Color(0, 153, 255));

        jLabel87.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(51, 51, 51));
        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel87.setText("Calculated Discounted Cash Flow Model");

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel87, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel87, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        DCFOut.add(jPanel53, java.awt.BorderLayout.PAGE_START);

        jPanel54.setBackground(new java.awt.Color(102, 255, 255));
        jPanel54.setLayout(new java.awt.GridLayout(2, 4));

        jLabel97.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(51, 51, 51));
        jLabel97.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel97.setText("Actual stock price:");
        jPanel54.add(jLabel97);

        ActPriceDCF.setEditable(false);
        ActPriceDCF.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        ActPriceDCF.setForeground(new java.awt.Color(204, 204, 204));
        jPanel54.add(ActPriceDCF);

        jLabel98.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(51, 51, 51));
        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel98.setText("DCF Price:");
        jPanel54.add(jLabel98);

        PriceDCF.setEditable(false);
        PriceDCF.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        PriceDCF.setForeground(new java.awt.Color(204, 204, 204));
        jPanel54.add(PriceDCF);

        jLabel99.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(51, 51, 51));
        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setText("Margin of Safety:");
        jPanel54.add(jLabel99);

        PillowDCF.setEditable(false);
        PillowDCF.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        PillowDCF.setForeground(new java.awt.Color(204, 204, 204));
        jPanel54.add(PillowDCF);

        jLabel100.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(51, 51, 51));
        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel100.setText("DCF Price with MoS:");
        jPanel54.add(jLabel100);

        PriceDCFMoS.setEditable(false);
        PriceDCFMoS.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        PriceDCFMoS.setForeground(new java.awt.Color(204, 204, 204));
        jPanel54.add(PriceDCFMoS);

        DCFOut.add(jPanel54, java.awt.BorderLayout.PAGE_END);

        jPanel55.setLayout(new java.awt.GridLayout(2, 1));

        jPanel56.setLayout(new java.awt.GridLayout(3, 1));

        LastFCF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Free Cash Flow", null, null, null, null, null, null, null, null},
                {"Growth Rate in %", null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Year", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(LastFCF);

        jPanel56.add(jScrollPane5);

        jPanel58.setBackground(new java.awt.Color(255, 255, 255));
        jPanel58.setLayout(new java.awt.GridLayout(1, 4));

        jLabel116.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(51, 51, 51));
        jLabel116.setText("Growth Rate (next 5 Years)");
        jPanel58.add(jLabel116);

        GRDCF.setEditable(false);
        GRDCF.setBackground(new java.awt.Color(70, 73, 75));
        GRDCF.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        GRDCF.setForeground(new java.awt.Color(204, 204, 204));
        jPanel58.add(GRDCF);

        jLabel117.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(51, 51, 51));
        jLabel117.setText("Average Growth Rate");
        jPanel58.add(jLabel117);

        AvGRDCF.setEditable(false);
        AvGRDCF.setBackground(new java.awt.Color(70, 73, 75));
        AvGRDCF.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        AvGRDCF.setForeground(new java.awt.Color(204, 204, 204));
        jPanel58.add(AvGRDCF);

        jPanel56.add(jPanel58);

        FutureFCF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Year", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "TV"},
                {"Future FCF", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"Discounted FFCF", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "PoFFCF", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(FutureFCF);

        jPanel56.add(jScrollPane6);

        jPanel55.add(jPanel56);

        jPanel57.setBackground(new java.awt.Color(255, 255, 255));
        jPanel57.setLayout(new java.awt.GridLayout(4, 4));

        jLabel109.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(51, 51, 51));
        jLabel109.setText("Perpentual Growth Rate");
        jPanel57.add(jLabel109);

        StateDCF.setEditable(false);
        StateDCF.setBackground(new java.awt.Color(70, 73, 75));
        StateDCF.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        StateDCF.setForeground(new java.awt.Color(204, 204, 204));
        jPanel57.add(StateDCF);

        jLabel110.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(51, 51, 51));
        jLabel110.setText("Discount Rate");
        jPanel57.add(jLabel110);

        WACCDCFOut.setEditable(false);
        WACCDCFOut.setBackground(new java.awt.Color(70, 73, 75));
        WACCDCFOut.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        WACCDCFOut.setForeground(new java.awt.Color(204, 204, 204));
        jPanel57.add(WACCDCFOut);

        jLabel111.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(51, 51, 51));
        jLabel111.setText("Cahs & Cash Equivalents");
        jPanel57.add(jLabel111);

        CashDCF.setEditable(false);
        CashDCF.setBackground(new java.awt.Color(70, 73, 75));
        CashDCF.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        CashDCF.setForeground(new java.awt.Color(204, 204, 204));
        jPanel57.add(CashDCF);

        jLabel112.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(51, 51, 51));
        jLabel112.setText("Sum of FCF");
        jPanel57.add(jLabel112);

        SumFCFDCF.setEditable(false);
        SumFCFDCF.setBackground(new java.awt.Color(70, 73, 75));
        SumFCFDCF.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        SumFCFDCF.setForeground(new java.awt.Color(204, 204, 204));
        jPanel57.add(SumFCFDCF);

        jLabel113.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(51, 51, 51));
        jLabel113.setText("Total Debt");
        jPanel57.add(jLabel113);

        DebtDCF.setEditable(false);
        DebtDCF.setBackground(new java.awt.Color(70, 73, 75));
        DebtDCF.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        DebtDCF.setForeground(new java.awt.Color(204, 204, 204));
        jPanel57.add(DebtDCF);

        jLabel114.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(51, 51, 51));
        jLabel114.setText("Equity Value");
        jPanel57.add(jLabel114);

        EVDCF.setEditable(false);
        EVDCF.setBackground(new java.awt.Color(70, 73, 75));
        EVDCF.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        EVDCF.setForeground(new java.awt.Color(204, 204, 204));
        jPanel57.add(EVDCF);

        jLabel115.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(51, 51, 51));
        jLabel115.setText("Shares Outstanding");
        jPanel57.add(jLabel115);

        SharesDCF.setEditable(false);
        SharesDCF.setBackground(new java.awt.Color(70, 73, 75));
        SharesDCF.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        SharesDCF.setForeground(new java.awt.Color(204, 204, 204));
        jPanel57.add(SharesDCF);

        jPanel55.add(jPanel57);

        DCFOut.add(jPanel55, java.awt.BorderLayout.CENTER);

        WelcomePanel.add(DCFOut);

        DDMIn.setBackground(new java.awt.Color(70, 73, 75));
        DDMIn.setPreferredSize(new java.awt.Dimension(850, 600));
        DDMIn.setLayout(new java.awt.BorderLayout());

        jPanel10.setBackground(new java.awt.Color(0, 153, 255));

        jLabel57.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(51, 51, 51));
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("Dividend Discount Model Inputs");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        DDMIn.add(jPanel10, java.awt.BorderLayout.PAGE_START);

        jPanel11.setLayout(new java.awt.GridLayout(1, 2));

        Dividends.setBackground(new java.awt.Color(255, 255, 255));
        Dividends.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Dividends.setForeground(new java.awt.Color(51, 51, 51));
        Dividends.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"2023", null},
                {"2022", null},
                {"2021", null},
                {"2020", null},
                {"2019", null}
            },
            new String [] {
                "Year", "Dividend"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Dividends.setRowHeight(40);
        Dividends.setRowMargin(1);
        Dividends.setShowGrid(true);
        Dividends.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Dividends);

        jPanel11.add(jScrollPane1);

        jPanel12.setLayout(new java.awt.GridLayout(1, 0));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setLayout(new java.awt.GridLayout(6, 2));

        jLabel58.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(51, 51, 51));
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("Discount Rate");
        jPanel19.add(jLabel58);

        WACCDDM.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        WACCDDM.setForeground(new java.awt.Color(204, 204, 204));
        WACCDDM.setBorder(null);
        WACCDDM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                WACCDDMKeyTyped(evt);
            }
        });
        jPanel19.add(WACCDDM);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel19.add(jPanel20);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel19.add(jPanel21);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel19.add(jPanel22);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel19.add(jPanel23);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel19.add(jPanel24);

        jPanel12.add(jPanel19);

        jPanel11.add(jPanel12);

        DDMIn.add(jPanel11, java.awt.BorderLayout.CENTER);

        WelcomePanel.add(DDMIn);

        Library.setPreferredSize(new java.awt.Dimension(0, 0));
        Library.setLayout(new java.awt.BorderLayout());

        jPanel81.setBackground(new java.awt.Color(0, 153, 255));

        jLabel162.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel162.setForeground(new java.awt.Color(51, 51, 51));
        jLabel162.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel162.setText("Saved Valuations");

        javax.swing.GroupLayout jPanel81Layout = new javax.swing.GroupLayout(jPanel81);
        jPanel81.setLayout(jPanel81Layout);
        jPanel81Layout.setHorizontalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel162, javax.swing.GroupLayout.DEFAULT_SIZE, 2183, Short.MAX_VALUE)
        );
        jPanel81Layout.setVerticalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel162, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        Library.add(jPanel81, java.awt.BorderLayout.PAGE_START);

        WelcomePanel.add(Library);

        Settings.setLayout(new java.awt.BorderLayout());

        jPanel79.setBackground(new java.awt.Color(0, 153, 255));

        jLabel160.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel160.setForeground(new java.awt.Color(51, 51, 51));
        jLabel160.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel160.setText("Settings");

        javax.swing.GroupLayout jPanel79Layout = new javax.swing.GroupLayout(jPanel79);
        jPanel79.setLayout(jPanel79Layout);
        jPanel79Layout.setHorizontalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel160, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
        );
        jPanel79Layout.setVerticalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel160, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        Settings.add(jPanel79, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.GridLayout(5, 2));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("jLabel6");
        jPanel3.add(jLabel6);

        LangChoice.setBackground(new java.awt.Color(255, 255, 255));
        LangChoice.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        LangChoice.setForeground(new java.awt.Color(51, 51, 51));
        LangChoice.setBorder(null);
        LangChoice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(LangChoice);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel6);

        jButton1.setBackground(new java.awt.Color(0, 51, 255));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("jButton1");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel3.add(jButton1);

        Settings.add(jPanel3, java.awt.BorderLayout.CENTER);

        WelcomePanel.add(Settings);

        RatioOut.setPreferredSize(new java.awt.Dimension(900, 600));
        RatioOut.setLayout(new java.awt.BorderLayout());

        jPanel51.setBackground(new java.awt.Color(0, 153, 255));

        jLabel86.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(51, 51, 51));
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setText("Summary ratio answers");

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel86, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE)
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel86, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        RatioOut.add(jPanel51, java.awt.BorderLayout.PAGE_START);

        jPanel52.setBackground(new java.awt.Color(255, 255, 255));
        jPanel52.setLayout(new java.awt.GridLayout(8, 4));

        jLabel89.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(51, 51, 51));
        jLabel89.setText("Gross Margin");
        jPanel52.add(jLabel89);

        GM.setEditable(false);
        GM.setBackground(new java.awt.Color(70, 73, 75));
        GM.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        GM.setForeground(new java.awt.Color(204, 204, 204));
        jPanel52.add(GM);

        jLabel90.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(51, 51, 51));
        jLabel90.setText("Operating Margin");
        jPanel52.add(jLabel90);

        OM.setEditable(false);
        OM.setBackground(new java.awt.Color(70, 73, 75));
        OM.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        OM.setForeground(new java.awt.Color(204, 204, 204));
        jPanel52.add(OM);

        jLabel91.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(51, 51, 51));
        jLabel91.setText("Earinings per Share (EPS)");
        jPanel52.add(jLabel91);

        EPSRatio.setEditable(false);
        EPSRatio.setBackground(new java.awt.Color(70, 73, 75));
        EPSRatio.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        EPSRatio.setForeground(new java.awt.Color(204, 204, 204));
        jPanel52.add(EPSRatio);

        jLabel92.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(51, 51, 51));
        jLabel92.setText("Price / Earinings");
        jPanel52.add(jLabel92);

        PpE.setEditable(false);
        PpE.setBackground(new java.awt.Color(70, 73, 75));
        PpE.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        PpE.setForeground(new java.awt.Color(204, 204, 204));
        jPanel52.add(PpE);

        jLabel93.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(51, 51, 51));
        jLabel93.setText("Current liquidity");
        jPanel52.add(jLabel93);

        CLiq.setEditable(false);
        CLiq.setBackground(new java.awt.Color(70, 73, 75));
        CLiq.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        CLiq.setForeground(new java.awt.Color(204, 204, 204));
        jPanel52.add(CLiq);

        jLabel94.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(51, 51, 51));
        jLabel94.setText("Price / Book");
        jPanel52.add(jLabel94);

        PpB.setEditable(false);
        PpB.setBackground(new java.awt.Color(70, 73, 75));
        PpB.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        PpB.setForeground(new java.awt.Color(204, 204, 204));
        jPanel52.add(PpB);

        jLabel95.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(51, 51, 51));
        jLabel95.setText("Debt / Equity");
        jPanel52.add(jLabel95);

        DpE.setEditable(false);
        DpE.setBackground(new java.awt.Color(70, 73, 75));
        DpE.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        DpE.setForeground(new java.awt.Color(204, 204, 204));
        jPanel52.add(DpE);

        jLabel96.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(51, 51, 51));
        jLabel96.setText("Payout Ratio");
        jPanel52.add(jLabel96);

        PayOut.setEditable(false);
        PayOut.setBackground(new java.awt.Color(70, 73, 75));
        PayOut.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        PayOut.setForeground(new java.awt.Color(204, 204, 204));
        jPanel52.add(PayOut);

        jLabel101.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(51, 51, 51));
        jLabel101.setText("Return on Assets (ROA)");
        jPanel52.add(jLabel101);

        ROA.setEditable(false);
        ROA.setBackground(new java.awt.Color(70, 73, 75));
        ROA.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        ROA.setForeground(new java.awt.Color(204, 204, 204));
        jPanel52.add(ROA);

        jLabel102.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(51, 51, 51));
        jLabel102.setText("Return on Equity (ROE)");
        jPanel52.add(jLabel102);

        ROE.setEditable(false);
        ROE.setBackground(new java.awt.Color(70, 73, 75));
        ROE.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        ROE.setForeground(new java.awt.Color(204, 204, 204));
        jPanel52.add(ROE);

        jLabel103.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(51, 51, 51));
        jLabel103.setText("Return on Sales (ROS)");
        jPanel52.add(jLabel103);

        ROS.setEditable(false);
        ROS.setBackground(new java.awt.Color(70, 73, 75));
        ROS.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        ROS.setForeground(new java.awt.Color(204, 204, 204));
        jPanel52.add(ROS);

        jLabel104.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(51, 51, 51));
        jLabel104.setText("Cost-effectiveness");
        jPanel52.add(jLabel104);

        RN.setEditable(false);
        RN.setBackground(new java.awt.Color(70, 73, 75));
        RN.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        RN.setForeground(new java.awt.Color(204, 204, 204));
        jPanel52.add(RN);

        jLabel105.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(51, 51, 51));
        jLabel105.setText("Total indebtedness of the enterprise");
        jPanel52.add(jLabel105);

        Indebtedness.setEditable(false);
        Indebtedness.setBackground(new java.awt.Color(70, 73, 75));
        Indebtedness.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        Indebtedness.setForeground(new java.awt.Color(204, 204, 204));
        jPanel52.add(Indebtedness);

        jLabel106.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(51, 51, 51));
        jLabel106.setText("Period of turnover of receivables");
        jPanel52.add(jLabel106);

        ReceivablesTime.setEditable(false);
        ReceivablesTime.setBackground(new java.awt.Color(70, 73, 75));
        ReceivablesTime.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        ReceivablesTime.setForeground(new java.awt.Color(204, 204, 204));
        jPanel52.add(ReceivablesTime);

        jLabel107.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(51, 51, 51));
        jLabel107.setText("Period of turnover of liabilities");
        jPanel52.add(jLabel107);

        LiabilitiesTime.setEditable(false);
        LiabilitiesTime.setBackground(new java.awt.Color(70, 73, 75));
        LiabilitiesTime.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        LiabilitiesTime.setForeground(new java.awt.Color(204, 204, 204));
        jPanel52.add(LiabilitiesTime);

        jLabel108.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(51, 51, 51));
        jLabel108.setText("Inventory turnover time");
        jPanel52.add(jLabel108);

        InventoryTime.setEditable(false);
        InventoryTime.setBackground(new java.awt.Color(70, 73, 75));
        InventoryTime.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        InventoryTime.setForeground(new java.awt.Color(204, 204, 204));
        jPanel52.add(InventoryTime);

        RatioOut.add(jPanel52, java.awt.BorderLayout.CENTER);

        WelcomePanel.add(RatioOut);

        DCFIn.setForeground(new java.awt.Color(204, 204, 204));
        DCFIn.setPreferredSize(new java.awt.Dimension(850, 600));
        DCFIn.setLayout(new java.awt.BorderLayout());

        jPanel13.setBackground(new java.awt.Color(0, 153, 255));

        jLabel45.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(51, 51, 51));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Discounted Cash Flow Model Inputs");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
        );

        DCFIn.add(jPanel13, java.awt.BorderLayout.PAGE_START);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new java.awt.GridLayout(1, 2));

        jScrollPane8.setBackground(new java.awt.Color(255, 255, 255));

        FCF2.setBackground(new java.awt.Color(255, 255, 255));
        FCF2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        FCF2.setForeground(new java.awt.Color(51, 51, 51));
        FCF2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"2024", null},
                {"2023", null},
                {"2022", null},
                {"2021", null},
                {"2020", null},
                {"2019", null},
                {"2018", null},
                {"2017", null},
                {"2016", null}
            },
            new String [] {
                "Year", "Free Cash Flow"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        FCF2.setRowHeight(40);
        FCF2.setRowMargin(1);
        FCF2.setShowGrid(true);
        FCF2.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(FCF2);

        jPanel14.add(jScrollPane8);

        jPanel87.setBackground(new java.awt.Color(255, 255, 255));
        jPanel87.setLayout(new java.awt.GridLayout(8, 2));

        jLabel134.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel134.setForeground(new java.awt.Color(51, 51, 51));
        jLabel134.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel134.setText("Growth rate (next 5y) [ % ]");
        jPanel87.add(jLabel134);

        GR3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        GR3.setForeground(new java.awt.Color(204, 204, 204));
        GR3.setBorder(null);
        GR3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                GR3KeyTyped(evt);
            }
        });
        jPanel87.add(GR3);

        jLabel135.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel135.setForeground(new java.awt.Color(51, 51, 51));
        jLabel135.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel135.setText("Discount Rate [ % ]");
        jPanel87.add(jLabel135);

        WACCDCFInn.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        WACCDCFInn.setForeground(new java.awt.Color(204, 204, 204));
        WACCDCFInn.setBorder(null);
        WACCDCFInn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                WACCDCFInnKeyTyped(evt);
            }
        });
        jPanel87.add(WACCDCFInn);

        jLabel136.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel136.setForeground(new java.awt.Color(51, 51, 51));
        jLabel136.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel136.setText("Actual Free Cash Flow");
        jPanel87.add(jLabel136);

        ActFCF2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        ActFCF2.setForeground(new java.awt.Color(204, 204, 204));
        ActFCF2.setBorder(null);
        ActFCF2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ActFCF2KeyTyped(evt);
            }
        });
        jPanel87.add(ActFCF2);

        jLabel137.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel137.setForeground(new java.awt.Color(51, 51, 51));
        jLabel137.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel137.setText("Total Debt");
        jPanel87.add(jLabel137);

        Debt2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        Debt2.setForeground(new java.awt.Color(204, 204, 204));
        Debt2.setBorder(null);
        Debt2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Debt2KeyTyped(evt);
            }
        });
        jPanel87.add(Debt2);

        jLabel141.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel141.setForeground(new java.awt.Color(51, 51, 51));
        jLabel141.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel141.setText("Shares Outstanding");
        jPanel87.add(jLabel141);

        Shares2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        Shares2.setForeground(new java.awt.Color(204, 204, 204));
        Shares2.setBorder(null);
        Shares2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Shares2KeyTyped(evt);
            }
        });
        jPanel87.add(Shares2);

        jLabel142.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel142.setForeground(new java.awt.Color(51, 51, 51));
        jLabel142.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel142.setText("Cash & Cash Equivalents");
        jPanel87.add(jLabel142);

        CandC2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        CandC2.setForeground(new java.awt.Color(204, 204, 204));
        CandC2.setBorder(null);
        CandC2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CandC2KeyTyped(evt);
            }
        });
        jPanel87.add(CandC2);

        jLabel164.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel164.setForeground(new java.awt.Color(51, 51, 51));
        jLabel164.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel164.setText("States Perpentual Growth Rate");
        jPanel87.add(jLabel164);

        State2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        State2.setForeground(new java.awt.Color(204, 204, 204));
        State2.setBorder(null);
        State2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                State2KeyTyped(evt);
            }
        });
        jPanel87.add(State2);

        jPanel14.add(jPanel87);

        DCFIn.add(jPanel14, java.awt.BorderLayout.CENTER);

        WelcomePanel.add(DCFIn);

        NAVOut.setLayout(new java.awt.BorderLayout());

        jPanel78.setBackground(new java.awt.Color(0, 153, 255));

        jLabel159.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel159.setForeground(new java.awt.Color(51, 51, 51));
        jLabel159.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel159.setText("Calculated Net Assets Value");

        javax.swing.GroupLayout jPanel78Layout = new javax.swing.GroupLayout(jPanel78);
        jPanel78.setLayout(jPanel78Layout);
        jPanel78Layout.setHorizontalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel159, javax.swing.GroupLayout.DEFAULT_SIZE, 2183, Short.MAX_VALUE)
        );
        jPanel78Layout.setVerticalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel159, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        NAVOut.add(jPanel78, java.awt.BorderLayout.PAGE_START);

        jPanel83.setBackground(new java.awt.Color(102, 255, 255));
        jPanel83.setLayout(new java.awt.GridLayout(2, 4));

        jLabel118.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(51, 51, 51));
        jLabel118.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel118.setText("Actual stock price:");
        jPanel83.add(jLabel118);

        ActPriceNAV.setEditable(false);
        ActPriceNAV.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        ActPriceNAV.setForeground(new java.awt.Color(204, 204, 204));
        jPanel83.add(ActPriceNAV);

        jLabel119.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(51, 51, 51));
        jLabel119.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel119.setText("NAV Price:");
        jPanel83.add(jLabel119);

        PriceNAV.setEditable(false);
        PriceNAV.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        PriceNAV.setForeground(new java.awt.Color(204, 204, 204));
        jPanel83.add(PriceNAV);

        jLabel128.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(51, 51, 51));
        jLabel128.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel128.setText("Margin of Safety:");
        jPanel83.add(jLabel128);

        PillowNAV.setEditable(false);
        PillowNAV.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        PillowNAV.setForeground(new java.awt.Color(204, 204, 204));
        jPanel83.add(PillowNAV);

        jLabel129.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(51, 51, 51));
        jLabel129.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel129.setText("NAV Price with MoS:");
        jPanel83.add(jLabel129);

        PriceNAVMoS.setEditable(false);
        PriceNAVMoS.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        PriceNAVMoS.setForeground(new java.awt.Color(204, 204, 204));
        jPanel83.add(PriceNAVMoS);

        NAVOut.add(jPanel83, java.awt.BorderLayout.PAGE_END);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(4, 2));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Number of Total Assets");
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1);

        TotalAssetsNAV.setEditable(false);
        TotalAssetsNAV.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        TotalAssetsNAV.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(TotalAssetsNAV);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Number of Total Liabilities");
        jLabel4.setToolTipText("");
        jPanel1.add(jLabel4);

        TotalLiabilitiesNAV.setEditable(false);
        TotalLiabilitiesNAV.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        TotalLiabilitiesNAV.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(TotalLiabilitiesNAV);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Shares outstanding");
        jLabel5.setToolTipText("");
        jPanel1.add(jLabel5);

        SharesNAV.setEditable(false);
        SharesNAV.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        SharesNAV.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(SharesNAV);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1091, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 79, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);

        NAVOut.add(jPanel1, java.awt.BorderLayout.CENTER);

        WelcomePanel.add(NAVOut);

        InfoIn.setBackground(new java.awt.Color(255, 255, 255));
        InfoIn.setMinimumSize(new java.awt.Dimension(620, 600));
        InfoIn.setPreferredSize(new java.awt.Dimension(620, 600));
        InfoIn.setLayout(new java.awt.GridLayout(7, 2));

        jPanel18.setBackground(new java.awt.Color(0, 153, 255));

        jLabel54.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(51, 51, 51));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("Stock");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        InfoIn.add(jPanel18);

        jPanel16.setBackground(new java.awt.Color(0, 153, 255));

        jLabel55.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(51, 51, 51));
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("Information");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        InfoIn.add(jPanel16);

        jLabel28.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 51, 51));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Corporation name:");
        jLabel28.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel28.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        InfoIn.add(jLabel28);

        CorpNameField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        CorpNameField.setForeground(new java.awt.Color(204, 204, 204));
        CorpNameField.setBorder(null);
        CorpNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CorpNameFieldKeyTyped(evt);
            }
        });
        InfoIn.add(CorpNameField);

        jLabel29.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 51));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Corporation sticker:");
        InfoIn.add(jLabel29);

        CorpStickerField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        CorpStickerField.setForeground(new java.awt.Color(204, 204, 204));
        CorpStickerField.setBorder(null);
        CorpStickerField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CorpStickerFieldKeyTyped(evt);
            }
        });
        InfoIn.add(CorpStickerField);

        jLabel30.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(51, 51, 51));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Stock exchange:");
        InfoIn.add(jLabel30);

        StockExchField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        StockExchField.setForeground(new java.awt.Color(204, 204, 204));
        StockExchField.setBorder(null);
        StockExchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                StockExchFieldKeyTyped(evt);
            }
        });
        InfoIn.add(StockExchField);

        jLabel44.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(51, 51, 51));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Actual Price:");
        InfoIn.add(jLabel44);

        ActPrice.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        ActPrice.setForeground(new java.awt.Color(204, 204, 204));
        ActPrice.setBorder(null);
        ActPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ActPriceKeyTyped(evt);
            }
        });
        InfoIn.add(ActPrice);

        jLabel166.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel166.setForeground(new java.awt.Color(51, 51, 51));
        jLabel166.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel166.setText("Margin of Safety [ % ]");
        InfoIn.add(jLabel166);

        Pillow2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        Pillow2.setForeground(new java.awt.Color(204, 204, 204));
        Pillow2.setBorder(null);
        Pillow2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Pillow2KeyTyped(evt);
            }
        });
        InfoIn.add(Pillow2);

        jLabel31.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 51, 51));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Notes:");
        InfoIn.add(jLabel31);

        NotesField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        NotesField.setForeground(new java.awt.Color(204, 204, 204));
        NotesField.setBorder(null);
        NotesField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NotesFieldKeyTyped(evt);
            }
        });
        InfoIn.add(NotesField);

        WelcomePanel.add(InfoIn);

        Save.setLayout(new java.awt.BorderLayout());

        jPanel82.setBackground(new java.awt.Color(0, 153, 255));

        jLabel163.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel163.setForeground(new java.awt.Color(51, 51, 51));
        jLabel163.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel163.setText("Saving works! Yay!");

        javax.swing.GroupLayout jPanel82Layout = new javax.swing.GroupLayout(jPanel82);
        jPanel82.setLayout(jPanel82Layout);
        jPanel82Layout.setHorizontalGroup(
            jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel163, javax.swing.GroupLayout.DEFAULT_SIZE, 2183, Short.MAX_VALUE)
        );
        jPanel82Layout.setVerticalGroup(
            jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel163, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        Save.add(jPanel82, java.awt.BorderLayout.PAGE_START);

        WelcomePanel.add(Save);

        NAVIn.setForeground(new java.awt.Color(204, 204, 204));
        NAVIn.setToolTipText("");
        NAVIn.setLayout(new java.awt.BorderLayout());

        jPanel28.setBackground(new java.awt.Color(0, 153, 255));

        jLabel63.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(51, 51, 51));
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setText("Net Asset Value Inputs");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, 2183, Short.MAX_VALUE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        NAVIn.add(jPanel28, java.awt.BorderLayout.PAGE_START);

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setLayout(new java.awt.GridLayout(6, 2));

        jLabel64.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(51, 51, 51));
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("Total Assets");
        jPanel29.add(jLabel64);

        TotalAssets.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        TotalAssets.setForeground(new java.awt.Color(204, 204, 204));
        TotalAssets.setToolTipText("");
        TotalAssets.setBorder(null);
        TotalAssets.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TotalAssetsKeyTyped(evt);
            }
        });
        jPanel29.add(TotalAssets);

        jLabel65.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(51, 51, 51));
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setText("Total Liabilities");
        jPanel29.add(jLabel65);

        TotalLiab.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        TotalLiab.setForeground(new java.awt.Color(204, 204, 204));
        TotalLiab.setToolTipText("");
        TotalLiab.setBorder(null);
        TotalLiab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TotalLiabKeyTyped(evt);
            }
        });
        jPanel29.add(TotalLiab);

        jLabel66.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(51, 51, 51));
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setText("Total number of outstanding share");
        jPanel29.add(jLabel66);

        SharesOut.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        SharesOut.setForeground(new java.awt.Color(204, 204, 204));
        SharesOut.setToolTipText("");
        SharesOut.setBorder(null);
        SharesOut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SharesOutKeyTyped(evt);
            }
        });
        jPanel29.add(SharesOut);

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1091, Short.MAX_VALUE)
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel29.add(jPanel30);

        NAVIn.add(jPanel29, java.awt.BorderLayout.CENTER);

        WelcomePanel.add(NAVIn);

        getContentPane().add(WelcomePanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * @param target
     * @param rand
     */
    public void changeColor(JPanel target, Color rand) {
        if (target != null) {
            target.setBackground(rand);
        }
    }

    /**
     *
     * @param showingMenu
     * @param target
     * @param hid
     * @param icon
     * @param route
     * @return
     */
    public boolean showHideMenu(JPanel showingMenu, JPanel target, boolean hid, JLabel icon, String route) {
        if (showingMenu != null && target != null && icon != null && route != null) {
            if (!hid) {
                showingMenu.setPreferredSize(new Dimension(0, MenuColumn.getHeight()));
                Menu.setPreferredSize(new Dimension(50, 400));
                target.setBackground(lightColor);
                activeChoices.remove(target);
                changeIcon(icon, route);
            } else {
                showingMenu.setPreferredSize(new Dimension(270, MenuColumn.getHeight()));
                Menu.setPreferredSize(new Dimension(320, 400));
                target.setBackground(lightDarkColor);
                activeChoices.add(target);
                changeIcon(icon, route);
            }
            return !hid;
        }
        return hid;
    }

    /**
     *
     * @param target
     * @param resourceRoute
     */
    public void changeIcon(JLabel target, String resourceRoute) {
        ImageIcon icon = new ImageIcon(getClass().getResource(resourceRoute));
        target.setIcon(icon);
        target.setSize(50, 50);
        target.setVerticalAlignment(SwingConstants.CENTER);
        target.setHorizontalAlignment(SwingConstants.CENTER);
    }

    /**
     *
     * @param target
     * @param change
     */
    public void exiting(JPanel target, Color change) {
        if (target != null) {
            if (target != actShowing && target != actMenuItem) {
                if (!cleaningChoices.contains(target.getName()) && !calcChoices.contains(target.getName())) {
                    if (!activeChoices.contains(target)) {
                        target.setBackground(change);
                    }
                }
            }
        }
    }

    /**
     *
     * @param target
     */
    public void clickUnclick(JPanel target) {
        if (target != null) {
            if (!activeChoices.contains(target)) {
                target.setBackground(darkLightColor);
                activeChoices.add(target);
            } else {
                target.setBackground(lightDarkColor);
                activeChoices.remove(target);
            }
        }
    }

    /**
     *
     * @param hide
     * @param menu
     * @param but
     * @param color
     * @param icon
     * @param route
     * @return
     */
    public boolean hideMenus(boolean hide, JPanel menu, JPanel but, Color color, JLabel icon, String route) {
        hide = true;
        menu.setVisible(false);
        Menu.setPreferredSize(new Dimension(0, MenuColumn.getHeight()));
        but.setBackground(color);
        activeChoices.remove(but);
        changeIcon(icon, route);
        return hide;
    }

    /**
     *
     * @param choice
     */
    public void chooseCleaning(JPanel choice) {
        if (choice != null) {
            if (cleaningChoices.contains(choice.getName())) {
                cleaningChoices.remove(choice.getName());
                choice.setBackground(lightDarkColor);
            } else {
                cleaningChoices.add(choice.getName());
                choice.setBackground(darkLightColor);
            }
        }
    }

    /**
     *
     * @param choice
     */
    public void chooseCalculation(JPanel choice) {
        if (choice != null) {
            if (calcChoices.contains(choice.getName())) {
                calcChoices.remove(choice.getName());
                choice.setBackground(lightDarkColor);
            } else {
                calcChoices.add(choice.getName());
                choice.setBackground(darkLightColor);
            }
        }
    }

    public void OpenView(JPanel target) {
        if (target != null && Menu != null) {
            for (JPanel a : views) {
                if (a.equals(target)) {
                    a.setVisible(true);
                    a.setPreferredSize(new Dimension(WelcomePanel.getWidth(), WelcomePanel.getHeight()));
                } else {
                    a.setVisible(false);
                }
            }
        }
    }

    /**
     *
     * @param opening
     * @param type
     */
    public void ShowingViewBackground(JPanel opening, int type) {
        if (opening != null) {
            switch (type) {
                case 0 -> {
                    if (actShowing != null) {
                        actShowing.setBackground(lightDarkColor);
                    }
                    actShowing = opening;
                    opening.setBackground(darkLightColor);
                }
                case 1 -> {
                    if (actMenuItem != null) {
                        actMenuItem.setBackground(lightColor);
                    }

                    actMenuItem = opening;
                    opening.setBackground(lightDarkColor);
                }
                default -> {
                }
            }
        }
    }

    public void setItemUnactive() {
        if (actMenuItem != null) {
            actMenuItem.setBackground(lightColor);
            actMenuItem = null;
        }
    }

    private void InputButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InputButMouseEntered
        changeColor(InputBut, lightDarkColor);
    }//GEN-LAST:event_InputButMouseEntered

    private void InputButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InputButMouseExited
        exiting(InputBut, lightColor);
    }//GEN-LAST:event_InputButMouseExited

    private void InputButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InputButMouseClicked
        HidingMenuInputs.setVisible(hiddenInputs);
        if (!hiddenOutputs || !hiddenCleaning || !hiddenCalc) {
            hiddenOutputs = hideMenus(hiddenOutputs, HidingMenuOutputs, ResultBut, lightColor, resultLabel, "/Icons/result.png");
            hiddenCleaning = hideMenus(hiddenCleaning, HidingMenuCleaning, CleanBut, lightColor, cleanLabel, "/Icons/rubber.png");
            hiddenCalc = hideMenus(hiddenCalc, HidingMenuInputs, CalcBut, lightColor, calcLabel, "/Icons/calc.png");
        }
        if (hiddenInputs) {
            hiddenInputs = showHideMenu(HidingMenuInputs, InputBut, hiddenInputs, innLabel, "/Icons/close-edit.png");
        } else {
            hiddenInputs = showHideMenu(HidingMenuInputs, InputBut, hiddenInputs, innLabel, "/Icons/inputs.png");
        }
        setItemUnactive();
        SwingUtilities.updateComponentTreeUI(this);
    }//GEN-LAST:event_InputButMouseClicked

    private void ResultButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResultButMouseEntered
        changeColor(ResultBut, lightDarkColor);
    }//GEN-LAST:event_ResultButMouseEntered

    private void ResultButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResultButMouseExited
        exiting(ResultBut, lightColor);
    }//GEN-LAST:event_ResultButMouseExited

    private void ResultButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResultButMouseClicked
        HidingMenuOutputs.setVisible(hiddenOutputs);
        if (!hiddenInputs || !hiddenCleaning || !hiddenCalc) {
            hiddenInputs = hideMenus(hiddenInputs, HidingMenuInputs, InputBut, lightColor, innLabel, "/Icons/inputs.png");
            hiddenCleaning = hideMenus(hiddenCleaning, HidingMenuCleaning, CleanBut, lightColor, cleanLabel, "/Icons/rubber.png");
            hiddenCalc = hideMenus(hiddenCalc, HidingMenuInputs, CalcBut, lightColor, calcLabel, "/Icons/calc.png");
        }
        if (hiddenOutputs) {
            hiddenOutputs = showHideMenu(HidingMenuOutputs, ResultBut, hiddenOutputs, resultLabel, "/Icons/close-edit.png");
        } else {
            hiddenOutputs = showHideMenu(HidingMenuOutputs, ResultBut, hiddenOutputs, resultLabel, "/Icons/result.png");
        }
        setItemUnactive();
        SwingUtilities.updateComponentTreeUI(this);
    }//GEN-LAST:event_ResultButMouseClicked

    private void SettingButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SettingButMouseEntered
        changeColor(SettingBut, lightDarkColor);
    }//GEN-LAST:event_SettingButMouseEntered

    private void SettingButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SettingButMouseExited
        exiting(SettingBut, lightColor);
    }//GEN-LAST:event_SettingButMouseExited

    private void SettingButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SettingButMouseClicked
        OpenView(Settings);
        ShowingViewBackground(SettingBut, 1);
    }//GEN-LAST:event_SettingButMouseClicked

    private void HelpButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HelpButMouseEntered
        changeColor(HelpBut, lightDarkColor);
    }//GEN-LAST:event_HelpButMouseEntered

    private void HelpButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HelpButMouseExited
        exiting(HelpBut, lightColor);
    }//GEN-LAST:event_HelpButMouseExited

    private void HelpButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HelpButMouseClicked
        OpenView(Help);
        ShowingViewBackground(HelpBut, 1);
    }//GEN-LAST:event_HelpButMouseClicked

    private void InRatioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InRatioMouseClicked
        OpenView(RatioIn);
        ShowingViewBackground(InRatio, 0);
    }//GEN-LAST:event_InRatioMouseClicked

    private void InRatioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InRatioMouseEntered
        changeColor(InRatio, darkLightColor);
    }//GEN-LAST:event_InRatioMouseEntered

    private void InRatioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InRatioMouseExited
        exiting(InRatio, lightDarkColor);
    }//GEN-LAST:event_InRatioMouseExited

    private void InDDMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InDDMMouseClicked
        OpenView(DDMIn);
        ShowingViewBackground(InDDM, 0);
    }//GEN-LAST:event_InDDMMouseClicked

    private void InDDMMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InDDMMouseEntered
        changeColor(InDDM, darkLightColor);
    }//GEN-LAST:event_InDDMMouseEntered

    private void InDDMMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InDDMMouseExited
        exiting(InDDM, lightDarkColor);
    }//GEN-LAST:event_InDDMMouseExited

    private void InGrahamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InGrahamMouseClicked
        OpenView(GrahamIn);
        ShowingViewBackground(InGraham, 0);
    }//GEN-LAST:event_InGrahamMouseClicked

    private void InGrahamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InGrahamMouseEntered
        changeColor(InGraham, darkLightColor);
    }//GEN-LAST:event_InGrahamMouseEntered

    private void InGrahamMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InGrahamMouseExited
        exiting(InGraham, lightDarkColor);
    }//GEN-LAST:event_InGrahamMouseExited

    private void InfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InfoMouseClicked
        OpenView(InfoIn);
        ShowingViewBackground(Info, 0);
    }//GEN-LAST:event_InfoMouseClicked

    private void InfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InfoMouseEntered
        changeColor(Info, darkLightColor);
    }//GEN-LAST:event_InfoMouseEntered

    private void InfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InfoMouseExited
        exiting(Info, lightDarkColor);
    }//GEN-LAST:event_InfoMouseExited

    private void InNAVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InNAVMouseClicked
        OpenView(NAVIn);
        ShowingViewBackground(InNAV, 0);
    }//GEN-LAST:event_InNAVMouseClicked

    private void InNAVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InNAVMouseEntered
        changeColor(InNAV, darkLightColor);
    }//GEN-LAST:event_InNAVMouseEntered

    private void InNAVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InNAVMouseExited
        exiting(InNAV, lightDarkColor);
    }//GEN-LAST:event_InNAVMouseExited

    private void OutSummaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutSummaryMouseClicked
        OpenView(SummaryOut);
        ShowingViewBackground(OutSummary, 0);
    }//GEN-LAST:event_OutSummaryMouseClicked

    private void OutSummaryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutSummaryMouseEntered
        changeColor(OutSummary, darkLightColor);
    }//GEN-LAST:event_OutSummaryMouseEntered

    private void OutSummaryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutSummaryMouseExited
        exiting(OutSummary, lightDarkColor);
    }//GEN-LAST:event_OutSummaryMouseExited

    private void OutRatioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutRatioMouseClicked
        OpenView(RatioOut);
        ShowingViewBackground(OutRatio, 0);
    }//GEN-LAST:event_OutRatioMouseClicked

    private void OutRatioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutRatioMouseEntered
        changeColor(OutRatio, darkLightColor);
    }//GEN-LAST:event_OutRatioMouseEntered

    private void OutRatioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutRatioMouseExited
        exiting(OutRatio, lightDarkColor);
    }//GEN-LAST:event_OutRatioMouseExited

    private void OutDCFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutDCFMouseClicked
        OpenView(DCFOut);
        ShowingViewBackground(OutDCF, 0);
    }//GEN-LAST:event_OutDCFMouseClicked

    private void OutDCFMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutDCFMouseEntered
        changeColor(OutDCF, darkLightColor);
    }//GEN-LAST:event_OutDCFMouseEntered

    private void OutDCFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutDCFMouseExited
        exiting(OutDCF, lightDarkColor);
    }//GEN-LAST:event_OutDCFMouseExited

    private void OutDDMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutDDMMouseClicked
        OpenView(DDMOut);
        ShowingViewBackground(OutDDM, 0);
    }//GEN-LAST:event_OutDDMMouseClicked

    private void OutDDMMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutDDMMouseEntered
        changeColor(OutDDM, darkLightColor);
    }//GEN-LAST:event_OutDDMMouseEntered

    private void OutDDMMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutDDMMouseExited
        exiting(OutDDM, lightDarkColor);
    }//GEN-LAST:event_OutDDMMouseExited

    private void OutGrahamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutGrahamMouseClicked
        OpenView(GrahamOut);
        ShowingViewBackground(OutGraham, 0);
    }//GEN-LAST:event_OutGrahamMouseClicked

    private void OutGrahamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutGrahamMouseEntered
        changeColor(OutGraham, darkLightColor);
    }//GEN-LAST:event_OutGrahamMouseEntered

    private void OutGrahamMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutGrahamMouseExited
        exiting(OutGraham, lightDarkColor);
    }//GEN-LAST:event_OutGrahamMouseExited

    private void OutNAVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutNAVMouseClicked
        OpenView(NAVOut);
        ShowingViewBackground(OutNAV, 0);
    }//GEN-LAST:event_OutNAVMouseClicked

    private void OutNAVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutNAVMouseEntered
        changeColor(OutNAV, darkLightColor);
    }//GEN-LAST:event_OutNAVMouseEntered

    private void OutNAVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OutNAVMouseExited
        exiting(OutNAV, lightDarkColor);
    }//GEN-LAST:event_OutNAVMouseExited

    private void CleanButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanButMouseClicked
        HidingMenuCleaning.setVisible(hiddenCleaning);
        if (!hiddenInputs || !hiddenOutputs || !hiddenCalc) {
            hiddenOutputs = hideMenus(hiddenOutputs, HidingMenuOutputs, ResultBut, lightColor, resultLabel, "/Icons/result.png");
            hiddenInputs = hideMenus(hiddenInputs, HidingMenuInputs, InputBut, lightColor, innLabel, "/Icons/inputs.png");
            hiddenCalc = hideMenus(hiddenCalc, HidingMenuInputs, CalcBut, lightColor, calcLabel, "/Icons/calc.png");
        }
        if (hiddenCleaning) {
            hiddenCleaning = showHideMenu(HidingMenuCleaning, CleanBut, hiddenCleaning, cleanLabel, "/Icons/close-edit.png");
        } else {
            hiddenCleaning = showHideMenu(HidingMenuCleaning, CleanBut, hiddenCleaning, cleanLabel, "/Icons/rubber.png");
        }
        setItemUnactive();
        SwingUtilities.updateComponentTreeUI(this);
    }//GEN-LAST:event_CleanButMouseClicked

    private void CleanButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanButMouseEntered
        changeColor(CleanBut, lightDarkColor);
    }//GEN-LAST:event_CleanButMouseEntered

    private void CleanButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanButMouseExited
        exiting(CleanBut, lightColor);
    }//GEN-LAST:event_CleanButMouseExited

    private void SaveButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveButMouseClicked
        OpenView(Save);
        ShowingViewBackground(SaveBut, 1);
    }//GEN-LAST:event_SaveButMouseClicked

    private void SaveButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveButMouseEntered
        changeColor(SaveBut, lightDarkColor);
    }//GEN-LAST:event_SaveButMouseEntered

    private void SaveButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveButMouseExited
        exiting(SaveBut, lightColor);
    }//GEN-LAST:event_SaveButMouseExited

    private void LibraryButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LibraryButMouseClicked
        OpenView(Library);
        ShowingViewBackground(LibraryBut, 1);
    }//GEN-LAST:event_LibraryButMouseClicked

    private void LibraryButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LibraryButMouseEntered
        changeColor(LibraryBut, lightDarkColor);
    }//GEN-LAST:event_LibraryButMouseEntered

    private void LibraryButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LibraryButMouseExited
        exiting(LibraryBut, lightColor);
    }//GEN-LAST:event_LibraryButMouseExited

    private void CalcButMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalcButMouseClicked
        HidingMenuCalculation.setVisible(hiddenCalc);
        if (!hiddenInputs || !hiddenOutputs || !hiddenCleaning) {
            hiddenOutputs = hideMenus(hiddenOutputs, HidingMenuOutputs, ResultBut, lightColor, resultLabel, "/Icons/result.png");
            hiddenInputs = hideMenus(hiddenInputs, HidingMenuInputs, InputBut, lightColor, innLabel, "/Icons/inputs.png");
            hiddenCleaning = hideMenus(hiddenCleaning, HidingMenuCleaning, CleanBut, lightColor, cleanLabel, "/Icons/rubber.png");
        }
        if (hiddenCalc) {
            hiddenCalc = showHideMenu(HidingMenuCalculation, CalcBut, hiddenCalc, calcLabel, "/Icons/close-edit.png");
        } else {
            hiddenCalc = showHideMenu(HidingMenuCalculation, CalcBut, hiddenCalc, calcLabel, "/Icons/calc.png");
        }
        setItemUnactive();
        SwingUtilities.updateComponentTreeUI(this);
    }//GEN-LAST:event_CalcButMouseClicked

    private void CalcButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalcButMouseEntered
        changeColor(CalcBut, lightDarkColor);
    }//GEN-LAST:event_CalcButMouseEntered

    private void CalcButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalcButMouseExited
        exiting(CalcBut, lightColor);
    }//GEN-LAST:event_CalcButMouseExited

    private void CleanAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanAllMouseClicked
        chooseCleaning(CleanAll);
    }//GEN-LAST:event_CleanAllMouseClicked

    private void CleanAllMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanAllMouseEntered
        changeColor(CleanAll, darkLightColor);
    }//GEN-LAST:event_CleanAllMouseEntered

    private void CleanAllMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanAllMouseExited
        exiting(CleanAll, lightDarkColor);
    }//GEN-LAST:event_CleanAllMouseExited

    private void CleanInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanInfoMouseClicked
        chooseCleaning(CleanInfo);
    }//GEN-LAST:event_CleanInfoMouseClicked

    private void CleanInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanInfoMouseEntered
        changeColor(CleanInfo, darkLightColor);
    }//GEN-LAST:event_CleanInfoMouseEntered

    private void CleanInfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanInfoMouseExited
        exiting(CleanInfo, lightDarkColor);
    }//GEN-LAST:event_CleanInfoMouseExited

    private void CleanRatioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanRatioMouseClicked
        chooseCleaning(CleanRatio);
    }//GEN-LAST:event_CleanRatioMouseClicked

    private void CleanRatioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanRatioMouseEntered
        changeColor(CleanRatio, darkLightColor);
    }//GEN-LAST:event_CleanRatioMouseEntered

    private void CleanRatioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanRatioMouseExited
        exiting(CleanRatio, lightDarkColor);
    }//GEN-LAST:event_CleanRatioMouseExited

    private void CleanDCFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanDCFMouseClicked
        chooseCleaning(CleanDCF);
    }//GEN-LAST:event_CleanDCFMouseClicked

    private void CleanDCFMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanDCFMouseEntered
        changeColor(CleanDCF, darkLightColor);
    }//GEN-LAST:event_CleanDCFMouseEntered

    private void CleanDCFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanDCFMouseExited
        exiting(CleanDCF, lightDarkColor);
    }//GEN-LAST:event_CleanDCFMouseExited

    private void CleanDDMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanDDMMouseClicked
        chooseCleaning(CleanDDM);
    }//GEN-LAST:event_CleanDDMMouseClicked

    private void CleanDDMMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanDDMMouseEntered
        changeColor(CleanDDM, darkLightColor);
    }//GEN-LAST:event_CleanDDMMouseEntered

    private void CleanDDMMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanDDMMouseExited
        exiting(CleanDDM, lightDarkColor);
    }//GEN-LAST:event_CleanDDMMouseExited

    private void CleanGrahamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanGrahamMouseClicked
        chooseCleaning(CleanGraham);
    }//GEN-LAST:event_CleanGrahamMouseClicked

    private void CleanGrahamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanGrahamMouseEntered
        changeColor(CleanGraham, darkLightColor);
    }//GEN-LAST:event_CleanGrahamMouseEntered

    private void CleanGrahamMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanGrahamMouseExited
        exiting(CleanGraham, lightDarkColor);
    }//GEN-LAST:event_CleanGrahamMouseExited

    private void CleanNAVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanNAVMouseClicked
        chooseCleaning(CleanNAV);
    }//GEN-LAST:event_CleanNAVMouseClicked

    private void CleanNAVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanNAVMouseEntered
        changeColor(CleanNAV, darkLightColor);
    }//GEN-LAST:event_CleanNAVMouseEntered

    private void CleanNAVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanNAVMouseExited
        exiting(CleanNAV, lightDarkColor);
    }//GEN-LAST:event_CleanNAVMouseExited

    private void CleanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanMouseClicked
        controller.clean(cleaningChoices);
        cleaningChoices.clear();
        SwingUtilities.updateComponentTreeUI(this);
    }//GEN-LAST:event_CleanMouseClicked

    private void CalcRatioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalcRatioMouseClicked
        chooseCalculation(CalcRatio);
    }//GEN-LAST:event_CalcRatioMouseClicked

    private void CalcRatioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalcRatioMouseEntered
        changeColor(CalcRatio, darkLightColor);
    }//GEN-LAST:event_CalcRatioMouseEntered

    private void CalcRatioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalcRatioMouseExited
        exiting(CalcRatio, lightDarkColor);
    }//GEN-LAST:event_CalcRatioMouseExited

    private void CalcDCFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalcDCFMouseClicked
        chooseCalculation(CalcDCF);
    }//GEN-LAST:event_CalcDCFMouseClicked

    private void CalcDCFMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalcDCFMouseEntered
        changeColor(CalcDCF, darkLightColor);
    }//GEN-LAST:event_CalcDCFMouseEntered

    private void CalcDCFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalcDCFMouseExited
        exiting(CalcDCF, lightDarkColor);
    }//GEN-LAST:event_CalcDCFMouseExited

    private void CalcDDMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalcDDMMouseClicked
        chooseCalculation(CalcDDM);
    }//GEN-LAST:event_CalcDDMMouseClicked

    private void CalcDDMMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalcDDMMouseEntered
        changeColor(CalcDDM, darkLightColor);
    }//GEN-LAST:event_CalcDDMMouseEntered

    private void CalcDDMMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalcDDMMouseExited
        exiting(CalcDDM, lightDarkColor);
    }//GEN-LAST:event_CalcDDMMouseExited

    private void CalcGrahamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalcGrahamMouseClicked
        chooseCalculation(CalcGraham);
    }//GEN-LAST:event_CalcGrahamMouseClicked

    private void CalcGrahamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalcGrahamMouseEntered
        changeColor(CalcGraham, darkLightColor);
    }//GEN-LAST:event_CalcGrahamMouseEntered

    private void CalcGrahamMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalcGrahamMouseExited
        exiting(CalcGraham, lightDarkColor);
    }//GEN-LAST:event_CalcGrahamMouseExited

    private void CalcNAVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalcNAVMouseClicked
        chooseCalculation(CalcNAV);
    }//GEN-LAST:event_CalcNAVMouseClicked

    private void CalcNAVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalcNAVMouseEntered
        changeColor(CalcNAV, darkLightColor);
    }//GEN-LAST:event_CalcNAVMouseEntered

    private void CalcNAVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalcNAVMouseExited
        exiting(CalcNAV, lightDarkColor);
    }//GEN-LAST:event_CalcNAVMouseExited

    private void CalcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalcMouseClicked
        controller.calculation(calcChoices);
        calcChoices.clear();
        SwingUtilities.updateComponentTreeUI(this);
    }//GEN-LAST:event_CalcMouseClicked

    private void InDCFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InDCFMouseClicked
        OpenView(DCFIn);
        ShowingViewBackground(InDCF, 0);
    }//GEN-LAST:event_InDCFMouseClicked

    private void InDCFMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InDCFMouseEntered
        changeColor(InDCF, darkLightColor);
    }//GEN-LAST:event_InDCFMouseEntered

    private void InDCFMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InDCFMouseExited
        exiting(InDCF, lightDarkColor);
    }//GEN-LAST:event_InDCFMouseExited

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try {
            langs.setLastLang(LangChoice.getSelectedIndex());
        } catch (IOException ex) {
            Logger.getLogger(ReworkedFrontend.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            setLabels(langs.getRoute());
        } catch (IOException ex) {
            Logger.getLogger(ReworkedFrontend.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            setLabels(langs.getRoute());
        } catch (IOException ex) {
            Logger.getLogger(ReworkedFrontend.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void TRevenue2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TRevenue2KeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_TRevenue2KeyTyped

    private void CofRevenue2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CofRevenue2KeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_CofRevenue2KeyTyped

    private void OpExpense2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_OpExpense2KeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_OpExpense2KeyTyped

    private void OthIncome2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_OthIncome2KeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_OthIncome2KeyTyped

    private void NIncome2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NIncome2KeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_NIncome2KeyTyped

    private void EBIT2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EBIT2KeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_EBIT2KeyTyped

    private void ComDiv2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComDiv2KeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_ComDiv2KeyTyped

    private void Taxes2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Taxes2KeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_Taxes2KeyTyped

    private void IntExp2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IntExp2KeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_IntExp2KeyTyped

    private void TAssets2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TAssets2KeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_TAssets2KeyTyped

    private void CurAssets2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CurAssets2KeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_CurAssets2KeyTyped

    private void Receivable2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Receivable2KeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_Receivable2KeyTyped

    private void Inv2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Inv2KeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_Inv2KeyTyped

    private void TLiabilities2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TLiabilities2KeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_TLiabilities2KeyTyped

    private void CurLiabilities2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CurLiabilities2KeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_CurLiabilities2KeyTyped

    private void TEGMI2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TEGMI2KeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_TEGMI2KeyTyped

    private void SHEquity2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SHEquity2KeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_SHEquity2KeyTyped

    private void CapLO2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CapLO2KeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_CapLO2KeyTyped

    private void TanBookVal2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TanBookVal2KeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_TanBookVal2KeyTyped

    private void OrShNum2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_OrShNum2KeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_OrShNum2KeyTyped

    private void EPSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EPSKeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_EPSKeyTyped

    private void GRGrahamInnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GRGrahamInnKeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_GRGrahamInnKeyTyped

    private void YKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_YKeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_YKeyTyped

    private void ActPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ActPriceKeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_ActPriceKeyTyped

    private void Pillow2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Pillow2KeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_Pillow2KeyTyped

    private void TotalAssetsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TotalAssetsKeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_TotalAssetsKeyTyped

    private void TotalLiabKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TotalLiabKeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_TotalLiabKeyTyped

    private void SharesOutKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SharesOutKeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_SharesOutKeyTyped

    private void WACCDDMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_WACCDDMKeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_WACCDDMKeyTyped

    private void GR3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GR3KeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_GR3KeyTyped

    private void WACCDCFInnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_WACCDCFInnKeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_WACCDCFInnKeyTyped

    private void ActFCF2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ActFCF2KeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_ActFCF2KeyTyped

    private void Debt2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Debt2KeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_Debt2KeyTyped

    private void Shares2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Shares2KeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_Shares2KeyTyped

    private void CandC2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CandC2KeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_CandC2KeyTyped

    private void State2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_State2KeyTyped
        keyCheck(evt);
    }//GEN-LAST:event_State2KeyTyped

    private void NotesFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NotesFieldKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isAlphabetic(c) && !Character.isDigit(c) && c != ' ' && c != ',') {
            evt.consume();
        }
    }//GEN-LAST:event_NotesFieldKeyTyped

    private void StockExchFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_StockExchFieldKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isAlphabetic(c) && !Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_StockExchFieldKeyTyped

    private void CorpStickerFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CorpStickerFieldKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isAlphabetic(c) && !Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_CorpStickerFieldKeyTyped

    private void CorpNameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CorpNameFieldKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isAlphabetic(c) && !Character.isDigit(c) && c != ' ' && c != ',' && c != '.') {
            evt.consume();
        }
    }//GEN-LAST:event_CorpNameFieldKeyTyped

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReworkedFrontend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReworkedFrontend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReworkedFrontend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReworkedFrontend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new ReworkedFrontend().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(ReworkedFrontend.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ActFCF2;
    private javax.swing.JTextField ActPrice;
    private javax.swing.JTextField ActPriceAns;
    private javax.swing.JTextField ActPriceDCF;
    private javax.swing.JTextField ActPriceDDM;
    private javax.swing.JTextField ActPriceGraham;
    private javax.swing.JTextField ActPriceNAV;
    private javax.swing.JTextField AvGRDCF;
    private javax.swing.JTextField AvGRDDM;
    private javax.swing.JTextField CLiq;
    private javax.swing.JPanel Calc;
    private javax.swing.JPanel CalcBut;
    private javax.swing.JPanel CalcDCF;
    private javax.swing.JPanel CalcDDM;
    private javax.swing.JPanel CalcGraham;
    private javax.swing.JPanel CalcNAV;
    private javax.swing.JPanel CalcRatio;
    private javax.swing.JTextField CandC2;
    private javax.swing.JTextField CapLO2;
    private javax.swing.JTextField CashDCF;
    private javax.swing.JPanel Clean;
    private javax.swing.JPanel CleanAll;
    private javax.swing.JPanel CleanBut;
    private javax.swing.JPanel CleanDCF;
    private javax.swing.JPanel CleanDDM;
    private javax.swing.JPanel CleanGraham;
    private javax.swing.JPanel CleanInfo;
    private javax.swing.JPanel CleanNAV;
    private javax.swing.JPanel CleanRatio;
    private javax.swing.JLabel CleaningBut;
    private javax.swing.JLabel CleaningBut1;
    private javax.swing.JTextField CofRevenue2;
    private javax.swing.JTextField ComDiv2;
    private javax.swing.JTextField CorpNameField;
    private javax.swing.JTextField CorpStickerField;
    private javax.swing.JTextField CurAssets2;
    private javax.swing.JTextField CurLiabilities2;
    private javax.swing.JTextField DCFAns;
    private javax.swing.JPanel DCFIn;
    private javax.swing.JTextField DCFMoSAns;
    private javax.swing.JPanel DCFOut;
    private javax.swing.JTextField DDMAns;
    private javax.swing.JPanel DDMIn;
    private javax.swing.JTextField DDMMoSAns;
    private javax.swing.JPanel DDMOut;
    private javax.swing.JTextField Debt2;
    private javax.swing.JTextField DebtDCF;
    private javax.swing.JTextField Diff;
    private javax.swing.JTable Dividends;
    private javax.swing.JTable DividendsPrediction;
    private javax.swing.JTextField DpE;
    private javax.swing.JTextField EBIT2;
    private javax.swing.JTextField EPS;
    private javax.swing.JTextField EPSGraham;
    private javax.swing.JTextField EPSGrahamRev;
    private javax.swing.JTextField EPSRatio;
    private javax.swing.JTextField EVDCF;
    private javax.swing.JTextField EndGraham;
    private javax.swing.JTextField EndGrahamMoS;
    private javax.swing.JTextField EndGrahamRev;
    private javax.swing.JTextField EndGrahamRevMoS;
    private javax.swing.JTable FCF2;
    private javax.swing.JTable FutureFCF;
    private javax.swing.JTextField GM;
    private javax.swing.JTextField GR3;
    private javax.swing.JTextField GRDCF;
    private javax.swing.JTextField GRGraham;
    private javax.swing.JTextField GRGrahamInn;
    private javax.swing.JTextField GRGrahamRev;
    private javax.swing.JTextField GrahamAns;
    private javax.swing.JPanel GrahamIn;
    private javax.swing.JTextField GrahamMoSAns;
    private javax.swing.JPanel GrahamOut;
    private javax.swing.JTextField GrahamRevAns;
    private javax.swing.JTextField GrahamRevMoSAns;
    private javax.swing.JPanel Help;
    private javax.swing.JPanel HelpBut;
    private javax.swing.JPanel HidingMenuCalculation;
    private javax.swing.JPanel HidingMenuCleaning;
    private javax.swing.JPanel HidingMenuInputs;
    private javax.swing.JPanel HidingMenuOutputs;
    private javax.swing.JTextField IdealPrice;
    private javax.swing.JTextField IdealPriceMoS;
    private javax.swing.JPanel InDCF;
    private javax.swing.JPanel InDDM;
    private javax.swing.JPanel InGraham;
    private javax.swing.JPanel InNAV;
    private javax.swing.JPanel InRatio;
    private javax.swing.JTextField Indebtedness;
    private javax.swing.JPanel Info;
    private javax.swing.JPanel InfoIn;
    private javax.swing.JPanel InputBut;
    private javax.swing.JTextField IntExp2;
    private javax.swing.JTextField Inv2;
    private javax.swing.JTextField InventoryTime;
    private javax.swing.JComboBox<String> LangChoice;
    private javax.swing.JTable LastFCF;
    private javax.swing.JTextField LiabilitiesTime;
    private javax.swing.JPanel Library;
    private javax.swing.JPanel LibraryBut;
    private javax.swing.JPanel LocalizatorCalculating;
    private javax.swing.JPanel LocalizatorCleaning;
    private javax.swing.JPanel LocalizatorIn;
    private javax.swing.JPanel LocalizatorOut;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel MenuColumn;
    private javax.swing.JTextField NAVAns;
    private javax.swing.JPanel NAVIn;
    private javax.swing.JTextField NAVMoSAns;
    private javax.swing.JPanel NAVOut;
    private javax.swing.JTextField NIncome2;
    private javax.swing.JTextField NotesField;
    private javax.swing.JTextField OM;
    private javax.swing.JTextField OpExpense2;
    private javax.swing.JTextField OrShNum2;
    private javax.swing.JTextField OthIncome2;
    private javax.swing.JPanel OutDCF;
    private javax.swing.JPanel OutDDM;
    private javax.swing.JPanel OutGraham;
    private javax.swing.JPanel OutNAV;
    private javax.swing.JPanel OutRatio;
    private javax.swing.JPanel OutSummary;
    private javax.swing.JTextField PayOut;
    private javax.swing.JTextField Pillow2;
    private javax.swing.JTextField PillowAns;
    private javax.swing.JTextField PillowDCF;
    private javax.swing.JTextField PillowDDM;
    private javax.swing.JTextField PillowGraham;
    private javax.swing.JTextField PillowNAV;
    private javax.swing.JTextField PpB;
    private javax.swing.JTextField PpE;
    private javax.swing.JTextField PriceDCF;
    private javax.swing.JTextField PriceDCFMoS;
    private javax.swing.JTextField PriceDDM;
    private javax.swing.JTextField PriceDDMMoS;
    private javax.swing.JTextField PriceNAV;
    private javax.swing.JTextField PriceNAVMoS;
    private javax.swing.JTextField RN;
    private javax.swing.JTextField ROA;
    private javax.swing.JTextField ROE;
    private javax.swing.JTextField ROS;
    private javax.swing.JPanel RatioIn;
    private javax.swing.JPanel RatioOut;
    private javax.swing.JTextField Receivable2;
    private javax.swing.JTextField ReceivablesTime;
    private javax.swing.JPanel ResultBut;
    private javax.swing.JTextField SHEquity2;
    private javax.swing.JPanel Save;
    private javax.swing.JPanel SaveBut;
    private javax.swing.JPanel SettingBut;
    private javax.swing.JPanel Settings;
    private javax.swing.JTextField Shares2;
    private javax.swing.JTextField SharesDCF;
    private javax.swing.JTextField SharesNAV;
    private javax.swing.JTextField SharesOut;
    private javax.swing.JPanel Space0;
    private javax.swing.JPanel Space1;
    private javax.swing.JTextField State2;
    private javax.swing.JTextField StateDCF;
    private javax.swing.JTextField StockExchField;
    private javax.swing.JTextField SumFCFDCF;
    private javax.swing.JTextField SumSticker;
    private javax.swing.JPanel SummaryOut;
    private javax.swing.JTextField TAssets2;
    private javax.swing.JTextField TEGMI2;
    private javax.swing.JTextField TLiabilities2;
    private javax.swing.JTextField TRevenue2;
    private javax.swing.JTextField TanBookVal2;
    private javax.swing.JTextField Taxes2;
    private javax.swing.JTextField TotalAssets;
    private javax.swing.JTextField TotalAssetsNAV;
    private javax.swing.JTextField TotalLiab;
    private javax.swing.JTextField TotalLiabilitiesNAV;
    private javax.swing.JLabel ViewDCFIn;
    private javax.swing.JLabel ViewDDMIn;
    private javax.swing.JLabel ViewGrahamIn;
    private javax.swing.JLabel ViewInfo;
    private javax.swing.JLabel ViewNAVIn;
    private javax.swing.JLabel ViewRatioIn;
    private javax.swing.JTextField WACCDCFInn;
    private javax.swing.JTextField WACCDCFOut;
    private javax.swing.JTextField WACCDDM;
    private javax.swing.JTextField WACCDDMOut;
    private javax.swing.JPanel WelcomePanel;
    private javax.swing.JTextField Y;
    private javax.swing.JTextField YGraham;
    private javax.swing.JTextField YGrahamRev;
    private javax.swing.JLabel calcLabel;
    private javax.swing.JLabel cleanLabel;
    private javax.swing.JLabel helpLabel;
    private javax.swing.JLabel innLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel208;
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel211;
    private javax.swing.JLabel jLabel212;
    private javax.swing.JLabel jLabel213;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel216;
    private javax.swing.JLabel jLabel217;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel79;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel jPanel82;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel87;
    private javax.swing.JPanel jPanel92;
    private javax.swing.JPanel jPanel93;
    private javax.swing.JPanel jPanel94;
    private javax.swing.JPanel jPanel95;
    private javax.swing.JPanel jPanel96;
    private javax.swing.JPanel jPanel97;
    private javax.swing.JPanel jPanel98;
    private javax.swing.JPanel jPanel99;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JLabel setttingLabel;
    private javax.swing.JLabel viewCalcRatio;
    private javax.swing.JLabel viewDCFVal;
    private javax.swing.JLabel viewDDMVal;
    private javax.swing.JLabel viewGrahamVal;
    private javax.swing.JLabel viewNAVVal;
    private javax.swing.JLabel viewValSum;
    // End of variables declaration//GEN-END:variables

    public void keyCheck(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != ',' && c != '.') {
            evt.consume();
        }
    }

    /**
     *
     * @return
     */
    public JTable getFCF() {
        return FCF2;
    }

    /**
     *
     * @return
     */
    public JTable getDividends() {
        return Dividends;
    }

    /**
     *
     * @return
     */
    public JTable getDividendsPrediction() {
        return DividendsPrediction;
    }

    /**
     *
     * @return
     */
    public JTextField getGrahamAns() {
        return GrahamAns;
    }

    /**
     *
     * @return
     */
    public JTextField getGR() {
        return GRGrahamInn;
    }

    /**
     *
     * @return
     */
    public JTextField getYInn() {
        return Y;
    }

    /**
     *
     * @return
     */
    public JTextField getWACCDDMInn() {
        return WACCDDM;
    }

    /**
     *
     * @return
     */
    public JTextField getActFCF() {
        return ActFCF2;
    }

    /**
     *
     * @return
     */
    public JTextField getDebt() {
        return Debt2;
    }

    /**
     *
     * @return
     */
    public JTextField getShares() {
        return Shares2;
    }

    /**
     *
     * @return
     */
    public JTextField getCandC() {
        return CandC2;
    }

    /**
     *
     * @return
     */
    public JTextField getPillow() {
        return Pillow2;
    }

    /**
     *
     * @return
     */
    public JTextField getInv() {
        return Inv2;
    }

    /**
     *
     * @return
     */
    public JTextField getReceivable() {
        return Receivable2;
    }

    /**
     *
     * @return
     */
    public JTextField getCapLO() {
        return CapLO2;
    }

    /**
     *
     * @return
     */
    public JTextField getTEGMI() {
        return TEGMI2;
    }

    /**
     *
     * @return
     */
    public JTextField getEBIT() {
        return EBIT2;
    }

    /**
     *
     * @return
     */
    public JTextField getEPS() {
        return EPS;
    }

    /**
     *
     * @return
     */
    public JTextField getActPrice() {
        return ActPrice;
    }

    /**
     *
     * @return
     */
    public JTextField getComDiv() {
        return ComDiv2;
    }

    /**
     *
     * @return
     */
    public JTextField getTAssets() {
        return TAssets2;
    }

    /**
     *
     * @return
     */
    public JTextField getTLiabilities() {
        return TLiabilities2;
    }

    /**
     *
     * @return
     */
    public JTextField getSHEquity() {
        return SHEquity2;
    }

    /**
     *
     * @return
     */
    public JTextField getTanBookVal() {
        return TanBookVal2;
    }

    /**
     *
     * @return
     */
    public JTextField getCurLiabilities() {
        return CurLiabilities2;
    }

    /**
     *
     * @return
     */
    public JTextField getCurAssets() {
        return CurAssets2;
    }

    /**
     *
     * @return
     */
    public JTextField getOrShNum() {
        return OrShNum2;
    }

    /**
     *
     * @return
     */
    public JTextField getNIncome() {
        return NIncome2;
    }

    /**
     *
     * @return
     */
    public JTextField getTaxes() {
        return Taxes2;
    }

    /**
     *
     * @return
     */
    public JTextField getIntExp() {
        return IntExp2;
    }

    /**
     *
     * @return
     */
    public JTextField getTRevenue() {
        return TRevenue2;
    }

    /**
     *
     * @return
     */
    public JTextField getOthIncome() {
        return OthIncome2;
    }

    /**
     *
     * @return
     */
    public JTextField getCofRevenue() {
        return CofRevenue2;
    }

    /**
     *
     * @return
     */
    public JTextField getOpExpense() {
        return OpExpense2;
    }

    /**
     *
     * @return
     */
    public JTextField getGrahamRevAns() {
        return GrahamRevAns;
    }

    /**
     *
     * @return
     */
    public JTextField getGrahamMoSAns() {
        return GrahamMoSAns;
    }

    /**
     *
     * @return
     */
    public JTextField getGrahamRevMoSAns() {
        return GrahamRevMoSAns;
    }

    /**
     *
     * @return
     */
    public JTextField getDDMMoSAns() {
        return DDMMoSAns;
    }

    /**
     *
     * @return
     */
    public JTextField getDDMAns() {
        return DDMAns;
    }

    /**
     *
     * @return
     */
    public JTextField getDCFMoSAns() {
        return DCFMoSAns;
    }

    /**
     *
     * @return
     */
    public JTextField getDCFAns() {
        return DCFAns;
    }

    /**
     *
     * @return
     */
    public JTextField getIdealPrice() {
        return IdealPrice;
    }

    /**
     *
     * @return
     */
    public JTextField getIdealPriceMoS() {
        return IdealPriceMoS;
    }

    /**
     *
     * @return
     */
    public JTextField getDiff() {
        return Diff;
    }

    /**
     *
     * @return
     */
    public JTextField getActPriceAns() {
        return ActPriceAns;
    }

    /**
     *
     * @return
     */
    public JTextField getActPriceDDM() {
        return ActPriceDDM;
    }

    /**
     *
     * @return
     */
    public JTextField getActPriceGraham() {
        return ActPriceGraham;
    }

    /**
     *
     * @return
     */
    public JTextField getActPriceDCF() {
        return ActPriceDCF;
    }

    /**
     *
     * @return
     */
    public JTextField getPillowAns() {
        return PillowAns;
    }

    /**
     *
     * @return
     */
    public JTextField getPillowDDM() {
        return PillowDDM;
    }

    /**
     *
     * @return
     */
    public JTextField getPillowGraham() {
        return PillowGraham;
    }

    /**
     *
     * @return
     */
    public JTextField getPillowDCF() {
        return PillowDCF;
    }

    /**
     *
     * @return
     */
    public JTextField getEPSGraham() {
        return EPSGraham;
    }

    /**
     *
     * @return
     */
    public JTextField getEPSGrahamRev() {
        return EPSGrahamRev;
    }

    /**
     *
     * @return
     */
    public JTextField getGRGraham() {
        return GRGraham;
    }

    /**
     *
     * @return
     */
    public JTextField getGRGrahamRev() {
        return GRGrahamRev;
    }

    /**
     *
     * @return
     */
    public JTextField getYGraham() {
        return YGraham;
    }

    /**
     *
     * @return
     */
    public JTextField getYGrahamRev() {
        return YGrahamRev;
    }

    /**
     *
     * @return
     */
    public JTextField getEndGraham() {
        return EndGraham;
    }

    /**
     *
     * @return
     */
    public JTextField getEndGrahamRev() {
        return EndGrahamRev;
    }

    /**
     *
     * @return
     */
    public JTextField getEndGrahamMoS() {
        return EndGrahamMoS;
    }

    /**
     *
     * @return
     */
    public JTextField getEndGrahamRevMoS() {
        return EndGrahamRevMoS;
    }

    /**
     *
     * @return
     */
    public JTextField getAvGRDDM() {
        return AvGRDDM;
    }

    /**
     *
     * @return
     */
    public JTextField getWACCDDMOut() {
        return WACCDDMOut;
    }

    /**
     *
     * @return
     */
    public JTextField getPriceDDMMoS() {
        return PriceDDMMoS;
    }

    /**
     *
     * @return
     */
    public JTextField getPriceDDM() {
        return PriceDDM;
    }

    /**
     *
     * @return
     */
    public JTable getLastFCF() {
        return LastFCF;
    }

    /**
     *
     * @return
     */
    public JTextField getGRDCF() {
        return GR3;
    }

    /**
     *
     * @return
     */
    public JTextField getAvGRDCF() {
        return AvGRDCF;
    }

    /**
     *
     * @return
     */
    public JTable getFutureFCF() {
        return FutureFCF;
    }

    /**
     *
     * @return
     */
    public JTextField getStateDCF() {
        return StateDCF;
    }

    /**
     *
     * @return
     */
    public JTextField getWACCDCFOut() {
        return WACCDCFOut;
    }

    /**
     *
     * @return
     */
    public JTextField getCashDCF() {
        return CashDCF;
    }

    /**
     *
     * @return
     */
    public JTextField getDebtDCF() {
        return DebtDCF;
    }

    /**
     *
     * @return
     */
    public JTextField getSharesDCF() {
        return SharesDCF;
    }

    /**
     *
     * @return
     */
    public JTextField getSumFCFDCF() {
        return SumFCFDCF;
    }

    /**
     *
     * @return
     */
    public JTextField getEVDCF() {
        return EVDCF;
    }

    /**
     *
     * @return
     */
    public JTextField getPriceDCF() {
        return PriceDCF;
    }

    /**
     *
     * @return
     */
    public JTextField getPriceDCFMoS() {
        return PriceDCFMoS;
    }

    /**
     *
     * @return
     */
    public JTextField getGM() {
        return GM;
    }

    /**
     *
     * @return
     */
    public JTextField getOM() {
        return OM;
    }

    /**
     *
     * @return
     */
    public JTextField getEPSRatio() {
        return EPSRatio;
    }

    /**
     *
     * @return
     */
    public JTextField getPpE() {
        return PpE;
    }

    /**
     *
     * @return
     */
    public JTextField getCLiq() {
        return CLiq;
    }

    /**
     *
     * @return
     */
    public JTextField getPpB() {
        return PpB;
    }

    /**
     *
     * @return
     */
    public JTextField getDpE() {
        return DpE;
    }

    /**
     *
     * @return
     */
    public JTextField getPayOut() {
        return PayOut;
    }

    /**
     *
     * @return
     */
    public JTextField getROA() {
        return ROA;
    }

    /**
     *
     * @return
     */
    public JTextField getROE() {
        return ROE;
    }

    /**
     *
     * @return
     */
    public JTextField getROS() {
        return ROS;
    }

    /**
     *
     * @return
     */
    public JTextField getRN() {
        return RN;
    }

    /**
     *
     * @return
     */
    public JTextField getIndebtedness() {
        return Indebtedness;
    }

    /**
     *
     * @return
     */
    public JTextField getReceivablesTime() {
        return ReceivablesTime;
    }

    /**
     *
     * @return
     */
    public JTextField getLiabilitiesTime() {
        return LiabilitiesTime;
    }

    /**
     *
     * @return
     */
    public JTextField getInventoryTime() {
        return InventoryTime;
    }

    /**
     *
     * @return
     */
    public JTextField getCorpName() {
        return CorpNameField;
    }

    /**
     *
     * @return
     */
    public JTextField getSticker() {
        return CorpStickerField;
    }

    /**
     *
     * @return
     */
    public JTextField getStockExchange() {
        return StockExchField;
    }

    /**
     *
     * @return
     */
    public JTextField getNotes() {
        return NotesField;
    }

    /**
     *
     * @return
     */
    public JTextField getWACCDCFInn() {
        return WACCDCFInn;
    }

    /**
     *
     * @return
     */
    public JTextField getStateInn() {
        return State2;
    }

    /**
     *
     * @return
     */
    public JTextField getAssets() {
        return TotalAssets;
    }

    /**
     *
     * @return
     */
    public JTextField getLiabilities() {
        return TotalLiab;
    }

    /**
     *
     * @return
     */
    public JTextField getSharesNAV() {
        return SharesOut;
    }

    /**
     *
     * @return
     */
    public JTextField getAssetsNAVOut() {
        return TotalAssetsNAV;
    }

    /**
     *
     * @return
     */
    public JTextField getLiabilitiesNAVOut() {
        return TotalLiabilitiesNAV;
    }

    /**
     *
     * @return
     */
    public JTextField getSharesNAVOut() {
        return SharesNAV;
    }

    /**
     *
     * @return
     */
    public JTextField getActPriceNAV() {
        return ActPriceNAV;
    }

    /**
     *
     * @return
     */
    public JTextField getPillowNAV() {
        return PillowNAV;
    }

    /**
     *
     * @return
     */
    public JTextField getPriceNAV() {
        return PriceNAV;
    }

    /**
     *
     * @return
     */
    public JTextField getPriceNAVMoS() {
        return PriceNAVMoS;
    }

    /**
     *
     * @return
     */
    private void setIconImage(String iconsaccountingico) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
