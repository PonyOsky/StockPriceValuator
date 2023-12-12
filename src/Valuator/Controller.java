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
        for(int coun = 0; coun < frontend.getFCF().getColumnCount(); coun++){
            if(frontend.getFCF().getValueAt(0,coun) == null){
                fcf.add(null);
            }else{
                fcf.add(Double.valueOf(frontend.getFCF().getValueAt(0,coun).toString()));
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
        for(int count = 0; count < frontend.getDividends().getColumnCount(); count++){
            String str = frontend.getDividends().getValueAt(0,count).toString();
            divis.add(Double.valueOf(str));
        }
        return divis;
    }

    /**
     *
     * @return
     */
    public double getGrowthRate(){
        if(frontend.getGR().getText() == null){
            return 0;
        }else{
            return Double.parseDouble(frontend.getGR().getText());
        }
    }

    /**
     *
     * @return
     */
    public double getAAACurrentYield(){
        return Double.parseDouble(frontend.getYInn().getText());
    }

    /**
     *
     * @return
     */
    public double getDiscountRate(){
        return Double.parseDouble(frontend.getWACC().getText())/100;
    }

    /**
     *
     * @return
     */
    public double getActualFreeCashFlow(){
        return Double.parseDouble(frontend.getActFCF().getText());
    }

    /**
     *
     * @return
     */
    public double getTotalDebt(){
        return Double.parseDouble(frontend.getDebt().getText());
    }

    /**
     *
     * @return
     */
    public double getSharesOutstanding(){
        return Double.parseDouble(frontend.getShares().getText());
    }

    /**
     *
     * @return
     */
    public double getCash(){
        return Double.parseDouble(frontend.getCandC().getText());
    }

    /**
     *
     * @return
     */
    public double getMarginOfSafety(){
        return Double.parseDouble(frontend.getPillow().getText())/100;
    }

    /**
     *
     * @return
     */
    public double getInventory(){
        return Double.parseDouble(frontend.getInv().getText());
    }

    /**
     *
     * @return
     */
    public double getReceivable(){
        return Double.parseDouble(frontend.getReceivable().getText());
    }

    /**
     *
     * @return
     */
    public double getCapitalLeaseObligations(){
        return Double.parseDouble(frontend.getCapLO().getText());
    }

    /**
     *
     * @return
     */
    public double getTEGMI(){
        return Double.parseDouble(frontend.getTEGMI().getText());
    }

    /**
     *
     * @return
     */
    public double getEBIT(){
        if(frontend.getEBIT().getText() == null){
            return addons.calcEbit();
        }else{
            return Double.parseDouble(frontend.getEBIT().getText());
        }
    }

    /**
     *
     * @return
     */
    public double getEarningsPerShare(){
        if(frontend.getEPS().getText() == null){
            ratios.earningsPerShare();
            if(ratios.earningsPerShare() == 0){
                return 0;
            }else{
                return ratios.earningsPerShare();
            }
        }else{
            return Double.parseDouble(frontend.getEPS().getText());
        }
    }

    /**
     *
     * @return
     */
    public double getActualPrice(){
        if(frontend.getActPrice().getText() == null){
            return Double.parseDouble(frontend.getActPriceInn().getText());
        }else{
            return Double.parseDouble(frontend.getActPrice().getText());
        }
    }

    /**
     *
     * @return
     */
    public double getCommonStockDividendPaid(){
        return Double.parseDouble(frontend.getComDiv().getText());
    }

    /**
     *
     * @return
     */
    public double getTotalAssets(){
        return Double.parseDouble(frontend.getTAssets().getText());
    }

    /**
     *
     * @return
     */
    public double getTotalLiabilities(){
        return Double.parseDouble(frontend.getTLiabilities().getText());
    }

    /**
     *
     * @return
     */
    public double getShareHoldersEquity(){
        return Double.parseDouble(frontend.getSHEquity().getText());
    }

    /**
     *
     * @return
     */
    public double getTangiableBookValue(){
        return Double.parseDouble(frontend.getTanBookVal().getText());
    }

    /**
     *
     * @return
     */
    public double getCurrentLiabilities(){
        return Double.parseDouble(frontend.getCurLiabilities().getText());
    }

    /**
     *
     * @return
     */
    public double getCurrentAssets(){
        return Double.parseDouble(frontend.getCurAssets().getText());
    }

    /**
     *
     * @return
     */
    public double getOrdinarySharesNumber(){
        return Double.parseDouble(frontend.getOrShNum().getText());
    }

    /**
     *
     * @return
     */
    public double getNetIncome(){
        return Double.parseDouble(frontend.getNIncome().getText());
    }

    /**
     *
     * @return
     */
    public double getTaxes(){
        return Double.parseDouble(frontend.getTaxes().getText());
    }

    /**
     *
     * @return
     */
    public double getInterestExpense(){
        return Double.parseDouble(frontend.getIntExp().getText());
    }

    /**
     *
     * @return
     */
    public double getTotalRevenue(){
        return Double.parseDouble(frontend.getTRevenue().getText());
    }

    /**
     *
     * @return
     */
    public double getOtherIncomeExpense(){
        return Double.parseDouble(frontend.getOthIncome().getText());
    }

    /**
     *
     * @return
     */
    public double getCostOfRevenue(){
        return Double.parseDouble(frontend.getCofRevenue().getText());
    }

    /**
     *
     * @return
     */
    public double getOperatingExpense(){
        return Double.parseDouble(frontend.getOpExpense().getText());
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
        DefaultTableModel DivPredModel = (DefaultTableModel) frontend.getDividendsPrediction().getModel();
        //Answer
        frontend.getGrahamAns().setText(String.valueOf(decfor.format(graham.graham())));
        frontend.getGrahamRevAns().setText(String.valueOf(decfor.format(graham.grahamReversed())));
        frontend.getGrahamMoSAns().setText(String.valueOf(decfor.format(graham.grahamMoS())));
        frontend.getGrahamRevMoSAns().setText(String.valueOf(decfor.format(graham.grahamRevMoS())));
        frontend.getDDMMoSAns().setText(String.valueOf(decfor.format(ddm.ddmMoS())));
        frontend.getDDMAns().setText(String.valueOf(decfor.format(ddm.controlDDM())));
        frontend.getDCFMoSAns().setText(String.valueOf(decfor.format(dcf.priceMoS())));
        frontend.getDCFAns().setText(String.valueOf(decfor.format(dcf.price())));
        frontend.getIdealPrice().setText(String.valueOf(decfor.format(makeValue())));
        frontend.getIdealPriceMoS().setText(String.valueOf(decfor.format(makeValueMoS())));
        frontend.getDiff().setText(String.valueOf(decfor.format(difference())));
        //Actual Prices
        frontend.getActPriceAns().setText(String.valueOf(getActualPrice()));
        frontend.getActPriceDDM().setText(String.valueOf(getActualPrice()));
        frontend.getActPriceGraham().setText(String.valueOf(getActualPrice()));
        frontend.getActPriceDCF().setText(String.valueOf(getActualPrice()));
        //Pillows
        frontend.getPillowAns().setText(String.valueOf(getMarginOfSafety()*100));
        frontend.getPillowDDM().setText(String.valueOf(getMarginOfSafety()*100));
        frontend.getPillowGraham().setText(String.valueOf(getMarginOfSafety()*100));
        frontend.getPillowDCF().setText(String.valueOf(getMarginOfSafety()*100));
        //Graham List
        frontend.getEPSGraham().setText(String.valueOf(decfor.format((Double)getEarningsPerShare())));
        frontend.getEPSGrahamRev().setText(String.valueOf(decfor.format((Double)getEarningsPerShare())));
        frontend.getGRGraham().setText(String.valueOf(decfor.format(getGrowthRate())));
        frontend.getGRGrahamRev().setText(String.valueOf(decfor.format(getGrowthRate())));
        frontend.getYGraham().setText(String.valueOf(decfor.format(getAAACurrentYield())));
        frontend.getYGrahamRev().setText(String.valueOf(decfor.format(getAAACurrentYield())));
        frontend.getEndGraham().setText(String.valueOf(decfor.format(graham.graham())));
        frontend.getEndGrahamRev().setText(String.valueOf(decfor.format(graham.grahamReversed())));
        frontend.getEndGrahamMoS().setText(String.valueOf(decfor.format(graham.grahamMoS())));
        frontend.getEndGrahamRevMoS().setText(String.valueOf(decfor.format(graham.grahamRevMoS())));
        //DDM List
        for(int count = 0; count < getDividends().size(); count++){
            frontend.getDividendsPrediction().setValueAt(getDividends().get(count), 0,count+1);
        }
        for(int count = 0; count < ddm.getYDiv().size(); count++){
            frontend.getDividendsPrediction().setValueAt(ddm.getYDiv().get(count), 1,count+1);
        }
        for(int count = 0; count < ddm.getGrowthDiv().size(); count++){
            frontend.getDividendsPrediction().setValueAt(ddm.getGrowthDiv().get(count), 2,count+1);
        }
        DivPredModel.fireTableDataChanged();
        frontend.getAvGRDDM().setText(String.valueOf(decfor.format(ddm.getAveGrowDDM())));
        frontend.getWACCDDM().setText(Double.toString(ddm.getDiscDDM(ddm.getAveGrowDDM())));
        frontend.getPriceDDMMoS().setText(String.valueOf(decfor.format(ddm.ddmMoS())));
        frontend.getPriceDDM().setText(String.valueOf(decfor.format(ddm.controlDDM())));
        //DCF List
        for(int count = 0; count < getFreeCashFlow().size(); count++){
            frontend.getLastFCF().setValueAt(getFreeCashFlow().get(count), 0,count+1);
        }
        for(int count = 0; count < dcf.getFCFGR().size(); count++){
            frontend.getLastFCF().setValueAt(dcf.getFCFGR().get(count), 1,count+1);
        }
        frontend.getGRDCF().setText(String.valueOf(decfor.format(getGrowthRate())));
        frontend.getAvGRDCF().setText(String.valueOf(decfor.format(dcf.aveGR())));
        for(int count = 0; count < 13; count++){
            frontend.getFutureFCF().setValueAt(decfor.format(dcf.getFFCF().get(count)), 1, count+1);
        }
        for(int count = 0; count < 13; count++){
            frontend.getFutureFCF().setValueAt(decfor.format(dcf.getDFFCF().get(count)), 2, count+1);
        }
        frontend.getStateDCF().setText(String.valueOf(getStateGrowthRate()));
        frontend.getWACCDCF().setText(String.valueOf(getDiscountRate()*100));
        frontend.getCashDCF().setText(String.valueOf(getCash()));
        frontend.getDebtDCF().setText(String.valueOf(getTotalDebt()));
        frontend.getSharesDCF().setText(String.valueOf(getSharesOutstanding()));
        frontend.getSumFCFDCF().setText(String.valueOf(decfor.format(dcf.sumOfDFCF())));
        frontend.getEVDCF().setText(String.valueOf(decfor.format(dcf.equityDCF())));
        frontend.getPriceDCF().setText(String.valueOf(decfor.format(dcf.price())));
        frontend.getPriceDCFMoS().setText(String.valueOf(decfor.format(dcf.priceMoS())));
    }
    public void setRatioAns(){
        frontend.getGM().setText(String.valueOf(decfor.format(ratios.grossMargin())));
        frontend.getOM().setText(String.valueOf(decfor.format(ratios.operationMargin())));
        frontend.getEPSRatio().setText(String.valueOf(decfor.format(ratios.earningsPerShare())));
        frontend.getPpE().setText(String.valueOf(decfor.format(ratios.pricePerEarnings())));
        frontend.getCLiq().setText(String.valueOf(decfor.format(ratios.currentLiquidity())));
        frontend.getPpB().setText(String.valueOf(decfor.format(ratios.pricePerBook())));
        frontend.getDpE().setText(String.valueOf(decfor.format(ratios.debtPerEquity())));
        frontend.getPayOut().setText(String.valueOf(decfor.format(ratios.payoutRatio())));
        frontend.getROA().setText(String.valueOf(decfor.format(ratios.roa())));
        frontend.getROE().setText(String.valueOf(decfor.format(ratios.roe())));
        frontend.getROS().setText(String.valueOf(decfor.format(ratios.ros())));
        frontend.getRN().setText(String.valueOf(decfor.format(ratios.rn())));
        frontend.getIndebtedness().setText(String.valueOf(decfor.format(ratios.indebtedness())));
        frontend.getReceivablesTime().setText(String.valueOf(formatter.format(ratios.recTime())));
        frontend.getLiabilitiesTime().setText(String.valueOf(decfor.format(ratios.liabTime())));
        frontend.getInventoryTime().setText(String.valueOf(formatter.format(ratios.invTime())));
    }

}
