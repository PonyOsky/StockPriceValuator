/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Valuator;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ondre
 */
public class Controller {
    
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
    private ReworkedFrontend frontend;
        
    public Controller(ReworkedFrontend f) {
        decfor.setRoundingMode(RoundingMode.DOWN);
        this.frontend = f;
    } 

    /************************Getting input
     * @return s***************************************/
    public List<Double> getFreeCashFlow(){
        fcf = new ArrayList<>();
        for(int coun = 0; coun < frontend..getColumnCount(); coun++){
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

}
