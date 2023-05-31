/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Valuator;

/**
 *
 * @author ondre
 */
public class StockRatios {
    private final AdditionalCalculates addons;
    private final CentralObject central;
    
    
    public StockRatios(CentralObject central, AdditionalCalculates addons){
        this.central = central;
        this.addons = addons;
    }
    /**
     *
     * @return
     */
    public double grossMargin(){
        return addons.calcGrossProfit() / central.getTotalRevenue() * 100;
    }

    /**
     *
     * @return
     */
    public double operationMargin(){
        return addons.calcOperatingIncome() / central.getTotalRevenue() * 100;
    }

    /**
     *
     * @return
     */
    public double earningsPerShare(){
        if(central.getNetIncome() == 0 || central.getOrdinarySharesNumber() == 0){
            return 0;
        }else{
            return central.getNetIncome() / central.getOrdinarySharesNumber();
        }
    }

    /**
     *
     * @return
     */
    public double pricePerEarnings(){
        return central.getActualPrice() / central.getEarningsPerShare();
    }

    /**
     *
     * @return
     */
    public double currentLiquidity(){
        return central.getCurrentAssets() / central.getCurrentLiabilities();
    }

    /**
     *
     * @return
     */
    public double pricePerBook(){
        return central.getActualPrice() / (central.getTangiableBookValue() / central.getOrdinarySharesNumber());
    }

    /**
     *
     * @return
     */
    public double debtPerEquity(){
        return central.getTotalLiabilities() / central.getShareHoldersEquity();
    }

    /**
     *
     * @return
     */
    public double payoutRatio(){
        return (central.getCommonStockDividendPaid() / central.getNetIncome()) * 100;
    }

    /**
     *
     * @return
     */
    public double roa(){
        return (central.getEBIT() / central.getTotalAssets()) * 100;
    }

    /**
     *
     * @return
     */
    public double roe(){
        return (central.getEBIT() / central.getTEGMI()) * 100;
    }

    /**
     *
     * @return
     */
    public double ros(){
        return (central.getEBIT() / central.getTotalRevenue()) * 100;
    }

    /**
     *
     * @return
     */
    public double rn(){
        return (central.getEBIT() / addons.calcTotalExpenses()) * 100;
    }

    /**
     *
     * @return
     */
    public double indebtedness(){
        return ((central.getTotalLiabilities() + central.getCapitalLeaseObligations()) / central.getTotalAssets()) * 100;
    }

    /**
     *
     * @return
     */
    public double recTime(){
        return (central.getReceivable() / central.getTotalRevenue()) / 360;
    }

    /**
     *
     * @return
     */
    public double liabTime(){
        return (central.getTotalLiabilities() / central.getTotalRevenue()) / 360;
    }

    /**
     *
     * @return
     */
    public double invTime(){
        return (central.getInventory() / central.getTotalRevenue()) / 360;
    }
}
