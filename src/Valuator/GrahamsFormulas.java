package Valuator;

/**
 *
 * @author ondre
 */
public class GrahamsFormulas {
    private final Controller controller;
    
    public GrahamsFormulas(Controller controller){
        this.controller = controller;
    }
    /**
     *
     * @return
     */
    public double grahamsSummary(){
        double grah = graham();
        double grahRev = grahamReversed();
        double diff1 = controller.getActualPrice()/grah;
        double diff2 = controller.getActualPrice()/grahRev;
        if(diff1 > 1 && diff2 > 1){
            if(diff1 > diff2){return grahRev;}else{return grah;}
        }else{if(diff1 < 1 && diff2 < 1){
            if(diff1 > diff2){return grah;}else{return grahRev;}
        }}
        if(diff1 > 1 && diff2 < 1){
            diff1 --;
            if(diff1 > diff2){return grahRev;}else{return grah;}
        }else{
            if(diff1 < 1 && diff2 > 1){
                diff2 --;
                if(diff1 > diff2){return grahRev;}else{return grah;}
            }else{
                if(diff1 == 1){return grah;}else{return grahRev;}
            }
        }
    }
    /**
     *
     * @return
     */
    public double grahamMoS(){
        return graham() - graham() * controller.getMarginOfSafety();
    }
    /**
     *
     * @return
     */
    public double grahamRevMoS(){
        return grahamReversed() - grahamReversed() * controller.getMarginOfSafety();
    }
    /**
     *
     * @return
     */
    public double graham(){
        if(controller.getEarningsPerShare() == 0){
            return 0;
        }else{
            if(controller.getGrowthRate() == 0){
                return 0;
            }else{
                if(controller.getAAACurrentYield() == 0){
                    return 0;
                }else{
                    return (controller.getEarningsPerShare() * ((2 * controller.getGrowthRate()) + 8.5) * 4.4) / controller.getAAACurrentYield();
                }
            }
        }
    }
    /**
     *
     * @return
     */
    public double grahamReversed(){
        if(controller.getEarningsPerShare() == 0 || controller.getGrowthRate() == 0 || controller.getAAACurrentYield() == 0) {
            return 0;
        }
        return (controller.getEarningsPerShare() * ((1 * controller.getGrowthRate()) + 7) * 4.4) / controller.getAAACurrentYield();
    }
}
