package Valuator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/*
Pro hlášení chyby:
JOptionPane.showMessageDialog(null, "Text!");
*/

/**
 *
 * @author ondre
 */
public class CentralObject extends javax.swing.JFrame {

    /**
     * Creates new form CentralObject
     */
    private static final DecimalFormat decfor = new DecimalFormat("0.000");

    NumberFormat formatter = new DecimalFormat("#0.0000");
    private double s;
    List<Double> divis;
    List<Double> fcf;
    private double discDDM;
    AdditionalCalculates addons = new AdditionalCalculates(this);
    StockRatios ratios = new StockRatios(this, addons);
    DividendDiscountModel ddm = new DividendDiscountModel(this);
    DiscountedCashFlowModel dcf = new DiscountedCashFlowModel(this);
    GrahamsFormulas graham = new GrahamsFormulas(this);
    
    /**
     *
     */
    public CentralObject() {
        initComponents();
        setTitle("Stock price valuator 1.0");
        decfor.setRoundingMode(RoundingMode.DOWN);
    } 
    /************************Getting input
     * @return s***************************************/
    public List<Double> getFreeCashFlow(){
        fcf = new ArrayList<>();
        for(int coun = 0; coun < FCF.getColumnCount(); coun++){
            if(FCF.getValueAt(0,coun) == null){
                fcf.add(null);
            }else{
                fcf.add(Double.valueOf(FCF.getValueAt(0,coun).toString()));
            }
        }
        return fcf;
    }

    /**
     *
     * @return
     */
    public List<Double> getDividends(){
        divis = new ArrayList();
        for(int count = 0; count < Dividends.getColumnCount(); count++){
            String str = Dividends.getValueAt(0,count).toString();
            divis.add(Double.valueOf(str));
        }
        return divis;
    }

    /**
     *
     * @return
     */
    public double getGrowthRate(){
        if(GR.getText() == null){
            return 0;
        }else{
            return Double.parseDouble(GR.getText());
        }
    }

    /**
     *
     * @return
     */
    public double getAAACurrentYield(){
        if(Y.getText() == null){
            return 0;
        }else{
            return Double.parseDouble(Y.getText());
        }
    }

    /**
     *
     * @return
     */
    public double getDiscountRate(){
        return Double.parseDouble(WACC.getText())/100;
    }

    /**
     *
     * @return
     */
    public double getActualFreeCashFlow(){
        return Double.parseDouble(ActFCF.getText());
    }

    /**
     *
     * @return
     */
    public double getTotalDebt(){
        return Double.parseDouble(Debt.getText());
    }

    /**
     *
     * @return
     */
    public double getSharesOutstanding(){
        return Double.parseDouble(Shares.getText());
    }

    /**
     *
     * @return
     */
    public double getCash(){
        return Double.parseDouble(CandC.getText());
    }

    /**
     *
     * @return
     */
    public double getMarginOfSafety(){
        return Double.parseDouble(Pillow.getText())/100;
    }

    /**
     *
     * @return
     */
    public double getInventory(){
        return Double.parseDouble(Inv.getText());
    }

    /**
     *
     * @return
     */
    public double getReceivable(){
        return Double.parseDouble(Receivable.getText());
    }

    /**
     *
     * @return
     */
    public double getCapitalLeaseObligations(){
        return Double.parseDouble(CapLO.getText());
    }

    /**
     *
     * @return
     */
    public double getTEGMI(){
        return Double.parseDouble(TEGMI.getText());
    }

    /**
     *
     * @return
     */
    public double getEBIT(){
        if(EBIT.getText() == null){
            return addons.calcEbit();
        }else{
            return Double.parseDouble(EBIT.getText());
        }
    }

    /**
     *
     * @return
     */
    public double getEarningsPerShare(){
        if(EPS.getText() == null){
            ratios.earningsPerShare();
            if(ratios.earningsPerShare() == 0){
                return 0;
            }else{
                return ratios.earningsPerShare();
            }
        }else{
            return Double.parseDouble(EPS.getText());
        }
    }

    /**
     *
     * @return
     */
    public double getActualPrice(){
        if(ActPrice.getText() == null){
            return Double.parseDouble(ActPriceInn.getText());
        }else{
            return Double.parseDouble(ActPrice.getText());
        }
    }

    /**
     *
     * @return
     */
    public double getCommonStockDividendPaid(){
        return Double.parseDouble(ComDiv.getText());
    }

    /**
     *
     * @return
     */
    public double getTotalAssets(){
        return Double.parseDouble(TAssets.getText());
    }

    /**
     *
     * @return
     */
    public double getTotalLiabilities(){
        return Double.parseDouble(TLiabilities.getText());
    }

    /**
     *
     * @return
     */
    public double getShareHoldersEquity(){
        return Double.parseDouble(SHEquity.getText());
    }

    /**
     *
     * @return
     */
    public double getTangiableBookValue(){
        return Double.parseDouble(TanBookVal.getText());
    }

    /**
     *
     * @return
     */
    public double getCurrentLiabilities(){
        return Double.parseDouble(CurLiabilities.getText());
    }

    /**
     *
     * @return
     */
    public double getCurrentAssets(){
        return Double.parseDouble(CurAssets.getText());
    }

    /**
     *
     * @return
     */
    public double getOrdinarySharesNumber(){
        return Double.parseDouble(OrShNum.getText());
    }

    /**
     *
     * @return
     */
    public double getNetIncome(){
        return Double.parseDouble(NIncome.getText());
    }

    /**
     *
     * @return
     */
    public double getTaxes(){
        return Double.parseDouble(Taxes.getText());
    }

    /**
     *
     * @return
     */
    public double getInterestExpense(){
        return Double.parseDouble(IntExp.getText());
    }

    /**
     *
     * @return
     */
    public double getTotalRevenue(){
        return Double.parseDouble(TRevenue.getText());
    }

    /**
     *
     * @return
     */
    public double getOtherIncomeExpense(){
        return Double.parseDouble(OthIncome.getText());
    }

    /**
     *
     * @return
     */
    public double getCostOfRevenue(){
        return Double.parseDouble(CofRevenue.getText());
    }

    /**
     *
     * @return
     */
    public double getOperatingExpense(){
        return Double.parseDouble(OpExpense.getText());
    }
    /***************************************Getters***********************************************
     * @return s*/
    public double getDiscontRate(){
        return discDDM;
    }

    /**
     *
     * @return
     */
    public double getStateGrowthRate(){
        return s;
    }
    /****************************************Make Valuation*********************************************
     * @return*/
    public double makeValue(){
        if(ddm.controlDDM() <= 0){
            return (dcf.price() + graham.grahamsSummary())/2;
        }else{
            return (dcf.price() + ddm.controlDDM() + graham.grahamsSummary())/3;
        }
    }
    /**
     *
     * @return
     */
    public double makeValueMoS(){
        return makeValue() - (makeValue() * getMarginOfSafety());
    }
    /**
     *
     * @return
     */
    public double difference(){
        return ((makeValue() - getActualPrice()) / getActualPrice())* 100;
    }
    /****************************************Setting answers and values**********************************************************/
    public void setAnswers(){
        DefaultTableModel DivPredModel = (DefaultTableModel) DividendsPrediction.getModel();
        //Answer
        GrahamAns.setText(String.valueOf(decfor.format(graham.graham())));
        GrahamRevAns.setText(String.valueOf(decfor.format(graham.grahamReversed())));
        GrahamMoSAns.setText(String.valueOf(decfor.format(graham.grahamMoS())));
        GrahamRevMoSAns.setText(String.valueOf(decfor.format(graham.grahamRevMoS())));
        DDMMoSAns.setText(String.valueOf(decfor.format(ddm.ddmMoS())));
        DDMAns.setText(String.valueOf(decfor.format(ddm.controlDDM())));
        DCFMoSAns.setText(String.valueOf(decfor.format(dcf.priceMoS())));
        DCFAns.setText(String.valueOf(decfor.format(dcf.price())));
        IdealPrice.setText(String.valueOf(decfor.format(makeValue())));
        IdealPriceMoS.setText(String.valueOf(decfor.format(makeValueMoS())));
        Diff.setText(String.valueOf(decfor.format(difference())));
        if(difference() < 20 && difference() > -20){
            Ans.setText("Hold - Fair Priced");
        }else{
            if(difference()> 20){
                Ans.setText("Buy - Low Priced");
            }else{
                Ans.setText("Sell - High Priced");
            }
        }
        //Actual Prices
        ActPriceAns.setText(String.valueOf(getActualPrice()));
        ActPriceDDM.setText(String.valueOf(getActualPrice()));
        ActPriceGraham.setText(String.valueOf(getActualPrice()));
        ActPriceDCF.setText(String.valueOf(getActualPrice()));
        //Pillows
        PillowAns.setText(String.valueOf(getMarginOfSafety()*100));
        PillowDDM.setText(String.valueOf(getMarginOfSafety()*100));
        PillowGraham.setText(String.valueOf(getMarginOfSafety()*100));
        PillowDCF.setText(String.valueOf(getMarginOfSafety()*100));
        //Graham List
        EPSGraham.setText(String.valueOf(decfor.format((Double)getEarningsPerShare())));
        EPSGrahamRev.setText(String.valueOf(decfor.format((Double)getEarningsPerShare())));
        GRGraham.setText(String.valueOf(decfor.format(getGrowthRate())));
        GRGrahamRev.setText(String.valueOf(decfor.format(getGrowthRate())));
        YGraham.setText(String.valueOf(decfor.format(getAAACurrentYield())));
        YGrahamRev.setText(String.valueOf(decfor.format(getAAACurrentYield())));
        EndGraham.setText(String.valueOf(decfor.format(graham.graham())));
        EndGrahamRev.setText(String.valueOf(decfor.format(graham.grahamReversed())));
        EndGrahamMoS.setText(String.valueOf(decfor.format(graham.grahamMoS())));
        EndGrahamRevMoS.setText(String.valueOf(decfor.format(graham.grahamRevMoS())));
        //DDM List
        for(int count = 0; count < getDividends().size(); count++){
            DividendsPrediction.setValueAt(getDividends().get(count), 0,count+1);
        }
        for(int count = 0; count < ddm.getYDiv().size(); count++){
            DividendsPrediction.setValueAt(ddm.getYDiv().get(count), 1,count+1);
        }
        for(int count = 0; count < ddm.getGrowthDiv().size(); count++){
            DividendsPrediction.setValueAt(ddm.getGrowthDiv().get(count), 2,count+1);
        }
        DivPredModel.fireTableDataChanged();
        AvGRDDM.setText(String.valueOf(decfor.format(ddm.getAveGrowDDM())));
        WACCDDM.setText(Double.toString(ddm.getDiscDDM(ddm.getAveGrowDDM())));
        PriceDDMMoS.setText(String.valueOf(decfor.format(ddm.ddmMoS())));
        PriceDDM.setText(String.valueOf(decfor.format(ddm.controlDDM())));
        //DCF List
        for(int count = 0; count < getFreeCashFlow().size(); count++){
            LastFCF.setValueAt(getFreeCashFlow().get(count), 0,count+1);
        }
        for(int count = 0; count < dcf.getFCFGR().size(); count++){
            LastFCF.setValueAt(dcf.getFCFGR().get(count), 1,count+1);
        }
        GRDCF.setText(String.valueOf(decfor.format(getGrowthRate())));
        AvGRDCF.setText(String.valueOf(decfor.format(dcf.aveGR())));
        for(int count = 0; count < 13; count++){
            FutureFCF.setValueAt(decfor.format(dcf.getFFCF().get(count)), 1, count+1);
        }
        for(int count = 0; count < 13; count++){
            FutureFCF.setValueAt(decfor.format(dcf.getDFFCF().get(count)), 2, count+1);
        }
        StateDCF.setText(String.valueOf(getStateGrowthRate()));
        WACCDCF.setText(String.valueOf(getDiscountRate()*100));
        CashDCF.setText(String.valueOf(getCash()));
        DebtDCF.setText(String.valueOf(getTotalDebt()));
        SharesDCF.setText(String.valueOf(getSharesOutstanding()));
        SumFCFDCF.setText(String.valueOf(decfor.format(dcf.sumOfDFCF())));
        EVDCF.setText(String.valueOf(decfor.format(dcf.equityDCF())));
        PriceDCF.setText(String.valueOf(decfor.format(dcf.price())));
        PriceDCFMoS.setText(String.valueOf(decfor.format(dcf.priceMoS())));
    }
    public void setRatioAns(){
        GM.setText(String.valueOf(decfor.format(ratios.grossMargin())));
        OM.setText(String.valueOf(decfor.format(ratios.operationMargin())));
        EPSRatio.setText(String.valueOf(decfor.format(ratios.earningsPerShare())));
        PpE.setText(String.valueOf(decfor.format(ratios.pricePerEarnings())));
        CLiq.setText(String.valueOf(decfor.format(ratios.currentLiquidity())));
        PpB.setText(String.valueOf(decfor.format(ratios.pricePerBook())));
        DpE.setText(String.valueOf(decfor.format(ratios.debtPerEquity())));
        PayOut.setText(String.valueOf(decfor.format(ratios.payoutRatio())));
        ROA.setText(String.valueOf(decfor.format(ratios.roa())));
        ROE.setText(String.valueOf(decfor.format(ratios.roe())));
        ROS.setText(String.valueOf(decfor.format(ratios.ros())));
        RN.setText(String.valueOf(decfor.format(ratios.rn())));
        Indebtedness.setText(String.valueOf(decfor.format(ratios.indebtedness())));
        ReceivablesTime.setText(String.valueOf(formatter.format(ratios.recTime())));
        LiabilitiesTime.setText(String.valueOf(decfor.format(ratios.liabTime())));
        InventoryTime.setText(String.valueOf(formatter.format(ratios.invTime())));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        Clear = new javax.swing.JButton();
        Calculate = new javax.swing.JButton();
        jLabel74 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        NoDDM = new javax.swing.JButton();
        SetKnowns = new javax.swing.JButton();
        ClearR = new javax.swing.JButton();
        CalcRatio = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        InputPane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ActPrice = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        EPS = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        GR = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Y = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        WACC = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ActFCF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Debt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Shares = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        CandC = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        States = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        Pillow = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        FCF = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        Dividends = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        InputRatio = new javax.swing.JPanel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        Taxes = new javax.swing.JTextField();
        IntExp = new javax.swing.JTextField();
        jLabel121 = new javax.swing.JLabel();
        EBIT = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        TRevenue = new javax.swing.JTextField();
        jLabel125 = new javax.swing.JLabel();
        NIncome = new javax.swing.JTextField();
        jLabel127 = new javax.swing.JLabel();
        ActPriceInn = new javax.swing.JTextField();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        CurAssets = new javax.swing.JTextField();
        CurLiabilities = new javax.swing.JTextField();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        TEGMI = new javax.swing.JTextField();
        Inv = new javax.swing.JTextField();
        OpExpense = new javax.swing.JTextField();
        CofRevenue = new javax.swing.JTextField();
        OthIncome = new javax.swing.JTextField();
        CapLO = new javax.swing.JTextField();
        TAssets = new javax.swing.JTextField();
        ComDiv = new javax.swing.JTextField();
        SHEquity = new javax.swing.JTextField();
        TLiabilities = new javax.swing.JTextField();
        TanBookVal = new javax.swing.JTextField();
        OrShNum = new javax.swing.JTextField();
        jLabel142 = new javax.swing.JLabel();
        Receivable = new javax.swing.JTextField();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        ValuePane = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        DCFAns = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        DCFMoSAns = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        DDMAns = new javax.swing.JTextField();
        DDMMoSAns = new javax.swing.JTextField();
        GrahamAns = new javax.swing.JTextField();
        GrahamMoSAns = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        ActPriceAns = new javax.swing.JTextField();
        IdealPrice = new javax.swing.JTextField();
        PillowAns = new javax.swing.JTextField();
        IdealPriceMoS = new javax.swing.JTextField();
        Diff = new javax.swing.JTextField();
        Ans = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        GrahamRevAns = new javax.swing.JTextField();
        GrahamRevMoSAns = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        RtioSum = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        GM = new javax.swing.JTextField();
        OM = new javax.swing.JTextField();
        EPSRatio = new javax.swing.JTextField();
        PpE = new javax.swing.JTextField();
        CLiq = new javax.swing.JTextField();
        PpB = new javax.swing.JTextField();
        DpE = new javax.swing.JTextField();
        PayOut = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        Indebtedness = new javax.swing.JTextField();
        ReceivablesTime = new javax.swing.JTextField();
        LiabilitiesTime = new javax.swing.JTextField();
        InventoryTime = new javax.swing.JTextField();
        RN = new javax.swing.JTextField();
        ROS = new javax.swing.JTextField();
        ROE = new javax.swing.JTextField();
        ROA = new javax.swing.JTextField();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        dcfPane = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        LastFCF = new javax.swing.JTable();
        jLabel54 = new javax.swing.JLabel();
        GRDCF = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        AvGRDCF = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        FutureFCF = new javax.swing.JTable();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        StateDCF = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        WACCDCF = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        CashDCF = new javax.swing.JTextField();
        DebtDCF = new javax.swing.JTextField();
        SharesDCF = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        SumFCFDCF = new javax.swing.JTextField();
        EVDCF = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        ActPriceDCF = new javax.swing.JTextField();
        PillowDCF = new javax.swing.JTextField();
        PriceDCFMoS = new javax.swing.JTextField();
        PriceDCF = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        ddmPane = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        DividendsPrediction = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        AvGRDDM = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        WACCDDM = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        PriceDDM = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        PillowDDM = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        ActPriceDDM = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        PriceDDMMoS = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        GrahamPane = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        EPSGraham = new javax.swing.JTextField();
        EPSGrahamRev = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        GRGrahamRev = new javax.swing.JTextField();
        GRGraham = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        YGrahamRev = new javax.swing.JTextField();
        YGraham = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        ActPriceGraham = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        PillowGraham = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        EndGrahamRev = new javax.swing.JTextField();
        EndGraham = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        EndGrahamRevMoS = new javax.swing.JTextField();
        EndGrahamMoS = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        Clear.setText("Clear Valuation");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        Calculate.setText("Calculate Valuation");
        Calculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculateActionPerformed(evt);
            }
        });

        jLabel74.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel74.setText("Stock price");

        jLabel100.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel100.setText("Valuator");

        NoDDM.setText("No Dividends / No DDM");
        NoDDM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoDDMActionPerformed(evt);
            }
        });

        SetKnowns.setText("I'm using Valuation");
        SetKnowns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetKnownsActionPerformed(evt);
            }
        });

        ClearR.setText("Clear Ratio");
        ClearR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearRActionPerformed(evt);
            }
        });

        CalcRatio.setText("Calculate Ratio");
        CalcRatio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalcRatioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(Clear))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(ClearR))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(NoDDM)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel100, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(76, 76, 76))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Calculate)
                            .addComponent(SetKnowns))
                        .addGap(19, 19, 19))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(CalcRatio)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel74)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Calculate)
                .addGap(18, 18, 18)
                .addComponent(CalcRatio)
                .addGap(18, 18, 18)
                .addComponent(SetKnowns)
                .addGap(18, 18, 18)
                .addComponent(NoDDM)
                .addGap(18, 18, 18)
                .addComponent(ClearR)
                .addGap(18, 18, 18)
                .addComponent(Clear)
                .addGap(12, 12, 12))
        );

        jTabbedPane1.setBackground(new java.awt.Color(0, 0, 255));

        jLabel1.setText("Actual Stock Price");

        ActPrice.setBackground(new java.awt.Color(204, 255, 255));

        jLabel2.setText("EPS (TTM)");

        EPS.setBackground(new java.awt.Color(204, 255, 255));

        jLabel3.setText("Growth rate (next 5y)");

        GR.setBackground(new java.awt.Color(204, 255, 255));

        jLabel4.setText("AAA current yield");

        Y.setBackground(new java.awt.Color(204, 255, 255));

        jLabel5.setText("Discount Rate");

        WACC.setBackground(new java.awt.Color(204, 255, 255));

        jLabel6.setText("Actual Free Cash Flow");

        ActFCF.setBackground(new java.awt.Color(204, 255, 255));

        jLabel7.setText("Total Debt");

        Debt.setBackground(new java.awt.Color(204, 255, 255));

        jLabel8.setText("Shares Outstanding");

        Shares.setBackground(new java.awt.Color(204, 255, 255));

        jLabel9.setText("Cash & Cash Equivalents");

        CandC.setBackground(new java.awt.Color(204, 255, 255));

        jLabel10.setText("States Perpentual Growth Rate");

        States.setBackground(new java.awt.Color(204, 255, 255));
        States.setForeground(new java.awt.Color(0, 255, 255));
        States.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                StatesItemStateChanged(evt);
            }
        });

        jLabel11.setText("Margin of Safety");

        Pillow.setBackground(new java.awt.Color(204, 255, 255));

        jLabel12.setText("Make sure, if values are in the same numbers.");

        jLabel13.setText("Dividend Payout");

        FCF.setBackground(new java.awt.Color(204, 255, 255));
        FCF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        FCF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(FCF);

        Dividends.setBackground(new java.awt.Color(204, 255, 255));
        Dividends.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Dividends.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "2018", "2019", "2020", "2021", "2022"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(Dividends);

        jLabel14.setText("Free Cash Flow");

        jLabel75.setText("%");

        jLabel76.setText("%");

        jLabel77.setText("%");

        javax.swing.GroupLayout InputPaneLayout = new javax.swing.GroupLayout(InputPane);
        InputPane.setLayout(InputPaneLayout);
        InputPaneLayout.setHorizontalGroup(
            InputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InputPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(InputPaneLayout.createSequentialGroup()
                            .addGroup(InputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addGroup(InputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ActPrice)
                                    .addComponent(jLabel2)
                                    .addComponent(EPS))
                                .addGroup(InputPaneLayout.createSequentialGroup()
                                    .addGroup(InputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(GR, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Y, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel75)))
                            .addGap(101, 101, 101)
                            .addGroup(InputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel7)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(WACC)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ActFCF)
                                .addComponent(Debt)
                                .addComponent(jLabel8)
                                .addComponent(Shares))
                            .addGroup(InputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(InputPaneLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel76)
                                    .addGap(64, 64, 64)
                                    .addGroup(InputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(InputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(CandC))
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel11)
                                        .addGroup(InputPaneLayout.createSequentialGroup()
                                            .addGroup(InputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(Pillow, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(States, javax.swing.GroupLayout.Alignment.LEADING, 0, 131, Short.MAX_VALUE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel77))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InputPaneLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12))))
                        .addComponent(jLabel13)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 902, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(292, Short.MAX_VALUE))
        );
        InputPaneLayout.setVerticalGroup(
            InputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InputPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ActPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(WACC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CandC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel76))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(InputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EPS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ActFCF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(States, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(InputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Debt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Pillow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel75)
                    .addComponent(jLabel77))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(InputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(InputPaneLayout.createSequentialGroup()
                        .addGroup(InputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(InputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Shares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Valuation", InputPane);

        jLabel117.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel117.setText("EBIT Calculation");

        jLabel118.setText("Taxes");

        jLabel119.setText("Interest Expense");

        jLabel120.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel120.setText("Ratio Inputs");

        Taxes.setBackground(new java.awt.Color(204, 204, 255));

        IntExp.setBackground(new java.awt.Color(204, 204, 255));

        jLabel121.setText("EBIT");

        EBIT.setBackground(new java.awt.Color(204, 255, 255));

        jLabel123.setText("Total Revenue");

        TRevenue.setBackground(new java.awt.Color(204, 255, 255));

        jLabel125.setText("Net Income");

        NIncome.setBackground(new java.awt.Color(204, 255, 255));

        jLabel127.setText("Actual Stock Price");

        ActPriceInn.setBackground(new java.awt.Color(204, 255, 255));

        jLabel128.setText("Current Assets");

        jLabel129.setText("Current Liabilities");

        CurAssets.setBackground(new java.awt.Color(204, 255, 255));

        CurLiabilities.setBackground(new java.awt.Color(204, 255, 255));

        jLabel130.setText("Ordinary Shares Number");

        jLabel131.setText("Tangible Book Value");

        jLabel132.setText("Total Liabilities Net Minority Interest ");

        jLabel133.setText("Shareholders Equity");

        jLabel134.setText("Common Stock Dividend Paid");

        jLabel135.setText("Total Assets");

        jLabel136.setText("Total Equity Gross Minority Interest");

        jLabel137.setText("Inventory");

        jLabel138.setText("Operating expense ");

        jLabel139.setText("Cost of Revenue");

        jLabel140.setText("Other Income Expense");

        jLabel141.setText("Capital Lease Obligations");

        TEGMI.setBackground(new java.awt.Color(204, 255, 255));

        Inv.setBackground(new java.awt.Color(204, 255, 255));

        OpExpense.setBackground(new java.awt.Color(204, 255, 255));

        CofRevenue.setBackground(new java.awt.Color(204, 255, 255));

        OthIncome.setBackground(new java.awt.Color(204, 255, 255));

        CapLO.setBackground(new java.awt.Color(204, 255, 255));

        TAssets.setBackground(new java.awt.Color(204, 255, 255));

        ComDiv.setBackground(new java.awt.Color(204, 255, 255));

        SHEquity.setBackground(new java.awt.Color(204, 255, 255));

        TLiabilities.setBackground(new java.awt.Color(204, 255, 255));

        TanBookVal.setBackground(new java.awt.Color(204, 255, 255));

        OrShNum.setBackground(new java.awt.Color(204, 255, 255));

        jLabel142.setText("Receivable");

        Receivable.setBackground(new java.awt.Color(204, 255, 255));

        jLabel144.setText("If you don't know EBIT, write 0 (zero) into field.");

        jLabel145.setText("Don't write white spaces nas \",\".");

        javax.swing.GroupLayout InputRatioLayout = new javax.swing.GroupLayout(InputRatio);
        InputRatio.setLayout(InputRatioLayout);
        InputRatioLayout.setHorizontalGroup(
            InputRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InputRatioLayout.createSequentialGroup()
                .addGroup(InputRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InputRatioLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel120))
                    .addGroup(InputRatioLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel117))
                    .addGroup(InputRatioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(InputRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel118)
                            .addComponent(jLabel119)
                            .addComponent(jLabel123)
                            .addComponent(jLabel127)
                            .addComponent(jLabel138)
                            .addComponent(jLabel139)
                            .addComponent(jLabel140))
                        .addGap(7, 7, 7)
                        .addGroup(InputRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OpExpense, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(InputRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Taxes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(TRevenue, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(IntExp, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ActPriceInn, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(NIncome, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(CofRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OthIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EBIT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(InputRatioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(InputRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel125)
                            .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(56, 56, 56)
                .addGroup(InputRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InputRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(CurLiabilities, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(InputRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(InputRatioLayout.createSequentialGroup()
                                .addComponent(jLabel130)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(OrShNum, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(InputRatioLayout.createSequentialGroup()
                                .addComponent(jLabel131)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TanBookVal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(InputRatioLayout.createSequentialGroup()
                                .addComponent(jLabel141)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CapLO, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(InputRatioLayout.createSequentialGroup()
                                .addComponent(jLabel132)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addComponent(TLiabilities, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InputRatioLayout.createSequentialGroup()
                                .addComponent(jLabel137)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Inv, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TEGMI, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InputRatioLayout.createSequentialGroup()
                                .addComponent(jLabel142)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Receivable, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(CurAssets, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(InputRatioLayout.createSequentialGroup()
                                .addComponent(jLabel133)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SHEquity, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(TAssets, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel136)
                    .addComponent(jLabel128)
                    .addComponent(jLabel129)
                    .addComponent(jLabel135))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(InputRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InputRatioLayout.createSequentialGroup()
                        .addComponent(jLabel134)
                        .addGap(56, 56, 56)
                        .addComponent(ComDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel145)
                    .addComponent(jLabel144))
                .addContainerGap(257, Short.MAX_VALUE))
        );
        InputRatioLayout.setVerticalGroup(
            InputRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InputRatioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel117)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InputRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel118)
                    .addComponent(Taxes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel135)
                    .addComponent(TAssets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel134)
                    .addComponent(ComDiv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InputRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel119)
                    .addComponent(IntExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel128)
                    .addComponent(CurAssets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InputRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel120)
                    .addComponent(jLabel142)
                    .addComponent(Receivable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InputRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ActPriceInn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel127)
                    .addComponent(jLabel137)
                    .addComponent(Inv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InputRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel123)
                    .addComponent(jLabel132)
                    .addComponent(TLiabilities, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InputRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InputRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel144)
                        .addComponent(CofRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel129)
                        .addComponent(CurLiabilities, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel139, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InputRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel136)
                    .addComponent(TEGMI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel145)
                    .addComponent(jLabel138)
                    .addComponent(OpExpense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(InputRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OthIncome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel140)
                    .addComponent(jLabel133)
                    .addComponent(SHEquity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(InputRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel125)
                    .addComponent(NIncome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel141)
                    .addComponent(CapLO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InputRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InputRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel121)
                        .addComponent(EBIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(InputRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(TanBookVal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel131)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(InputRatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel130)
                    .addComponent(OrShNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ratio", InputRatio);

        jLabel15.setText("DCF without MoS");

        DCFAns.setEditable(false);
        DCFAns.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setText("DCF model");

        DCFMoSAns.setEditable(false);
        DCFMoSAns.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setText("DDM without MoS");

        jLabel18.setText("Grahams formula without MoS");

        jLabel19.setText("DDM model");

        jLabel20.setText("Grahams formula");

        DDMAns.setEditable(false);
        DDMAns.setBackground(new java.awt.Color(255, 255, 255));

        DDMMoSAns.setEditable(false);
        DDMMoSAns.setBackground(new java.awt.Color(255, 255, 255));

        GrahamAns.setEditable(false);
        GrahamAns.setBackground(new java.awt.Color(255, 255, 255));

        GrahamMoSAns.setEditable(false);
        GrahamMoSAns.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setText("Actual stock price");

        jLabel22.setText("Ideal price without Margin of Safety");

        jLabel23.setText("Margin of Safety");

        jLabel24.setText("Ideal price");

        jLabel25.setText("Difference");

        jLabel26.setText("Answer");

        ActPriceAns.setEditable(false);
        ActPriceAns.setBackground(new java.awt.Color(255, 204, 204));

        IdealPrice.setEditable(false);
        IdealPrice.setBackground(new java.awt.Color(204, 255, 204));

        PillowAns.setEditable(false);
        PillowAns.setBackground(new java.awt.Color(255, 255, 255));

        IdealPriceMoS.setEditable(false);
        IdealPriceMoS.setBackground(new java.awt.Color(255, 255, 204));

        Diff.setEditable(false);
        Diff.setBackground(new java.awt.Color(255, 255, 255));

        Ans.setEditable(false);
        Ans.setBackground(new java.awt.Color(255, 255, 255));

        jLabel27.setText("MoS = Margin of Safety");

        jLabel28.setText("Grahams reversed formula without MoS");

        jLabel29.setText("Grahams reversed formula");

        GrahamRevAns.setEditable(false);
        GrahamRevAns.setBackground(new java.awt.Color(255, 255, 255));

        GrahamRevMoSAns.setEditable(false);
        GrahamRevMoSAns.setBackground(new java.awt.Color(255, 255, 255));

        jLabel78.setText("%");

        jLabel79.setText("%");

        javax.swing.GroupLayout ValuePaneLayout = new javax.swing.GroupLayout(ValuePane);
        ValuePane.setLayout(ValuePaneLayout);
        ValuePaneLayout.setHorizontalGroup(
            ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ValuePaneLayout.createSequentialGroup()
                .addGroup(ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ValuePaneLayout.createSequentialGroup()
                        .addGap(363, 363, 363)
                        .addGroup(ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ActPriceAns, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(IdealPrice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE))
                    .addGroup(ValuePaneLayout.createSequentialGroup()
                        .addGroup(ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ValuePaneLayout.createSequentialGroup()
                                .addGap(304, 304, 304)
                                .addComponent(jLabel27))
                            .addGroup(ValuePaneLayout.createSequentialGroup()
                                .addGroup(ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ValuePaneLayout.createSequentialGroup()
                                        .addGap(179, 179, 179)
                                        .addComponent(jLabel23))
                                    .addGroup(ValuePaneLayout.createSequentialGroup()
                                        .addGap(193, 193, 193)
                                        .addGroup(ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel24)
                                            .addComponent(jLabel25)
                                            .addGroup(ValuePaneLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel26))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ValuePaneLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ValuePaneLayout.createSequentialGroup()
                                                .addGroup(ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(DCFMoSAns, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(ValuePaneLayout.createSequentialGroup()
                                                        .addGap(21, 21, 21)
                                                        .addComponent(jLabel16)))
                                                .addGroup(ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(ValuePaneLayout.createSequentialGroup()
                                                        .addGap(90, 90, 90)
                                                        .addComponent(DDMMoSAns, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(ValuePaneLayout.createSequentialGroup()
                                                        .addGap(110, 110, 110)
                                                        .addComponent(jLabel19))))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ValuePaneLayout.createSequentialGroup()
                                                .addGroup(ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(DCFAns, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel15))
                                                .addGap(90, 90, 90)
                                                .addGroup(ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel17)
                                                    .addComponent(DDMAns, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGroup(ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ValuePaneLayout.createSequentialGroup()
                                        .addGap(63, 63, 63)
                                        .addGroup(ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(IdealPriceMoS, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(ValuePaneLayout.createSequentialGroup()
                                                .addComponent(Diff, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel79))
                                            .addGroup(ValuePaneLayout.createSequentialGroup()
                                                .addComponent(PillowAns, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel78))))
                                    .addGroup(ValuePaneLayout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(Ans, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ValuePaneLayout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addGroup(ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ValuePaneLayout.createSequentialGroup()
                                                .addComponent(jLabel18)
                                                .addGap(31, 31, 31))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ValuePaneLayout.createSequentialGroup()
                                                .addGroup(ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel20)
                                                    .addComponent(GrahamAns, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(GrahamMoSAns, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(59, 59, 59))))))
                            .addGroup(ValuePaneLayout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(jLabel22)))
                        .addGap(0, 119, Short.MAX_VALUE)))
                .addGroup(ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addGroup(ValuePaneLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GrahamRevAns, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GrahamRevMoSAns, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(751, 751, 751))
            .addGroup(ValuePaneLayout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ValuePaneLayout.setVerticalGroup(
            ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ValuePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(jLabel17)
                        .addComponent(jLabel18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DCFAns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DDMAns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(GrahamRevAns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(GrahamAns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(jLabel19)
                        .addComponent(jLabel29))
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DCFMoSAns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DDMMoSAns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GrahamMoSAns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GrahamRevMoSAns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addGap(2, 2, 2)
                .addGroup(ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(ActPriceAns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdealPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(PillowAns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel78))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdealPriceMoS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(Diff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ValuePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(119, 119, 119))
        );

        jTabbedPane1.addTab("Valuaion Summary", ValuePane);

        jLabel89.setText("Gross Margin");

        jLabel90.setText("Operating Margin");

        jLabel91.setText("Earinings per Share (EPS)");

        jLabel92.setText("Price / Earinings");

        jLabel93.setText("Current liquidity");

        jLabel94.setText("Price / Book");

        jLabel95.setText("Debt / Equity");

        jLabel96.setText("Payout Ratio");

        GM.setEditable(false);
        GM.setBackground(new java.awt.Color(255, 255, 255));

        OM.setEditable(false);
        OM.setBackground(new java.awt.Color(255, 255, 255));

        EPSRatio.setEditable(false);
        EPSRatio.setBackground(new java.awt.Color(255, 255, 255));

        PpE.setEditable(false);
        PpE.setBackground(new java.awt.Color(255, 255, 255));

        CLiq.setEditable(false);
        CLiq.setBackground(new java.awt.Color(255, 255, 255));

        PpB.setEditable(false);
        PpB.setBackground(new java.awt.Color(255, 255, 255));

        DpE.setEditable(false);
        DpE.setBackground(new java.awt.Color(255, 255, 255));

        PayOut.setEditable(false);
        PayOut.setBackground(new java.awt.Color(255, 255, 255));

        jLabel97.setText("%");

        jLabel98.setText("%");

        jLabel99.setText("%");

        jLabel101.setText("Return on Assets (ROA)");

        jLabel102.setText("Return on Equity (ROE)");

        jLabel103.setText("Return on Sales (ROS)");

        jLabel104.setText("Cost-effectiveness");

        jLabel105.setText("Total indebtedness of the enterprise");

        jLabel106.setText("Period of turnover of receivables");

        jLabel107.setText("Period of turnover of liabilities");

        jLabel108.setText("Inventory turnover time");

        Indebtedness.setEditable(false);
        Indebtedness.setBackground(new java.awt.Color(255, 255, 255));

        ReceivablesTime.setEditable(false);
        ReceivablesTime.setBackground(new java.awt.Color(255, 255, 255));

        LiabilitiesTime.setEditable(false);
        LiabilitiesTime.setBackground(new java.awt.Color(255, 255, 255));

        InventoryTime.setEditable(false);
        InventoryTime.setBackground(new java.awt.Color(255, 255, 255));

        RN.setEditable(false);
        RN.setBackground(new java.awt.Color(255, 255, 255));

        ROS.setEditable(false);
        ROS.setBackground(new java.awt.Color(255, 255, 255));

        ROE.setEditable(false);
        ROE.setBackground(new java.awt.Color(255, 255, 255));

        ROA.setEditable(false);
        ROA.setBackground(new java.awt.Color(255, 255, 255));

        jLabel109.setText("%");

        jLabel110.setText("%");

        jLabel111.setText("%");

        jLabel112.setText("%");

        jLabel113.setText("%");

        jLabel114.setText("Days");

        jLabel115.setText("Days");

        jLabel116.setText("Days");

        javax.swing.GroupLayout RtioSumLayout = new javax.swing.GroupLayout(RtioSum);
        RtioSum.setLayout(RtioSumLayout);
        RtioSumLayout.setHorizontalGroup(
            RtioSumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RtioSumLayout.createSequentialGroup()
                .addGroup(RtioSumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RtioSumLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel89))
                    .addGroup(RtioSumLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel90))
                    .addGroup(RtioSumLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel91))
                    .addGroup(RtioSumLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(RtioSumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel93)
                            .addComponent(jLabel92)))
                    .addGroup(RtioSumLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(RtioSumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel95)
                            .addComponent(jLabel94)
                            .addComponent(jLabel96))))
                .addGap(28, 28, 28)
                .addGroup(RtioSumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(GM)
                    .addComponent(OM)
                    .addComponent(EPSRatio)
                    .addComponent(PpE)
                    .addComponent(CLiq)
                    .addComponent(PpB)
                    .addComponent(DpE)
                    .addComponent(PayOut, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGroup(RtioSumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RtioSumLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(RtioSumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel105)
                            .addGroup(RtioSumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel107)
                                .addComponent(jLabel106))))
                    .addGroup(RtioSumLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(RtioSumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel97)
                            .addComponent(jLabel98)
                            .addGroup(RtioSumLayout.createSequentialGroup()
                                .addComponent(jLabel99)
                                .addGap(85, 85, 85)
                                .addComponent(jLabel108))))
                    .addGroup(RtioSumLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(RtioSumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel102)
                            .addGroup(RtioSumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel101)
                                .addComponent(jLabel104)
                                .addComponent(jLabel103)))))
                .addGap(39, 39, 39)
                .addGroup(RtioSumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RtioSumLayout.createSequentialGroup()
                        .addComponent(RN, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel112))
                    .addGroup(RtioSumLayout.createSequentialGroup()
                        .addComponent(InventoryTime, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel116))
                    .addGroup(RtioSumLayout.createSequentialGroup()
                        .addComponent(Indebtedness, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel113))
                    .addGroup(RtioSumLayout.createSequentialGroup()
                        .addComponent(ReceivablesTime, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel114))
                    .addGroup(RtioSumLayout.createSequentialGroup()
                        .addComponent(LiabilitiesTime, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel115))
                    .addGroup(RtioSumLayout.createSequentialGroup()
                        .addComponent(ROS, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel111))
                    .addGroup(RtioSumLayout.createSequentialGroup()
                        .addComponent(ROE, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel110))
                    .addGroup(RtioSumLayout.createSequentialGroup()
                        .addComponent(ROA, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel109)))
                .addContainerGap(505, Short.MAX_VALUE))
        );
        RtioSumLayout.setVerticalGroup(
            RtioSumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RtioSumLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(RtioSumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel89)
                    .addComponent(GM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel97)
                    .addComponent(jLabel101)
                    .addComponent(ROA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel109))
                .addGap(18, 18, 18)
                .addGroup(RtioSumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel90)
                    .addComponent(OM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel98)
                    .addComponent(jLabel102)
                    .addComponent(ROE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel110))
                .addGap(18, 18, 18)
                .addGroup(RtioSumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel91)
                    .addComponent(EPSRatio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel103)
                    .addComponent(ROS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel111))
                .addGap(18, 18, 18)
                .addGroup(RtioSumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel92)
                    .addComponent(PpE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel104)
                    .addComponent(RN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel112))
                .addGap(18, 18, 18)
                .addGroup(RtioSumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel93)
                    .addComponent(CLiq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel105)
                    .addComponent(Indebtedness, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel113))
                .addGap(18, 18, 18)
                .addGroup(RtioSumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel94)
                    .addComponent(PpB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel106)
                    .addComponent(ReceivablesTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel114))
                .addGap(18, 18, 18)
                .addGroup(RtioSumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel95)
                    .addComponent(DpE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel107)
                    .addComponent(LiabilitiesTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel115))
                .addGap(18, 18, 18)
                .addGroup(RtioSumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel96)
                    .addComponent(PayOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel99)
                    .addComponent(jLabel108)
                    .addComponent(InventoryTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel116))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ratio Summary", RtioSum);

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

        jLabel54.setText("Growth Rate (next 5 Years)");

        GRDCF.setEditable(false);
        GRDCF.setBackground(new java.awt.Color(255, 255, 255));

        jLabel55.setText("Average Growth Rate");

        AvGRDCF.setEditable(false);
        AvGRDCF.setBackground(new java.awt.Color(255, 255, 255));

        FutureFCF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Year", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "TV"},
                {"Future FCF", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"Discounted FFCF", null, null, null, null, null, null, null, null, null, null, null, null, null}
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

        jLabel56.setText("PoFFCF = Prediction of Future Free Cash Flow");

        jLabel57.setText("TV = Terminal Value");

        jLabel58.setText("DFFCF = Discounted Future Free Cash Flow");

        jLabel59.setText("Perpentual Growth Rate");

        StateDCF.setEditable(false);
        StateDCF.setBackground(new java.awt.Color(255, 255, 255));

        jLabel60.setText("Discount Rate");

        WACCDCF.setEditable(false);
        WACCDCF.setBackground(new java.awt.Color(255, 255, 255));

        jLabel61.setText("Cahs & Cash Equivalents");

        jLabel62.setText("Total Debt");

        jLabel63.setText("Shares Outstanding");

        CashDCF.setEditable(false);
        CashDCF.setBackground(new java.awt.Color(255, 255, 255));

        DebtDCF.setEditable(false);
        DebtDCF.setBackground(new java.awt.Color(255, 255, 255));

        SharesDCF.setEditable(false);
        SharesDCF.setBackground(new java.awt.Color(255, 255, 255));

        jLabel64.setText("Sum of FCF");

        jLabel65.setText("Equity Value");

        SumFCFDCF.setEditable(false);
        SumFCFDCF.setBackground(new java.awt.Color(255, 255, 255));

        EVDCF.setEditable(false);
        EVDCF.setBackground(new java.awt.Color(255, 255, 255));

        jLabel66.setText("Actual Stock Price");

        jLabel67.setText("Margin of Safety");

        jLabel68.setText("DCF Price");

        jLabel69.setText("DCF Price with MoS");

        ActPriceDCF.setEditable(false);
        ActPriceDCF.setBackground(new java.awt.Color(255, 204, 204));

        PillowDCF.setEditable(false);
        PillowDCF.setBackground(new java.awt.Color(255, 255, 255));

        PriceDCFMoS.setEditable(false);
        PriceDCFMoS.setBackground(new java.awt.Color(255, 255, 204));

        PriceDCF.setEditable(false);
        PriceDCF.setBackground(new java.awt.Color(204, 255, 204));

        jLabel70.setText("MoS = Margin of Safety");

        jLabel80.setText("%");

        jLabel81.setText("%");

        jLabel82.setText("%");

        jLabel83.setText("%");

        jLabel84.setText("%");

        javax.swing.GroupLayout dcfPaneLayout = new javax.swing.GroupLayout(dcfPane);
        dcfPane.setLayout(dcfPaneLayout);
        dcfPaneLayout.setHorizontalGroup(
            dcfPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dcfPaneLayout.createSequentialGroup()
                .addGroup(dcfPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dcfPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5))
                    .addGroup(dcfPaneLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel54)
                        .addGap(18, 18, 18)
                        .addComponent(GRDCF, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel81)
                        .addGap(94, 94, 94)
                        .addComponent(jLabel55)
                        .addGap(18, 18, 18)
                        .addComponent(AvGRDCF, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel80)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(dcfPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6)))
                .addContainerGap())
            .addGroup(dcfPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dcfPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dcfPaneLayout.createSequentialGroup()
                        .addGroup(dcfPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dcfPaneLayout.createSequentialGroup()
                                .addComponent(jLabel67)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PillowDCF, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dcfPaneLayout.createSequentialGroup()
                                .addComponent(jLabel66)
                                .addGap(18, 18, 18)
                                .addComponent(ActPriceDCF, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel84))
                    .addGroup(dcfPaneLayout.createSequentialGroup()
                        .addGroup(dcfPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(dcfPaneLayout.createSequentialGroup()
                                .addComponent(jLabel63)
                                .addGap(45, 45, 45)
                                .addComponent(SharesDCF, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dcfPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(dcfPaneLayout.createSequentialGroup()
                                    .addComponent(jLabel62)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DebtDCF, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dcfPaneLayout.createSequentialGroup()
                                    .addComponent(jLabel59)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(StateDCF, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dcfPaneLayout.createSequentialGroup()
                                    .addComponent(jLabel61)
                                    .addGap(18, 18, 18)
                                    .addComponent(CashDCF, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel82)))
                .addGap(97, 97, 97)
                .addGroup(dcfPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dcfPaneLayout.createSequentialGroup()
                        .addGroup(dcfPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(dcfPaneLayout.createSequentialGroup()
                                .addComponent(jLabel60)
                                .addGap(18, 18, 18)
                                .addComponent(WACCDCF, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel83))
                            .addGroup(dcfPaneLayout.createSequentialGroup()
                                .addComponent(jLabel64)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SumFCFDCF, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dcfPaneLayout.createSequentialGroup()
                                .addComponent(jLabel65)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(EVDCF, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(178, 178, 178)
                        .addGroup(dcfPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel57)
                            .addComponent(jLabel56)
                            .addComponent(jLabel58)
                            .addComponent(jLabel70)))
                    .addGroup(dcfPaneLayout.createSequentialGroup()
                        .addGroup(dcfPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel69)
                            .addComponent(jLabel68))
                        .addGap(18, 18, 18)
                        .addGroup(dcfPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PriceDCF, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PriceDCFMoS, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(268, Short.MAX_VALUE))
        );
        dcfPaneLayout.setVerticalGroup(
            dcfPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dcfPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dcfPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GRDCF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54)
                    .addComponent(jLabel55)
                    .addComponent(AvGRDCF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel80)
                    .addComponent(jLabel81))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(dcfPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(jLabel59)
                    .addComponent(StateDCF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60)
                    .addComponent(WACCDCF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel82)
                    .addComponent(jLabel83))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dcfPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jLabel61)
                    .addComponent(CashDCF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64)
                    .addComponent(SumFCFDCF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dcfPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(jLabel62)
                    .addComponent(DebtDCF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65)
                    .addComponent(EVDCF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dcfPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel70)
                    .addGroup(dcfPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel63)
                        .addComponent(SharesDCF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(dcfPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(ActPriceDCF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel68)
                    .addComponent(PriceDCF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dcfPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PillowDCF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67)
                    .addComponent(jLabel69)
                    .addComponent(PriceDCFMoS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel84))
                .addGap(18, 18, 18))
        );

        jTabbedPane1.addTab("DCF", dcfPane);

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

        jLabel30.setText("Average Growth Rate");

        AvGRDDM.setEditable(false);
        AvGRDDM.setBackground(new java.awt.Color(255, 255, 255));

        jLabel31.setText("WACC / Discount rate");

        WACCDDM.setEditable(false);

        jLabel32.setText("DDM Price");

        PriceDDM.setEditable(false);
        PriceDDM.setBackground(new java.awt.Color(204, 255, 204));

        jLabel33.setText("Margin of Safety");

        PillowDDM.setEditable(false);
        PillowDDM.setBackground(new java.awt.Color(255, 255, 255));

        jLabel34.setText("Actual Stock Price");

        ActPriceDDM.setEditable(false);
        ActPriceDDM.setBackground(new java.awt.Color(255, 204, 204));

        jLabel35.setText("DDM Price with MoS");

        PriceDDMMoS.setEditable(false);
        PriceDDMMoS.setBackground(new java.awt.Color(255, 255, 204));

        jLabel71.setText("MoS = Margin of Safety");

        jLabel85.setText("%");

        jLabel86.setText("%");

        jLabel87.setText("%");

        javax.swing.GroupLayout ddmPaneLayout = new javax.swing.GroupLayout(ddmPane);
        ddmPane.setLayout(ddmPaneLayout);
        ddmPaneLayout.setHorizontalGroup(
            ddmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ddmPaneLayout.createSequentialGroup()
                .addGroup(ddmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(ddmPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ddmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AvGRDDM))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel87)
                        .addGap(93, 93, 93)
                        .addGroup(ddmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ddmPaneLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(WACCDDM, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel86))
                            .addGroup(ddmPaneLayout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addGap(244, 244, 244)
                                .addComponent(jLabel71)))
                        .addGap(0, 481, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(ddmPaneLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(ddmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ddmPaneLayout.createSequentialGroup()
                        .addGroup(ddmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(jLabel32))
                        .addGroup(ddmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(ddmPaneLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(PriceDDMMoS, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ddmPaneLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PriceDDM, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(ddmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(ddmPaneLayout.createSequentialGroup()
                            .addComponent(jLabel34)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ActPriceDDM, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ddmPaneLayout.createSequentialGroup()
                            .addComponent(jLabel33)
                            .addGap(45, 45, 45)
                            .addComponent(PillowDDM, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel85)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ddmPaneLayout.setVerticalGroup(
            ddmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ddmPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ddmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jLabel71))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ddmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AvGRDDM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(WACCDDM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel86)
                    .addComponent(jLabel87))
                .addGap(18, 18, 18)
                .addGroup(ddmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(ActPriceDDM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ddmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(PillowDDM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel85))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ddmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(PriceDDM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ddmPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(PriceDDMMoS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DDM", ddmPane);

        jLabel36.setText("Grahams Formula Original");

        jLabel37.setText("Grahams Reversed Formula");

        EPSGraham.setEditable(false);
        EPSGraham.setBackground(new java.awt.Color(255, 255, 255));

        EPSGrahamRev.setEditable(false);
        EPSGrahamRev.setBackground(new java.awt.Color(255, 255, 255));

        jLabel38.setText("EPS");

        jLabel39.setText("P/E ratio");

        jLabel40.setText("7.00");

        jLabel41.setText("8.50");

        jLabel42.setText("Growth rate (next 5 years)");

        GRGrahamRev.setEditable(false);
        GRGrahamRev.setBackground(new java.awt.Color(255, 255, 255));

        GRGraham.setEditable(false);
        GRGraham.setBackground(new java.awt.Color(255, 255, 255));

        jLabel43.setText("Multiplier for Growth rate");

        jLabel44.setText("1.00");

        jLabel45.setText("2.00");

        jLabel46.setText("Average yeald");

        jLabel47.setText("4.40");

        jLabel48.setText("4.40");

        jLabel49.setText("AAA Current Yield (Y)");

        YGrahamRev.setEditable(false);
        YGrahamRev.setBackground(new java.awt.Color(255, 255, 255));

        YGraham.setEditable(false);
        YGraham.setBackground(new java.awt.Color(255, 255, 255));

        jLabel50.setText("Current Stock Price");

        ActPriceGraham.setEditable(false);
        ActPriceGraham.setBackground(new java.awt.Color(255, 204, 204));

        jLabel51.setText("Margin of Safety");

        PillowGraham.setEditable(false);
        PillowGraham.setBackground(new java.awt.Color(255, 255, 255));

        jLabel52.setText("Instrinsic value");

        EndGrahamRev.setEditable(false);
        EndGrahamRev.setBackground(new java.awt.Color(204, 255, 204));

        EndGraham.setEditable(false);
        EndGraham.setBackground(new java.awt.Color(204, 255, 204));

        jLabel53.setText("Instrinsic value with MoS");

        EndGrahamRevMoS.setEditable(false);
        EndGrahamRevMoS.setBackground(new java.awt.Color(255, 255, 204));

        EndGrahamMoS.setEditable(false);
        EndGrahamMoS.setBackground(new java.awt.Color(255, 255, 204));

        jLabel72.setText("MoS = Margin of Safety");

        jLabel73.setText("TICKER aaa current yield => Google.com");

        jLabel88.setText("%");

        javax.swing.GroupLayout GrahamPaneLayout = new javax.swing.GroupLayout(GrahamPane);
        GrahamPane.setLayout(GrahamPaneLayout);
        GrahamPaneLayout.setHorizontalGroup(
            GrahamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GrahamPaneLayout.createSequentialGroup()
                .addGroup(GrahamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GrahamPaneLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(GrahamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GrahamPaneLayout.createSequentialGroup()
                                .addGroup(GrahamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(EPSGraham, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                                .addGroup(GrahamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(GrahamPaneLayout.createSequentialGroup()
                                        .addGap(97, 97, 97)
                                        .addComponent(jLabel38))
                                    .addGroup(GrahamPaneLayout.createSequentialGroup()
                                        .addGap(82, 82, 82)
                                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GrahamPaneLayout.createSequentialGroup()
                                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(jLabel46))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GrahamPaneLayout.createSequentialGroup()
                                .addGroup(GrahamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(YGraham, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(EndGraham, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(EndGrahamMoS, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(GRGraham, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(GrahamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(GrahamPaneLayout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addGroup(GrahamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel42)
                                            .addComponent(jLabel43))
                                        .addGap(34, 34, 34)
                                        .addGroup(GrahamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(GRGrahamRev, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(GrahamPaneLayout.createSequentialGroup()
                                                .addGroup(GrahamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(EPSGrahamRev, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(110, 110, 110)
                                                .addGroup(GrahamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel72)
                                                    .addComponent(jLabel73)))))
                                    .addGroup(GrahamPaneLayout.createSequentialGroup()
                                        .addGroup(GrahamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(GrahamPaneLayout.createSequentialGroup()
                                                .addGap(41, 41, 41)
                                                .addComponent(jLabel49))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GrahamPaneLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel52)))
                                        .addGap(45, 45, 45)
                                        .addGroup(GrahamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(YGrahamRev, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                            .addComponent(EndGrahamRev)
                                            .addComponent(EndGrahamRevMoS)))))))
                    .addGroup(GrahamPaneLayout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addGroup(GrahamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel53)
                            .addGroup(GrahamPaneLayout.createSequentialGroup()
                                .addGroup(GrahamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel50)
                                    .addComponent(jLabel51))
                                .addGap(18, 18, 18)
                                .addGroup(GrahamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PillowGraham, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ActPriceGraham, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel88))
                    .addGroup(GrahamPaneLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel36)
                        .addGap(131, 131, 131)
                        .addComponent(jLabel37)))
                .addContainerGap(397, Short.MAX_VALUE))
        );
        GrahamPaneLayout.setVerticalGroup(
            GrahamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GrahamPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GrahamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(GrahamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EPSGraham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EPSGrahamRev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel72))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(GrahamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41)
                    .addComponent(jLabel73))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(GrahamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(GRGrahamRev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GRGraham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(GrahamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jLabel44)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(GrahamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jLabel47)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(GrahamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(YGraham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(GrahamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel49)
                        .addComponent(YGrahamRev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(GrahamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(ActPriceGraham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(GrahamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(PillowGraham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel88))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(GrahamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(EndGrahamRev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EndGraham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(GrahamPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(EndGrahamRevMoS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EndGrahamMoS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Grahams formula", GrahamPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StatesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_StatesItemStateChanged
        State st = (State)States.getSelectedItem();
            s = st.getGrowth();
    }//GEN-LAST:event_StatesItemStateChanged

    private void CalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculateActionPerformed
        setAnswers();
        makeValue();
        makeValueMoS();
        difference();
    }//GEN-LAST:event_CalculateActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        FileReader fr = null;
        BufferedReader br;
        try {
            File f = new File("states.csv");
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String radek = br.readLine();
            while (radek != null) {
                String[] data = radek.split(";");
                if (data.length == 2) {
                    States.addItem(new State(data[0], Double.parseDouble(data[1])));
                }
                radek = br.readLine();
            }
            State st = (State)States.getSelectedItem();
            this.s = st.getGrowth();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CentralObject.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(CentralObject.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(CentralObject.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        EPS.setText("");
        ActPrice.setText("");
        GR.setText("");
        Y.setText("");
        WACC.setText("");
        ActFCF.setText("");
        Debt.setText("");
        Shares.setText("");
        CandC.setText("");
        Pillow.setText("");
        for(int count = 0; count < 5; count++){
            Dividends.setValueAt(null, 0, count);
        }
        for(int count = 0; count < 8; count++){
            FCF.setValueAt(null, 0, count);
        }
        divis.clear();
        fcf.clear();
    }//GEN-LAST:event_ClearActionPerformed

    private void NoDDMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoDDMActionPerformed
        for(int i = 0; i < 5; i++){
            Dividends.setValueAt(0, 0, i);
        }
    }//GEN-LAST:event_NoDDMActionPerformed

    private void ClearRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearRActionPerformed
        Taxes.setText("");
        IntExp.setText("");
        EBIT.setText("");
        TRevenue.setText("");
        NIncome.setText("");
        ActPriceInn.setText("");
        CurAssets.setText("");
        OrShNum.setText("");
        TanBookVal.setText("");
        TLiabilities.setText("");
        ComDiv.setText("");
        TAssets.setText("");
        TEGMI.setText("");
        Inv.setText("");
        OpExpense.setText("");
        CofRevenue.setText("");
        OthIncome.setText("");
        Receivable.setText("");
        CurLiabilities.setText("");
        CapLO.setText("");
        SHEquity.setText("");
    }//GEN-LAST:event_ClearRActionPerformed

    private void SetKnownsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetKnownsActionPerformed
        ActPriceInn.setText(String.valueOf(getActualPrice()));
    }//GEN-LAST:event_SetKnownsActionPerformed

    private void CalcRatioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalcRatioActionPerformed
        setRatioAns();
    }//GEN-LAST:event_CalcRatioActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CentralObject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CentralObject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CentralObject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CentralObject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CentralObject().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ActFCF;
    private javax.swing.JTextField ActPrice;
    private javax.swing.JTextField ActPriceAns;
    private javax.swing.JTextField ActPriceDCF;
    private javax.swing.JTextField ActPriceDDM;
    private javax.swing.JTextField ActPriceGraham;
    private javax.swing.JTextField ActPriceInn;
    private javax.swing.JTextField Ans;
    private javax.swing.JTextField AvGRDCF;
    private javax.swing.JTextField AvGRDDM;
    private javax.swing.JTextField CLiq;
    private javax.swing.JButton CalcRatio;
    private javax.swing.JButton Calculate;
    private javax.swing.JTextField CandC;
    private javax.swing.JTextField CapLO;
    private javax.swing.JTextField CashDCF;
    private javax.swing.JButton Clear;
    private javax.swing.JButton ClearR;
    private javax.swing.JTextField CofRevenue;
    private javax.swing.JTextField ComDiv;
    private javax.swing.JTextField CurAssets;
    private javax.swing.JTextField CurLiabilities;
    private javax.swing.JTextField DCFAns;
    private javax.swing.JTextField DCFMoSAns;
    private javax.swing.JTextField DDMAns;
    private javax.swing.JTextField DDMMoSAns;
    private javax.swing.JTextField Debt;
    private javax.swing.JTextField DebtDCF;
    private javax.swing.JTextField Diff;
    private javax.swing.JTable Dividends;
    private javax.swing.JTable DividendsPrediction;
    private javax.swing.JTextField DpE;
    private javax.swing.JTextField EBIT;
    private javax.swing.JTextField EPS;
    private javax.swing.JTextField EPSGraham;
    private javax.swing.JTextField EPSGrahamRev;
    private javax.swing.JTextField EPSRatio;
    private javax.swing.JTextField EVDCF;
    private javax.swing.JTextField EndGraham;
    private javax.swing.JTextField EndGrahamMoS;
    private javax.swing.JTextField EndGrahamRev;
    private javax.swing.JTextField EndGrahamRevMoS;
    private javax.swing.JTable FCF;
    private javax.swing.JTable FutureFCF;
    private javax.swing.JTextField GM;
    private javax.swing.JTextField GR;
    private javax.swing.JTextField GRDCF;
    private javax.swing.JTextField GRGraham;
    private javax.swing.JTextField GRGrahamRev;
    private javax.swing.JTextField GrahamAns;
    private javax.swing.JTextField GrahamMoSAns;
    private javax.swing.JPanel GrahamPane;
    private javax.swing.JTextField GrahamRevAns;
    private javax.swing.JTextField GrahamRevMoSAns;
    private javax.swing.JTextField IdealPrice;
    private javax.swing.JTextField IdealPriceMoS;
    private javax.swing.JTextField Indebtedness;
    private javax.swing.JPanel InputPane;
    private javax.swing.JPanel InputRatio;
    private javax.swing.JTextField IntExp;
    private javax.swing.JTextField Inv;
    private javax.swing.JTextField InventoryTime;
    private javax.swing.JTable LastFCF;
    private javax.swing.JTextField LiabilitiesTime;
    private javax.swing.JTextField NIncome;
    private javax.swing.JButton NoDDM;
    private javax.swing.JTextField OM;
    private javax.swing.JTextField OpExpense;
    private javax.swing.JTextField OrShNum;
    private javax.swing.JTextField OthIncome;
    private javax.swing.JTextField PayOut;
    private javax.swing.JTextField Pillow;
    private javax.swing.JTextField PillowAns;
    private javax.swing.JTextField PillowDCF;
    private javax.swing.JTextField PillowDDM;
    private javax.swing.JTextField PillowGraham;
    private javax.swing.JTextField PpB;
    private javax.swing.JTextField PpE;
    private javax.swing.JTextField PriceDCF;
    private javax.swing.JTextField PriceDCFMoS;
    private javax.swing.JTextField PriceDDM;
    private javax.swing.JTextField PriceDDMMoS;
    private javax.swing.JTextField RN;
    private javax.swing.JTextField ROA;
    private javax.swing.JTextField ROE;
    private javax.swing.JTextField ROS;
    private javax.swing.JTextField Receivable;
    private javax.swing.JTextField ReceivablesTime;
    private javax.swing.JPanel RtioSum;
    private javax.swing.JTextField SHEquity;
    private javax.swing.JButton SetKnowns;
    private javax.swing.JTextField Shares;
    private javax.swing.JTextField SharesDCF;
    private javax.swing.JTextField StateDCF;
    private javax.swing.JComboBox<State> States;
    private javax.swing.JTextField SumFCFDCF;
    private javax.swing.JTextField TAssets;
    private javax.swing.JTextField TEGMI;
    private javax.swing.JTextField TLiabilities;
    private javax.swing.JTextField TRevenue;
    private javax.swing.JTextField TanBookVal;
    private javax.swing.JTextField Taxes;
    private javax.swing.JPanel ValuePane;
    private javax.swing.JTextField WACC;
    private javax.swing.JTextField WACCDCF;
    private javax.swing.JTextField WACCDDM;
    private javax.swing.JTextField Y;
    private javax.swing.JTextField YGraham;
    private javax.swing.JTextField YGrahamRev;
    private javax.swing.JPanel dcfPane;
    private javax.swing.JPanel ddmPane;
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
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
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
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
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
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
