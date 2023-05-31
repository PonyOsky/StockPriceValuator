/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Valuator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ondre
 */
public class DiscountedCashFlowModel {
    private CentralObject central;
    List<Double> fcfGR;
    List<Double> ffcf;
    List<Double> dffcf;
    
    public DiscountedCashFlowModel(CentralObject central){
        this.central = central;
    }
    /**
     *
     * @return
     */
    public List<Double> getFCFGR(){
    fcfGR = new ArrayList<>();
    fcfGR.add(0.0);
    for(int a = 1; a < central.getFreeCashFlow().size(); a++){
        if(central.getFreeCashFlow().get(a) == null || central.getFreeCashFlow().get(a) == 0){}else{
        if(central.getFreeCashFlow().get(a-1) == 0 || central.getFreeCashFlow().get(a-1) == null){
            fcfGR.add(0.0);
            }else{
                double b = ((central.getFreeCashFlow().get(a) - central.getFreeCashFlow().get(a-1))/central.getFreeCashFlow().get(a-1)) * 100; 
                if(central.getFreeCashFlow().get(a) > 0 && central.getFreeCashFlow().get(a-1) > 0){
                    fcfGR.add(b);
                }else{
                    if(central.getFreeCashFlow().get(a) < 0 && central.getFreeCashFlow().get(a-1) > 0){
                        fcfGR.add(b);
                    }else{
                        fcfGR.add(b * -1);
                    }
                }
            }
        }
    }
    return fcfGR;
    }

    /**
     *
     * @return
     */
    public double aveGR(){
        double avgr = 0;
        int control = 0;
        for(int count = 1; count < fcfGR.size(); count++){
            if(fcfGR.get(count) == null){}else{
            avgr = avgr + fcfGR.get(count);
            control++;
            }
        }
        avgr = avgr/control;
        return avgr;
    }

    /**
     *
     * @return
     */
    public List<Double> getFFCF(){
        ffcf.add(central.getActualFreeCashFlow());
        double d = 1 + (central.getGrowthRate()/100);
        double y = ffcf.get(0);
        double e = y * d;
        if(y<0){
            ffcf.add(y + (y - ffcf.get(1)));
        }else{
            ffcf.add(e);
        }
        for(int c = 2; c < 12; c++){
            double x = ffcf.get(c-1);
            double z = x * d;
            if(x<0){
                ffcf.add(x + (x - ffcf.get(c)));
            }else{
                ffcf.add(z);
            }
        }
        
        return ffcf;
    }

    /**
     *
     * @return
     */
    public List<Double> getDFFCF(){
        int h = 1;
        double i = 1 + central.getDiscountRate();
        for(int j = 0; j < ffcf.size(); j++){
            dffcf.add(ffcf.get(j) / Math.pow(i, h));
            h++;
        }
        return dffcf;
    }

    /**
     *
     * @return
     */
    public double termFCF(){
        double term = ffcf.get(11) * (1 + (central.getStateGrowthRate()/100)) / (central.getDiscountRate() - (central.getStateGrowthRate()/100));
        ffcf.add(12, term);
        return term;
    }

    /**
     *
     * @return
     */
    public double termDCFC(){
        double val = termFCF()/Math.pow((1 + central.getDiscountRate()), 13);
        dffcf.add(val);
        return val;
    }

    /**
     *
     * @return
     */
    public double sumOfDFCF(){
        double sum = 0;
        for(int a = 0; a < dffcf.size(); a++){
        sum +=dffcf.get(a);
        }
        return sum;
    }

    /**
     *
     * @return
     */
    public double equityDCF(){
        return sumOfDFCF() + central.getCash() - central.getTotalDebt();
    }

    /**
     *
     * @return
     */
    public double price(){
        dffcf = new ArrayList<>();
        ffcf = new ArrayList<>();
        return equityDCF()/central.getSharesOutstanding();
    }

    /**
     *
     * @return
     */
    public double priceMoS(){
        return price() - (price() * central.getMarginOfSafety());
    }
}
