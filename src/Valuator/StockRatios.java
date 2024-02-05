package Valuator;

/**
 *
 * @author ondre
 */
public class StockRatios {

    private final AdditionalCalculates addons;
    private final Controller controller;

    /**
     *
     * @param controller
     * @param addons
     */
    public StockRatios(Controller controller, AdditionalCalculates addons) {
        this.controller = controller;
        this.addons = addons;
    }

    /**
     *
     * @return
     */
    public double grossMargin() {
        return addons.calcGrossProfit() / controller.getTotalRevenue() * 100;
    }

    /**
     *
     * @return
     */
    public double operationMargin() {
        return addons.calcOperatingIncome() / controller.getTotalRevenue() * 100;
    }

    /**
     *
     * @return
     */
    public double earningsPerShare() {
        if (controller.getNetIncome() == 0 || controller.getOrdinarySharesNumber() == 0) {
            return 0;
        } else {
            return controller.getNetIncome() / controller.getOrdinarySharesNumber();
        }
    }

    /**
     *
     * @return
     */
    public double pricePerEarnings() {
        return controller.getActualPrice() / controller.getEarningsPerShare();
    }

    /**
     *
     * @return
     */
    public double currentLiquidity() {
        return controller.getCurrentAssets() / controller.getCurrentLiabilities();
    }

    /**
     *
     * @return
     */
    public double pricePerBook() {
        return controller.getActualPrice() / (controller.getTangiableBookValue() / controller.getOrdinarySharesNumber());
    }

    /**
     *
     * @return
     */
    public double debtPerEquity() {
        return controller.getTotalLiabilities() / controller.getShareHoldersEquity();
    }

    /**
     *
     * @return
     */
    public double payoutRatio() {
        return (controller.getCommonStockDividendPaid() / controller.getNetIncome()) * 100;
    }

    /**
     *
     * @return
     */
    public double roa() {
        return (controller.getEBIT() / controller.getTotalAssets()) * 100;
    }

    /**
     *
     * @return
     */
    public double roe() {
        return (controller.getEBIT() / controller.getTEGMI()) * 100;
    }

    /**
     *
     * @return
     */
    public double ros() {
        return (controller.getEBIT() / controller.getTotalRevenue()) * 100;
    }

    /**
     *
     * @return
     */
    public double rn() {
        return (controller.getEBIT() / addons.calcTotalExpenses()) * 100;
    }

    /**
     *
     * @return
     */
    public double indebtedness() {
        return ((controller.getTotalLiabilities() + controller.getCapitalLeaseObligations()) / controller.getTotalAssets()) * 100;
    }

    /**
     *
     * @return
     */
    public double recTime() {
        return (controller.getReceivable() / controller.getTotalRevenue()) / 360;
    }

    /**
     *
     * @return
     */
    public double liabTime() {
        return (controller.getTotalLiabilities() / controller.getTotalRevenue()) / 360;
    }

    /**
     *
     * @return
     */
    public double invTime() {
        return (controller.getInventory() / controller.getTotalRevenue()) / 360;
    }
}
