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
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ondre
 */
public class Controller {

    private static final DecimalFormat decfor = new DecimalFormat("0.000");
    NumberFormat formatter = new DecimalFormat("#0.0000");
    ArrayList divis;
    ArrayList fcf;
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
    public DCFInput dcfin;
    public DDMInput ddmin;
    public GrahamInput grahamin;
    public InfoInput info;
    public NAVInput navin;
    public RatioInput ratioin;
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
        for (int coun = 0; coun < dcfin.getFCF().getColumnCount(); coun++) {
            if (dcfin.getFCF().getValueAt(0, coun) == null) {
                fcf.add(null);
            } else {
                fcf.add(Double.valueOf(dcfin.getFCF().getValueAt(0, coun).toString()));
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
        for (int count = 0; count < ddmin.getDividends().getColumnCount(); count++) {
            String str = ddmin.getDividends().getValueAt(0, count).toString();
            divis.add(Double.valueOf(str));
        }
        return (ArrayList) divis;
    }

    /**
     *
     * @return
     */
    public double getGrowthRate() {
        if (grahamin.getGRGraham().getText() == null) {
            return 0;
        } else {
            return doubleFormat(grahamin.getGRGraham().getText());
        }
    }

    /**
     *
     * @return
     */
    public double getGrowthRateDCF() {
        if (dcfin.getGR().getText() == null) {
            return 0;
        } else {
            return doubleFormat(dcfin.getGR().getText());
        }
    }

    /**
     *
     * @return
     */
    public double getAAACurrentYield() {
        return doubleFormat(grahamin.getYInn().getText());
    }

    /**
     *
     * @return
     */
    public double getDiscountRateDDM() {
        return doubleFormat(ddmin.getWACCDDM().getText()) / 100;
    }

    /**
     *
     * @return
     */
    public double getDiscountRateDCF() {
        return doubleFormat(dcfin.getWACCDCFInn().getText()) / 100;
    }

    /**
     *
     * @return
     */
    public double getActualFreeCashFlow() {
        return doubleFormat(dcfin.getActFCF().getText());
    }

    /**
     *
     * @return
     */
    public double getTotalDebt() {
        return doubleFormat(dcfin.getDebt().getText());
    }

    /**
     *
     * @return
     */
    public double getSharesOutstanding() {
        return doubleFormat(dcfin.getShares().getText());
    }

    /**
     *
     * @return
     */
    public double getCash() {
        return doubleFormat(dcfin.getCandC().getText());
    }

    /**
     *
     * @return
     */
    public double getMarginOfSafety() {
        return doubleFormat(info.getPillow().getText()) / 100;
    }

    /**
     *
     * @return
     */
    public double getInventory() {
        return doubleFormat(ratioin.getInv().getText());
    }

    /**
     *
     * @return
     */
    public double getReceivable() {
        return doubleFormat(ratioin.getReceivable().getText());
    }

    /**
     *
     * @return
     */
    public double getCapitalLeaseObligations() {
        return doubleFormat(ratioin.getCapLO().getText());
    }

    /**
     *
     * @return
     */
    public double getTEGMI() {
        return doubleFormat(ratioin.getTEGMI().getText());
    }

    /**
     *
     * @return
     */
    public double getEBIT() {
        if (ratioin.getEBIT().getText() == null) {
            return addons.calcEbit();
        } else {
            return doubleFormat(ratioin.getEBIT().getText());
        }
    }

    /**
     *
     * @return
     */
    public double getEarningsPerShare() {
        if (grahamin.getEPS().getText() == null) {
            ratios.earningsPerShare();
            if (ratios.earningsPerShare() == 0) {
                return 0;
            } else {
                return ratios.earningsPerShare();
            }
        } else {
            return doubleFormat(grahamin.getEPS().getText());
        }
    }

    /**
     *
     * @return
     */
    public double getActualPrice() {
        return doubleFormat(info.getActPrice().getText());
    }

    /**
     *
     * @return
     */
    public double getCommonStockDividendPaid() {
        return doubleFormat(ratioin.getComDiv().getText());
    }

    /**
     *
     * @return
     */
    public double getTotalAssets() {
        return doubleFormat(ratioin.getTAssets().getText());
    }

    /**
     *
     * @return
     */
    public double getTotalLiabilities() {
        return doubleFormat(ratioin.getTLiabilities().getText());
    }

    /**
     *
     * @return
     */
    public double getShareHoldersEquity() {
        return doubleFormat(ratioin.getSHEquity().getText());
    }

    /**
     *
     * @return
     */
    public double getTangiableBookValue() {
        return doubleFormat(ratioin.getTanBookVal().getText());
    }

    /**
     *
     * @return
     */
    public double getCurrentLiabilities() {
        return doubleFormat(ratioin.getCurLiabilities().getText());
    }

    /**
     *
     * @return
     */
    public double getCurrentAssets() {
        return doubleFormat(ratioin.getCurAssets().getText());
    }

    /**
     *
     * @return
     */
    public double getOrdinarySharesNumber() {
        return doubleFormat(ratioin.getOrShNum().getText());
    }

    /**
     *
     * @return
     */
    public double getNetIncome() {
        return doubleFormat(ratioin.getNIncome().getText());
    }

    /**
     *
     * @return
     */
    public double getTaxes() {
        return doubleFormat(ratioin.getTaxes().getText());
    }

    /**
     *
     * @return
     */
    public double getInterestExpense() {
        return doubleFormat(ratioin.getIntExp().getText());
    }

    /**
     *
     * @return
     */
    public double getTotalRevenue() {
        return doubleFormat(ratioin.getTRevenue().getText());
    }

    /**
     *
     * @return
     */
    public double getOtherIncomeExpense() {
        return doubleFormat(ratioin.getOthIncome().getText());
    }

    /**
     *
     * @return
     */
    public double getCostOfRevenue() {
        return doubleFormat(ratioin.getCofRevenue().getText());
    }

    /**
     *
     * @return
     */
    public double getOperatingExpense() {
        return doubleFormat(ratioin.getOpExpense().getText());
    }

    /**
     *
     * @return
     */
    public double getAssetsNAV() {
        return doubleFormat(navin.getTotalAssets().getText());
    }

    /**
     *
     * @return
     */
    public double getLiabilitiesNAV() {
        return doubleFormat(navin.getTotalLiab().getText());
    }

    /**
     *
     * @return
     */
    public double getSharesNAV() {
        return doubleFormat(navin.getSharesOut().getText());
    }

    /**
     *
     * @return
     */
    public double getStateGrowthRate() {
        return doubleFormat(dcfin.getState().getText());
    }

    /**
     * **************************************Make Valuation
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
                info.getCorpName().setText("");
                info.getSticker().setText("");
                info.getStockExchange().setText("");
                info.getPillow().setText("");
                info.getActPrice().setText("");
                info.getNotes().setText("");
                ratioin.getTaxes().setText("");
                ratioin.getIntExp().setText("");
                ratioin.getEBIT().setText("");
                ratioin.getTRevenue().setText("");
                ratioin.getNIncome().setText("");
                ratioin.getCurAssets().setText("");
                ratioin.getOrShNum().setText("");
                ratioin.getTanBookVal().setText("");
                ratioin.getTLiabilities().setText("");
                ratioin.getComDiv().setText("");
                ratioin.getTAssets().setText("");
                ratioin.getTEGMI().setText("");
                ratioin.getInv().setText("");
                ratioin.getOpExpense().setText("");
                ratioin.getCofRevenue().setText("");
                ratioin.getOthIncome().setText("");
                ratioin.getReceivable().setText("");
                ratioin.getCurLiabilities().setText("");
                ratioin.getCapLO().setText("");
                ratioin.getSHEquity().setText("");
                dcfin.getGR().setText("");
                dcfin.getWACCDCFInn().setText("");
                dcfin.getActFCF().setText("");
                dcfin.getDebt().setText("");
                dcfin.getShares().setText("");
                dcfin.getCandC().setText("");
                dcfin.getState().setText("");
                for (int count = 0; count < 8; count++) {
                    dcfin.getFCF().setValueAt(null, 0, count);
                }
                fcf.clear();
                ddmin.getWACCDDM().setText("");
                divis.clear();
                for (int count = 0; count < 5; count++) {
                    ddmin.getDividends().setValueAt(null, 0, count);
                }
                grahamin.getEPS().setText("");
                grahamin.getGRGraham().setText("");
                grahamin.getYInn().setText("");
                navin.getTotalAssets().setText("");
                navin.getTotalLiab().setText("");
                navin.getSharesOut().setText("");
            }

            if (choices.contains("CleanInfo")) {
                info.getCorpName().setText("");
                info.getSticker().setText("");
                info.getStockExchange().setText("");
                info.getPillow().setText("");
                info.getActPrice().setText("");
                info.getNotes().setText("");
            }

            if (choices.contains("CleanRatio")) {
                ratioin.getTaxes().setText("");
                ratioin.getIntExp().setText("");
                ratioin.getEBIT().setText("");
                ratioin.getTRevenue().setText("");
                ratioin.getNIncome().setText("");
                ratioin.getCurAssets().setText("");
                ratioin.getOrShNum().setText("");
                ratioin.getTanBookVal().setText("");
                ratioin.getTLiabilities().setText("");
                ratioin.getComDiv().setText("");
                ratioin.getTAssets().setText("");
                ratioin.getTEGMI().setText("");
                ratioin.getInv().setText("");
                ratioin.getOpExpense().setText("");
                ratioin.getCofRevenue().setText("");
                ratioin.getOthIncome().setText("");
                ratioin.getReceivable().setText("");
                ratioin.getCurLiabilities().setText("");
                ratioin.getCapLO().setText("");
                ratioin.getSHEquity().setText("");
            }

            if (choices.contains("CleanDCF")) {
                dcfin.getGR().setText("");
                dcfin.getWACCDCFInn().setText("");
                dcfin.getActFCF().setText("");
                dcfin.getDebt().setText("");
                dcfin.getShares().setText("");
                dcfin.getCandC().setText("");
                dcfin.getState().setText("");
                for (int count = 0; count < 8; count++) {
                    dcfin.getFCF().setValueAt(null, 0, count);
                }
                fcf.clear();
            }

            if (choices.contains("CleanDDM")) {
                ddmin.getWACCDDM().setText("");
                divis.clear();
                for (int count = 0; count < 5; count++) {
                    ddmin.getDividends().setValueAt(null, 0, count);
                }
            }

            if (choices.contains("CleanGraham")) {
                grahamin.getEPS().setText("");
                grahamin.getGRGraham().setText("");
                grahamin.getYInn().setText("");
            }

            if (choices.contains("CleanNAV")) {
                navin.getTotalAssets().setText("");
                navin.getTotalLiab().setText("");
                navin.getSharesOut().setText("");
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
                    info.getCorpName().getText(),
                    info.getSticker().getText(),
                    info.getStockExchange().getText(),
                    info.getNotes().getText(),
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

    /**
     *
     * @param evt
     */
    public void keyCheck(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != ',' && c != '.') {
            evt.consume();
        }
    }

    /**
     *
     * @param evt
     */
    public void letterCheck(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isAlphabetic(c) && !Character.isDigit(c) && c != ' ' && c != ',') {
            evt.consume();
        }
    }

    /**
     *
     * @return
     */
    public Integer getActYear() {
        Date currentDate = new Date();
        return (int) currentDate.getYear() + 1900;
    }
}
