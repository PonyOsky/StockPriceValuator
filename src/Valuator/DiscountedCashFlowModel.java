package Valuator;

import java.util.ArrayList;

/**
 *
 * @author ondre
 */
public class DiscountedCashFlowModel {

    private double value;
    private double valueMoS;
    private double terminalValue;
    private double aveGr;
    private ArrayList ffcf;
    private ArrayList dffcf;
    private double sodfcf;
    private double equity;

    public DiscountedCashFlowModel() {
        value = 0;
        valueMoS = 0;
        terminalValue = 0;
        aveGr = 0;
        ffcf = new ArrayList();
        dffcf = new ArrayList();
        sodfcf = 0;
        equity = 0;
    }

    /**
     *
     * @param fcf
     * @return
     */
    public ArrayList getFCFGR(ArrayList fcf) {
        ArrayList fcfGR = new ArrayList();
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
        aveGR(fcfGR);
        return fcfGR;
    }

    /**
     *
     * @param fcfGR
     */
    public void aveGR(ArrayList fcfGR) {
        double avgr = 0;
        for (int count = 1; count < fcfGR.size(); count++) {
            if (fcfGR.get(count) != null) {
                avgr += (double) fcfGR.get(count);
            }
        }
        aveGr = avgr / fcfGR.size() - 1;
    }

    /**
     *
     * @param actFCF
     * @param grRate
     * @param stateGrRate
     * @param disRate
     * @return
     */
    public ArrayList getFFCF(double actFCF, double grRate, double stateGrRate, double disRate) {
        ffcf.add(actFCF);
        double d = 1 + grRate;
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
        ffcf.add(12, termFCF(ffcf, stateGrRate, disRate));
        return ffcf;
    }

    /**
     *
     * @param disRate
     * @param ffcf
     * @return
     */
    public ArrayList getDFFCF(double disRate, ArrayList ffcf) {
        int h = 1;
        double i = 1 + disRate;
        for (int j = 0; j < ffcf.size(); j++) {
            dffcf.add((double) ffcf.get(j) / Math.pow(i, h));
            h++;
        }
        dffcf.add(12, termDCFC(disRate, terminalValue));
        return dffcf;
    }

    /**
     *
     * @param f
     * @param stateGrRate
     * @param disRate
     * @return
     */
    public double termFCF(ArrayList f, double stateGrRate, double disRate) {
        double term = (double) f.get(11) * (1 + stateGrRate) / (disRate - stateGrRate);
        terminalValue = term;
        return term;
    }

    /**
     *
     * @param disRate
     * @param termVal
     * @return
     */
    public double termDCFC(double disRate, double termVal) {
        double val = termVal / Math.pow((1 + disRate), 13);
        return val;
    }

    /**
     *
     * @param dffcf
     * @return
     */
    public double sumOfDFCF(ArrayList dffcf) {
        double sum = 0;
        for (int a = 0; a < dffcf.size(); a++) {
            if (a == 13) {
                break;
            }
            sum += (double) dffcf.get(a);
        }
        sodfcf = sum;
        return sum;
    }

    /**
     *
     * @param cash
     * @param tDebt
     * @param actFcf
     * @param stateGr
     * @param grRate
     * @param disRate
     * @return
     */
    public double equityDCF(double cash, double tDebt, double stateGr, double grRate, double disRate, double actFcf) {
        equity = sumOfDFCF(getDFFCF(disRate, getFFCF(actFcf, grRate, stateGr, disRate))) + cash - tDebt;
        return equity;
    }

    /**
     *
     * @param sharesOuts
     * @param cash
     * @param tDebt
     * @param stateGr
     * @param grRate
     * @param disRate
     * @param actFcf
     */
    public void price(double sharesOuts, double cash, double tDebt, double stateGr, double grRate, double disRate, double actFcf) {
        value = equityDCF(cash, tDebt, stateGr, grRate, disRate, actFcf) / sharesOuts;
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

    /**
     *
     * @return
     */
    public double getAveGr() {
        return aveGr;
    }

    /**
     *
     * @return
     */
    public ArrayList getFfcf() {
        return ffcf;
    }

    /**
     *
     * @return
     */
    public ArrayList getDffcf() {
        return dffcf;
    }

    /**
     *
     * @return
     */
    public double getSodfcf() {
        return sodfcf;
    }

    /**
     *
     * @return
     */
    public double getEquity() {
        return equity;
    }

}
