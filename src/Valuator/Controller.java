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
    NetAssetValue nav = new NetAssetValue(this);
    private ReworkedFrontend frontend;
    private double value;
        
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
    public double getGrowthRateDCF(){
        if(frontend.getGRDCF().getText() == null){
            return 0;
        }else{
            return Double.parseDouble(frontend.getGRDCF().getText());
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
    public double getDiscountRateDDM(){
        return Double.parseDouble(frontend.getWACCDDMInn().getText())/100;
    }
    
    /**
     *
     * @return
     */
    public double getDiscountRateDCF(){
        return Double.parseDouble(frontend.getWACCDCFInn().getText())/100;
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
            return Double.parseDouble(frontend.getActPrice().getText());
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
    
    /**
     *
     * @return
     */
    public double getAssetsNAV(){
        return Double.parseDouble(frontend.getAssets().getText());
    }
    
    /**
     *
     * @return
     */
    public double getLiabilitiesNAV(){
        return Double.parseDouble(frontend.getLiabilities().getText());
    }
    
    /**
     *
     * @return
     */
    public double getSharesNAV(){
        return Double.parseDouble(frontend.getSharesNAV().getText());
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
    /****************************************Make Valuation**********************************************/
    public void makeValue(){
        value = (dcf.price() + ddm.controlDDM() + graham.grahamsSummary() + nav.getValue())/4;
    }
    /**
     *
     * @param value
     * @return
     */
    public double makeValueMoS(double value){
        return value - (value * getMarginOfSafety());
    }
    /**
     *
     * @param value
     * @return
     */
    public double difference(double value){
        return ((value - getActualPrice()) / getActualPrice())* 100;
    }
    /****************************************Setting answers and values**********************************************************/
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
    
    /**
     *
     * @param choices
     */
    public void clean(ArrayList choices){
        if(choices == null || choices.isEmpty()){
            if(choices.contains("CleanAll")){
                frontend.getCorpName().setText("");
                frontend.getSticker().setText("");
                frontend.getStockExchange().setText("");
                frontend.getPillow().setText("");
                frontend.getActPrice().setText("");
                frontend.getNotes().setText("");
                frontend.getTaxes().setText("");
                frontend.getIntExp().setText("");
                frontend.getEBIT().setText("");
                frontend.getTRevenue().setText("");
                frontend.getNIncome().setText("");
                frontend.getCurAssets().setText("");
                frontend.getOrShNum().setText("");
                frontend.getTanBookVal().setText("");
                frontend.getTLiabilities().setText("");
                frontend.getComDiv().setText("");
                frontend.getTAssets().setText("");
                frontend.getTEGMI().setText("");
                frontend.getInv().setText("");
                frontend.getOpExpense().setText("");
                frontend.getCofRevenue().setText("");
                frontend.getOthIncome().setText("");
                frontend.getReceivable().setText("");
                frontend.getCurLiabilities().setText("");
                frontend.getCapLO().setText("");
                frontend.getSHEquity().setText("");
                frontend.getGRDCF().setText("");
                frontend.getWACCDCFInn().setText("");
                frontend.getActFCF().setText("");
                frontend.getDebt().setText("");
                frontend.getShares().setText("");
                frontend.getCandC().setText("");
                frontend.getStateInn().setText("");
                for(int count = 0; count < 8; count++){
                    frontend.getFCF().setValueAt(null, 0, count);
                }
                fcf.clear();
                frontend.getWACCDDMInn().setText("");
                divis.clear();
                for(int count = 0; count < 5; count++){
                    frontend.getDividends().setValueAt(null, 0, count);
                }
                frontend.getEPS().setText("");
                frontend.getGR().setText("");
                frontend.getYInn().setText("");
                frontend.getAssets().setText("");
                frontend.getLiabilities().setText("");
                frontend.getSharesNAV().setText("");
            }
            
            if(choices.contains("CleanInfo")){
                frontend.getCorpName().setText("");
                frontend.getSticker().setText("");
                frontend.getStockExchange().setText("");
                frontend.getPillow().setText("");
                frontend.getActPrice().setText("");
                frontend.getNotes().setText("");
            }
            
            if(choices.contains("CleanRatio")){
                frontend.getTaxes().setText("");
                frontend.getIntExp().setText("");
                frontend.getEBIT().setText("");
                frontend.getTRevenue().setText("");
                frontend.getNIncome().setText("");
                frontend.getCurAssets().setText("");
                frontend.getOrShNum().setText("");
                frontend.getTanBookVal().setText("");
                frontend.getTLiabilities().setText("");
                frontend.getComDiv().setText("");
                frontend.getTAssets().setText("");
                frontend.getTEGMI().setText("");
                frontend.getInv().setText("");
                frontend.getOpExpense().setText("");
                frontend.getCofRevenue().setText("");
                frontend.getOthIncome().setText("");
                frontend.getReceivable().setText("");
                frontend.getCurLiabilities().setText("");
                frontend.getCapLO().setText("");
                frontend.getSHEquity().setText("");
            }
            
            if(choices.contains("CleanDCF")){
                frontend.getGRDCF().setText("");
                frontend.getWACCDCFInn().setText("");
                frontend.getActFCF().setText("");
                frontend.getDebt().setText("");
                frontend.getShares().setText("");
                frontend.getCandC().setText("");
                frontend.getStateInn().setText("");
                for(int count = 0; count < 8; count++){
                    frontend.getFCF().setValueAt(null, 0, count);
                }
                fcf.clear();
            }
            
            if(choices.contains("CleanDDM")){
                frontend.getWACCDDMInn().setText("");
                divis.clear();
                for(int count = 0; count < 5; count++){
                    frontend.getDividends().setValueAt(null, 0, count);
                }
            }
            
            if(choices.contains("CleanGraham")){
                frontend.getEPS().setText("");
                frontend.getGR().setText("");
                frontend.getYInn().setText("");
            }
            
            if(choices.contains("CleanNAV")){
                frontend.getAssets().setText("");
                frontend.getLiabilities().setText("");
                frontend.getSharesNAV().setText("");
            }
        }
    }
    
    public void calculation(ArrayList choices){
        if(choices != null){
            if(choices.contains("CalcRatio")){
                setRatioAns();
            }
            if(choices.contains("CalcDCF")){
                frontend.getDCFMoSAns().setText(String.valueOf(decfor.format(dcf.priceMoS())));
                frontend.getDCFAns().setText(String.valueOf(decfor.format(dcf.price())));
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
                frontend.getWACCDCFOut().setText(String.valueOf(getDiscountRateDCF()*100));
                frontend.getCashDCF().setText(String.valueOf(getCash()));
                frontend.getDebtDCF().setText(String.valueOf(getTotalDebt()));
                frontend.getSharesDCF().setText(String.valueOf(getSharesOutstanding()));
                frontend.getSumFCFDCF().setText(String.valueOf(decfor.format(dcf.sumOfDFCF())));
                frontend.getEVDCF().setText(String.valueOf(decfor.format(dcf.equityDCF())));
                frontend.getPriceDCF().setText(String.valueOf(decfor.format(dcf.price())));
                frontend.getPriceDCFMoS().setText(String.valueOf(decfor.format(dcf.priceMoS())));
            }
            if(choices.contains("CalcDDM")){
                DefaultTableModel DivPredModel = (DefaultTableModel) frontend.getDividendsPrediction().getModel();
                frontend.getDDMMoSAns().setText(String.valueOf(decfor.format(ddm.ddmMoS())));
                frontend.getDDMAns().setText(String.valueOf(decfor.format(ddm.controlDDM())));
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
                frontend.getWACCDDMOut().setText(Double.toString(ddm.getDiscDDM(ddm.getAveGrowDDM())));
                frontend.getPriceDDMMoS().setText(String.valueOf(decfor.format(ddm.ddmMoS())));
                frontend.getPriceDDM().setText(String.valueOf(decfor.format(ddm.controlDDM())));
            }
            if(choices.contains("CalcGraham")){
                frontend.getGrahamAns().setText(String.valueOf(decfor.format(graham.graham())));
                frontend.getGrahamRevAns().setText(String.valueOf(decfor.format(graham.grahamReversed())));
                frontend.getGrahamMoSAns().setText(String.valueOf(decfor.format(graham.grahamMoS())));
                frontend.getGrahamRevMoSAns().setText(String.valueOf(decfor.format(graham.grahamRevMoS())));
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
            }
            if(choices.contains("CalcNAV")){
                frontend.getAssetsNAVOut().setText(frontend.getAssets().getText());
                frontend.getLiabilitiesNAVOut().setText(frontend.getLiabilities().getText());
                frontend.getSharesNAVOut().setText(frontend.getSharesNAV().getText());
                frontend.getPriceNAV().setText(String.valueOf(decfor.format(nav.valuation(getAssetsNAV(), getLiabilitiesNAV(), getSharesNAV()))));
                frontend.getPriceNAVMoS().setText(String.valueOf(decfor.format(nav.valuationMoS(getMarginOfSafety()))));
            }
            makeValue();
            frontend.getIdealPrice().setText(String.valueOf(decfor.format(value)));
            frontend.getIdealPriceMoS().setText(String.valueOf(decfor.format(makeValueMoS(value))));
            frontend.getDiff().setText(String.valueOf(decfor.format(difference(value))));
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
        }
    }
     public Double doubleFormat(String s){
        if(s.contains(".") && s.contains(",")){
            s = s.replaceAll(",", "");
            while(s.indexOf(".") != s.lastIndexOf(".")){
                s = s.replaceFirst("\\.", "");
            }
            s = s.replaceAll(",", "");
        }
        if(s.contains(".") && !s.contains(",")){
            while(s.indexOf(".") != s.lastIndexOf(".")){
                s = s.replaceFirst("\\.", "");
            }
        }
        if(!s.contains(".") && s.contains(",")){
            if(s.indexOf(",") == s.lastIndexOf(",")){
                s = s.replaceFirst(",", ".");
            }else{
                s = s.replaceAll(",", "");
            }
        }
        return Double.valueOf(s);
     }
}
