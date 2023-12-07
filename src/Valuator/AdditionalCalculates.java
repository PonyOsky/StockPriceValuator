package Valuator;

/**
 *
 * @author ondre
 */
public class AdditionalCalculates {
    private final Controller controller;
    
    public AdditionalCalculates(Controller controller){
        this.controller = controller;
    }
    /**
     *
     * @return
     */
    public double calcEbit(){
        return controller.getTaxes() + controller.getInterestExpense() + controller.getNetIncome();
    }
    /**
     *
     * @return
     */
    public double calcGrossProfit(){
        return controller.getTotalRevenue() - controller.getCostOfRevenue();
    }
    /**
     *
     * @return
     */
    public double calcOperatingIncome(){
        return calcGrossProfit() - controller.getOperatingExpense();
    }
    /**
     *
     * @return
     */
    public double calcTotalExpenses(){
        return controller.getCostOfRevenue() + controller.getOperatingExpense() + controller.getOtherIncomeExpense();
    }
}
