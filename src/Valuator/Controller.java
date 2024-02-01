/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Valuator;

import java.io.IOException;
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
    List<Double> divis;
    List<Double> fcf;
    AdditionalCalculates addons = new AdditionalCalculates(this);
    StockRatios ratios = new StockRatios(this, addons);
    DividendDiscountModel ddm = new DividendDiscountModel();
    DiscountedCashFlowModel dcf = new DiscountedCashFlowModel();
    GrahamsFormulas graham = new GrahamsFormulas();
    NetAssetValue nav = new NetAssetValue();
    private ReworkedFrontend frontend;
    private double value;
    private double valueMoS;
    public SaveTemplate stemp;
    public SaveLoad saveLoad;

    /**
     *
     * @param f
     */
    public Controller(ReworkedFrontend f) {
        decfor.setRoundingMode(RoundingMode.DOWN);
        this.frontend = f;
    }

    /**
     * **********************Getting input
     *
     * @return s**************************************
     */
    public ArrayList getFreeCashFlow() {
        fcf = new ArrayList<>();
        for (int coun = 0; coun < frontend.getFCF().getColumnCount(); coun++) {
            if (frontend.getFCF().getValueAt(0, coun) == null) {
                fcf.add(null);
            } else {
                fcf.add(Double.valueOf(frontend.getFCF().getValueAt(0, coun).toString()));
            }
        }
        return (ArrayList) fcf;
    }

    /**
     *
     * @return
     */
    public ArrayList getDividends() {
        divis = new ArrayList();
        for (int count = 0; count < frontend.getDividends().getColumnCount(); count++) {
            String str = frontend.getDividends().getValueAt(0, count).toString();
            divis.add(Double.valueOf(str));
        }
        return (ArrayList) divis;
    }

    /**
     *
     * @return
     */
    public double getGrowthRate() {
        if (frontend.getGR().getText() == null) {
            return 0;
        } else {
            return doubleFormat(frontend.getGR().getText());
        }
    }

    /**
     *
     * @return
     */
    public double getGrowthRateDCF() {
        if (frontend.getGRDCF().getText() == null) {
            return 0;
        } else {
            return doubleFormat(frontend.getGRDCF().getText());
        }
    }

    /**
     *
     * @return
     */
    public double getAAACurrentYield() {
        return doubleFormat(frontend.getYInn().getText());
    }

    /**
     *
     * @return
     */
    public double getDiscountRateDDM() {
        return doubleFormat(frontend.getWACCDDMInn().getText()) / 100;
    }

    /**
     *
     * @return
     */
    public double getDiscountRateDCF() {
        return doubleFormat(frontend.getWACCDCFInn().getText()) / 100;
    }

    /**
     *
     * @return
     */
    public double getActualFreeCashFlow() {
        return doubleFormat(frontend.getActFCF().getText());
    }

    /**
     *
     * @return
     */
    public double getTotalDebt() {
        return doubleFormat(frontend.getDebt().getText());
    }

    /**
     *
     * @return
     */
    public double getSharesOutstanding() {
        return doubleFormat(frontend.getShares().getText());
    }

    /**
     *
     * @return
     */
    public double getCash() {
        return doubleFormat(frontend.getCandC().getText());
    }

    /**
     *
     * @return
     */
    public double getMarginOfSafety() {
        return doubleFormat(frontend.getPillow().getText()) / 100;
    }

    /**
     *
     * @return
     */
    public double getInventory() {
        return doubleFormat(frontend.getInv().getText());
    }

    /**
     *
     * @return
     */
    public double getReceivable() {
        return doubleFormat(frontend.getReceivable().getText());
    }

    /**
     *
     * @return
     */
    public double getCapitalLeaseObligations() {
        return doubleFormat(frontend.getCapLO().getText());
    }

    /**
     *
     * @return
     */
    public double getTEGMI() {
        return doubleFormat(frontend.getTEGMI().getText());
    }

    /**
     *
     * @return
     */
    public double getEBIT() {
        if (frontend.getEBIT().getText() == null) {
            return addons.calcEbit();
        } else {
            return doubleFormat(frontend.getEBIT().getText());
        }
    }

    /**
     *
     * @return
     */
    public double getEarningsPerShare() {
        if (frontend.getEPS().getText() == null) {
            ratios.earningsPerShare();
            if (ratios.earningsPerShare() == 0) {
                return 0;
            } else {
                return ratios.earningsPerShare();
            }
        } else {
            return doubleFormat(frontend.getEPS().getText());
        }
    }

    /**
     *
     * @return
     */
    public double getActualPrice() {
        return doubleFormat(frontend.getActPrice().getText());
    }

    /**
     *
     * @return
     */
    public double getCommonStockDividendPaid() {
        return doubleFormat(frontend.getComDiv().getText());
    }

    /**
     *
     * @return
     */
    public double getTotalAssets() {
        return doubleFormat(frontend.getTAssets().getText());
    }

    /**
     *
     * @return
     */
    public double getTotalLiabilities() {
        return doubleFormat(frontend.getTLiabilities().getText());
    }

    /**
     *
     * @return
     */
    public double getShareHoldersEquity() {
        return doubleFormat(frontend.getSHEquity().getText());
    }

    /**
     *
     * @return
     */
    public double getTangiableBookValue() {
        return doubleFormat(frontend.getTanBookVal().getText());
    }

    /**
     *
     * @return
     */
    public double getCurrentLiabilities() {
        return doubleFormat(frontend.getCurLiabilities().getText());
    }

    /**
     *
     * @return
     */
    public double getCurrentAssets() {
        return doubleFormat(frontend.getCurAssets().getText());
    }

    /**
     *
     * @return
     */
    public double getOrdinarySharesNumber() {
        return doubleFormat(frontend.getOrShNum().getText());
    }

    /**
     *
     * @return
     */
    public double getNetIncome() {
        return doubleFormat(frontend.getNIncome().getText());
    }

    /**
     *
     * @return
     */
    public double getTaxes() {
        return doubleFormat(frontend.getTaxes().getText());
    }

    /**
     *
     * @return
     */
    public double getInterestExpense() {
        return doubleFormat(frontend.getIntExp().getText());
    }

    /**
     *
     * @return
     */
    public double getTotalRevenue() {
        return doubleFormat(frontend.getTRevenue().getText());
    }

    /**
     *
     * @return
     */
    public double getOtherIncomeExpense() {
        return doubleFormat(frontend.getOthIncome().getText());
    }

    /**
     *
     * @return
     */
    public double getCostOfRevenue() {
        return doubleFormat(frontend.getCofRevenue().getText());
    }

    /**
     *
     * @return
     */
    public double getOperatingExpense() {
        return doubleFormat(frontend.getOpExpense().getText());
    }

    /**
     *
     * @return
     */
    public double getAssetsNAV() {
        return doubleFormat(frontend.getAssets().getText());
    }

    /**
     *
     * @return
     */
    public double getLiabilitiesNAV() {
        return doubleFormat(frontend.getLiabilities().getText());
    }

    /**
     *
     * @return
     */
    public double getSharesNAV() {
        return doubleFormat(frontend.getSharesNAV().getText());
    }

    /**
     *
     * @return
     */
    public double getStateGrowthRate() {
        return doubleFormat(frontend.getStateInn().getText());
    }

    /**
     * **************************************Make
     * Valuation
     *
     *********************************************
     * @param divider
     */
    public void makeValue(int divider) {
        value = (dcf.getValue() + ddm.getValue() + graham.grahamsSummary(getActualPrice()) + nav.getValue()) / divider;
    }

    /**
     *
     * @param divider
     */
    public void makeValueMoS(int divider) {
        valueMoS = (dcf.getValueMoS() + ddm.getValueMoS() + graham.grahamsSummaryMoS(getActualPrice()) + nav.getValuePillow()) / divider;
    }

    /**
     *
     * @param value
     * @return
     */
    public double difference(double value) {
        return ((value - getActualPrice()) / getActualPrice()) * 100;
    }

    /**
     * **************************************Setting answers and
     * values*********************************************************
     */
    public void setRatioAns() {
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
    public void clean(ArrayList choices) {
        if (choices == null || choices.isEmpty()) {
            if (choices.contains("CleanAll")) {
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
                for (int count = 0; count < 8; count++) {
                    frontend.getFCF().setValueAt(null, 0, count);
                }
                fcf.clear();
                frontend.getWACCDDMInn().setText("");
                divis.clear();
                for (int count = 0; count < 5; count++) {
                    frontend.getDividends().setValueAt(null, 0, count);
                }
                frontend.getEPS().setText("");
                frontend.getGR().setText("");
                frontend.getYInn().setText("");
                frontend.getAssets().setText("");
                frontend.getLiabilities().setText("");
                frontend.getSharesNAV().setText("");
            }

            if (choices.contains("CleanInfo")) {
                frontend.getCorpName().setText("");
                frontend.getSticker().setText("");
                frontend.getStockExchange().setText("");
                frontend.getPillow().setText("");
                frontend.getActPrice().setText("");
                frontend.getNotes().setText("");
            }

            if (choices.contains("CleanRatio")) {
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

            if (choices.contains("CleanDCF")) {
                frontend.getGRDCF().setText("");
                frontend.getWACCDCFInn().setText("");
                frontend.getActFCF().setText("");
                frontend.getDebt().setText("");
                frontend.getShares().setText("");
                frontend.getCandC().setText("");
                frontend.getStateInn().setText("");
                for (int count = 0; count < 8; count++) {
                    frontend.getFCF().setValueAt(null, 0, count);
                }
                fcf.clear();
            }

            if (choices.contains("CleanDDM")) {
                frontend.getWACCDDMInn().setText("");
                divis.clear();
                for (int count = 0; count < 5; count++) {
                    frontend.getDividends().setValueAt(null, 0, count);
                }
            }

            if (choices.contains("CleanGraham")) {
                frontend.getEPS().setText("");
                frontend.getGR().setText("");
                frontend.getYInn().setText("");
            }

            if (choices.contains("CleanNAV")) {
                frontend.getAssets().setText("");
                frontend.getLiabilities().setText("");
                frontend.getSharesNAV().setText("");
            }
        }
    }

    /**
     *
     * @param choices
     */
    public void calculation(ArrayList choices) {
        if (choices != null) {
            if (choices.contains("CalcRatio")) {
                setRatioAns();
            }
            if (choices.contains("CalcDCF")) {
                dcf.price(getSharesOutstanding(), getCash(), getTotalDebt());
                dcf.priceMoS(getMarginOfSafety());
                frontend.getDCFMoSAns().setText(String.valueOf(decfor.format(dcf.getValueMoS())));
                frontend.getDCFAns().setText(decfor.format(dcf.getValue()));
                for (int count = 0; count < getFreeCashFlow().size(); count++) {
                    frontend.getLastFCF().setValueAt(getFreeCashFlow().get(count), 0, count + 1);
                }
                for (int count = 0; count < dcf.getFCFGR(getFreeCashFlow()).size(); count++) {
                    frontend.getLastFCF().setValueAt(dcf.getFCFGR(getFreeCashFlow()).get(count), 1, count + 1);
                }
                frontend.getGRDCF().setText(String.valueOf(decfor.format(getGrowthRate())));
                frontend.getAvGRDCF().setText(String.valueOf(decfor.format(dcf.aveGR())));
                for (int count = 0; count < 13; count++) {
                    frontend.getFutureFCF().setValueAt(decfor.format(dcf.getFFCF(getActualPrice(), getGrowthRateDCF()).get(count)), 1, count + 1);
                }
                for (int count = 0; count < 13; count++) {
                    frontend.getFutureFCF().setValueAt(decfor.format(dcf.getDFFCF(getDiscountRateDCF()).get(count)), 2, count + 1);
                }
                frontend.getStateDCF().setText(String.valueOf(getStateGrowthRate()));
                frontend.getWACCDCFOut().setText(String.valueOf(getDiscountRateDCF() * 100));
                frontend.getCashDCF().setText(String.valueOf(getCash()));
                frontend.getDebtDCF().setText(String.valueOf(getTotalDebt()));
                frontend.getSharesDCF().setText(String.valueOf(getSharesOutstanding()));
                frontend.getSumFCFDCF().setText(decfor.format(dcf.sumOfDFCF()));
                frontend.getEVDCF().setText(decfor.format(dcf.equityDCF(getCash(), getTotalDebt())));
                frontend.getPriceDCF().setText(decfor.format(dcf.getValue()));
                frontend.getPriceDCFMoS().setText(decfor.format(dcf.getValueMoS()));
            }
            if (choices.contains("CalcDDM")) {
                DefaultTableModel DivPredModel = (DefaultTableModel) frontend.getDividendsPrediction().getModel();
                ddm.getDDMPrice(getDividends());
                ddm.ddmMoS(getMarginOfSafety());
                frontend.getDDMMoSAns().setText(decfor.format(ddm.getValueMoS()));
                frontend.getDDMAns().setText(decfor.format(ddm.getValue()));
                for (int count = 0; count < getDividends().size(); count++) {
                    frontend.getDividendsPrediction().setValueAt(getDividends().get(count), 0, count + 1);
                }
                for (int count = 0; count < ddm.getYDiv().size(); count++) {
                    frontend.getDividendsPrediction().setValueAt(ddm.getYDiv().get(count), 1, count + 1);
                }
                for (int count = 0; count < ddm.getGrowthDiv().size(); count++) {
                    frontend.getDividendsPrediction().setValueAt(ddm.getGrowthDiv().get(count), 2, count + 1);
                }
                DivPredModel.fireTableDataChanged();
                frontend.getAvGRDDM().setText(decfor.format(ddm.getAveGrowDDM()));
                frontend.getWACCDDMOut().setText(Double.toString(ddm.getDiscDDM(ddm.getAveGrowDDM())));
                frontend.getPriceDDMMoS().setText(decfor.format(ddm.getValueMoS()));
                frontend.getPriceDDM().setText(decfor.format(ddm.getValue()));
            }
            if (choices.contains("CalcGraham")) {
                graham.graham(getEarningsPerShare(), getGrowthRate(), getAAACurrentYield());
                graham.grahamReversed(getEarningsPerShare(), getGrowthRate(), getAAACurrentYield());
                graham.grahamMoS(getMarginOfSafety());
                graham.grahamRevMoS(getMarginOfSafety());
                frontend.getGrahamAns().setText(decfor.format(graham.getValue()));
                frontend.getGrahamRevAns().setText(decfor.format(graham.getValueRev()));
                frontend.getGrahamMoSAns().setText(decfor.format(graham.getValueMoS()));
                frontend.getGrahamRevMoSAns().setText(decfor.format(graham.getValueRevMoS()));
                frontend.getEPSGraham().setText(decfor.format((Double) getEarningsPerShare()));
                frontend.getEPSGrahamRev().setText(decfor.format((Double) getEarningsPerShare()));
                frontend.getGRGraham().setText(decfor.format(getGrowthRate()));
                frontend.getGRGrahamRev().setText(decfor.format(getGrowthRate()));
                frontend.getYGraham().setText(decfor.format(getAAACurrentYield()));
                frontend.getYGrahamRev().setText(decfor.format(getAAACurrentYield()));
                frontend.getEndGraham().setText(decfor.format(graham.getValue()));
                frontend.getEndGrahamRev().setText(decfor.format(graham.getValueRev()));
                frontend.getEndGrahamMoS().setText(decfor.format(graham.getValueMoS()));
                frontend.getEndGrahamRevMoS().setText(decfor.format(graham.getValueRevMoS()));
            }
            if (choices.contains("CalcNAV")) {
                nav.valuation(getAssetsNAV(), getLiabilitiesNAV(), getSharesNAV());
                nav.valuationMoS(getMarginOfSafety());
                frontend.getNAVAns().setText(String.valueOf(decfor.format(nav.getValue())));
                frontend.getNAVMoSAns().setText(decfor.format(nav.getValuePillow()));
                frontend.getAssetsNAVOut().setText(frontend.getAssets().getText());
                frontend.getLiabilitiesNAVOut().setText(frontend.getLiabilities().getText());
                frontend.getSharesNAVOut().setText(frontend.getSharesNAV().getText());
                frontend.getPriceNAV().setText(decfor.format(nav.getValue()));
                frontend.getPriceNAVMoS().setText(decfor.format(nav.getValuePillow()));
            }
            makeValue(choices.size());
            makeValueMoS(choices.size());
            frontend.getIdealPrice().setText(decfor.format(value));
            frontend.getIdealPriceMoS().setText(decfor.format(valueMoS));
            frontend.getDiff().setText(decfor.format(difference(value)));
            //Actual Prices
            frontend.getActPriceAns().setText(String.valueOf(getActualPrice()));
            frontend.getActPriceDDM().setText(String.valueOf(getActualPrice()));
            frontend.getActPriceGraham().setText(String.valueOf(getActualPrice()));
            frontend.getActPriceDCF().setText(String.valueOf(getActualPrice()));
            //Pillows
            frontend.getPillowAns().setText(String.valueOf(getMarginOfSafety() * 100));
            frontend.getPillowDDM().setText(String.valueOf(getMarginOfSafety() * 100));
            frontend.getPillowGraham().setText(String.valueOf(getMarginOfSafety() * 100));
            frontend.getPillowDCF().setText(String.valueOf(getMarginOfSafety() * 100));

            stemp = new SaveTemplate(
                    choices,
                    frontend.getCorpName().getText(),
                    frontend.getSticker().getText(),
                    frontend.getStockExchange().getText(),
                    frontend.getNotes().getText(),
                    getTotalRevenue(),
                    getCostOfRevenue(),
                    getOperatingExpense(),
                    getOtherIncomeExpense(),
                    getNetIncome(),
                    getEBIT(),
                    getCommonStockDividendPaid(),
                    getTaxes(),
                    getInterestExpense(),
                    getTotalAssets(),
                    getCurrentAssets(),
                    getReceivable(),
                    getInventory(),
                    getReceivable(),
                    getInventory(),
                    getTotalLiabilities(),
                    getCurrentLiabilities(),
                    getTEGMI(),
                    getShareHoldersEquity(),
                    getCapitalLeaseObligations(),
                    getTangiableBookValue(),
                    getOrdinarySharesNumber(),
                    getFreeCashFlow(),
                    getGrowthRateDCF(),
                    getDiscountRateDCF(),
                    getActualFreeCashFlow(),
                    getTotalDebt(),
                    getSharesOutstanding(),
                    getCash(),
                    getStateGrowthRate(),
                    getDividends(),
                    getDiscountRateDDM(),
                    getEarningsPerShare(),
                    getGrowthRate(),
                    getAAACurrentYield(),
                    getAssetsNAV(),
                    getLiabilitiesNAV(),
                    getSharesNAV());
        }
    }

    /**
     *
     * @param s
     * @return
     */
    public double doubleFormat(String s) {
        if (s.contains(".") && s.contains(",")) {
            if (s.indexOf(",") < s.indexOf(".")) {
                s = s.replace(",", "");
            } else {
                s = s.replace(".", "");
            }
            while (s.indexOf(".") != s.lastIndexOf(".")) {
                s = s.replaceFirst("\\.", "");
            }
            s = s.replace(",", "");
        }
        if (s.contains(".") && !s.contains(",")) {
            while (s.indexOf(".") != s.lastIndexOf(".")) {
                s = s.replaceFirst("\\.", "");
            }
        }
        if (!s.contains(".") && s.contains(",")) {
            if (s.indexOf(",") == s.lastIndexOf(",")) {
                s = s.replaceFirst(",", ".");
            } else {
                s = s.replace(",", "");
            }
        }
        return Double.parseDouble(s);
    }

    /**
     *
     * @throws IOException
     */
    public void ShowFiles() throws IOException {
        for (int i = 0; i > saveLoad.load().size(); i++) {
            for (SaveTemplate st : saveLoad.load()) {
                frontend.getSavesShowout().setValueAt(st.getName(), i, 0);
                frontend.getSavesShowout().setValueAt(st.getTicker(), i, 1);
                frontend.getSavesShowout().setValueAt(st.getNote(), i, 2);
            }
        }
    }

    /**
     *
     * @return
     */
    public double getValue() {
        return value;
    }

    /**
     *
     * @return
     */
    public double getValueMoS() {
        return valueMoS;
    }

}
