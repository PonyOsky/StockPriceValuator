/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Valuator;

import java.util.List;

/**
 *
 * @author ondre
 */
public class SaveTemplate {

    private int id;
    private List<String> valMethods;//id + ";" + s1 + "," + s2 + ";"
    //Inputs
    private String name;
    private String ticker;
    private String exchange;
    private String note;
    private double actPrice;
    private double pillow;
    //Ratio Inputs
    private double totalRevenue;
    private double CostOfRevenue;
    private double operatingExpense;
    private double otherIncomeExpense;
    private double netIncome;
    private double ebit;
    private double comStockDivPaid;
    private double taxes;
    private double interExpense;
    private double totalAssest;
    private double curAssets;
    private double receivable;
    private double inventory;
    private double totalLiabNetMinInt;
    private double curLiabilities;
    private double totalEqGrossMinInt;
    private double shareholdersEquity;
    private double capitalLeaseObl;
    private double tanBookVal;
    private double ordinaryShareNum;
    //DCF Inputs
    private List<Double> FCF;
    private double GrRate;
    private double DisRate;
    private double actFCF;
    private double totalDebt;
    private double sharesOuts;
    private double CashCashEq;
    private double perpGrRate;
    //DDM Inputs
    private List<Double> Dividends;
    private double discRate;
    //Gaham Inputs
    private double eps;
    private double GrGrRate;
    private double aaa;
    //NAV Inputs
    private double NAVTotAssets;
    private double NAVTotLiab;
    private double NAVTotNumOfOutShare;

    /**
     *
     * @param valMethods
     * @param name
     * @param ticker
     * @param exchange
     * @param note
     * @param actPrice
     * @param pillow
     * @param totalRevenue
     * @param CostOfRevenue
     * @param operatingExpense
     * @param otherIncomeExpense
     * @param netIncome
     * @param ebit
     * @param comStockDivPaid
     * @param taxes
     * @param interExpense
     * @param totalAssest
     * @param curAssets
     * @param receivable
     * @param inventory
     * @param totalLiabNetMinInt
     * @param curLiabilities
     * @param totalEqGrossMinInt
     * @param shareholdersEquity
     * @param capitalLeaseObl
     * @param tanBookVal
     * @param ordinaryShareNum
     * @param FCF
     * @param GrRate
     * @param DisRate
     * @param actFCF
     * @param totalDebt
     * @param sharesOuts
     * @param CashCashEq
     * @param perpGrRate
     * @param Dividends
     * @param discRate
     * @param eps
     * @param GrGrRate
     * @param aaa
     * @param NAVTotAssets
     * @param NAVTotLiab
     * @param NAVTotNumOfOutShare
     */
    public SaveTemplate(List<String> valMethods, String name, String ticker, String exchange, String note, double actPrice, double pillow, double totalRevenue, double CostOfRevenue, double operatingExpense, double otherIncomeExpense, double netIncome, double ebit, double comStockDivPaid, double taxes, double interExpense, double totalAssest, double curAssets, double receivable, double inventory, double totalLiabNetMinInt, double curLiabilities, double totalEqGrossMinInt, double shareholdersEquity, double capitalLeaseObl, double tanBookVal, double ordinaryShareNum, List<Double> FCF, double GrRate, double DisRate, double actFCF, double totalDebt, double sharesOuts, double CashCashEq, double perpGrRate, List<Double> Dividends, double discRate, double eps, double GrGrRate, double aaa, double NAVTotAssets, double NAVTotLiab, double NAVTotNumOfOutShare) {
        this.valMethods = valMethods;
        this.name = name;
        this.ticker = ticker;
        this.exchange = exchange;
        this.note = note;
        this.actPrice = actPrice;
        this.pillow = pillow;
        this.totalRevenue = totalRevenue;
        this.CostOfRevenue = CostOfRevenue;
        this.operatingExpense = operatingExpense;
        this.otherIncomeExpense = otherIncomeExpense;
        this.netIncome = netIncome;
        this.ebit = ebit;
        this.comStockDivPaid = comStockDivPaid;
        this.taxes = taxes;
        this.interExpense = interExpense;
        this.totalAssest = totalAssest;
        this.curAssets = curAssets;
        this.receivable = receivable;
        this.inventory = inventory;
        this.totalLiabNetMinInt = totalLiabNetMinInt;
        this.curLiabilities = curLiabilities;
        this.totalEqGrossMinInt = totalEqGrossMinInt;
        this.shareholdersEquity = shareholdersEquity;
        this.capitalLeaseObl = capitalLeaseObl;
        this.tanBookVal = tanBookVal;
        this.ordinaryShareNum = ordinaryShareNum;
        this.FCF = FCF;
        this.GrRate = GrRate;
        this.DisRate = DisRate;
        this.actFCF = actFCF;
        this.totalDebt = totalDebt;
        this.sharesOuts = sharesOuts;
        this.CashCashEq = CashCashEq;
        this.perpGrRate = perpGrRate;
        this.Dividends = Dividends;
        this.discRate = discRate;
        this.eps = eps;
        this.GrGrRate = GrGrRate;
        this.aaa = aaa;
        this.NAVTotAssets = NAVTotAssets;
        this.NAVTotLiab = NAVTotLiab;
        this.NAVTotNumOfOutShare = NAVTotNumOfOutShare;
    }

    /**
     *
     * @param ID
     */
    public void setID(int ID) {
        id = ID;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getTicker() {
        return ticker;
    }

    /**
     *
     * @param ticker
     */
    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    /**
     *
     * @return
     */
    public String getExchange() {
        return exchange;
    }

    /**
     *
     * @param exchange
     */
    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    /**
     *
     * @return
     */
    public String getNote() {
        return note;
    }

    /**
     *
     * @param note
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     *
     * @return
     */
    public double getActPrice() {
        return actPrice;
    }

    /**
     *
     * @param actPrice
     */
    public void setActPrice(double actPrice) {
        this.actPrice = actPrice;
    }

    /**
     *
     * @return
     */
    public double getPillow() {
        return pillow;
    }

    /**
     *
     * @param pillow
     */
    public void setPillow(double pillow) {
        this.pillow = pillow;
    }

    /**
     *
     * @return
     */
    public double getTotalRevenue() {
        return totalRevenue;
    }

    /**
     *
     * @param totalRevenue
     */
    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    /**
     *
     * @return
     */
    public double getCostOfRevenue() {
        return CostOfRevenue;
    }

    /**
     *
     * @param CostOfRevenue
     */
    public void setCostOfRevenue(double CostOfRevenue) {
        this.CostOfRevenue = CostOfRevenue;
    }

    /**
     *
     * @return
     */
    public double getOperatingExpense() {
        return operatingExpense;
    }

    /**
     *
     * @param operatingExpense
     */
    public void setOperatingExpense(double operatingExpense) {
        this.operatingExpense = operatingExpense;
    }

    /**
     *
     * @return
     */
    public double getOtherIncomeExpense() {
        return otherIncomeExpense;
    }

    /**
     *
     * @param otherIncomeExpense
     */
    public void setOtherIncomeExpense(double otherIncomeExpense) {
        this.otherIncomeExpense = otherIncomeExpense;
    }

    /**
     *
     * @return
     */
    public double getNetIncome() {
        return netIncome;
    }

    /**
     *
     * @param netIncome
     */
    public void setNetIncome(double netIncome) {
        this.netIncome = netIncome;
    }

    /**
     *
     * @return
     */
    public double getEbit() {
        return ebit;
    }

    /**
     *
     * @param ebit
     */
    public void setEbit(double ebit) {
        this.ebit = ebit;
    }

    /**
     *
     * @return
     */
    public double getComStockDivPaid() {
        return comStockDivPaid;
    }

    /**
     *
     * @param comStockDivPaid
     */
    public void setComStockDivPaid(double comStockDivPaid) {
        this.comStockDivPaid = comStockDivPaid;
    }

    /**
     *
     * @return
     */
    public double getTaxes() {
        return taxes;
    }

    /**
     *
     * @param taxes
     */
    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    /**
     *
     * @return
     */
    public double getInterExpense() {
        return interExpense;
    }

    /**
     *
     * @param interExpense
     */
    public void setInterExpense(double interExpense) {
        this.interExpense = interExpense;
    }

    /**
     *
     * @return
     */
    public double getTotalAssest() {
        return totalAssest;
    }

    /**
     *
     * @param totalAssest
     */
    public void setTotalAssest(double totalAssest) {
        this.totalAssest = totalAssest;
    }

    /**
     *
     * @return
     */
    public double getCurAssets() {
        return curAssets;
    }

    /**
     *
     * @param curAssets
     */
    public void setCurAssets(double curAssets) {
        this.curAssets = curAssets;
    }

    /**
     *
     * @return
     */
    public double getReceivable() {
        return receivable;
    }

    /**
     *
     * @param receivable
     */
    public void setReceivable(double receivable) {
        this.receivable = receivable;
    }

    /**
     *
     * @return
     */
    public double getInventory() {
        return inventory;
    }

    /**
     *
     * @param inventory
     */
    public void setInventory(double inventory) {
        this.inventory = inventory;
    }

    /**
     *
     * @return
     */
    public double getTotalLiabNetMinInt() {
        return totalLiabNetMinInt;
    }

    /**
     *
     * @param totalLiabNetMinInt
     */
    public void setTotalLiabNetMinInt(double totalLiabNetMinInt) {
        this.totalLiabNetMinInt = totalLiabNetMinInt;
    }

    /**
     *
     * @return
     */
    public double getCurLiabilities() {
        return curLiabilities;
    }

    /**
     *
     * @param curLiabilities
     */
    public void setCurLiabilities(double curLiabilities) {
        this.curLiabilities = curLiabilities;
    }

    /**
     *
     * @return
     */
    public double getTotalEqGrossMinInt() {
        return totalEqGrossMinInt;
    }

    /**
     *
     * @param totalEqGrossMinInt
     */
    public void setTotalEqGrossMinInt(double totalEqGrossMinInt) {
        this.totalEqGrossMinInt = totalEqGrossMinInt;
    }

    /**
     *
     * @return
     */
    public double getShareholdersEquity() {
        return shareholdersEquity;
    }

    /**
     *
     * @param shareholdersEquity
     */
    public void setShareholdersEquity(double shareholdersEquity) {
        this.shareholdersEquity = shareholdersEquity;
    }

    /**
     *
     * @return
     */
    public double getCapitalLeaseObl() {
        return capitalLeaseObl;
    }

    /**
     *
     * @param capitalLeaseObl
     */
    public void setCapitalLeaseObl(double capitalLeaseObl) {
        this.capitalLeaseObl = capitalLeaseObl;
    }

    /**
     *
     * @return
     */
    public double getTanBookVal() {
        return tanBookVal;
    }

    /**
     *
     * @param tanBookVal
     */
    public void setTanBookVal(double tanBookVal) {
        this.tanBookVal = tanBookVal;
    }

    /**
     *
     * @return
     */
    public double getOrdinaryShareNum() {
        return ordinaryShareNum;
    }

    /**
     *
     * @param ordinaryShareNum
     */
    public void setOrdinaryShareNum(double ordinaryShareNum) {
        this.ordinaryShareNum = ordinaryShareNum;
    }

    /**
     *
     * @return
     */
    public List<Double> getFCF() {
        return FCF;
    }

    /**
     *
     * @param FCF
     */
    public void setFCF(List<Double> FCF) {
        this.FCF = FCF;
    }

    /**
     *
     * @return
     */
    public double getGrRate() {
        return GrRate;
    }

    /**
     *
     * @param GrRate
     */
    public void setGrRate(double GrRate) {
        this.GrRate = GrRate;
    }

    /**
     *
     * @return
     */
    public double getDisRate() {
        return DisRate;
    }

    /**
     *
     * @param DisRate
     */
    public void setDisRate(double DisRate) {
        this.DisRate = DisRate;
    }

    /**
     *
     * @return
     */
    public double getActFCF() {
        return actFCF;
    }

    /**
     *
     * @param actFCF
     */
    public void setActFCF(double actFCF) {
        this.actFCF = actFCF;
    }

    /**
     *
     * @return
     */
    public double getTotalDebt() {
        return totalDebt;
    }

    /**
     *
     * @param totalDebt
     */
    public void setTotalDebt(double totalDebt) {
        this.totalDebt = totalDebt;
    }

    /**
     *
     * @return
     */
    public double getSharesOuts() {
        return sharesOuts;
    }

    /**
     *
     * @param sharesOuts
     */
    public void setSharesOuts(double sharesOuts) {
        this.sharesOuts = sharesOuts;
    }

    /**
     *
     * @return
     */
    public double getCashCashEq() {
        return CashCashEq;
    }

    /**
     *
     * @param CashCashEq
     */
    public void setCashCashEq(double CashCashEq) {
        this.CashCashEq = CashCashEq;
    }

    /**
     *
     * @return
     */
    public double getPerpGrRate() {
        return perpGrRate;
    }

    /**
     *
     * @param perpGrRate
     */
    public void setPerpGrRate(double perpGrRate) {
        this.perpGrRate = perpGrRate;
    }

    /**
     *
     * @return
     */
    public List<Double> getDividends() {
        return Dividends;
    }

    /**
     *
     * @param Dividends
     */
    public void setDividends(List<Double> Dividends) {
        this.Dividends = Dividends;
    }

    /**
     *
     * @return
     */
    public double getDiscRate() {
        return discRate;
    }

    /**
     *
     * @param discRate
     */
    public void setDiscRate(double discRate) {
        this.discRate = discRate;
    }

    /**
     *
     * @return
     */
    public double getEps() {
        return eps;
    }

    /**
     *
     * @param eps
     */
    public void setEps(double eps) {
        this.eps = eps;
    }

    /**
     *
     * @return
     */
    public double getGrGrRate() {
        return GrGrRate;
    }

    /**
     *
     * @param GrGrRate
     */
    public void setGrGrRate(double GrGrRate) {
        this.GrGrRate = GrGrRate;
    }

    /**
     *
     * @return
     */
    public double getAaa() {
        return aaa;
    }

    /**
     *
     * @param aaa
     */
    public void setAaa(double aaa) {
        this.aaa = aaa;
    }

    /**
     *
     * @return
     */
    public double getNAVTotAssets() {
        return NAVTotAssets;
    }

    /**
     *
     * @param NAVTotAssets
     */
    public void setNAVTotAssets(double NAVTotAssets) {
        this.NAVTotAssets = NAVTotAssets;
    }

    /**
     *
     * @return
     */
    public double getNAVTotLiab() {
        return NAVTotLiab;
    }

    /**
     *
     * @param NAVTotLiab
     */
    public void setNAVTotLiab(double NAVTotLiab) {
        this.NAVTotLiab = NAVTotLiab;
    }

    /**
     *
     * @return
     */
    public double getNAVTotNumOfOutShare() {
        return NAVTotNumOfOutShare;
    }

    /**
     *
     * @param NAVTotNumOfOutShare
     */
    public void setNAVTotNumOfOutShare(double NAVTotNumOfOutShare) {
        this.NAVTotNumOfOutShare = NAVTotNumOfOutShare;
    }

    /**
     *
     * @return
     */
    public List<String> getValMethods() {
        return valMethods;
    }

    /**
     *
     * @param valMethods
     */
    public void setValMethods(List<String> valMethods) {
        this.valMethods = valMethods;
    }

    /**
     *
     * @return
     */
    public String getValues() {
        String d = ";";
        String s = ",";
        String a = "";
        String b = "";
        String c = "";
        int i = 0;
        for (String str : valMethods) {
            a = a + str;
            i++;
            if (i < valMethods.size()) {
                a = a + s;
            }
        }
        i = 0;
        for (var in : FCF) {
            b = b + in;
            i++;
            if (i < FCF.size()) {
                b = b + s;
            }
        }
        i = 0;
        for (var dbl : Dividends) {
            c = c + dbl;
            i++;
            if (i < Dividends.size()) {
                c = c + s;
            }
        }
        return id + d + a + d + name + d + ticker + d + exchange + d + note + d + actPrice + d + pillow + d + totalRevenue + d + CostOfRevenue + d + operatingExpense + d + otherIncomeExpense + d + netIncome + d + ebit + d + comStockDivPaid + d + taxes + d + interExpense + d + totalAssest + d + curAssets + d + receivable + d + inventory + d + totalLiabNetMinInt + d + curLiabilities + d + totalEqGrossMinInt + d + shareholdersEquity + d + capitalLeaseObl + d + tanBookVal + d + ordinaryShareNum + d + b + d + GrRate + d + DisRate + d + actFCF + d + totalDebt + d + sharesOuts + d + CashCashEq + d + perpGrRate + d + c + d + discRate + d + eps + d + GrGrRate + d + aaa + d + NAVTotAssets + d + NAVTotLiab + d + NAVTotNumOfOutShare;
    }

}
