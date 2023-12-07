package Valuator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ondre
 */
public class DividendDiscountModel {
    private final Controller controller;
    List<Double> YDiv;
    List<Double> GrowthDiv;
    
    public DividendDiscountModel(Controller controller){
        this.controller = controller;
    }
    /**
     *
     */
    public void calcYDiv(){
        YDiv = new ArrayList<>();
        for(int i = 0; i < controller.getDividends().size(); i++){
            YDiv.add(controller.getDividends().get(i) * 4);
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
    public double getDiscDDM(final double aveGrow){
        if(aveGrow > 6.5) return 13;
        if(aveGrow > 5.5) return 12;
        if(aveGrow > 5.3) return 11;
        if(aveGrow > 5.1) return 10;
        if(aveGrow > 4.9) return 9;
        return 8;
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
        double a = (ans - controller.getActualPrice()) / controller.getActualPrice();
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
            return a - (a * controller.getMarginOfSafety());
        }
    }
}
