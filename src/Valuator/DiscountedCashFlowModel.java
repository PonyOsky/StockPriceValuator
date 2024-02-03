package Valuator;

import java.util.ArrayList;

/**
 *
 * @author ondre
 */
public class DiscountedCashFlowModel {

    private double value;
    private double valueMoS;
    ArrayList fcfGR;
    ArrayList ffcf;
    ArrayList dffcf;

    public DiscountedCashFlowModel() {
        value = 0;
        valueMoS = 0;
        fcfGR = new ArrayList();
        ffcf = new ArrayList();
        dffcf = new ArrayList();
    }

    /**
     *
     * @param fcf
     * @return
     */
    public ArrayList getFCFGR(ArrayList fcf) {
        fcfGR.add(0.0);
        if (fcf.get(0) != null) {
            for (int a = 1; a < fcf.size(); a++) {
                double actual = (double) fcf.get(a);
                double before = (double) fcf.get(a - 1);
                if (actual != 0.0) {
                    if (before == 0.0) {
                        fcfGR.add(0.0);
                    } else {
                        double b = ((actual - before) / before) * 100;
                        if (actual > 0.0 && before > 0.0) {
                            fcfGR.add(b);
                        } else {
                            if (actual < 0.0 && before > 0.0) {
                                fcfGR.add(b);
                            } else {
                                fcfGR.add(-b);
                            }
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
    public double aveGR() {
        double avgr = 0;
        int control = 0;
        for (int count = 1; count < fcfGR.size(); count++) {
            if (fcfGR.get(count) != null) {
                avgr += (double) fcfGR.get(count);
                control++;
            }
        }
        return avgr / control;
    }

    /**
     *
     * @param actFCF
     * @param grRate
     * @return
     */
    public ArrayList getFFCF(double actFCF, double grRate) {
        ffcf.add(actFCF);
        double d = 1 + (grRate / 100);
        double y = (double) ffcf.get(0);
        double e = y * d;
        if (y < 0) {
            ffcf.add(y + (y - (double) ffcf.get(1)));
        } else {
            ffcf.add(e);
        }
        for (int c = 2; c < 12; c++) {
            double x = (double) ffcf.get(c - 1);
            double z = x * d;
            if (x < 0) {
                ffcf.add(x + (x - (double) ffcf.get(c)));
            } else {
                ffcf.add(z);
            }
        }
        return ffcf;
    }

    /**
     *
     * @param disRate
     * @return
     */
    public ArrayList getDFFCF(double disRate) {
        int h = 1;
        double i = 1 + disRate;
        for (int j = 0; j < ffcf.size(); j++) {
            dffcf.add((double) ffcf.get(j) / Math.pow(i, h));
            h++;
        }
        return dffcf;
    }

    /**
     *
     * @param stateGrRate
     * @param disRate
     * @return
     */
    public double termFCF(double stateGrRate, double disRate) {
        double term = (double) ffcf.get(11) * (1 + (stateGrRate / 100)) / (disRate - (stateGrRate / 100));
        ffcf.add(12, term);
        return term;
    }

    /**
     *
     * @param disRate
     * @param cash
     * @param tDebt
     * @return
     */
    public double termDCFC(double disRate, double cash, double tDebt) {
        double val = termFCF(cash, tDebt) / Math.pow((1 + disRate), 13);
        dffcf.add(val);
        return val;
    }

    /**
     *
     * @return
     */
    public double sumOfDFCF() {
        double sum = 0;
        for (int a = 0; a < dffcf.size(); a++) {
            sum += (double) dffcf.get(a);
        }
        return sum;
    }

    /**
     *
     * @param cash
     * @param tDebt
     * @return
     */
    public double equityDCF(double cash, double tDebt) {
        return sumOfDFCF() + cash - tDebt;
    }

    /**
     *
     * @param sharesOuts
     * @param cash
     * @param tDebt
     */
    public void price(double sharesOuts, double cash, double tDebt) {
        value = equityDCF(cash, tDebt) / sharesOuts;
    }

    /**
     *
     * @param pillow
     */
    public void priceMoS(double pillow) {
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
