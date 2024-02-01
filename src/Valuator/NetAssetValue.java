/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Valuator;

/**
 *
 * @author ondre
 */
public class NetAssetValue {

    private double value;
    private double valuePillow;

    /**
     *
     * @param assets
     * @param liabilities
     * @param shares
     */
    public void valuation(double assets, double liabilities, double shares) {
        value = (assets - liabilities) / shares;
    }

    /**
     *
     * @param pillow
     */
    public void valuationMoS(double pillow) {
        valuePillow = value - (value * pillow);
    }

    /**
     *
     * @return
     */
    public double getValue() {
        return value;
    }

    public double getValuePillow() {
        return valuePillow;
    }

}
