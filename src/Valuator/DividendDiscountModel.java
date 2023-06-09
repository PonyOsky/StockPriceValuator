package Valuator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ondre
 */
public class DividendDiscountModel {
    private final CentralObject central;
    List<Double> YDiv;
    List<Double> GrowthDiv;
    
    public DividendDiscountModel(CentralObject central){
        this.central = central;
    }
    /**
     *
     */
    public void calcYDiv(){
        YDiv = new ArrayList<>();
        for(int i = 0; i < central.getDividends().size(); i++){
            YDiv.add(central.getDividends().get(i) * 4);
        }
    }

    /**
     *
     */
    public void calcGrowthDiv(){
        GrowthDiv = new ArrayList<>();
        GrowthDiv.add(0.0);
        for(int b = 1; b < YDiv.size(); b++){
            GrowthDiv.add((YDiv.get(b) - YDiv.get(b-1))/YDiv.get(b-1)*100);
        }
    }

    /**
     *
     * @return
     */
    public List<Double> getYDiv(){
        return YDiv;
    }

    /**
     *
     * @return
     */
    public List<Double> getGrowthDiv(){
        return GrowthDiv;
    }
    public double getDiscDDM(double aveGrow){
        if(aveGrow<=6.5){
            if(aveGrow<=5.5){
                if(aveGrow<=5.3){
                    if(aveGrow<=5.1){
                        if(aveGrow<=4.9){
                        return 8;
                        }else{
                        return 9;}
                    }else{
                    return 10;
                    }
                }else{
                return 11;
                }
            }else{
            return 12;
            }
        }else{
        return 13;
        }
    }
    /**
     *
     * @return
     */
    public double getAveGrowDDM(){
        double d = 0.0;
        for(int e = 0; e < GrowthDiv.size(); e++){
            d = d + GrowthDiv.get(e);
        }
        return d/4;
    }

    /**
     *
     * @return
     */
    public double getDDMPrice(){
        calcYDiv();
        calcGrowthDiv();
        return (YDiv.get(4) * (100 + getAveGrowDDM())) / (getDiscDDM(getAveGrowDDM()) - getAveGrowDDM());
    }
    /**
     *
     * @return
     */
    public double controlDDM(){
        double ans = getDDMPrice();
        double a = (ans - central.getActualPrice()) / central.getActualPrice();
        if(a >=-0.6){
            if(a <=0.6){
                return ans;
            }else{
            ans = 0;
            return ans;}
        }else{
            ans = 0;
            return ans;
        }
    }
    /**
     *
     * @return
     */
    public double ddmMoS(){
        double a = controlDDM();
        if(a == 0){
            return a;
        }else{
            return a - (a * central.getMarginOfSafety());
        }
    }
}
