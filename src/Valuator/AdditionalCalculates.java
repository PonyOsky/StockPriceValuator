package Valuator;

/**
 *
 * @author ondre
 */
public class AdditionalCalculates {
    private final CentralObject central;
    
    public AdditionalCalculates(CentralObject central){
        this.central = central;
    }
    /**
     *
     * @return
     */
    public double calcEbit(){
        return central.getTaxes() + central.getInterestExpense() + central.getNetIncome();
    }
    /**
     *
     * @return
     */
    public double calcGrossProfit(){
        return central.getTotalRevenue() - central.getCostOfRevenue();
    }
    /**
     *
     * @return
     */
    public double calcOperatingIncome(){
        return calcGrossProfit() - central.getOperatingExpense();
    }
    /**
     *
     * @return
     */
    public double calcTotalExpenses(){
        return central.getCostOfRevenue() + central.getOperatingExpense() + central.getOtherIncomeExpense();
    }
}
