/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
