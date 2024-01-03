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
    
    private final Controller controller;
    private double value;
    
    /**
     *
     * @param controller
     */
    public NetAssetValue(Controller controller){
        this.controller = controller;
    }
    
    /**
     *
     * @param assets
     * @param liabilities
     * @param shares
     * @return
     */
    public double valuation(double assets, double liabilities, double shares){
        value = (controller.getTotalAssets() - controller.getTotalLiabilities())/controller.getSharesOutstanding();
        return value;
    }
    
    /**
     *
     * @param pillow
     * @return
     */
    public double valuationMoS(double pillow){
        return value - (value * pillow);
    }
    
    /**
     *
     * @return
     */
    public double getValue(){
        return value;
    }
}
