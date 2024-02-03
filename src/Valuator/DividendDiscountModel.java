package Valuator;

import java.util.ArrayList;

/**
 *
 * @author ondre
 */
public class DividendDiscountModel {

    private double value;
    private double valueMoS;
    ArrayList YDiv;
    ArrayList GrowthDiv;

    public DividendDiscountModel() {
        value = 0;
        valueMoS = 0;
        YDiv = new ArrayList();
        GrowthDiv = new ArrayList();
    }

    /**
     *
     * @param divs
     */
    public void calcYDiv(ArrayList divs) {
        if (divs.get(0) != null) {
            for (int i = 0; i < divs.size(); i++) {
                YDiv.add((double) divs.get(i) * 4);
            }
        }
    }

    public void calcGrowthDiv() {
        GrowthDiv.add(0.0);
        for (int b = 1; b < YDiv.size(); b++) {
            GrowthDiv.add(((double) YDiv.get(b) - (double) YDiv.get(b - 1)) / (double) YDiv.get(b - 1) * 100);
        }
    }

    /**
     *
     * @return
     */
    public ArrayList getYDiv() {
        return YDiv;
    }

    /**
     *
     * @return
     */
    public ArrayList getGrowthDiv() {
        return GrowthDiv;
    }

    /**
     *
     * @param aveGrow
     * @return
     */
    public double getDiscDDM(final double aveGrow) {
        if (aveGrow > 6.5) {
            return 13;
        }
        if (aveGrow > 5.5) {
            return 12;
        }
        if (aveGrow > 5.3) {
            return 11;
        }
        if (aveGrow > 5.1) {
            return 10;
        }
        if (aveGrow > 4.9) {
            return 9;
        }
        return 8;
    }

    /**
     *
     * @return
     */
    public double getAveGrowDDM() {
        double d = 0.0;
        for (int e = 0; e < GrowthDiv.size(); e++) {
            d = d + (double) GrowthDiv.get(e);
        }
        return d / 4;
    }

    /**
     *
     * @param divs
     */
    public void getDDMPrice(ArrayList divs) {
        calcYDiv(divs);
        calcGrowthDiv();
        if (divs.size() > 2) {
            value = ((double) YDiv.get(4) * (100 + getAveGrowDDM())) / (getDiscDDM(getAveGrowDDM()) - getAveGrowDDM());
        }
    }

    /**
     *
     * @param pillow
     */
    public void ddmMoS(double pillow) {
        valueMoS = value - (value * pillow);
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
}
