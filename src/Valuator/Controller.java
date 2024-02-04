/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Valuator;

import component.DCFInput;
import component.DCFOutput;
import component.DDMInput;
import component.DDMOutput;
import component.GrahamInput;
import component.GrahamOutput;
import component.InfoInput;
import component.Library;
import component.NAVInput;
import component.NAVOutput;
import component.RatioInput;
import component.RatioOutput;
import component.SummaryOutput;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
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
    public DCFOutput dcfout;
    public DDMOutput ddmout;
    public GrahamOutput grahamout;
    public NAVOutput navout;
    public RatioOutput ratioout;
    public SummaryOutput sumout;
    public Library lib;

    public Controller() {
        decfor.setRoundingMode(RoundingMode.DOWN);
    }

    /**
     *
     * @param i
     * @param ri
     * @param dci
     * @param ddi
     * @param gi
     * @param ni
     * @param ro
     * @param dco
     * @param ddo
     * @param go
     * @param no
     * @param l
     * @param so
     */
    public void setConstants(InfoInput i, RatioInput ri, DCFInput dci, DDMInput ddi, GrahamInput gi, NAVInput ni, RatioOutput ro, DCFOutput dco, DDMOutput ddo, GrahamOutput go, NAVOutput no, Library l, SummaryOutput so) {
        info = i;
        ratioin = ri;
        dcfin = dci;
        ddmin = ddi;
        grahamin = gi;
        navin = ni;
        ratioout = ro;
        dcfout = dco;
        ddmout = ddo;
        grahamout = go;
        navout = no;
        lib = l;
        sumout = so;
    }

    /**
     *
     *
     * @return
     */
    public ArrayList getFreeCashFlow() {
        fcf = new ArrayList();
        for (int coun = 0; coun < dcfin.getFCF().getRowCount(); coun++) {
            if (dcfin.getFCF().getValueAt(coun, 1) == null) {
                fcf.add(null);
            } else {
                fcf.add(Double.valueOf(dcfin.getFCF().getValueAt(coun, 1).toString()));
            }
        }
        return fcf;
    }

    /**
     *
     * @return
     */
    public ArrayList getDividends() {
        divis = new ArrayList();
        for (int count = 0; count < ddmin.getDividends().getColumnCount(); count++) {
            if (ddmin.getDividends().getValueAt(count, 1) != null) {
                divis.add(Double.valueOf(ddmin.getDividends().getValueAt(count, 1).toString()));
            } else {
                divis.add(null);
            }
        }
        return divis;
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
     *
     *
     *
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
     *
     * @param choices
     */
    public void clean(ArrayList choices) {
        if (choices == null || choices.isEmpty()) {
            if (choices.contains("All")) {
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

            if (choices.contains("Informations")) {
                info.getCorpName().setText("");
                info.getSticker().setText("");
                info.getStockExchange().setText("");
                info.getPillow().setText("");
                info.getActPrice().setText("");
                info.getNotes().setText("");
            }

            if (choices.contains("Ratios")) {
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

            if (choices.contains("DCF")) {
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

            if (choices.contains("DDM")) {
                ddmin.getWACCDDM().setText("");
                divis.clear();
                for (int count = 0; count < 5; count++) {
                    ddmin.getDividends().setValueAt(null, 0, count);
                }
            }

            if (choices.contains("Graham")) {
                grahamin.getEPS().setText("");
                grahamin.getGRGraham().setText("");
                grahamin.getYInn().setText("");
            }

            if (choices.contains("NAV")) {
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
        if (choices != null || choices.isEmpty()) {
            if (choices.contains("Ratios")) {
                ratioout.getGM().setText(String.valueOf(decfor.format(ratios.grossMargin())));
                ratioout.getOM().setText(String.valueOf(decfor.format(ratios.operationMargin())));
                ratioout.getEPSRatio().setText(String.valueOf(decfor.format(ratios.earningsPerShare())));
                ratioout.getPpE().setText(String.valueOf(decfor.format(ratios.pricePerEarnings())));
                ratioout.getCLiq().setText(String.valueOf(decfor.format(ratios.currentLiquidity())));
                ratioout.getPpB().setText(String.valueOf(decfor.format(ratios.pricePerBook())));
                ratioout.getDpE().setText(String.valueOf(decfor.format(ratios.debtPerEquity())));
                ratioout.getPayOut().setText(String.valueOf(decfor.format(ratios.payoutRatio())));
                ratioout.getROA().setText(String.valueOf(decfor.format(ratios.roa())));
                ratioout.getROE().setText(String.valueOf(decfor.format(ratios.roe())));
                ratioout.getROS().setText(String.valueOf(decfor.format(ratios.ros())));
                ratioout.getRN().setText(String.valueOf(decfor.format(ratios.rn())));
                ratioout.getIndebtedness().setText(String.valueOf(decfor.format(ratios.indebtedness())));
                ratioout.getReceivablesTime().setText(String.valueOf(formatter.format(ratios.recTime())));
                ratioout.getLiabilitiesTime().setText(String.valueOf(decfor.format(ratios.liabTime())));
                ratioout.getInventoryTime().setText(String.valueOf(formatter.format(ratios.invTime())));
            }
            if (choices.contains("DCF")) {
                dcf.price(getSharesOutstanding(), getCash(), getTotalDebt());
                dcf.priceMoS(getMarginOfSafety());
                dcfout.getPriceDCFMoS().setText(decfor.format(dcf.getValueMoS()));
                dcfout.getPriceDCF().setText(decfor.format(dcf.getValue()));
                for (int count = 0; count < getFreeCashFlow().size(); count++) {
                    if (count + 1 == 9) {
                        break;
                    }
                    dcfout.getLastFCF().setValueAt(getFreeCashFlow().get(count), 0, count + 1);
                }
                for (int count = 0; count < dcf.getFCFGR(getFreeCashFlow()).size(); count++) {
                    if (count + 1 == 9) {
                        break;
                    }
                    dcfout.getLastFCF().setValueAt(dcf.getFCFGR(getFreeCashFlow()).get(count), 1, count + 1);
                }
                dcfout.getGRDCF().setText(String.valueOf(decfor.format(getGrowthRate())));
                dcfout.getAvGRDCF().setText(String.valueOf(decfor.format(dcf.aveGR())));
                for (int count = 0; count < 13; count++) {
                    dcfout.getFutureFCF().setValueAt(decfor.format(dcf.getFFCF(getActualPrice(), getGrowthRateDCF()).get(count)), 1, count + 1);
                }
                for (int count = 0; count < 13; count++) {
                    dcfout.getFutureFCF().setValueAt(decfor.format(dcf.getDFFCF(getDiscountRateDCF()).get(count)), 2, count + 1);
                }
                dcfout.getStateDCF().setText(String.valueOf(getStateGrowthRate()));
                dcfout.getWACCDCFOut().setText(String.valueOf(getDiscountRateDCF() * 100));
                dcfout.getCashDCF().setText(String.valueOf(getCash()));
                dcfout.getDebtDCF().setText(String.valueOf(getTotalDebt()));
                dcfout.getSharesDCF().setText(String.valueOf(getSharesOutstanding()));
                dcfout.getSumFCFDCF().setText(decfor.format(dcf.sumOfDFCF()));
                dcfout.getEVDCF().setText(decfor.format(dcf.equityDCF(getCash(), getTotalDebt())));
            }
            if (choices.contains("DDM")) {
                DefaultTableModel DivPredModel = (DefaultTableModel) ddmout.getDividendsPrediction().getModel();
                ddm.getDDMPrice(getDividends());
                ddm.ddmMoS(getMarginOfSafety());
                ddmout.getPriceDDMMoS().setText(decfor.format(ddm.getValueMoS()));
                ddmout.getPriceDDM().setText(decfor.format(ddm.getValue()));
                for (int count = 0; count < getDividends().size(); count++) {
                    ddmout.getDividendsPrediction().setValueAt(getDividends().get(count), 0, count + 1);
                }
                for (int count = 0; count < ddm.getYDiv().size(); count++) {
                    ddmout.getDividendsPrediction().setValueAt(ddm.getYDiv().get(count), 1, count + 1);
                }
                for (int count = 0; count < ddm.getGrowthDiv().size(); count++) {
                    ddmout.getDividendsPrediction().setValueAt(ddm.getGrowthDiv().get(count), 2, count + 1);
                }
                DivPredModel.fireTableDataChanged();
                ddmout.getAvGRDDM().setText(decfor.format(ddm.getAveGrowDDM()));
                ddmout.getWACCDDMOut().setText(Double.toString(ddm.getDiscDDM(ddm.getAveGrowDDM())));
            }
            if (choices.contains("Graham")) {
                graham.graham(getEarningsPerShare(), getGrowthRate(), getAAACurrentYield());
                graham.grahamReversed(getEarningsPerShare(), getGrowthRate(), getAAACurrentYield());
                graham.grahamMoS(getMarginOfSafety());
                graham.grahamRevMoS(getMarginOfSafety());
                grahamout.getEndGraham().setText(decfor.format(graham.getValue()));
                grahamout.getEndGrahamRev().setText(decfor.format(graham.getValueRev()));
                grahamout.getEndGrahamMoS().setText(decfor.format(graham.getValueMoS()));
                grahamout.getEndGrahamRevMoS().setText(decfor.format(graham.getValueRevMoS()));
                grahamout.getEPSGraham().setText(decfor.format(getEarningsPerShare()));
                grahamout.getEPSGrahamRev().setText(decfor.format(getEarningsPerShare()));
                grahamout.getGRGraham().setText(decfor.format(getGrowthRate()));
                grahamout.getGRGrahamRev().setText(decfor.format(getGrowthRate()));
                grahamout.getYGraham().setText(decfor.format(getAAACurrentYield()));
                grahamout.getYGrahamRev().setText(decfor.format(getAAACurrentYield()));
            }
            if (choices.contains("NAV")) {
                nav.valuation(getAssetsNAV(), getLiabilitiesNAV(), getSharesNAV());
                nav.valuationMoS(getMarginOfSafety());
                navout.getPriceNAV().setText(decfor.format(nav.getValue()));
                navout.getPriceNAVMoS().setText(decfor.format(nav.getValuePillow()));
                navout.getTotalAssetsNAV().setText(decfor.format(getAssetsNAV()));
                navout.getTotalLiabilitiesNAV().setText(decfor.format(getLiabilitiesNAV()));
                navout.getSharesNAV().setText(decfor.format(getSharesNAV()));
            }
            //Summary output
            makeValue(choices.size());
            makeValueMoS(choices.size());
            sumout.getIdealPrice().setText(decfor.format(value));
            sumout.getIdealPriceMoS().setText(decfor.format(valueMoS));
            sumout.getDiff().setText(decfor.format(difference(value)));
            sumout.getSumSticker().setText(info.getSticker().getText());
            sumout.getDCFAns().setText(decfor.format(dcf.getValue()));
            sumout.getDCFMoSAns().setText(decfor.format(dcf.getValueMoS()));
            sumout.getDDMAns().setText(decfor.format(ddm.getValue()));
            sumout.getDDMMoSAns().setText(decfor.format(ddm.getValueMoS()));
            sumout.getGrahamAns().setText(decfor.format(graham.getValue()));
            sumout.getGrahamRevAns().setText(decfor.format(graham.getValueRev()));
            sumout.getGrahamMoSAns().setText(decfor.format(graham.getValueMoS()));
            sumout.getGrahamRevMoSAns().setText(decfor.format(graham.getValueRevMoS()));
            sumout.getNAVAns().setText(decfor.format(nav.getValue()));
            sumout.getNAVMoSAns().setText(decfor.format(nav.getValuePillow()));
            //Actual Prices
            sumout.getActPriceAns().setText(String.valueOf(getActualPrice()));
            ddmout.getActPriceDDM().setText(String.valueOf(getActualPrice()));
            grahamout.getActPriceGraham().setText(String.valueOf(getActualPrice()));
            dcfout.getActPriceDCF().setText(String.valueOf(getActualPrice()));
            navout.getActPriceNAV().setText(String.valueOf(getActualPrice()));
            //Pillows
            sumout.getPillowAns().setText(String.valueOf(getMarginOfSafety() * 100));
            ddmout.getPillowDDM().setText(String.valueOf(getMarginOfSafety() * 100));
            grahamout.getPillowGraham().setText(String.valueOf(getMarginOfSafety() * 100));
            dcfout.getPillowDCF().setText(String.valueOf(getMarginOfSafety() * 100));
            navout.getPillowNAV().setText(String.valueOf(getMarginOfSafety() * 100));

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
        if (!s.isEmpty()) {
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
        } else {
            return 0;
        }
    }

    /**
     *
     * @throws IOException
     */
    public void ShowFiles() throws IOException {
        for (int i = 0; i > saveLoad.load().size(); i++) {
            for (SaveTemplate st : saveLoad.load()) {
                lib.getSavesShowout().setValueAt(st.getName(), i, 0);
                lib.getSavesShowout().setValueAt(st.getTicker(), i, 1);
                lib.getSavesShowout().setValueAt(st.getNote(), i, 2);
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

}
